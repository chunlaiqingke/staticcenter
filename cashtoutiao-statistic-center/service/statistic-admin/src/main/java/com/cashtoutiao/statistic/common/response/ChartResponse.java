package com.cashtoutiao.statistic.common.response;

import java.util.List;

public class ChartResponse <V, T> extends Response{

	private List<V> categories;
	
	private List<T> firstList;
	
	private List<T> secondList;

	public List<V> getCategories() {
		return categories;
	}

	public void setCategories(List<V> categories) {
		this.categories = categories;
	}

	public List<T> getFirstList() {
		return firstList;
	}

	public void setFirstList(List<T> firstList) {
		this.firstList = firstList;
	}

	public List<T> getSecondList() {
		return secondList;
	}

	public void setSecondList(List<T> secondList) {
		this.secondList = secondList;
	}
}
