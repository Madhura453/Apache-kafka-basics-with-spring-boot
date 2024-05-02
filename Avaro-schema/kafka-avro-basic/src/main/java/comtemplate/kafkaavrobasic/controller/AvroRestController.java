package comtemplate.kafkaavrobasic.controller;

import comtemplate.kafkaavrobasic.producer.AvroProducer;
import comtemplate.kafkaavrobasic.schema.StockHistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/avro")
public class AvroRestController {

    @Autowired
    AvroProducer avroProducer;
    @PostMapping("/send")
    public ResponseEntity<String> sendStockHistory(@RequestBody StockHistory stockHistory)
    {
        avroProducer.send(stockHistory);
       return ResponseEntity.ok("we send message to kafka tempate");
    }
}
