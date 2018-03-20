/**
 * Copyright (c) 2017 www.bonc.com.cn. All Rights Reserved.
 */
package com.jiajia.main.repository;

import com.jiajia.main.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

/**
 * 描述当前功能
 *
 * @author yangwang1@bonc.com.cn
 * @version V1.0.0
 */
public interface OrderRepository extends JpaRepository<Order, String>, JpaSpecificationExecutor {

    Optional<Order> findByOrderNum(String orderNum);


}
