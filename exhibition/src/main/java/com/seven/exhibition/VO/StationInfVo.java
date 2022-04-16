package com.seven.exhibition.VO;

import com.seven.exhibition.model.StationEqu;
import lombok.Data;

import java.util.List;

@Data
public class StationInfVo {
    private String sname;//站点名
    private Integer lnum;//出站口数
    private Integer cnum;//入站口数
    private List<StationEqu> sdata;//站点详细数据
}
