package com.jiajia.main.service;

import com.jiajia.main.model.Order;
import com.jiajia.main.model.OrderDetail;
import com.jiajia.main.repository.OrderRepository;
import com.jiajia.main.utils.BeanMapper;
import com.jiajia.main.utils.MappingWithDetail;
import com.jiajia.main.utils.PredicateUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.ListJoin;
import javax.persistence.criteria.Predicate;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    MappingWithDetail mappingWithDetail;

    private List<String>  orderNumList;
    private String startData;
    private String endData;
    private List<String> orderTypeList2 = new ArrayList<String>();
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");


    @Transactional(readOnly = true, rollbackFor = Exception.class)
    public Page<Order> find(String orderNum, String startTime, String endTime, String phoneNum,
                            String mobile, String consigneeName, String orderType, String bizStatus,
                            String saleId, String channel, String orderTypeList, String address,
                            String cityCode, String staffNo, Pageable pageable) {
        Page<Order> page = orderRepository.findAll((root, query, cb) -> {
            Predicate p1 = null; Predicate p2 = null; Predicate p3 = null;
            Predicate p4 = null; Predicate p5 = null; Predicate p6 = null;
            Predicate p7 = null; Predicate p8 = null; Predicate p9 = null;
            Predicate p10 = null; Predicate p11 = null; Predicate p12 = null;
            Predicate p13 = null; Predicate p14 = null;
            //参数判断
            if (StringUtils.isNotBlank(orderNum)) {
                p1 = cb.like(root.get("orderNum"),  "%"+orderNum+"%");
            }
            if (StringUtils.isNotBlank(orderType)) {
                p2 = cb.equal(root.get("orderType"),  orderType);
            }
            if (StringUtils.isNotBlank(bizStatus)) {
                p3 = cb.equal(root.get("bizStatus"),  bizStatus);
            }
//            if (StringUtils.isNotBlank(mobile)) {
//                p4 = cb.like(root.get("consignee").get("mobile"),  "%"+mobile+"%");
//            }
            if (StringUtils.isNotBlank(mobile)) {
                p4 = cb.like(root.get("userId"),  "%"+mobile+"%");
            }

            if (StringUtils.isNotBlank(consigneeName)) {
                p5 = cb.like(root.get("consignee").get("consigneeName"),  "%"+consigneeName+"%");
            }
            if (StringUtils.isNotBlank(saleId)) {
                ListJoin<Order,OrderDetail> subJoin = root.join(root.getModel().getList("orderDetailList",OrderDetail.class), JoinType.LEFT);
                p6 = cb.equal(subJoin.get("saleId"), saleId);
            }
            if (StringUtils.isNotBlank(channel)) {
                p7 = cb.equal(root.get("channel"),  channel);
            }
            if (StringUtils.isNotBlank(orderTypeList)) {
                if("all".equals(orderTypeList)){
                    orderTypeList2.add("zs-flow");
                    orderTypeList2.add("zs-mobile-fare");
                    orderTypeList2.add("zs-electronic-ticket");
                    p8 = root.get("orderType").in(orderTypeList2);
                    orderTypeList2.clear();
                }else{
                    p8 = cb.equal(root.get("orderType"),  orderTypeList);
                }
            }
            if (StringUtils.isNotBlank(startTime)){
                startData = startTime+" 00:00:00";
                try{
                    Date date = sdf.parse(startData);
                    p9 = cb.greaterThan(root.get("orderDate"), date);
                }catch (ParseException e){
                    e.printStackTrace();
                }
            }
            if (StringUtils.isNotBlank(startTime)){
                endData = endTime + " 00:00:00";
                try{
                    Date date = sdf.parse(endData);
                    p10 = cb.lessThan(root.get("orderDate"), date);
                }catch (ParseException e) {
                    e.printStackTrace();
                }
            }
            if (StringUtils.isNotBlank(address)) {
                p11 = cb.like(root.get("consignee").get("address"),  "%"+address+"%");
            }
            if (StringUtils.isNotBlank(phoneNum)) {
                ListJoin<Order,OrderDetail> subJoin = root.join(root.getModel().getList("orderDetailList",OrderDetail.class), JoinType.LEFT);
                p12 = cb.like(subJoin.get("phoneNum"), "%"+phoneNum+"%");
            }
            if (StringUtils.isNotBlank(cityCode)) {
                p13 = cb.like(root.get("consignee").get("cityCode"),  "%"+cityCode+"%");
            }
            if (StringUtils.isNotBlank(staffNo)) {
                p14 = cb.like(root.get("staffNo"),  "%"+staffNo+"%");
            }

            return PredicateUtils.merge(cb, p1, p2, p3 ,p4, p5, p6, p7, p8, p9, p10, p11, p12, p13, p14);
        }, pageable);

        List<Order> data = new ArrayList<>();
        if (page.getTotalElements() > 0) {
            for (Order order : page.getContent()) {
                data.add(mappingWithDetail(order));
            }
        }
        return new PageImpl(data, pageable, page.getTotalElements());
    }

    private Order mappingWithDetail(Order order) {

        Order OrderInfoDto = BeanMapper.map(order, Order.class);
        return OrderInfoDto;
    }
}
