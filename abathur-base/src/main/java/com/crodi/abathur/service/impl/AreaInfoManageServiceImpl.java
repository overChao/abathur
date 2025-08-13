package com.crodi.abathur.service.impl;

import com.crodi.abathur.entity.AreaInfo;
import com.crodi.abathur.mapper.AreaInfoMapper;
import com.crodi.abathur.service.AreaInfoService;
import lombok.RequiredArgsConstructor;

import java.util.List;

/**
 * @author Crodi
 * @date 2025/5/28 14:59
 * @description: TODO
 */

@RequiredArgsConstructor
public class AreaInfoManageServiceImpl implements AreaInfoService {

    private final AreaInfoMapper areaInfoMapper;

    @Override
    public void addBatch(List<AreaInfo> dataList) {
        final int result = areaInfoMapper.insertBatch(dataList);
    }

    @Override
    public void update(AreaInfo areaInfo) {
        final int i = areaInfoMapper.update(areaInfo, null);
    }

    @Override
    public void delete(List<AreaInfo> dataList) {
        areaInfoMapper.deleteBatchIds(dataList);
    }

    @Override
    public List<AreaInfo> getAreaInfoList() {
        return areaInfoMapper.selectList(null);
    }
}
