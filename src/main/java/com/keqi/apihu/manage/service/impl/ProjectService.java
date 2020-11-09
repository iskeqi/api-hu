package com.keqi.apihu.manage.service.impl;

import com.keqi.apihu.core.common.PageVO;
import com.keqi.apihu.manage.domain.ProjectDO;
import com.keqi.apihu.manage.domain.param.CreateProjectParam;
import com.keqi.apihu.manage.domain.param.QueryProjectParam;
import com.keqi.apihu.manage.domain.param.UpdateProjectParam;

public interface ProjectService{

    /**
     * 根据id删除项目
     * @param id id
     * @return
     */
    void deleteByPrimaryKey(Long id);

    int insert(ProjectDO record);

    int insertSelective(ProjectDO record);

    ProjectDO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ProjectDO record);

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
    PageVO pageProject(QueryProjectParam queryProjectParam);
}
