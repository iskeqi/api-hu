package com.keqi.apihu.manage.domain.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DictItemVO {

    /**
     * 字典记录ID
     */
    @ApiModelProperty(value = "字典记录ID", example = "1")
    private Long id;

    /**
     * 字典类型编码
     */
    @ApiModelProperty(value = "字典类型编码", example = "gender")
    private String typeCode;

    /**
     * 字典类型名称
     */
    @ApiModelProperty(value = "字典类型名称", example = "性别")
    private String typeName;

    /**
     * 字典项编码
     */
    @ApiModelProperty(value = "字典项编码", example = "man")
    private String itemCode;

    /**
     * 字典项值
     */
    @ApiModelProperty(value = "字典项值", example = "男")
    private String itemValue;

    /**
     * 字典项排序
     */
    @ApiModelProperty(value = "字典项排序", example = "1")
    private Integer itemSort;

    /**
     * 字典项备注字段
     */
    @ApiModelProperty(value = "字典项备注字段", example = "男性")
    private String itemRemark;

    /**
     * 字典项样式属性(备用字段)
     */
    @ApiModelProperty(value = "字典项样式属性(备用字段)", example = "备用字段")
    private String itemCss;
}