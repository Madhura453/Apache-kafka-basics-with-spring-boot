package com.apache.kafkaconsumer.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KafkaMessageListener {

    // TODO: Implement concurrency way
    /*
    it is not right way to implement consumer groups
     */
//    @KafkaListener(topics = "topicbyjava4",groupId = "consumer-group2")
//    public void consume1(String message)
//    {
//        log.info("consumer1 consume the message {}",message);
//    }
//
//    @KafkaListener(topics = "topicbyjava4",groupId = "consumer-group2")
//    public void consume2(String message)
//    {
//        log.info("consumer2 consume the message {}",message);
//    }
//
//    @KafkaListener(topics = "topicbyjava4",groupId = "consumer-group2")
//    public void consume3(String message)
//    {
//        log.info("consumer3 consume the message {}",message);
//    }
//
//    @KafkaListener(topics = "topicbyjava4",groupId = "consumer-group2")
//    public void consume4(String message)
//    {
//        log.info("consumer4 consume the message {}",message);
//    }
}
