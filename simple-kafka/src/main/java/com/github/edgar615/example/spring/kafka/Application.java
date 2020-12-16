package com.github.edgar615.example.spring.kafka;

import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.ByteArraySerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.config.KafkaListenerEndpointRegistry;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.listener.ContainerProperties;
import org.springframework.kafka.listener.KafkaMessageListenerContainer;
import org.springframework.kafka.listener.MessageListener;

import java.util.Collections;
import java.util.concurrent.TimeUnit;

@SpringBootApplication
@Configuration
public class Application implements CommandLineRunner {

    @Autowired
    private MessageSender messageSender;

    @Autowired
    private KafkaTemplate<String, String> template;

//    @Autowired
//    private  KafkaListenerEndpointRegistry registry;

//    @Autowired
//    private Listener2 listener2;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
//        TimeUnit.SECONDS.sleep(5);
//        listener2.seekToBeginning();
    messageSender.send();
//    TimeUnit.SECONDS.sleep(5);

//        template.send("pause.resume.topic", "thing1");
//        Thread.sleep(10_000);
//        System.out.println("pausing");
//        registry.getListenerContainer("pause.resume").pause();
//        Thread.sleep(10_000);
//        template.send("pause.resume.topic", "thing2");
//        Thread.sleep(10_000);
//        System.out.println("resuming");
//        registry.getListenerContainer("pause.resume").resume();
//        Thread.sleep(10_000);
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, String> listenerContainer(ConsumerFactory<String, String> cf) {
        ConcurrentKafkaListenerContainerFactory<String, String> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(cf);
        factory.setConcurrency(1);
//    factory.setBatchListener(true);
        factory.getContainerProperties().setAckMode(ContainerProperties.AckMode.MANUAL_IMMEDIATE);
        return factory;
    }

//  @Bean
//  public KafkaMessageListenerContainer<String, String> listenerContainer(ConsumerFactory<String, String> cf) {
//    ContainerProperties properties = new ContainerProperties("myTopic");
//
//    properties.setGroupId("test");
//
//    properties.setMessageListener((MessageListener<String, String>) record
//            -> System.out.println("myTopic receive : " + record.toString()));
//    KafkaMessageListenerContainer<String, String> listenerContainer = new KafkaMessageListenerContainer<>(cf, properties);
//    return listenerContainer;
//  }
//
//  @Bean
//  public KafkaTemplate<String, String> stringTemplate(ProducerFactory<String, String> pf) {
//    KafkaTemplate<String, String> kafkaTemplate = new KafkaTemplate<>(pf);
//    kafkaTemplate.setDefaultTopic("default-topic");
//    return kafkaTemplate;
//  }
//
//  @Bean
//  public KafkaTemplate<String, byte[]> bytesTemplate(ProducerFactory<String, byte[]> pf) {
//    return new KafkaTemplate<>(pf,
//            Collections.singletonMap(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, ByteArraySerializer.class));
//  }

}
