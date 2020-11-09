package com.keqi.apihu.manage.controller;

import com.keqi.apihu.core.common.AjaxEntity;
import com.keqi.apihu.core.common.AjaxEntityBuilder;
import com.keqi.apihu.manage.domain.param.CreateProjectParam;
import com.keqi.apihu.manage.domain.param.QueryProjectParam;
import com.keqi.apihu.manage.domain.param.UpdateProjectParam;
import com.keqi.apihu.manage.service.impl.ProjectService;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;

@RestController
@AllArgsConstructor
@Validated
@RequestMapping("/sys/project")
public class ProjectController {

    private final ProjectService projectService;

    @PostMapping("/create")
    public AjaxEntity create(@Validated @RequestBody CreateProjectParam createProjectParam) {
        this.projectService.createProject(createProjectParam);
        return AjaxEntityBuilder.success();
    }

    @PostMapping("/delete")
    public AjaxEntity delete(@NotNull Long id) {
        this.projectService.deleteByPrimaryKey(id);
        return AjaxEntityBuilder.success();
    }

    @PostMapping("/update")
    public AjaxEntity update(@Validated @RequestBody UpdateProjectParam updateProjectParam) {
        this.projectService.updateByPrimaryKey(updateProjectParam);
        return AjaxEntityBuilder.success();
    }

    @PostMapping("/page")
    public AjaxEntity page(@Validated @RequestBody QueryProjectParam queryProjectParam) {
        return AjaxEntityBuilder.successList(this.projectService.pageProject(queryProjectParam));
    }

    // 指定人员接口



















}
