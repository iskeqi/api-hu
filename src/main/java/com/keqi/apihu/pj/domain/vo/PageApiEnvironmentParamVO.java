package com.keqi.apihu.pj.domain.vo;

import com.keqi.apihu.pj.domain.ParamType;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PageApiEnvironmentParamVO {

    /**
     * 环境参数ID
     */
    @ApiModelProperty(value = "环境参数ID", example = "1")
    private Long id;

    /**
    * 参数名称
    */
    @ApiModelProperty(value = "参数名称", example = "accessToken")
    private String paramName;

    /**
    * 参数值
    */
    @ApiModelProperty(value = "参数值", example = "GUiOiJTVVBFUl9BRE1JTiIsInByb2p")
    private String paramValue;

    /**
    * 参数备注
    */
    @ApiModelProperty(value = "参数备注", example = "访问accessToken")
    private String paramNote;

    /**
    * 参数类型（HEADER/QUERY）
    */
    @ApiModelProperty(value = "参数类型", example = "HEADER")
    private ParamType paramType;
}