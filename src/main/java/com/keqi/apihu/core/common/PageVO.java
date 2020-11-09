package com.keqi.apihu.core.common;

import java.util.ArrayList;
import java.util.List;

/**
 * 分页响应VO
 */
public class PageVO {

	private int total;

	private List<?> list;

	public PageVO() {
	}

	public PageVO(int total, List<?> list) {
		this.total = total;
		this.list = list;
	}

	public long getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public List<?> getList() {
		return list == null ? new ArrayList<>() : list;
	}

	public void setList(List<?> list) {
		this.list = list;
	}
}
