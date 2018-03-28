package com.jiajia.main.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;


/*
* 在数据库的操作中将编码改为utf-8
* */
/*
* 用户表
* */
@Entity
@Table(name="qq")
@Data
public class Qq {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="a")
    Integer a;

    @Column(name="b")
    Integer b;

    @Column(name="c")
    Integer c;

}
