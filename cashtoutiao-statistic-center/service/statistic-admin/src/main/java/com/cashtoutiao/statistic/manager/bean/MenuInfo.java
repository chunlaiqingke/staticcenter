package com.cashtoutiao.statistic.manager.bean;

import com.alibaba.fastjson.annotation.JSONField;

public class MenuInfo {

	private Integer id;
	
	private String title;
	
	private String icon;
	
	private String url;
	
	@JSONField(serialize = false)
	private Integer parentId;
	
	private boolean permitted;
	
	public boolean isPermitted() {
		return permitted;
	}

	public void setPermitted(boolean permitted) {
		this.permitted = permitted;
	}

	public MenuInfo(){}
	
	public MenuInfo(Integer id, String title, String icon, String url){
		this.id = id;
		this.title = title;
		this.icon = icon;
		this.url = url;		
	}
	
	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

}
