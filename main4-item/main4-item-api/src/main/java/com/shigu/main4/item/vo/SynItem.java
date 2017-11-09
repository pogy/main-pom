package com.shigu.main4.item.vo;

import com.shigu.main4.item.enums.ItemFrom;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 同步商品
 * Created by zhaohongbo on 17/2/25.
 */
public class SynItem implements Serializable{
    /**
     * 星座网商品ID
     */
    private Long goodsId;
    /**
     * 淘宝商品NumIid
     */
    private Long numIid;
    /**
     * 原宝贝链接
     */
    private String detailUrl;
    /**
     * 商品标题,不能超过60字节
     */
    private String title;
    /**
     * 创建时间
     */
    private Date created;
    /**
     * 商家外部编号
     */
    private String outerId;
    /**
     * 淘宝叶子类目ID
     */
    private Long cid;
    /**
     * 商家编号
     */
    private String cidAll;
    /**
     * 商品主图
     */
    private String picUrl;
    /**
     * 商品总量
     */
    private Long num;
    /**
     * 上架时间
     */
    private Date listTime;
    /**
     * 下架时间
     */
    private Date delistTime;
    /**
     * 所在城市
     */
    private String city;
    /**
     * 所在省份
     */
    private String prov;
    /**
     * 价格
     */
    private String priceString;
    /**
     * 批发价
     */
    private String piPriceString;
    /**
     * 淘宝中邮费承担方式
     */
    private String freightPayer;
    /**
     * 淘宝中,橱窗推荐@true/false
     */
    private String hasShowcase;
    /**
     * 修改时间
     */
    private Date modified;
    /**
     * 店铺ID
     */
    private Long shopId;
    /**
     * 市场ID
     */
    private Long marketId;
    /**
     * 楼层ID
     */
    private Long floorId;
    /**
     * 分站标识
     */
    private String webSite;
    /**
     * 货号
     */
    private String goodsNo;
    /**
     * 是否在售,true代表在售,false代表没在售
     */
    private Boolean onsale;
    /**
     * 商品详情
     */
    private String goodsDesc;
    /**
     * 商品属性键值
     */
    private String propsName;
    /**
     * 商品属性别名
     */
    private String propertyAlias;
    /**
     * 商品属性ID串
     */
    private String props;
    /**
     * 自定义pid串
     */
    private String inputPids;
    /**
     * 自定义值串
     */
    private String inputStr;
    /**
     * 商品的重量@用于按重量计费的运费模板。注意：单位为kg
     */
    private String itemWeight;
    /**
     * 商品的体积@用于按体积计费的运费模板。
     */
    private String itemSize;
    /**
     * 无线的宝贝描述
     */
    private String wirelessDesc;
    /**
     * 五张图
     */
    private List<String> imageList;
    /**
     * 卖点
     */
    private String sellPoint;
    /**
     * 商品prop,带图部分
     */
    private List<ShiguPropImg> propImgs;
    /**
     * 商品来源
     */
    private ItemFrom itemFrom;

    /**
     * 排序权重
     */
    private Long sortOrder;

    /**
     * 面料 用于手工发布，手工发布时必填
     */
    private String fabric;

    /**
     * 里料 用于手工发布
     */
    private String inFabric;

    public ItemFrom getItemFrom() {
        return itemFrom;
    }

    public void setItemFrom(ItemFrom itemFrom) {
        this.itemFrom = itemFrom;
    }

    public Boolean isOnsale() {
        return onsale;
    }

    public void setOnsale(Boolean onsale) {
        this.onsale = onsale;
    }

    public String getGoodsDesc() {
        return goodsDesc;
    }

    public void setGoodsDesc(String goodsDesc) {
        this.goodsDesc = goodsDesc;
    }

    public String getPropsName() {
        return propsName;
    }

    public void setPropsName(String propsName) {
        this.propsName = propsName;
    }

    public String getPropertyAlias() {
        return propertyAlias;
    }

    public void setPropertyAlias(String propertyAlias) {
        this.propertyAlias = propertyAlias;
    }

