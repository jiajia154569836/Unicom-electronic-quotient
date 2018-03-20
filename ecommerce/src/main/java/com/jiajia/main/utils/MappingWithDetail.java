package com.jiajia.main.utils;

import com.jiajia.main.model.Order;

public class MappingWithDetail {

    public Order mappingWithDetail(Order order) {

        Order OrderInfoDto = BeanMapper.map(order, Order.class);
        return OrderInfoDto;
    }
}
