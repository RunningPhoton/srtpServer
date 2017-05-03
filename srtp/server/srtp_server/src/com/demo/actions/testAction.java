package com.demo.actions;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.demo.database.data.TDemoCircle;
import com.demo.database.data.TDemoUser;
import com.demo.database.idao.IDaoService;
import com.demo.database.idao.impl.DaoServiceImpl;
import com.demo.services.impl.LogServiceImpl;
import com.demo.services.impl.UserServiceImpl;
import com.opensymphony.xwork2.ActionContext;

public class testAction {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContext.xml");
		
		IDaoService idaoService = (DaoServiceImpl) ctx.getBean("idaoService");
		UserServiceImpl userService = new UserServiceImpl();
		LogServiceImpl logService = new LogServiceImpl();
		logService.setIdaoService(idaoService);
		userService.setIdaoService(idaoService);
		
		LogAction logAction = new LogAction();
		logAction.setIlogService(logService);
		
		UserAction userAction1 = new UserAction();
		userAction1.setIuserService(userService);
		
		UserAction userAction2 = new UserAction();
		userAction2.setIuserService(userService);
		
		UserAction userAction3 = new UserAction();
		userAction3.setIuserService(userService);
		
		TDemoUser user1 = new TDemoUser();
		user1.setUserName("user1");
		user1.setUserPassword("user1");
		user1.setUserNickname("RunningPhoton");
		user1.setUserGender("男");
		user1.setUserCollege("CQU");
		
		TDemoUser user2 = new TDemoUser();
		user2.setUserName("user2");
		user2.setUserPassword("user2");
		user2.setUserNickname("Tom");
		user2.setUserGender("男");
		user2.setUserCollege("CQU");
		
		TDemoUser user3 = new TDemoUser();
		user3.setUserName("user3");
		user3.setUserPassword("user3");
		user3.setUserNickname("Bob");
		user3.setUserGender("男");
		user3.setUserCollege("CQU");
		
		//测试
		logAction.setUser(user1);
		logAction.register();
		logAction.login();
		logAction.setUser(user2);
		logAction.register();
		logAction.login();
		logAction.setUser(user3);
		logAction.register();
		logAction.login();
		
		
		userAction1.setUser(user1);
		userAction2.setUser(user2);
		userAction3.setUser(user3);
		
		/**
		 * 添加关注
		 */
		userAction1.setOperObject("user2");
		userAction2.setOperObject("user1");
		userAction3.setOperObject("user1");
		userAction1.addFriend();
		userAction2.addFriend();
		userAction3.addFriend();
		userAction1.setOperObject("user3");
		userAction1.addFriend();
		
		userAction1.setOperContent("I am user1, I send to user2");
		userAction2.setOperContent("I am user2, I send to user1");
		userAction1.sendUserMessage(); userAction2.sendUserMessage();
		
		
		userAction3.setOperObject("数学");
		userAction1.setOperObject("数学");
		userAction3.setCircle();
		userAction1.setCircle();
		
		userAction1.setOperContent("I am user1, I send to math");
		userAction3.setOperContent("I am user3, I send to math");
		userAction1.sendCircleMessage();
		userAction3.sendCircleMessage();
		
//		Object user = ActionContext.getContext().getContextMap().get("user");
//		System.out.println(user);
		
//		userAction1.setOperObject(user3.getUserName());
//		userAction1.removeFriend();
//		
//		userAction1.setOperObject("数学");
//		userAction1.removeCircle();
	}
}
