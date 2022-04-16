package com.seven.exhibition.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.seven.exhibition.mapper.StationEquMapper;
import com.seven.exhibition.model.StationEqu;
import com.seven.exhibition.service.StationEquService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class StationEquServiceImpl implements StationEquService {

    @Resource
    private StationEquMapper stationEquMapper;


    @Override
    public List<StationEqu> selectStationEqu() {
        Page<StationEqu> page = new Page<>(1,100);
        stationEquMapper.selectPage(page,null);
        return page.getRecords();
    }

    @Override
    public List<StationEqu> selectByStation(String sname) {

        QueryWrapper<StationEqu> queryWrapper = new QueryWrapper<>();
        QueryWrapper<StationEqu> station = queryWrapper.select("distinct equ_type,equ_no,station_name")
                .eq("station_name", sname)
                .orderByAsc("equ_type");

        return stationEquMapper.selectList(station);

    }

    @Override
    public Integer selectLnum(String sname) {
        QueryWrapper<StationEqu> queryWrapper = new QueryWrapper<>();
        QueryWrapper<StationEqu> station = queryWrapper.select("distinct equ_type,equ_no,station_name")
                .eq("station_name", sname)
                .eq("equ_type","出站设备");

        return stationEquMapper.selectList(station).size();
    }

    @Override
    public Integer selectCnum(String sname) {
        QueryWrapper<StationEqu> queryWrapper = new QueryWrapper<>();
        QueryWrapper<StationEqu> station = queryWrapper.select("distinct equ_type,equ_no,station_name")
                .eq("station_name", sname)
                .eq("equ_type","入站设备");

        return stationEquMapper.selectList(station).size();
    }
}
