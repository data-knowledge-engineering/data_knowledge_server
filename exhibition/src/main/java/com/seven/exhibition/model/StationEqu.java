package com.seven.exhibition.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;


@Data
@TableName("deal_data_station_equ")
public class StationEqu {

    private String station_name;//线路站点
    private String equ_no;//设备编码
    private String equ_type;//交易类型



}
