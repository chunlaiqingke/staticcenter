package com.cashtoutiao.statistic.statistic.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cashtoutiao.statistic.common.bean.ReceiveRecord;
import com.cashtoutiao.statistic.statistic.bean.AdminDailyOwnStatisticRecord;
import com.cashtoutiao.statistic.statistic.dao.AdminDailyOwnStatisticRecordDao;
import com.cashtoutiao.statistic.statistic.service.AdminDailyOwnStatisticRecordService;

@Service
public class AdminDailyOwnStatisticRecordServiceImpl implements AdminDailyOwnStatisticRecordService {

	@Autowired
	private AdminDailyOwnStatisticRecordDao adminDailyOwnStatisticRecordDao;
	
	@Override
	public List<AdminDailyOwnStatisticRecord> getRegisters(String day) {
		return adminDailyOwnStatisticRecordDao.getRegisters(day);
	}

	@Override
	public List<AdminDailyOwnStatisticRecord> getDau(String day) {
		return adminDailyOwnStatisticRecordDao.getDau(day);
	}

	@Override
	public List<ReceiveRecord> getInviteExpense(String day) {
		return adminDailyOwnStatisticRecordDao.getInviteExpense(day);
	}

	@Override
	public List<AdminDailyOwnStatisticRecord> getNewsRecordList(String day) {
		return adminDailyOwnStatisticRecordDao.getNewsRecordList(day);
	}

	@Override
	public List<AdminDailyOwnStatisticRecord> getVideoRecordList(String day) {
		return adminDailyOwnStatisticRecordDao.getVideoRecordList(day);
	}

	@Override
	public List<ReceiveRecord> getCashback(String day) {
		return adminDailyOwnStatisticRecordDao.getCashback(day);
	}

}
