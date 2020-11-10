package com.keqi.apihu.manage.service;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.date.DateUtil;
import com.keqi.apihu.core.common.*;
import com.keqi.apihu.core.exception.BusinessException;
import com.keqi.apihu.core.util.CommonUtil;
import com.keqi.apihu.core.util.JWTUtil;
import com.keqi.apihu.manage.domain.db.AccountDO;
import com.keqi.apihu.manage.domain.param.CreateAccountParam;
import com.keqi.apihu.manage.domain.param.LoginParam;
import com.keqi.apihu.manage.domain.param.QueryAccountParam;
import com.keqi.apihu.manage.domain.param.UpdateAccountParam;
import com.keqi.apihu.manage.domain.vo.LoginVO;
import com.keqi.apihu.manage.domain.vo.PageAccountVO;
import com.keqi.apihu.manage.mapper.AccountMapper;
import com.keqi.apihu.manage.service.impl.AccountService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Objects;

@Service
@AllArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountMapper accountMapper;

    /**
     * 根据主键删除用户
     * @param id id
     */
    @Override
    @Transactional
    public void deleteByPrimaryKey(Long id) {
        // 删除用户表的用户记录
        this.accountMapper.deleteByPrimaryKey(id);
        // 删除用户项目关联表的关联记录 todo
    }

    /**
     * 根据主键修改用户信息
     * @param updateAccountParam updateAccountParam
     */
    @Override
    @Transactional
    public void updateByPrimaryKey(UpdateAccountParam updateAccountParam) {
        AccountDO accountDO = new AccountDO();
        BeanUtil.copyProperties(updateAccountParam, accountDO);
        this.accountMapper.updateByPrimaryKey(accountDO);
    }

    /**
     * 创建用户
     *
     * @param createAccountParam createAccountParam
     */
    @Override
    @Transactional
    public void createAccount(CreateAccountParam createAccountParam) {
        // 校验账号是否存在
        int count = this.accountMapper.accountExist(createAccountParam.getAccount());
        if (count > 0) {
            throw new BusinessException("该用户名已存在");
        }

        AccountDO accountDO = new AccountDO();
        BeanUtil.copyProperties(createAccountParam, accountDO);
        accountDO.setPassword(CommonUtil.encryptedPassword(accountDO.getAccount(), CommonConstant.DEFAULT_PASSWORD));

        this.accountMapper.insert(accountDO);
    }

    /**
     * 查询用户分页列表
     *
     * @param queryAccountParam queryAccountParam
     * @return r
     */
    @Override
    public AjaxPageEntity<PageAccountVO> pageAccount(QueryAccountParam queryAccountParam) {
        int total = this.accountMapper.countPageAccount(queryAccountParam);

        AjaxPageEntity<PageAccountVO> ajaxPageEntity = new AjaxPageEntity<>();

        if (total > 0) {
            List<PageAccountVO> pageAccountVOList = this.accountMapper.pageAccount(queryAccountParam);
            ajaxPageEntity.setTotal(total);
            ajaxPageEntity.setList(pageAccountVOList);
        }

        return ajaxPageEntity;
    }

    /**
     * 重置密码
     *
     * @param id id
     */
    @Override
    @Transactional
    public void resetPassword(Long id) {
        // 验证当前操作用户是否是超级管理员，其他用户无法操作此接口
        LoginUserBO loginUserBO = Auth.getLoginUserBO();
        if (Objects.isNull(loginUserBO)) {
            throw new BusinessException("未登录用户");
        }
        if (!UserTypeEnum.SUPER_ADMIN.equals(loginUserBO.getUserType())) {
            // 如果当前登录用户不是超级管理员，则无此权限
            throw new BusinessException("无重置密码权限");
        }
        // 验证用户是否存在
        AccountDO temp = this.accountMapper.selectByPrimaryKey(id);
        if (temp == null) {
            throw new BusinessException("当前用户不存在");
        }
        // 修改用户密码
        AccountDO accountDO = new AccountDO();
        accountDO.setId(id);
        accountDO.setPassword(CommonUtil.encryptedPassword(temp.getAccount(), CommonConstant.DEFAULT_PASSWORD));
        this.accountMapper.updatePasswordByPrimaryKey(accountDO);
    }

    /**
     * 用户修改密码
     *
     * @param oldPassword oldPassword
     * @param newPassword newPassword
     */
    @Override
    @Transactional
    public void updatePassword(String oldPassword, String newPassword) {
        // 验证密码是否相等
        Long loginAccountId = Auth.getLoginAccountId();
        AccountDO accountDO = this.accountMapper.selectByPrimaryKey(loginAccountId);
        String oldEncryptionPassword = CommonUtil.encryptedPassword(accountDO.getAccount(), oldPassword);
        if (!Objects.equals(oldEncryptionPassword, accountDO.getPassword())) {
            throw new BusinessException("密码不正确");
        }
        // 修改密码
        String newEncryptionPassword = CommonUtil.encryptedPassword(accountDO.getAccount(), newPassword);
        AccountDO temp = new AccountDO();
        temp.setPassword(newEncryptionPassword);
        temp.setId(loginAccountId);
        this.accountMapper.updatePasswordByPrimaryKey(temp);
    }

    /**
     * 登录
     *
     * @param loginParam loginParam
     */
    @Override
    public LoginVO login(LoginParam loginParam) {
        AccountDO accountDO = this.accountMapper.findOneByAccount(loginParam.getAccount());
        String password = CommonUtil.encryptedPassword(loginParam.getAccount(), loginParam.getPassword());

        if (Objects.isNull(accountDO) || !Objects.equals(password, accountDO.getPassword())) {
            throw new BusinessException("用户名或密码错误");
        }

        // 生成 JWT 字符串
        LoginUserBO loginUserBO = new LoginUserBO();
        BeanUtil.copyProperties(accountDO, loginUserBO);
        loginUserBO.setUserType(CommonConstant.SUPER_ADMIN.equals(loginParam.getAccount()) ?
                UserTypeEnum.SUPER_ADMIN : UserTypeEnum.COMMON_USER);
        // 设置过期时间为第二天的凌晨 2 点钟
        LocalDateTime expirationDate = LocalDateTime.of(LocalDate.now().plusDays(1), LocalTime.of(2, 0, 0));
        String accessToken = JWTUtil.generateToken(BeanUtil.beanToMap(loginUserBO), DateUtil.date(expirationDate));

        return LoginVO.builder()
                .accessToken(accessToken)
                .userType(loginUserBO.getUserType())
                .build();
    }

}
