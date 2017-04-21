package com.shigu.seller.vo;

import com.shigu.tools.DateParseUtil;

import java.io.Serializable;
import java.util.Date;

/**
 * 批量修改的
 * Created by zhaohongbo on 17/3/19.
 */
public class MoreModifyItemVO implements Serializable{
    private Long itemId;
    private String goodsNo;
    private String price;
    private String piPrice;
    private String picUrl;
    private String created;

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public String getGoodsNo() {
        return goodsNo;
    }

    public void setGoodsNo(String goodsNo) {
        this.goodsNo = goodsNo;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getPiPrice() {
        return piPrice;
    }

    public void setPiPrice(String piPrice) {
        this.piPrice = piPrice;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = DateParseUtil.parseDate("yyyy-MM-dd HH:mm:ss",created);
    }
}
