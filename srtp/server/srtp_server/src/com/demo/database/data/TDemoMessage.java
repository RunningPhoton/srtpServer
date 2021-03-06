package com.demo.database.data;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;

/**
 * 用户之间发布的消息的实体类 messageId是在数据库的主键 mainUserId是发送消息的用户 inferiorUserId是接受消息的用户
 * 在用户打开聊天界面后，按照opertime来刷新客户端
 * 
 * @author runningphoton
 *
 */
public class TDemoMessage implements Serializable {
	private Integer messageId;
	private TDemoUser mainUser;
	private TDemoUser inferiorUser;
	private String messageContent;
	private Timestamp opertime;

	
	public Integer getMessageId() {
		return messageId;
	}

	public void setMessageId(Integer messageId) {
		this.messageId = messageId;
	}

	public TDemoUser getMainUser() {
		return mainUser;
	}

	public void setMainUser(TDemoUser mainUser) {
		this.mainUser = mainUser;
	}

	public TDemoUser getInferiorUser() {
		return inferiorUser;
	}

	public void setInferiorUser(TDemoUser inferiorUser) {
		this.inferiorUser = inferiorUser;
	}

	public String getMessageContent() {
		return messageContent;
	}

	public void setMessageContent(String messageContent) {
		this.messageContent = messageContent;
	}
	

	public Timestamp getOpertime() {
		return opertime;
	}

	public void setOpertime(Timestamp opertime) {
		this.opertime = opertime;
	}

	public String getUserName() {
		return this.mainUser.getUserName();
	}

	public TDemoImplMessage toImplMessage() {
		return new TDemoImplMessage(this.mainUser.getUserName(), this.messageContent, this.opertime);
	}
}
