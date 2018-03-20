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
/*
    @Transactional(readOnly = true, rollbackFor = Exception.class)
    public Page<User> find(String a_id, String a_password, String a_username, Pageable pageable) {
        Page<User> page = userRepository.findAll((root, query, cb) -> {
            Predicate p1 = null;
            Predicate p2 = null;
            Predicate p3 = null;
            //参数判断
            if (StringUtils.isNotBlank(a_id)) {
                p1 = cb.like(root.get("id"), "%" + a_id + "%");
            }
            if (StringUtils.isNotBlank(a_password)) {
                p2 = cb.like(root.get("password"), "%" + a_password + "%");
            }
            if (StringUtils.isNotBlank(a_username)) {
                p3 = cb.like(root.get("username"), "%" + a_username + "%");
            }
            return PredicateUtils.merge(cb, p1, p2, p3);
        }, pageable);
        return new PageImpl(page.getContent(), pageable, page.getTotalElements());
    }
*/
}
