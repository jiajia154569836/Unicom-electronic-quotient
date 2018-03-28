/**
 * Copyright (c) 2018 www.bonc.com.cn. All Rights Reserved.
 */
package com.jiajia.flow.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;

/**
 * 任务配置， 开启异步方法调用 和 启动 Kafka的 支持
 *
 * @author yangwang1@bonc.com.cn
 * @version V1.0.0
 */
@Configuration
@EnableKafka
public class MQConfig {
}
