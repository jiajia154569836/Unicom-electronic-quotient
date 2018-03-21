package com.jiajia.main.controller;

import com.jiajia.main.model.User;
import com.jiajia.main.service.UserServce;
import com.jiajia.main.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

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
    public void login(User user, HttpServletResponse response) throws IOException {
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
