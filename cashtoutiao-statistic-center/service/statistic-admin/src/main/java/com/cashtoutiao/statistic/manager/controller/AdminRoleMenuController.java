package com.cashtoutiao.statistic.manager.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cashtoutiao.statistic.common.response.Response;
import com.cashtoutiao.statistic.manager.bean.AdminRoleMenu;
import com.cashtoutiao.statistic.manager.bean.MenuInfo;
import com.cashtoutiao.statistic.manager.bean.ParentMenuInfo;
import com.cashtoutiao.statistic.manager.dto.response.MenuResponse;
import com.cashtoutiao.statistic.manager.service.AdminMenuInfoService;
import com.cashtoutiao.statistic.manager.service.AdminRoleMenuService;
import com.cashtoutiao.statistic.manager.service.AdminUserRoleService;
import com.huadongmedia.common.util.ListUtil;

@Controller
@RequestMapping("role/menu")
public class AdminRoleMenuController {

	@Autowired
	private AdminUserRoleService userRoleService;
	
	@Autowired
	private AdminRoleMenuService roleMenuService;
	
	@Autowired
	private AdminMenuInfoService adminMenuService;
	
	@RequestMapping("list")
	@ResponseBody
	public List<ParentMenuInfo> getIndexMenuByRoleCode(HttpServletRequest request){
		Integer userId = (Integer) request.getSession().getAttribute("userId");
		if (userId != null) {
			List<Integer> roleIds = userRoleService.getRoleByUserId(userId);
			List<MenuInfo> menuList = roleMenuService.getMenuIdByRole(roleIds);
			List<ParentMenuInfo> parentMenuList = new ArrayList<ParentMenuInfo>();
			Map<Integer,ParentMenuInfo> map = new HashMap<Integer, ParentMenuInfo>();
			if(menuList != null){
				for (MenuInfo menuInfo : menuList) {
					if(menuInfo.getParentId() == -1){
						ParentMenuInfo parentMenuInfo = new ParentMenuInfo(menuInfo.getId(), menuInfo.getTitle(), menuInfo.getIcon(), menuInfo.getUrl());
						parentMenuList.add(parentMenuInfo);
						map.put(menuInfo.getId(), parentMenuInfo);
					}
				}
				for (MenuInfo menuInfo : menuList) {
					if(menuInfo.getParentId() != -1){
						ParentMenuInfo parentMenuInfo = map.get(menuInfo.getParentId());
						if(parentMenuInfo.getChildren() == null){
							parentMenuInfo.setChildren(new ArrayList<MenuInfo>());
						}
						parentMenuInfo.getChildren().add(menuInfo);
					}
				}
				Iterator<ParentMenuInfo> iterator = parentMenuList.iterator();
				while(iterator.hasNext()){
					if(iterator.next().getChildren() == null){
						iterator.remove();
					}
				}
				return parentMenuList;
			}
		}
		return new ArrayList<ParentMenuInfo>();
	}
	
	@RequestMapping("list/permitted")
	@ResponseBody
	public MenuResponse getPermittedMenu(HttpServletRequest request){
		MenuResponse response = new MenuResponse();
		Integer userId = (Integer) request.getSession().getAttribute("userId");
		List<MenuInfo> allList = adminMenuService.getMenuInfoPage(null, null);
		List<Integer> roleIds = userRoleService.getRoleByUserId(userId);
		List<MenuInfo> menuList = roleMenuService.getMenuIdByRole(roleIds);
		List<Integer> permittedMenuIds = ListUtil.keyList(menuList, "id");
		for (MenuInfo menu : allList) {
			if(permittedMenuIds.contains(menu.getId())){
				menu.setPermitted(true);
			}
		}
		response.setList(allList);
		response.setStatusCode(Response.SUCCESS);
		return response;
	}
	
	@RequestMapping("save")
	@ResponseBody
	public Response save(String ids, Integer roleId){
		Response response = new Response();
		roleMenuService.delete(roleId);
		if(!"".equals(ids)){
			String[] idsArr = ids.split(",");
			List<AdminRoleMenu> roleMenus = new ArrayList<AdminRoleMenu>();
			for (String idStr : idsArr) {
				AdminRoleMenu roleMenu = new AdminRoleMenu();
				roleMenu.setRoleId(roleId);
				roleMenu.setMenuId(Integer.parseInt(idStr));
				roleMenus.add(roleMenu);
			}
			roleMenuService.save(roleMenus);
		}
		response.setMsg("修改成功");
		response.setStatusCode(Response.SUCCESS);
		return response;
	}
}
