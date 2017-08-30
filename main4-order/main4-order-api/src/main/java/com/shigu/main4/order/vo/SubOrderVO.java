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

    /**
     * 产品价格
     */
    private Long price;

    /**
     * 市场ID
     */
    private Long marketId;

    /**
     * 楼层ID
     */
    private Long floorId;

    /**
     * 店铺ID
     */
    private Long shopId;

    /**
     * 档口号
     */
    private String shopNum;

    /**
     * 市场名字
     */
    private String marketName;

    /**
     * 楼层号
     */
    private String floor;

    /**
     * 重量，克为单位
     */
    private Long weight;


    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Long getMarketId() {
        return marketId;
    }

    public void setMarketId(Long marketId) {
        this.marketId = marketId;
    }

    public Long getFloorId() {
        return floorId;
    }

    public void setFloorId(Long floorId) {
        this.floorId = floorId;
    }

    public Long getShopId() {
        return shopId;
    }

    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }

    public String getShopNum() {
        return shopNum;
    }

    public void setShopNum(String shopNum) {
        this.shopNum = shopNum;
    }

    public String getMarketName() {
        return marketName;
    }

    public void setMarketName(String marketName) {
        this.marketName = marketName;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public Long getWeight() {
        return weight;
    }

    public void setWeight(Long weight) {
        this.weight = weight;
    }

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
