package com.cashtoutiao.statistic.manager.dao;

import java.util.List;

import com.cashtoutiao.statistic.manager.bean.MenuInfo;

public interface AdminMenuInfoDao {

	List<MenuInfo> getMenuInfoByIds(List<Integer> menuIds);

	List<MenuInfo> getMenuInfoPage(Integer offset, Integer pageSize);

	int getTotalCount();

	MenuInfo getMenuInfoById(Integer id);
	
	public List<MenuInfo> getAllParentMenu();

	boolean save(Integer menuId, String menuName, String menuIcon, String menuUrl, Integer parentId);

}
