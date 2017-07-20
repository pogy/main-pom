package com.shigu.main4.order.vo;

import java.io.Serializable;

/**
 * 子订单
 * Created by zhaohongbo on 17/6/1.
 */
public class SubOrderVO implements Serializable{


    /**
     * 子订单ID
     */
    private Long soid;

    /**
     * 订单ID
     */
    private Long oid;

    /**
     * 件数
     */
    private Integer num;

    /**
     * 备注
     */
    private String mark;

    /**
     * 商品ID
     */
    private Long goodsId;

    /**
     * 货号(商家编码?)
     */
    private String goodsNo;
    /**
     * 尺码
     */
    private String size;

    /**
     * 颜色
     */
    private String color;

    public Long getSoid() {
        return soid;
    }

    public void setSoid(Long soid) {
        this.soid = soid;
    }

    public Long getOid() {
        return oid;
    }

    public void setOid(Long oid) {
        this.oid = oid;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getGoodsNo() {
        return goodsNo;
    }

    public void setGoodsNo(String goodsNo) {
        this.goodsNo = goodsNo;
    }
}
