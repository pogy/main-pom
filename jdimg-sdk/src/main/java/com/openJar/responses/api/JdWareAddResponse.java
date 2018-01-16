package com.openJar.responses.api;

import com.openJar.responses.Response;
import java.util.List;

/**
 * Created By admin on 2017/12/24/14:14
 */
public class JdWareAddResponse extends Response {
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

    public JdWareAddResponse() {
    }

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
