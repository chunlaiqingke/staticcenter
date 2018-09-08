package com.cashtoutiao.statistic.manager.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cashtoutiao.statistic.manager.dao.AdminUserRoleDao;
import com.huadongmedia.common.mybatis.MybatisDaoSupport;

@Repository
public class AdminUserRoleDaoImpl extends MybatisDaoSupport implements AdminUserRoleDao {

	private static final String NAMESPACE = "com.cashtoutiao.statistic.manager.bean.AdminUserRole";
	
	@Override
	public List<Integer> getRoleByUserId(Integer userId) {
		return getSqlSession().selectList(NAMESPACE + ".getRoleByUserId", userId);
	}

}
