package com.cordi.abathur.service;

import com.cordi.abathur.entity.DeviceType;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Crodi
 * @date 2025/5/28 17:22
 * @description: 设备类型管理
 */

@Service
public interface DeviceTypeService {

    void addBatch(List<DeviceType> dataList);

    void update(DeviceType dataList);

    void deleteBatch(List<DeviceType> dataList);

    List<DeviceType> getDeviceTypeList();
}
