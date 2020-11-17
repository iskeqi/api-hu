package com.keqi.apihu.pj.service;

import com.keqi.apihu.core.common.AjaxPageEntity;
import com.keqi.apihu.pj.domain.Direction;
import com.keqi.apihu.pj.domain.db.ApiRequestDO;
import com.keqi.apihu.pj.domain.param.CreateApiRequestParam;
import com.keqi.apihu.pj.domain.param.QueryApiRequestParam;
import com.keqi.apihu.pj.domain.vo.ApiRequestDetailVO;
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

    /**
     * 查询API详情
     * @param id id
     * @return r
     */
    ApiRequestDetailVO selectByPrimaryKey(Long id);

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

    /**
     * 在本级移动API
     * @param id id
     * @param direction direction
     */
    void moveApi(Long id, Direction direction);

    /**
     * 移动API到其他分组下
     * @param id id
     * @param apiGroupId apiGroupId
     */
    void moveApiToOtherGroup(Long id, Long apiGroupId);
}
