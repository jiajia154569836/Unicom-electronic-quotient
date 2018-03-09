package com.jiajia.backend.config;

import com.bonc.security.web.AuthFilter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnProperty(name = "auth.enable", havingValue = "true")
public class AuthConfig {
	@Bean
	public FilterRegistrationBean authFilter() {
		FilterRegistrationBean registration = new FilterRegistrationBean();
		registration.setFilter(new AuthFilter());
		registration.addUrlPatterns("/*");
		registration.addInitParameter("skipUrls",
				".*/tenantinfo!selectTenant.action.*,.*/tenantinfo!getOrSaveTenantCookie.action.*,.*/getIntroPageConfig.*,.*/imageUploader.*,.*/out.jsp,.*/.*UserVisitIntro.*,.*/portalIntro*.action,.*/login!userLogin.action.*,.*/menuinfo.action.*,.*/menuinfo!to.*,.*/portalThemeSkin.*,.*/onlineUser.*,.*/announcement.*,.*/logout.action.*,.*tpl$,.*css$,.*js$,.*jpg$,.*jpeg$,.*bmp$,.*png$,.*gif$,.*ico$");		
		registration.setName("AuthFilter");
		return registration;
	}
}
