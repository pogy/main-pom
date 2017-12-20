package com.shigu.main4.newcdn.vo;

import java.util.List;

/**
 * Created by zf on 2017/7/25.
 */
public class CdnGoodsInfoVO {
    /**
     * 商品ID
     */
    private Long goodsId;
    /**
     * 淘宝商品ID
     */
    private Long tbGoodsId;
    /**
     * 标题
     */
    private String title;
    /**
     * 主图6张,第一张为首图
     */
    private List<String> imgUrls;
    /**
     * 商品服务类型, 1(可退)，2（可换），可以有的服务都传进来
     */
    private List<String> services;
    /**
     * 商品货号
     */
    private String goodsNo;
    /**
     * 	发布时间，格式（2017-02-22）
     */
    private String postTime;
    /**
     * 零售价
     */
    private String liPrice;
    /**
     * 批发价
     */
    private String piPrice;
    /**
     * 浏览次数
     */
    private Long viewNum;
    /**
     * 常规属性
     */
    private List<CdnGoodsPropVO> normalAttrs;
    /**
     * 商品详情
     */
    private String descHtml;
    /**
     * 在售状态,true为在售，false已下架
     */
    private Boolean onSale;

    /**
     * 是否可线上购买
     */
    private Boolean onlineSale;

    /**
     * 档口ID
     */
    private Long shopId;
    /**
     * 分站
     */
    private String webSite;
    /**
     * 颜色
     */
    private String colorsMeta;
    /**
     * 尺码
     */
    private String sizesMeta;
    /**
     * 是否有原图
     */
    private String hasOriginalPic;
    /**
     * 面料成分
     */
    private String fabric;
    /**
     * 里料成分
     */
    private String inFabric;
    /**
     * 最低零售价
     */
    private String lowestLiPrice;
    /**
     * 主图视频地址
     */
    private String goodsVideoUrl;

    /**
     * 获取 商品ID
     */
    public Long getGoodsId() {
        return this.goodsId;
    }

    /**
     * 设置 商品ID
     */
    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    /**
     * 获取 主图6张,第一张为首图
     */
    public List<String> getImgUrls() {
        return this.imgUrls;
    }

    /**
     * 设置 主图6张,第一张为首图
     */
    public void setImgUrls(List<String> imgUrls) {
        this.imgUrls = imgUrls;
    }

    /**
     * 获取 商品服务类型, 1(可退)，2（可换），可以有的服务都传进来
     */
    public List<String> getServices() {
        return this.services;
    }

    /**
     * 设置 商品服务类型, 1(可退)，2（可换），可以有的服务都传进来
     */
    public void setServices(List<String> services) {
        this.services = services;
    }

    /**
     * 获取 商品货号
     */
    public String getGoodsNo() {
        return this.goodsNo;
    }

    /**
     * 设置 商品货号
     */
    public void setGoodsNo(String goodsNo) {
        this.goodsNo = goodsNo;
    }

    /**
     * 获取 	发布时间，格式（2017-02-22）
     */
    public String getPostTime() {
        return this.postTime;
    }

    /**
     * 设置 	发布时间，格式（2017-02-22）
     */
    public void setPostTime(String postTime) {
        this.postTime = postTime;
    }

    /**
     * 获取 零售价
     */
    public String getLiPrice() {
        return this.liPrice;
    }

    /**
     * 设置 零售价
     */
    public void setLiPrice(String liPrice) {
        this.liPrice = liPrice;
    }

    /**
     * 获取 批发价
     */
    public String getPiPrice() {
        return this.piPrice;
    }

    /**
     * 设置 批发价
     */
    public void setPiPrice(String piPrice) {
        this.piPrice = piPrice;
    }

    /**
     * 获取 浏览次数
     */
    public Long getViewNum() {
        return this.viewNum;
    }

    /**
     * 设置 浏览次数
     */
    public void setViewNum(Long viewNum) {
        this.viewNum = viewNum;
    }

    /**
     * 获取 常规属性
     */
    public List<CdnGoodsPropVO> getNormalAttrs() {
        return this.normalAttrs;
    }

    /**
     * 设置 常规属性
     */
    public void setNormalAttrs(List<CdnGoodsPropVO> normalAttrs) {
        this.normalAttrs = normalAttrs;
    }

    /**
     * 获取 商品详情
     */
    public String getDescHtml() {
        return this.descHtml;
    }

    /**
     * 设置 商品详情
     */
    public void setDescHtml(String descHtml) {
        this.descHtml = descHtml;
    }

    /**
     * 获取 在售状态,true为在售
     */
    public Boolean getOnSale() {
        return this.onSale;
    }

    /**
     * 设置 在售状态,true为在售
     */
    public void setOnSale(Boolean onSale) {
        this.onSale = onSale;
    }

    public Boolean getOnlineSale() {
        return onlineSale;
    }

    public void setOnlineSale(Boolean onlineSale) {
        this.onlineSale = onlineSale;
    }

    /**
     * 获取 档口ID
     */
    public Long getShopId() {
        return this.shopId;
    }

    /**
     * 设置 档口ID
     */
    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }

    /**
     * 获取 分站
     */
    public String getWebSite() {
        return this.webSite;
    }

    /**
     * 设置 分站
     */
    public void setWebSite(String webSite) {
        this.webSite = webSite;
    }

    /**
     * 获取 颜色
     */
    public String getColorsMeta() {
        return this.colorsMeta;
    }

    /**
     * 设置 颜色
     */
    public void setColorsMeta(String colorsMeta) {
        this.colorsMeta = colorsMeta;
    }

    /**
     * 获取 尺码
     */
    public String getSizesMeta() {
        return this.sizesMeta;
    }

    /**
     * 设置 尺码
     */
    public void setSizesMeta(String sizesMeta) {
        this.sizesMeta = sizesMeta;
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
     * 获取 淘宝商品ID
     */
    public Long getTbGoodsId() {
        return this.tbGoodsId;
    }

    /**
     * 设置 淘宝商品ID
     */
    public void setTbGoodsId(Long tbGoodsId) {
        this.tbGoodsId = tbGoodsId;
    }

    /**
     * 获取 是否有原图
     */
    public String getHasOriginalPic() {
        return this.hasOriginalPic;
    }

    /**
     * 设置 是否有原图
     */
    public void setHasOriginalPic(String hasOriginalPic) {
        this.hasOriginalPic = hasOriginalPic;
    }

    public String getFabric() {
        return fabric;
    }

    public void setFabric(String fabric) {
        this.fabric = fabric;
    }

    public String getInFabric() {
        return inFabric;
    }

    public void setInFabric(String inFabric) {
        this.inFabric = inFabric;
    }

    public String getLowestLiPrice() {
        return lowestLiPrice;
    }

    public void setLowestLiPrice(String lowestLiPrice) {
        this.lowestLiPrice = lowestLiPrice;
    }

    public String getGoodsVideoUrl() {
        return goodsVideoUrl;
    }

    public void setGoodsVideoUrl(String goodsVideoUrl) {
        this.goodsVideoUrl = goodsVideoUrl;
    }
}
