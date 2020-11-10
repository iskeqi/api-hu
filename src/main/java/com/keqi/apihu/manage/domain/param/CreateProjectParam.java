package com.keqi.apihu.manage.domain.param;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateProjectParam {

    /**
     * 项目名称
     */
    @ApiModelProperty(value = "项目名称", example = "网格监管", required = true)
    @Length(min = 2, max = 32)
    private String projectName;

    /**
     * 项目描述信息
     */
    @ApiModelProperty(value = "项目描述信息", example = "山东枣庄网格监管项目", required = true)
    @Length(min = 2, max = 128)
    private String projectNote;

}
