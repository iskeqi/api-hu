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
public class PageAccountVO {

    /**
     * 主键
     */
    @ApiModelProperty(value = "用户ID", example = "2")
    private Long id;

    /**
     * 用户名
     */
    @ApiModelProperty(value = "用户名", example = "xiaoming")
    private String account;

    /**
     * 姓名
     */
    @ApiModelProperty(value = "姓名", example = "小明")
    private String nickName;

    /**
     * 岗位
     */
    @ApiModelProperty(value = "岗位", example = "后端开发")
    private String post;

    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间", example = "2020-11-10 10:30:23")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;

    /**
     * 用户拥有项目数量
     */
    @ApiModelProperty(value = "用户拥有项目数量", example = "6")
    private Integer numberOfProjectsOwned;
}
