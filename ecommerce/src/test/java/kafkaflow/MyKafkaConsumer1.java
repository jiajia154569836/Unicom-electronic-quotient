package kafkaflow;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.util.Arrays;
import java.util.Properties;

public class MyKafkaConsumer1 extends Thread
{
    private final KafkaConsumer<String,String> consumer;
    private final Properties props = new Properties();
    public MyKafkaConsumer1()
    {
        props.put("bootstrap.servers", KafkaProperties.kafkaServer);
        props.put("group.id", KafkaProperties.groupId);
        props.put("auto.offset.reset", "earliest");//latest
        props.put("enable.auto.commit", "true");
        props.put("auto.commit.interval.ms", "1000");
        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        consumer = new KafkaConsumer<>(props);
        consumer.subscribe(Arrays.asList("topic1","topic2"));


    }

    @Override
    public void run() {
        int messageNo = 1;
        while (messageNo<=3) {
            ConsumerRecords<String, String> records = consumer.poll(1000);
            for (ConsumerRecord<String, String> record : records)

                System.out.printf("topic=%s, offset = %d, key = %s, value = %s%n", record.topic(), record.offset(), record.key(), record.value());
            System.out.println("--------------------��ʼ��������---------------------");
            try {
                messageNo++;
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
   /* public static void main(String[] args)
    {
        MyKafkaConsumer1 myKafkaConsumer1 = new MyKafkaConsumer1();
        myKafkaConsumer1.start();
    }*/
}