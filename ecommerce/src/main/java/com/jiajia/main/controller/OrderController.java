package com.jiajia.main.controller;

import com.jiajia.main.model.Order;
import com.jiajia.main.model.User;
import com.jiajia.main.service.OrderService;
import com.jiajia.main.service.UserServce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequestMapping("/order")
public class OrderController {

    private  OrderService orderServce;

    @Autowired
    public OrderController(UserServce userServce) {
        this.orderServce = orderServce;
    }



    @GetMapping(value = "/list")
    public Page<Order> find(String orderNum, String startTime, String endTime, String phoneNum,
                            String mobile, String consigneeName, String orderType, String bizStatus,
                            String productName, String channel, String orderTypeList, String address,
                            String cityCode, String staffNo, Pageable pageable) {
        return orderServce.find(orderNum, startTime, endTime, phoneNum, mobile, consigneeName, orderType, bizStatus,productName,channel,orderTypeList,address,cityCode,staffNo, pageable);
    }
}
