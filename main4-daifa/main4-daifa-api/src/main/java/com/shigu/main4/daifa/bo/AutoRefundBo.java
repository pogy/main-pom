package com.shigu.main4.daifa.bo;

import java.io.Serializable;
import java.util.List;

public class AutoRefundBo implements Serializable {
    private String soid;
    private List<String> soidps;
    private Integer num;

    public String getSoid() {
        return this.soid;
    }

    public void setSoid(String soid) {
        this.soid = soid;
    }

    public List<String> getSoidps() {
        return this.soidps;
    }

    public void setSoidps(List<String> soidps) {
        this.soidps = soidps;
    }

    public Integer getNum() {
        return this.num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }
}
