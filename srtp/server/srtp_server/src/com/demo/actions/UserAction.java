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
		TDemoUser tempUser = iuserService.findByUserName(this.user.getUserName());
		tempUser.setUserGender(this.user.getUserGender());
		tempUser.setUserCollege(this.user.getUserCollege());
		tempUser.setUserNickname(this.user.getUserNickname());
		tempUser.setUserPassword(this.user.getUserPassword());
		tempUser.setGraphName(this.user.getGraphName());
		this.user = tempUser;
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
			System.out.println("success执行addFriend");
			return SUCCESS;
		} catch (Exception e) {
			return ERROR;
		}
	}
	public String removeFriend() {
		this.user = iuserService.findByUserName(this.user.getUserName());
		try {
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
			System.out.println("success 执行setCircle");
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
			System.out.println("sendCircleMessage");
			iuserService.sendCircleMessage(this.user, operContent);
			System.out.println("success sendCircleMessage");
			return SUCCESS;
		} catch (Exception e) {
			return ERROR;
		}
	}
}
