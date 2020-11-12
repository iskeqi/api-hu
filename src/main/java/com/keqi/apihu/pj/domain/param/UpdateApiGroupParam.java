package com.keqi.apihu.pj.domain.param;

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
public class UpdateApiGroupParam {

    /**
    * 分组ID
    */
    @ApiModelProperty(value = "分组ID", example = "1")
    private Long id;

    /**
    * 分组名称
    */
    @ApiModelProperty(value = "分组名称", example = "系统管理模块", required = true)
    @NotBlank
    private String name;
}