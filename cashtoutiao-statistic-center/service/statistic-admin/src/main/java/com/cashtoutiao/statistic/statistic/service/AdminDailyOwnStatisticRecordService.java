package com.cashtoutiao.statistic.statistic.service;

import java.util.List;

import com.cashtoutiao.statistic.common.bean.ReceiveRecord;
import com.cashtoutiao.statistic.statistic.bean.AdminDailyOwnStatisticRecord;

public interface AdminDailyOwnStatisticRecordService {

	List<AdminDailyOwnStatisticRecord> getRegisters(String day);

	List<AdminDailyOwnStatisticRecord> getDau(String day);

	List<ReceiveRecord> getInviteExpense(String day);

	List<AdminDailyOwnStatisticRecord> getNewsRecordList(String day);

	List<AdminDailyOwnStatisticRecord> getVideoRecordList(String day);

	List<ReceiveRecord> getCashback(String day);

}
