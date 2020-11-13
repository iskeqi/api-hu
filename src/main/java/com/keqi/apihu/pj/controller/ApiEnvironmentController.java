package com.keqi.apihu.pj.controller;

import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.github.xiaoymin.knife4j.annotations.ApiSupport;
import com.keqi.apihu.core.common.AjaxEntity;
import com.keqi.apihu.core.common.AjaxEntityBuilder;
import com.keqi.apihu.pj.domain.param.CreateApiEnvironmentParam;
import com.keqi.apihu.pj.domain.param.UpdateApiEnvironmentParam;
import com.keqi.apihu.pj.domain.vo.PageApiEnvironmentVO;
import com.keqi.apihu.pj.service.ApiEnvironmentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.List;

@Api(tags = "3. API环境管理")
@ApiSupport(author = "keqi", order = 3)
@Validated
@AllArgsConstructor
@RestController
@RequestMapping("/pj/apiEnvironment")
public class ApiEnvironmentController {

    private final ApiEnvironmentService apiEnvironmentService;
    
    /**
     * 增加API环境
     * @param createApiEnvironmentParam createApiEnvironmentParam
     * @return r
     */
    @ApiOperation(value = "3.1 增加API环境")
    @ApiOperationSupport(order = 1)
    @PostMapping("/create")
    public AjaxEntity create(@Validated @RequestBody CreateApiEnvironmentParam createApiEnvironmentParam) {
        this.apiEnvironmentService.createApiEnvironment(createApiEnvironmentParam);
        return AjaxEntityBuilder.success();
    }

    /**
     * 删除API环境
     * @param id id
     * @return r
     */
    @ApiOperation(value = "3.2 删除API环境")
    @ApiOperationSupport(order = 2)
    @ApiImplicitParam(name = "id", value = "API环境ID", example = "1", required = true)
    @PostMapping("/delete")
    public AjaxEntity delete(@RequestParam @NotNull Long id) {
        this.apiEnvironmentService.deleteByPrimaryKey(id);
        return AjaxEntityBuilder.success();
    }

    /**
     * 修改API环境
     * @param updateApiEnvironmentParam updateApiEnvironmentParam
     * @return r
     */
    @ApiOperation(value = "3.3 修改API环境")
    @ApiOperationSupport(order = 3)
    @PostMapping("/update")
    public AjaxEntity update(@Validated @RequestBody UpdateApiEnvironmentParam updateApiEnvironmentParam) {
        this.apiEnvironmentService.updateByPrimaryKey(updateApiEnvironmentParam);
        return AjaxEntityBuilder.success();
    }

    /**
     * 查询全部API环境列表
     * @return r
     */
    @ApiOperation(value = "3.4 查询全部API环境列表")
    @ApiOperationSupport(order = 4)
    @GetMapping("/list")
    public AjaxEntity<List<PageApiEnvironmentVO>> list() {
        return AjaxEntityBuilder.success(this.apiEnvironmentService.listApiEnvironment());
    }
}
