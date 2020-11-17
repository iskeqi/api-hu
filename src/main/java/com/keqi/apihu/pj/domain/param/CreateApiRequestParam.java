package com.keqi.apihu.pj.domain.param;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.util.List;

/**
    * API 请求表
    */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateApiRequestParam {

    /**
     * API ID(新增时不使用，修改时才使用)
     */
    @ApiModelProperty(value = "API ID(新增时不使用，修改时才使用)", example = "1")
    private Long id;

    /**
    * 接口名称
    */
    @ApiModelProperty(value = "接口名称", example = "新增用户", required = true)
    @NotBlank
    private String name;

    /**
    * 接口地址
    */
    @ApiModelProperty(value = "接口地址", example = "/user/create", required = true)
    @NotBlank
    private String url;

    /**
    * 请求方式
    */
    @ApiModelProperty(value = "请求方式", example = "POST", required = true)
    @NotBlank
    private String requestmethod;

    /**
    * 请求数据类型
    */
    @ApiModelProperty(value = "请求数据类型", example = "application/json", required = true)
    @NotBlank
    private String requestContentType;

    /**
    * 响应数据类型
    */
    @ApiModelProperty(value = "响应数据类型", example = "application/json", required = true)
    @NotBlank
    private String responseContentType;

    /**
    * 请求示例
    */
    @ApiModelProperty(value = "请求示例", required = true)
    @NotBlank
    private String requestDemo;

    /**
    * 响应示例
    */
    @ApiModelProperty(value = "响应示例", required = true)
    @NotBlank
    private String responseDemo;

    /**
    * 接口描述
    */
    @ApiModelProperty(value = "接口描述", example = "增加用户", required = true)
    @NotBlank
    private String note;

    /**
    * 请求JSON根类型
    */
    @ApiModelProperty(value = "请求JSON根类型", example = "object", required = true)
    @NotBlank
    private String requestJsonRootType;

    /**
    * 响应JSON根类型
    */
    @ApiModelProperty(value = "响应JSON根类型", example = "object", required = true)
    @NotBlank
    private String responseJsonRootType;

    /**
     * API所属分组ID
     */
    @ApiModelProperty(value = "API所属分组ID", example = "43", required = true)
    private Long apiGroupId;

    /**
     * 请求参数列表
     */
    @ApiModelProperty(value = "请求参数列表", required = true)
    private List<CreateApiRequestParamParam> requestParamList;

    /**
     * 响应参数列表
     */
    @ApiModelProperty(value = "响应参数列表", required = true)
    private List<CreateApiRequestParamParam> responseParamList;
}