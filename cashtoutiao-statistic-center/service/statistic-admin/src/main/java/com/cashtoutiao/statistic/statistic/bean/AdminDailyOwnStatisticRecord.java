package com.cashtoutiao.statistic.statistic.bean;

import com.alibaba.fastjson.annotation.JSONField;

public class AdminDailyOwnStatisticRecord {

	private Integer id;
	
	private String day;
	
	@JSONField(serialize = false)
	private String type;
	
	@JSONField(serialize = false)
	private String subType;
	
	private Long value;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getSubType() {
		return subType;
	}

	public void setSubType(String subType) {
		this.subType = subType;
	}

	public Long getValue() {
		return value;
	}

	public void setValue(Long value) {
		this.value = value;
	}
	
}
