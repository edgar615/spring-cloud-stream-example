package com.github.edgar615.example.spring.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.common.TopicPartition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.listener.ConsumerSeekAware;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

//@Component
class Listener implements ConsumerSeekAware {

    private static final Logger logger = LoggerFactory.getLogger(Listener.class);

    private final ThreadLocal<ConsumerSeekCallback> callbackForThread = new ThreadLocal<>();

    private final Map<TopicPartition, ConsumerSeekCallback> callbacks = new ConcurrentHashMap<>();

    @Override
    public void registerSeekCallback(ConsumerSeekCallback callback) {
        // called when the container is started and whenever partitions are assigned
        this.callbackForThread.set(callback);
    }

    @Override
    public void onPartitionsAssigned(Map<TopicPartition, Long> assignments, ConsumerSeekCallback callback) {
        // called when partitions are assigned
        assignments.keySet().forEach(tp -> this.callbacks.put(tp, this.callbackForThread.get()));

        TopicPartition tp = new TopicPartition("myTopic", 0);
        if (assignments.containsKey(tp)) {
            callback.seekToBeginning(Collections.singletonList(tp));
        }
    }

    @Override
    public void onPartitionsRevoked(Collection<TopicPartition> partitions) {
        // called when the container is stopped or Kafka revokes assignments
        partitions.forEach(tp -> this.callbacks.remove(tp));
        this.callbackForThread.remove();
    }

    @Override
    public void onIdleContainer(Map<TopicPartition, Long> assignments, ConsumerSeekCallback callback) {
    }

    @KafkaListener(topics = "myTopic")
    public void processMessage(String content) {
        System.out.println(content);
    }

}