package com.keqi.apihu.manage.domain.param;

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
     * 主键
     */
    @NotNull
    private Long id;

    /**
     * 项目名称
     */
    @Length(min = 2, max = 32)
    private String projectName;

    /**
     * 项目描述信息
     */
    @Length(min = 2, max = 128)
    private String projectNote;

}
