package com.keqi.apihu.pj.domain.db;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
    * API分组表
    */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ApiGroupDO {
    /**
    * API分组ID
    */
    private Long id;

    /**
    * 父级分组ID
    */
    private Integer parentId;

    /**
    * 祖级列表
    */
    private String ancestors;

    /**
    * 分组名称
    */
    private String name;

    /**
    * 显示顺序
    */
    private Integer orderNum;
}