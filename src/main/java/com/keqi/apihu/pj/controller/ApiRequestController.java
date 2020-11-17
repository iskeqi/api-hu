package com.keqi.apihu.pj.controller;

import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.github.xiaoymin.knife4j.annotations.ApiSupport;
import com.keqi.apihu.core.common.AjaxEntity;
import com.keqi.apihu.core.common.AjaxEntityBuilder;
import com.keqi.apihu.core.common.AjaxPageEntity;
import com.keqi.apihu.pj.domain.Direction;
import com.keqi.apihu.pj.domain.param.CreateApiRequestParam;
import com.keqi.apihu.pj.domain.param.QueryApiRequestParam;
import com.keqi.apihu.pj.domain.vo.ApiRequestDetailVO;
import com.keqi.apihu.pj.domain.vo.PageApiRequestVO;
import com.keqi.apihu.pj.service.ApiRequestService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
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
     *
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
     *
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
     *
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
     *
     * @param queryApiRequestParam queryApiRequestParam
     * @return r
     */
    @ApiOperation(value = "4.4 分页查询API列表")
    @ApiOperationSupport(order = 4)
    @PostMapping("/page")
    public AjaxEntity<AjaxPageEntity<PageApiRequestVO>> list(@Validated @RequestBody QueryApiRequestParam queryApiRequestParam) {
        return AjaxEntityBuilder.successList(this.apiRequestService.pageApiRequest(queryApiRequestParam));
    }

    /**
     * 查询API详情
     *
     * @param id id
     * @return r
     */
    @ApiOperation(value = "4.5 查询API详情")
    @ApiOperationSupport(order = 5)
    @ApiImplicitParam(name = "id", value = "API ID", example = "1", required = true)
    @PostMapping("/detail")
    public AjaxEntity<ApiRequestDetailVO> detail(@NotNull @RequestParam Long id) {
        return AjaxEntityBuilder.success(this.apiRequestService.selectByPrimaryKey(id));
    }

    /**
     * 在本级移动API
     *
     * @param id        id
     * @param direction direction
     * @return r
     */
    @ApiOperation(value = "4.6 在本级移动API")
    @ApiOperationSupport(order = 6)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "API ID", example = "1", required = true),
            @ApiImplicitParam(name = "direction", value = "移动方向", example = "UP", required = true)
    })
    @PostMapping("/moveApi")
    public AjaxEntity moveApi(@NotNull @RequestParam Long id, @NotNull @RequestParam Direction direction) {
        this.apiRequestService.moveApi(id, direction);
        return AjaxEntityBuilder.success();
    }

    /**
     * 移动API到其他分组下
     *
     * @param id         id
     * @param apiGroupId apiGroupId
     * @return r
     */
    @ApiOperation(value = "4.7 移动API到其他分组下")
    @ApiOperationSupport(order = 7)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "API ID", example = "1", required = true),
            @ApiImplicitParam(name = "apiGroupId", value = "分组ID", example = "1", required = true)
    })
    @PostMapping("/moveApiToOtherGroup")
    public AjaxEntity moveApiToOtherGroup(@NotNull @RequestParam Long id, @NotNull @RequestParam Long apiGroupId) {
        this.apiRequestService.moveApiToOtherGroup(id, apiGroupId);
        return AjaxEntityBuilder.success();
    }
}
