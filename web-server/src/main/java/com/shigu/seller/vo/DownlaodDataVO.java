package com.shigu.seller.vo;

import java.io.Serializable;

/**
 * Created by gtx on 2018/5/30.
 * 下载排行
 * @author gtx
 * @description
 * @since
 */
public class DownlaodDataVO implements Serializable {
    /**
     * 商品id
     */
    private String goodsId;
    /**
     * 图片地址
     */
    private String imgSrc;
    /**
     *	商品标题
     */
    private String title;
    /**
     * 最后一次下载的用户的手机号
     */
    private String userPhone;
    /**
     * 下载次数
     */
    private String downNum;
    /**
     * 最后下载时间 yyyy-mm-dd HH:mm
     */
    private String lastDownTime;

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public String getImgSrc() {
        return imgSrc;
    }

    public void setImgSrc(String imgSrc) {
        this.imgSrc = imgSrc;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getDownNum() {
        return downNum;
    }

    public void setDownNum(String downNum) {
        this.downNum = downNum;
    }

    public String getLastDownTime() {
        return lastDownTime;
    }

    public void setLastDownTime(String lastDownTime) {
        this.lastDownTime = lastDownTime;
    }
}
