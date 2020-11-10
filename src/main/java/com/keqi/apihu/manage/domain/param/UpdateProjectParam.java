package com.keqi.apihu.manage.domain.param;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateProjectParam {

    /**
     * 项目ID
     */
    @ApiModelProperty(value = "项目ID", example = "1", required = true)
    @NotNull
    private Long id;

    /**
     * 项目名称
     */
    @ApiModelProperty(value = "项目名称", example = "山东枣庄网格监管项目", required = true)
    @Length(min = 2, max = 32)
    private String projectName;

    /**
     * 项目描述信息
     */
    @ApiModelProperty(value = "项目描述信息", example = "山东枣庄网格监管项目", required = true)
    @Length(min = 2, max = 128)
    private String projectNote;

}
