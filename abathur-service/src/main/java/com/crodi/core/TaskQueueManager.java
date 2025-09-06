package com.crodi.core;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * @author Crodi
 * @date 2025/4/24 17:53
 * @description: 执行队列管理工具
 */

@Slf4j
@Component
public class TaskQueueManager implements ApplicationRunner {


    private final Map<String, BlockingQueue<AsyncExecutor>> workQueues = new HashMap<>();

    public void addTaskToQueue(TaskContext context, AsyncExecutor executor) {

        workQueues.computeIfAbsent(context.getNode(), k -> new LinkedBlockingDeque<>()).add(executor);

    }


    /**
     * spring 容器启动后，初始化业务队列
     *
     * @param businessIds 业务
     */
    private void initQueue(List<String> businessIds) {
        for (String businessId : businessIds) {
            workQueues.computeIfAbsent(businessId, k -> new LinkedBlockingDeque<>(16));
        }
    }


    @Override
    public void run(ApplicationArguments args) throws Exception {
        this.initQueue(args.getOptionValues("businessIds"));
    }
}
