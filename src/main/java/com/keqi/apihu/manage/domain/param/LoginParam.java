package com.keqi.apihu.manage.domain.param;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginParam {

    @Length(min = 2, max = 32)
    private String account;

    @Length(min = 2, max = 32)
    private String password;
}
