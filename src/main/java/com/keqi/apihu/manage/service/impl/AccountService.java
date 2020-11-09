package com.keqi.apihu.manage.service.impl;

import com.keqi.apihu.core.common.PageVO;
import com.keqi.apihu.manage.domain.param.CreateAccountParam;
import com.keqi.apihu.manage.domain.param.LoginParam;
import com.keqi.apihu.manage.domain.param.QueryAccountParam;
import com.keqi.apihu.manage.domain.param.UpdateAccountParam;
import com.keqi.apihu.manage.domain.vo.LoginVO;

public interface AccountService {

    /**
     * 根据主键删除用户
     * @param id id
     */
    void deleteByPrimaryKey(Long id);

    /**
     * 根据主键修改用户信息
     * @param updateAccountParam updateAccountParam
     */
    void updateByPrimaryKey(UpdateAccountParam updateAccountParam);

    /**
     * 创建用户
     * @param createAccountParam createAccountParam
     */
    void createAccount(CreateAccountParam createAccountParam);

    /**
     * 查询用户分页列表
     * @param queryAccountParam queryAccountParam
     * @return r
     */
    PageVO pageAccount(QueryAccountParam queryAccountParam);

    /**
     * 重置密码
     * @param id id
     */
    void resetPassword(Long id);

    /**
     * 用户修改密码
     * @param oldPassword oldPassword
     * @param newPassword newPassword
     */
    void updatePassword(String oldPassword, String newPassword);

    /**
     * 登录
     * @param loginParam loginParam
     */
    LoginVO login(LoginParam loginParam);
}
