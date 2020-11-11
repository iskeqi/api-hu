package com.keqi.apihu.pj.domain.vo;

import io.swagger.annotations.ApiModelProperty;
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
public class PageDatasourceTableColumnVO {
    /**
    * 表字段ID
    */
    @ApiModelProperty(value = "表字段ID", example = "1")
    private Long id;

    /**
    * 所属表ID
    */
    @ApiModelProperty(value = "所属表ID", example = "1")
    private Long datasourceTableId;

    /**
    * 列名
    */
    @ApiModelProperty(value = "列名", example = "account")
    private String columnName;

    /**
    * 列类型
    */
    @ApiModelProperty(value = "列类型", example = "varchar")
    private String columnType;

    /**
    * 列描述
    */
    @ApiModelProperty(value = "列描述", example = "账号")
    private String columnComment;
}