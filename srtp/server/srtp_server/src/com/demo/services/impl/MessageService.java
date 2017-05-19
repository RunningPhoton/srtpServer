package com.demo.services.impl;

import java.util.Set;

import net.sf.json.JSONArray;

import com.demo.database.data.TDemoImplMessage;
import com.demo.database.data.TDemoUser;
import com.demo.services.IMessageService;

public class MessageService implements IMessageService {

	@Override
	public void sendUserMessage(TDemoUser user, String messageContent,
			String userName) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void sendCircleMessage(TDemoUser user, String circleMessageContent)
			throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public JSONArray listMessageSets(Set<TDemoImplMessage> objSet)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
