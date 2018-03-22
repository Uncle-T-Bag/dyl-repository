package com.dyl.jms.queue;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.MessageProducer;
import org.apache.activemq.ActiveMQConnectionFactory;

/**
 * 消息发布者（队列模式）
 *
 */
public class ProducerClient {
	//消息中间件服务器地址
	private static final String url = "tcp://127.0.0.1:61616";
	//队列名称
	private static final String queueName = "queue-name";
	
	public static void main(String[] args) throws Exception{
		//创建连接工厂
		ConnectionFactory cf = new ActiveMQConnectionFactory(url);
		//创建连接
		Connection connection = cf.createConnection();
		//启动连接
		connection.start();
		//创建会话
		Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		//创建目的地
		Destination destination = session.createQueue(queueName);
		//创建生产者
		MessageProducer producer = session.createProducer(destination);
		//创建消息
		for(int i=0; i<100; i++) {
			TextMessage message = session.createTextMessage("textMessage:"+i);
			//发送消息
			producer.send(message);
			
			System.out.println("发送消息："+message.getText());
		}
		//关闭连接
		connection.close();
	}
}
