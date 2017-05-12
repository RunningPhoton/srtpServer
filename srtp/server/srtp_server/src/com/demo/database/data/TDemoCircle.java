package com.demo.database.data;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;
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
 * 圈子的活跃度circleMarks
 * @author runningphoton
 *
 */
public class TDemoCircle implements Serializable {
	private Integer circleId;
	private String circleName;
	private String circleDescribe;
	private Integer circleMarks;
	private Set<TDemoUser> userSet;
	private Set<TDemoCircleMessage> messageSet;
	private Timestamp opertime;
	private String graphName;
	
	public boolean equals(TDemoCircle temp) {
		return this.circleName.equals(temp.circleName);
	}

	
	public String getGraphName() {
		return graphName;
	}

	public void setGraphName(String graphName) {
		this.graphName = graphName;
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
	
	public Integer getCircleMarks() {
		return circleMarks;
	}


	public void setCircleMarks(Integer circleMarks) {
		this.circleMarks = circleMarks;
	}


	public Set<TDemoUser> getUserSet() {
		return userSet;
	}

	public void setUserSet(Set<TDemoUser> userSet) {
		this.userSet = userSet;
	}

	
	public String getCircleDescribe() {
		return circleDescribe;
	}


	public void setCircleDescribe(String circleDescribe) {
		this.circleDescribe = circleDescribe;
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
