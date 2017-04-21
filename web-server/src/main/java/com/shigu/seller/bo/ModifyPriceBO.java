package com.shigu.seller.bo;

import org.hibernate.validator.constraints.SafeHtml;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 修改价格
 * Created by zhaohongbo on 17/3/9.
 */
public class ModifyPriceBO implements Serializable{

    @NotNull(message = "goodsId不能为null")
    private Long goodsId;
    @SafeHtml(message = "price1包含非法页面标签")
    private String price1;
    @SafeHtml(message = "price2包含非法页面标签")
    private String price2;

    @SafeHtml(message = "price包含非法页面标签")
    private String price;

    @NotNull(message = "type不能为null")
    private Integer type;

    private Integer isShowcase;

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public String getPrice1() {
        return price1;
    }

    public void setPrice1(String price1) {
        this.price1 = price1;
    }

    public String getPrice2() {
        return price2;
    }

    public void setPrice2(String price2) {
        this.price2 = price2;
    }

    public Integer getIsShowcase() {
        return isShowcase;
    }

    public void setIsShowcase(Integer isShowcase) {
        this.isShowcase = isShowcase;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
