package com.keqi.apihu.manage.domain.vo;

import com.keqi.apihu.core.common.UserTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginVO {

    private String accessToken;

    private UserTypeEnum userType;
}
