package com.github.edgar615.example.spring.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class MessageReceiver {

	@KafkaListener(topics = "myTopic")
	public void processMessage(String content) {
		System.out.println(content);
	}
}
