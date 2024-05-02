package com.apache.kafkaproducer.controller;

import com.apache.kafkaproducer.dto.Customer;
import com.apache.kafkaproducer.service.KafkaMessagePublisher;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("producer-app")
@Slf4j
public class EventController {

    @Autowired
    private KafkaMessagePublisher kafkaMessagePublisher;

    @GetMapping("/publish")
    public ResponseEntity<?> publishMessage(@RequestParam("message") String message) {
        try {
            for (int i = 0; i <= 1000000; i++) {
                kafkaMessagePublisher.sendMessage(message + " " + i);
            }
            return ResponseEntity.ok("message sent successfully");
        } catch (Exception e) {
            log.info(e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping("/publish-events")
    public ResponseEntity<String> sendEvents(@RequestBody Customer customer) {
        try {
            kafkaMessagePublisher.sendEventsToTopic(customer);
            return ResponseEntity.ok("message sent successfully");
        } catch (Exception e) {
            log.info(e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping("/publish-events-to-partition")
    public ResponseEntity<String> sendEventsToParticularPartition(@RequestBody Customer customer) {
        try {
            for(int i=0;i<100;i++)
            {
                kafkaMessagePublisher.sendEventsToTopicParticularPartion(customer);
            }
            return ResponseEntity.ok("message sent successfully");
        } catch (Exception e) {
            log.info(e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
