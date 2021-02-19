package com.example.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;



@Component
public class Consumer {
    private final Logger logger =  LoggerFactory.getLogger(Consumer.class);

    @KafkaListener(topics = "TesteTopic2", groupId = "FiapGroupId")
    public void consume(ConsumerRecord<String, String> record){
        logger.info("Key " +record.key());
        logger.info("Value " + record.value());
    }
}
