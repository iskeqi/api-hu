package com.keqi.apihu.pj.domain.db;

import com.keqi.apihu.pj.domain.ParamType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * API环境参数表
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ApiEnvironmentParamDO {
    /**
     * 参数ID
     */
    private Long id;

    /**
     * 参数名称
     */
    private String paramName;

    /**
     * 参数值
     */
    private String paramValue;

    /**
     * 参数备注
     */
    private String paramNote;

    /**
     * 参数类型（HEADER/QUERY）
     */
    private ParamType paramType;

    /**
     * 所属环境ID
     */
    private Long apiEnvironmentId;
}