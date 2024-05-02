package com.kafka.producer.wikimedia;

import com.launchdarkly.eventsource.ConnectStrategy;
import com.launchdarkly.eventsource.EventSource;
import com.launchdarkly.eventsource.background.BackgroundEventHandler;
import com.launchdarkly.eventsource.background.BackgroundEventSource;
import okhttp3.Headers;
import okhttp3.internal.http.HttpHeaders;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.util.concurrent.TimeUnit;

@Service
public class WikimediaChangesProducer {

    private static final Logger LOGGER= LoggerFactory.getLogger(WikimediaChangesProducer.class);

    @Value("${spring.kafka.topic.name}")
    private String topicName;

    private KafkaTemplate<String ,String> kafkaTemplate;

    private WikimediaChangesProducer(KafkaTemplate<String,String> kafkaTemplate)
    {
        this.kafkaTemplate=kafkaTemplate;
    }

    public void sendMessage()
    {
        // to reade real time stream data from wikimedia we use eventsource

        BackgroundEventHandler backgroundEventHandler=new WikimediaChangesHandler(kafkaTemplate,topicName);

        String url="https://stream.wikimedia.org/v2/stream/recentchange";

        // create eventsource which will connect to the real url source
        // event source will connect to the source
        Headers myCustomHeaders= new Headers.Builder().build();

        ConnectStrategy connectStrategy=ConnectStrategy.http(URI.create(url))
                .headers(myCustomHeaders)
                .connectTimeout(115, TimeUnit.SECONDS);

        EventSource.Builder eventSourceBuilder=new EventSource.Builder(connectStrategy);

        BackgroundEventSource backgroundEventSource= new BackgroundEventSource.Builder(backgroundEventHandler,eventSourceBuilder).build();

       backgroundEventSource.start();

    }
}
