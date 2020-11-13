package com.keqi.apihu.pj.mapper;

import com.keqi.apihu.pj.domain.db.ApiRequestDO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ApiRequestMapper {
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
}