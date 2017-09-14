package com.shigu.daifa.bo;

import java.io.Serializable;
import java.util.List;

public class PrintGoodsTagBO implements Serializable {
    private Integer type;
    private List<Long> ids;

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
}
