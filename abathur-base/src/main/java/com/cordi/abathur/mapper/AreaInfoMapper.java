package com.cordi.abathur.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cordi.abathur.entity.AreaInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author Crodi
 * @date 2025/5/28 14:05
 * @description: 区域信息mapper
 */

@Mapper
public interface AreaInfoMapper extends BaseMapper<AreaInfo> {

    @Insert("<script>" +
            "insert into area_info (area_name,area_description) values " +
            "<foreach collection='areaInfoList' item='item' index='index' separator=','>" +
            " (#{item.areaName},#{item.areaDescription})" +
            "</script>")
    int insertBatch(List<AreaInfo> areaInfoList);

}
