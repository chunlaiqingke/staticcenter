package com.cashtoutiao.statistic.user.dao;

import java.util.List;

import com.cashtoutiao.statistic.user.bean.UserInfo;

public interface UserInfoDao {

	List<UserInfo> getUserInfosByRegisterDay(String day);

}
