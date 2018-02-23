package com.jiajia.controller;

import com.jiajia.service.UserServce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserServce userServce;

    @Autowired
    public UserController(UserServce userServce) {
        this.userServce = userServce;
    }

    @GetMapping("/login")
    public void login(HttpServletResponse response) throws IOException {
        boolean flag=userServce.login("jiajia","123456");
        if(flag)
        {
            response.sendRedirect("/user/html");
        }
    }

    @RequestMapping("/html")
    public String html()
    {
        return "/helloHtml";
    }

    @GetMapping("/register")
    public void register(HttpServletResponse response) throws IOException {
        boolean flag=userServce.register("jiajia","123456");
        if(flag)
        {
            response.sendRedirect("/user/html");
        }
    }



}
