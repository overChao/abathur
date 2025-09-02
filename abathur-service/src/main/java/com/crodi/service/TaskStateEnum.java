package com.eforkrobot.modules.wcs.common.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;

/**
 * @Author: crodi.zhang
 * @Date: 2025/8/11 16:50
 * @Description: 任务状态枚举
 **/


@Getter
@RequiredArgsConstructor
public enum TaskStateEnum {

    INIT("0", "INIT", "初始化"),

    PLAN_SUC("1", "PLANNING", "任务规划成功"),

    SCHEDULE_SUC("2", "SCHEDULE_SUCCESS", "调度成功"),

     RUNNING("3", "RUNNING", "执行中"),

    COMPLETED("4", "COMPLETED", "自动完成"),

    MANUAL_COMP("5", "MANUAL_COMPLETED", "手动完成"),

    CANCEL("6", "CANCEL", "任务取消"),

    PAUSE("7", "PAUSE", "任务暂停"),

    FAILED("9", "FAILED", "任务失败");

    private final String code;

    private final String name;

    private final String desc;


    public static String getByCode(String code) {
        return Arrays.stream(values())
                .filter(value -> value.code.equals(code))
                .findFirst().map(TaskStateEnum::getName)
                .orElse(null);
    }

    public static String getCodeByName(String name) {
        return Arrays.stream(values())
                .filter(value -> value.name.equals(name))
                .findFirst().map(TaskStateEnum::getCode)
                .orElse(null);
    }

}
