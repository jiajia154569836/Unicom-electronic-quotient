package com.jiajia.main.service.impl;

import com.jiajia.main.repository.UserRepository;
import com.jiajia.main.model.User;
import com.jiajia.main.service.UserServce;
import com.jiajia.main.utils.PredicateUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.criteria.Predicate;

@Service
public class UserServceimpl implements UserServce {


    private UserRepository userRepository;

    @Autowired
    public UserServceimpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Boolean login(String jiajia, String s) {
        User user = userRepository.findByUsername(jiajia);
        System.out.println(jiajia);
        System.out.println(s);
        if (s.equals(user.getPassword())) {
            return true;
        }
        return false;
    }

    public Boolean register(String jiajia, String s) {
        User user = new User();
        user.setUsername(jiajia);
        user.setPassword(s);
        userRepository.save(user);
        System.out.println(jiajia);
        System.out.println(s);
        return true;
    }

}
