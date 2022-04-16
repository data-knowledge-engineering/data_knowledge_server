package com.seven.pretreatment.utils;

import com.seven.pretreatment.entity.DealData;
import com.seven.pretreatment.entity.StationEqu;

public class TransformData {

    public static StationEqu dealDataToStationEquipment(DealData dealData) {
        StationEqu se = new StationEqu();
        se.setStationName(dealData.getStation());
        se.setEquNo(dealData.getEqu_no());
        se.setEquType(dealData.getDeal_type().equals("地铁入站") ? "入站设备" : "出站设备");
        return se;
    }

}
