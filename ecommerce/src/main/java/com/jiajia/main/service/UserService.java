package com.jiajia.main.service;

import com.jiajia.main.model.User;
import com.jiajia.main.repository.UserRepository;
import com.jiajia.main.utils.PredicateUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {


     @Autowired
     UserRepository userRepository;

     @Transactional(readOnly = true, rollbackFor = Exception.class)
     public Page<User> find(String a_password,String a_username, Pageable pageable) {
          System.out.println(a_password+"------------"+a_username);
          Page<User> page = userRepository.findAll((root, query, cb) -> {
               Predicate p1 = null; Predicate p2 = null; Predicate p3 = null;
               //参数判断
//               if (a_id > 0) {
//                    p1 = cb.equal(root.get("id"), a_id);
//               }
               if (StringUtils.isNotBlank(a_password)) {
                    p2 = cb.equal(root.get("password"),  a_password);
               }
               if (StringUtils.isNotBlank(a_username)) {
                    p3 = cb.equal(root.get("username"),  a_username);
               }

               return PredicateUtils.merge(cb, p2, p3 );
          }, pageable);
          System.out.println(page.toString());
          List<User> data = new ArrayList<>();
          if (page.getTotalElements() > 0) {
               for (User order : page.getContent()) {
                    data.add(order);
               }
          }
          return new PageImpl(data, pageable, page.getTotalElements());
     }
}
