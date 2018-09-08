package com.cashtoutiao.statistic.manager.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cashtoutiao.statistic.manager.bean.AdminRoleInfo;
import com.cashtoutiao.statistic.manager.dao.AdminRoleDao;
import com.cashtoutiao.statistic.manager.service.AdminRoleService;

@Service
public class AdminRoleServiceImpl implements AdminRoleService {

	@Autowired
	private AdminRoleDao roleDao;
	
	@Override
	public List<AdminRoleInfo> getRolePage(int page, int limit) {
		return roleDao.getRolePage(page, limit);
	}

	@Override
	public int getTotalCount() {
		return roleDao.getTotalCount();
	}

}
