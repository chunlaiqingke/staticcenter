package com.cashtoutiao.statistic.mall.service.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cashtoutiao.statistic.common.bean.ReceiveRecord;
import com.cashtoutiao.statistic.mall.dao.OrderDao;
import com.cashtoutiao.statistic.mall.service.OrderService;
import com.huadongmedia.common.util.DateUtil;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderDao orderDao;

	@Override
	public List<ReceiveRecord> getTotalWithdraw(String startDate, String endDate) {
		Date start = DateUtil.toDate(startDate, DateUtil.ymdDash.get());
		Date end = DateUtil.toDate(endDate, DateUtil.ymdDash.get());
		int offset = DateUtil.getDayOffset(start, end);
		ArrayList<ReceiveRecord> list = new ArrayList<ReceiveRecord>();
		for (int i = 0; i < offset; i++) {
			String startDay = DateUtil.toString(DateUtil.addTimes(start, Calendar.DAY_OF_MONTH, i), DateUtil.ymdDash.get());
			String endDay = DateUtil.toString(DateUtil.addTimes(start, Calendar.DAY_OF_MONTH, i + 1), DateUtil.ymdDash.get());
			ReceiveRecord record = orderDao.getTotalWithdrawByDay(startDay, endDay);
			if(record != null){
				list.add(record);
			}
		}
		return list;
	}
}
