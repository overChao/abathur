package com.crodi.service;

import com.crodi.entity.ScheduleResult;
import com.crodi.entity.TaskRoute;
import com.crodi.entity.TaskStatus;

import java.util.List;
import java.util.Map;

/**
 * @Author: crodi.zhang
 * @Date: 2025/9/2 9:13
 * @Description: 冲突预防服务
 **/
public interface ConflictPreventService {


    /**
     * 初始化任务起点
     */
    List<TaskStatus> initTaskStart(List<TaskRoute> taskRoutes);

    /**
     * 获取预占路径点
     *
     * @param taskRoutes 任务列表
     * @param taskPoints 任务状态
     */
    List<ScheduleResult> getPreRoutePoints(List<TaskRoute> taskRoutes, Map<String, String> taskPoints);


    List<List<String>> checkConflictRoute(List<ScheduleResult> scheduleResults);


}
