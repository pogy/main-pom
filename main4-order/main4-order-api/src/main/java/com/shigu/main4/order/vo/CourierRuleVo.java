package com.shigu.main4.order.vo;

import java.io.Serializable;
import java.util.List;

/**
 * @ProjectName: main-pom
 * @Package: com.shigu.main4.daifa.vo
 * @ClassName: CourierRuleVo
 * @Author: sy
 * @CreateDate: 2018/4/4 0004 14:32
 */
public class CourierRuleVo implements Serializable{

    private String provs;
    private List<CourierShowVo> freightList;

    public String getProvs() {
        return provs;
    }

    public void setProvs(String provs) {
        this.provs = provs;
    }

    public List<CourierShowVo> getFreightList() {
        return freightList;
    }

    public void setFreightList(List<CourierShowVo> freightList) {
        this.freightList = freightList;
    }
}
