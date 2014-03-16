package com.lyq.action.admin;

import com.opensymphony.xwork2.ActionSupport;

public class Login extends ActionSupport {

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		return SUCCESS;
	}

	public String loadBody() {

		return "admin_body";
	}

	public String loadMenu() {

		return "admin_menu";
	}

}
