package com.crodi.abathur.core;

import com.crodi.abathur.entity.AwarenessContext;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * @author Crodi
 * @date 2025/4/24 17:53
 * @description: TODO
 */

@Component
public class ExecutorQueueManager {


    private final Map<String, BlockingQueue<Executor>> workQueues = new HashMap<>();

    public void addTaskToQueue(AwarenessContext context, Executor executor) {

        workQueues.computeIfAbsent(context.getNode(), k -> new LinkedBlockingDeque<>()).add(executor);

    }

}
