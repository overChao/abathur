package com.crodi.abathur.config;

import com.crodi.abathur.core.EventLoopScheduler;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Crodi
 * @date 2025/4/14 16:10
 * @description: TODO
 */

@Configuration
@EnableConfigurationProperties
public class EventLoopConfig {


    @Bean
    public EventLoopScheduler eventLoopScheduler(EventLoopProperties eventLoopProperties) {
        return new EventLoopScheduler(eventLoopProperties);
    }


}
