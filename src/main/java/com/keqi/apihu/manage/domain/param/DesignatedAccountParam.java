package com.keqi.apihu.manage.domain.param;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DesignatedAccountParam {

    @ApiModelProperty(value = "项目ID", example = "1", required = true)
    @NotNull
    private Long projectId;

    @ApiModelProperty(value = "人员ID列表", example = "[1,2,3,4]", required = true)
    @NotNull
    @Size
    private List<Long> accountIdList;
}
