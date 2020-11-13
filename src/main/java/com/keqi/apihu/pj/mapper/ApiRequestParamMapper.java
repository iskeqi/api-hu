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

    /**
     * 根据 apiRequestId 删除所有请求和相应参数
     * @param apiRequestId apiRequestId
     * @return r
     */
    int deleteByApiRequestId(@Param("apiRequestId")Long apiRequestId);


}