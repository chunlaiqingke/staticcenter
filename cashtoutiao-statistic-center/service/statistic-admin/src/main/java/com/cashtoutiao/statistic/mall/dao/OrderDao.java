package com.cashtoutiao.statistic.mall.dao;

import com.cashtoutiao.statistic.common.bean.ReceiveRecord;

public interface OrderDao {

	ReceiveRecord getTotalWithdrawByDay(String start, String end);

}
