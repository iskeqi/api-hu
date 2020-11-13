package com.keqi.apihu.pj.domain.param;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UpdateApiEnvironmentParam {

    /**
     * 环境ID
     */
    @ApiModelProperty(value = "环境ID", example = "1", required = true)
    @NotNull
    private Long id;

    /**
    * 环境名称
    */
    @ApiModelProperty(value = "环境名称", example = "开发测试环境", required = true)
    @NotBlank
    private String name;

    /**
    * 前置URL
    */
    @ApiModelProperty(value = "前置URL", example = "http://192.168.49.35/api-hu", required = true)
    @NotBlank
    private String url;

    /**
    * 备注
    */
    @ApiModelProperty(value = "备注", example = "此环境用于开发自测和前端联调")
    private String note;

    /**
     * 环境所属 header/query 参数
     */
    @ApiModelProperty(value = "环境所属 header/query 参数")
    List<UpdateApiEnvironmentParamParam> apiEnvironmentParamParamList;
}