package com.demo.actions;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.demo.database.data.*;
import com.demo.database.idao.IDaoService;
import com.demo.database.idao.impl.DaoServiceImpl;
import com.demo.services.impl.LogServiceImpl;
import com.demo.services.impl.UserServiceImpl;
import com.opensymphony.xwork2.ActionContext;
import com.demo.tools.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javassist.bytecode.Descriptor.Iterator;

public class testAction {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContext.xml");
		
		IDaoService idaoService = (DaoServiceImpl) ctx.getBean("idaoService");
//		String hql = "select mes from TDemoMessage mes join mes.mainUser user where "
//				+ "user.userName='" + "user1" + "'";
//		try {
//			List<TDemoMessage> list = (List<TDemoMessage>) idaoService.query(hql);
//			if(list != null) {
//				for(int i = 0; i < list.size(); i++) {
//					TDemoMessage cur = list.get(i);
//					System.out.println(cur.getContent());
//				}
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		
//		UserServiceImpl userService = new UserServiceImpl();
//		LogServiceImpl logService = new LogServiceImpl();
//		logService.setIdaoService(idaoService);
//		userService.setIdaoService(idaoService);
		
//		LogAction logAction = new LogAction();
//		logAction.setIlogService(logService);
//		
//		UserAction userAction1 = new UserAction();
//		userAction1.setIuserService(userService);
//		
//		UserAction userAction2 = new UserAction();
//		userAction2.setIuserService(userService);
//		
//		UserAction userAction3 = new UserAction();
//		userAction3.setIuserService(userService);
//		
//		TDemoUser user1 = new TDemoUser();
//		user1.setUserName("user1");
//		user1.setUserPassword("user1");
//		user1.setUserNickname("RunningPhoton");
//		user1.setUserGender("男");
//		user1.setUserCollege("CQU");
//		
//		TDemoUser user2 = new TDemoUser();
//		user2.setUserName("user2");
//		user2.setUserPassword("user2");
//		user2.setUserNickname("Tom");
//		user2.setUserGender("男");
//		user2.setUserCollege("CQU");
//		
//		TDemoUser user3 = new TDemoUser();
//		user3.setUserName("user3");
//		user3.setUserPassword("user3");
//		user3.setUserNickname("Bob");
//		user3.setUserGender("男");
//		user3.setUserCollege("CQU");
//		
//		//测试
//		logAction.setUser(user1);
//		logAction.register();
//		logAction.login();
//		logAction.setUser(user2);
//		logAction.register();
//		logAction.login();
//		logAction.setUser(user3);
//		logAction.register();
//		logAction.login();
//		
//		
//		userAction1.setUser(user1);
//		userAction2.setUser(user2);
//		userAction3.setUser(user3);
//		
//		/**
//		 * 添加关注
//		 */
//		userAction1.setOperObject("user2");
//		userAction2.setOperObject("user1");
//		userAction3.setOperObject("user1");
//		userAction1.addFriend();
//		userAction2.addFriend();
//		userAction3.addFriend();
//		userAction1.setOperObject("user3");
//		userAction1.addFriend();
//		
//		userAction1.setOperContent("I am user1, I send to user2");
//		userAction2.setOperContent("I am user2, I send to user1");
//		userAction1.sendUserMessage(); 
//		userAction2.sendUserMessage();
//		
//		
//		userAction3.setOperObject("数学");
//		userAction1.setOperObject("数学");
//		userAction1.setOperContent("数学群");
//		userAction1.createCircle();
//		userAction3.setCircle();
//		userAction1.setCircle();
//		
//		userAction1.setOperContent("I am user1, I send to math");
//		userAction3.setOperContent("I am user3, I send to math");
//		userAction1.sendCircleMessage();
//		userAction3.sendCircleMessage();
		
		
//		userAction1.setOperObject(user3.getUserName());
//		userAction1.removeFriend();
//		
//		userAction1.setOperObject("数学");
//		userAction1.removeCircle();
		
//		Set<Object> s = new HashSet<Object>();
//		s.add(new TDemoImplUser("hyx", "23", "男", "CQU", ""));
//		s.add(new TDemoImplUser("ssss", "sss", "男", "CQU", ""));
//		Tools tool = new Tools();
//		tool.setToJson(s);
//		tool.objectToJson(new TDemoImplUser("hyx", "23", "男", "CQU", ""));
	}
}
