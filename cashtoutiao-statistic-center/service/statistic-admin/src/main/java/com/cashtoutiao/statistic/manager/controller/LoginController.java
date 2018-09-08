package com.cashtoutiao.statistic.manager.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.cashtoutiao.statistic.common.response.Response;
import com.cashtoutiao.statistic.manager.bean.AdminUser;
import com.cashtoutiao.statistic.manager.dto.response.LoginResponse;
import com.cashtoutiao.statistic.manager.service.AdminUserService;

@Controller
@RequestMapping("login")
public class LoginController {
	
	@Autowired
	private AdminUserService userService;

	@RequestMapping("name")
	@ResponseBody
	public LoginResponse login(AdminUser adminUser, HttpServletRequest request){
		LoginResponse response = new LoginResponse();
		AdminUser user = userService.getUserInfoByName(adminUser.getUserName(), adminUser.getPassword());
		if(user != null){
			request.getSession().setAttribute("userId", user.getUserId());
			request.getSession().setAttribute("userName", user.getUserName());
			request.getSession().setMaxInactiveInterval(6 * 60 * 60);
			response.setAdminUser(user);
			response.setStatusCode(Response.SUCCESS);
			response.setMsg("登录成功");
			return response;
		}
		response.setStatusCode(Response.FAILED);
		response.setMsg("用户名或密码错误");
		return response;
	}
	
	@RequestMapping("logout")
	public ModelAndView logout(HttpServletRequest request){
		ModelAndView mav = new ModelAndView("redirect:/login.html");
		request.getSession().removeAttribute("userId");
		request.getSession().removeAttribute("userName");
		return mav;
	}
}
