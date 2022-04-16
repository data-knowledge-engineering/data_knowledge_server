package com.seven.pretreatment;

import com.seven.pretreatment.entity.CouponCard;
import com.seven.pretreatment.entity.DealData;
import com.seven.pretreatment.entity.LineStation;
import com.seven.pretreatment.entity.StationEqu;
import com.seven.pretreatment.service.CouponCardService;
import com.seven.pretreatment.service.DealDataService;
import com.seven.pretreatment.service.LineStationService;
import com.seven.pretreatment.service.StationEquService;
import com.seven.pretreatment.utils.DataImport;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

@SpringBootTest
class SpringBootDemoApplicationTests {


    @Test
    void contextLoads() {
    }

    @Autowired
    DealDataService dealDataService;
    @Autowired
    StationEquService stationEquService;
    @Autowired
    LineStationService lineStationService;
    @Autowired
    CouponCardService couponCardService;

    @Test
    public void parseCode() {
        System.out.println("开始执行");
        DataImport dataImport = new DataImport();

        long now = System.currentTimeMillis();
        ArrayList<String> strings = dataImport.toArrayByFileReader1("E:\\Project\\zstu\\metro\\2018record3.jsons");
        System.out.printf("读取文件完成，用时%.2fs\n", getCostTime(now));

        now = System.currentTimeMillis();
        ArrayList<DealData> dealDataList = dataImport.toDealData(strings);
        System.out.printf("生成对象数组完成，用时%.2fs\n", getCostTime(now));

        now = System.currentTimeMillis();
        ArrayList<StationEqu> stationEquList = dataImport.getStationEquipment(dealDataList);
        System.out.printf("读取站点设备信息完成，用时%.2fs\n", getCostTime(now));

        now = System.currentTimeMillis();
        stationEquService.saveBatch(stationEquList);
        System.out.printf("存储站点设备信息完成，用时%.2fs\n", getCostTime(now));

        now = System.currentTimeMillis();
        ArrayList<LineStation> lineStation = dataImport.getLineStation(dealDataList);
        System.out.printf("读取站点线路信息完成，用时%.2fs\n", getCostTime(now));

        now = System.currentTimeMillis();
        lineStationService.saveBatch(lineStation);
        System.out.printf("存储站点线路信息完成，用时%.2fs\n", getCostTime(now));

        now = System.currentTimeMillis();
        ArrayList<CouponCard> couponCard = dataImport.getCouponCard(dealDataList);
        System.out.printf("读取优惠卡完成，用时%.2fs\n", getCostTime(now));

        now = System.currentTimeMillis();
        couponCardService.saveBatch(couponCard);
        System.out.printf("存储优惠卡完成，用时%.2fs\n", getCostTime(now));
    }

    private float getCostTime(long now) {
        return (System.currentTimeMillis() - now) / 1000.0F;
    }

}
