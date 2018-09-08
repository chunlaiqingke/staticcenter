package com.cashtoutiao.statistic.statistic.dao;

import java.util.List;

import com.cashtoutiao.statistic.common.bean.ReceiveRecord;
import com.cashtoutiao.statistic.statistic.bean.AdminDailyOwnStatisticRecord;

public interface AdminDailyOwnStatisticRecordDao {

	List<AdminDailyOwnStatisticRecord> getRegisters(String day);

	List<AdminDailyOwnStatisticRecord> getDau(String day);

	List<ReceiveRecord> getInviteExpense(String day);

	List<AdminDailyOwnStatisticRecord> getNewsRecordList(String day);

	List<AdminDailyOwnStatisticRecord> getVideoRecordList(String day);

	List<ReceiveRecord> getCashback(String day);

}
