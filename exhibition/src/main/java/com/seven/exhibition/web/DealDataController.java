package com.seven.exhibition.web;



import com.seven.exhibition.model.StationEqu;
import com.seven.exhibition.service.DealDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DealDataController {
    @Autowired
    private DealDataService dealDataService;

    @RequestMapping(value = "/station1")
    public  Object station() {


        List<StationEqu> stationEqus = dealDataService.selectStationEqu();




        return stationEqus;
    }

}
