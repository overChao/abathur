package com.crodi.abathur.entity;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

/**
 * @author Crodi
 * @date 2025/4/25 10:37
 * @description: 感知上下文 组件
 * 1. 标识任务执行节点
 * 2. 推送任务到下一个运行节点
 */

@Component
@Data
public class AwarenessContext {

    // 执行节点
    private String node;

    // 上下文ID
    private String contextId;

    // 执行数据
    private List<Object> dataList;


    //
    public AwarenessContext(String node, List<Object> dataList) {
        this.node = node;
        this.contextId = UUID.randomUUID().toString();
        this.dataList = dataList;

        this.next();
    }


    private void next() {

        // node: null => setToQueue("TAS"， List<Object>)

        // node: Tas  => setToQueue("ACS"， List<Object>)

        // node: ACS  => setToQueue("DCS"， List<Object>)


    }


}

