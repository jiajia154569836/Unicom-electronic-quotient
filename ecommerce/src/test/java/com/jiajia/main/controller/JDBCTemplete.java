package com.jiajia.main.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.jiajia.main.MainApplication;
import com.jiajia.main.model.Order;
import com.jiajia.main.model.Qq;
import com.jiajia.main.repository.QRepository;
import com.jiajia.main.utils.HttpUtil;
import org.apache.commons.collections.MapUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MainApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)

public class JDBCTemplete {


    private static final Logger logger = LoggerFactory.getLogger(JDBCTemplete.class);
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    QRepository qRepository;



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
        //String channelNo=map.get("channelNo").toString();
        System.out.println("----------------------------------"+mobile);

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

    @Test
    public void tencentToBaidu(/*double longitude, double latitude*/) {
        double longitude = 35;
        double latitude =35;
        String address ="http://api.map.baidu.com/geoconv/v1/?from=3&to=5&ak=pXph9gPv3vjW40NZXG9AqzsW&coords=longitude,latitude";
        String url = address.replace("longitude", longitude + "").replace("latitude", latitude + "");
        String result = HttpUtil.httpGet(url);
        System.out.println(result.toString());
        /*Map<String, String> map = httpClientUtil.doGet(url);
        System.out.println(map.toString());
        String content = map.get("content");
        MapConvertResultDto resultDto = JSONObject.parseObject(content, MapConvertResultDto.class);
        MapConvertResultDto dto = JSONObject.parseObject(resultDto.getResult().get(0).toString(), MapConvertResultDto.class);
        String result = dto.getX() + "," + dto.getY();
        System.out.println(result);*/
        //return result;
    }

    @Test
    public void testQuery() throws Exception {

        //userQueryRepository.deleteAB(1,1);
       // qRepository.updateState(1,3);
        List<Qq> list = new ArrayList<Qq>();
        list = qRepository.findAllQ();
       // Qq qq = userQueryRepository.findByA(2);
        System.out.println(list.toString());
        //System.out.println(qq.toString());

    }

    /***
     * 百度地图坐标转GPS坐标
     * @param baiduLon  百度地图经度
     * @param baiduLat  百度地图纬度
     * 注释:百度坐标和GPS坐标转换在很近的距离时偏差非常接近。
    假设你有百度坐标：x1=116.397428，y1=39.90923
    把这个坐标当成GPS坐标，通过接口获得他的百度坐标：x2=116.41004950566，y2=39.916979519873
    通过计算就可以得到GPS的坐标：
    x = 2*x1-x2，y = 2*y1-y2
    x=116.38480649434001
    y=39.901480480127
     * @return
     * @throws
     */
    @Test
    public void testBaiduToGis(/*double baiduLon, double baiduLat*/)  {
        double baiduLon=116.397428;
        double baiduLat=39.90923;
        String bdUrl = "http://api.map.baidu.com/geoconv/v1/?from=1&to=5&ak=5FVsSwr28sepnKMtdBX7wgQvHUNgBd5f&coords="+baiduLon+","+baiduLat;
        JSONObject resp = JSON.parseObject(HttpUtil.httpGet(bdUrl));
        logger.info("百度坐标转换返回结果 : {}", resp.toJSONString());

        if(0 == resp.getInteger("status"))
        {
            //成功
            JSONArray res = resp.getJSONArray("result");
            JSONObject jsonObject = res.getJSONObject(0);

            double x2 = jsonObject.getDouble("x");
            double y2 = jsonObject.getDouble("y");

            double gpsLon = (2*baiduLon - x2);
            double gpsLat = (2*baiduLat - y2);
            logger.info("百度转GPS坐标后的结果 : {}, {}", gpsLon, gpsLat);

           // return new LngLat(gpsLon, gpsLat);
        }
        else
        {
            logger.error("百度坐标转换失败, status : {}", resp.getInteger("status"));
            //return null;
        }
    }
}
