package com.keqi.apihu.manage.domain.db;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * 用户表
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountDO {
    /**
     * 主键
     */
    private Long id;

    /**
     * 用户名
     */
    private String account;

    /**
     * 姓名
     */
    private String nickName;

    /**
     * 岗位
     */
    private String post;

    /**
     * 密码
     */
    private String password;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 修改时间
     */
    private LocalDateTime updateTime;
}