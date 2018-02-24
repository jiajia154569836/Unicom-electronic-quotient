package com.jiajia.model;

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
@Table(name="a_user")
@Data
@RequiredArgsConstructor
public class User {
    @Id
    @Column(name="a_id")
    @GeneratedValue
    Integer id;

    @Column(name="a_username")
    String username;

    @Column(name="a_password")
    String password;

}
