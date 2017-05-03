package com.demo.actions;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

import com.demo.database.data.TDemoMessage;
import com.demo.database.data.TDemoTempUser;
import com.demo.database.data.TDemoUser;
import com.demo.database.idao.IDaoService;
import com.demo.services.ILogService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class LogAction extends ActionSupport {
	private ILogService ilogService;
	private TDemoUser user;
	private InputStream inputStream;
	private Map<String, Object> jsonResult;
	private String result;
	
	
	public InputStream getInputStream() {
		return inputStream;
	}

	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}

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
			System.out.println(baseUser);
			if(baseUser == null) {
				inputStream = new ByteArrayInputStream("fail".getBytes("UTF-8"));
			} else {
				this.user = baseUser;
				inputStream = new ByteArrayInputStream("success".getBytes("UTF-8"));
			}

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
//			ActionContext.getContext().getSession().put("user", this.user);
			return SUCCESS;
		} catch (Exception e) {
			System.out.println("执行login代码 catch");
			e.printStackTrace();
			return ERROR;
		}
	}
	public String userToJson() {
		result = null;
		TDemoTempUser temp = new TDemoTempUser();
    	temp.setUserName("123123");
    	temp.setUserPassword("jjjj");
    	JSONObject json=JSONObject.fromObject(temp);
        System.out.println(json);
        result = json.toString();
        response.getWriter().print(result);
        System.out.println("result " + result);
        return SUCCESS;
	}
//	public String userToJson(){
//		this.jsonResult = new HashMap<String, Object>();
//        String status = null;
//        try {
//        	
//        	System.out.println(this.user.getUserName() + " " + this.user.getUserPassword());
//        	this.user = ilogService.login(this.user.getUserName(), this.user.getUserPassword());
//        	if(this.user != null) {
//        		status = "1";
//            	
//        	} else {
//        		status = "0";
//        	}
//        	TDemoTempUser temp = new TDemoTempUser();
//        	temp.setUserName("123123");
//        	temp.setUserPassword("jjjj");
//    		System.out.println("debugUP1111");
//    		JSONObject json=JSONObject.fromObject(temp);
//    		System.out.println("debugUP");
//            System.out.println(json);
//    		System.out.println("debugDOWN");
//            result = json.toString();
//            System.out.println("result " + result);
//            return SUCCESS;
//        	
//        } catch (Exception e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//        return ERROR;
//    }
	public String logout() {
		System.out.println("执行logout代码");
		try {
			if(ilogService.logout(user)) {
				inputStream = new ByteArrayInputStream("success".getBytes("UTF-8"));
			} else {
				inputStream = new ByteArrayInputStream("fail".getBytes("UTF-8"));
			}
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}
	public String register() {
		try {
			System.out.println("执行register代码");
			if(ilogService.register(user)) {
				inputStream = new ByteArrayInputStream("success".getBytes("UTF-8"));
			} else {
				inputStream = new ByteArrayInputStream("fail".getBytes("UTF-8"));
			}
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}
}