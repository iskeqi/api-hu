package com.keqi.apihu.pj.domain.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
    * 数据源表
    */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PageDatasourceVO {

    /**
    * 数据源ID
    */
    @ApiModelProperty(value = "数据源ID", example = "1")
    private Long id;

    /**
     * 数据源名称
     */
    @ApiModelProperty(value = "数据源名称", example = "api-hu")
    private String name;

    /**
     * 数据源连接url
     */
    @ApiModelProperty(value = "数据源连接url", example = "jdbc:mysql://10.10.20.200:3306/api-hu?useUnicode=true&characterEncoding=utf8")
    private String url;

    /**
     * 数据源驱动名
     */
    @ApiModelProperty(value = "数据源驱动名", example = "com.mysql.cj.jdbc.Driver")
    private String driverClassName;

    /**
     * 数据源用户名
     */
    @ApiModelProperty(value = "数据源用户名", example = "root")
    private String username;

    /**
     * 数据源密码
     */
    @ApiModelProperty(value = "数据源密码", example = "123456")
    private String password;
}