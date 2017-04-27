package com.shigu.main4.item.vo;

/**
 * 往图搜的对象
 * Created by zhaohongbo on 17/4/27.
 */
public class ImgToSearch {

    private Long goodsId;

    private String picUrl;

    private String webSite;
    /**
     * 0删除,1添加或更新
     */
    private Integer type;

    public ImgToSearch(Long goodsId, String webSite,String picUrl,  Integer type) {
        this.goodsId = goodsId;
        this.picUrl = picUrl;
        this.webSite = webSite;
        this.type = type;
    }

    public String getWebSite() {
        return webSite;
    }

    public void setWebSite(String webSite) {
        this.webSite = webSite;
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
