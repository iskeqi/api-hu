package com.keqi.apihu.pj.domain.param;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.util.List;

/**
    * API 请求的请求参数和相应参数
    */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UpdateApiRequestParamParam {

    /**
    * 参数名称
    */
    @ApiModelProperty(value = "参数名称", example = "username", required = true)
    @NotBlank
    private String name;

    /**
    * 参数说明
    */
    @ApiModelProperty(value = "参数说明", example = "用户名", required = true)
    @NotBlank
    private String note;

    /**
    * 是否必须（必须 Y，非必须N）
    */
    @ApiModelProperty(value = "是否必须（必须 Y，非必须N）", example = "Y", required = true)
    @NotBlank
    private String required;

    /**
    * 参数类型(string,int等)
    */
    @ApiModelProperty(value = "参数类型(string,int等)", example = "string", required = true)
    @NotBlank
    private String type;

    /**
    * 示例
    */
    @ApiModelProperty(value = "示例", example = "xiaoming", required = true)
    @NotBlank
    private String example;

    /**
     * 子级参数列表
     */
    @ApiModelProperty(value = "子级参数列表")
    private List<UpdateApiRequestParamParam> subList;

    //================================其他参数================================//

    /**
     * 参数ID
     */
    @ApiModelProperty(hidden = true)
    private Long id;

    /**
     * 请求/响应（REQUEST/RESPONSE）
     */
    @ApiModelProperty(hidden = true)
    private String paramType;

    /**
     * 请求API ID
     */
    @ApiModelProperty(hidden = true)
    private Long apiRequestId;

    /**
     * 父级参数ID(顶级参数的 parentId 置为0)
     */
    @ApiModelProperty(hidden = true)
    private Long parentId;

    /**
     * 参数排序字段
     */
    @ApiModelProperty(hidden = true)
    private Integer orderNum;
}