package comtemplate.kafkaavrobasic.config;

import comtemplate.kafkaavrobasic.schema.StockHistory;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.config.KafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.listener.ConcurrentMessageListenerContainer;

@Configuration
public class ConsumerConfig {

    @Bean
    public ConsumerFactory<String, StockHistory> consumerFactory(KafkaProperties kafkaProperties)
    {
        return new DefaultKafkaConsumerFactory<>(kafkaProperties.buildConsumerProperties());
    }

    @Bean
    public KafkaListenerContainerFactory<ConcurrentMessageListenerContainer<String,StockHistory>> kafkaListenerContainerFactory(KafkaProperties kafkaProperties)
    {
        ConcurrentKafkaListenerContainerFactory<String,StockHistory> kafkaListenerContainerFactory=
                new ConcurrentKafkaListenerContainerFactory<String,StockHistory>();
        kafkaListenerContainerFactory.setConsumerFactory(consumerFactory(kafkaProperties));
        return kafkaListenerContainerFactory;
    }
}

