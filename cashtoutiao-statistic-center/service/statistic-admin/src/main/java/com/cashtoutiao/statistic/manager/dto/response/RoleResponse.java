package com.cashtoutiao.statistic.manager.dto.response;

import java.util.List;

import com.cashtoutiao.statistic.common.response.Response;
import com.cashtoutiao.statistic.manager.bean.AdminRoleInfo;

public class RoleResponse extends Response {

	private List<AdminRoleInfo> list;
	
	private Integer total;

	public List<AdminRoleInfo> getList() {
		return list;
	}

	public void setList(List<AdminRoleInfo> list) {
		this.list = list;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}
}
