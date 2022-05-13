package com.seven.exhibition.service;

import com.seven.exhibition.model.LineStation;

import java.util.List;

public interface LineStationService {
    List<String> selectLine(String lineName);
}
