package com.crodi.abathur.service.impl;

import com.crodi.abathur.entity.DeviceType;
import com.crodi.abathur.mapper.DeviceTypeMapper;
import com.crodi.abathur.service.DeviceTypeService;
import lombok.RequiredArgsConstructor;

import java.util.List;

/**
 * @author Crodi
 * @date 2025/5/28 17:23
 * @description: TODO
 */

@RequiredArgsConstructor
public class DeviceTypeServiceImpl implements DeviceTypeService {

    private final DeviceTypeMapper deviceTypeMapper;


    @Override
    public void addBatch(List<DeviceType> dataList) {
        deviceTypeMapper.insertBatch(dataList);
    }

    @Override
    public void update(DeviceType deviceType) {
        deviceTypeMapper.update(deviceType, null);
    }

    @Override
    public void deleteBatch(List<DeviceType> dataList) {
        final int i = deviceTypeMapper.deleteBatchIds(dataList);
    }

    @Override
    public List<DeviceType> getDeviceTypeList() {
        return deviceTypeMapper.selectList(null);
    }
}
