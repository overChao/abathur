package com.crodi.entity;

import lombok.Data;

import java.util.List;

/**
 * @Author: crodi.zhang
 * @Date: 2025/8/28 10:34
 * @Description: 任务路径
 **/

@Data
public class TaskRoute {

    /**
     * 任务号
     */
    private String taskNo;

    /**
     * 路径号
     */
    private String routeNo;

    /**
     * 路径点
     */
    private List<String> routePoints;

    /**
     * 任务路径
     */
    private List<TaskRoute> areaTaskRoutes;

}
