package com.cashtoutiao.statistic.statistic.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cashtoutiao.statistic.common.bean.ReceiveRecord;
import com.cashtoutiao.statistic.statistic.bean.AdminDailyOwnStatisticRecord;
import com.cashtoutiao.statistic.statistic.dao.AdminDailyOwnStatisticRecordDao;
import com.huadongmedia.common.mybatis.MybatisDaoSupport;
import com.huadongmedia.common.util.MapUtil;

@Repository
public class AdminDailyOwnStatisticRecordDaoImpl extends MybatisDaoSupport implements AdminDailyOwnStatisticRecordDao {

	private static final String NAMESPACE = "com.cashtoutiao.statistic.statistic.bean.AdminDailyOwnStatisticRecord";
	
	@Override
	public List<AdminDailyOwnStatisticRecord> getRegisters(String day) {
		return getSqlSession().selectList(NAMESPACE + ".getValue", MapUtil.build("day", day, "type", "user_info", "subType", "total"));
	}

	@Override
	public List<AdminDailyOwnStatisticRecord> getDau(String day) {
		return getSqlSession().selectList(NAMESPACE + ".getValue", MapUtil.build("day", day, "type", "dau", "subType", "total"));
	}

	@Override
	public List<ReceiveRecord> getInviteExpense(String day) {
		return getSqlSession().selectList(NAMESPACE + ".getInviteExpense", MapUtil.build("day", day));
	}

	@Override
	public List<AdminDailyOwnStatisticRecord> getNewsRecordList(String day) {
		return getSqlSession().selectList(NAMESPACE + ".getValue", MapUtil.build("day", day, "type", "news_daily", "subType", "duration"));
	}

	@Override
	public List<AdminDailyOwnStatisticRecord> getVideoRecordList(String day) {
		return getSqlSession().selectList(NAMESPACE + ".getValue", MapUtil.build("day", day, "type", "video_daily", "subType", "duration"));
	}

	@Override
	public List<ReceiveRecord> getCashback(String day) {
		return getSqlSession().selectList(NAMESPACE + ".getCashback", MapUtil.build("day", day));
	}

}
