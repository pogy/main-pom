package com.shigu.main4.jd.vo;

import java.io.Serializable;

/**
 * Created By admin on 2017/12/24/14:17
 */
public class JdSkuInfoVO implements Serializable {
    private long skuId;
    private String attribute;

    public long getSkuId() {
        return skuId;
    }

    public void setSkuId(long skuId) {
        this.skuId = skuId;
    }

    public String getAttribute() {
        return attribute;
    }

    public void setAttribute(String attribute) {
        this.attribute = attribute;
    }
}
