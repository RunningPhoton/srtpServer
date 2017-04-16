package com.demo.services.impl;

import java.sql.Timestamp;
import java.util.List;

import com.demo.database.data.TDemoUser;
import com.demo.database.idao.IDaoService;
import com.demo.services.ILogService;

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
		if (list == null)
			return null;
		else {
			TDemoUser user = list.get(0);
			if (user.getOnline() == 1)
				return null;
			user.setOnline(1);
			idaoService.update(user);
			return user;
		}
	}

	/**
	 * 若用户是online状态则返回真，且重设用户状态，否则返回false
	 */
	@Override
	public Boolean logout(TDemoUser user) throws Exception {
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
		if (list != null)
			return false;
		// 封装用户通用字段数据
		user.setOpertime(new Timestamp(System.currentTimeMillis()));
		user.setOnline(0);
		user.setUserAuthority(0);
		// 访问数据库，保存新用户数据
		idaoService.save(user);
		return true;
	}

}