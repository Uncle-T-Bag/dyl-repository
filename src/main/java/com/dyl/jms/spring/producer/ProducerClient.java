package com.dyl.jms.spring.producer;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ProducerClient {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext act = new ClassPathXmlApplicationContext("activemq/producer.xml");
		ProducerService service = act.getBean(ProducerService.class);
		for(int i=0;i<100;i++) {
			service.sendMessage("信息"+i);
		}
		act.close();
	}
}
