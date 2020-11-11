package com.keqi.apihu.pj.controller;

import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.github.xiaoymin.knife4j.annotations.ApiSupport;
import com.keqi.apihu.core.common.AjaxEntity;
import com.keqi.apihu.core.common.AjaxEntityBuilder;
import com.keqi.apihu.core.common.AjaxPageEntity;
import com.keqi.apihu.manage.domain.vo.PageProjectVO;
import com.keqi.apihu.pj.domain.param.CreateDatasourceParam;
import com.keqi.apihu.pj.domain.param.QueryDatasourceParam;
import com.keqi.apihu.pj.domain.param.UpdateDatasourceParam;
import com.keqi.apihu.pj.domain.vo.PageDatasourceTableColumnVO;
import com.keqi.apihu.pj.domain.vo.PageDatasourceTableVO;
import com.keqi.apihu.pj.service.DatasourceService;
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
     * @param updateDatasourceParam updateDatasourceParam
     * @return r
     */
    @ApiOperation(value = "1.3 修改数据源")
    @ApiOperationSupport(order = 3)
    @PostMapping("/update")
    public AjaxEntity update(@Validated @RequestBody UpdateDatasourceParam updateDatasourceParam) {
        this.datasourceService.updateByPrimaryKey(updateDatasourceParam);
        return AjaxEntityBuilder.success();
    }

    /**
     * 查询数据源列表
     * @param queryDatasourceParam queryDatasourceParam
     * @return r
     */
    @ApiOperation(value = "1.4 分页查询数据源列表")
    @ApiOperationSupport(order = 4)
    @PostMapping("/page")
    public AjaxEntity<AjaxPageEntity<PageProjectVO>> page(@Validated @RequestBody QueryDatasourceParam queryDatasourceParam) {
        return AjaxEntityBuilder.successList(this.datasourceService.pageDataSource(queryDatasourceParam));
    }

    /**
     * 查询全部数据源列表
     * @param queryDatasourceParam queryDatasourceParam
     * @return r
     */
    @ApiOperation(value = "1.5 查询全部数据源列表")
    @ApiOperationSupport(order = 5)
    @PostMapping("/list")
    public AjaxEntity<AjaxPageEntity<PageProjectVO>> list(@Validated @RequestBody QueryDatasourceParam queryDatasourceParam) {
        return AjaxEntityBuilder.successList(this.datasourceService.listDataSource(queryDatasourceParam));
    }

    /**
     * 在线读取数据库
     * @param id id
     * @return r
     */
    @ApiOperation(value = "1.6 在线读取数据库")
    @ApiOperationSupport(order = 6)
    @ApiImplicitParam(name = "id", value = "数据源ID", example = "1", required = true)
    @PostMapping("/readDataSource")
    public AjaxEntity readDataSource(@RequestParam @NotNull Long id) {
        this.datasourceService.readDataSource(id);
        return AjaxEntityBuilder.success();
    }

    /**
     * 查询指定数据源下的所有表
     * @param id id
     * @return r
     */
    @ApiOperation(value = "1.7 查询指定数据源下的所有表")
    @ApiOperationSupport(order = 7)
    @ApiImplicitParam(name = "id", value = "数据源ID", example = "1", required = true)
    @PostMapping("/listByDatasourceId")
    public AjaxEntity<AjaxPageEntity<PageDatasourceTableVO>> listByDatasourceId(@RequestParam @NotNull Long id) {
        return AjaxEntityBuilder.successList(this.datasourceService.listByDatasourceId(id));
    }

    /**
     * 查询指定表下的所有列
     * @param id id
     * @return r
     */
    @ApiOperation(value = "1.8 查询指定表下的所有列")
    @ApiOperationSupport(order = 8)
    @ApiImplicitParam(name = "id", value = "表ID", example = "1", required = true)
    @PostMapping("/listByDatasourceTableId")
    public AjaxEntity<AjaxPageEntity<PageDatasourceTableColumnVO>> listByDatasourceTableId(@RequestParam @NotNull Long id) {
        return AjaxEntityBuilder.successList(this.datasourceService.listByDatasourceTableId(id));
    }
}
