package com.jiajia.main.service.impl;

import com.alibaba.fastjson.JSON;
import com.jiajia.main.repository.BookRepository;
import com.jiajia.main.model.Book;
import com.jiajia.main.service.BookServce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class BookServceimpl implements BookServce {


     private BookRepository bookRepository;

     @Autowired
     public BookServceimpl(BookRepository bookRepository) {
          this.bookRepository = bookRepository;
     }


     public String list()
     {
          Iterable<Book> gene = bookRepository.findAll();
          List<Book> list = new ArrayList<Book>();
          gene.forEach(single ->{list.add(single); } );
          String result =  JSON.toJSONString(list);
          return result;
     }

     public String detail(String type)
     {

          return "";
     }

}
