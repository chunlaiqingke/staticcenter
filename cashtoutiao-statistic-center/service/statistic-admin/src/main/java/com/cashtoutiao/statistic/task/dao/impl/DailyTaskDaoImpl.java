package com.cashtoutiao.statistic.task.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cashtoutiao.statistic.task.bean.TaskSummary;
import com.cashtoutiao.statistic.task.dao.DailyTaskDao;
import com.huadongmedia.common.mybatis.MybatisDaoSupport;
import com.huadongmedia.common.util.MapUtil;

@Repository
public class DailyTaskDaoImpl extends MybatisDaoSupport implements DailyTaskDao {

	private static final String NAMESPACE = "com.cashtoutiao.statistic.task.bean.response.DailyTask";
	
	@Override
	public List<Integer> getTaskId(Integer day) {
		return getSqlSession().selectList(NAMESPACE + ".getTaskId", day);
	}

	@Override
	public List<TaskSummary> getDailyTaskReward(Integer day, List<Integer> taskIds) {
		return getSqlSession().selectList(NAMESPACE + ".getDailyTaskReward", MapUtil.build("day", day, "taskIds", taskIds));
	}

}
