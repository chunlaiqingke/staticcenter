package com.cashtoutiao.statistic.sign.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cashtoutiao.statistic.common.response.ChartResponse;
import com.cashtoutiao.statistic.common.response.Response;
import com.cashtoutiao.statistic.sign.bean.SignDailySummary;
import com.cashtoutiao.statistic.sign.service.UserSignService;
import com.huadongmedia.common.util.DateUtil;
import com.huadongmedia.common.util.ListUtil;

@Controller
@RequestMapping("sign")
public class SignController {

	@Autowired
	private UserSignService userSignService;
	
	@RequestMapping("")
	@ResponseBody
	public ChartResponse<Integer, Integer> getDailySignUserCount(String startDate, String endDate){
		ChartResponse<Integer,Integer> response = new ChartResponse<Integer, Integer>();
		Date start = DateUtil.toDate(startDate, DateUtil.ymdDash.get());
		Date end = DateUtil.toDate(endDate, DateUtil.ymdDash.get());
		List<Integer> dayList = new ArrayList<Integer>();
		for (int i = 0; i < DateUtil.getDayOffset(start, end); i++) {
			dayList.add(DateUtil.toDayInt(DateUtil.addTimes(start, Calendar.DAY_OF_MONTH, i)));
		}
		List<SignDailySummary> list = userSignService.getDailySignUserCount(dayList);
		List<Integer> categories = ListUtil.keyList(list, "lastDay");
		List<Integer> values = ListUtil.keyList(list, "count");
		response.setCategories(categories);
		response.setFirstList(values);
		response.setStatusCode(Response.SUCCESS);
		return response;
	}
}
