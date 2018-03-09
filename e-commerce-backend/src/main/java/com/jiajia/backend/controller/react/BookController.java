package com.jiajia.backend.controller.react;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.jiajia.backend.bean.BookDto;
import com.jiajia.backend.utils.BeanMapper;
import com.jiajia.backend.utils.HttpUtil;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.web.bind.annotation.*;
import com.jiajia.main.model.Book;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@ConfigurationProperties(prefix = "book-operation")
@RequestMapping("/react/book")
public class BookController {
    String opurl;

    public String getOpurl() {
        return opurl;
    }


    @RequestMapping("/helloHtml")
    public String helloHtml() {
        // Map<String,Object> map
        //map.put("hello","from TemplateController.helloHtml");
        return "/helloHtml";
    }



    @GetMapping("/list")
    public List<BookDto>  list() throws IOException {
        List<Book> bookList = new ArrayList<Book>();
        List<BookDto> bookListDto = new ArrayList<BookDto>();
         String param = JSONObject.toJSONString(null);
        String result = null;

        /*
        String jsonString = JSON.toJSONString(group);
        System.out.println("jsonString:" + jsonString);
        UserGroup group2 = JSON.parseObject(jsonString, UserGroup.class);
        System.out.println("jsonString:" + jsonString);
        // JSON串转用户组对象
        bookList  = JSON.parseArray(jsonString, Book.class);
        */

        try {
            // result = HttpUtil.httpPostJson(param,URL + "/operation/order/task/slow");
            result = HttpUtil.httpPostJson(param, "http://localhost:8072" + "/books/list");
        } catch (IOException e) {
            e.printStackTrace();
        }
        bookList  = JSON.parseArray(result, Book.class);
        System.out.println(bookList.toString());
        System.out.println("--------------------------------------------------------------------");
        System.out.println("--------------------------------------------------------------------");
        System.out.println("--------------------------------------------------------------------");
        System.out.println("--------------------------------------------------------------------");
        System.out.println("--------------------------------------------------------------------");
        int a=0;
        if (bookList.size() > 0) {
            for (Book book1 : bookList) {
                BookDto bookDto = BeanMapper.map(book1, BookDto.class);
                bookDto.setSex(a+++"");
                bookListDto.add(bookDto);
            }
        }
        System.out.println(bookListDto.toString());
        return  bookListDto;
    }

    @RequestMapping("/html")
    public String html() {
        return "/helloHtml";
    }

    @GetMapping("/register")
    public void register(HttpServletResponse response) throws IOException {

    }


}
