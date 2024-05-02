package kafka.consumer.database.consumer;

//import kafka.consumer.database.repository.WikimediaDataRepository;
import kafka.consumer.database.entity.WikimediaData;
import kafka.consumer.database.repository.WikimediaDataRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;


@Service
public class KafkaDatabaseConsumer {

    private static final Logger LOGGER= LoggerFactory.getLogger(KafkaDatabaseConsumer.class);

    @Autowired
    private WikimediaDataRepository wikimediaDataRepository;


    @KafkaListener(topics ="${spring.kafka.topic.name}",groupId = "${spring.kafka.consumer.group-id}")
    public void consumeWikiMediaEvents(String eventMessage)
    {
      LOGGER.info(String.format("Event message received-> %s",eventMessage));

        WikimediaData wikimediaData=new WikimediaData();
        wikimediaData.setWikiEventData(eventMessage);
        wikimediaDataRepository.save(wikimediaData);
    }
}
