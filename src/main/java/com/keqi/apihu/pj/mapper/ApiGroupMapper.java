package com.keqi.apihu.pj.mapper;

import com.keqi.apihu.pj.domain.db.ApiGroupDO;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ApiGroupMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ApiGroupDO record);

    int insertSelective(ApiGroupDO record);

    ApiGroupDO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ApiGroupDO record);

    int updateByPrimaryKey(ApiGroupDO record);

    int updateBatch(List<ApiGroupDO> list);

    int batchInsert(@Param("list") List<ApiGroupDO> list);
}