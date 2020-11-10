package com.keqi.apihu.manage.domain.db;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
    * 项目表
    */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProjectDO {
    /**
    * 主键
    */
    private Long id;

    /**
    * 项目名称
    */
    private String projectName;

    /**
    * 项目描述信息
    */
    private String projectNote;

    /**
    * 逻辑删除(Y：未删除，N：已删除)
    */
    private String deleteFlag;

    /**
    * 创建时间
    */
    private LocalDateTime createTime;

    /**
    * 修改时间
    */
    private LocalDateTime updateTime;
}