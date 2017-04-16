package com.demo.actions;

import java.util.List;

import com.demo.database.data.TDemoUser;
import com.demo.database.idao.IDaoService;
import com.demo.services.ILogService;
import com.opensymphony.xwork2.ActionSupport;

public class LogAction extends ActionSupport {
	private ILogService ilogService;
	private TDemoUser user;

	public ILogService getIloginService() {
		return ilogService;
	}

	public void setIloginService(ILogService iloginService) {
		this.ilogService = iloginService;
	}

	public TDemoUser getUser() {
		return user;
	}

	public void setUser(TDemoUser user) {
		this.user = user;
	}
	/**
	 * user!login.action
	 * 
	 */
	public String login() {
		try {
			System.out.println("userName : " + user.getUserName() + 
					" userPassword: " + user.getUserPassword());
			
			List<TDemoUser> list = (List<TDemoUser>) ilogService.login(user.getUserName(), user.getUserPassword());
			if(list.size() > 0) {
				this.user = list.get(0);
				return SUCCESS;
			}
			return "loginFail";
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}
	public String logout() {
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