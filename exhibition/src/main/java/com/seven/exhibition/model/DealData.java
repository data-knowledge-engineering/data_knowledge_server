package com.seven.exhibition.model;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
@Data
public class DealData {

    private String card_no;//卡号
    private Date deal_date;//交易时间
    private String deal_type;//交易类型
    private BigDecimal deal_money;//交易金额
    private BigDecimal deal_value;//交易值
    private String equ_no;//设备编码
    private String company_name;//公司名称
    private String station;//线路站点
    private String car_no;//车牌号
    private Integer conn_mark;//联程标记
    private Date close_date;//结算日期


}
