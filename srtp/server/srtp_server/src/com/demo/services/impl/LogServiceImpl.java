package com.demo.services.impl;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.List;

import com.demo.database.data.TDemoUser;
import com.demo.database.idao.IDaoService;
import com.demo.services.ILogService;
import com.demo.tools.Tools;

/**
 * 注册，登录，登出的业务实现类
 * 
 * @author runningphoton
 *
 */
public class LogServiceImpl implements ILogService {
	private IDaoService idaoService;

	public IDaoService getIdaoService() {
		return idaoService;
	}

	public void setIdaoService(IDaoService idaoService) {
		this.idaoService = idaoService;
	}

	/**
	 * 登录返回用户实例，且更改用户状态，若为空则表示登录失败，用户名或者密码不匹配，或者该用户已经登录
	 */
	@Override
	public TDemoUser login(String userName, String password) throws Exception {
		
		
		
		String hql = "from TDemoUser where userName='" + userName
				+ "' and userPassword='" + password + "'";
		List<TDemoUser> list = (List<TDemoUser>) idaoService.query(hql);
		//System.out.println("find user size = " + list.size());
		if (list.size() == 0)
			return null;
		else {
			TDemoUser user = list.get(0);
			/**
			 * 测试用set 为0
			 */
//			user.setOnline(0);
//			System.out.println("user is " + user);
//			System.out.println(user.getOnline());
			
//			if (user.getOnline() == 1) {
//				return null;
//			}
//			user.setOnline(1);
			if(user.getUserToken() == null) {
				Tools tool = new Tools();
				user.setUserToken(tool.getToken(user.getUserId().toString(), user.getUserName(), user.getGraphName()));
			}
			idaoService.update(user);
//			System.out.println(user.getOnline());
			return user;
		}
	}

	/**
	 * 若用户是online状态则返回真，且重设用户状态，否则返回false
	 */
	@Override
	public Boolean logout(TDemoUser user) throws Exception {
//		System.out.println(user);
//		if(user == null) user = new TDemoUser();
//		user.setOnline(0);
		if (user.getOnline() == 1) {
			user.setOnline(0);
			idaoService.update(user);
			return true;
		}
		return false;
	}

	/**
	 * 查询用户，若已经存在该用户名则返回false 注册失败，否则返回true，且把用户信息更新到数据库
	 */
	@Override
	public Boolean register(TDemoUser user) throws Exception {

		String hql = "from TDemoUser where userName='" + user.getUserName()
				+ "'";
		List<TDemoUser> list = (List<TDemoUser>) idaoService.query(hql);
		if (list.size() > 0)
			return false;
		// 封装用户通用字段数据
		user.setOpertime(new Timestamp(System.currentTimeMillis()));
		user.setOnline(0);
		user.setUserAuthority(0);
		user.setGraphName("http://120.77.171.222:8080/srtp_server/upload/head.jpg");
		// 访问数据库，保存新用户数据
		
		idaoService.save(user);
		return true;
	}

}
