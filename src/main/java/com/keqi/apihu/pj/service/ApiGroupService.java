package com.keqi.apihu.pj.service;

import com.keqi.apihu.pj.domain.param.CreateApiGroupParam;
import com.keqi.apihu.pj.domain.param.MoveGroupParam;
import com.keqi.apihu.pj.domain.param.UpdateApiGroupParam;
import com.keqi.apihu.pj.domain.vo.PageApiGroupVO;

import java.util.List;

public interface ApiGroupService {

    /**
     * 删除API分组
     *
     * @param id id
     * @return r
     */
    int deleteByPrimaryKey(Long id);

    /**
     * 修改API分组
     *
     * @param updateApiGroupParam updateApiGroupParam
     * @return r
     */
    void updateByPrimaryKey(UpdateApiGroupParam updateApiGroupParam);

    /**
     * 增加API分组
     *
     * @param createApiGroupParam createApiGroupParam
     */
    void createApiGroup(CreateApiGroupParam createApiGroupParam);

    /**
     * 查询全部API分组列表
     *
     * @return r
     */
    List<PageApiGroupVO> listApiGroup();

    /**
     * 移动分组顺序
     *
     * @param moveGroupParamList moveGroupParamList
     */
    void moveGroup(List<MoveGroupParam> moveGroupParamList);
}
