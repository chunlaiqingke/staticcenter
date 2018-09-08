package com.cashtoutiao.statistic.manager.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cashtoutiao.statistic.manager.bean.AdminUser;
import com.cashtoutiao.statistic.manager.dao.AdminUserDao;
import com.huadongmedia.common.mybatis.MybatisDaoSupport;
import com.huadongmedia.common.util.MapUtil;

@Repository
public class AdminUserDaoImpl extends MybatisDaoSupport implements AdminUserDao {

	private static final String NAMESPACE = "com.cashtoutiao.statistic.manager.bean.AdminUser";
	
	@Override
	public AdminUser getUserInfoByName(String userName, String password) {
		return getSqlSession().selectOne(NAMESPACE + ".getUserInfoByName", MapUtil.build("userName", userName, "password", password));
	}

	@Override
	public List<AdminUser> getUserListPage(int page, int limit) {
		return getSqlSession().selectList(NAMESPACE + ".getUserListPage", MapUtil.build("offset", (page -1) * limit, "pageSize", limit));
	}

	@Override
	public int getTotalCount() {
		return getSqlSession().selectOne(NAMESPACE + ".getTotalCount");
	}

}
