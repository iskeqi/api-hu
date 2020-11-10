package com.keqi.apihu.manage.domain.param;

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
public class CreateDictItemParam {

    /**
    * 字典类型编码
    */
    @ApiModelProperty(value = "字典类型编码", example = "gender", required = true)
    @NotBlank
    private String typeCode;

    /**
    * 字典类型名称
    */
    @ApiModelProperty(value = "字典类型名称", example = "性别", required = true)
    @NotBlank
    private String typeName;

    /**
    * 字典项编码
    */
    @ApiModelProperty(value = "字典项编码", example = "man", required = true)
    @NotBlank
    private String itemCode;

    /**
    * 字典项值
    */
    @ApiModelProperty(value = "字典项值", example = "男", required = true)
    @NotBlank
    private String itemValue;

    /**
    * 字典项排序
    */
    @ApiModelProperty(value = "字典项排序", example = "1", required = true)
    @NotNull
    private Integer itemSort;

    /**
    * 字典项备注字段
    */
    @ApiModelProperty(value = "字典项备注字段", example = "男性", required = true)
    @NotBlank
    private String itemRemark;

    /**
    * 字典项样式属性(备用字段)
    */
    @ApiModelProperty(value = "字典项样式属性(备用字段)", example = "备用字段", required = true)
    @NotBlank
    private String itemCss;
}