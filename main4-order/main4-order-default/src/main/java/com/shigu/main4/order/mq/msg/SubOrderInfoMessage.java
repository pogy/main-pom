package com.shigu.main4.order.mq.msg;

import com.shigu.tools.KeyWordsUtil;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;
import java.util.List;

/**
 * 子单消息
 * Created by bugzy on 2017/8/15 0015.
 */
public class SubOrderInfoMessage implements Serializable {
    /**
     * 子单ID
     */
    private Long soid;

    private List<Long> soidps;

    private String mark;
    /**
     * 商品数
     */
    private Integer num;
    /**
     * 单价：接口传出来的数值
     */
    private String singlePay;
    /**
     * 商品ID
     */
    private Long goodsId;
    /**
     * 标题
     */
    private String title;
    /**
     * 图片地址
     */
    private String picUrl;
    /**
     * 分站信息
     */
    private String webSite;
    /**
     * 市场id
     */
    private Long marketId;
    /**
     * 楼层id
     */
    private Long floorId;
    /**
     * 档口id
     */
    private Long shopId;
    /**
     * 市场
     */
    private String marketName;
    /**
     * 楼层
     */
    private String floor;
    /**
     * 档口
     */
    private String shopNum;
    /**
     * 货号(商家编码?)
     */
    private String goodsNo;
    /**
     * 重量
     */
    private String weight;
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

    public List<Long> getSoidps() {
        return soidps;
    }

    public void setSoidps(List<Long> soidps) {
        this.soidps = soidps;
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
        if(StringUtils.isNotBlank(title)){
            title= KeyWordsUtil.duleKeyWords(title);
        }
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

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
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
}
