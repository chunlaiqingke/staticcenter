package com.cashtoutiao.statistic.manager.dao;

import java.util.List;

import com.cashtoutiao.statistic.manager.bean.AdminRoleInfo;

public interface AdminRoleDao {

	List<AdminRoleInfo> getRolePage(int page, int limit);

	int getTotalCount();

}
