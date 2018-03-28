package com.jiajia.main.controller;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * 解决跨域访问
 * Created by DENGJIAN on 2017-11-24.
 */

@Component
public class CrossFilter implements Filter {


    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletResponse rep = (HttpServletResponse) servletResponse;
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        String origin = req.getHeader("Origin");

        rep.setHeader("Access-Control-Allow-Origin", origin);
        rep.setHeader("Access-Control-Allow-Methods", "POST, GET,PUT,DELETE,OPTIONS");
        rep.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");
        rep.setHeader("Access-Control-Allow-Credentials", "true");
        //((HttpServletRequest) servletRequest).getSession().setAttribute(SessConstants.QRCODE_TYPE,QRcodeTypeEnum.G1.getCode());
        //((HttpServletRequest) servletRequest).getSession().setAttribute(SessConstants.CHOSE_NUMBER_CBSSID,"A0020980");

        StringBuffer requestUrl = req.getRequestURL();
        //用户登录不拦截
        if((requestUrl.toString().contains("/shop") || requestUrl.toString().contains("/lottery"))&&(!requestUrl.toString().contains("shopUserLogin"))&&(!requestUrl.toString().contains("saveOrUpdataUserInfo"))){
           // req.getSession().setAttribute(SessConstants.SHOP_USER_LOGIN_MOBILE, "18512345678");
           // req.getSession().setAttribute(SessConstants.QR_ID, "1ae9355c3bf9412e88c43d80091e37bc");
            Object mobile = req.getSession().getAttribute("SHOP_USER_LOGIN_MOBILE");

            if(StringUtils.isEmpty(mobile)){
               System.out.println("拒绝访问，信息"+mobile);
               rep.setStatus(403);
               return;
            }
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void destroy() {

    }
}

