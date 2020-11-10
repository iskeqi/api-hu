package com.keqi.apihu.manage.mapper;

import com.keqi.apihu.manage.domain.db.ProjectDO;
import com.keqi.apihu.manage.domain.param.QueryProjectParam;
import com.keqi.apihu.manage.domain.vo.PageProjectVO;

import java.util.List;

public interface ProjectMapper {
    int deleteByPrimaryKey(Long id);

    /**
     * 新增项目
     * @param record record
     * @return r
     */
    int insert(ProjectDO record);

    int insertSelective(ProjectDO record);

    ProjectDO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ProjectDO record);

    /**
     * 禁用项目
     * @param id id
     */
    void disabledProject(Long id);

    /**
     * 修改项目
     * @param record record
     * @return r
     */
    int updateByPrimaryKey(ProjectDO record);

    /**
     * 判断是否存在同名项目名
     * @param projectName projectName
     * @return r
     */
    int projectExist(String projectName);

    /**
     * 分页列表查询记录总数
     * @param queryProjectParam queryProjectParam
     * @return r
     */
    int countProject(QueryProjectParam queryProjectParam);

    /**
     * 分页查询项目列表总数
     * @param queryProjectParam queryProjectParam
     * @return r
     */
    List<PageProjectVO> pageProject(QueryProjectParam queryProjectParam);
}