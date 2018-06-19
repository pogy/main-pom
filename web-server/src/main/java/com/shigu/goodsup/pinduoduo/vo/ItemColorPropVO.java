package com.shigu.goodsup.pinduoduo.vo;

import java.io.Serializable;

/**
 * Created by gtx on 2018/6/18.
 * 商品详情页颜色与色图
 * @author gtx
 * @since
 */
public class ItemColorPropVO implements Serializable{
    /**
     * 颜色名
     */
    private String text;
    /**
     * 颜色图片地址
     */
    private String imgSrc;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getImgSrc() {
        return imgSrc;
    }

    public void setImgSrc(String imgSrc) {
        this.imgSrc = imgSrc;
    }
}
