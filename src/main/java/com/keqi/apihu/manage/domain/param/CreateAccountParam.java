package com.keqi.apihu.manage.domain.param;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateAccountParam {

    /**
     * 用户名
     */
    @NotBlank
    @Length(min = 2, max = 32)
    private String account;

    /**
     * 姓名
     */
    @NotBlank
    @Length(min = 2, max = 32)
    private String nickName;

    /**
     * 岗位
     */
    @NotBlank
    @Length(min = 2, max = 32)
    private String post;

}
