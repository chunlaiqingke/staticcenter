package com.cashtoutiao.statistic.invite.dao;

import java.util.List;

import com.cashtoutiao.statistic.invite.bean.InviteNumber;

public interface InviteDao {

	InviteNumber getInviteNumber(List<Long> userIds, String day);

}
