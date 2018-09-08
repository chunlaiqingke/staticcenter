package com.cashtoutiao.statistic.mall.dao.impl;

import org.springframework.stereotype.Repository;

import com.cashtoutiao.statistic.common.bean.ReceiveRecord;
import com.cashtoutiao.statistic.mall.dao.OrderDao;
import com.huadongmedia.common.mybatis.MybatisDaoSupport;
import com.huadongmedia.common.util.MapUtil;

@Repository
public class OrderDaoImpl extends MybatisDaoSupport implements OrderDao{

	private static final String NAMESPACE = "com.cashtoutiao.statistic.mall.bean.OrderInfo";
	
	@Override
	public ReceiveRecord getTotalWithdrawByDay(String start, String end) {
		return getSqlSession().selectOne(NAMESPACE + ".getTotalWithdrawByDay", MapUtil.build("start", start, "end", end));
	}

}
