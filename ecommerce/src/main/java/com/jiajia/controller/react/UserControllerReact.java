package com.jiajia.controller.react;

import com.jiajia.model.User;
import com.jiajia.model.Users;
import com.jiajia.service.UserServce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("/users")
public class UserControllerReact {

    private final UserServce userServce;

    @Autowired
    public UserControllerReact(UserServce userServce) {
        this.userServce = userServce;
    }

    @RequestMapping("/helloHtml")
    public String helloHtml(){
       // Map<String,Object> map
        //map.put("hello","from TemplateController.helloHtml");
        return "/helloHtml";
    }

    @PostMapping("/login")
    public boolean login(@RequestBody Users user) throws IOException {
       /* boolean flag=userServce.login(user.getUserName(),user.getPassword());*/
        System.out.println(user.getUserName());
        System.out.println(user.getPassword());
       /* if(flag)
        {
            response.sendRedirect("/user/html");
        }*/
        System.out.println(user.toString());
        System.out.println("--------------------------------------------------------------------");
        System.out.println("--------------------------------------------------------------------");
        System.out.println("--------------------------------------------------------------------");
        System.out.println("--------------------------------------------------------------------");
        System.out.println("--------------------------------------------------------------------");

      return true;
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
