package com.seven.exhibition.web;

import com.seven.exhibition.VO.StationInfVo;
import com.seven.exhibition.model.StationEqu;
import com.seven.exhibition.service.StationEquService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/station")
public class StationEquController {
    @Resource
    private StationEquService stationEquService;


    /*查询站点-设备号-交易类型
     * station, equ_no, deal_type
     * */
    @RequestMapping("")
    public Object station() {
        return stationEquService.selectStationEqu();
    }


    /*查询某个站点的 设备数
     * station-->equ_no, deal_type
     * */
    @RequestMapping("/{sname}/inf")
    public Object findOneStation(@PathVariable("sname") String sname) {


        StationInfVo stationInfVo = new StationInfVo();
        stationInfVo.setSname(sname);
        stationInfVo.setLnum(stationEquService.selectLnum(sname));
        stationInfVo.setCnum(stationEquService.selectCnum(sname));
        stationInfVo.setSdata(stationEquService.selectByStation(sname));


        return stationInfVo;
    }

}
