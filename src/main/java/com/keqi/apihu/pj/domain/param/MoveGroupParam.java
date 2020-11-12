package com.keqi.apihu.pj.domain.param;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MoveGroupParam {

    /**
     * 分组名称
     */
    @ApiModelProperty(value = "分组名称", example = "0", required = true)
    private String name;

    /**
     * 子级分组列表
     */
    @ApiModelProperty(value = "子级分组列表")
    List<MoveGroupParam> subMoveGroupParamList;

    //================================其他参数================================//

    /**
     * 父级分组ID
     */
    @ApiModelProperty(hidden = true)
    private Long parentId;

    /**
     * 祖级列表
     */
    @ApiModelProperty(hidden = true)
    private String ancestors;

    /**
     * 显示顺序
     */
    @ApiModelProperty(hidden = true)
    private Integer orderNum;

    /**
     * 项目Id
     */
    @ApiModelProperty(hidden = true)
    private Long projectId;

    /**
     * API分组ID
     */
    @ApiModelProperty(hidden = true)
    private Long id;
}
