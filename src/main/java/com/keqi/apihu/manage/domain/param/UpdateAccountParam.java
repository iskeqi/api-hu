package com.keqi.apihu.manage.domain.param;

import io.swagger.annotations.ApiModelProperty;
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
     * 用户ID
     */
    @ApiModelProperty(value = "用户ID", example = "1", required = true)
    @NotNull
    private Long id;

    /**
     * 姓名
     */
    @ApiModelProperty(value = "姓名", example = "xiaoming", required = true)
    @Length(min = 2, max = 32)
    private String nickName;

    /**
     * 岗位
     */
    @ApiModelProperty(value = "岗位", example = "前端开发", required = true)
    @Length(min = 2, max = 32)
    private String post;

}
