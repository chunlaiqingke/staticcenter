package com.cashtoutiao.statistic.invite.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cashtoutiao.statistic.invite.bean.InviteNumber;
import com.cashtoutiao.statistic.invite.dao.InviteDao;
import com.huadongmedia.common.mybatis.MybatisDaoSupport;
import com.huadongmedia.common.util.MapUtil;

@Repository
public class InviteDaoImpl extends MybatisDaoSupport implements InviteDao {

	private static final String NAMESPACE = "com.cashtoutiao.statistic.invite.bean.Invite";
	
	@Override
	public InviteNumber getInviteNumber(List<Long> userIds, String day) {
		return getSqlSession().selectOne(NAMESPACE + ".getInviteNumber", MapUtil.build("userIds", userIds, "day", day));
	}

}
