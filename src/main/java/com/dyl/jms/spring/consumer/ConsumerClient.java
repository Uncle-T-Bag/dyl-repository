package com.dyl.jms.spring.consumer;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ConsumerClient {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext act = new ClassPathXmlApplicationContext("activemq/consumer.xml");
		
	}
}
