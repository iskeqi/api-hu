package com.keqi.apihu.pj.controller;

import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.github.xiaoymin.knife4j.annotations.ApiSupport;
import com.keqi.apihu.core.common.AjaxEntity;
import com.keqi.apihu.core.common.AjaxEntityBuilder;
import com.keqi.apihu.pj.domain.param.CreateApiGroupParam;
import com.keqi.apihu.pj.domain.param.MoveGroupParam;
import com.keqi.apihu.pj.domain.param.UpdateApiGroupParam;
import com.keqi.apihu.pj.domain.vo.PageApiGroupVO;
import com.keqi.apihu.pj.service.ApiGroupService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.List;

@Api(tags = "2. API分组管理")
@ApiSupport(author = "keqi", order = 2)
@Validated
@AllArgsConstructor
@RestController
@RequestMapping("/pj/apiGroup")
public class ApiGroupController {

    private final ApiGroupService apiGroupService;
    
    /**
     * 增加API分组
     * @param createApiGroupParam createApiGroupParam
     * @return r
     */
    @ApiOperation(value = "2.1 增加API分组")
    @ApiOperationSupport(order = 1)
    @PostMapping("/create")
    public AjaxEntity create(@Validated @RequestBody CreateApiGroupParam createApiGroupParam) {
        this.apiGroupService.createApiGroup(createApiGroupParam);
        return AjaxEntityBuilder.success();
    }

    /**
     * 删除API分组
     * @param id id
     * @return r
     */
    @ApiOperation(value = "2.2 删除API分组")
    @ApiOperationSupport(order = 2)
    @ApiImplicitParam(name = "id", value = "API分组ID", example = "1", required = true)
    @PostMapping("/delete")
    public AjaxEntity delete(@RequestParam @NotNull Long id) {
        this.apiGroupService.deleteByPrimaryKey(id);
        return AjaxEntityBuilder.success();
    }

    /**
     * 修改API分组
     * @param updateApiGroupParam updateApiGroupParam
     * @return r
     */
    @ApiOperation(value = "2.3 修改API分组")
    @ApiOperationSupport(order = 3)
    @PostMapping("/update")
    public AjaxEntity update(@Validated @RequestBody UpdateApiGroupParam updateApiGroupParam) {
        this.apiGroupService.updateByPrimaryKey(updateApiGroupParam);
        return AjaxEntityBuilder.success();
    }

    /**
     * 查询全部API分组列表
     * @return r
     */
    @ApiOperation(value = "2.4 查询全部API分组列表")
    @ApiOperationSupport(order = 4)
    @GetMapping("/list")
    public AjaxEntity<List<PageApiGroupVO>> list() {
        return AjaxEntityBuilder.success(this.apiGroupService.listApiGroup());
    }

    /**
     * 移动分组顺序
     * @return r
     */
    @ApiOperation(value = "2.5 移动分组顺序")
    @ApiOperationSupport(order = 5)
    @PostMapping("/moveGroup")
    public AjaxEntity moveGroup(@Validated @RequestBody List<MoveGroupParam> moveGroupParamList) {
        this.apiGroupService.moveGroup(moveGroupParamList);
        return AjaxEntityBuilder.success();
    }

}
