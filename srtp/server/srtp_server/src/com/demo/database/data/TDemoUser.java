package com.demo.database.data;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * 用户实体类 userId是在数据库的主键 userGender是用户性别 userNickname是昵称 userName是用户名
 * userPassword是密码 userCollege是学校 userGraph是头像名称 userFriendSet是好友集合
 * userMessageSet是和好友聊天内容列表 userCircle是加入的圈子名称
 * 
 * @author runningphoton
 *
 */
public class TDemoUser implements Serializable {

	private Integer userId;
	private String userGender;
	private String userNickname;
	private String userName;
	private String userPassword;
	private String userCollege;
	private String graphName;
	private Set<TDemoUser> userFriendSet;
	private Set<TDemoMessage> userMessageSendSet;
	private Set<TDemoMessage> userMessageGetSet;
	private TDemoCircle userCircle;
	private Integer online;
	private Integer userAuthority;
	private Timestamp opertime;

	public String getUserGender() {
		return userGender;
	}

	public void setUserGender(String userGender) {
		this.userGender = userGender;
	}

	public void addUserMessageGet(TDemoMessage temp) {
		if (userMessageGetSet == null)
			userMessageGetSet = new HashSet<TDemoMessage>();
		userMessageGetSet.add(temp);
	}

	public void addUserMessage(TDemoMessage temp) {
		if (userMessageSendSet == null)
			userMessageSendSet = new HashSet<TDemoMessage>();
		userMessageSendSet.add(temp);
		temp.getInferiorUser().addUserMessageGet(temp);
	}

	public void addCircleMessage(TDemoCircleMessage temp) {
		try {
			userCircle.addMessage(temp);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void removeFriend(TDemoUser temp) {
		try {
			userFriendSet.remove(temp);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void addFriend(TDemoUser temp) {
		if (userFriendSet == null)
			userFriendSet = new HashSet<TDemoUser>();
		userFriendSet.add(temp);
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserNickname() {
		return userNickname;
	}

	public void setUserNickname(String userNickname) {
		this.userNickname = userNickname;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserCollege() {
		return userCollege;
	}

	public void setUserCollege(String userCollege) {
		this.userCollege = userCollege;
	}

	public String getGraphName() {
		return graphName;
	}

	public void setGraphName(String graphName) {
		this.graphName = graphName;
	}

	public Set<TDemoUser> getUserFriendSet() {
		return userFriendSet;
	}

	public void setUserFriendSet(Set<TDemoUser> userFriendSet) {
		this.userFriendSet = userFriendSet;
	}

	public Set<TDemoMessage> getUserMessageSendSet() {
		return userMessageSendSet;
	}

	public void setUserMessageSendSet(Set<TDemoMessage> userMessageSendSet) {
		this.userMessageSendSet = userMessageSendSet;
	}

	public Set<TDemoMessage> getUserMessageGetSet() {
		return userMessageGetSet;
	}

	public void setUserMessageGetSet(Set<TDemoMessage> userMessageGetSet) {
		this.userMessageGetSet = userMessageGetSet;
	}

	public TDemoCircle getUserCircle() {
		return userCircle;
	}

	public void setUserCircle(TDemoCircle userCircle) {
		this.userCircle = userCircle;
	}

	public void removeUserCircle() {
		this.userCircle.removeUser(this);
		this.userCircle = null;
	}

	public Integer getOnline() {
		return online;
	}

	public void setOnline(Integer online) {
		this.online = online;
	}

	public Integer getUserAuthority() {
		return userAuthority;
	}

	public void setUserAuthority(Integer userAuthority) {
		this.userAuthority = userAuthority;
	}

	public Timestamp getOpertime() {
		return opertime;
	}

	public void setOpertime(Timestamp timestamp) {
		this.opertime = timestamp;
	}

}