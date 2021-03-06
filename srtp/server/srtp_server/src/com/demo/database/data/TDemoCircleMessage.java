package com.demo.database.data;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;

/**
 * 圈子消息实体类
 * 包括圈子消息在数据库中的编号circleMessageId，发布消息的user编号userId
 * 圈子的circleId，和内容circleMessageContent以及发布时间opertime
 * 在客户端刷新消息的时候按照opertime排序
 * @author runningphoton
 *
 */
public class TDemoCircleMessage implements Serializable {
	private Integer circleMessageId;
	private TDemoCircle circle;
	private TDemoUser user;
	private String circleMessageContent;
	private Timestamp opertime;
	
	

	public Integer getCircleMessageId() {
		return circleMessageId;
	}
	public void setCircleMessageId(Integer circleMessageId) {
		this.circleMessageId = circleMessageId;
	}
	public TDemoCircle getCircle() {
		return circle;
	}
	public void setCircle(TDemoCircle circle) {
		this.circle = circle;
	}
	public TDemoUser getUser() {
		return user;
	}
	public void setUser(TDemoUser user) {
		this.user = user;
	}
	public String getCircleMessageContent() {
		return circleMessageContent;
	}
	public void setCircleMessageContent(String circleMessageContent) {
		this.circleMessageContent = circleMessageContent;
	}
	
	public Timestamp getOpertime() {
		return opertime;
	}
	public void setOpertime(Timestamp opertime) {
		this.opertime = opertime;
	}
	public TDemoImplMessage toImplMessage() {
		return new TDemoImplMessage(this.user.getUserName(), this.circleMessageContent, this.opertime);
	}
	
}
