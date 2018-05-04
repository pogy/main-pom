package com.shigu.seller.vo;

import java.io.Serializable;

/**
 * @ProjectName: main-pom
 * @Package: com.shigu.seller.vo
 * @ClassName: DfQuery
 * @Author: sy
 * @CreateDate: 2018/5/4 0004 17:53
 */
public class DfQuery implements Serializable{

    private Long orderId;
    private String goodsNo;

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getGoodsNo() {
        return goodsNo;
    }

    public void setGoodsNo(String goodsNo) {
        this.goodsNo = goodsNo;
    }
}
