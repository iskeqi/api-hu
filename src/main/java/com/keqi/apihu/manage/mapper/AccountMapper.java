package com.keqi.apihu.manage.mapper;

import com.keqi.apihu.manage.domain.db.AccountDO;
import com.keqi.apihu.manage.domain.param.QueryAccountParam;
import com.keqi.apihu.manage.domain.vo.PageAccountVO;

import java.util.List;

public interface AccountMapper {

    /**
     * 根据主键删除用户记录
     * @param id id
     * @return r
     */
    int deleteByPrimaryKey(Long id);

    /**
     * 新增用户
     * @param record record
     * @return r
     */
    int insert(AccountDO record);

    int insertSelective(AccountDO record);

    /**
     * 根据用户ID查询用户信息
     * @param id
     * @return
     */
    AccountDO selectByPrimaryKey(Long id);

    /**
     * 根据主键修改用户信息
     * @param record record
     * @return r
     */
    int updateByPrimaryKey(AccountDO record);

    /**
     * 判断用户名是否存在
     * @param account account
     * @return 返回值大于零，即存在该用户名
     */
    int accountExist(String account);

    /**
     * 分页列表查询记录总数
     * @param queryAccountParam queryAccountParam
     * @return r
     */
    int countPageAccount(QueryAccountParam queryAccountParam);

    /**
     * 查询用户分页列表
     * @param queryAccountParam queryAccountParam
     * @return r
     */
    List<PageAccountVO> pageAccount(QueryAccountParam queryAccountParam);

    /**
     * 根据用户ID修改密码
     * @param accountDO accountDO
     */
    void updatePasswordByPrimaryKey(AccountDO accountDO);

    /**
     * 根据用户账号查找用户信息
     * @param account account
     * @return
     */
    AccountDO findOneByAccount(String account);
}