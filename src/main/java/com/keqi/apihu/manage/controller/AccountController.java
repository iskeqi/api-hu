package com.keqi.apihu.manage.controller;

import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.github.xiaoymin.knife4j.annotations.ApiSupport;
import com.keqi.apihu.core.common.AjaxEntity;
import com.keqi.apihu.core.common.AjaxEntityBuilder;
import com.keqi.apihu.core.common.AjaxPageEntity;
import com.keqi.apihu.manage.domain.param.CreateAccountParam;
import com.keqi.apihu.manage.domain.param.QueryAccountParam;
import com.keqi.apihu.manage.domain.param.UpdateAccountParam;
import com.keqi.apihu.manage.domain.vo.PageAccountVO;
import com.keqi.apihu.manage.service.impl.AccountService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
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
@Api(tags = "2. 用户管理")
@ApiSupport(author = "keqi", order = 2)
public class AccountController {

    private final AccountService accountService;

    /**
     * 增加用户
     * @param createAccountParam createAccountParam
     * @return r
     */
    @ApiOperation(value = "2.1 增加用户")
    @ApiOperationSupport(order = 1)
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
    @ApiOperation(value = "2.2 删除用户")
    @ApiOperationSupport(order = 2)
    @ApiImplicitParam(name = "id", value = "用户ID", example = "1", required = true)
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
    @ApiOperation(value = "2.3 修改用户")
    @ApiOperationSupport(order = 3)
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
    @ApiOperation(value = "2.4 分页查询用户列表")
    @ApiOperationSupport(order = 4)
    @PostMapping("/page")
    public AjaxEntity<AjaxPageEntity<PageAccountVO>> page(@Validated @RequestBody QueryAccountParam queryAccountParam) {
        // 用户名或者姓名使用 searchValue 字段接收
        return AjaxEntityBuilder.successList(this.accountService.pageAccount(queryAccountParam));
    }

    /**
     * 重置用户密码
     * @param id id
     * @return r
     */
    @ApiOperation(value = "2.5 重置用户密码")
    @ApiOperationSupport(order = 5)
    @ApiImplicitParam(name = "id", value = "用户ID", example = "3", required = true)
    @PostMapping("/resetPassword")
    public AjaxEntity resetPassword(@RequestParam @NotNull Long id) {
        this.accountService.resetPassword(id);
        return AjaxEntityBuilder.success();
    }

}
