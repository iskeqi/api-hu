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
public class QueryDatasourceParam extends QueryBaseParam {





    //================================其他参数================================//

    @ApiModelProperty(hidden = true)
    private Long projectId;

}
