package com.github.edgar615.example.spring.kafka;

import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaProducerException;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

@Component
public class MessageSender {

  @Autowired
  private KafkaTemplate<String, String> template;

  public void send() {
    this.template.send("myTopic", "message1");
//    for (int i = 0; i < 10; i ++) {
//      this.template.send("myTopic", "message" + i);
//    }
//    ListenableFuture<SendResult<String, String>> future =this.template.sendDefault( "message1");
//    future.addCallback(new ListenableFutureCallback<SendResult<String, String>>() {
//      @Override
//      public void onFailure(Throwable ex) {
//        KafkaProducerException kafkaProducerException = (KafkaProducerException) ex;
//        ProducerRecord<String, String> record = kafkaProducerException.getFailedProducerRecord();
//      }
//
//      @Override
//      public void onSuccess(SendResult<String, String> result) {
//        ProducerRecord<String, String> record = result.getProducerRecord();
//        RecordMetadata metadata = result.getRecordMetadata();
//        StringBuffer logOutput = new StringBuffer();
//        logOutput.append("send a message")
//                .append(" with key='")
//                .append(record.key())
//                .append("'")
//                .append(" and payload='")
//                .append(record.value())
//                .append("'")
//                .append(" to topic ").append(record.topic());
//        if (record.partition() != null) {
//          logOutput.append(" and partition ").append(record.partition());
//        }
//        logOutput.append(":");
//        System.out.println(logOutput);
//      }
//    });
//    this.template.send("myTopic", "message2");
//    this.template.send("myTopic", "message3");
//    Message<String> message = MessageBuilder.withPayload("message1")
//            .setHeader("from", "kafka-simple-demo")
//            .build();
//    this.template.send("myTopic", message);
  }

}
