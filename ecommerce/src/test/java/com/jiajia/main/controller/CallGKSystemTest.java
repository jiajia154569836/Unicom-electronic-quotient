///*
//package com.jiajia.main.controller;
//
//import com.alibaba.fastjson.JSON;
//import com.jiajia.main.MainApplication;
//import org.apache.commons.collections.MapUtils;
//import org.apache.commons.lang.StringUtils;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.http.ResponseEntity;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.web.client.RestTemplate;
//import java.util.List;
//import java.util.Map;
//import java.util.Vector;
//
//*/
///**
// * Created by chao on 2018/1/11.
// *//*
//
//@RunWith(SpringRunner.class)
//@SpringBootTest(classes = MainApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//public class CallGKSystemTest {
//    private static final String WSDL_URL = "http://localhost:8080/ws/services/HelloWorld?wsdl";//接口的wsdl地址
//    private static final String OPERATION_NAME = "sayHelloWorldFrom"; // 方法名
//    private static final String NAME_SPACE = "http://HelloWorld"; // 命名空间
//
////    @Autowired
////    OrderRepository orderRepository;
//
//    @Autowired
//    RestTemplate restTemplate;
//
//
//    @Test
//    public void testShopAware() {
//        //String orderNum="";
//        //Optional<Order> optional = orderRepository.findByOrderNum(orderNum);
//        //String touchId =  order.getTouchId();
//        //String lightTouchId = order.getLightTouchId();
//        //Long saleId = Long.parseLong(order.getOrderDetailList().get(0).getSaleId());
//
//        String touchId =  "90b2aec";
//        String lightTouchId = "light001";
//        int saleId = 6942;
//
//        if (StringUtils.isNotBlank(touchId))
//        {
//            String url = AddressConst.OfferingAddress.AA;
//            ResponseEntity<String> entity = restTemplate.getForEntity(url, String.class, touchId ,saleId);
//            String body = entity.getBody();
//            System.out.println("----------------------------------");
//            System.out.println("商品中心返回参数：body:{}"+body);
//            if (org.springframework.util.StringUtils.isEmpty(body)){
//                //  return "信息错误";
//            }
//            Map resultMap = JSON.parseObject(body, Map.class);
//            String data = MapUtils.getString(resultMap, "data");
//            System.out.println("----------------------------------");
//            System.out.println("data"+data);
//            Map map = JSON.parseObject(data, Map.class);
//            int yuangong = MapUtils.getInteger(map, "yuangong");
//            int pDevelop = MapUtils.getInteger(map, "pDevelop");
//            System.out.println("----------------------------------");
//            System.out.println("yuangong"+yuangong+"pDevelop"+pDevelop);
//        }
//
//        if (StringUtils.isNotBlank(lightTouchId))
//        {
//            String url = AddressConst.OfferingAddress.BB;
//            ResponseEntity<String> entity = restTemplate.getForEntity(url, String.class, lightTouchId);
//            String body = entity.getBody();
//            System.out.println("----------------------------------");
//            System.out.println("触点中心返回参数：body:{}"+body);
//            if (org.springframework.util.StringUtils.isEmpty(body)){
//                //  return "信息错误";
//            }
//            Map resultMap = JSON.parseObject(body, Map.class);
//            String msg = MapUtils.getString(resultMap, "msg");
//            String data= MapUtils.getString(resultMap, "data");
//            List list = JSON.parseObject(toString().valueOf(data), List.class);
//            Map map = (Map) list.get(0);
//            String mobile=map.get("mobile").toString();
//          //  Object channelNo=map.get("channelNo").toString();
//            System.out.println("----------------------------------");
//            //System.out.println("channelNo"+channelNo);
//            System.out.println("mobile"+mobile);
//        }
//    }
//
//}
//*/
