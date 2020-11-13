package com.keqi.apihu.pj.service;

import com.keqi.apihu.core.common.AjaxPageEntity;
import com.keqi.apihu.pj.domain.db.ApiRequestDO;
import com.keqi.apihu.pj.domain.param.CreateApiRequestParam;
import com.keqi.apihu.pj.domain.param.QueryApiRequestParam;
import com.keqi.apihu.pj.domain.vo.PageApiRequestVO;

import java.util.List;

public interface ApiRequestService {

    /**
     * 删除API
     * @param id id
     * @return r
     */
    int deleteByPrimaryKey(Long id);

    int insert(ApiRequestDO record);

    int insertSelective(ApiRequestDO record);

    ApiRequestDO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ApiRequestDO record);

    /**
     * 修改API
     * @param updateApiRequestParam updateApiRequestParam
     * @return r
     */
    void updateByPrimaryKey(CreateApiRequestParam updateApiRequestParam);

    int updateBatch(List<ApiRequestDO> list);

    int batchInsert(List<ApiRequestDO> list);

    /**
     * 增加API
     * @param createApiRequestParam createApiRequestParam
     */
    void createApiRequest(CreateApiRequestParam createApiRequestParam);

    /**
     * 分页查询API列表
     * @param queryApiRequestParam queryApiRequestParam
     * @return r
     */
    AjaxPageEntity<PageApiRequestVO> pageApiRequest(QueryApiRequestParam queryApiRequestParam);
}
