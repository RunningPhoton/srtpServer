package com.demo.database.data;

import java.io.Serializable;

public class TDemoImplUser implements Serializable {
	private String userName;
	private String userNickname;
	private String userGender;
	private String userCollege;
	private String graphName;
	private String userDescribe;
	
	public void print() {
		System.out.println(userName);
		System.out.println(userNickname);
		System.out.println(userGender);
		System.out.println(userCollege);
		System.out.println(graphName);
		System.out.println(userDescribe);
	}
	
	public String getUserDescribe() {
		return userDescribe;
	}

	public void setUserDescribe(String userDescribe) {
		this.userDescribe = userDescribe;
	}

	public TDemoImplUser(String userName, String userNickname, String userGender, 
			String userCollege, String userDescribe, String graphName) {
		this.userName = userName;
		this.userNickname = userNickname;
		this.userGender = userGender;
		this.userCollege = userCollege;
		this.userDescribe = userDescribe;
		this.graphName = graphName;
	}
	
	public String getUserGender() {
		return userGender;
	}

	public void setUserGender(String userGender) {
		this.userGender = userGender;
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

}