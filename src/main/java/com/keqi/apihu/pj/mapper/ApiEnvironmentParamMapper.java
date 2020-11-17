package com.keqi.apihu.pj.mapper;

import com.keqi.apihu.pj.domain.db.ApiEnvironmentParamDO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ApiEnvironmentParamMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ApiEnvironmentParamDO record);

    int insertSelective(ApiEnvironmentParamDO record);

    ApiEnvironmentParamDO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ApiEnvironmentParamDO record);

    int updateByPrimaryKey(ApiEnvironmentParamDO record);

    int updateBatch(List<ApiEnvironmentParamDO> list);

    /**
     * 批量增加
     *
     * @param list list
     * @return r
     */
    int batchInsert(@Param("list") List<ApiEnvironmentParamDO> list);

    /**
     * 根据 apiEnvironmentId 删除对应的参数
     *
     * @param apiEnvironmentId apiEnvironmentId
     * @return r
     */
    int deleteByApiEnvironmentId(@Param("apiEnvironmentId") Long apiEnvironmentId);


}