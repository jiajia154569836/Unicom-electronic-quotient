package com.jiajia.flow.com.jaijia.flow.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class TestController {

    @RequestMapping(value = "/test")
    public String  aa()
    {
        return "flow";
    }

}
