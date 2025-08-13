package com.crodi.core;

import com.crodi.common.constant.enums.NodeEnum;
import com.crodi.common.entity.Task;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.UUID;

/**
 * @author Crodi
 * @date 2025/4/25 10:37
 * @description: 任务上下文 组件
 */


@Data
@Slf4j
public class TaskContext {

    // 执行节点
    private String node;

    // 上下文ID
    private String contextId;

    // 执行数据
    private List<Task> dataList;


    /**
     * 更新 context
     *
     * @param dataList 任务列表
     */
    public void updateContext(List<Task> dataList) {

        //1. 重建 context
        this.node = NodeEnum.getNextNode(this.node);
        this.dataList = dataList;

        //2. 删除旧的context
        this.delete();

        //3. 保存新的context
        this.save();

    }


    /**
     * 初始化 任务 context
     *
     * @param node     当前节点
     * @param dataList 执行任务列表
     * @return context 实例
     */
    public TaskContext initContext(String node, List<Task> dataList) {
        final TaskContext context = new TaskContext();
        context.setContextId(UUID.randomUUID().toString());
        context.setNode(node);
        context.setDataList(dataList);
        return context;
    }


    /**
     * 删除 context
     */
    private void delete() {
        //TODO 2025/5/14: 补充删除逻辑
        log.info("context delete success, id = {}", this.contextId);
    }


    /**
     * 保存 context
     */
    private void save() {
        //TODO 2025/5/16: 补充保存逻辑
        log.info("context save success, id = {}", this.contextId);
    }


}

