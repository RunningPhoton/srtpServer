package com.demo.database.data;

import java.io.Serializable;

public class TDemoImplUser implements Serializable {
	private int userId;
	private String userName;
	private String userNickname;
	private String userGender;
	private String userCollege;
	private String graphName;
	private String userDescribe;
	private String userToken;
	private int code;
	
	public void print() {
		System.out.println(userName);
		System.out.println(userNickname);
		System.out.println(userGender);
		System.out.println(userCollege);
		System.out.println(graphName);
		System.out.println(userDescribe);
	}
	
	
	public int getCode() {
		return code;
	}


	public void setCode(int code) {
		this.code = code;
	}


	public int getUserId() {
		return userId;
	}


	public void setUserId(int userId) {
		this.userId = userId;
	}


	public String getUserToken() {
		return userToken;
	}

	public void setUserToken(String userToken) {
		this.userToken = userToken;
	}

	public String getUserDescribe() {
		return userDescribe;
	}

	public void setUserDescribe(String userDescribe) {
		this.userDescribe = userDescribe;
	}

	public TDemoImplUser(int userId, String userName, String userNickname, String userGender, 
			String userCollege, String userDescribe, String graphName, String userToken, int code) {
		this.userId = userId;
		this.userName = userName;
		this.userNickname = userNickname;
		this.userGender = userGender;
		this.userCollege = userCollege;
		this.userDescribe = userDescribe;
		this.graphName = graphName;
		this.userToken = userToken;
		this.code = code;
	}
	
	public TDemoImplUser() {
		// TODO Auto-generated constructor stub
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
