package com.keqi.apihu.core.exception;

import java.io.Serializable;

/**
 * 自定义异常类
 *
 * @author keqi
 */
public class BusinessException extends RuntimeException implements Serializable {

    private static final long serialVersionUID = -3046894916874710577L;

    /**
     * 创建异常对象(必须指定异常信息，故在此处屏蔽了空的构造函数)
     *
     * @param message 异常信息
     */
    public BusinessException(String message) {
        super(message);
    }
}
