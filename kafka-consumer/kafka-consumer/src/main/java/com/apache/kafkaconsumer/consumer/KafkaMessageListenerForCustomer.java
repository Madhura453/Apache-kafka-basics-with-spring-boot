package com.apache.kafkaconsumer.consumer;

import com.apache.kafkaconsumer.dto.Customer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KafkaMessageListenerForCustomer {

//    @KafkaListener(topics = "partitiontopic",groupId = "customer-consumer-group2")
//    public void consumeEvents(Customer customer)
//    {
//        log.info("consumer consume the events {}",customer.toString());
//    }

 /*
 Read the message from particular partition
  */
    @KafkaListener(topics = "partitiontopic",groupId = "customer-consumer-group2",
    topicPartitions = {@TopicPartition(topic = "partitiontopic",partitions = {"3"})})
    public void consumeEventsFromParticularPartition(Customer customer)
    {
        log.info("consumer consume the events {}",customer.toString());
    }
}
