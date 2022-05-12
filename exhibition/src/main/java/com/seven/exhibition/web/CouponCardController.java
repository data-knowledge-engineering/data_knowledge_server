package com.seven.exhibition.web;

import com.seven.exhibition.service.CouponCardService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.text.DecimalFormat;

/*
* 查询优惠卡比例
* 访问http://localhost:8002/coupon/per
* */

@RestController
@RequestMapping("/coupon")
public class CouponCardController {

    @Resource
    private CouponCardService couponCardService;

    @RequestMapping("/per")
    public Object selectCouponPer(){

        DecimalFormat df = new DecimalFormat("0.00");

        return df.format(couponCardService.selectCouponCard()*100)+"%" ;

    }



}
