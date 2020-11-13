package com.keqi.apihu.pj.domain.db;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
    * API 请求的请求参数和相应参数
    */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ApiRequestParamDO {
    /**
    * API请求或响应参数ID
    */
    private Long id;

    /**
    * 参数名称
    */
    private String name;

    /**
    * 参数说明
    */
    private String note;

    /**
    * 是否必须（必须 Y，非必须N）
    */
    private String required;

    /**
    * 参数类型(string,int等)
    */
    private String type;

    /**
    * 示例
    */
    private String example;

    /**
    * 请求/响应（REQUEST/RESPONSE）
    */
    private String paramType;

    /**
    * 请求API ID
    */
    private Long apiRequestId;

    /**
    * 父级参数ID(顶级参数的 parentId 置为0)
    */
    private Long parentId;

    /**
    * 参数排序字段
    */
    private Long orderNum;
}