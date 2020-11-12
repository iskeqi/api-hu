package com.keqi.apihu.pj.domain.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
    * API分组表
    */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PageApiGroupVO {

    /**
    * API分组ID
    */
    @ApiModelProperty(value = "API分组ID", example = "1")
    private Long id;

    /**
    * 父级分组ID
    */
    @ApiModelProperty(value = "父级分组ID", example = "0")
    private Long parentId;

    /**
    * 祖级列表
    */
    @ApiModelProperty(value = "祖级列表", example = "0")
    private String ancestors;

    /**
    * 分组名称
    */
    @ApiModelProperty(value = "分组名称", example = "0")
    private String name;

    /**
    * 显示顺序
    */
    @ApiModelProperty(value = "显示顺序", example = "1")
    private Integer orderNum;

    /**
     * 子集分组列表
     */
    @ApiModelProperty(value = "子集分组列表")
    List<PageApiGroupVO> pageApiGroupVOList;

    /**
     * 子集API列表
     */
    @ApiModelProperty(value = "子集API列表")
    List<ApiGroupListVO> apiGroupListVOList;
}