package com.demo.services.impl;

import java.sql.Timestamp;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import com.demo.database.data.TDemoCircle;
import com.demo.database.data.TDemoCircleMessage;
import com.demo.database.data.TDemoMessage;
import com.demo.database.data.TDemoUser;
import com.demo.database.idao.IDaoService;
import com.demo.services.IUserService;


/**
 * 用户操作业务逻辑实现类
 * @author runningphoton
 *
 */
public class UserServiceImpl implements IUserService {
	private IDaoService idaoService;

	public IDaoService getIdaoService() {
		return idaoService;
	}

	public void setIdaoService(IDaoService idaoService) {
		this.idaoService = idaoService;
	}


	/**
	 * 通过userName来找到用户
	 */
	@Override
	public TDemoUser findByUserName(String userName) {
		String hql = "from TDemoUser where userName='"+userName+"'";
		try {
			List<TDemoUser> list = (List<TDemoUser>) idaoService.query(hql);
			if(list != null) 
				return list.get(0);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return null;
	}

	/**
	 * 通过ciecleName来查找circle，找不到就创建一个
	 */
	@Override
	public TDemoCircle findByCircleName(String circleName) {
		String hql = "from TDemoCircle where circleName='" + circleName + "'";
		try {
			List<TDemoCircle> list = (List<TDemoCircle>) idaoService.query(hql);
//			System.out.println(list);
			if(list == null || list.size() == 0) {
				TDemoCircle circle = new TDemoCircle();
				circle.setCircleName(circleName);
				circle.setOpertime(new Timestamp(System.currentTimeMillis()));
				idaoService.save(circle);
				List<TDemoCircle> list2 = (List<TDemoCircle>) idaoService.query(hql);
				return list2.get(0);
			}
			return list.get(0);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 用数据库中最新的数据来刷新user
	 */
	@Override
	public void fresh(TDemoUser user) throws Exception {
		user = findByUserName(user.getUserName());
	}

	/**
	 * 添加朋友
	 */
	@Override
	public void addFriend(TDemoUser user, String userName) throws Exception {
		TDemoUser user1 = this.findByUserName(userName);
		/**
		 * test
		 */
		System.out.println(user.getUserName() + " add friend " + user1.getUserName());
		System.out.println(user.getUserFriendSet().size() + " * " + user1.getUserFriendSet().size());
		user.getUserFriendSet().add(user1);
		user1.getUserBeenFriendSet().add(user);
		System.out.println(user.getUserFriendSet().size() + " * " + user1.getUserFriendSet().size());
		idaoService.update(user);
		System.out.println(user.getUserName() + " true add friend " + user1.getUserName());
	}

	/**
	 * 删除朋友，传入朋友的用户名
	 */
	@Override
	public void removeFriend(TDemoUser user, String userName) throws Exception {
		TDemoUser user1 = this.findByUserName(userName);
		if(user1 != null) {
//			user.getUserFriendSet().remove(user1);
//			user1.getUserBeenFriendSet().remove(user);
			System.out.println(user.getUserFriendSet().size());
			
			Iterator iter = user.getUserFriendSet().iterator();
			while(iter.hasNext()) {
				TDemoUser temp = (TDemoUser) iter.next();
				System.out.println(temp.getUserName() + "    " + user1.getUserName());
				if(temp.equals(user1)) 
					iter.remove();
			}
			System.out.println(user.getUserFriendSet().size());
			idaoService.update(user);
		}
	}

	/**
	 * 设置圈子
	 */
	@Override
	public void setCircle(TDemoUser user, String circleName) throws Exception {
		TDemoCircle circle = this.findByCircleName(circleName);
		
		System.out.println(circle.getCircleName());
		
		circle.getUserSet().add(user);
		user.setUserCircle(circle);
		System.out.println("debug1");
//		idaoService.update(circle);
		System.out.println("debug2");
		idaoService.update(user);
		System.out.println("debug3");
	}

	/**
	 * 移除圈子
	 */
	@Override
	public void removeCircle(TDemoUser user, String circleName) throws Exception {
		TDemoCircle circle = this.findByCircleName(circleName);
//		circle.getUserSet().remove(user);
		Iterator iter = circle.getUserSet().iterator();
		while(iter.hasNext()) {
			if(iter.next().equals(user)) {
				iter.remove();
			}
		}
		idaoService.update(circle);
		user.setUserCircle(null);
		idaoService.update(user);
	}
	/**
	 * 向用户发送消息
	 */
	@Override
	public void sendUserMessage(TDemoUser user, String messageContent, String userName)
			throws Exception {
		TDemoMessage message = new TDemoMessage();
		TDemoUser user1 = this.findByUserName(userName);
		message.setMainUser(user);
		message.setInferiorUser(user1);
		message.setOpertime(new Timestamp(System.currentTimeMillis()));
		message.setMessageContent(messageContent);
		user.getUserMessageSendSet().add(message);
		user1.getUserMessageGetSet().add(message);

		idaoService.save(message);
		idaoService.update(user);
		idaoService.update(user1);
	}

	/**
	 * 向圈子发送消息
	 */
	@Override
	public void sendCircleMessage(TDemoUser user, String circleMessageContent) throws Exception {
		

		System.out.println("debug1");
		System.out.println(user.getUserName());
		TDemoCircle circle = this.findByCircleName(user.getUserCircle().getCircleName());
		TDemoCircleMessage circleMessage = new TDemoCircleMessage();
		circleMessage.setCircle(circle);
		circleMessage.setCircleMessageContent(circleMessageContent);
		circleMessage.setOpertime(new Timestamp(System.currentTimeMillis()));
		circleMessage.setUser(user);
		System.out.println("debug11");
		idaoService.save(circleMessage);
		
		System.out.println("debug111");
		Set<TDemoCircleMessage> se = circle.getMessageSet();
		System.out.println("debug1111");
		se.add(circleMessage);

		System.out.println("debug2");
		idaoService.update(circle);
		System.out.println("debug3");
	}

	/**
	 * 更新用户信息
	 */
	@Override
	public boolean update(TDemoUser user) {
		
		try {
			idaoService.update(user);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
