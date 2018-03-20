package com.jiajia.main.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class KafkaListeners {

    @KafkaListener(topics = {"bootcwenaoTopic"})
    public void testListener(ConsumerRecord<?, ?> record) {

        Optional<?> messages = Optional.ofNullable(record.value());

        if (messages.isPresent()) {
            Object msg = messages.get();
            System.out.println("  this is the testTopic send message: " + msg);
        }
    }
}
