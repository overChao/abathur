package com.cordi.abathur.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * @author Crodi
 * @date 2025/5/28 13:57
 * @description: 设备类型
 */

@Data
public class DeviceType {

    /**
     * 类型id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 类型名称
     */
    private String typeName;

    /**
     * 类型描述
     */
    private String typeDescription;

    /**
     * 父类型id
     */
    private Long parentId;

}
