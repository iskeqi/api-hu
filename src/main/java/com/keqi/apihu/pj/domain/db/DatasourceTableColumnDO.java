package com.keqi.apihu.pj.domain.db;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 表结构字段列表
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DatasourceTableColumnDO {
    /**
     * 表字段ID
     */
    private Long id;

    /**
     * 所属表ID
     */
    private Long datasourceTableId;

    /**
     * 列名
     */
    private String columnName;

    /**
     * 列类型
     */
    private String columnType;

    /**
     * 列描述
     */
    private String columnComment;
}