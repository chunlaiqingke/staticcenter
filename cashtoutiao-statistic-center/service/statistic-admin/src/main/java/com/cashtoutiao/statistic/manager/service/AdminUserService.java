package com.cashtoutiao.statistic.manager.service;

import java.util.List;

import com.cashtoutiao.statistic.manager.bean.AdminUser;

public interface AdminUserService {

	AdminUser getUserInfoByName(String userName, String password);

	List<AdminUser> getUserListPage(int page, int limit);

	int getTotalCount();

}
