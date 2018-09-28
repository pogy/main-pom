package com.shigu.seller.bo;

import java.io.Serializable;

/**
 * @ProjectName: main-pom
 * @Package: com.shigu.seller.bo
 * @ClassName: GoodsSkuBo
 * @Author: sy
 * @CreateDate: 2018/9/27 0027 11:28
 */
public class GoodsSkuBo implements Serializable{

    private Long skuId;
    private String skuPrice;
    private Integer skuInventory;

    public Long getSkuId() {
        return skuId;
    }

    public void setSkuId(Long skuId) {
        this.skuId = skuId;
    }

    public String getSkuPrice() {
        return skuPrice;
    }

    public void setSkuPrice(String skuPrice) {
        this.skuPrice = skuPrice;
    }

    public Integer getSkuInventory() {
        return skuInventory;
    }

    public void setSkuInventory(Integer skuInventory) {
        this.skuInventory = skuInventory;
    }
}
