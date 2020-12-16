//package com.github.edgar615.example.spring.kafka;
//
//import org.apache.kafka.clients.consumer.Consumer;
//import org.apache.kafka.clients.consumer.ConsumerRecord;
//import org.apache.kafka.clients.producer.ProducerRecord;
//import org.apache.kafka.common.header.Headers;
//import org.springframework.kafka.support.Acknowledgment;
//import org.springframework.kafka.support.KafkaHeaders;
//import org.springframework.kafka.support.converter.KafkaMessageHeaders;
//import org.springframework.kafka.support.converter.RecordMessageConverter;
//import org.springframework.messaging.Message;
//import org.springframework.messaging.MessageHeaders;
//import org.springframework.messaging.support.MessageBuilder;
//import org.springframework.util.Assert;
//
//import java.lang.reflect.Type;
//import java.nio.charset.StandardCharsets;
//import java.util.Map;
//
//public class CustomMessageConverter implements RecordMessageConverter {
//    @Override
//    public Message<?> toMessage(ConsumerRecord<?, ?> record, Acknowledgment acknowledgment, Consumer<?, ?> consumer, Type payloadType) {
//        KafkaMessageHeaders kafkaMessageHeaders = new KafkaMessageHeaders(this.generateMessageId,
//                this.generateTimestamp);
//
//        Map<String, Object> rawHeaders = kafkaMessageHeaders.getRawHeaders();
//        if (this.headerMapper != null && record.headers() != null) {
//            this.headerMapper.toHeaders(record.headers(), rawHeaders);
//        }
//        else {
//            this.logger.debug(() ->
//                    "No header mapper is available; Jackson is required for the default mapper; "
//                            + "headers (if present) are not mapped but provided raw in "
//                            + KafkaHeaders.NATIVE_HEADERS);
//            rawHeaders.put(KafkaHeaders.NATIVE_HEADERS, record.headers());
//        }
//        String ttName = record.timestampType() != null ? record.timestampType().name() : null;
//        commonHeaders(acknowledgment, consumer, rawHeaders, record.key(), record.topic(), record.partition(),
//                record.offset(), ttName, record.timestamp());
//
//        return MessageBuilder.createMessage(extractAndConvertValue(record, type), kafkaMessageHeaders);
//    }
//
//    @Override
//    public ProducerRecord<?, ?> fromMessage(Message<?> message, String defaultTopic) {
//        MessageHeaders headers = message.getHeaders();
//        Object topicHeader = headers.get(KafkaHeaders.TOPIC);
//        String topic = null;
//        if (topicHeader instanceof byte[]) {
//            topic = new String(((byte[]) topicHeader), StandardCharsets.UTF_8);
//        }
//        else if (topicHeader instanceof String) {
//            topic = (String) topicHeader;
//        }
//        else if (topicHeader == null) {
//            Assert.state(defaultTopic != null, "With no topic header, a defaultTopic is required");
//        }
//        else {
//            throw new IllegalStateException(KafkaHeaders.TOPIC + " must be a String or byte[], not "
//                    + topicHeader.getClass());
//        }
//        Integer partition = headers.get(KafkaHeaders.PARTITION_ID, Integer.class);
//        Object key = headers.get(KafkaHeaders.MESSAGE_KEY);
//        Object payload = convertPayload(message);
//        Long timestamp = headers.get(KafkaHeaders.TIMESTAMP, Long.class);
//        Headers recordHeaders = initialRecordHeaders(message);
//        if (this.headerMapper != null) {
//            this.headerMapper.fromHeaders(headers, recordHeaders);
//        }
//        return new ProducerRecord(topic == null ? defaultTopic : topic, partition, timestamp, key, payload,
//                recordHeaders);
//    }
//}
