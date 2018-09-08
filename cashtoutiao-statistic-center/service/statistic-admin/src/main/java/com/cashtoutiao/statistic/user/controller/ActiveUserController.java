package com.cashtoutiao.statistic.user.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cashtoutiao.statistic.common.response.ChartResponse;
import com.cashtoutiao.statistic.common.response.Response;
import com.cashtoutiao.statistic.statistic.bean.AdminDailyOwnStatisticRecord;
import com.cashtoutiao.statistic.statistic.service.AdminDailyOwnStatisticRecordService;
import com.huadongmedia.common.util.DateUtil;

@RestController
@RequestMapping("user")
public class ActiveUserController {
	
	@Autowired
	private AdminDailyOwnStatisticRecordService adminDailyOwnStatisticService;

	@RequestMapping("active")
	public ChartResponse<String, AdminDailyOwnStatisticRecord> getActive(String day){
		ChartResponse<String, AdminDailyOwnStatisticRecord> response = new ChartResponse<String, AdminDailyOwnStatisticRecord>();
		if(day == null || "".equals(day)){
			day =DateUtil.toString(DateUtil.addTimes(new Date(), Calendar.DAY_OF_YEAR, -7), DateUtil.ymdDash.get());
		}
		List<AdminDailyOwnStatisticRecord> dailyRegisters = adminDailyOwnStatisticService.getRegisters(day);
		List<AdminDailyOwnStatisticRecord> dau = adminDailyOwnStatisticService.getDau(day);
		if(dailyRegisters == null && dau == null){
			response.setStatusCode(Response.FAILED);
			response.setMsg("数据为空!");
			return response;
		}
		List<String> categories = new ArrayList<String>();
		for (AdminDailyOwnStatisticRecord record : dau) {
			categories.add(record.getDay());
		}
		response.setFirstList(dau);
		response.setSecondList(dailyRegisters);
		response.setCategories(categories);
		response.setStatusCode(Response.SUCCESS);
		return response;
	}
}
