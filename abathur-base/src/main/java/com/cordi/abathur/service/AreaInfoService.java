package com.cordi.abathur.service;

import com.cordi.abathur.entity.AreaInfo;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Crodi
 * @date 2025/5/28 14:16
 * @description: 基础信息管理
 */

@Service
public interface AreaInfoService {

    void addBatch(List<AreaInfo> dataList);

    void update(AreaInfo dataList);

    void delete(List<AreaInfo> dataList);

    List<AreaInfo> getAreaInfoList();

}
