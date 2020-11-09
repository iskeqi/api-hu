package com.keqi.apihu.manage.domain.param;

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
    @Length(min = 2, max = 32)
    private String projectName;

    /**
     * 项目描述信息
     */
    @Length(min = 2, max = 128)
    private String projectNote;

}
