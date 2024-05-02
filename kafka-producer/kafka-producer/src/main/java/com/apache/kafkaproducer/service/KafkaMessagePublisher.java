package com.apache.kafkaproducer.service;

import com.apache.kafkaproducer.dto.Customer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;


@Service
@Slf4j
public class KafkaMessagePublisher {

    @Autowired
    private KafkaTemplate<String ,Object> kafkaTemplate;

    @Value("${kafka.topic}")
    private String topicName;

    public void sendMessage(String message)
    {
       CompletableFuture<SendResult<String, Object>> future=kafkaTemplate.send(topicName,message);
       future.whenComplete((result,ex)->{
           if(ex==null)
           {
               System.out.println("Sent message=[" + message +
                       "] with offset=[" + result.getRecordMetadata().offset() + "]");
           }
           else {
               System.out.println("Unable to send message=[" +
                       message + "] due to : " + ex.getMessage());
           }
       });
    }


    public void sendEventsToTopic(Customer customer)
    {
        try {
            CompletableFuture<SendResult<String, Object>> future = kafkaTemplate.send(topicName, customer);
            future.whenComplete((result, ex) -> {
                if (ex == null) {
                    System.out.println("sent message with message" + customer.toString() + "offset: " + result.getRecordMetadata().offset());
                } else {
                    System.out.println("unable to send message" + customer.toString() + ex.getMessage());
                }
            });
        }
        catch(Exception e)
        {
            log.info("exception"+e.getMessage());
        }
    }

    public void sendEventsToTopicParticularPartion(Customer customer)
    {
        try {
            CompletableFuture<SendResult<String, Object>> future = kafkaTemplate.send(topicName,3,"madhu", customer);
            future.whenComplete((result, ex) -> {
                if (ex == null) {
                    System.out.println("sent message with message" + customer.toString() + "offset: " + result.getRecordMetadata().offset());
                } else {
                    System.out.println("unable to send message" + customer.toString() + ex.getMessage());
                }
            });
        }
        catch(Exception e)
        {
            log.info("exception"+e.getMessage());
        }
    }

}
