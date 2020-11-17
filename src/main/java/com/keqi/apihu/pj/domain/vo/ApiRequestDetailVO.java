package com.keqi.apihu.pj.domain.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ApiRequestDetailVO {

    /**
     * API ID(新增时不使用，修改时才使用)
     */
    @ApiModelProperty(value = "API ID(新增时不使用，修改时才使用)", example = "1")
    private Long id;

    /**
     * 接口名称
     */
    @ApiModelProperty(value = "接口名称", example = "新增用户")
    @NotBlank
    private String name;

    /**
     * 接口地址
     */
    @ApiModelProperty(value = "接口地址", example = "/user/create")
    @NotBlank
    private String url;

    /**
     * 请求方式
     */
    @ApiModelProperty(value = "请求方式", example = "POST")
    @NotBlank
    private String requestmethod;

    /**
     * 请求数据类型
     */
    @ApiModelProperty(value = "请求数据类型", example = "application/json")
    @NotBlank
    private String requestContentType;

    /**
     * 响应数据类型
     */
    @ApiModelProperty(value = "响应数据类型", example = "application/json")
    @NotBlank
    private String responseContentType;

    /**
     * 请求示例
     */
    @ApiModelProperty(value = "请求示例")
    @NotBlank
    private String requestDemo;

    /**
     * 响应示例
     */
    @ApiModelProperty(value = "响应示例")
    @NotBlank
    private String responseDemo;

    /**
     * 接口描述
     */
    @ApiModelProperty(value = "接口描述", example = "增加用户")
    @NotBlank
    private String note;

    /**
     * 请求JSON根类型
     */
    @ApiModelProperty(value = "请求JSON根类型", example = "object")
    @NotBlank
    private String requestJsonRootType;

    /**
     * 响应JSON根类型
     */
    @ApiModelProperty(value = "响应JSON根类型", example = "object")
    @NotBlank
    private String responseJsonRootType;

    /**
     * API所属分组ID
     */
    @ApiModelProperty(value = "API所属分组ID", example = "43")
    private Long apiGroupId;

    /**
     * 请求参数列表
     */
    @ApiModelProperty(value = "请求参数列表")
    private List<ApiRequestParamVO> requestParamList;

    /**
     * 响应参数列表
     */
    @ApiModelProperty(value = "响应参数列表")
    private List<ApiRequestParamVO> responseParamList;
    
}
