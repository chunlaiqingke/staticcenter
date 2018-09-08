package com.cashtoutiao.statistic.manager.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cashtoutiao.statistic.manager.bean.AdminRoleMenu;
import com.cashtoutiao.statistic.manager.bean.MenuInfo;
import com.cashtoutiao.statistic.manager.dao.AdminMenuInfoDao;
import com.cashtoutiao.statistic.manager.dao.AdminRoleMenuDao;
import com.cashtoutiao.statistic.manager.service.AdminRoleMenuService;
import com.huadongmedia.common.util.ListUtil;

@Service
public class AdminRoleMenuServiceImpl implements AdminRoleMenuService {

	@Autowired
	private AdminRoleMenuDao roleMenuDao;
	
	@Autowired
	private AdminMenuInfoDao menuInfoDao;

	@Override
	public List<MenuInfo> getMenuIdByRole(List<Integer> roleId) {
		List<Integer> menuIds = roleMenuDao.getMenuIdByRole(roleId);
		if(ListUtil.isEmpty(menuIds)){
			return null;
		}
		return menuInfoDao.getMenuInfoByIds(menuIds);
		 
	}

	@Override
	public boolean delete(Integer roleId) {
		return roleMenuDao.delete(roleId);
	}

	@Override
	public boolean save(List<AdminRoleMenu> roleMenus) {
		return roleMenuDao.save(roleMenus);
	}
}
