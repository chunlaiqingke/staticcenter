package com.cashtoutiao.statistic.manager.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cashtoutiao.statistic.manager.bean.MenuInfo;
import com.cashtoutiao.statistic.manager.dao.AdminMenuInfoDao;
import com.cashtoutiao.statistic.manager.service.AdminMenuInfoService;

@Service
public class AdminMenuInfoServiceImpl implements AdminMenuInfoService {

	@Autowired
	private AdminMenuInfoDao menuInfoDao;
	
	@Override
	public List<MenuInfo> getMenuInfoByIds(List<Integer> menuIds) {
		return menuInfoDao.getMenuInfoByIds(menuIds);
	}

	@Override
	public List<MenuInfo> getMenuInfoPage(Integer page, Integer pageSize) {
		if(page == null){
			return menuInfoDao.getMenuInfoPage(null, null);
		}
		return menuInfoDao.getMenuInfoPage((page-1) * pageSize, pageSize);
	}

	@Override
	public int getTotalCount() {
		return menuInfoDao.getTotalCount();
	}

	@Override
	public MenuInfo getMenuInfoById(Integer id) {
		return menuInfoDao.getMenuInfoById(id);
	}

	@Override
	public List<MenuInfo> getAllParentMenu() {
		return menuInfoDao.getAllParentMenu();
	}

	@Override
	public boolean save(Integer menuId, String menuName, String menuIcon, String menuUrl, Integer parentId) {
		return menuInfoDao.save(menuId, menuName, menuIcon, menuUrl, parentId);
	}

}
