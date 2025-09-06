package com.crodi.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * @author Crodi
 * @date 2025/5/28 14:03
 * @description: 区域信息
 */

@Data
public class AreaInfo {

    /**
     * 区域ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 区域名称
     */
    private String areaName;

    /**
     * 区域描述
     */
    private String areaDescription;

}
