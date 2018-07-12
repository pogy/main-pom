package com.shigu.order.vo;

import java.io.Serializable;

/**
 * @ProjectName: main-pom
 * @Package: com.shigu.order.vo
 * @ClassName: TownVo
 * @Author: sy
 * @CreateDate: 2018/6/13 0013 15:16
 */
public class TownVo implements Serializable{
    private Long countyId;
    private String countyText;

    public Long getCountyId() {
        return countyId;
    }

    public void setCountyId(Long countyId) {
        this.countyId = countyId;
    }

    public String getCountyText() {
        return countyText;
    }

    public void setCountyText(String countyText) {
        this.countyText = countyText;
    }
}
