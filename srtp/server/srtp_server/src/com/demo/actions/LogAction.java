package com.demo.actions;

import java.util.Iterator;
import java.util.List;

import com.demo.database.data.TDemoMessage;
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
		try {

			System.out.println("执行login代码");
			System.out.println(user.getUserName() + " " + user.getUserPassword());
			TDemoUser baseUser = ilogService.login(user.getUserName(), user.getUserPassword());
			if(baseUser == null) 
				return "fail";

			/**
			 * 测试User登录后是否集合类自动加载
			 */
//			Iterator<TDemoUser> itFriend = baseUser.getUserFriendSet().iterator();
//			while(itFriend.hasNext()) {
//				TDemoUser temp = itFriend.next();
//				System.out.println(temp.getUserName());
//			}
//			System.out.println(baseUser.getUserCircle().getCircleName());
//			Iterator<TDemoMessage> itUserMessage = baseUser.getUserMessageSendSet().iterator();
//			while(itUserMessage.hasNext()) {
//				TDemoMessage ms = itUserMessage.next();
//				System.out.println(ms.getMessageContent());
//			}
//			System.out.println(baseUser.getUserMessageGetSet().size());
//			System.out.println(baseUser.getUserMessageSendSet().size());
			
			return SUCCESS;
		} catch (Exception e) {
			System.out.println("执行login代码 catch");
			e.printStackTrace();
			return ERROR;
		}
	}
	public String logout() {
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
		try {

			System.out.println("执行register代码");
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