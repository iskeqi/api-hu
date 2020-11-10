package com.keqi.apihu.core.common;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 分页响应VO
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AjaxPageEntity<T> {

	@ApiModelProperty(value = "总记录数", required = true, example = "20")
	private int total;

	@ApiModelProperty(value = "记录列表", required = true)
	private List<T> list;
}
