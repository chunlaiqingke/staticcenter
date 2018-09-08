package com.cashtoutiao.statistic.invite.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cashtoutiao.statistic.common.bean.ReceiveRecord;
import com.cashtoutiao.statistic.common.response.ChartResponse;
import com.cashtoutiao.statistic.common.response.Response;
import com.cashtoutiao.statistic.invite.bean.InviteNumber;
import com.cashtoutiao.statistic.invite.service.InviteService;
import com.cashtoutiao.statistic.statistic.service.AdminDailyOwnStatisticRecordService;
import com.cashtoutiao.statistic.user.bean.UserInfo;
import com.cashtoutiao.statistic.user.service.UserInfoService;
import com.huadongmedia.common.util.DateUtil;
import com.huadongmedia.common.util.ListUtil;

@Controller
@RequestMapping("invite")
public class InviteController {
	
	@Autowired
	private AdminDailyOwnStatisticRecordService adminDailyOwnStatisticService;
	
	@Autowired
	private UserInfoService userService;
	
	@Autowired
	private InviteService inviteService;

	@RequestMapping(value = "payout")
	@ResponseBody
	public ChartResponse<String, ReceiveRecord> getInvitePayout(String day){
		ChartResponse<String, ReceiveRecord> response = new ChartResponse<String, ReceiveRecord>();
		if(day == null){
			day = DateUtil.toString(new Date(), DateUtil.ymdDash.get());
		}
		List<ReceiveRecord> list = adminDailyOwnStatisticService.getInviteExpense(day);
		List<String> days = ListUtil.keyList(list, "day");
		response.setStatusCode(Response.SUCCESS);
		response.setCategories(days);
		response.setFirstList(list);
		return response;
	}
	
	@RequestMapping("number")
	@ResponseBody
	public ChartResponse<String, Integer> getInviteNumber(String day){
		ChartResponse<String, Integer> response = new ChartResponse<String, Integer>();
		if(day == null){
			day = DateUtil.toString(DateUtil.addTimes(new Date(), Calendar.DAY_OF_MONTH, -1), DateUtil.ymdDash.get());
		}
		
		List<Integer> inviters = new ArrayList<Integer>();
		List<Integer> invitees = new ArrayList<Integer>();
		List<String> categories = new ArrayList<String>();
			
		List<UserInfo> userInfoList = userService.getUserInfosByRegisterDay(day);
		List<Long> userIds = ListUtil.keyList(userInfoList, "id");
		InviteNumber inviteNumber = inviteService.getInviteNumber(ListUtil.isEmpty(userIds) ? null : userIds, day);
		inviters.add(inviteNumber.getInviters());
		invitees.add(inviteNumber.getInvitees());
		categories.add(day);
		
		response.setCategories(categories);
		response.setFirstList(inviters);
		response.setSecondList(invitees);
		response.setStatusCode(Response.SUCCESS);
		return response;
	}
}
