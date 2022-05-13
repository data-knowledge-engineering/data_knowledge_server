package com.seven.exhibition.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.seven.exhibition.model.LineStation;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface LineStationMapper {
    List<String> selectLineStation(String lineName);
}
