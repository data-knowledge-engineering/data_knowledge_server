package com.seven.pretreatment.entity;

import com.baomidou.mybatisplus.annotation.IdType;
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
@ApiModel(value="StationEqu对象", description="")
public class StationEqu implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private String id;

    @ApiModelProperty(value = "站点名称")
    private String stationName;

    @ApiModelProperty(value = "设备编号")
    private String equNo;

    @ApiModelProperty(value = "站点设备")
    private String equType;

    // 判空方法
    public boolean hasNull() {
        return stationName == null || stationName.equals("") ||
                equNo == null || equNo.equals("") ||
                equType == null || equType.equals("");
    }

}
