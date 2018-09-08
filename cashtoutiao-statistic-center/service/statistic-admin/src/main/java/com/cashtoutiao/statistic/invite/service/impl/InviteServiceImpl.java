package com.cashtoutiao.statistic.invite.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cashtoutiao.statistic.invite.bean.InviteNumber;
import com.cashtoutiao.statistic.invite.dao.InviteDao;
import com.cashtoutiao.statistic.invite.service.InviteService;

@Service
public class InviteServiceImpl implements InviteService {

	@Autowired
	private InviteDao inviteDao;
	
	@Override
	public InviteNumber getInviteNumber(List<Long> userIds, String day) {
		return inviteDao.getInviteNumber(userIds, day);
	}

}
