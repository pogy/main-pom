package com.opentae.data.mall.beans;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * 商品风格
 * Created by bugzy on 2017/5/17 0017.
 */
public class ShiguGoodsStyle implements Serializable {

    @Id
    @GeneratedValue(
            generator = "JDBC"
    )
    private Long gsId;

    private Long goodsId;

    private String sids;

    public Long getGsId() {
        return gsId;
    }

    public void setGsId(Long gsId) {
        this.gsId = gsId;
    }

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public String getSids() {
        return sids;
    }

    public void setSids(String sids) {
        this.sids = sids;
    }
}
