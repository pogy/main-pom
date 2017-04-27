package com.shigu.main4.item.vo;

/**
 * 往图搜的对象
 * Created by zhaohongbo on 17/4/27.
 */
public class ImgToSearch {

    private Long goodsId;

    private String picUrl;
    /**
     * 0删除,1添加或更新
     */
    private Integer type;

    public ImgToSearch(Long goodsId, String picUrl, Integer type) {
        this.goodsId = goodsId;
        this.picUrl = picUrl;
        this.type = type;
    }

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}
