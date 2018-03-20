package com.jiajia.main.service.impl;

import com.alibaba.fastjson.JSON;
import com.jiajia.main.model.Book;
import com.jiajia.main.repository.BookRepository;
import com.jiajia.main.service.BookServce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookServceimpl implements BookServce {


     private BookRepository bookRepository;

     @Autowired
     public BookServceimpl(BookRepository bookRepository) {
          this.bookRepository = bookRepository;
     }

     //ead-only="true"表示该事务为只读事务，比如上面说的多条查询的这种情况可以使用只读事务，
     //由于只读事务不存在数据的修改，因此数据库将会为只读事务提供一些优化手段，例如Oracle对于只读事务，不启动回滚段，不记录回滚log。
     @Transactional(readOnly = true, rollbackFor = Exception.class)
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
