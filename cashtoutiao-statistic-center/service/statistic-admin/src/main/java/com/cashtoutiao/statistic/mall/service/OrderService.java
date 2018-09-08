package com.cashtoutiao.statistic.mall.service;

import java.util.List;

import com.cashtoutiao.statistic.common.bean.ReceiveRecord;

public interface OrderService {

	List<ReceiveRecord> getTotalWithdraw(String startDate, String endDate);

}
