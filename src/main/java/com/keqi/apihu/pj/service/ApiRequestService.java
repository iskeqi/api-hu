package com.keqi.apihu.pj.service;

import com.keqi.apihu.pj.domain.db.ApiRequestDO;
import com.keqi.apihu.pj.domain.param.CreateApiRequestParam;

import java.util.List;

public interface ApiRequestService {


    int deleteByPrimaryKey(Long id);

    int insert(ApiRequestDO record);

    int insertSelective(ApiRequestDO record);

    ApiRequestDO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ApiRequestDO record);

    int updateByPrimaryKey(ApiRequestDO record);

    int updateBatch(List<ApiRequestDO> list);

    int batchInsert(List<ApiRequestDO> list);

    /**
     * 增加API
     * @param createApiRequestParam createApiRequestParam
     */
    void createApiRequest(CreateApiRequestParam createApiRequestParam);
}
