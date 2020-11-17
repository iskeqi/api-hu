package com.keqi.apihu.pj.domain.param;

import com.keqi.apihu.core.pojo.QueryBaseParam;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Data
public class QueryApiRequestParam extends QueryBaseParam {

    /**
     * 分组ID
     */
    @ApiModelProperty(value = "分组ID", example = "1", required = true)
    private Long apiGroupId;


    //================================其他参数================================//

    @ApiModelProperty(hidden = true)
    private Long projectId;

}
