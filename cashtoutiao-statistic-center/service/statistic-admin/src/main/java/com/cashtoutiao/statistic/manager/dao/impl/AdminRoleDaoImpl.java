package com.cashtoutiao.statistic.manager.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cashtoutiao.statistic.manager.bean.AdminRoleInfo;
import com.cashtoutiao.statistic.manager.dao.AdminRoleDao;
import com.huadongmedia.common.mybatis.MybatisDaoSupport;
import com.huadongmedia.common.util.MapUtil;

@Repository
public class AdminRoleDaoImpl extends MybatisDaoSupport implements AdminRoleDao{

	private static final String NAMESPACE = "com.cashtoutiao.statistic.manager.bean.AdminRoleInfo";
	
	@Override
	public List<AdminRoleInfo> getRolePage(int page, int limit) {
		return getSqlSession().selectList(NAMESPACE + ".getRolePage", MapUtil.build("offset", (page - 1) * limit , "pageSize", limit));
	}

	@Override
	public int getTotalCount() {
		return getSqlSession().selectOne(NAMESPACE + ".getTotalCount");
	}

}
