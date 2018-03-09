package com.jiajia.main.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.Date;


/*
* 在数据库的操作中将编码改为utf-8
* */
/*
* 用户表
* */
@Entity
@Table(name="a_book")
@Data
@RequiredArgsConstructor
public class Book {
    @Id
    @Column(name="bookId")
    @GeneratedValue
    Integer bookId;

    @Column(name="bookName")
    String bookName;

    @Column(name="bookPrice")
    String bookPrice;

    @Column(name="bookTime")
    Date bookTime;

}
