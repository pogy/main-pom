package com.shigu.seller.vo;

import java.io.Serializable;

/**
 * Created by gtx on 2018/5/30.
 * 一周访问排行榜数据
 * @author gtx
 * @description
 * @since
 */
public class WeekReadDataVO implements Comparable<WeekReadDataVO>,Serializable{

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
     * 浏览次数
     */
    private String readNum;
    /**
     * 最后浏览时间 yyyy-MM-dd HH:mm
     */
    private String lastReadTime;

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

    public String getReadNum() {
        return readNum;
    }

    public void setReadNum(String readNum) {
        this.readNum = readNum;
    }

    public String getLastReadTime() {
        return lastReadTime;
    }

    public void setLastReadTime(String lastReadTime) {
        this.lastReadTime = lastReadTime;
    }

    @Override
    public int compareTo(WeekReadDataVO o) {
        if (o == null || o.getReadNum() == null || o.getReadNum().trim().length() == 0) {
            return 1;
        }
        if (this.getReadNum() == null || this.getReadNum().trim().length() == 0) {
            return -1;
        }
        return Long.parseLong(this.getReadNum()) > Long.parseLong(o.getReadNum()) ? -1 : 1;
    }
}
