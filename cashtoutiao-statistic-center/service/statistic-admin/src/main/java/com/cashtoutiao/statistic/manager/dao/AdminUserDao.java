package com.cashtoutiao.statistic.manager.dao;

import java.util.List;

import com.cashtoutiao.statistic.manager.bean.AdminUser;

public interface AdminUserDao {

	AdminUser getUserInfoByName(String userName, String password);

	List<AdminUser> getUserListPage(int page, int limit);

	int getTotalCount();

}
