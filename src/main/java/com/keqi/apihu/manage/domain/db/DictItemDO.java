package com.keqi.apihu.manage.domain.db;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 系统管理-字典表
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DictItemDO {
    /**
     * 字典记录主键
     */
    private Long id;

    /**
     * 字典类型编码
     */
    private String typeCode;

    /**
     * 字典类型名称
     */
    private String typeName;

    /**
     * 字典项编码
     */
    private String itemCode;

    /**
     * 字典项值
     */
    private String itemValue;

    /**
     * 字典项排序
     */
    private Integer itemSort;

    /**
     * 字典项备注字段
     */
    private String itemRemark;

    /**
     * 字典项样式属性(备用字段)
     */
    private String itemCss;

    /**
     * 逻辑删除字段（Y 未删除，N 已删除）
     */
    private String deleteFlag;
}