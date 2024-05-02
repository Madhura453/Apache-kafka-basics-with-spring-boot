package comtemplate.kafkaavrobasic.consumer;

import comtemplate.kafkaavrobasic.schema.StockHistory;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class AvroConsumer {

    private static final Logger LOGGER= LoggerFactory.getLogger(AvroConsumer.class);

    @KafkaListener(topics="${avro.topic.name}",containerFactory = "kafkaListenerContainerFactory")
    public void read(ConsumerRecord<String, StockHistory> stockHistory)
    {
        String key=stockHistory.key();
       StockHistory record1=stockHistory.value();
        LOGGER.info("Avro message received for key :"+key+"value: "+stockHistory.value());
    }


}
