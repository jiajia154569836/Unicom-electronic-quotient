package com.jiajia.main.kafka;

import com.alibaba.fastjson.JSON;
import com.jiajia.main.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kafka")
public class FeignController {

    @Autowired
    KafkaTemplate kafkaTemplate;

    int i=0;
    @GetMapping("/test")
    public void testkafka() {

        kafkaTemplate.send("bootcwenaoTopic", "bootcwnao", "haha");

    }
    @GetMapping("/user")
    public void order() {

        User user = new User();
        user.setId(i++);
        user.setUsername("11");
        user.setPassword("22");
        kafkaTemplate.send("orderTopic", "order", JSON.toJSONString(user));

    }
}
