package com.cashtoutiao.statistic.manager.bean;

import java.util.List;

public class ParentMenuInfo extends MenuInfo{

	private List<MenuInfo> children;
	
	private boolean spread;
	
	public ParentMenuInfo(){}
	
	public ParentMenuInfo(Integer id, String title, String icon, String url){
		super(id, title, icon, url);
	}

	public boolean isSpread() {
		return spread;
	}

	public void setSpread(boolean spread) {
		this.spread = spread;
	}

	public List<MenuInfo> getChildren() {
		return children;
	}

	public void setChildren(List<MenuInfo> children) {
		this.children = children;
	}
}
