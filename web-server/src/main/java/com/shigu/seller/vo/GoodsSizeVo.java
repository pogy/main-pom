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

    private String sizeText;
    private Long skuId;
    private String skuPrice;
    private Integer num;


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

    public String getSizeText() {
        return sizeText;
    }

    public void setSizeText(String sizeText) {
        this.sizeText = sizeText;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }
}
