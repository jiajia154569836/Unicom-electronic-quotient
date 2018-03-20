package com.jiajia.main.controller;

import com.jiajia.main.model.Order;
import com.jiajia.main.model.User;
import com.jiajia.main.service.OrderService;
import com.jiajia.main.service.UserServce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class UsersController {

    private UserServce userServce;

    @Autowired
    public UsersController(UserServce userServce) {
        this.userServce = userServce;
    }



   /* @GetMapping(value = "/list")
    public Page<User> find(String a_id, String a_password, String a_username, Pageable pageable) {
        return userServce.find(a_id, a_password, a_username, pageable);
    }*/
}
