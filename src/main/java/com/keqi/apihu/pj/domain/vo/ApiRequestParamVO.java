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
public class ApiRequestParamVO {

    /**
     * 参数ID
     */
    @ApiModelProperty(value = "参数ID", example = "1")
    private Long id;

    /**
     * 参数名称
     */
    @ApiModelProperty(value = "参数名称", example = "username")
    @NotBlank
    private String name;

    /**
     * 参数说明
     */
    @ApiModelProperty(value = "参数说明", example = "用户名")
    @NotBlank
    private String note;

    /**
     * 是否必须（必须 Y，非必须N）
     */
    @ApiModelProperty(value = "是否必须（必须 Y，非必须N）", example = "Y")
    @NotBlank
    private String required;

    /**
     * 参数类型(string,int等)
     */
    @ApiModelProperty(value = "参数类型(string,int等)", example = "string")
    @NotBlank
    private String type;

    /**
     * 示例
     */
    @ApiModelProperty(value = "示例", example = "xiaoming")
    @NotBlank
    private String example;

    /**
     * 子级参数列表
     */
    @ApiModelProperty(value = "子级参数列表")
    private List<ApiRequestParamVO> subList;

    //================================其他参数================================//

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
    private Long orderNum;
}
