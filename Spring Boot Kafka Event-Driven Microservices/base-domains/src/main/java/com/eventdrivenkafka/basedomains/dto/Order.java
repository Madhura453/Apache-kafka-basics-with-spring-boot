package com.eventdrivenkafka.basedomains.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Order {

    private String orderId;

    private String name;

    private int c;

    private double price;
}
