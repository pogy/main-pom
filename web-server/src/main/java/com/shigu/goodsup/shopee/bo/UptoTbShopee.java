package com.shigu.goodsup.shopee.bo;


import java.io.Serializable;

/**
 * 上传给淘宝的参数
 * Created by zhaohongbo on 17/1/18.
 */
public class UptoTbShopee implements Serializable{

    /**
     * 新旧
     */
    private String stuffStatus;
    /**
     * 标题
     */
    private String title;
    /**
     * 卖点
     */
    private String sellPoint;
    /**
     * 价格
     */
    private String price;
    /**
     * 重量
     */
    private String weight;
    /**
     * 在售状态
     */
    private String approve_status;
    /**
     * 类目ID
     */
    private Long cid;
    /**
     * 用户淘宝ID
     */
    private Long uid;
    /**
     * 星座店ID
     */
    private Long shopUid;
    /**
     * 商品ID
     */
    private Long mid;

    /**
     * 获取 新旧
     */
    public String getStuffStatus() {
        return this.stuffStatus;
    }

    /**
     * 设置 新旧
     */
    public void setStuffStatus(String stuffStatus) {
        this.stuffStatus = stuffStatus;
    }

    /**
     * 获取 标题
     */
    public String getTitle() {
        return this.title;
    }

    /**
     * 设置 标题
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 获取 卖点
     */
    public String getSellPoint() {
        return this.sellPoint;
    }

    /**
     * 设置 卖点
     */
    public void setSellPoint(String sellPoint) {
        this.sellPoint = sellPoint;
    }

    /**
     * 获取 价格
     */
    public String getPrice() {
        return this.price;
    }

    /**
     * 设置 价格
     */
    public void setPrice(String price) {
        this.price = price;
    }

    /**
     * 获取 重量
     */
    public String getWeight() {
        return this.weight;
    }

    /**
     * 设置 重量
     */
    public void setWeight(String weight) {
        this.weight = weight;
    }

    /**
     * 获取 在售状态
     */
    public String getApprove_status() {
        return this.approve_status;
    }

    /**
     * 设置 在售状态
     */
    public void setApprove_status(String approve_status) {
        this.approve_status = approve_status;
    }

    /**
     * 获取 类目ID
     */
    public Long getCid() {
        return this.cid;
    }

    /**
     * 设置 类目ID
     */
    public void setCid(Long cid) {
        this.cid = cid;
    }

    /**
     * 获取 用户淘宝ID
     */
    public Long getUid() {
        return this.uid;
    }

    /**
     * 设置 用户淘宝ID
     */
    public void setUid(Long uid) {
        this.uid = uid;
    }

    /**
     * 获取 星座店ID
     */
    public Long getShopUid() {
        return this.shopUid;
    }

    /**
     * 设置 星座店ID
     */
    public void setShopUid(Long shopUid) {
        this.shopUid = shopUid;
    }

    /**
     * 获取 商品ID
     */
    public Long getMid() {
        return this.mid;
    }

    /**
     * 设置 商品ID
     */
    public void setMid(Long mid) {
        this.mid = mid;
    }
}
