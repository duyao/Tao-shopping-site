package com.taotao.pojo;

import java.util.List;

/**
 * @author dy
 * easyUI的数据列表
 *
 */
public class EUDataGrid {
	private long total;
	private List<?> rows;
	public long getTotal() {
		return total;
	}
	public void setTotal(long total) {
		this.total = total;
	}
	public List<?> getRows() {
		return rows;
	}
	public void setRows(List<?> rows) {
		this.rows = rows;
	}

}
