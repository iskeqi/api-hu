package com.keqi.apihu.pj.mapper;

import com.keqi.apihu.pj.domain.db.ApiRequestDO;
import com.keqi.apihu.pj.domain.param.QueryApiRequestParam;
import com.keqi.apihu.pj.domain.vo.PageApiRequestVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ApiRequestMapper {

    /**
     * 删除API
     * @param id id
     * @return r
     */
    int deleteByPrimaryKey(Long id);

    /**
     * 新增
     * @param record record
     * @return r
     */
    int insert(ApiRequestDO record);

    int insertSelective(ApiRequestDO record);

    ApiRequestDO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ApiRequestDO record);

    int updateByPrimaryKey(ApiRequestDO record);

    int updateBatch(List<ApiRequestDO> list);

    int batchInsert(@Param("list") List<ApiRequestDO> list);

    /**
     * 分页查询总记录
     * @param queryApiRequestParam queryApiRequestParam
     * @return r
     */
    int countByName(QueryApiRequestParam queryApiRequestParam);

    /**
     * 分页查询记录列表
     * @param queryApiRequestParam queryApiRequestParam
     * @return r
     */
    List<PageApiRequestVO> pageApiRequest(QueryApiRequestParam queryApiRequestParam);
}