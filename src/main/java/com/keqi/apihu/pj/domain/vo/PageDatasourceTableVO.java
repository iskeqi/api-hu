package com.keqi.apihu.pj.domain.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
    * 数据源表结构表
    */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PageDatasourceTableVO {

    /**
    * 表结构ID
    */
    @ApiModelProperty(value = "表结构ID", example = "1")
    private Long id;

    /**
    * 数据源ID
    */
    @ApiModelProperty(value = "数据源ID", example = "1")
    private Long datasourceId;

    /**
    * 表名称
    */
    @ApiModelProperty(value = "表名称", example = "sys_account")
    private String tableName;

    /**
    * 表备注
    */
    @ApiModelProperty(value = "表备注", example = "用户表")
    private String tableComment;

}