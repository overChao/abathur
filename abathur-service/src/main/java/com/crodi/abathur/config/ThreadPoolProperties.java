package com.crodi.abathur.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author Crodi
 * @date 2025/4/14 16:07
 * @description: TODO
 */


@Data
@Configuration
@ConfigurationProperties(prefix = "thread-pool.config")
public class ThreadPoolProperties {

    // 工作线程池 核心线程数
    private int corePoolSize = 10;

    // 工作线程池 最大线程数
    private int maxPoolSize = 20;

    // 工作线程池 线程存活时间
    private int keepAliveSeconds = 60;

    // 工作线程池 队列容量
    private int queueCapacity = 10000;

}
