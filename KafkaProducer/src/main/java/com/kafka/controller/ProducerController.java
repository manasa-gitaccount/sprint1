package com.kafka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.kafka.entity.Book;

@RestController
public class ProducerController {
	
	@Autowired
	KafkaTemplate<String,Book> kafkaTemplate;
	
	private static final String TOPIC="KafkaTopic";

	@PostMapping("/publish")
	public String publishMessage(@RequestBody Book book)
	{
		kafkaTemplate.send(TOPIC,book);
		return "Published Successfully!";
	}
}
