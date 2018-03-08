package com.jiajia.utils;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * HttpUtil
 * author:songg
 * date:20171018
 */
public class HttpUtil {

    private static Logger logger = LoggerFactory.getLogger(HttpUtil.class);

    private static final int TIME_OUT = 60000;


    /**
     * 发送http get请求
     *
     * @param url
     * @return
     * @throws Exception
     */
    public static String httpGet(String url) {
        logger.info("开始提交Get请求：" + url);
        String result = "";
        CloseableHttpClient client = null;
        try {
            client = HttpClients.createDefault();
            HttpGet httpGet = new HttpGet(url);
            RequestConfig config = RequestConfig.custom()
                    .setConnectTimeout(TIME_OUT).setConnectionRequestTimeout(TIME_OUT).build();
            httpGet.setConfig(config);
            CloseableHttpResponse response = client.execute(httpGet);

            HttpEntity entity = response.getEntity();
            if (null != entity) {
                int statusCode = response.getStatusLine().getStatusCode();
                logger.info("请求Url[" + url + "]返回的状态码：" + statusCode);
                result = EntityUtils.toString(entity, "utf-8");
            }
            response.close();
        } catch (Exception e) {
            logger.error("Exception while execute httpGet:" + url, e);
        } finally {
            if (null != client) {
                try {
                    client.close();
                } catch (Exception e) {
                    logger.error("Exception while close client.", e);
                }
            }
        }
        return result;
    }


    /**
     * 发送http post请求
     *
     * @return
     * @throws Exception
     */
    public static String httpPost(String url, Map<String, String> params) throws Exception {
        logger.info("开始提交Post请求：" + url);
        logger.info("请求参数：" + JSON.toJSONString(params));
        String result = "";
        CloseableHttpClient client = null;
        try {
            client = HttpClients.createDefault();
            HttpPost httpPost = new HttpPost(url);
            RequestConfig config = RequestConfig.custom()
                    .setConnectTimeout(60000).setConnectionRequestTimeout(60000).build();
            httpPost.setConfig(config);

            List<NameValuePair> paramList = new ArrayList<NameValuePair>();
            if (null != params && !params.isEmpty()) {
                Set<String> keySet = params.keySet();
                for (String key : keySet) {
                    paramList.add(new BasicNameValuePair(key, params.get(key)));
                }
            }
            UrlEncodedFormEntity uefEntity = new UrlEncodedFormEntity(paramList, "UTF-8");
            httpPost.setEntity(uefEntity);
            CloseableHttpResponse response = client.execute(httpPost);
            HttpEntity entity = response.getEntity();
            if (null != entity) {
                int statusCode = response.getStatusLine().getStatusCode();
                logger.info("请求Url[" + url + "]返回的状态码：" + statusCode);
                result = EntityUtils.toString(entity, "utf-8");
            }
        } catch (Exception e) {
            logger.error("Exception while execute httpPost:" + url, e);
        } finally {
            if (null != client) {
                try {
                    client.close();
                } catch (Exception e) {
                    logger.error("Exception while close client.", e);
                }
            }
        }
        return result;
    }

    /**
     * 参数为json格式
     *
     * @param body
     * @param url
     * @return
     * @throws IOException
     */
    public static String httpPostJson(String body, String url) throws IOException {
        HttpPost httpPost = new HttpPost(url);
        StringEntity entity = new StringEntity(body, Charset.forName("UTF-8"));
        entity.setContentEncoding("UTF-8");
        entity.setContentType("application/json");
        httpPost.setHeader(new BasicHeader("Content-Type", "application/json"));
//        httpPost.setHeader(new BasicHeader("Content-Type", "application/x-www-form-urlencoded; charset=utf-8"));
        httpPost.setHeader(new BasicHeader("Accept", "text/plain;charset=utf-8"));
        httpPost.setEntity(entity);
        CloseableHttpClient client = null;
        client = HttpClients.createDefault();

        HttpResponse response = client.execute(httpPost);
        HttpEntity httpEntity = response.getEntity();

        String content = EntityUtils.toString(httpEntity);
        ObjectMapper objectMapper = new ObjectMapper();
//        JavaType javaType = objectMapper.readValue(content, JavaType.class);
//        return javaType.toString();
//        return objectMapper.readValue(content, clazz);
        return content;
    }


    public static void main(String[] args) {

        try {
            String address = "吉林通化市通化市内东昌区老站街道通化师范学院";
            String typeNo = "01";

            String url = "http://www.baidu.com";

            String data = URLEncoder.encode(URLEncoder.encode(address, "utf-8"), "utf-8");

            String str = "http://133.195.235.33:12005/Map_web/androidInterface/AdressPointToGird!getPersonData.action?typeNo=" + typeNo + "&data=" + data;

            String content = HttpUtil.httpGet(str);

            System.out.println(content);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}
