package com.github.edgar615.example.spring.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.PartitionOffset;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.List;

@Component
public class MessageReceiver {

//    @KafkaListener(topics = "myTopic")
//    public void processMessage(String content) {
//        System.out.println(content);
//    }
//
//	@KafkaListener(topics = "kRequests")
//	public void processMessage2(ConsumerRecord<String, String> record) {
//		System.out.println(new String(record.headers().lastHeader(KafkaHeaders.REPLY_TOPIC).value()));
//		System.out.println(new String(record.headers().lastHeader(KafkaHeaders.CORRELATION_ID).value()));
//	}
//
//	@KafkaListener(topics = "default-topic")
//	public void processMessage3(String content) {
//		System.out.println(content);
//	}
//
//	@KafkaListener(topics = "myTopic")
//	public void processMessage4(List<String> content) {
//		System.out.println(content);
//	}
//    @KafkaListener(topicPartitions = {
//            @TopicPartition(topic = "myTopic", partitions = {"0"}, partitionOffsets = {
//                    @PartitionOffset(partition = "1", initialOffset = "10")
//            })
//    })
//    public void processMessage5(String content) {
//        System.out.println(content);
//    }
//    @KafkaListener(topicPartitions = {
//            @TopicPartition(topic = "myTopic", partitionOffsets = {
//                    @PartitionOffset(partition = "0", initialOffset = "10")
//            })
//    })
//	public void processMessage6(@Payload String data,
//                                @Header(KafkaHeaders.RECEIVED_MESSAGE_KEY) Integer key,
//                                @Header(KafkaHeaders.RECEIVED_PARTITION_ID) int partition,
//                                @Header(KafkaHeaders.RECEIVED_TOPIC) String topic,
//                                @Header(KafkaHeaders.RECEIVED_TIMESTAMP) long ts) {
//        System.out.println("receive : \n"+
//                "data : "+data+"\n"+
//                "key : "+key+"\n"+
//                "partitionId : "+partition+"\n"+
//                "topic : "+topic+"\n"+
//                "timestamp : "+ts+"\n"
//        );
//	}
//
//    @KafkaListener(topics = "myTopic", containerFactory = "listenerContainer")
//    public void processMessage7(ConsumerRecord record,  Acknowledgment ack) {
//        System.out.println(record);
//        ack.acknowledge();
//    }

//    @KafkaListener(id = "pause.resume", topics = "pause.resume.topic")
//    public void processMessage8(String content) {
//        System.out.println(String.format("%d:%s", Instant.now().getEpochSecond(), content));
//    }

    @KafkaListener(topics = "myTopic", errorHandler = "customExceptionHandler")
    public void processMessage9(String content) {
        System.out.println(content);
        throw new RuntimeException("occur err");
    }
}
