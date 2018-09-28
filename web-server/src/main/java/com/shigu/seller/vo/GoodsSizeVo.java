package com.shigu.seller.vo;

import java.io.Serializable;

/**
 * @ProjectName: main-pom
 * @Package: com.shigu.seller.vo
 * @ClassName: GoodsSizeVo
 * @Author: sy
 * @CreateDate: 2018/9/26 0026 17:59
 */
public class GoodsSizeVo implements Serializable{

    private String size;
    private Long skuId;
    private String skuPrice;
    private Integer inventory;

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

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

    public Integer getInventory() {
        return inventory;
    }

    public void setInventory(Integer inventory) {
        this.inventory = inventory;
    }
}
