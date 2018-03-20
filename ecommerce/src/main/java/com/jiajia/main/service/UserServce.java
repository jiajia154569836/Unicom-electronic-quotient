package com.jiajia.main.service;

import com.jiajia.main.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserServce {
     Boolean login(String jiajia, String s);

     Boolean register(String jiajia, String s);

     //Page<User> find(String a_id, String a_password, String a_username, Pageable pageable);
}
