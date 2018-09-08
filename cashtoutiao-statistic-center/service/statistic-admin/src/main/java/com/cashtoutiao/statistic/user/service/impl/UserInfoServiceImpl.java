package com.cashtoutiao.statistic.user.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cashtoutiao.statistic.user.bean.UserInfo;
import com.cashtoutiao.statistic.user.dao.UserInfoDao;
import com.cashtoutiao.statistic.user.service.UserInfoService;

@Service
public class UserInfoServiceImpl implements UserInfoService {

	@Autowired
	private UserInfoDao userInfoDao;
	
	@Override
	public List<UserInfo> getUserInfosByRegisterDay(String day) {
		return userInfoDao.getUserInfosByRegisterDay(day);
	}
}
