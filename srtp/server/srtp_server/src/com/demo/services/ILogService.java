package com.demo.services;

import com.demo.database.data.TDemoUser;


/**
 * 注册，登录，登出接口业务接口
 * @author runningphoton
 *
 */
public interface ILogService {

	/**
	 * 登录的接口
	 * param1 userName
	 * param2 password
	 * return TDemoUser
	 */
	public TDemoUser login(String userName, String password) throws Exception;
	
	/**
	 * 登出的接口
	 * @throws Exception
	 */
	public Boolean logout(TDemoUser user) throws Exception;
	
	/**
	 * 注册添加新用户的接口
	 * @return 
	 * @throws Exception
	 */
	public Boolean register(TDemoUser user) throws Exception;

}
