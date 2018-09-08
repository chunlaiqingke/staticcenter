package com.cashtoutiao.statistic.credit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cashtoutiao.statistic.common.bean.ReceiveRecord;
import com.cashtoutiao.statistic.common.response.ChartResponse;
import com.cashtoutiao.statistic.common.response.Response;
import com.cashtoutiao.statistic.mall.service.OrderService;
import com.cashtoutiao.statistic.statistic.service.AdminDailyOwnStatisticRecordService;
import com.huadongmedia.common.util.ListUtil;

@Controller
@RequestMapping("credit")
public class CreditController {
	
	@Autowired
	private AdminDailyOwnStatisticRecordService adminDailyOwnStatisticService;
	
	@Autowired
	private OrderService orderService;

	@ResponseBody
	@RequestMapping("cash/back")
	public ChartResponse<String, Integer> getaCashback(String day){
		ChartResponse<String, Integer> response = new ChartResponse<String, Integer>();
		List<ReceiveRecord> cashbackList = adminDailyOwnStatisticService.getCashback(day);
		List<String> categories = ListUtil.keyList(cashbackList, "day");
		List<Integer> values = ListUtil.keyList(cashbackList, "value");
		response.setStatusCode(Response.SUCCESS);
		response.setCategories(categories);
		response.setFirstList(values);
		return response;
	}
	
	@ResponseBody
	@RequestMapping("withdraw/back")
	public ChartResponse<String, Long> getaWithdraw(String startDate, String endDate){
		ChartResponse<String, Long> response = new ChartResponse<String, Long>();
		List<ReceiveRecord> list = orderService.getTotalWithdraw(startDate, endDate);
		if(!ListUtil.isEmpty(list)){
			List<String> categories = ListUtil.keyList(list, "day");
			List<Long> firstList = ListUtil.keyList(list, "value");
			List<Long> secondList = ListUtil.keyList(list, "count");
			response.setFirstList(firstList);
			response.setCategories(categories);
			response.setSecondList(secondList);
		}
		response.setStatusCode(Response.SUCCESS);
		return response;
	}
}
