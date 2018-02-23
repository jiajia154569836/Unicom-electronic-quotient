package com.jiajia.service.impl;

import com.jiajia.model.User;
import com.jiajia.repository.UserRepository;
import com.jiajia.service.UserServce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServceimpl implements UserServce {


     private UserRepository userRepository;

     @Autowired
     public UserServceimpl(UserRepository userRepository) {
          this.userRepository = userRepository;
     }


     public Boolean login(String jiajia, String s)
     {


          User user = userRepository.findByUsername(jiajia);
          System.out.println(jiajia);
          System.out.println(s);
          if(s.equals(user.getPassword()))
          {
               return true;
          }
          return false;
     }




}
