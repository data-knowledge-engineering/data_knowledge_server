package com.seven.exhibition.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("deal_data_line_station")
public class LineStation {
    private String id;
    private String lineName;
    private String station;
}
