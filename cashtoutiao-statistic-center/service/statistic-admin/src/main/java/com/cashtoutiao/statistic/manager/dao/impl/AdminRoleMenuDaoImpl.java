package com.cashtoutiao.statistic.manager.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cashtoutiao.statistic.manager.bean.AdminRoleMenu;
import com.cashtoutiao.statistic.manager.dao.AdminRoleMenuDao;
import com.huadongmedia.common.mybatis.MybatisDaoSupport;
import com.huadongmedia.common.util.MapUtil;

@Repository
public class AdminRoleMenuDaoImpl extends MybatisDaoSupport implements AdminRoleMenuDao {

	private static final String NAMESPACE = "com.cashtoutiao.statistic.manager.bean.AdminRoleMenu";

	@Override
	public List<Integer> getMenuIdByRole(List<Integer> roleIds) {
		return getSqlSession().selectList(NAMESPACE + ".getMenuIdByRole", MapUtil.build("roleIds", roleIds));
	}

	@Override
	public boolean delete(Integer roleId) {
		return getSqlSession().delete(NAMESPACE + ".deleteByRole", MapUtil.build("roleId", roleId))>0;
	}

	@Override
	public boolean save(List<AdminRoleMenu> roleMenus) {
		return getSqlSession().insert(NAMESPACE + ".saveList", MapUtil.build("roleMenus", roleMenus)) > 0;
	}
}
