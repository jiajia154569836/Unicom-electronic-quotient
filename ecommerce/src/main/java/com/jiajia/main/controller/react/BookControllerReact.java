package com.jiajia.main.controller.react;

import com.jiajia.main.service.BookServce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/books")
public class BookControllerReact {

    private final BookServce bookServce;

    @Autowired
    public BookControllerReact(BookServce bookServce) {
        this.bookServce = bookServce;
    }

    @RequestMapping("/helloHtml")
    public String helloHtml() {
        // Map<String,Object> map
        //map.put("hello","from TemplateController.helloHtml");
        return "/helloHtml";
    }

    @PostMapping("/list")
    public String list() throws IOException {
        String result = null;

        result = bookServce.list();

        System.out.println(result);
        System.out.println("--------------------------------------------------------------------");
        System.out.println("--------------------------------------------------------------------");
        System.out.println("--------------------------------------------------------------------");
        System.out.println("--------------------------------------------------------------------");
        System.out.println("--------------------------------------------------------------------");

        return result;
    }

    @RequestMapping("/html")
    public String html() {
        return "/helloHtml";
    }

    @GetMapping("/detail")
    public String detail(String id) throws IOException {
        String flag = bookServce.detail(id);
        return flag;
    }

}
