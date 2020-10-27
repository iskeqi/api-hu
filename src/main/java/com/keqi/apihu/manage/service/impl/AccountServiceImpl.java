package com.keqi.apihu.manage.service.impl;

import com.keqi.apihu.core.common.CommonConstant;
import com.keqi.apihu.core.common.PageVO;
import com.keqi.apihu.core.util.CommonUtil;
import com.keqi.apihu.manage.domain.param.AccountListParam;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.keqi.apihu.manage.mapper.AccountMapper;
import com.keqi.apihu.manage.domain.AccountDO;
import com.keqi.apihu.manage.service.AccountService;

import java.util.ArrayList;
import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    @Resource
    private AccountMapper accountMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return accountMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(AccountDO record) {
        return accountMapper.insert(record);
    }

    @Override
    public int insertSelective(AccountDO record) {
        return accountMapper.insertSelective(record);
    }

    @Override
    public AccountDO selectByPrimaryKey(Long id) {
        return accountMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(AccountDO record) {
        return accountMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(AccountDO record) {
        return accountMapper.updateByPrimaryKey(record);
    }

    /**
     * 创建用户
     *
     * @param accountDO accountDO
     */
    @Override
    public void createAccount(AccountDO accountDO) {
        String password = CommonUtil.encryptedPassword(accountDO.getAccount(), CommonConstant.DEFAULT_PASSWORD);
        accountDO.setPassword(password);
        this.accountMapper.insert(accountDO);
    }

    /**
     * 根据用户id删除用户
     *
     * @param id id
     */
    @Override
    public void deleteAccountById(Long id) {
        this.accountMapper.deleteByPrimaryKey(id);
    }

    /**
     * 批量删除用户
     *
     * @param ids ids
     */
    @Override
    public void deleteAccountByIds(Long[] ids) {
        this.accountMapper.batchDelete(ids);
    }

    /**
     * 根据用id修改用户信息
     *
     * @param accountDO accountDO
     */
    @Override
    public void updateAccountById(AccountDO accountDO) {
        this.accountMapper.updateByPrimaryKeySelective(accountDO);
    }

    /**
     * 查询用户列表
     *
     * @param accountListParam accountListParam
     * @return r
     */
    @Override
    public PageVO listAccount(AccountListParam accountListParam) {

        long total = this.accountMapper.count(accountListParam);
        List<AccountDO> accountDOList = new ArrayList<>();
        if (total > 0) {
            accountDOList = this.accountMapper.listAccount(accountListParam);
        }

        return new PageVO(total, accountDOList);
    }

}
