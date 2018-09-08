package com.cashtoutiao.statistic.user.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cashtoutiao.statistic.user.bean.UserInfo;
import com.cashtoutiao.statistic.user.dao.UserInfoDao;
import com.huadongmedia.common.mybatis.MybatisDaoSupport;
import com.huadongmedia.common.util.MapUtil;

@Repository
public class UserInfoDaoImpl extends MybatisDaoSupport implements UserInfoDao {

	private static final String NAMESPACE = "com.cashtoutiao.statistic.user.bean.UserInfo";
	
	@Override
	public List<UserInfo> getUserInfosByRegisterDay(String day) {
		return getSqlSession().selectList(NAMESPACE + ".getUserInfosByRegisterDay", MapUtil.build("day", day));
	}

}
