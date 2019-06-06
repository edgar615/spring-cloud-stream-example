package com.github.edgar615.example.spring.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class MessageSender {

  @Autowired
  private KafkaTemplate template;

  public void send() {
    this.template.send("myTopic", "message1");
    this.template.send("myTopic", "message2");
    this.template.send("myTopic", "message3");
  }

}
