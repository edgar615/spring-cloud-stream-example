package com.github.edgar615.example.spring.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.listener.AbstractConsumerSeekAware;
import org.springframework.stereotype.Component;

//@Component
class Listener2 extends AbstractConsumerSeekAware {

    @KafkaListener(topics = "myTopic")
    public void processMessage(String content) {
        System.out.println(content);
    }

    public void seekToBeginning() {
        getSeekCallbacks().forEach((tp, callback) -> callback.seekToBeginning(tp.topic(), tp.partition()));
    }

}