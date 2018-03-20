package com.jiajia.main.controller;

import com.alibaba.fastjson.JSON;
import com.jiajia.main.MainApplication;
import com.jiajia.main.model.Order;
import com.jiajia.main.utils.HttpUtil;
import org.apache.commons.collections.MapUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MainApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class JDBCTemplete {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    private RestTemplate restTemplate;

    @Test
    @Transactional
    public void restTemplateTest()
    {
        String url = "http://133.195.235.81/tpc-test/v1/tpc/light/findLightPointById?id={1}";
        ResponseEntity<String> entity = restTemplate.getForEntity(url, String.class, "light001");
        String body = entity.getBody();
        System.out.println("----------------------------------");
        System.out.println("触点中心返回参数：body:{}"+body);
        if (org.springframework.util.StringUtils.isEmpty(body)){
            //  return "信息错误";
        }
        Map resultMap = JSON.parseObject(body, Map.class);
        String msg = MapUtils.getString(resultMap, "msg");
        String data= MapUtils.getString(resultMap, "data");
        List list = JSON.parseObject(toString().valueOf(data), List.class);
        Map map = (Map) list.get(0);
        String mobile=map.get("mobile").toString();
        String channelNo=map.get("channelNo").toString();
        System.out.println("----------------------------------"+mobile+channelNo);

    }

    @Test
    public void jdbcTemplateTest()
    {

        int bookPrice =jdbcTemplate.queryForObject("select book_name from a_book where book_id='"+2+"'",Integer.class);
        System.out.println("-------------------------");
        System.out.println(bookPrice);
    }

    @Test
    public void testAware() throws Exception {
        /*
        * post请求中带有url参数的请求方法
        * */
        //POST http://133.193.24.68:8088/channel/webservice/doRewardPay/queryWoacount?order_no=12345678921&staff_id=13213310021
        Order order = new Order();
        String order_no = "fa3de08d633a1137";
        String staff_id = "13213310021";
        String URL = "http://133.193.24.68:8088";
        String param = "";
        String result = null;
        Map<String, String> map = new HashMap();
        map.put("order_no", order_no);
        map.put("staff_id", staff_id);
        //  /channel/webservice/doRewardPay/postWoPayRealTime
        //  /channel/webservice/doRewardPay/queryWoacount
        result = HttpUtil.httpPost(URL + "/channel/webservice/doRewardPay/queryWoacount", map);
        System.out.println("------------------------------------------");
        System.out.println("------------------------------------------");
        System.out.println("------------------------------------------");
        System.out.println("------------------------------------------");
        System.out.println("------------------------------------------");
        System.out.println(result.toString());
        Map resultMap = JSON.parseObject(result, Map.class);
        String msg = org.apache.commons.collections4.MapUtils.getString(resultMap, "msg");
        String code = org.apache.commons.collections4.MapUtils.getString(resultMap, "code");
        String wo_account_id = org.apache.commons.collections4.MapUtils.getString(resultMap, "wo_account_id");
        System.out.println("msg="+msg+"code="+code+"wo_account_id="+wo_account_id);
    }



}
