package com.shigu.buyer.vo;

import java.io.Serializable;

/**
 * 认证初始信息
 * Created by zhaohongbo on 17/3/13.
 */
public class SafeRzVO implements Serializable{

    /**
     * 身份证号
     */
    private String cardnum;
    /**
     * 实名认证图
     */
    private String imgurl1;
    /**
     * 暂时没用
     */
    private String imgurl2;
    /**
     * 错误信息
     */
    private String msg;

    public String getCardnum() {
        return cardnum;
    }

    public void setCardnum(String cardnum) {
        this.cardnum = cardnum;
    }

    public String getImgurl1() {
        return imgurl1;
    }

    public void setImgurl1(String imgurl1) {
        this.imgurl1 = imgurl1;
    }

    public String getImgurl2() {
        return imgurl2;
    }

    public void setImgurl2(String imgurl2) {
        this.imgurl2 = imgurl2;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
