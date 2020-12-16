package com.github.edgar615.example.spring.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

@Component
public class ReplyMessageReceiver {

//	@KafkaListener(topics = "kRequests")
//	@SendTo // use default replyTo expression
//	public String listen(String in) {
//		System.out.println("Server received: " + in);
//		return in.toUpperCase();
//	}

	@KafkaListener(topics = "kRequests")
	@SendTo // use default replyTo expression
	public Message<String> listen(String in) {
		System.out.println("Server received: " + in);
		return MessageBuilder.withPayload(in.toUpperCase())
				.build();
	}
}
