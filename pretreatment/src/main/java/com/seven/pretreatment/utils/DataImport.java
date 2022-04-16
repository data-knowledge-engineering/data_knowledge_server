package com.seven.pretreatment.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.seven.pretreatment.entity.CouponCard;
import com.seven.pretreatment.entity.DealData;
import com.seven.pretreatment.entity.LineStation;
import com.seven.pretreatment.entity.StationEqu;

import javax.sound.sampled.Line;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * @version 1.0.0
 * @classname DataImport.java
 * @description 数据导入功能类
 * @date 2022/3/27 16:27
 * @created by Leo
 */
public class DataImport {


    public ArrayList<String> toArrayByFileReader1(String filePath) {
        // 使用ArrayList来存储每行读取到的字符串
        ArrayList<String> arrayList = new ArrayList<>();
        try {
            FileReader fr = new FileReader(filePath);
            BufferedReader bf = new BufferedReader(fr);
            String str;
            // 按行读取字符串
            while ((str = bf.readLine()) != null) {
                arrayList.add(str);
            }
            bf.close();
            fr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 返回数组
        return arrayList;
    }

    public ArrayList<DealData> toDealData(ArrayList<String> list) {
        ArrayList<DealData> dealDataList = new ArrayList<>();
        for (String s : list) {
            // 每一行取data数组
            JSONArray data = JSON.parseObject(s).getJSONArray("data");
            for (int j = 0; j < data.size(); j++) {
                DealData object = data.getObject(j, DealData.class);
                if (object.getDeal_type() == null || object.getDeal_type().contains("巴士")) continue;
                dealDataList.add(object);
            }
        }
        return dealDataList;
    }

    // 获取站点设备
    public ArrayList<StationEqu> getStationEquipment(ArrayList<DealData> dealDataList) {
        // 通过 站点 – 设备号 – 交易类型 获取数据
        // 存储最终设备
        ArrayList<StationEqu> seList = new ArrayList<>();
        // 存储所有找到站点的设备
        ArrayList<String> equNoList = new ArrayList<>();
        for (DealData dealData : dealDataList) {
            if (equNoList.contains(dealData.getEqu_no())) continue;
            StationEqu se = TransformData.dealDataToStationEquipment(dealData);
            if (seList.contains(se)) continue;
            // 简单清洗数据
            if (se.hasNull()) continue;
            seList.add(se);
            equNoList.add(se.getEquNo());
        }
        return seList;
    }

    public ArrayList<LineStation> getLineStation(ArrayList<DealData> dealDataList) {
        ArrayList<LineStation> lineStations = new ArrayList<>();
        for (DealData dealData : dealDataList) {
            LineStation ls = new LineStation();
            ls.setStation(dealData.getStation());
            ls.setLineName(dealData.getCompany_name());
            if (lineStations.contains(ls)) continue;
            lineStations.add(ls);
        }
        return lineStations;
    }

    public ArrayList<CouponCard> getCouponCard(ArrayList<DealData> dealDataList) {
        ArrayList<CouponCard> cardArrayList = new ArrayList<>();
        ArrayList<Float> floats = new ArrayList<>();
        for (DealData dealData : dealDataList) {
            if (dealData.getDeal_value() == 0 || dealData.getDeal_money() == 0) continue;
            float count = dealData.getDeal_money() / dealData.getDeal_value();
            BigDecimal b = new BigDecimal(count);
            Float f1 = b.setScale(2, BigDecimal.ROUND_HALF_UP).floatValue();
            if (floats.contains(f1)) continue;
            floats.add(f1);
            CouponCard couponCard = new CouponCard();
            couponCard.setCouponCount(f1);
            if (Float.toString(f1).contains(".")) {
                String s = f1.toString().split("\\.")[1];
                couponCard.setCouponType(s + "折卡");
            } else {
                couponCard.setCouponType("地铁卡");
            }
            cardArrayList.add(couponCard);
        }
        return cardArrayList;
    }


}
