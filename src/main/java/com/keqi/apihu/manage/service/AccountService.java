package com.keqi.apihu.manage.service;

import com.keqi.apihu.core.common.PageVO;
import com.keqi.apihu.manage.domain.AccountDO;
import com.keqi.apihu.manage.domain.param.AccountListParam;

public interface AccountService {


    int deleteByPrimaryKey(Long id);

    int insert(AccountDO record);

    int insertSelective(AccountDO record);

    AccountDO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(AccountDO record);

    int updateByPrimaryKey(AccountDO record);

    /**
     * 创建用户
     *
     * @param accountDO accountDO
     */
    void createAccount(AccountDO accountDO);

    /**
     * 根据用户id删除用户
     * @param id id
     */
    void deleteAccountById(Long id);

    /**
     * 批量删除用户
     * @param ids ids
     */
    void deleteAccountByIds(Long[] ids);

    /**
     * 根据用id修改用户信息
     * @param accountDO accountDO
     */
    void updateAccountById(AccountDO accountDO);

    /**
     * 查询用户列表
     * @param accountListParam accountListParam
     * @return r
     */
    PageVO listAccount(AccountListParam accountListParam);
}
