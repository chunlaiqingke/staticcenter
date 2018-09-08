package com.cashtoutiao.statistic.manager.dto.response;

import java.util.List;

import com.cashtoutiao.statistic.common.response.Response;
import com.cashtoutiao.statistic.manager.bean.ParentMenuInfo;

public class IndexMenuResponse extends Response {

	private List<ParentMenuInfo> menuList;

	public List<ParentMenuInfo> getMenuList() {
		return menuList;
	}

	public void setMenuList(List<ParentMenuInfo> menuList) {
		this.menuList = menuList;
	}
}
