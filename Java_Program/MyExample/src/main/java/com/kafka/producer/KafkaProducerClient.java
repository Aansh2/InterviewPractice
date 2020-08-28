package com.kafka.producer;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.Serde;

import java.util.Properties;

public class KafkaProducerClient {
    public static void main(String[] args) throws Exception {

        String topicName = "SimpleProducerTopic";
        String key = "Key1";
        String value = "Value-1";

        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9092,localhost:9093");
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        Producer<String, String> producer = new KafkaProducer<>(props);

        ProducerRecord<String, String> record = new ProducerRecord<>(topicName, key, value);
        producer.send(record);
        producer.close();

        System.out.println("SimpleProducer Completed.");
    }
}
