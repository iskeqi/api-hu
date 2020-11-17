package com.keqi.apihu.manage.controller;

import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.github.xiaoymin.knife4j.annotations.ApiSupport;
import com.keqi.apihu.core.common.AjaxEntity;
import com.keqi.apihu.core.common.AjaxEntityBuilder;
import com.keqi.apihu.core.common.AjaxPageEntity;
import com.keqi.apihu.manage.domain.param.CreateProjectParam;
import com.keqi.apihu.manage.domain.param.DesignatedAccountParam;
import com.keqi.apihu.manage.domain.param.QueryProjectParam;
import com.keqi.apihu.manage.domain.param.UpdateProjectParam;
import com.keqi.apihu.manage.domain.vo.PageProjectVO;
import com.keqi.apihu.manage.service.ProjectService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;


@Api(tags = "3. 项目管理")
@ApiSupport(author = "keqi", order = 3)
@Validated
@AllArgsConstructor
@RestController
@RequestMapping("/sys/project")
public class ProjectController {

    private final ProjectService projectService;

    /**
     * 增加项目
     *
     * @param createProjectParam createProjectParam
     * @return r
     */
    @ApiOperation(value = "3.1 增加项目")
    @ApiOperationSupport(order = 1)
    @PostMapping("/create")
    public AjaxEntity create(@Validated @RequestBody CreateProjectParam createProjectParam) {
        this.projectService.createProject(createProjectParam);
        return AjaxEntityBuilder.success();
    }

    /**
     * 删除项目
     *
     * @param id id
     * @return r
     */
    @ApiOperation(value = "3.2 删除项目")
    @ApiOperationSupport(order = 2)
    @ApiImplicitParam(name = "id", value = "项目ID", example = "1", required = true)
    @PostMapping("/delete")
    public AjaxEntity delete(@RequestParam @NotNull Long id) {
        this.projectService.deleteByPrimaryKey(id);
        return AjaxEntityBuilder.success();
    }

    /**
     * 修改项目
     *
     * @param updateProjectParam updateProjectParam
     * @return r
     */
    @ApiOperation(value = "3.3 修改项目")
    @ApiOperationSupport(order = 3)
    @PostMapping("/update")
    public AjaxEntity update(@Validated @RequestBody UpdateProjectParam updateProjectParam) {
        this.projectService.updateByPrimaryKey(updateProjectParam);
        return AjaxEntityBuilder.success();
    }

    /**
     * 查询项目列表
     *
     * @param queryProjectParam queryProjectParam
     * @return r
     */
    @ApiOperation(value = "3.4 分页查询项目列表")
    @ApiOperationSupport(order = 4)
    @PostMapping("/page")
    public AjaxEntity<AjaxPageEntity<PageProjectVO>> page(@Validated @RequestBody QueryProjectParam queryProjectParam) {
        return AjaxEntityBuilder.successList(this.projectService.pageProject(queryProjectParam));
    }

    /**
     * 指定项目人员
     *
     * @param designatedAccountParam designatedAccountParam
     * @return r
     */
    @ApiOperation(value = "3.5 指定项目人员")
    @ApiOperationSupport(order = 5)
    @PostMapping("/designatedAccount")
    public AjaxEntity designatedAccount(@Validated @RequestBody DesignatedAccountParam designatedAccountParam) {
        this.projectService.designatedAccount(designatedAccountParam);
        return AjaxEntityBuilder.success();
    }


}
