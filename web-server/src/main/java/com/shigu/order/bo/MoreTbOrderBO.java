package com.shigu.order.bo;

import java.util.List;

/**
 * 批量解析淘宝订单
 */
public class MoreTbOrderBO {
    private List<String> tids;
    private Boolean repeatIs;

    public List<String> getTids() {
        return this.tids;
    }

    public void setTids(List<String> tids) {
        this.tids = tids;
    }

    public Boolean getRepeatIs() {
        return this.repeatIs;
    }

    public void setRepeatIs(Boolean repeatIs) {
        this.repeatIs = repeatIs;
    }
}
