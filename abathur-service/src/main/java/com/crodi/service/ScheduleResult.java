package com.eforkrobot.modules.wcs.common.dto;

import lombok.Builder;
import lombok.Data;

/**
 * @Author: crodi.zhang
 * @Date: 2025/9/2 9:29
 * @Description: 任务调度结果
 **/

@Data
@Builder
public class ScheduleResult {

    /**
     * 任务号
     */
    private String taskNo;


    private String sourcePoint;

    /**
     * 目标点
     */
    private String targetPoint;


    /**
     * 是否完成
     */
    private boolean isCompleted;


}
