package com.shigu.seller.bo;

import com.shigu.tools.EncodeParamter;

import java.io.Serializable;

/**
 * 供货商里面用的,统一的get
 * Created by zhaohongbo on 17/3/4.
 */
public class GhsGet implements Serializable{
    /**
     * 搜索关键词回填
     */
    private String keyword;
    /**
     * 搜索货号回填
     */
    private String goodsNo;
    /**
     * 搜索淘宝id回填
     */
    private Long goodsId;
    /**
     * 1淘宝未绑定; 2淘宝授权过期
     */
    private int feedback;

    private String cid;

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = EncodeParamter.decodeUtf8(keyword);
    }

    public String getGoodsNo() {
        return goodsNo;
    }

    public void setGoodsNo(String goodsNo) {
        this.goodsNo = goodsNo;
    }

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public int getFeedback() {
        return feedback;
    }

    public void setFeedback(int feedback) {
        this.feedback = feedback;
    }
}
