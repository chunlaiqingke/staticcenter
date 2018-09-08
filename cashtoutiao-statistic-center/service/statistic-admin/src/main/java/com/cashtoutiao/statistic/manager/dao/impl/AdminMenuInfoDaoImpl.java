package com.cashtoutiao.statistic.manager.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cashtoutiao.statistic.manager.bean.MenuInfo;
import com.cashtoutiao.statistic.manager.dao.AdminMenuInfoDao;
import com.huadongmedia.common.mybatis.MybatisDaoSupport;
import com.huadongmedia.common.util.MapUtil;

@Repository
public class AdminMenuInfoDaoImpl extends MybatisDaoSupport implements AdminMenuInfoDao {

	private static final String NAMESPACE = "com.cashtoutiao.statistic.manager.bean.MenuInfo";
	
	@Override
	public List<MenuInfo> getMenuInfoByIds(List<Integer> menuIds) {
		return getSqlSession().selectList(NAMESPACE + ".getMenuInfoByIds", MapUtil.build("menuIds", menuIds));
	}

	@Override
	public List<MenuInfo> getMenuInfoPage(Integer offset, Integer pageSize) {
		return getSqlSession().selectList(NAMESPACE + ".getMenuInfoPage", MapUtil.build("offset", offset, "pageSize", pageSize));
	}

	@Override
	public int getTotalCount() {
		return getSqlSession().selectOne(NAMESPACE + ".getTotalCount");
	}

	@Override
	public MenuInfo getMenuInfoById(Integer id) {
		return getSqlSession().selectOne(NAMESPACE + ".getMenuInfoById", MapUtil.build("id", id));
	}

	@Override
	public List<MenuInfo> getAllParentMenu() {
		return getSqlSession().selectList(NAMESPACE + ".getAllParentMenu");
	}

	@Override
	public boolean save(Integer menuId, String menuName, String menuIcon, String menuUrl, Integer parentId) {
		return getSqlSession().update(NAMESPACE + ".save", MapUtil.build("menuId", menuId, "menuName", menuName, "menuIcon", menuIcon, "menuUrl", menuUrl, "parentId", parentId)) > 0;
	}

}
