package com.keqi.apihu.pj.mapper;

import com.keqi.apihu.pj.domain.db.DatasourceTableDO;
import org.apache.ibatis.annotations.Param;

import java.util.Collection;
import java.util.List;

public interface DatasourceTableMapper {
    int deleteByPrimaryKey(Long id);

    int insert(DatasourceTableDO record);

    int insertSelective(DatasourceTableDO record);

    DatasourceTableDO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(DatasourceTableDO record);

    int updateByPrimaryKey(DatasourceTableDO record);

    /**
     * 通过 dataSourceId 查找所属全部表结构列表
     *
     * @param dataSourceId dataSourceId
     * @return r
     */
    List<DatasourceTableDO> findAllByDatasourceId(@Param("dataSourceId") Long dataSourceId);

    /**
     * 根据 id 列表批量删除数据源表
     *
     * @param idCollection idCollection
     * @return r
     */
    int deleteByIds(@Param("idCollection") Collection<Long> idCollection);

    /**
     * 根据数据源id删除对应的记录
     *
     * @param datasourceId datasourceId
     * @return r
     */
    int deleteByDatasourceId(@Param("datasourceId") Long datasourceId);

    /**
     * 批量新增数据源表
     *
     * @param list list
     * @return r
     */
    int batchInsert(@Param("list") List<DatasourceTableDO> list);

}