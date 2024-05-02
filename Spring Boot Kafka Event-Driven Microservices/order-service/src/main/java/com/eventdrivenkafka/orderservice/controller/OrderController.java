package com.eventdrivenkafka.orderservice.controller;

import com.eventdrivenkafka.basedomains.dto.Order;
import com.eventdrivenkafka.basedomains.dto.OrderEvent;
import com.eventdrivenkafka.orderservice.kafka.OrderProducer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1")
public class OrderController {

    private OrderProducer orderProducer;

    public OrderController(OrderProducer orderProducer) {
        this.orderProducer = orderProducer;
    }

    @PostMapping("/orders")
    public ResponseEntity<?> placeOrder(@RequestBody Order order) {
        order.setOrderId(UUID.randomUUID().toString());
        OrderEvent orderEvent = new OrderEvent();
        orderEvent.setMessage("PENDING");
        orderEvent.setMessage("order status is pending state");
        orderEvent.setOrder(order);
        orderProducer.sendMessage(orderEvent);
        return ResponseEntity.ok("Order placed successfully");
    }
}
