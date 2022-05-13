package com.seven.exhibition.web;

import com.seven.exhibition.model.LineStation;
import com.seven.exhibition.service.LineStationService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class LineStationController {

    @Resource
    private LineStationService lineStationService;

    @RequestMapping("/line/{lineName}")
    public Object selectLine(@PathVariable("lineName") String lineName){






        return  lineStationService.selectLine(lineName);
    }

}
