package com.keqi.apihu.pj.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.keqi.apihu.core.common.Auth;
import com.keqi.apihu.core.exception.BusinessException;
import com.keqi.apihu.pj.domain.PjConstant;
import com.keqi.apihu.pj.domain.db.ApiGroupDO;
import com.keqi.apihu.pj.domain.param.CreateApiGroupParam;
import com.keqi.apihu.pj.domain.param.MoveGroupParam;
import com.keqi.apihu.pj.domain.param.UpdateApiGroupParam;
import com.keqi.apihu.pj.domain.vo.PageApiGroupVO;
import com.keqi.apihu.pj.mapper.ApiGroupMapper;
import com.keqi.apihu.pj.mapper.ApiRequestMapper;
import com.keqi.apihu.pj.service.ApiGroupService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@AllArgsConstructor
public class ApiGroupServiceImpl implements ApiGroupService{

    private final ApiGroupMapper apiGroupMapper;
    private final ApiRequestMapper apiRequestMapper;

    /**
     * 删除API分组
     * @param id id
     * @return r
     */
    @Override
    @Transactional
    public int deleteByPrimaryKey(Long id) {
        // 查询该分组下级分组总数
        int groupCount = this.apiGroupMapper.countByParentId(id);

        // 查询该分组下级API总数
        int apiCount = this.apiRequestMapper.countByApiGroupId(id);

        // 删除对应的分组，如果该分组下有其它分组或者接口，则不允许删除，必须要先移出
        if (groupCount > 0 || apiCount > 0) {
            throw new BusinessException("请先移出该分组下的分组及API");
        }

        return apiGroupMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改API分组
     * @param updateApiGroupParam updateApiGroupParam
     * @return r
     */
    @Override
    @Transactional
    public void updateByPrimaryKey(UpdateApiGroupParam updateApiGroupParam) {
        ApiGroupDO obj = this.apiGroupMapper.findOneByName(updateApiGroupParam.getName(), Auth.getProjectId());
        if (!Objects.isNull(obj) && !Objects.equals(obj.getId(), updateApiGroupParam.getId())) {
            throw new BusinessException("已存在同名分组");
        }

        ApiGroupDO apiGroupDO = new ApiGroupDO();
        BeanUtil.copyProperties(updateApiGroupParam, apiGroupDO);
        apiGroupDO.setProjectId(Auth.getProjectId());
        this.apiGroupMapper.updateNameById(apiGroupDO);
    }

    /**
     * 增加API分组
     *
     * @param createApiGroupParam createApiGroupParam
     */
    @Override
    @Transactional
    public void createApiGroup(CreateApiGroupParam createApiGroupParam) {
        ApiGroupDO obj = this.apiGroupMapper.findOneByName(createApiGroupParam.getName(), Auth.getProjectId());
        if (!Objects.isNull(obj)) {
            throw new BusinessException("已存在同名分组");
        }


        // 如果 parentId 为 null，则为顶级分组，parentId 为 0
        if (Objects.isNull(createApiGroupParam.getParentId())) {
            createApiGroupParam.setParentId(PjConstant.rootParentId);
        }

        String ancestors = this.getAncestorsByParentId(createApiGroupParam.getParentId());
        ApiGroupDO apiGroupDO = new ApiGroupDO();
        BeanUtil.copyProperties(createApiGroupParam, apiGroupDO);
        apiGroupDO.setAncestors(ancestors);
        apiGroupDO.setProjectId(Auth.getProjectId());

        // 查询当前 parentId 分组下最大的 orderNum 值
        ApiGroupDO temp = new ApiGroupDO();
        temp.setParentId(createApiGroupParam.getParentId());
        temp.setProjectId(Auth.getProjectId());
        int maxOrderNumByParentId = this.apiGroupMapper.getMaxOrderNumByParentId(temp);
        apiGroupDO.setOrderNum(maxOrderNumByParentId + 1);

        this.apiGroupMapper.insert(apiGroupDO);
    }

    /**
     * 查询全部API分组列表
     *
     * @return r
     */
    @Override
    public List<PageApiGroupVO> listApiGroup() {
        // 直接使用 MyBatis 的一对多功能将分组和分组下的API全部查询出来
        List<ApiGroupDO> apiGroupDOList = this.apiGroupMapper.findAllByProjectId(Auth.getProjectId());

        List<PageApiGroupVO> pageApiGroupVOS = new ArrayList<>(apiGroupDOList.size());
        for (ApiGroupDO apiGroupDO : apiGroupDOList) {
            PageApiGroupVO pageApiGroupVO = new PageApiGroupVO();
            BeanUtil.copyProperties(apiGroupDO, pageApiGroupVO);
            pageApiGroupVOS.add(pageApiGroupVO);
        }

        // 再在程序中对分组进行树形结构的组装
        return this.assembleTreeList(pageApiGroupVOS, PjConstant.rootParentId);
    }

    /**
     * 移动分组顺序
     *
     * @param moveGroupParamList        moveGroupParamList
     */
    @Override
    @Transactional
    public void moveGroup(List<MoveGroupParam> moveGroupParamList) {
        // 移动分组时会打乱分组的前后顺序，这里直接利用前端树形控件的方式来实现，后端直接做全量替换
        Long projectId = Auth.getProjectId();
        this.apiGroupMapper.deleteByProjectId(projectId);

        // 组装树的根节点
        MoveGroupParam root = new MoveGroupParam();
        root.setId((long) 0);
        root.setParentId(PjConstant.rootParentId);
        root.setAncestors(null);
        root.setSubMoveGroupParamList(moveGroupParamList);

        // 遍历树形结构（使用 BFS 遍历 N叉树的典型应用）
        Queue<MoveGroupParam> queue = new LinkedList<>();
        queue.offer(root);
        Map<MoveGroupParam, MoveGroupParam> map = new HashMap<>();
        while (!queue.isEmpty()) {
            MoveGroupParam moveGroupParam = null;
            for (int i = 0; i < queue.size(); i++) {
                moveGroupParam = queue.poll();

                if (!Objects.equals(moveGroupParam.getId(), (long)0)) {
                    // 执行插入记录
                    ApiGroupDO apiGroupDO = new ApiGroupDO();
                    BeanUtil.copyProperties(moveGroupParam, apiGroupDO);
                    this.apiGroupMapper.insert(apiGroupDO);
                    moveGroupParam.setId(apiGroupDO.getId());
                }

                List<MoveGroupParam> subMoveGroupParamList = moveGroupParam.getSubMoveGroupParamList();
                for (int j = 0; j < subMoveGroupParamList.size(); j++) {
                    MoveGroupParam t = subMoveGroupParamList.get(j);
                    map.put(t, moveGroupParam); // 每一个子级节点，都以自己为 key ，父节点为 value，存储到Map中
                    t.setOrderNum(j + 1);
                    t.setParentId(map.get(t).getId());
                    t.setAncestors(moveGroupParam.getAncestors() == null ? String.valueOf(PjConstant.rootParentId)
                            : moveGroupParam.getAncestors() + "," + moveGroupParam.getId());
                    t.setProjectId(projectId);
                    queue.offer(t);
                }
            }
        }
    }

    //================================私有方法================================//

    /**
     * 根据 parentId 计算分组的祖级列表
     * @param parentId parentId
     * @return r
     */
    private String getAncestorsByParentId(Long parentId) {
        StringBuilder ancestors = new StringBuilder();
        if (Objects.equals(PjConstant.rootParentId, parentId)) {
            ancestors.append(PjConstant.rootParentId);
        } else {
            // 查询 parentId 的 ancestors ，再在末尾追加 ",parentId"
            ApiGroupDO apiGroupDO = this.apiGroupMapper.selectByPrimaryKey(parentId);
            ancestors.append(apiGroupDO.getAncestors()).append(",").append(parentId);
        }
        return ancestors.toString();
    }

    /**
     * 把没有层次结构的分组列表按照父子结构关系进行组装（递归构造树形结构）
     * @param pageApiGroupVOS apiGroupDOList
     * @return r
     */
    private List<PageApiGroupVO> assembleTreeList(List<PageApiGroupVO> pageApiGroupVOS, Long rootParentId) {
        List<PageApiGroupVO> apiGroupDOTreeList = new ArrayList<>();
        for (PageApiGroupVO apiGroupDO : pageApiGroupVOS) {
            if (apiGroupDO.getParentId().equals(rootParentId)) {
                apiGroupDO.setPageApiGroupVOList(assembleTreeList(pageApiGroupVOS, apiGroupDO.getId()));
                apiGroupDOTreeList.add(apiGroupDO);
            }
        }
        apiGroupDOTreeList.sort(Comparator.comparing(PageApiGroupVO::getOrderNum));
        return apiGroupDOTreeList;
    }
}
