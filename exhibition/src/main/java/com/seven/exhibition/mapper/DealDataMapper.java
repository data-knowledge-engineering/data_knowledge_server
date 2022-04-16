package com.seven.exhibition.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.seven.exhibition.model.DealData;
import com.seven.exhibition.model.StationEqu;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface DealDataMapper extends BaseMapper<DealData> {

    Page<StationEqu> selectStationEqu(Page<StationEqu> page);




}
