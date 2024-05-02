package comtemplate.kafkaavrobasic.notes;

public class Notes {
    /*
    autoOffsetReset: "earliest"= for first time create the topic it will use later
    on it will use reset where it left from there it will read the message

    means read the message from the topic first offset

https://stackoverflow.com/questions/60344848/kafka-avro-serialize-deserialize-into-concrete-type-using-schema-registry-failin/73247629#73247629
    I was getting blocked by the same issue as you. Thing is that the KafkaAvroDeserializer was deserializing the message as GenericData$Record so then spring kafka is searching the class annotated with @KafkaListener to have @KafkaHandler methods with a parameter of this type.

You'll need to add this property to your spring kafka configuration so the deserializer can return directly the SpecificRecord classes that you previously need to generate with the avro plugin:

spring:
  kafka:
    properties:
      specific.avro.reader: true
     */
}
