package com.kafka.producer.wikimedia;

import com.launchdarkly.eventsource.MessageEvent;
import com.launchdarkly.eventsource.background.BackgroundEventHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;

public class WikimediaChangesHandler implements BackgroundEventHandler {

    /*
    This will trigger when ever there will be any event in wikimedia
     */
    @Value("${spring.kafka.topic.name}")
    private String topicName;

    private KafkaTemplate<String ,String> kafkaTemplate;

    public WikimediaChangesHandler(KafkaTemplate<String ,String> kafkaTemplate,String topicName)
    {
        this.kafkaTemplate=kafkaTemplate;
        this.topicName=topicName;
    }
    private static final Logger LOGGER= LoggerFactory.getLogger(WikimediaChangesHandler.class);
    @Override
    public void onOpen() throws Exception {

    }

    @Override
    public void onClosed() throws Exception {

    }

    @Override
    public void onMessage(String s, MessageEvent messageEvent) throws Exception {
       LOGGER.info(String.format("event data -> %s",messageEvent.getData()));
      kafkaTemplate.send(topicName,messageEvent.getData());
    }

    @Override
    public void onComment(String s) throws Exception {

    }

    @Override
    public void onError(Throwable throwable) {

    }
}
