package com.apache.kafkaconsumer.notes;

public class Notes {
    /*
    consumer groups=cg
    1. group-id: madhura-group this is consumer group id
    2. the zookeeper and kafka server will assign partitions to consumer groups based on group id.
    3. if 3 partition, 4 consumer groups was there. the 4th consumer group will sit ideally until other
    cg was destroyed and stopped
    4. By using concurrency we can implement multiple consumer groups for better throughput
    5.log indicates that how many message failures received by consumer. not received by consumer
    6. apache kafka is suitable with multimodal project

    configuration'
    2 ways application.yml or own custom configuration java file so put only one at a time KafkaConsumerConfig
    or application.properties
     */
}
