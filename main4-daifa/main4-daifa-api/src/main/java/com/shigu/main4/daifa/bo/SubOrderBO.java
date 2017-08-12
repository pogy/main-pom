package com.shigu.main4.daifa.bo;

import java.io.Serializable;
import java.util.List;

/**
 * Created by jmb on 2017/8/11.
 * Path com.shigu.main4.daifa.bo.SubOrderBO
 */
public class SubOrderBO implements Serializable{
    private Long soid;//      子订单ID
    private int num;//       子订单中件数
    private List<Long> soidps;
    private String singlePay;//   支付的单价
    private Long goodsId;//      商品ID
    private String title;//             标题
    private String picUrl;//         下单时刻的图片链接
    private String webSite;//       分站标识
    private Long marketId;//     市场ID
    private Long floorId;//         楼层ID
    private Long shopId;//         档口ID
    private String marketName;//  下单时刻的市场名
    private String shopNum;//     下单时刻的档口号
    private String goodsNo;//        货号
    private String weight;//          下单时刻的重量
    private String floor;//              下单时刻的楼层
    private String size;//        尺码
    private String color;//        颜色
    private String serviceFee;//服务费

    public String getServiceFee() {
        return serviceFee;
    }

    public void setServiceFee(String serviceFee) {
        this.serviceFee = serviceFee;
    }

    public List<Long> getSoidps() {
        return soidps;
    }

    public void setSoidps(List<Long> soidps) {
        this.soidps = soidps;
    }

    public String getSinglePay() {
        return singlePay;
    }

    public void setSinglePay(String singlePay) {
        this.singlePay = singlePay;
    }

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public String getWebSite() {
        return webSite;
    }

    public void setWebSite(String webSite) {
        this.webSite = webSite;
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

    public String getMarketName() {
        return marketName;
    }

    public void setMarketName(String marketName) {
        this.marketName = marketName;
    }

    public String getShopNum() {
        return shopNum;
    }

    public void setShopNum(String shopNum) {
        this.shopNum = shopNum;
    }

    public String getGoodsNo() {
        return goodsNo;
    }

    public void setGoodsNo(String goodsNo) {
        this.goodsNo = goodsNo;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
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

    public Long getSoid() {
        return soid;
    }

    public void setSoid(Long soid) {
        this.soid = soid;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}
