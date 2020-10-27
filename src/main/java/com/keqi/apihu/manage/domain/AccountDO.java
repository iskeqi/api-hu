package com.keqi.apihu.manage.domain;

import java.io.Serializable;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
    * 用户表
    */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AccountDO implements Serializable {
    /**
    * 主键
    */
    private Long id;

    /**
    * 账号
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
    private Date createTime;

    /**
    * 修改时间
    */
    private Date updateTime;

    private static final long serialVersionUID = 1L;
}