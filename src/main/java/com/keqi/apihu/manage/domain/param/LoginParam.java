package com.keqi.apihu.manage.domain.param;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginParam {

    @ApiModelProperty(value = "账号", example = "xiaoming", required = true)
    @Length(min = 2, max = 32)
    private String account;

    @ApiModelProperty(value = "密码", example = "123456", required = true)
    @Length(min = 2, max = 32)
    private String password;
}
