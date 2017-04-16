package com.demo.database.data;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * 圈子实体类
 * circleId代表在数据库的主键
 * 圈子名circleName
 * 圈子里的用户集合userSet
 * 圈子里已经发布了的消息集合messageSet
 * 圈子产生时间opertime
 * @author runningphoton
 *
 */
public class TDemoCircle implements Serializable {
	private Integer circleId;
	private String circleName;
	private Set<TDemoUser> userSet;
	private Set<TDemoCircleMessage> messageSet;
	private Timestamp opertime;

	public void addMessage(TDemoCircleMessage temp) {
		if (messageSet == null) {
			messageSet = new HashSet<TDemoCircleMessage>();
		}
		messageSet.add(temp);
	}

	public void addUser(TDemoUser temp) {
		if (userSet == null)
			userSet = new HashSet<TDemoUser>();
		userSet.add(temp);
	}

	public void removeUser(TDemoUser temp) {
		try {
			userSet.remove(temp);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public Integer getCircleId() {
		return circleId;
	}

	public void setCircleId(Integer circleId) {
		this.circleId = circleId;
	}

	public String getCircleName() {
		return circleName;
	}

	public void setCircleName(String circleName) {
		this.circleName = circleName;
	}

	public Set<TDemoUser> getUserSet() {
		return userSet;
	}

	public void setUserSet(Set<TDemoUser> userSet) {
		this.userSet = userSet;
	}

	public Set<TDemoCircleMessage> getMessageSet() {
		return messageSet;
	}

	public void setMessageSet(Set<TDemoCircleMessage> messageSet) {
		this.messageSet = messageSet;
	}

	public Timestamp getOpertime() {
		return opertime;
	}

	public void setOpertime(Timestamp opertime) {
		this.opertime = opertime;
	}
}