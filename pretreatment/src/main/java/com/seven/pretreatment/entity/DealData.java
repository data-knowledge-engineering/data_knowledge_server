package com.seven.pretreatment.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author Leo
 * @since 2022-04-16
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="DealData对象", description="")
public class DealData implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableField("deal_date")
    private Date deal_date;
    @TableField("close_date")
    private Date close_date;
    @TableField("card_no")
    private String card_no;
    @TableField("deal_value")
    private float deal_value;
    @TableField("deal_type")
    private String deal_type;
    @TableField("company_name")
    private String company_name;
    @TableField("car_no")
    private String car_no;
    @TableField("station")
    private String station;
    @TableField("conn_mark")
    private int conn_mark;
    @TableField("deal_money")
    private float deal_money;
    @TableField("equ_no")
    private String equ_no;

}
