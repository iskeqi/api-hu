package com.keqi.apihu.manage.service.impl;

import com.keqi.apihu.core.common.AjaxPageEntity;
import com.keqi.apihu.manage.domain.param.CreateProjectParam;
import com.keqi.apihu.manage.domain.param.DesignatedAccountParam;
import com.keqi.apihu.manage.domain.param.QueryProjectParam;
import com.keqi.apihu.manage.domain.param.UpdateProjectParam;
import com.keqi.apihu.manage.domain.vo.PageProjectVO;

public interface ProjectService{

    /**
     * 根据id删除项目
     * @param id id
     * @return r
     */
    void deleteByPrimaryKey(Long id);

    /**
     * 修改项目
     * @param updateProjectParam updateProjectParam
     * @return r
     */
    void updateByPrimaryKey(UpdateProjectParam updateProjectParam);

    /**
     * 创建项目
     * @param createProjectParam createProjectParam
     */
    void createProject(CreateProjectParam createProjectParam);

    /**
     * 分页查询项目列表
     * @param queryProjectParam queryProjectParam
     * @return r
     */
    AjaxPageEntity<PageProjectVO> pageProject(QueryProjectParam queryProjectParam);

    /**
     * 指定项目人员
     * @param designatedAccountParam designatedAccountParam
     */
    void designatedAccount(DesignatedAccountParam designatedAccountParam);
}
