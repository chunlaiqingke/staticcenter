package com.cashtoutiao.statistic.task.service;

import java.util.List;

import com.cashtoutiao.statistic.task.bean.TaskSummary;

public interface DailyTaskService {

	List<Integer> getTaskId(Integer day);

	List<TaskSummary> getDailyTaskReward(Integer day, List<Integer> taskIds);

}
