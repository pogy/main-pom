package com.shigu.main4.daifa.vo;

import java.io.Serializable;
import java.util.List;

public class UnComleteAllVO implements Serializable {
    private List<Long> takeIds;
    private List<Long> notTakeIds;

    public List<Long> getTakeIds() {
        return this.takeIds;
    }

    public void setTakeIds(List<Long> takeIds) {
        this.takeIds = takeIds;
    }

    public List<Long> getNotTakeIds() {
        return this.notTakeIds;
    }

    public void setNotTakeIds(List<Long> notTakeIds) {
        this.notTakeIds = notTakeIds;
    }
}
