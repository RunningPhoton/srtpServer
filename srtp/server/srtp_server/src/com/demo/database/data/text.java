package com.demo.database.data;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.demo.database.idao.IDaoService;
import com.demo.database.idao.impl.DaoServiceImpl;



/**
 * 经过测试得到，每个访问服务器的操作需要使用idaoService.update(user)操作
 * 创建user的时候用save操作，之后所有的操作的行为发动者都是user，然后调用idaoService的update方法
 * @author runningphoton
 *
 */
public class text {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContext.xml");
		
		IDaoService idaoService = (DaoServiceImpl) ctx.getBean("idaoService");
//		FileSystemXmlApplicationContext ctx2 = new FileSystemXmlApplicationContext("/WebContent/WEB-INF/web.xml");
//				System.out.println(ctx);
//		Session session = sessionFactory.openSession();
		/**
		 * 建立三个用户，方便测试
		 */
		TDemoUser a = new TDemoUser();
		TDemoUser b = new TDemoUser();
		TDemoUser c = new TDemoUser();
		c.setUserName("123");
		a.setUserName("hyx");
		b.setUserName("qyd");
		
		

		/**
		 * 测试添加好友
		 */
		a.addFriend(b);
		b.addFriend(c);
		b.addFriend(a);
		c.addFriend(a);
		c.addFriend(b);
		
		
		/**
		 * 测试发送消息
		 */
		TDemoMessage messageUser = new TDemoMessage();
		try {
			idaoService.save(messageUser);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		messageUser.setInferiorUser(b);
		messageUser.setMainUser(a);
		b.addUserMessageGet(messageUser);
		a.addUserMessage(messageUser);
		String temp = "Hello of my girl!!!!!!";
		messageUser.setMessageContent(temp);
		
		
		try {
			idaoService.save(a);
			a.setUserNickname("sbsss");
			a.setUserName("sb");
//			a.setUserId(23);
			idaoService.update(a);
			/**
			 * 测试添加圈子信息
			 * 
			 */
			TDemoCircle circle = new TDemoCircle();
			circle.setCircleName("数学");
			circle.addUser(a);
			idaoService.save(circle);
			a.setUserCircle(circle);
			
			TDemoCircleMessage circleMessage = new TDemoCircleMessage();
			circleMessage.setCircleMessageContent("hello sb men");
			circleMessage.setCircle(circle);
			circleMessage.setUser(a);
			idaoService.save(circleMessage);
			idaoService.update(a);
		} catch (Exception e) {
			e.printStackTrace();
		}
		ctx.close();
	}
}
