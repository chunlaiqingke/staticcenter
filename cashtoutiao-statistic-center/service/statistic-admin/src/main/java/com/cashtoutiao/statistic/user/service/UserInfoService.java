package com.cashtoutiao.statistic.user.service;

import java.util.List;

import com.cashtoutiao.statistic.user.bean.UserInfo;

public interface UserInfoService {

	public List<UserInfo> getUserInfosByRegisterDay(String day);
}
