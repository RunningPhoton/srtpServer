package com.demo.actions;

import java.util.HashMap;
import java.util.Map;

import com.demo.database.data.TDemoUser;
import com.demo.database.idao.IDaoService;
import com.demo.services.IUserService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport {
	private TDemoUser user;
	private String operObject;
	private String operContent;
	private IUserService iuserService;
	private Map<String, Object> jsonResult;
	
	
	public Map<String, Object> getJsonResult() {
		return jsonResult;
	}

	public void setJsonResult(Map<String, Object> jsonResult) {
		this.jsonResult = jsonResult;
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
	public String userToJson(){
        Map<String, Object> map = new HashMap<String, Object>();
        String status = null;
        try {
            map.put("user", this.user);
            map.put("status", status);
            jsonResult=map;
            System.out.println("excucuccccu");
            return "success";
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return ERROR;
    }
	public String update() {
		TDemoUser tempUser = iuserService.findByUserName(this.user.getUserName());
		tempUser.setUserGender(this.user.getUserGender());
		tempUser.setUserCollege(this.user.getUserCollege());
		tempUser.setUserNickname(this.user.getUserNickname());
		tempUser.setUserPassword(this.user.getUserPassword());
		tempUser.setGraphName(this.user.getGraphName());
		this.user = tempUser;
		System.out.println("执行update");
		ActionContext.getContext().getSession().put("user", tempUser);
		if(iuserService.update(this.user)) {
			return SUCCESS;
		} else {
			return ERROR;
		}
	}
	
	public String addFriend() {
		this.user = iuserService.findByUserName(this.user.getUserName());
		try {
			System.out.println("执行addFriend");
			iuserService.addFriend(this.user, operObject);
			System.out.println("success执行addFriend");
			
			ActionContext.getContext().getSession().put("user", this.user);
			return SUCCESS;
		} catch (Exception e) {
			return ERROR;
		}
	}
	public String removeFriend() {
		this.user = iuserService.findByUserName(this.user.getUserName());
		try {
			iuserService.removeFriend(this.user, operObject);

			ActionContext.getContext().getSession().put("user", this.user);
			return SUCCESS;
		} catch (Exception e) {
			return ERROR;
		}
	}
	public String setCircle() {
		this.user = iuserService.findByUserName(this.user.getUserName());
		try {
			System.out.println("执行setCircle");
			iuserService.setCircle(this.user, operObject);

			ActionContext.getContext().getSession().put("user", this.user);
			return SUCCESS;
		} catch (Exception e) {
			return ERROR;
		}
	}
	public String removeCircle() {
		this.user = iuserService.findByUserName(this.user.getUserName());
		try {
			System.out.println("执行removeCircle");
			iuserService.removeCircle(this.user, operObject);

			ActionContext.getContext().getSession().put("user", this.user);
			return SUCCESS;
		} catch (Exception e) {
			return ERROR;
		}
	}
	public String sendUserMessage() {
		this.user = iuserService.findByUserName(this.user.getUserName());
		try {
			System.out.println("执行sendUserMessage");
			iuserService.sendUserMessage(this.user, operContent, operObject);
			
			ActionContext.getContext().getSession().put("user", this.user);
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

			ActionContext.getContext().getSession().put("user", this.user);
			System.out.println("success sendCircleMessage");
			return SUCCESS;
		} catch (Exception e) {
			return ERROR;
		}
	}
}