    public String getProps() {
        return props;
    }

    public void setProps(String props) {
        this.props = props;
    }

    public String getInputPids() {
        return inputPids;
    }

    public void setInputPids(String inputPids) {
        this.inputPids = inputPids;
    }

    public String getInputStr() {
        return inputStr;
    }

    public void setInputStr(String inputStr) {
        this.inputStr = inputStr;
    }

    public String getItemWeight() {
        return itemWeight;
    }

    public void setItemWeight(String itemWeight) {
        this.itemWeight = itemWeight;
    }

    public String getItemSize() {
        return itemSize;
    }

    public void setItemSize(String itemSize) {
        this.itemSize = itemSize;
    }

    public String getWirelessDesc() {
        return wirelessDesc;
    }

    public void setWirelessDesc(String wirelessDesc) {
        this.wirelessDesc = wirelessDesc;
    }

    public List<String> getImageList() {
        return imageList;
    }

    public void setImageList(List<String> imageList) {
        this.imageList = imageList;
    }

    public String getSellPoint() {
        return sellPoint;
    }

    public void setSellPoint(String sellPoint) {
        this.sellPoint = sellPoint;
    }

    public List<ShiguPropImg> getPropImgs() {
        return propImgs;
    }

    public void setPropImgs(List<ShiguPropImg> propImgs) {
        this.propImgs = propImgs;
    }

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public Long getNumIid() {
        return numIid;
    }

    public void setNumIid(Long numIid) {
        this.numIid = numIid;
    }

    public String getDetailUrl() {
        return detailUrl;
    }

    public void setDetailUrl(String detailUrl) {
        this.detailUrl = detailUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public String getOuterId() {
        return outerId;
    }

    public void setOuterId(String outerId) {
        this.outerId = outerId;
    }

    public Long getCid() {
        return cid;
    }

    public void setCid(Long cid) {
        this.cid = cid;
    }

    public String getCidAll() {
        return cidAll;
    }

    public void setCidAll(String cidAll) {
        this.cidAll = cidAll;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public Long getNum() {
        return num;
    }

    public void setNum(Long num) {
        this.num = num;
    }

    public Date getListTime() {
        return listTime;
    }

    public void setListTime(Date listTime) {
        this.listTime = listTime;
    }

    public Date getDelistTime() {
        return delistTime;
    }

    public void setDelistTime(Date delistTime) {
        this.delistTime = delistTime;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProv() {
        return prov;
    }

    public void setProv(String prov) {
        this.prov = prov;
    }

    public String getPriceString() {
        return priceString;
    }

    public void setPriceString(String priceString) {
        this.priceString = priceString;
    }

    public String getPiPriceString() {
        return piPriceString;
    }

    public void setPiPriceString(String piPriceString) {
        this.piPriceString = piPriceString;
    }

    public String getFreightPayer() {
        return freightPayer;
    }

    public void setFreightPayer(String freightPayer) {
        this.freightPayer = freightPayer;
    }

    public String getHasShowcase() {
        return hasShowcase;
    }

    public void setHasShowcase(String hasShowcase) {
        this.hasShowcase = hasShowcase;
    }

    public Date getModified() {
        return modified;
    }

    public void setModified(Date modified) {
        this.modified = modified;
    }

    public Long getShopId() {
        return shopId;
    }

    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }

    public Long getMarketId() {
        return marketId;
    }

    public void setMarketId(Long marketId) {
        this.marketId = marketId;
    }

    public Long getFloorId() {
        return floorId;
    }

    public void setFloorId(Long floorId) {
        this.floorId = floorId;
    }

    public String getWebSite() {
        return webSite;
    }

    public void setWebSite(String webSite) {
        this.webSite = webSite;
    }

    public String getGoodsNo() {
        return goodsNo;
    }

    public void setGoodsNo(String goodsNo) {
        this.goodsNo = goodsNo;
    }

    public Long getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(Long sortOrder) {
        this.sortOrder = sortOrder;
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
}
