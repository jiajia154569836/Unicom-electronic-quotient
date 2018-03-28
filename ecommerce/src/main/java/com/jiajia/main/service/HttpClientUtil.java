package com.jiajia.main.service;


import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;
//import net.sf.json.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultRedirectStrategy;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by DENGJIAN on 2017/11/16.
 */

public class HttpClientUtil {

    @Autowired
    private HttpClient httpClient;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());


    /**
     * 发送Http  Get 请求
     *
     * @param clazz
     * @param url
     * @param <T>
     * @return
     * @throws IOException
     */
    public <T> T httpGet(Class<T> clazz, String url) throws IOException {
        HttpGet httpGet = new HttpGet(url);
        HttpResponse response = httpClient.execute(httpGet);

        HttpEntity httpEntity = response.getEntity();
        String content = EntityUtils.toString(httpEntity);
        if ("".equals(content)) {
            return null;
        }
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(content, clazz);
    }


    /**
     * 发送 ttp  Post 请求
     *
     * @param clazz
     * @param body
     * @param url
     * @param <T>
     * @return
     * @throws IOException
     */
    public <T> T httpPost(Class<T> clazz, JSONObject body, String url) throws IOException {
        HttpPost httpPost = new HttpPost(url);
        StringEntity entity = new StringEntity(body.toString(), Charset.forName("UTF-8"));
        entity.setContentEncoding("UTF-8");
        entity.setContentType("application/json");
        httpPost.setEntity(entity);
        HttpResponse response = httpClient.execute(httpPost);
        HttpEntity httpEntity = response.getEntity();

        String content = EntityUtils.toString(httpEntity);
        if ("".equals(content)) {
            return null;
        }
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(content, clazz);
    }

    /**
     * 参数为json格式
     *
     * @param clazz
     * @param body
     * @param url
     * @param <T>
     * @return
     * @throws IOException
     */
    public <T> T httpPostJson(Class<T> clazz, String body, String url) throws Exception {
        HttpPost httpPost = new HttpPost(url);
        StringEntity entity = new StringEntity(body, Charset.forName("UTF-8"));
        entity.setContentEncoding("UTF-8");
        entity.setContentType("application/json");
        httpPost.setHeader(new BasicHeader("Content-Type", "application/json;charset=UTF-8"));
        // httpPost.setHeader(new BasicHeader("Accept", "text/plain;charset=utf-8"));
        httpPost.setEntity(entity);
        HttpResponse response = httpClient.execute(httpPost);
        HttpEntity httpEntity = response.getEntity();

        String content = EntityUtils.toString(httpEntity);
        if(StringUtils.isEmpty(content)){
            throw new Exception("接口返回数据为空, url: "+ url + "  body: " + body);
        }
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(content, clazz);
    }


    /**
     * form表单为参数
     *
     * @param url
     * @param params
     * @return
     */
    public Map<String, String> doPost(String url, Map<String, String> params) {
        Map<String, String> resultMap = new HashMap<>();
        HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();

        httpClientBuilder.setRedirectStrategy(new DefaultRedirectStrategy() {
            @Override
            protected boolean isRedirectable(String method) {
                return true;
            }
        });

        CloseableHttpClient closeableHttpClient = httpClientBuilder.build();
        HttpPost httpPost = new HttpPost(url);
        //设置超时时间
        RequestConfig requestConfig = RequestConfig.custom()
                .setConnectTimeout(60000).setConnectionRequestTimeout(60000).build();
        httpPost.setConfig(requestConfig);
        try {
            //请求体
            if (params != null && !params.isEmpty()) {
                List formParams = new ArrayList();
                for (String key : params.keySet()) {
                    formParams.add(new BasicNameValuePair(key, params.get(key)));
                }
                httpPost.setEntity(new UrlEncodedFormEntity(formParams, "UTF-8"));

            }
            //请求头
//            if (headers != null && !headers.isEmpty()) {
//                for (String key : headers.keySet()) {
//                    httpPost.addHeader(key, headers.get(key));
//                }
//            }

            CloseableHttpResponse httpResponse = closeableHttpClient.execute(httpPost);
            Map<String, String> headerParam = new HashMap();
            HttpEntity entity = httpResponse.getEntity();
            resultMap.put("code", httpResponse.getStatusLine().getStatusCode() + "");
            resultMap.put("content", EntityUtils.toString(entity));
            httpPost.releaseConnection();
            closeableHttpClient.close();
        } catch (Exception e) {
            logger.error("httpclientutil请求异常", e);
        }

        return resultMap;
    }


    /**
     * get
     * @param url
     * @return
     */
    public Map<String, String> doGet(String url) {
        Map<String, String> resultMap = new HashMap<>();
        HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();

        httpClientBuilder.setRedirectStrategy(new DefaultRedirectStrategy() {
            @Override
            protected boolean isRedirectable(String method) {
                return true;
            }
        });
        CloseableHttpClient closeableHttpClient = httpClientBuilder.build();
        HttpGet httpGet = new HttpGet(url);
        //设置超时时间
        RequestConfig requestConfig = RequestConfig.custom()
                .setConnectTimeout(60000).setConnectionRequestTimeout(60000).build();
        httpGet.setConfig(requestConfig);
        try {
            CloseableHttpResponse httpResponse = closeableHttpClient.execute(httpGet);
            HttpEntity entity = httpResponse.getEntity();
            resultMap.put("code", httpResponse.getStatusLine().getStatusCode() + "");
            resultMap.put("content", EntityUtils.toString(entity));
            httpGet.releaseConnection();
            closeableHttpClient.close();
        } catch (Exception e) {
            logger.error("httpclientutil请求异常", e);
        }
        return resultMap;
    }


    /**
     * 营销云工具类
     *
     * @param url
     * @param params
     * @return
     */
    public String doPost2(String url, Map<String, Object> params) {
        URL u = null;
        HttpURLConnection con = null;
        //构建请求参数
        StringBuffer sb = new StringBuffer();
        if (params != null) {
            for (Map.Entry<String, Object> e : params.entrySet()) {
                sb.append(e.getKey());
                sb.append("=");
                sb.append(e.getValue());
                sb.append("&");
            }
            sb.substring(0, sb.length() - 1);
        }
        //尝试发送请求
        try {
            u = new URL(url);
            con = (HttpURLConnection) u.openConnection();
            con.setRequestMethod("POST");
            con.setDoOutput(true);
            con.setDoInput(true);
            con.setUseCaches(false);
//            con.setConnectTimeout(CON_TIME_OUT);
//            con.setReadTimeout(READ_TIME_OUT);
            con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            OutputStreamWriter osw = new OutputStreamWriter(con.getOutputStream(), "UTF-8");
            String cont = sb.substring(0, sb.length() - 1).toString();
            osw.write(cont.toString());
            osw.flush();
            osw.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (con != null) {
                con.disconnect();
            }
        }
        //读取返回内容
        StringBuffer buffer = new StringBuffer();
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF-8"));
            String temp;
            while ((temp = br.readLine()) != null) {
                buffer.append(temp);
                buffer.append("\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return buffer.toString();
    }


    /**
     * 发送短信工具类
     * @param strUrl
     * @param requestMethod
     * @param contentype
     * @param content
     * @return
     * @throws IOException
     */
    public  String sendRequest(String strUrl,String requestMethod,String contentype,String content) throws IOException
    {
        StringBuffer buffer = new StringBuffer();
        URL url = new URL(strUrl);
        HttpURLConnection httpUrlConnection = (HttpURLConnection)url.openConnection();
        httpUrlConnection.setRequestMethod(requestMethod);
//    	if (content.length() > 0 )
        httpUrlConnection.setRequestProperty("Content-type","application/json");
        httpUrlConnection.setDoOutput(true);
        httpUrlConnection.setDoInput(true);
        httpUrlConnection.setUseCaches(false);
        httpUrlConnection.connect();

        if(content.length()>0){
            OutputStreamWriter out = new OutputStreamWriter(httpUrlConnection.getOutputStream(), "UTF-8");
            out.write(content);
            out.flush();
            out.close();
        }

        BufferedReader in = new BufferedReader(new InputStreamReader(httpUrlConnection.getInputStream(),"UTF-8"));
        String inputLine;
        while ((inputLine = in.readLine()) != null) {
            buffer.append(inputLine.trim());
        }
        in.close();
        httpUrlConnection.disconnect();
        return buffer.toString();
    }
}

