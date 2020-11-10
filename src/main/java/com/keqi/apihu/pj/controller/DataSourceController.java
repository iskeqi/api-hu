package com.keqi.apihu.pj.controller;

import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.github.xiaoymin.knife4j.annotations.ApiSupport;
import com.keqi.apihu.core.common.AjaxEntity;
import com.keqi.apihu.core.common.AjaxEntityBuilder;
import com.keqi.apihu.core.common.AjaxPageEntity;
import com.keqi.apihu.manage.domain.param.QueryProjectParam;
import com.keqi.apihu.manage.domain.param.UpdateProjectParam;
import com.keqi.apihu.manage.domain.vo.PageProjectVO;
import com.keqi.apihu.pj.DatasourceService;
import com.keqi.apihu.pj.domain.param.CreateDatasourceParam;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;

@Api(tags = "1. 数据源管理")
@ApiSupport(author = "keqi", order = 1)
@Validated
@AllArgsConstructor
@RestController
@RequestMapping("/pj/ds")
public class DataSourceController {

    private final DatasourceService datasourceService;
    
    /**
     * 增加数据源
     * @param createProjectParam createProjectParam
     * @return r
     */
    @ApiOperation(value = "1.1 增加数据源")
    @ApiOperationSupport(order = 1)
    @PostMapping("/create")
    public AjaxEntity create(@Validated @RequestBody CreateDatasourceParam createProjectParam) {
        this.datasourceService.createDataSource(createProjectParam);
        return AjaxEntityBuilder.success();
    }

    /**
     * 删除数据源
     * @param id id
     * @return r
     */
    @ApiOperation(value = "1.2 删除数据源")
    @ApiOperationSupport(order = 2)
    @ApiImplicitParam(name = "id", value = "数据源ID", example = "1", required = true)
    @PostMapping("/delete")
    public AjaxEntity delete(@RequestParam @NotNull Long id) {
        this.datasourceService.deleteByPrimaryKey(id);
        return AjaxEntityBuilder.success();
    }

    /**
     * 修改数据源
     * @param updateProjectParam updateProjectParam
     * @return r
     */
    @ApiOperation(value = "1.3 修改数据源")
    @ApiOperationSupport(order = 3)
    @PostMapping("/update")
    public AjaxEntity update(@Validated @RequestBody UpdateProjectParam updateProjectParam) {
        //this.datasourceService.updateByPrimaryKey(updateProjectParam);
        return AjaxEntityBuilder.success();
    }

    /**
     * 查询数据源列表
     * @param queryProjectParam queryProjectParam
     * @return r
     */
    @ApiOperation(value = "1.4 分页查询数据源列表")
    @ApiOperationSupport(order = 4)
    @PostMapping("/page")
    public AjaxEntity<AjaxPageEntity<PageProjectVO>> page(@Validated @RequestBody QueryProjectParam queryProjectParam) {
        return AjaxEntityBuilder.successList(null/*this.datasourceService.pageProject(queryProjectParam)*/);
    }
}
