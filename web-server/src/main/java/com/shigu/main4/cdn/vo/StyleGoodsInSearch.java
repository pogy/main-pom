package com.shigu.main4.cdn.vo;

import java.io.Serializable;

/**
 * 路径:com.shigu.main4.cdn.vo.StyleGoodsInSearch
 * 工程:main-pom
 * 时间:18-1-29下午1:34
 * 创建人:wanghaoxiang
 * 描述：前端在风格频道改了显示商品字段
 */
public class StyleGoodsInSearch implements Serializable {
    /**
     * 商品id
     */
    private Long id;
    /**
     * 商品标题
     */
    private String title;

    private String highLightTitle;
    /**
     * 商品图片地址，绝对路径
     */
    private String imgsrc;
    /**
     * 商品批发价，格式(12.00)
     */
    private String piprice;
    /**
     * 商品发布时间，格式(5分钟前，2小时前等)
     */
    private String postTimeText;
    /**
     * 店铺ID
     */
    private Long shopId;
    /**
     * 商品所属市场档口名全称，空格隔开
     */
    private String fullStoreName;
    /**
     * 阿里旺旺昵称
     */
    private String aliww;
    /**
     * 货号
     */
    private String goodsNo;
    /**
     * 高亮货号
     */
    private String highLightGoodsNo;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getHighLightTitle() {
        return highLightTitle;
    }

    public void setHighLightTitle(String highLightTitle) {
        this.highLightTitle = highLightTitle;
    }

    public String getImgsrc() {
        return imgsrc;
    }

    public void setImgsrc(String imgsrc) {
        this.imgsrc = imgsrc;
    }

    public String getPiprice() {
        return piprice;
    }

    public void setPiprice(String piprice) {
        this.piprice = piprice;
    }

    public String getPostTimeText() {
        return postTimeText;
    }

    public void setPostTimeText(String postTimeText) {
        this.postTimeText = postTimeText;
    }

    public String getFullStoreName() {
        return fullStoreName;
    }

    public void setFullStoreName(String fullStoreName) {
        this.fullStoreName = fullStoreName;
    }

    public String getAliww() {
        return aliww;
    }

    public void setAliww(String aliww) {
        this.aliww = aliww;
    }

    public Long getShopId() {
        return shopId;
    }

    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }

    public String getGoodsNo() {
        return goodsNo;
    }

    public void setGoodsNo(String goodsNo) {
        this.goodsNo = goodsNo;
    }

    public String getHighLightGoodsNo() {
        return highLightGoodsNo;
    }

    public void setHighLightGoodsNo(String highLightGoodsNo) {
        this.highLightGoodsNo = highLightGoodsNo;
    }

}
