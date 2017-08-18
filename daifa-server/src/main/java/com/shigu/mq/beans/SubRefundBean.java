package com.shigu.mq.beans;

import java.io.Serializable;
import java.util.List;

public class SubRefundBean implements Serializable{
    private String soid;
    private List<String> soidps;

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
}
