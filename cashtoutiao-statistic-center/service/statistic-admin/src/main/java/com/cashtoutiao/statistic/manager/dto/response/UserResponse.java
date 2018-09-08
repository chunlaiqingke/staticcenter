package com.cashtoutiao.statistic.manager.dto.response;

import java.util.List;

import com.cashtoutiao.statistic.common.response.Response;
import com.cashtoutiao.statistic.manager.bean.AdminUser;

public class UserResponse extends Response{

	private List<AdminUser> list;
	
	private Integer total;

	public List<AdminUser> getList() {
		return list;
	}

	public void setList(List<AdminUser> list) {
		this.list = list;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}
	
}
