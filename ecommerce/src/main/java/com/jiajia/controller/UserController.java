package com.jiajia.controller;

import com.jiajia.model.User;
import com.jiajia.service.UserServce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {

    private final UserServce userServce;

    @Autowired
    public UserController(UserServce userServce) {
        this.userServce = userServce;
    }

    @RequestMapping("/helloHtml")
    public String helloHtml(){
       // Map<String,Object> map
        //map.put("hello","from TemplateController.helloHtml");
        return "/helloHtml";
    }

    @GetMapping("/login")
    public void login( User user,HttpServletResponse response) throws IOException {
        boolean flag=userServce.login(user.getUsername(),user.getPassword());
        System.out.println(user.getUsername());
        System.out.println(user.getPassword());
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
