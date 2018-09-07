package com.shigu.daifa.bo;

import java.io.Serializable;
import java.util.List;

public class PrintGoodsTagBO implements Serializable {
    private Integer type;
    private List<Long> ids;
    private String batchesText;

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public List<Long> getIds() {
        return ids;
    }

    public void setIds(List<Long> ids) {
        this.ids = ids;
    }

    public String getBatchesText() {
        return this.batchesText;
    }

    public void setBatchesText(String batchesText) {
        this.batchesText = batchesText;
    }
}
