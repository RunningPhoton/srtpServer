package com.demo.actions;

import java.util.List;

import com.demo.database.data.TDemoUser;
import com.demo.database.idao.IDaoService;
import com.demo.services.ILogService;
import com.opensymphony.xwork2.ActionSupport;

public class LogAction extends ActionSupport {
	private ILogService ilogService;
	private TDemoUser user;

	public ILogService getIlogService() {
		return ilogService;
	}

	public void setIlogService(ILogService ilogService) {
		this.ilogService = ilogService;
	}

	public TDemoUser getUser() {
		return user;
	}

	public void setUser(TDemoUser user) {
		this.user = user;
	}
	/**
	 * log!login.action
	 * 
	 */
	public String login() {
		System.out.println("执行login代码");
		try {

			System.out.println(user.getUserName() + " " + user.getUserPassword());
			System.out.println(ilogService);
			TDemoUser baseUser = ilogService.login(user.getUserName(), user.getUserPassword());
			if(baseUser == null) 
				return "fail";
			return SUCCESS;
		} catch (Exception e) {
			System.out.println("执行login代码 catch");
			e.printStackTrace();
			return ERROR;
		}
	}
	public String logout() {
		System.out.println(ilogService);
		System.out.println("执行logout代码");
		try {
			if(ilogService.logout(user))
				return SUCCESS;
			else 
				return ERROR;
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}
	public String register() {
		System.out.println(ilogService);
		System.out.println("执行register代码");
		try {
			if(ilogService.register(user)) 
				return SUCCESS;
			else 
				return ERROR;
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}
}