package com.seven.exhibition.service;

import com.seven.exhibition.model.StationEqu;

import java.util.List;

public interface StationEquService {
    List<StationEqu> selectStationEqu();
    List<StationEqu> selectByStation(String sname);
    Integer selectLnum(String sname);
    Integer selectCnum(String sname);
}
