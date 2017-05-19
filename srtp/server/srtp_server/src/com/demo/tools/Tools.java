package com.demo.tools;

import io.rong.RongCloud;
import io.rong.models.ChatRoomInfo;
import io.rong.models.CodeSuccessResult;
import io.rong.models.TokenResult;

import java.util.List;
import java.util.Set;

import com.demo.database.data.TDemoCircle;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * 工具函数包
 * @author runningphoton
 *
 */
public class Tools {
	String appKey = "0vnjpoad0c78z";//替换成您的appkey
	String appSecret = "lXVTmtBrJH";//替换成匹配上面key的secret
	
	
	
	
	/**
	 * 移除群组某成员
	 * 
	 */
	public void removeUserOfChatRoom(String userId, String groupId) {
		RongCloud rongCloud = RongCloud.getInstance(appKey, appSecret);
		String[] groupQuitUserId = {userId};
		try {
			CodeSuccessResult groupQuitResult = rongCloud.group.quit(groupQuitUserId, groupId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 添加成员到群组
	 */
	public Boolean addToChatRoom(String userId, String chatRoomId, String chatRoomName) {
		RongCloud rongCloud = RongCloud.getInstance(appKey, appSecret);
		String[] groupJoinUserId = {userId};
		CodeSuccessResult groupJoinResult;
		try {
			groupJoinResult = rongCloud.group.join(groupJoinUserId, chatRoomId, chatRoomName);
			return groupJoinResult.getCode().equals(200);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	/**
	 * 创建群组
	 */
	public Boolean createChatRoom(String roomId, String roomName) {
		RongCloud rongCloud = RongCloud.getInstance(appKey, appSecret);
		String[] groupCreateUserId = {};
		try {
			CodeSuccessResult groupCreateResult = rongCloud.group.create(groupCreateUserId, roomId, roomName);
			return groupCreateResult.getCode().equals(200);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			return false;
		}
	}
	/**
	 * 得到user的token串
	 * 
	 */
	public String getToken(String userId, String userName, String graphName) {
		RongCloud rongCloud = RongCloud.getInstance(appKey, appSecret);
		try {
			TokenResult result = rongCloud.user.getToken(userId, userName, graphName);
			return result.getToken();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	/**
	 * 将类转化为json字符串
	 * @param temp
	 * @return
	 */
	
	public JSONObject objectToJson(Object temp) {
		return JSONObject.fromObject(temp);
//		JSONObject json = JSONObject.fromObject(temp);
//        return json.toString();
	}
	/**
	 * 将Set转化为json字符串
	 */
	public JSONArray setToJson(Set<Object> temp) {
		return JSONArray.fromObject(temp);
//		JSONArray json = JSONArray.fromObject(temp);
//		return json.toString();
	}
	/**
	 * 将list转化为json
	 * @param list
	 * @return
	 */
	public JSONArray listToJson(List<Object> list) {
		return JSONArray.fromObject(list);
		// TODO Auto-generated method stub
	}
}
