package com.cashtoutiao.statistic.sign.service;

import java.util.List;

import com.cashtoutiao.statistic.sign.bean.SignDailySummary;

public interface UserSignService {

	List<SignDailySummary> getDailySignUserCount(List<Integer> dayList);

}
