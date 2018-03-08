//package com.jiajia.config;
//
//import com.bonc.security.common.ConfigurationContants;
//import com.bonc.security.web.AuthFilter;
//import org.jasig.cas.client.session.SingleSignOutHttpSessionListener;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.boot.autoconfigure.web.DispatcherServletAutoConfiguration;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.boot.web.servlet.FilterRegistrationBean;
//import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
//import org.springframework.boot.web.servlet.ServletRegistrationBean;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.DispatcherServlet;
//
//@Configuration
//@ConfigurationProperties(prefix = "cas")
//public class CasConfig {
//
//	@Value("${cas.casAddress}")
//	private String casAddress;
//
//	@Value("${cas.frontAddress}")
//	private String frontAddress;
//
//	@Value("${cas.backAddress}")
//	private String backAddress;
//
//	@Bean
//	public FilterRegistrationBean ssoFilter() {
//		FilterRegistrationBean registration = new FilterRegistrationBean();
//		registration.setFilter(new CasFilter());
//		registration.addUrlPatterns("/*");
//		registration.addInitParameter("serverName", this.backAddress);
//		registration.addInitParameter("callbackServerName", this.frontAddress);
//		registration.addInitParameter("casServerUrlPrefix", "http://" + this.casAddress+"/cas");
//		registration.addInitParameter("casServerLoginUrl", "http://" + this.casAddress+"/cas/login");
//		registration.addInitParameter("singleSignOut", "true");
//		registration.addInitParameter("skipUrls","/" + ConfigurationContants.APP_CODE + "/.*");
//		registration.addInitParameter("loginUserHandle", "com.bonc.security.sso.SSOAuthHandle");
//		registration.addInitParameter("characterEncoding", "UTF-8");
//		registration.addInitParameter("encoding", "UTF-8");
//		registration.setName("SSO Filter");
//		return registration;
//	}
//
////	@Bean
//	public FilterRegistrationBean authFilter() {
//		FilterRegistrationBean registration = new FilterRegistrationBean();
//		registration.setFilter(new AuthFilter());
//		registration.addUrlPatterns("/" + ConfigurationContants.APP_CODE + "/*");
//		registration.addInitParameter("skipUrls","");
//		registration.setName("AuthFilter");
//		return registration;
//	}
//
//	@Bean
//	public ServletListenerRegistrationBean<SingleSignOutHttpSessionListener> servletListener() {
//		ServletListenerRegistrationBean<SingleSignOutHttpSessionListener> sessionListener = new ServletListenerRegistrationBean<SingleSignOutHttpSessionListener>();
//		sessionListener.setListener(new SingleSignOutHttpSessionListener());
//		return sessionListener;
//	}
//
//	@Bean
//	public ServletRegistrationBean dispatcherServletRegistration() {
//		ServletRegistrationBean registration = new ServletRegistrationBean(
//				dispatcherServlet(), "/" + ConfigurationContants.APP_CODE + "/*");
//		registration.setName(DispatcherServletAutoConfiguration.DEFAULT_DISPATCHER_SERVLET_REGISTRATION_BEAN_NAME);
//		return registration;
//	}
//
//	@Bean
//	public DispatcherServlet dispatcherServlet() {
//		return new DispatcherServlet();
//	}
//}
