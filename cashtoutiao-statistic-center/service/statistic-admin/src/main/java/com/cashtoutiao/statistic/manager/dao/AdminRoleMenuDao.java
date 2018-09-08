package com.cashtoutiao.statistic.manager.dao;

import java.util.List;

import com.cashtoutiao.statistic.manager.bean.AdminRoleMenu;

public interface AdminRoleMenuDao {

	List<Integer> getMenuIdByRole(List<Integer> roleIds);

	boolean delete(Integer roleId);

	boolean save(List<AdminRoleMenu> roleMenus);

}
