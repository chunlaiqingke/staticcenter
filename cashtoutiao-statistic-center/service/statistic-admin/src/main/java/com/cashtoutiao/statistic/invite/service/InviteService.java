package com.cashtoutiao.statistic.invite.service;

import java.util.List;

import com.cashtoutiao.statistic.invite.bean.InviteNumber;

public interface InviteService {

	InviteNumber getInviteNumber(List<Long> userIds, String day);

}
