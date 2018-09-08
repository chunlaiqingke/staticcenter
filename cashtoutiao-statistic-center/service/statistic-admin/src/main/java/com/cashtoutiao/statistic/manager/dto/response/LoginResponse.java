package com.cashtoutiao.statistic.manager.dto.response;

import com.cashtoutiao.statistic.common.response.Response;
import com.cashtoutiao.statistic.manager.bean.AdminUser;

public class LoginResponse extends Response {

	private AdminUser adminUser;

	public AdminUser getAdminUser() {
		return adminUser;
	}

	public void setAdminUser(AdminUser adminUser) {
		this.adminUser = adminUser;
	}
}
