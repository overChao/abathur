package com.crodi.service.impl;

import com.crodi.entity.ScheduleResult;
import com.crodi.entity.TaskRoute;
import com.crodi.entity.TaskStatus;
import com.crodi.enums.TaskStateEnum;
import com.crodi.service.ConflictPreventService;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @Author: crodi.zhang
 * @Date: 2025/9/2 9:33
 * @Description: 冲突预防服务实现
 **/
@Slf4j
@Service
public class ConflictPreventServiceImpl implements ConflictPreventService {


    @Override
    public List<TaskStatus> initTaskStart(List<TaskRoute> taskRoutes) {
        return taskRoutes.stream()
                .map(this::initTaskStatus)
                .toList();
    }

    @Override
    public List<ScheduleResult> getPreRoutePoints(List<TaskRoute> taskRoutes, Map<String, String> taskPoints) {

        List<ScheduleResult> scheduleResults = Lists.newArrayList();
        for (TaskRoute taskRoute : taskRoutes) {
            List<String> routePoints = taskRoute.getRoutePoints();
            for (int i = 0; i < routePoints.size() - 1; i++) {
                if (Objects.equals(routePoints.get(i), taskPoints.get(taskRoute.getTaskNo()))) {
                    String source = routePoints.get(i);
                    String target = source;
                    if (i < routePoints.size() - 1) {
                        target = routePoints.get(i + 1);
                    }
                    scheduleResults.add(initScheduleResult(taskRoute.getTaskNo(), source, target));
                    break;
                }
            }
        }
        return scheduleResults;
    }

    @Override
    public List<List<String>> checkConflictRoute(List<ScheduleResult> scheduleResults) {

        List<List<String>> conflictTasks = Lists.newArrayList();
        for (int i = 0; i < scheduleResults.size(); i++) {
            ScheduleResult result = scheduleResults.get(i);
            List<String> conflictTask = Lists.newArrayList();
            for (int j = i + 1; j < scheduleResults.size(); j++) {
                ScheduleResult scheduleResult = scheduleResults.get(j);
                // 边竞争
                if (Objects.equals(result.getSourcePoint(), scheduleResult.getTargetPoint())
                        && Objects.equals(result.getTargetPoint(), scheduleResult.getSourcePoint())) {
                    conflictTask.add(result.getTaskNo());
                    conflictTask.add(scheduleResult.getTaskNo());
                    continue;
                }
                // 点竞争
                if (Objects.equals(result.getTargetPoint(), scheduleResult.getTargetPoint())) {
                    conflictTask.add(result.getTaskNo());
                    conflictTask.add(scheduleResult.getTaskNo());
                }
            }
            conflictTasks.add(conflictTask);
        }
        return conflictTasks;
    }


    public void conflictPrevent(List<TaskRoute> taskRoutes, List<TaskStatus> taskStatuses) {

        Map<String, String> taskCurrentPoints = taskStatuses.stream()
                .collect(Collectors.toMap(TaskStatus::getTaskNo,
                        TaskStatus::getCurrentPoint,
                        (a, b) -> b));

        List<ScheduleResult> scheduleResults = getPreRoutePoints(taskRoutes, taskCurrentPoints);

        List<List<String>> conflictTasks = checkConflictRoute(scheduleResults);
        log.info("冲突任务组：{}", conflictTasks);


    }


    private TaskStatus initTaskStatus(TaskRoute taskRoute) {
        return TaskStatus.builder()
                .taskNo(taskRoute.getTaskNo())
                .status(TaskStateEnum.INIT.getCode())
                .currentPoint(taskRoute.getRoutePoints().get(0))
                .build();
    }

    private ScheduleResult initScheduleResult(String taskNo, String source, String target) {
        return ScheduleResult.builder()
                .taskNo(taskNo)
                .sourcePoint(source)
                .targetPoint(target)
                .build();
    }

}
