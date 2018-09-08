package com.cashtoutiao.statistic.manager.service;

import java.util.List;

import com.cashtoutiao.statistic.manager.bean.AdminRoleInfo;

public interface AdminRoleService {

	List<AdminRoleInfo> getRolePage(int page, int limit);

	int getTotalCount();

}
