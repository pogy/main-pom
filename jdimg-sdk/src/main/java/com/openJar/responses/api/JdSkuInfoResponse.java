package com.openJar.responses.api;

import com.openJar.responses.Response;

/**
 * Created By admin on 2017/12/24/14:17
 */
public class JdSkuInfoResponse extends Response {
    private long skuId;
    private String attribute;

    public JdSkuInfoResponse() {
    }

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
