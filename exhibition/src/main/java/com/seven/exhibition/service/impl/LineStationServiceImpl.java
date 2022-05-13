package com.seven.exhibition.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.seven.exhibition.mapper.LineStationMapper;
import com.seven.exhibition.model.LineStation;
import com.seven.exhibition.model.StationEqu;
import com.seven.exhibition.service.LineStationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LineStationServiceImpl implements LineStationService {

    @Resource
    private LineStationMapper lineStationMapper;

    @Override
    public List<String> selectLine(String lineName) {

       return lineStationMapper.selectLineStation(lineName);
    }
}
