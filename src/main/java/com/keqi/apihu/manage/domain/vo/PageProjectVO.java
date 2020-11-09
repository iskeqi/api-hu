package com.keqi.apihu.manage.domain.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageProjectVO {

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
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;

    /**
     * 协作人员数量
     */
    private Integer numberOfCollaborators;

    /**
     * API 总数
     */
    private Integer apiTotal;

}
