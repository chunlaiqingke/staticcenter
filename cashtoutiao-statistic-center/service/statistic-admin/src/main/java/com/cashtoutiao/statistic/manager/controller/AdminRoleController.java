package com.cashtoutiao.statistic.manager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cashtoutiao.statistic.common.response.Response;
import com.cashtoutiao.statistic.manager.bean.AdminRoleInfo;
import com.cashtoutiao.statistic.manager.dto.response.RoleResponse;
import com.cashtoutiao.statistic.manager.service.AdminRoleService;

@Controller
@RequestMapping("role")
public class AdminRoleController {

	@Autowired
	private AdminRoleService roleService;
	
	@RequestMapping("list")
	@ResponseBody
	public RoleResponse getRoleList(int page, int limit){
		RoleResponse response = new RoleResponse();
		List<AdminRoleInfo> roles = roleService.getRolePage(page, limit);
		int total = roleService.getTotalCount();
		response.setStatusCode(Response.SUCCESS);
		response.setList(roles);
		response.setTotal(total);
		return response;
	}
}
