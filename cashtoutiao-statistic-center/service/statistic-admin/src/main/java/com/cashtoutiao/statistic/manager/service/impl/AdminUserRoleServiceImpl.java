package com.cashtoutiao.statistic.manager.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cashtoutiao.statistic.manager.dao.AdminUserRoleDao;
import com.cashtoutiao.statistic.manager.service.AdminUserRoleService;

@Service
public class AdminUserRoleServiceImpl implements AdminUserRoleService {

	@Autowired
	private AdminUserRoleDao userRoleDao;

	@Override
	public List<Integer> getRoleByUserId(Integer userId) {
		return userRoleDao.getRoleByUserId(userId);
	}
}
