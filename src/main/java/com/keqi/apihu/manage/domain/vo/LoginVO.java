package com.keqi.apihu.manage.domain.vo;

import com.keqi.apihu.core.pojo.UserTypeEnum;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginVO {

    @ApiModelProperty(value = "accessToken", example = "BRE1JTiIsInByb2plY3RJZCI6bnVsbCwiZX")
    private String accessToken;

    @ApiModelProperty(value = "用户类型", example = "COMMON_USER")
    private UserTypeEnum userType;
}
