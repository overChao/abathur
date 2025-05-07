package com.crodi.abathur.service.impl;

import com.crodi.abathur.core.Executor;
import com.crodi.abathur.core.ExecutorQueueManager;
import com.crodi.abathur.entity.AwarenessContext;
import com.crodi.abathur.service.RoutePlanningService;
import com.crodi.abathur.service.TaskManagerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author Crodi
 * @date 2025/4/9 16:24
 * @description: TODO
 */


@RequiredArgsConstructor
@Service
public class TaskManagerServiceImpl implements TaskManagerService, Executor {


    private final RoutePlanningService routePlanningService;

    private final ExecutorQueueManager executorQueueManager;


    private final AwarenessContext context;



    @Override
    public void execute(AwarenessContext context) {
        routePlanningService.execute();
    }

    @Override
    public void addTask() {

        // 任务持久化



        // 启动调度
        context.setNode("Tas");
        context.setDataList(null);
        executorQueueManager.addTaskToQueue(context, this);


    }

    @Override
    public void removeTask() {

        //  查询 & 清理任务池， 防止后续再调度
    }

    @Override
    public void getTasks() {

    }

    @Override
    public void pauseTask() {
        // 暂停任务
        // 关闭调度对任务的调度


    }
}
