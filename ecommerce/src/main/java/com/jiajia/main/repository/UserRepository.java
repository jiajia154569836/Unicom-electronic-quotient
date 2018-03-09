package com.jiajia.main.repository;

import com.jiajia.main.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {

    User findByUsername(String a_username);
}
