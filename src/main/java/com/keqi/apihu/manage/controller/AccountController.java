package com.keqi.apihu.manage.controller;

import com.keqi.apihu.core.common.AjaxEntity;
import com.keqi.apihu.core.common.AjaxEntityBuilder;
import com.keqi.apihu.manage.domain.param.CreateAccountParam;
import com.keqi.apihu.manage.domain.param.QueryAccountParam;
import com.keqi.apihu.manage.domain.param.UpdateAccountParam;
import com.keqi.apihu.manage.service.impl.AccountService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;

/**
 * 用户管理
 */
@RestController
@RequestMapping("/sys/account")
@AllArgsConstructor
@Validated
@Slf4j
public class AccountController {

    private final AccountService accountService;

    /**
     * 创建用户
     * @param createAccountParam createAccountParam
     * @return r
     */
    @PostMapping("/create")
    public AjaxEntity create(@Validated @RequestBody CreateAccountParam createAccountParam) {
        this.accountService.createAccount(createAccountParam);
        return AjaxEntityBuilder.success();
    }

    /**
     * 删除用户
     * @param id id
     * @return r
     */
    @PostMapping("/delete")
    public AjaxEntity delete(@RequestParam("id") @NotNull Long id) {
        this.accountService.deleteByPrimaryKey(id);
        return AjaxEntityBuilder.success();
    }

    /**
     * 修改用户信息
     * @param updateAccountParam updateAccountParam
     * @return r
     */
    @PostMapping("/update")
    public AjaxEntity update(@Validated @RequestBody UpdateAccountParam updateAccountParam) {
        this.accountService.updateByPrimaryKey(updateAccountParam);
        return AjaxEntityBuilder.success();
    }

    /**
     * 查询用户分页列表
     * @param queryAccountParam queryAccountParam
     * @return r
     */
    @PostMapping("/page")
    public AjaxEntity page(@Validated @RequestBody QueryAccountParam queryAccountParam) {
        // 用户名或者姓名使用 searchValue 字段接收
        return AjaxEntityBuilder.successList(this.accountService.pageAccount(queryAccountParam));
    }

    /**
     * 重置密码
     * @param id id
     * @return r
     */
    @PostMapping("/resetPassword")
    public AjaxEntity resetPassword(@NotNull Long id) {
        this.accountService.resetPassword(id);
        return AjaxEntityBuilder.success();
    }

}
