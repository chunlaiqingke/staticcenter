package com.cashtoutiao.statistic.manager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cashtoutiao.statistic.common.response.Response;
import com.cashtoutiao.statistic.manager.bean.AdminUser;
import com.cashtoutiao.statistic.manager.dto.response.UserResponse;
import com.cashtoutiao.statistic.manager.service.AdminUserService;

@Controller
@RequestMapping("user")
public class AdminUserController {

	@Autowired
	private AdminUserService userService;
	
	@RequestMapping("list")
	@ResponseBody
	public UserResponse getUserListPage(int page, int limit){
		UserResponse response = new UserResponse();
		List<AdminUser> list = userService.getUserListPage(page, limit);
		int total = userService.getTotalCount();
		response.setList(list);
		response.setTotal(total);
		response.setStatusCode(Response.SUCCESS);
		return response;
	}
}
