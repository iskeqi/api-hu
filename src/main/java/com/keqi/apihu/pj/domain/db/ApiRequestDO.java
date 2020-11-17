package com.keqi.apihu.pj.domain.db;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * API 请求表
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ApiRequestDO {
    /**
     * API请求ID
     */
    private Long id;

    /**
     * 接口名称
     */
    private String name;

    /**
     * 接口地址
     */
    private String url;

    /**
     * 请求方式
     */
    private String requestmethod;

    /**
     * 请求数据类型
     */
    private String requestContentType;

    /**
     * 响应数据类型
     */
    private String responseContentType;

    /**
     * 请求示例
     */
    private String requestDemo;

    /**
     * 响应示例
     */
    private String responseDemo;

    /**
     * 接口描述
     */
    private String note;

    /**
     * 请求JSON根类型
     */
    private String requestJsonRootType;

    /**
     * 响应JSON根类型
     */
    private String responseJsonRootType;

    /**
     * 项目ID
     */
    private Long projectId;

    /**
     * 所属分组ID
     */
    private Long apiGroupId;

    /**
     * 显示顺序
     */
    private Integer orderNum;
}