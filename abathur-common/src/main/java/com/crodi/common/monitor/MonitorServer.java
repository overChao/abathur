package com.crodi.common.monitor;

import io.micrometer.core.instrument.Gauge;
import io.micrometer.core.instrument.binder.MeterBinder;
import org.springframework.context.annotation.Bean;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author Crodi
 * @date 2025/4/14 17:50
 * @description: TODO
 */

public class MonitorServer {
    
    
    @Bean
    public MeterBinder threadPoolMetrics(ExecutorService workerPool) {
        return registry -> {
            ThreadPoolExecutor executor = (ThreadPoolExecutor) workerPool;
            Gauge.builder("thread.pool.active", executor::getActiveCount)
                    .register(registry);
            Gauge.builder("thread.pool.queue.size",
                            () -> executor.getQueue().size())
                    .register(registry);
        };
    }


}
