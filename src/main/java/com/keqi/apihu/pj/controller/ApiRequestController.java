package com.keqi.apihu.pj.controller;

import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.github.xiaoymin.knife4j.annotations.ApiSupport;
import com.keqi.apihu.core.common.AjaxEntity;
import com.keqi.apihu.core.common.AjaxEntityBuilder;
import com.keqi.apihu.core.common.AjaxPageEntity;
import com.keqi.apihu.pj.domain.param.CreateApiRequestParam;
import com.keqi.apihu.pj.domain.param.QueryApiRequestParam;
import com.keqi.apihu.pj.domain.vo.PageApiRequestVO;
import com.keqi.apihu.pj.service.ApiRequestService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;

@Api(tags = "4. API管理")
@ApiSupport(author = "keqi", order = 4)
@Validated
@AllArgsConstructor
@RestController
@RequestMapping("/pj/apiRequest")
public class ApiRequestController {

    private final ApiRequestService apiRequestService;
    
    /**
     * 增加API
     * @param createApiRequestParam createApiRequestParam
     * @return r
     */
    @ApiOperation(value = "4.1 增加API")
    @ApiOperationSupport(order = 1)
    @PostMapping("/create")
    public AjaxEntity create(@Validated @RequestBody CreateApiRequestParam createApiRequestParam) {
        this.apiRequestService.createApiRequest(createApiRequestParam);
        return AjaxEntityBuilder.success();
    }

    /**
     * 删除API
     * @param id id
     * @return r
     */
    @ApiOperation(value = "4.2 删除API")
    @ApiOperationSupport(order = 2)
    @ApiImplicitParam(name = "id", value = "API ID", example = "1", required = true)
    @PostMapping("/delete")
    public AjaxEntity delete(@RequestParam @NotNull Long id) {
        this.apiRequestService.deleteByPrimaryKey(id);
        return AjaxEntityBuilder.success();
    }

    /**
     * 修改API
     * @param updateApiRequestParam updateApiRequestParam
     * @return r
     */
    @ApiOperation(value = "4.3 修改API")
    @ApiOperationSupport(order = 3)
    @PostMapping("/update")
    public AjaxEntity update(@Validated @RequestBody CreateApiRequestParam updateApiRequestParam) {
        this.apiRequestService.updateByPrimaryKey(updateApiRequestParam);
        return AjaxEntityBuilder.success();
    }

    /**
     * 分页查询API列表
     * @param queryApiRequestParam queryApiRequestParam
     * @return r
     */
    @ApiOperation(value = "4.4 分页查询API列表")
    @ApiOperationSupport(order = 4)
    @PostMapping("/page")
    public AjaxEntity<AjaxPageEntity<PageApiRequestVO>> list(@Validated @RequestBody QueryApiRequestParam queryApiRequestParam) {
        return AjaxEntityBuilder.successList(this.apiRequestService.pageApiRequest(queryApiRequestParam));
    }

    // todo 查询API详情、在本级移动API、移动到其他分组下
}
