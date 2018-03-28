/**
 * Copyright (c) 2018 www.bonc.com.cn. All Rights Reserved.
 */
package com.jiajia.flow.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

import java.util.concurrent.Executor;

/**
 * 线程池设置 用于执行异步任务
 *
 * @author yangwang1@bonc.com.cn
 * @version V1.0.0
 */
@Configuration
@EnableAsync
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class ThreadPoolConfig implements AsyncConfigurer, SchedulingConfigurer {

    private static final Logger log = LoggerFactory.getLogger(ThreadPoolConfig.class);

    // ------------------关于线程执行器，异步方法，时间定时器的配置------------------------

    /**
     * Spring的ThreadPoolTaskScheduler既实现了TaskExecutor接口（对@Async注解的方法异步执行），又实现了TaskScheduler接口（对@Scheduled注解方法按计划执行）
     * 为了让线程资源有效地被管理使用，这里配置的ThreadPoolTaskScheduler不仅为应用程序使用，同时也将其配置到AsyncConfigurer, SchedulingConfigurer接口中。
     * 这样执行器和调度器都使用相同的线程池。
     */

    @Bean
    public ThreadPoolTaskScheduler taskScheduler() {
        ThreadPoolTaskScheduler scheduler = new ThreadPoolTaskScheduler();
        scheduler.setPoolSize(5); // 核心线程 5 个 ， 最大线程 Integer.MAX , Keepalive 时间为 0 ； 队列使用 DelayedQueue
        scheduler.setThreadNamePrefix("oc-flow-task"); // Thread Factory 设置
        scheduler.setAwaitTerminationSeconds(60);
        scheduler.setWaitForTasksToCompleteOnShutdown(true);
        scheduler.setErrorHandler(t -> log.error("Unknown error occurred while executing task.", t)); // 线程错误处理， Thread Factory 设置
        scheduler.setRejectedExecutionHandler((r, executor) -> log.error("Execution of task {} was rejected for unknown reasons.", r)); // 线程池的拒绝策略
        return scheduler;
    }


    /**
     * 配置任务执行器，所以需要实现SchedulingConfigurer接口
     */
    @Override
    public void configureTasks(ScheduledTaskRegistrar registrar) {
        TaskScheduler scheduler = this.taskScheduler();
        log.info("Configuring scheduled method executor {}.", scheduler);
        registrar.setTaskScheduler(scheduler);
    }

    /**
     * 配置异步执行器，所以需要实现AsyncConfigurer
     * 应用程序中通常使用的是JDK提供的线程，如：
     * ExecutorService = Executors.newCachedThreadPool();
     * 不过这会启动额外的资源，为了让整个应用程序启动的线程在可控范围内，可以统一使用注册在Spring中的taskScheduler
     */
    @Override
    public Executor getAsyncExecutor() {
        Executor executor = this.taskScheduler();
        log.info("Configuring asynchronous method executor {}.", executor);
        return executor;
    }

    /**
     * 配置异步执行器的异常处理
     */
    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
        return (ex, method, params) -> log.error("调用异步任务出错了, message : " + method, ex);
    }
    // ------------------------------END-------------------------------------

}
