package com.keqi.apihu.manage.domain.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageProjectVO {

    /**
     * 项目ID
     */
    @ApiModelProperty(value = "项目ID", example = "1")
    private Long id;

    /**
     * 项目名称
     */
    @ApiModelProperty(value = "项目名称", example = "网格监管")
    private String projectName;

    /**
     * 项目描述信息
     */
    @ApiModelProperty(value = "项目描述信息", example = "山东枣庄网格监管项目")
    private String projectNote;

    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间", example = "2020-11-10 13:37:28")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;

    /**
     * 协作人员数量
     */
    @ApiModelProperty(value = "协作人员数量", example = "4")
    private Integer numberOfCollaborators;

    /**
     * API 总数
     */
    @ApiModelProperty(value = "API 总数", example = "45")
    private Integer apiTotal;

}
