package com.github.edgar615.example.spring.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.requestreply.ReplyingKafkaTemplate;
import org.springframework.kafka.requestreply.RequestReplyFuture;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

//@Component
public class ReplyMessageSender {

	@Autowired
	private ReplyingKafkaTemplate<String, String, String> template;

	public void send() throws Exception {
		ProducerRecord<String, String> record = new ProducerRecord<>("kRequests", "foo");
		RequestReplyFuture<String, String, String> replyFuture = template.sendAndReceive(record);
		SendResult<String, String> sendResult = replyFuture.getSendFuture().get(10, TimeUnit.SECONDS);
		System.out.println("Sent ok: " + sendResult.getRecordMetadata());
		ConsumerRecord<String, String> consumerRecord = replyFuture.get(10, TimeUnit.SECONDS);
		System.out.println("Return value: " + consumerRecord.value());
	}
}
