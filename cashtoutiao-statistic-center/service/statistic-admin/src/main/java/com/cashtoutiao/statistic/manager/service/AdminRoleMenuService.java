package com.cashtoutiao.statistic.manager.service;

import java.util.List;

import com.cashtoutiao.statistic.manager.bean.AdminRoleMenu;
import com.cashtoutiao.statistic.manager.bean.MenuInfo;

public interface AdminRoleMenuService {

	List<MenuInfo> getMenuIdByRole(List<Integer> roleId);

	boolean delete(Integer roleId);

	boolean save(List<AdminRoleMenu> roleMenus);

}
