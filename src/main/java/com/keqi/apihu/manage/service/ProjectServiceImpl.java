package com.keqi.apihu.manage.service;

import cn.hutool.core.bean.BeanUtil;
import com.keqi.apihu.core.common.PageVO;
import com.keqi.apihu.core.exception.BusinessException;
import com.keqi.apihu.manage.domain.ProjectDO;
import com.keqi.apihu.manage.domain.param.CreateProjectParam;
import com.keqi.apihu.manage.domain.param.QueryProjectParam;
import com.keqi.apihu.manage.domain.param.UpdateProjectParam;
import com.keqi.apihu.manage.domain.vo.PageProjectVO;
import com.keqi.apihu.manage.mapper.ProjectMapper;
import com.keqi.apihu.manage.service.impl.ProjectService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService{

    @Resource
    private ProjectMapper projectMapper;

    @Override
    @Transactional
    public void deleteByPrimaryKey(Long id) {
        // 项目删除采用逻辑删除的方式，后续通过定时任务去删除项目表以及项目内的各个表的记录 todo
        this.projectMapper.disabledProject(id);
    }

    @Override
    public int insert(ProjectDO record) {
        return projectMapper.insert(record);
    }

    @Override
    public int insertSelective(ProjectDO record) {
        return projectMapper.insertSelective(record);
    }

    @Override
    public ProjectDO selectByPrimaryKey(Long id) {
        return projectMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(ProjectDO record) {
        return projectMapper.updateByPrimaryKeySelective(record);
    }

    /**
     * 修改项目
     * @param updateProjectParam updateProjectParam
     * @return r
     */
    @Override
    @Transactional
    public void updateByPrimaryKey(UpdateProjectParam updateProjectParam) {
        // 查询是否存在同名的项目
        int count = this.projectMapper.projectExist(updateProjectParam.getProjectName());
        if (count > 0) {
            throw new BusinessException("系统中已存在同名项目");
        }

        ProjectDO projectDO = new ProjectDO();
        BeanUtil.copyProperties(updateProjectParam, projectDO);
        this.projectMapper.updateByPrimaryKey(projectDO);
    }

    /**
     * 创建项目
     *
     * @param createProjectParam createProjectParam
     */
    @Override
    @Transactional
    public void createProject(CreateProjectParam createProjectParam) {
        // 查询是否存在同名的项目
        int count = this.projectMapper.projectExist(createProjectParam.getProjectName());
        if (count > 0) {
            throw new BusinessException("系统中已存在同名项目");
        }

        ProjectDO projectDO = new ProjectDO();
        BeanUtil.copyProperties(createProjectParam, projectDO);
        this.projectMapper.insert(projectDO);
    }

    /**
     * 分页查询项目列表
     *
     * @param queryProjectParam queryProjectParam
     * @return r
     */
    @Override
    public PageVO pageProject(QueryProjectParam queryProjectParam) {
        int total = this.projectMapper.countProject(queryProjectParam);

        PageVO pageVO = new PageVO();

        if (total > 0) {
            List<PageProjectVO> pageAccountVOList = this.projectMapper.pageProject(queryProjectParam);
            pageVO.setTotal(total);
            pageVO.setList(pageAccountVOList);
        }

        return pageVO;
    }

}
