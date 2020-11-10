package com.keqi.apihu.pj.mapper;

import com.keqi.apihu.pj.domain.db.DatasourceDO;
import org.apache.ibatis.annotations.Param;

public interface DatasourceMapper {
    int deleteByPrimaryKey(Long id);

    int insert(DatasourceDO record);

    int insertSelective(DatasourceDO record);

    DatasourceDO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(DatasourceDO record);

    int updateByPrimaryKey(DatasourceDO record);

    /**
     * 判断同名数据源是否存在
     * @param name name
     * @param projectId projectId
     * @return r
     */
    int dataSourceExist(@Param("name") String name, @Param("projectId") Long projectId);
}