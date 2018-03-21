package com.jiajia.main.controller;

import com.alibaba.fastjson.JSON;
import com.jiajia.main.model.Order;
import com.jiajia.main.model.User;
import com.jiajia.main.service.OrderService;
import com.jiajia.main.service.UserServce;
import com.jiajia.main.service.UserService;
import org.apache.commons.collections.MapUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/order")
public class OrderController {

    //private  OrderService orderServce;

    private final UserService userService;

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    public OrderController(/*OrderService orderServce,*/UserService userService/*,RestTemplate restTemplate*/) {
       // this.orderServce = orderServce;
      //  this.restTemplate = restTemplate;
        this.userService = userService;
    }

//    @GetMapping(value = "/list")
//    public Page<Order> find(String orderNum, String startTime, String endTime, String phoneNum,
//                            String mobile, String consigneeName, String orderType, String bizStatus,
//                            String productName, String channel, String orderTypeList, String address,
//                            String cityCode, String staffNo, Pageable pageable) {
//        return orderServce.find(orderNum, startTime, endTime, phoneNum, mobile, consigneeName, orderType, bizStatus,productName,channel,orderTypeList,address,cityCode,staffNo, pageable);
//    }


    //http://localhost:8072/order/list?a_password=123&page=0&size=2  初始page为0
    @GetMapping(value = "/list")
    //http://localhost:8072/user/list?a_id=123&page=1&size=2
    public Page<User> find(String a_password, String a_username, Pageable pageable) {
        return userService.find(a_password, a_username, pageable);
    }


}
