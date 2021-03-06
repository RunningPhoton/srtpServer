package com.demo.database.data;

import java.io.Serializable;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;

public class TDemoImplMessage implements Serializable {

	private String userName;
	private String content;
	private long opertime;
	
	public TDemoImplMessage(String userName, String content, Date opertime) {
		this.userName = userName;
		this.content = content;
		this.opertime = opertime.getTime();
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public long getOpertime() {
		return opertime;
	}

	public void setOpertime(long opertime) {
		this.opertime = opertime;
	}

	
	
}
