package com.keqi.apihu.manage.domain.param;

import io.swagger.annotations.ApiModelProperty;
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
    @ApiModelProperty(value = "用户名", example = "xiaoming", required = true)
    @NotBlank
    @Length(min = 2, max = 32)
    private String account;

    /**
     * 姓名
     */
    @ApiModelProperty(value = "姓名", example = "小明", required = true)
    @NotBlank
    @Length(min = 2, max = 32)
    private String nickName;

    /**
     * 岗位
     */
    @ApiModelProperty(value = "岗位", example = "后端开发", required = true)
    @NotBlank
    @Length(min = 2, max = 32)
    private String post;

}
