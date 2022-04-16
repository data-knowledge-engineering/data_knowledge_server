package com.seven.exhibition.service.impl;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.seven.exhibition.mapper.DealDataMapper;
import com.seven.exhibition.model.StationEqu;
import com.seven.exhibition.service.DealDataService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Service
public class DealDataServiceImpl implements DealDataService {

    @Resource
    private DealDataMapper dealDataMapper;
    @Override
    public  List<StationEqu> selectStationEqu(){
        //设置分页参数
        Page<StationEqu> page = new Page<>(1,10);
        dealDataMapper.selectStationEqu(page);
        //获取分页数据
        List<StationEqu> list = page.getRecords();

        System.out.println("旭"+dealDataMapper.selectStationEqu(page));
        return list;
    }

}
