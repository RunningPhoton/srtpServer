package com.demo.actions;

import net.sf.json.JSONArray;

import com.demo.database.data.TDemoUser;
import com.demo.services.IUserService;
import com.opensymphony.xwork2.ActionSupport;

public class MessageAction extends ActionSupport {
	private TDemoUser user;
	private String operObject;
	private String operContent;
	private IUserService iuserService;
	private JSONArray many;

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

	public IUserService getIuserService() {
		return iuserService;
	}

	public void setIuserService(IUserService iuserService) {
		this.iuserService = iuserService;
	}

	public JSONArray getMany() {
		return many;
	}

	public void setMany(JSONArray many) {
		this.many = many;
	}

	
}
