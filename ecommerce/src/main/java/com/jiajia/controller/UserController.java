package com.jiajia.controller;

import com.jiajia.service.UserServce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserServce userServce;

    @Autowired
    public UserController(UserServce userServce) {
        this.userServce = userServce;
    }

    @GetMapping("/login")
    public boolean login()
    {

        boolean flag=userServce.login("jiajia","123456");
        return flag;
    }



}
