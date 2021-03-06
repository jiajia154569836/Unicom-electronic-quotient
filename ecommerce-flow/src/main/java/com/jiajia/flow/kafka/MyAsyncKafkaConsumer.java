package com.jiajia.flow.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

public class MyAsyncKafkaConsumer
{
    private final KafkaConsumer<String,String> consumer;
    private final String topic;
    private final Properties props = new Properties();
    final int minBatchSize = 30;
    List<ConsumerRecord<String, String>> buffer = new ArrayList<>();
    public MyAsyncKafkaConsumer(String topic)
    {
        props.put("bootstrap.servers", KafkaProperties.kafkaServer);
        props.put("group.id", KafkaProperties.groupId);
        props.put("enable.auto.commit", "false");
        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        consumer = new KafkaConsumer<>(props);
        consumer.subscribe(Arrays.asList(topic));
        this.topic = topic;
        while (true){
            ConsumerRecords<String, String> records = consumer.poll(10);
            for (ConsumerRecord<String, String> record : records) {
                System.out.printf("async:offset = %d, key = %s, value = %s%n", record.offset(), record.key(), record.value());
                buffer.add(record);
            }
            if (buffer.size() >= minBatchSize) {
                System.out.println("async reached buffer size");
                consumer.commitSync();
                buffer.clear();
            }
        }
    }
    public static void main(String[] args)
    {
        new MyAsyncKafkaConsumer(KafkaProperties.topic);
    }

}