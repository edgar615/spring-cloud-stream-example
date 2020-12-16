package com.github.edgar615.example.spring.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

//@SpringBootApplication
//@Configuration
public class ReplyApplication implements CommandLineRunner {

  @Autowired
  private ReplyMessageSender replyMessageSender;

  public static void main(String[] args) {
    SpringApplication.run(ReplyApplication.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
    replyMessageSender.send();
  }

//  @Bean
//  public KafkaTemplate<String, String> stringTemplate(ProducerFactory<String, String> pf) {
//    return new KafkaTemplate<>(pf);
//  }
//
//  @Bean
//  public KafkaTemplate<String, byte[]> bytesTemplate(ProducerFactory<String, byte[]> pf) {
//    return new KafkaTemplate<>(pf,
//            Collections.singletonMap(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, ByteArraySerializer.class));
//  }

}
