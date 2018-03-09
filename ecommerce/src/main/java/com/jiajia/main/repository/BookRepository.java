package com.jiajia.main.repository;

import com.jiajia.main.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Integer> {


}
