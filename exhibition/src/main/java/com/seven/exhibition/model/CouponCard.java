package com.seven.exhibition.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("deal_data_coupon_card")
public class CouponCard {
    private String id;
    private String couponType;
    private String couponCount;

}
