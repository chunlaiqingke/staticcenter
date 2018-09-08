package com.cashtoutiao.statistic.manager.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cashtoutiao.statistic.manager.bean.AdminUser;
import com.cashtoutiao.statistic.manager.dao.AdminUserDao;
import com.cashtoutiao.statistic.manager.service.AdminUserService;

@Service
public class AdminUserServiceImpl implements AdminUserService {

	@Autowired
	private AdminUserDao userDao;

	@Override
	public AdminUser getUserInfoByName(String userName, String password) {
		return userDao.getUserInfoByName(userName, password);
	}

	@Override
	public List<AdminUser> getUserListPage(int page, int limit) {
		return userDao.getUserListPage(page, limit);
	}

	@Override
	public int getTotalCount() {
		return userDao.getTotalCount();
	}
}
