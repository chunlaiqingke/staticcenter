package com.cashtoutiao.statistic.manager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cashtoutiao.statistic.common.response.Response;
import com.cashtoutiao.statistic.manager.bean.MenuInfo;
import com.cashtoutiao.statistic.manager.dto.response.MenuResponse;
import com.cashtoutiao.statistic.manager.service.AdminMenuInfoService;

@Controller
@RequestMapping("menu")
public class AdminMenuController {

	@Autowired
	private AdminMenuInfoService adminMenuService;
	
	@RequestMapping("list")
	@ResponseBody
	public MenuResponse getMenuList(Integer page, Integer limit){
		MenuResponse response = new MenuResponse();
		List<MenuInfo> list = adminMenuService.getMenuInfoPage(page, limit);
		int total = adminMenuService.getTotalCount();
		response.setList(list);
		response.setTotal(total);
		response.setStatusCode(Response.SUCCESS);
		return response;
	}
	
	@RequestMapping("parents")
	@ResponseBody
	public MenuResponse getParents(){
		MenuResponse response = new MenuResponse();
		List<MenuInfo> parentMenus = adminMenuService.getAllParentMenu();
		response.setList(parentMenus);
		response.setStatusCode(Response.SUCCESS);
		return response;
	}
	
	@RequestMapping("save")
	@ResponseBody
	public Response save(Integer menuId, String menuName, String menuIcon, String menuUrl, Integer parentId ){
		Response response = new Response();
		boolean result = adminMenuService.save(menuId, menuName, menuIcon, menuUrl, parentId);
		if(result){
			response.setStatusCode(Response.SUCCESS);
			response.setMsg("修改成功");
			return response;
		}
		response.setStatusCode(Response.FAILED);
		response.setMsg("修改失败");
		return response;
	}
}
