package com.cashtoutiao.statistic.sign.dao;

import java.util.List;

import com.cashtoutiao.statistic.sign.bean.SignDailySummary;

public interface UserSignRecordDao {

	List<SignDailySummary> getDailySignUserCount(List<Integer> dayList);

}
