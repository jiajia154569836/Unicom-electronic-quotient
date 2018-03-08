///**
// * Copyright (c) 2017 www.bonc.com.cn. All Rights Reserved.
// */
//package com.jiajia.controller.react;
//
//import com.alibaba.fastjson.JSONObject;
//import com.bonc.icrm.oc.api.dto.HumanAssignDto;
//import com.bonc.icrm.oc.api.dto.SlowLoadingDto;
//import com.bonc.icrm.oc.backend.order.dto.OrderInfoDto;
//import com.bonc.icrm.oc.backend.order.service.OrderService;
//import com.bonc.icrm.oc.backend.utils.HttpUtil;
//import com.bonc.icrm.oc.spi.order.entity.OcMesh;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
//import org.springframework.web.bind.annotation.*;
//
//import java.io.IOException;
//
///**
// * 订单管理接口
// *
// * @author yangwang1@bonc.com.cn
// * @version V1.0.0
// */
//@RestController
//@ConfigurationProperties(prefix = "order-operation")
////@RequestMapping(value = "/order")
//public class OrderController {
//
//
//    String opurl;
//
//    public String getOpurl() {
//        return opurl;
//    }
//
//    public void setOpurl(String opurl) {
//        this.opurl = opurl;
//    }
//
//    /**
//     * 分页搜索订单列表
//     * param ... 查询条件
//     * @param pageable  分页参数
//     * @return 订单列表
//     */
//    @GetMapping(value = "/list")
//    public Page<OrderInfoDto> find(String orderNum, String startTime, String endTime, String phoneNum,
//                                   String mobile, String consigneeName, String orderType, String bizStatus,
//                                   String productName, String channel, String orderTypeList, String address,
//                                   String cityCode, String staffNo, Pageable pageable) {
//        return orderService.find(orderNum, startTime, endTime, phoneNum, mobile, consigneeName, orderType, bizStatus,productName,channel,orderTypeList,address,cityCode,staffNo, pageable);
//    }
//
//
//    /**
//     * 查看订单详情
//     *
//     * @param id 订单ID
//     * @return 订单详情
//     */
//    @GetMapping(value = "/view/{id}")
//    public OrderInfoDto view(@PathVariable("id") String id) {
//        return orderService.view(id);
//    }
//
//    /**
//     *  查询未指派订单
//     * @param pageable
//     * @param orderType
//     * @return
//     */
//    @GetMapping(value = "/nozp")
//    public Page<OrderInfoDto> findNoZhipaiOrder(Pageable pageable, @RequestParam(name = "orderType", required = false) String orderType,
//                                                String orderNum, String mobile, String consigneeName, String startTime, String endTime, String cityCode){
//
//        return orderService.findNoZhipaiOrder(pageable, orderType, orderNum, mobile, consigneeName, startTime, endTime,cityCode);
//    }
//
//    /**
//     * 查询网格经理
//     */
//    @GetMapping(value = "/getMesh")
//    public Page<OcMesh> findMesh(Pageable pageable, String areaName, String areaid, String gridmanagerName, String staffid, String staffname){
//        return orderService.findMesh(pageable, areaName, areaid, gridmanagerName, staffid, staffname);
//    }
//
//    /**
//     * 人工指派
//     */
//    @PostMapping(value = "/humanAssign")
//    public String assign(@RequestBody HumanAssignDto humanAssignDto){
//        System.out.println("--------------------------------------------------------------------");
//        System.out.println("--------------------------------------------------------------------");
//        System.out.println("--------------------------------------------------------------------");
//        System.out.println("--------------------------------------------------------------------");
//        System.out.println("--------------------------------------------------------------------");
//        System.out.println(humanAssignDto.toString());
//        String URL = getOpurl();
//        String param = JSONObject.toJSONString(humanAssignDto);
//        String result=null;
//        try {
//            result = HttpUtil.httpPostJson(param,URL + "/operation/order/task/assign");
////            result = HttpUtil.httpPostJson(param,"http://localhost:10003" + "/operation/order/task/assign");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return result;
//    }
//
//    /**
//     * 人工指派
//     */
//    @PostMapping(value = "/humanSlow")
//    public String humanSlow(@RequestBody SlowLoadingDto slowLoadingDto){
//        System.out.println("--------------------------------------------------------------------");
//        System.out.println("--------------------------------------------------------------------");
//        System.out.println("--------------------------------------------------------------------");
//        System.out.println("--------------------------------------------------------------------");
//        System.out.println("--------------------------------------------------------------------");
//        System.out.println(slowLoadingDto.toString());
//        String URL = getOpurl();
//        String param = JSONObject.toJSONString(slowLoadingDto);
//        String result=null;
//
//
//        try {
//            result = HttpUtil.httpPostJson(param,URL + "/operation/order/task/slow");
////            result = HttpUtil.httpPostJson(param,"http://localhost:10003" + "/operation/order/task/assign");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        System.out.println("--------------------------------------------------------------------");
//        System.out.println("--------------------------------------------------------------------");
//        System.out.println("--------------------------------------------------------------------");
//        System.out.println("--------------------------------------------------------------------");
//        System.out.println("--------------------------------------------------------------------");
//        System.out.println(result);
//
//        return result;
//    }
//
//    /**
//     * 更改地市
//     * @param id
//     * @param cityCode
//     * @return
//     */
//    @GetMapping(value = "/changeCity")
//    public String changeCityCode(String id, String cityCode){
//        return orderService.changeCityCode(id, cityCode);
//    }
//}
