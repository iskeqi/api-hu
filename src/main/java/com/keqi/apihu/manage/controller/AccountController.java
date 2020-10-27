package com.keqi.apihu.manage.controller;

import com.keqi.apihu.core.common.AjaxEntity;
import com.keqi.apihu.core.common.AjaxEntityBuilder;
import com.keqi.apihu.manage.domain.AccountDO;
import com.keqi.apihu.manage.domain.param.AccountListParam;
import com.keqi.apihu.manage.service.AccountService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户管理
 */
@RestController
public class AccountController {

    private final AccountService accountService;


    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping("/account/create")
    public AjaxEntity create(@RequestBody AccountDO accountDO) {
        accountService.createAccount(accountDO);
        return AjaxEntityBuilder.success();
    }

    @PostMapping("/account/delete")
    public AjaxEntity delete(Long id) {
        accountService.deleteAccountById(id);
        return AjaxEntityBuilder.success();
    }

    @PostMapping("/account/bathDelete")
    public AjaxEntity delete(Long[] ids) {
        accountService.deleteAccountByIds(ids);
        return AjaxEntityBuilder.success();
    }

    @PostMapping("/account/update")
    public AjaxEntity update(@RequestBody AccountDO accountDO) {
        accountService.updateAccountById(accountDO);
        return AjaxEntityBuilder.success();
    }

    @PostMapping("/account/list")
    public AjaxEntity list(@RequestBody AccountListParam accountListParam) {
        return AjaxEntityBuilder.successList(accountService.listAccount(accountListParam));
    }
}
