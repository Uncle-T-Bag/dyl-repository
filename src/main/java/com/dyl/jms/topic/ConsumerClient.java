package com.dyl.jms.topic;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;

/**
 * 消息接受者（主题模式）
 * 
 */
public class ConsumerClient {
	//消息中间件服务器地址
	private static final String url = "tcp://127.0.0.1:61616";
	//主题名称
	private static final String topicName = "topic-name";
	
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
		Destination destination = session.createTopic(topicName);
		//创建消费者
		MessageConsumer consumer = session.createConsumer(destination);
		//创建消息监听器，监听消息服务器上的消息队列
		consumer.setMessageListener(new MessageListener() {
			
			@Override
			public void onMessage(Message message) {
				TextMessage message2 = (TextMessage)message;
				try {
					System.out.println("接收到的消息："+message2.getText());
				} catch (JMSException e) {
					e.printStackTrace();
				}
			}
		});
	}
}
