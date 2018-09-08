package com.cashtoutiao.statistic.sign.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.cashtoutiao.statistic.sign.bean.SignDailySummary;
import com.cashtoutiao.statistic.sign.dao.UserSignRecordDao;
import com.huadongmedia.common.mybatis.MybatisDaoSupport;
import com.huadongmedia.common.util.MapUtil;

@Repository
public class UserSignRecordDaoImpl extends MybatisDaoSupport implements UserSignRecordDao {

	private static final String NAMESPACE = "com.cashtoutiao.statistic.sign.bean.UserSignRecord";

	@Override
	public List<SignDailySummary> getDailySignUserCount(List<Integer> dayList) {
		List<SignDailySummary> list = new ArrayList<SignDailySummary>();
		for (Integer day : dayList) {
			Integer count = getSqlSession().selectOne(NAMESPACE + ".getDailySignUserCount", MapUtil.build("day", day));
			SignDailySummary summary = new SignDailySummary();
			summary.setCount(count);
			summary.setLastDay(day);
			list.add(summary);
		}
		return list;
	}
}
