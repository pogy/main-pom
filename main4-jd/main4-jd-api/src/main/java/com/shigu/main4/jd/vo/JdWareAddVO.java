package com.shigu.main4.jd.vo;

import java.io.Serializable;
import java.util.List;

/**
 * Created By admin on 2017/12/24/14:14
 */
public class JdWareAddVO implements Serializable {
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
    private List<JdSkuInfoVO> jdSkuInfoVOS;

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

    public List<JdSkuInfoVO> getJdSkuInfoVOS() {
        return jdSkuInfoVOS;
    }

    public void setJdSkuInfoVOS(List<JdSkuInfoVO> jdSkuInfoVOS) {
        this.jdSkuInfoVOS = jdSkuInfoVOS;
    }
}
