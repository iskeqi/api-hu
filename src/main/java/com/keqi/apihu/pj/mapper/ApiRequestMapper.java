package com.keqi.apihu.pj.mapper;

import com.keqi.apihu.pj.domain.db.ApiRequestDO;
import com.keqi.apihu.pj.domain.param.QueryApiRequestParam;
import com.keqi.apihu.pj.domain.vo.PageApiRequestVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ApiRequestMapper {

    /**
     * 删除API
     *
     * @param id id
     * @return r
     */
    int deleteByPrimaryKey(Long id);

    /**
     * 新增
     *
     * @param record record
     * @return r
     */
    int insert(ApiRequestDO record);

    int insertSelective(ApiRequestDO record);

    /**
     * 根据 id 查询 API
     *
     * @param id id
     * @return r
     */
    ApiRequestDO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ApiRequestDO record);

    int updateByPrimaryKey(ApiRequestDO record);

    int updateBatch(List<ApiRequestDO> list);

    int batchInsert(@Param("list") List<ApiRequestDO> list);

    /**
     * 分页查询总记录
     *
     * @param queryApiRequestParam queryApiRequestParam
     * @return r
     */
    int countByName(QueryApiRequestParam queryApiRequestParam);

    /**
     * 分页查询记录列表
     *
     * @param queryApiRequestParam queryApiRequestParam
     * @return r
     */
    List<PageApiRequestVO> pageApiRequest(QueryApiRequestParam queryApiRequestParam);

    /**
     * 查询指定分组下最大的 orderNum
     *
     * @param apiGroupId apiGroupId
     * @return r
     */
    Integer getMaxOrderNumByApiGroupId(@Param("apiGroupId") Long apiGroupId);

    /**
     * 查询指定分组下最小的 orderNum
     *
     * @param apiGroupId apiGroupId
     * @return r
     */
    Integer getMinOrderNumByApiGroupId(@Param("apiGroupId") Long apiGroupId);

    /**
     * 查询指定分组下且小于 orderNum 的最大的一个 API记录
     *
     * @param apiGroupId apiGroupId
     * @param orderNum   orderNum
     * @return r
     */
    ApiRequestDO findPreviousByApiGroupId(@Param("apiGroupId") Long apiGroupId, @Param("orderNum") Integer orderNum);

    /**
     * 查询指定分组下且大于 orderNum 的最小的一个 API记录
     *
     * @param apiGroupId apiGroupId
     * @param orderNum   orderNum
     * @return r
     */
    ApiRequestDO findNextByApiGroupId(@Param("apiGroupId") Long apiGroupId, @Param("orderNum") Integer orderNum);

    /**
     * 根据 id 修改 orderNum 字段
     *
     * @param orderNum orderNum
     * @param id       id
     * @return r
     */
    int updateOrderNumById(@Param("orderNum") Integer orderNum, @Param("id") Long id);

    /**
     * 根据 id 修改 apiGroupId 和 orderNum 字段
     *
     * @param apiGroupId apiGroupId
     * @param orderNum   orderNum
     * @param id         id
     * @return r
     */
    int updateApiGroupIdAndOrderNumById(@Param("apiGroupId") Long apiGroupId, @Param("orderNum") Integer orderNum, @Param("id") Long id);


    /**
     * 根据apiGroupId 查找该分组的 API 总数
     *
     * @param apiGroupId apiGroupId
     * @return r
     */
    int countByApiGroupId(Long apiGroupId);
}