package com.jiajia.config;

import com.bonc.sso.client.IAuthHandle;
import org.jasig.cas.client.authentication.AuthenticationFilter;
import org.jasig.cas.client.session.SingleSignOutFilter;
import org.jasig.cas.client.util.CommonUtils;
import org.jasig.cas.client.util.HttpServletRequestWrapperFilter;
import org.jasig.cas.client.validation.Cas20ProxyReceivingTicketValidationFilter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

public class CasFilter implements Filter {
    private List<Filter> filterList = new ArrayList();
    private IAuthHandle authHandle = null;
    private String[] skipUrls = null;
    private static String casServerUrlPrefix = null;
    private static String casServerLoginUrl = null;
    private String callbackServerName = "";
    public CasFilter() {
    }

    public void init(FilterConfig filterConfig) throws ServletException {
        String skipUrl = filterConfig.getInitParameter("skipUrls");
        if(null != skipUrl && skipUrl.trim().length() > 0) {
            this.skipUrls = skipUrl.split(",");
        }

        boolean singleSignOut = "true".equals(this.getPropertyFromInitParams(filterConfig, "singleSignOut", "false"));
        casServerUrlPrefix = this.getPropertyFromInitParams(filterConfig, "casServerUrlPrefix", (String)null);
        casServerLoginUrl = this.getPropertyFromInitParams(filterConfig, "casServerLoginUrl", (String)null);
        callbackServerName = getPropertyFromInitParams(filterConfig, "callbackServerName", "");
        if(singleSignOut) {
            this.filterList.add(new SingleSignOutFilter());
        }

        this.filterList.add(new AuthenticationFilter());
        this.filterList.add(new Cas20ProxyReceivingTicketValidationFilter());
        this.filterList.add(new HttpServletRequestWrapperFilter());
        Iterator clazzName = this.filterList.iterator();

        while(clazzName.hasNext()) {
            Filter e = (Filter)clazzName.next();
            e.init(filterConfig);
        }

        String clazzName1 = this.getPropertyFromInitParams(filterConfig, "loginUserHandle", (String)null);
        if(null != clazzName1 && clazzName1.trim().length() > 0) {
            try {
                this.authHandle = (IAuthHandle)Class.forName(clazzName1.trim()).newInstance();
            } catch (InstantiationException var6) {
                var6.printStackTrace();
            } catch (IllegalAccessException var7) {
                var7.printStackTrace();
            } catch (ClassNotFoundException var8) {
                var8.printStackTrace();
            }
        }

    }

    private String getPropertyFromInitParams(FilterConfig filterConfig, String key, String defaultValue) {
        String value = filterConfig.getInitParameter(key);
        return null != value && !value.trim().equals("")?value:defaultValue;
    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
    	
        HttpServletResponse response = (HttpServletResponse)servletResponse;
        HttpServletRequest request = (HttpServletRequest)servletRequest;
        request.getSession();
        response.setHeader("P3P", "CP=\'IDC DSP COR ADM DEVi TAIi PSA PSD IVAi IVDi CONi HIS OUR IND CNT\'");
        if(this.preFilter(request, response)) {
            chain.doFilter(request, response);
        } else {
            CasFilterChain simpleFilterChain = new CasFilterChain();

            for(Iterator i$ = this.filterList.iterator(); i$.hasNext(); response = (HttpServletResponse)simpleFilterChain.getResponse()) {
                Filter filter = (Filter)i$.next();
                simpleFilterChain.reset();

                try {
                    filter.doFilter(request, response, simpleFilterChain);
                } catch (Exception var10) {
                    var10.printStackTrace();
                }

                if(!simpleFilterChain.isContinue()) {
                    return;
                }
                request = (HttpServletRequest)simpleFilterChain.getRequest();
            }
            if(simpleFilterChain.isContinue()) {
                if(this.onSuccess(request, response)) {
            		String callbackUrl = CommonUtils.constructServiceUrl(request, response, null, this.callbackServerName, "ticket", true);
            		response.sendRedirect(callbackUrl);
                } else {
                    String msg = request.getAttribute("msg")+"";
                    if("".equals(msg)){
                        msg ="登录用户发生异常";//您没有权限登录本系统!
                    }
                    response.setCharacterEncoding("UTF-8");
                    response.setContentType("text/html");
                    response.getWriter().print("<html><head></head><body>"+msg+"</body></html>");
                }
            }
        }

    }

    protected boolean preFilter(ServletRequest servletRequest, ServletResponse servletResponse) {
        boolean skip = false;
        HttpServletRequest request = (HttpServletRequest)servletRequest;
        String requestURI = request.getRequestURI();
        String contextPath = request.getContextPath();
        if(!"/".equals(contextPath)) {
            requestURI = requestURI.substring(contextPath.length());
        }

        if(null != this.skipUrls) {
            String[] arr$ = this.skipUrls;
            int len$ = arr$.length;

            for(int i$ = 0; i$ < len$; ++i$) {
                String s = arr$[i$];
                skip = Pattern.matches(s, requestURI);
                if(skip) {
                    break;
                }
            }
        }

        return skip;
    }

    protected boolean onSuccess(HttpServletRequest request, HttpServletResponse response) {
        this.authHandle.onSuccess(request, response, request.getRemoteUser());        
        return true;
    }

    public void destroy() {
        this.filterList.clear();
        this.filterList = null;
        this.authHandle = null;
    }

    public static String getSSOLoginUrl(HttpServletRequest request, String serviceUrl) {
        if(null == casServerLoginUrl) {
            throw new RuntimeException("SSOFilter not init!");
        } else {
            return __getServerUrl(request, casServerLoginUrl, serviceUrl);
        }
    }

    public static String getSSOLogoutUrl(HttpServletRequest request, String serviceUrl) {
        if(null == casServerUrlPrefix) {
            throw new RuntimeException("SSOFilter not init!");
        } else {
            return __getServerUrl(request, casServerUrlPrefix + "/logout", serviceUrl);
        }
    }

    private static String __getServerUrl(HttpServletRequest request, String casUrl, String serviceUrl) {
        if(null != serviceUrl && !"".equals(serviceUrl)) {
            if(!serviceUrl.startsWith("http")) {
                if(!serviceUrl.startsWith("/")) {
                    serviceUrl = "/" + serviceUrl;
                }

                serviceUrl = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + serviceUrl;
            }

            return casUrl.indexOf(63) != -1?casUrl + "&service=" + encodeURL(serviceUrl):casUrl + "?service=" + encodeURL(serviceUrl);
        } else {
            return casUrl;
        }
    }

    private static String encodeURL(String value) {
        try {
            return URLEncoder.encode(value, "UTF-8");
        } catch (UnsupportedEncodingException var4) {
            try {
                return URLEncoder.encode(value, "GBK");
            } catch (UnsupportedEncodingException var3) {
                throw new RuntimeException(var4);
            }
        }
    }
}
