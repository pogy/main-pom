package com.shigu.main4.item.vo;

import com.shigu.main4.item.enums.ItemFrom;

import java.io.Serializable;
import java.util.List;

/**
 * 给显示商品详情页面用的对象
 * Created by zhaohongbo on 17/2/16.
 */
public class CdnItem implements Serializable{

    private static final long serialVersionUID = 8783778989291726942L;
    /**
     * 标题
     */
    private String title;
    /**
     * 商品5张图,第1张首图,第6张长图
     */
    private List<String> imgUrl;
    /**
     * 尺码
     */
    private List<SaleProp> sizes;
    /**
     * 颜色
     */
    private List<SaleProp> colors;
    /**
     * 一般属性
     */
    private List<NormalProp> normalProps;
    /**
     * 店铺ID
     */
    private Long shopId;
    /**
     * 如果商品是淘宝来的,此处有淘宝的numIid
     */
    private Long tbNumIid;
    /**
     * 商品来源
     */
    private ItemFrom itemFrom;
    /**
     * 商品详情
     */
    private String description;
    /**
     * 上架时间,yyyy-MM-dd格式,暂时查created
     */
    private String listTime;
    /**
     * 发货地,prov city
     */
    private String sendFrom;
    /**
     * 货号
     */
    private String huohao;
    /**
     * 市场ID
     */
    private Long marketId;
    /**
     * 楼层ID
     */
    private Long floorId;
    /**
     * 价格
     */
    private String price;
    /**
     * 批发价
     */
    private String piPrice;

    private Long num;
    /**
     * 分站标识
     */
    private String webSite;
    /**
     * 在售状态,true为在售
     */
    private Boolean onsale;
    /**
     * 子类目Id
     */
    private Long cid;
    /**
     * 面料成分
     */
    private String fabric;
    /**
     * 里料成分
     */
    private String inFabric;
    /**
     * 视频链接地址
     */
    private String goodsVideoUrl;

    public Boolean getOnsale() {
        return onsale;
    }

    public void setOnsale(Boolean onsale) {
        this.onsale = onsale;
    }

    public String getWebSite() {
        return webSite;
    }

    public void setWebSite(String webSite) {
        this.webSite = webSite;
    }

    public String getHuohao() {
        return huohao;
    }

    public void setHuohao(String huohao) {
        this.huohao = huohao;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getPiPrice() {
        return piPrice;
    }

    public void setPiPrice(String piPrice) {
        this.piPrice = piPrice;
    }

    public Long getMarketId() {
        return marketId;
    }

    public void setMarketId(Long marketId) {
        this.marketId = marketId;
    }

    public String getListTime() {
        return listTime;
    }

    public void setListTime(String listTime) {
        this.listTime = listTime;
    }

    public String getSendFrom() {
        return sendFrom;
    }

    public void setSendFrom(String sendFrom) {
        this.sendFrom = sendFrom;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<String> getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(List<String> imgUrl) {
        this.imgUrl = imgUrl;
    }

    public List<SaleProp> getSizes() {
        return sizes;
    }

    public void setSizes(List<SaleProp> sizes) {
        this.sizes = sizes;
    }

    public List<SaleProp> getColors() {
        return colors;
    }

    public void setColors(List<SaleProp> colors) {
        this.colors = colors;
    }

    public List<NormalProp> getNormalProps() {
        return normalProps;
    }

    public void setNormalProps(List<NormalProp> normalProps) {
        this.normalProps = normalProps;
    }

    public Long getShopId() {
        return shopId;
    }

    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }

    public Long getTbNumIid() {
        return tbNumIid;
    }

    public void setTbNumIid(Long tbNumIid) {
        this.tbNumIid = tbNumIid;
    }

    public ItemFrom getItemFrom() {
        return itemFrom;
    }

    public void setItemFrom(ItemFrom itemFrom) {
        this.itemFrom = itemFrom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getNum() {
        return num;
    }

    public void setNum(Long num) {
        this.num = num;
    }

    public Long getFloorId() {
        return floorId;
    }

    public void setFloorId(Long floorId) {
        this.floorId = floorId;
    }

    public Long getCid() {
        return cid;
    }

    public void setCid(Long cid) {
        this.cid = cid;
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

    public String getGoodsVideoUrl() {
        return goodsVideoUrl;
    }

    public void setGoodsVideoUrl(String goodsVideoUrl) {
        this.goodsVideoUrl = goodsVideoUrl;
    }
}
