package com.keqi.apihu.manage.domain.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageAccountVO {

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
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;

    /**
     * 用户拥有项目数量
     */
    private Integer numberOfProjectsOwned;
}
