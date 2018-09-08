package com.cashtoutiao.statistic.manager.dao;

import java.util.List;

public interface AdminUserRoleDao {

	List<Integer> getRoleByUserId(Integer userId);

}
