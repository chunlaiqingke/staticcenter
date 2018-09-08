package com.cashtoutiao.statistic.task.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cashtoutiao.statistic.task.bean.TaskSummary;
import com.cashtoutiao.statistic.task.dao.DailyTaskDao;
import com.cashtoutiao.statistic.task.service.DailyTaskService;

@Service
public class DailyTaskServiceImpl implements DailyTaskService{

	@Autowired
	private DailyTaskDao dailyTaskDao;

	@Override
	public List<Integer> getTaskId(Integer day) {
		return dailyTaskDao.getTaskId(day);
	}

	@Override
	public List<TaskSummary> getDailyTaskReward(Integer day, List<Integer> taskIds) {
		return dailyTaskDao.getDailyTaskReward(day, taskIds);
	}
}
