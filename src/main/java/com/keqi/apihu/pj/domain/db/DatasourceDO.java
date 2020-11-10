package com.keqi.apihu.pj.domain.db;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
    * 数据源表
    */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DatasourceDO {
    /**
    * 数据源ID
    */
    private Long id;

    /**
    * 数据源名称
    */
    private String name;

    /**
    * 数据源连接url
    */
    private String url;

    /**
    * 数据源驱动名
    */
    private String driverClassName;

    /**
    * 数据源用户名
    */
    private String username;

    /**
    * 数据源密码
    */
    private String password;

    /**
    * 项目ID
    */
    private Long projectid;
}