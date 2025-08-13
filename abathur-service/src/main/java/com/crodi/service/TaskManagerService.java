package com.crodi.service;

/**
 * @author Crodi
 * @date 2025/4/24 17:00
 * @description: TODO
 */
public interface TaskManagerService {

    void addTask(Object data);

    void removeTask();

    void getTasks();

    void pauseTask();

}
