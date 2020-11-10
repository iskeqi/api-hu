package com.keqi.apihu.core.common;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 响应实体类
 *
 * @author keqi
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AjaxEntity<T> {

	@ApiModelProperty(value = "响应状态码", example = "200", required = true)
	private Integer status;

	@ApiModelProperty(value = "响应描述信息", example = "OK", required = true)
	private String msg;

	@ApiModelProperty(value = "响应体", example = "{}", required = true)
	private T body;
}
