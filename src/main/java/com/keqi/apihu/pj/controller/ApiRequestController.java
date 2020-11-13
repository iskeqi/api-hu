package com.keqi.apihu.pj.controller;

import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.github.xiaoymin.knife4j.annotations.ApiSupport;
import com.keqi.apihu.core.common.AjaxEntity;
import com.keqi.apihu.core.common.AjaxEntityBuilder;
import com.keqi.apihu.pj.domain.param.CreateApiRequestParam;
import com.keqi.apihu.pj.domain.param.MoveGroupParam;
import com.keqi.apihu.pj.domain.param.UpdateApiGroupParam;
import com.keqi.apihu.pj.domain.vo.PageApiGroupVO;
import com.keqi.apihu.pj.service.ApiRequestService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.List;

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
    @ApiImplicitParam(name = "id", value = "APIID", example = "1", required = true)
    @PostMapping("/delete")
    public AjaxEntity delete(@RequestParam @NotNull Long id) {
        this.apiRequestService.deleteByPrimaryKey(id);
        return AjaxEntityBuilder.success();
    }

    /**
     * 修改API
     * @param updateApiGroupParam updateApiGroupParam
     * @return r
     */
    @ApiOperation(value = "4.3 修改API")
    @ApiOperationSupport(order = 3)
    @PostMapping("/update")
    public AjaxEntity update(@Validated @RequestBody UpdateApiGroupParam updateApiGroupParam) {
        //this.apiRequestService.updateByPrimaryKey(updateApiGroupParam);
        return AjaxEntityBuilder.success();
    }

    /**
     * 查询全部API列表
     * @return r
     */
    @ApiOperation(value = "4.4 查询全部API列表")
    @ApiOperationSupport(order = 4)
    @GetMapping("/list")
    public AjaxEntity<List<PageApiGroupVO>> list() {
        //return AjaxEntityBuilder.success(this.apiRequestService.listApiGroup());
        return null;
    }

    /**
     * 移动分组顺序
     * @return r
     */
    @ApiOperation(value = "4.5 移动分组顺序")
    @ApiOperationSupport(order = 5)
    @PostMapping("/moveGroup")
    public AjaxEntity moveGroup(@Validated @RequestBody List<MoveGroupParam> moveGroupParamList) {
        //this.apiRequestService.moveGroup(moveGroupParamList);
        return AjaxEntityBuilder.success();
    }

}
