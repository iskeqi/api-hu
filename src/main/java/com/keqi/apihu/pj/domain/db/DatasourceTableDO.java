package com.keqi.apihu.pj.domain.db;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
    * 数据源表结构表
    */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DatasourceTableDO {
    /**
    * 表结构ID
    */
    private Long id;

    /**
    * 数据源ID
    */
    private Long datasourceId;

    /**
    * 表名称
    */
    private String tableName;

    /**
    * 表备注
    */
    private String tableComment;

    //================================其他参数================================//

    private List<DatasourceTableColumnDO> datasourceTableColumnDOList;

}