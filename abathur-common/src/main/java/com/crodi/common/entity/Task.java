package com.crodi.common.entity;

import lombok.Data;

/**
 * @author Crodi
 * @date 2025/5/19 16:01
 * @description: 任务信息
 */

@Data
public class Task {

    /**
     * 任务编号
     */
    private String taskNo;

    /**
     * 任务起点
     */
    private String taskStart;

    /**
     * 任务终点
     */
    private String taskEnd;

    /**
     * 优先级
     */
    private Integer priority;

    /**
     * 任务属性
     */
    private Object property;

}
