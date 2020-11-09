package com.keqi.apihu.manage.controller;

import com.keqi.apihu.core.common.AjaxEntity;
import com.keqi.apihu.core.common.AjaxEntityBuilder;
import com.keqi.apihu.manage.domain.param.LoginParam;
import com.keqi.apihu.manage.service.impl.AccountService;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sys/auth")
@AllArgsConstructor
public class AuthController {

    private final AccountService accountService;

    /**
     * 登录
     * @param loginParam loginParam
     * @return r
     */
    @PostMapping("/login")
    public AjaxEntity login(@Validated @RequestBody LoginParam loginParam) {
        return AjaxEntityBuilder.success(this.accountService.login(loginParam));
    }

    /**
     * 用户自己修改密码
     * @param oldPassword oldPassword
     * @param newPassword newPassword
     * @return r
     */
    @PostMapping("/updatePassword")
    public AjaxEntity updatePassword(String oldPassword, String newPassword) {
        this.accountService.updatePassword(oldPassword, newPassword);
        return AjaxEntityBuilder.success();
    }
}
