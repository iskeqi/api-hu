package com.keqi.apihu.pj.domain.param;

import com.keqi.apihu.pj.domain.ParamType;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateApiEnvironmentParamParam {

    /**
    * 参数名称
    */
    @ApiModelProperty(value = "参数名称", example = "accessToken", required = true)
    @NotBlank
    private String paramName;

    /**
    * 参数值
    */
    @ApiModelProperty(value = "参数值", example = "GUiOiJTVVBFUl9BRE1JTiIsInByb2p", required = true)
    @NotBlank
    private String paramValue;

    /**
    * 参数备注
    */
    @ApiModelProperty(value = "参数备注", example = "访问accessToken")
    private String paramNote;

    /**
    * 参数类型（HEADER/QUERY）
    */
    @ApiModelProperty(value = "参数类型", example = "HEADER", required = true)
    @NotBlank
    private ParamType paramType;
}