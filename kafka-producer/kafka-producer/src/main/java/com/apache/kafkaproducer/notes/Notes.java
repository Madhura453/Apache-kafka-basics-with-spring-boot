package com.apache.kafkaproducer.notes;

public class Notes {
    /*
   1. It's not in hour hand which partition need to send message.
   2. it will be controlled by zookeeper or kafka server

   // customer
   1. while sending message to topic it always allows byte array as input
   2. serializing(byte array)=producer , deserializing(string)=consumer
   3. string automatically convert to byte array
   4. In case of customer or any dto we need write serializing logic and deserializing logic

    configuration'
 2 ways application.yml or own custom configuration java file so put only one at a time KafkaProducerConfig
    or application.properties
     */
}
