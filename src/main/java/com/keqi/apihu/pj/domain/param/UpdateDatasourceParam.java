package com.keqi.apihu.pj.domain.param;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UpdateDatasourceParam {

    /**
     * 数据源ID
     */
    @ApiModelProperty(value = "数据源ID", example = "1", required = true)
    @NotNull
    private Long id;

    /**
    * 数据源名称
    */
    @ApiModelProperty(value = "数据源名称", example = "api-hu", required = true)
    @NotBlank
    private String name;

    /**
    * 数据源连接url
    */
    @ApiModelProperty(value = "数据源连接url", example = "jdbc:mysql://10.10.20.200:3306/api-hu?useUnicode=true&characterEncoding=utf8&useSSL=true&serverTimezone=GMT%2B8&allowMultiQueries=true", required = true)
    @NotBlank
    private String url;

    /**
    * 数据源驱动名
    */
    @ApiModelProperty(value = "数据源驱动名", example = "com.mysql.cj.jdbc.Driver", required = true)
    @NotBlank
    private String driverClassName;

    /**
    * 数据源用户名
    */
    @ApiModelProperty(value = "数据源用户名", example = "root", required = true)
    @NotBlank
    private String username;

    /**
    * 数据源密码
    */
    @ApiModelProperty(value = "数据源密码", example = "123456", required = true)
    @NotBlank
    private String password;
}