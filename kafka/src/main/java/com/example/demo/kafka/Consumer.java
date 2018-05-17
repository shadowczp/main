package com.example.demo.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.Properties;

public class Consumer extends Thread {
    private Logger logger = LoggerFactory.getLogger(Consumer.class);
    private KafkaConsumer<Integer, String> consumer;
    private String topic;
    private String groupId;
    private String id;

    public Consumer(String topic, String groupId, String id) {
        this.id = id;
        Properties props = new Properties();
        props.put("bootstrap.servers", "kafka1:9092");
        props.put("group.id", groupId);
        props.put("enable.auto.commit", "true");
        props.put("auto.commit.interval.ms", "1000");
        props.put("key.deserializer", "org.apache.kafka.common.serialization.IntegerDeserializer");
        props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("auto.offset.reset","earliest");
        consumer = new KafkaConsumer<>(props);
        consumer.subscribe(Arrays.asList(topic));
    }

    @Override
    public void run() {
        while (true) {
            ConsumerRecords<Integer, String> records = consumer.poll(100);
            for (ConsumerRecord<Integer, String> record : records) {
                System.out.printf("consumerID = %s, offset = %d, key = %s, value = %s, partition = %s%n", id, record.offset(), record.key(), record.value(), record.partition());
            }
        }
    }
}
