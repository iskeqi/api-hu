package com.keqi.apihu.manage.service;

import cn.hutool.core.bean.BeanUtil;
import com.keqi.apihu.core.common.AjaxPageEntity;
import com.keqi.apihu.core.exception.BusinessException;
import com.keqi.apihu.manage.domain.AccountProjectDO;
import com.keqi.apihu.manage.domain.ProjectDO;
import com.keqi.apihu.manage.domain.param.CreateProjectParam;
import com.keqi.apihu.manage.domain.param.DesignatedAccountParam;
import com.keqi.apihu.manage.domain.param.QueryProjectParam;
import com.keqi.apihu.manage.domain.param.UpdateProjectParam;
import com.keqi.apihu.manage.domain.vo.PageProjectVO;
import com.keqi.apihu.manage.mapper.AccountProjectMapper;
import com.keqi.apihu.manage.mapper.ProjectMapper;
import com.keqi.apihu.manage.service.impl.ProjectService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ProjectServiceImpl implements ProjectService{

    private final ProjectMapper projectMapper;
    private final AccountProjectMapper accountProjectMapper;

    /**
     * 根据id删除项目
     * @param id id
     * @return r
     */
    @Override
    @Transactional
    public void deleteByPrimaryKey(Long id) {
        // 项目删除采用逻辑删除的方式，后续通过定时任务去删除项目表以及项目内的各个表的记录 todo
        this.projectMapper.disabledProject(id);
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
    public AjaxPageEntity<PageProjectVO> pageProject(QueryProjectParam queryProjectParam) {
        int total = this.projectMapper.countProject(queryProjectParam);

        AjaxPageEntity ajaxPageEntity = new AjaxPageEntity();

        if (total > 0) {
            List<PageProjectVO> pageAccountVOList = this.projectMapper.pageProject(queryProjectParam);
            ajaxPageEntity.setTotal(total);
            ajaxPageEntity.setList(pageAccountVOList);
        }

        return ajaxPageEntity;
    }

    /**
     * 指定项目人员
     *
     * @param designatedAccountParam designatedAccountParam
     */
    @Override
    @Transactional
    public void designatedAccount(DesignatedAccountParam designatedAccountParam) {
        // 删除项目-人员关联记录
        this.accountProjectMapper.deleteByProjectId(designatedAccountParam.getProjectId());
        // 增加项目-人员关联记录
        List<Long> accountIdList = designatedAccountParam.getAccountIdList();
        if (accountIdList.size() > 0) {
            List<AccountProjectDO> accountProjectDOList = new ArrayList<>(accountIdList.size());
            for (Long accountId : accountIdList) {
                AccountProjectDO accountProjectDO = new AccountProjectDO();
                accountProjectDO.setAccountId(accountId);
                accountProjectDO.setProjectId(designatedAccountParam.getProjectId());
                accountProjectDOList.add(accountProjectDO);
            }
            this.accountProjectMapper.batchInsert(accountProjectDOList);
        }
    }

}
