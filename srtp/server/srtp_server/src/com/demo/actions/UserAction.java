package com.demo.actions;

import com.demo.database.data.TDemoUser;
import com.demo.database.idao.IDaoService;
import com.demo.services.IUserService;
import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport {
	private TDemoUser user;
	private String operObject;
	private String operContent;
	private IUserService iuserService;
	
	public IUserService getIuserService() {
		return iuserService;
	}

	public void setIuserService(IUserService iuserService) {
		this.iuserService = iuserService;
	}

	public TDemoUser getUser() {
		return user;
	}

	public void setUser(TDemoUser user) {
		this.user = user;
	}

	public String getOperObject() {
		return operObject;
	}

	public void setOperObject(String operObject) {
		this.operObject = operObject;
	}

	public String getOperContent() {
		return operContent;
	}

	public void setOperContent(String operContent) {
		this.operContent = operContent;
	}

	
	
	
	public String update() {
		System.out.println("执行update");
		if(iuserService.update(this.user)) {
			return SUCCESS;
		} else {
			return ERROR;
		}
	}
	
	public String addFriend() {
		this.user = iuserService.findByUserName(this.user.getUserName());
		try {
			System.out.println("执行addFriend");
			iuserService.addFriend(this.user, operObject);
			return SUCCESS;
		} catch (Exception e) {
			return ERROR;
		}
	}
	public String removeFriend() {
		this.user = iuserService.findByUserName(this.user.getUserName());
		try {
			System.out.println("执行removeFriend");
			iuserService.removeFriend(this.user, operObject);
			return SUCCESS;
		} catch (Exception e) {
			return ERROR;
		}
	}
	public String setCircle() {
		this.user = iuserService.findByUserName(this.user.getUserName());
		try {
			System.out.println("执行setCircle");
			iuserService.setCircle(this.user, operObject);
			return SUCCESS;
		} catch (Exception e) {
			return ERROR;
		}
	}
	public String removeCircle() {
		this.user = iuserService.findByUserName(this.user.getUserName());
		try {
			System.out.println("执行removeCircle");
			iuserService.removeCircle(this.user, operObject);
			return SUCCESS;
		} catch (Exception e) {
			return ERROR;
		}
	}
	public String sendUserMessage() {
		this.user = iuserService.findByUserName(this.user.getUserName());
		try {
			System.out.println("执行sendUserMessage");
			iuserService.sendUserMessage(this.user, operContent, operObject);
			return SUCCESS;
		} catch (Exception e) {
			return ERROR;
		}
	}
	public String sendCircleMessage() {
		this.user = iuserService.findByUserName(this.user.getUserName());
		try {
			System.out.println("执行sendCircleMessage");
			iuserService.sendCircleMessage(this.user, operContent);
			return SUCCESS;
		} catch (Exception e) {
			return ERROR;
		}
	}
}
