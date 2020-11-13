package com.keqi.apihu.pj.domain.db;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
    * API 环境表
    */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ApiEnvironmentDO {
    /**
    * 环境ID
    */
    private Long id;

    /**
    * 环境名称
    */
    private String name;

    /**
    * 前置URL
    */
    private String url;

    /**
    * 备注
    */
    private String note;

    /**
    * 项目ID
    */
    private Long projectid;
}