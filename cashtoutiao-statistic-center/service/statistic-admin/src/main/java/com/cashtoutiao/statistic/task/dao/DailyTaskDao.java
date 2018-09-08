package com.cashtoutiao.statistic.task.dao;

import java.util.List;

import com.cashtoutiao.statistic.task.bean.TaskSummary;

public interface DailyTaskDao {

	List<Integer> getTaskId(Integer day);

	List<TaskSummary> getDailyTaskReward(Integer day, List<Integer> taskIds);

}
