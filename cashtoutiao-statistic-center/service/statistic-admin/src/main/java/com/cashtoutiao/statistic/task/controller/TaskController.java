package com.cashtoutiao.statistic.task.controller;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cashtoutiao.statistic.common.response.ChartResponse;
import com.cashtoutiao.statistic.common.response.Response;
import com.cashtoutiao.statistic.task.bean.TaskSummary;
import com.cashtoutiao.statistic.task.service.DailyTaskService;
import com.huadongmedia.common.util.DateUtil;
import com.huadongmedia.common.util.ListUtil;

@Controller
@RequestMapping("task")
public class TaskController {

	@Autowired
	private DailyTaskService dailyTaskService;
	
	@RequestMapping("payout")
	@ResponseBody
	public ChartResponse<Integer, Long> getTaskPayout(@RequestParam(value="day") String dateStr){
		ChartResponse<Integer, Long> response = new ChartResponse<Integer, Long>();
		if(dateStr == null){
			dateStr = DateUtil.toString(DateUtil.addTimes(new Date(), Calendar.DAY_OF_MONTH, -1), DateUtil.ymdDash.get());
		}
		int day = DateUtil.toDayInt(DateUtil.toDate(dateStr, DateUtil.ymdDash.get()));
		List<Integer> taskIds = dailyTaskService.getTaskId(day);
		if(ListUtil.isEmpty(taskIds)){
			response.setStatusCode(Response.FAILED);
			return response;
		}
		List<TaskSummary> list = dailyTaskService.getDailyTaskReward(day, taskIds);
		taskIds = ListUtil.keyList(list, "taskId");
		List<Long> values = ListUtil.keyList(list, "value");
		response.setFirstList(values);
		response.setCategories(taskIds);
		response.setStatusCode(Response.SUCCESS);
		return response;
	}
}
