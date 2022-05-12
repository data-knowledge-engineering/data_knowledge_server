package com.seven.exhibition.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.seven.exhibition.mapper.CouponCardMapper;
import com.seven.exhibition.model.CouponCard;
import com.seven.exhibition.model.StationEqu;
import com.seven.exhibition.service.CouponCardService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class CouponCardServiceImpl implements CouponCardService {

    @Resource
    private CouponCardMapper couponCardMapper;

    @Override
    public Double selectCouponCard() {

        QueryWrapper<CouponCard> queryWrapper = new QueryWrapper<>();
        QueryWrapper<CouponCard> couponCard = queryWrapper.select("id,coupon_type,coupon_count")
                .lt("coupon_count", 1);
        QueryWrapper<CouponCard> queryWrapper2 = new QueryWrapper<>();
        QueryWrapper<CouponCard> allCard = queryWrapper2.select("id,coupon_type,coupon_count");
        Double size = Double.valueOf(couponCardMapper.selectList(couponCard).size());
        Double size1 = Double.valueOf(couponCardMapper.selectList(allCard).size());

        Double per = (size/size1);



        return per;
    }
}
