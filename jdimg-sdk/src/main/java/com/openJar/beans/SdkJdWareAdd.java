package com.openJar.beans;

import com.openJar.responses.api.JdSkuInfoResponse;
import com.openJar.utils.OpenBean;

import java.util.List;

public class SdkJdWareAdd extends OpenBean{
    /**
     * 商品ID
     */
    private Long goodsId;
    /**
     * 最后更新时间
     */
    private String createdAt;
    /**
     * sku信息
     */
    private List<JdSkuInfoResponse> jdSkuInfoVOS;

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public List<JdSkuInfoResponse> getJdSkuInfoVOS() {
        return jdSkuInfoVOS;
    }

    public void setJdSkuInfoVOS(List<JdSkuInfoResponse> jdSkuInfoVOS) {
        this.jdSkuInfoVOS = jdSkuInfoVOS;
    }
}
