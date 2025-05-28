package com.crodi.abathur.service.impl;

import com.alibaba.fastjson2.JSON;
import com.crodi.abathur.core.TaskQueueManager;
import com.crodi.abathur.service.RoutePlanningService;
import com.crodi.abathur.service.TaskManagerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author Crodi
 * @date 2025/4/9 16:24
 * @description: TODO
 */


@RequiredArgsConstructor
@Service
@Slf4j
public class TaskManagerServiceImpl implements TaskManagerService {


    private final RoutePlanningService routePlanningService;

    private final TaskQueueManager executorQueueManager;


    @Override
    public void addTask(Object data) {

        //TODO 2025/5/12: 填充保存逻辑
        log.info("save task success:{}", JSON.toJSONString(data));

        // 驱动 任务
        // 初始化上下文  设置当前上下文的节点
        //

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
