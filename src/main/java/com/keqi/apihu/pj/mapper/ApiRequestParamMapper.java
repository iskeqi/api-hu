package com.keqi.apihu.pj.mapper;

import com.keqi.apihu.pj.domain.db.ApiRequestParamDO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ApiRequestParamMapper {
    int deleteByPrimaryKey(Long id);

    /**
     * 增加
     * @param record record
     * @return r
     */
    int insert(ApiRequestParamDO record);

    int insertSelective(ApiRequestParamDO record);

    ApiRequestParamDO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ApiRequestParamDO record);

    int updateByPrimaryKey(ApiRequestParamDO record);

    int updateBatch(List<ApiRequestParamDO> list);

    int batchInsert(@Param("list") List<ApiRequestParamDO> list);
}