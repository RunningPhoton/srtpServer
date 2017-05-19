package com.demo.actions;

import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.demo.database.data.TDemoCircle;
import com.demo.database.data.TDemoCircleMessage;
import com.demo.database.data.TDemoImplMessage;
import com.demo.database.data.TDemoImplUser;
import com.demo.database.data.TDemoMessage;
import com.demo.database.data.TDemoUser;
import com.demo.database.idao.IDaoService;
import com.demo.services.IUserService;
import com.demo.tools.Tools;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport {
	private TDemoUser user;
	private String operObject;
	private String operContent;
	private IUserService iuserService;
	private JSONArray many;
	private JSONObject one;
	
	public JSONObject getOne() {
		return one;
	}

	public void setOne(JSONObject one) {
		this.one = one;
	}

	public JSONArray getMany() {
		return many;
	}

	public void setMany(JSONArray many) {
		this.many = many;
	}

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
	
	
	
	/**
	 * 列出用户添加的关注的人的信息，该行为需要客户端设置user.userName
	 * @return
	 */
	public String listWhoIAdd() {
		try {
			TDemoUser tempUser = iuserService.findByUserName(this.user.getUserName());
			this.many = iuserService.listUserSets(tempUser.getUserFriendSet());
			return "many";
		} catch (Exception e) {
			System.out.println(e);
			return ERROR;
		}
	}
	
	
	/**
	 * 列出该用户被哪些人添加了，该行为需要客户端设置user.userName
	 * @return
	 */
	public String listWhoAddMe() {
		try {
			TDemoUser tempUser = iuserService.findByUserName(this.user.getUserName());
			this.many = iuserService.listUserSets(tempUser.getUserBeenFriendSet());
			return "many";
		} catch (Exception e) {
			System.out.println(e);
			return ERROR;
		}
	}
	
	/**
	 * 列出圈子的用户信息，该行为需要设置operObject作为圈子名
	 * @return
	 */
	public String listCircleUser() {
		try {
			TDemoCircle circle = iuserService.findByCircleName(operObject);
			this.many = iuserService.listUserSets(circle.getUserSet());
			return "many";
		} catch (Exception e) {
			System.out.println(e);
			return ERROR;
		}
	}
	
	
	/**
	 * 将operObject作为圈子名，来查找圈子，在返回json字符串表示圈子的消息
	 * @param objSet
	 * @return
	 */
	public String listCircleMessage() {
		try {
			TDemoCircle circle = iuserService.findByCircleName(operObject);
			Set<TDemoImplMessage> obj = new HashSet<TDemoImplMessage> ();
			Iterator iter = circle.getMessageSet().iterator();
			while(iter.hasNext()) {
				TDemoCircleMessage cur = (TDemoCircleMessage) iter.next();
				obj.add(new TDemoImplMessage(cur.getUser().getUserName(), 
						cur.getCircleMessageContent(), new Date(cur.getOpertime().getTime())));
				System.out.println(new Date(cur.getOpertime().getTime()));
			}
			this.many = iuserService.listMessageSets(obj);
			return "many";
		} catch (Exception e) {
			System.out.println(e);
			return ERROR;
		}
	}
	
	/**
	 * 更新用户信息，更新成功之后返回该用户新信息json，失败返回null
	 * @return
	 */
	public String update() {
		TDemoUser tempUser = iuserService.findByUserName(this.user.getUserName());
		tempUser.setUserGender(this.user.getUserGender());
		tempUser.setUserCollege(this.user.getUserCollege());
		tempUser.setUserNickname(this.user.getUserNickname());
		tempUser.setUserPassword(this.user.getUserPassword());
		tempUser.setGraphName(this.user.getGraphName());
		tempUser.setUserDescribe(this.user.getUserDescribe());
		this.user = tempUser;
		System.out.println("执行update");
		if(iuserService.update(this.user)) {
			
			try {
				this.one = iuserService.listUser(this.user);
				return "one";
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			this.one = null;
		}
		return "one";
	}
	/**
	 * 根据用户名查找用户
	 * @return
	 */
	public String listUser() {
		System.out.println("listUser");
		TDemoUser op = iuserService.findByUserName(operObject);
		try {
			this.one = iuserService.listUser(op);
			return "one";
		} catch (Exception e) {
			System.out.println(e);
			return ERROR;
		}
	}
	/**
	 * 添加关注用户，需要用户名，被关注的用户名
	 * @return
	 */
	public String addFriend() {
		this.user = iuserService.findByUserName(this.user.getUserName());
		try {
			iuserService.addFriend(this.user, operObject);
			return this.listWhoIAdd();
		} catch (Exception e) {
			return ERROR;
		}
	}
	/**
	 * 移除关注用户，需要用户名，被关注的用户名
	 * @return
	 */
	public String removeFriend() {
		this.user = iuserService.findByUserName(this.user.getUserName());
		try {
			iuserService.removeFriend(this.user, operObject);

			return this.listWhoIAdd();
		} catch (Exception e) {
			return ERROR;
		}
	}
	/**
	 * 创建圈子，需要用户名，圈子名，圈子描述
	 * @return
	 */
	public String createCircle() {
		try {
			if(iuserService.createCircle(this.operObject, this.operContent)) {
				this.setCircle();
				this.one = iuserService.listMyCircle(this.user);
			}
			return "one";
		} catch (Exception e) {
			System.out.println(e);
			return ERROR;
		}
	}
	/**
	 * 列出圈子消息，若用户没有关注任何圈子，则展示所有圈子信息
	 * @return
	 */
	public String listCircle() {
		this.user = iuserService.findByUserName(this.user.getUserName());
		try {
			if(this.user.getUserCircle() == null) {
				return listAllCircle();
			}
			this.one = iuserService.listMyCircle(this.user);
			return "one";
		} catch (Exception e) {
			System.out.println(e);
			return ERROR;
		}
	}
	/**
	 * 展示所有的圈子信息
	 * @return
	 */
	public String listAllCircle() {
		try {
			this.many = iuserService.listAllCircle();
			return "many";
		} catch (Exception e) {
			System.out.println(e);
			return ERROR;
		}
	}
	/**设置用户的圈子信息
	 * 
	 * @return
	 */
	public String setCircle() {
		this.user = iuserService.findByUserName(this.user.getUserName());
		try {
			System.out.println("执行setCircle");
			iuserService.setCircle(this.user, operObject);
			return this.listCircle();
		} catch (Exception e) {
			return ERROR;
		}
	}
	public String removeCircle() {
		this.user = iuserService.findByUserName(this.user.getUserName());
		try {
			iuserService.removeCircle(this.user, operObject);
			return this.listAllCircle();
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
