package com.keqi.apihu.pj.domain.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * API 请求表
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PageApiRequestVO {
    /**
     * API请求ID
     */
    @ApiModelProperty(value = "API请求ID", example = "1")
    private Long id;

    /**
     * 接口名称
     */
    @ApiModelProperty(value = "接口名称", example = "增加用户")
    private String name;

    /**
     * 接口地址
     */
    @ApiModelProperty(value = "接口地址", example = "/user/create")
    private String url;

    /**
     * 请求方式
     */
    @ApiModelProperty(value = "请求方式", example = "POST")
    private String requestmethod;

    /**
     * 接口描述
     */
    @ApiModelProperty(value = "接口描述", example = "增加用户")
    private String note;
}