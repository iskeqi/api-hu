package com.keqi.apihu.pj.mapper;

import com.keqi.apihu.pj.domain.db.DatasourceTableColumnDO;
import org.apache.ibatis.annotations.Param;

import java.util.Collection;
import java.util.List;

public interface DatasourceTableColumnMapper {
    int deleteByPrimaryKey(Long id);

    int insert(DatasourceTableColumnDO record);

    int insertSelective(DatasourceTableColumnDO record);

    DatasourceTableColumnDO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(DatasourceTableColumnDO record);

    int updateByPrimaryKey(DatasourceTableColumnDO record);

    /**
     * 通过 datasourceTableId 列表查找对应的数据源表的所有列
     *
     * @param datasourceTableIdCollection datasourceTableIdCollection
     * @return r
     */
    List<DatasourceTableColumnDO> findAllByDatasourceTableIdIn(@Param("datasourceTableIdCollection") Collection<Long> datasourceTableIdCollection);

    /**
     * 通过 datasourceTableId 列表删除所有对应的记录
     *
     * @param datasourceTableIdCollection datasourceTableIdCollection
     * @return r
     */
    int deleteByDatasourceTableIdIn(@Param("datasourceTableIdCollection") Collection<Long> datasourceTableIdCollection);

    /**
     * 批量新增数据源表列
     *
     * @param list list
     * @return r
     */
    int batchInsert(@Param("list") List<DatasourceTableColumnDO> list);
}