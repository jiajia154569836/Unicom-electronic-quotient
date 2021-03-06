package com.jiajia.flow.kafka;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import com.alibaba.fastjson.JSON;
import org.apache.kafka.clients.producer.*;


public class MyKafkaProducer extends Thread
{
    private final Producer<String, String> producer;
    private final String topic;
    private final Properties props = new Properties();

   /* public static void main(String[] args)
    {
        MyKafkaProducer producerThread = new MyKafkaProducer(KafkaProperties.topic);
        producerThread.start();
    }*/

    public MyKafkaProducer(String topic)
    {
        props.put("bootstrap.servers", KafkaProperties.kafkaServer);
        props.put("acks", "all");
        props.put("retries", 0);
        //props.put("batch.size", 16384);
        props.put("linger.ms", 1);
        props.put("buffer.memory", 33554432);
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        producer = new KafkaProducer<>(props);
        this.topic = topic;
    }
    @Override
    public void run() {
        int messageNo = 1;
        while (messageNo<=3)
        {
            String messageStr = new String("Message_" + messageNo);
            Map map = new HashMap();
            map.put("a",1);
            map.put("b",2);
            String str = JSON.toJSONString(map);


            System.out.println("Send:" + messageStr);
            producer.send(new ProducerRecord<>(topic, "key_"+messageNo,messageStr),   new Callback() {
                public void onCompletion(RecordMetadata metadata, Exception e) {
                    if (e != null) {
                        e.printStackTrace();
                    } else {
                        System.out.println("---------------------------��ʼ��������------------------------------------");
                        System.out.println("The offset of the record we just sent is: " + metadata.offset());
                    }
                }
            });
            messageNo++;

            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}