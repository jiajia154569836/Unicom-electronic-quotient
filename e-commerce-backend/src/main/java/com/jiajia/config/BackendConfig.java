/**
 * Copyright (c) 2017 www.bonc.com.cn. All Rights Reserved.
 */
package com.jiajia.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * 描述当前功能
 *
 * @author yangwang1@bonc.com.cn
 * @version V1.0.0
 */
@Configuration
@EnableAspectJAutoProxy(proxyTargetClass = true, exposeProxy = true)
public class BackendConfig {
}
