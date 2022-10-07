package com.kafka.controller;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer {
	
	@KafkaListener(topics ="KafkaTopic",groupId="group_id")
	public void consumer(String message)
	{
		System.out.println("message="+message);
	}

}
