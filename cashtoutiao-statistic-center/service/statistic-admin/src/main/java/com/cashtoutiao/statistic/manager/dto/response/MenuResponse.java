package com.cashtoutiao.statistic.manager.dto.response;

import java.util.List;

import com.cashtoutiao.statistic.common.response.Response;
import com.cashtoutiao.statistic.manager.bean.MenuInfo;

public class MenuResponse extends Response{

	private List<MenuInfo> list;
	
	private Integer total;

	public List<MenuInfo> getList() {
		return list;
	}

	public void setList(List<MenuInfo> list) {
		this.list = list;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}
}
