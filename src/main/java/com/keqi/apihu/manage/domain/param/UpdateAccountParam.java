package com.keqi.apihu.manage.domain.param;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateAccountParam {

    /**
     * 主键
     */
    @NotNull
    private Long id;

    /**
     * 姓名
     */
    @Length(min = 2, max = 32)
    private String nickName;

    /**
     * 岗位
     */
    @Length(min = 2, max = 32)
    private String post;

}
