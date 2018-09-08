package com.cashtoutiao.statistic.sign.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cashtoutiao.statistic.sign.bean.SignDailySummary;
import com.cashtoutiao.statistic.sign.dao.UserSignRecordDao;
import com.cashtoutiao.statistic.sign.service.UserSignService;

@Service
public class UserSignServiceImpl implements UserSignService{

	@Autowired
	private UserSignRecordDao userSignRecordDao;

	@Override
	public List<SignDailySummary> getDailySignUserCount(List<Integer> dayList) {
		return userSignRecordDao.getDailySignUserCount(dayList);
	}
}
