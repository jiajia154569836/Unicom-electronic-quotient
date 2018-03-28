package com.jiajia.main.kafka;

import com.alibaba.fastjson.JSON;
import com.jiajia.main.model.User;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class OrderListeners {

    @KafkaListener(topics = {"orderTopic"})
    public void orderListener(String content) {
        System.out.println(content);
        System.out.println("-----------------------------------");
        User user = JSON.parseObject(content, User.class);
        System.out.println(user.toString());
        //return user.toString();


    }
}
