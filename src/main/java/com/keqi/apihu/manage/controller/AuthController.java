package com.keqi.apihu.manage.controller;

import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.github.xiaoymin.knife4j.annotations.ApiSupport;
import com.keqi.apihu.core.common.AjaxEntity;
import com.keqi.apihu.core.common.AjaxEntityBuilder;
import com.keqi.apihu.manage.domain.param.LoginParam;
import com.keqi.apihu.manage.service.AccountService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@Api(tags = "1. 登录相关接口管理")
@ApiSupport(author = "keqi", order = 1)
@AllArgsConstructor
@RestController
@RequestMapping("/sys/auth")
public class AuthController {

    private final AccountService accountService;

    /**
     * 登录
     *
     * @param loginParam loginParam
     * @return r
     */
    @ApiOperation(value = "1.1 登录")
    @ApiOperationSupport(order = 1)
    @PostMapping("/login")
    public AjaxEntity login(@Validated @RequestBody LoginParam loginParam) {
        return AjaxEntityBuilder.success(this.accountService.login(loginParam));
    }

    /**
     * 用户自己修改密码
     *
     * @param oldPassword oldPassword
     * @param newPassword newPassword
     * @return r
     */
    @ApiOperation(value = "1.2 用户修改密码")
    @ApiOperationSupport(order = 2)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "oldPassword", value = "旧密码", example = "123456", required = true),
            @ApiImplicitParam(name = "newPassword", value = "新密码", example = "123456", required = true)
    })
    @PostMapping("/updatePassword")
    public AjaxEntity updatePassword(@RequestParam String oldPassword, @RequestParam String newPassword) {
        this.accountService.updatePassword(oldPassword, newPassword);
        return AjaxEntityBuilder.success();
    }
}
