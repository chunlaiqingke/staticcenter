package com.cashtoutiao.statistic.manager.service;

import java.util.List;

import com.cashtoutiao.statistic.manager.bean.MenuInfo;

public interface AdminMenuInfoService {

	List<MenuInfo> getMenuInfoByIds(List<Integer> menuIds);

	List<MenuInfo> getMenuInfoPage(Integer page, Integer pageSize);

	int getTotalCount();

	MenuInfo getMenuInfoById(Integer id);
	
	public List<MenuInfo> getAllParentMenu();

	boolean save(Integer menuId, String menuName, String menuIcon, String menuUrl, Integer parentId);

}
