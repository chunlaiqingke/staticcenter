package com.cashtoutiao.statistic.read.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cashtoutiao.statistic.common.response.ChartResponse;
import com.cashtoutiao.statistic.common.response.Response;
import com.cashtoutiao.statistic.statistic.bean.AdminDailyOwnStatisticRecord;
import com.cashtoutiao.statistic.statistic.service.AdminDailyOwnStatisticRecordService;
import com.huadongmedia.common.util.ListUtil;

@Controller
@RequestMapping("read")
public class ReadController {

	@Autowired
	private AdminDailyOwnStatisticRecordService adminDailyOwnStatisticService;
	
	@ResponseBody
	@RequestMapping("")
	public ChartResponse<String, AdminDailyOwnStatisticRecord> getReadTime(String day){
		ChartResponse<String, AdminDailyOwnStatisticRecord> response = new ChartResponse<String, AdminDailyOwnStatisticRecord>();
		List<AdminDailyOwnStatisticRecord> newsDurations = adminDailyOwnStatisticService.getNewsRecordList(day);
		List<AdminDailyOwnStatisticRecord> videoDurations = adminDailyOwnStatisticService.getVideoRecordList(day);
		List<String> categories = ListUtil.keyList(newsDurations, "day");
		response.setStatusCode(Response.SUCCESS);
		response.setCategories(categories);
		response.setFirstList(newsDurations);
		response.setSecondList(videoDurations);
		return response;
	}
}
