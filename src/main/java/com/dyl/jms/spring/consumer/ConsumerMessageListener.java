package com.dyl.jms.spring.consumer;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

public class ConsumerMessageListener implements MessageListener {

	@Override
	public void onMessage(Message message) {
		//接收消息打印到控制台
		TextMessage textMessage = (TextMessage)message;
		try {
			System.out.println("接收到的消息："+textMessage.getText());
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}

}
