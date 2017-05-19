package com.demo.services;

import java.util.Set;

import net.sf.json.JSONArray;

import com.demo.database.data.TDemoImplMessage;
import com.demo.database.data.TDemoUser;

public interface IMessageService {
	/**
	 * 发送用户信息
	 * @param message
	 * @throws Exception
	 */
	public void sendUserMessage(TDemoUser user, String messageContent, String userName) throws Exception;

	/**
	 * 
	 * 向圈子发送消息
	 * @param circleMessage
	 * @throws Exception
	 */
	public void sendCircleMessage(TDemoUser user, String circleMessageContent) throws Exception;
	/**
	 * 消息集合转化为json
	 * @param objSet
	 * @return
	 * @throws Exception
	 */
	public JSONArray listMessageSets(Set<TDemoImplMessage> objSet) throws Exception;
}
