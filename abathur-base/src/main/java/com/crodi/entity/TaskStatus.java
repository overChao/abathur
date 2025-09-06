package com.crodi.entity;

import lombok.Builder;
import lombok.Data;

/**
 * @Author: crodi.zhang
 * @Date: 2025/9/2 9:20
 * @Description: 任务状态
 **/

@Data
@Builder
public class TaskStatus {

    /**
     * 任务号
     */
    private String taskNo;

    /**
     * 任务状态
     */
    private String status;

    /**
     * 任务所在点位
     */
    private String currentPoint;

}
