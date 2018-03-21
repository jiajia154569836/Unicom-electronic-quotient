package com.jiajia.main.service;

import com.jiajia.main.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserServce {
     Boolean login(String jiajia, String s);

     Boolean register(String jiajia, String s);
}

