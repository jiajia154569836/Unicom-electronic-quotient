package com.jiajia.backend.controller.react;


import com.alibaba.fastjson.JSONObject;
import com.jiajia.backend.bean.Users;
import com.jiajia.backend.utils.HttpUtil;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequestMapping("/react/user")
public class UserController {


    @RequestMapping("/helloHtml")
    public String helloHtml() {
        // Map<String,Object> map
        //map.put("hello","from TemplateController.helloHtml");
        return "/helloHtml";
    }

    @PostMapping("/login")
    public String  login(@RequestBody Users users) throws IOException {

        System.out.println(users.toString());
        System.out.println("--------------------------------------------------------------------");
        System.out.println("--------------------------------------------------------------------");
        System.out.println("--------------------------------------------------------------------");
        System.out.println("--------------------------------------------------------------------");
        System.out.println("--------------------------------------------------------------------");
        String param = JSONObject.toJSONString(users);
        String result = null;

        try {
            // result = HttpUtil.httpPostJson(param,URL + "/operation/order/task/slow");
            result = HttpUtil.httpPostJson(param, "http://localhost:8072" + "/users/login");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    @RequestMapping("/html")
    public String html() {
        return "/helloHtml";
    }

    @GetMapping("/register")
    public void register(HttpServletResponse response) throws IOException {

    }


}
