package com.keqi.apihu.pj.service.impl;

import com.keqi.apihu.pj.domain.db.ApiGroupDO;
import com.keqi.apihu.pj.domain.param.CreateApiGroupParam;

import java.util.List;
public interface ApiGroupService{


    int deleteByPrimaryKey(Long id);

    int insert(ApiGroupDO record);

    int insertSelective(ApiGroupDO record);

    ApiGroupDO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ApiGroupDO record);

    int updateByPrimaryKey(ApiGroupDO record);

    int updateBatch(List<ApiGroupDO> list);

    int batchInsert(List<ApiGroupDO> list);

    /**
     * 增加API分组
     * @param createApiGroupParam createApiGroupParam
     */
    void createApiGroup(CreateApiGroupParam createApiGroupParam);
}
