package com.cordi.abathur.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cordi.abathur.entity.DeviceType;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author Crodi
 * @date 2025/5/28 14:13
 * @description: 设备类型mapper
 */

@Mapper
public interface DeviceTypeMapper extends BaseMapper<DeviceType> {

    @Insert("<script>" +
            "insert into device_type(type_name, type_description, parent_id) values " +
            "<foreach collection='' item='item' index='index' separator=','>" +
            " (#{item.typeName}, #{item.typeDescription}, #{item.parentId})" +
            "</script>")
    int insertBatch(List<DeviceType> deviceTypeList);

}
