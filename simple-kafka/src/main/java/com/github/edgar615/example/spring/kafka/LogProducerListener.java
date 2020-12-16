package com.github.edgar615.example.spring.kafka;

import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.springframework.kafka.support.ProducerListener;
import org.springframework.stereotype.Component;

//@Component
public class LogProducerListener implements ProducerListener<Object, Object> {

    @Override
    public void onSuccess(ProducerRecord<Object, Object> record, RecordMetadata metadata) {
        StringBuffer logOutput = new StringBuffer();
        logOutput.append("send a message")
                .append(" with key='")
                .append(record.key())
                .append("'")
                .append(" and payload='")
                .append(record.value())
                .append("'")
                .append(" to topic ").append(record.topic());
        if (record.partition() != null) {
            logOutput.append(" and partition ").append(record.partition());
        }
        logOutput.append(":");
        System.out.println(logOutput);
    }

    @Override
    public void onError(ProducerRecord<Object, Object> producerRecord, Exception exception) {

    }
}
