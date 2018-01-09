package com.shigu.main4.item.vo;

import com.shigu.main4.item.enums.ItemFrom;

import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 网站商品服务类
 * Created by zhaohongbo on 17/2/23.
 */
public class ShiguItem implements Serializable{
    /**
     * 淘宝类目ID
     */
    private Long cid;
    /**
     * 店内类目
     */
    private String sellerCids;
    /**
     * 商品属性
     */
    private String props;
    /**
     * 20000:3275069:品牌:盈讯;1753146:3485013:型号:F908;30606:112030:上市时间:2008年
     */
    private String propsName;
    /**
     * 用户自行输入的类目
     */
    private String inputPids;
    /**
     * 用户自行输入的子属性名和值
     */
    private String inputStr;
    /**
     * 商品主图
     */
    private String picUrl;
    /**
     * 商品数量
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
     * 发货城市
     */
    private String city;
    /**
     * 发货省
     */
    private String state;
    /**
     * 商品修改时间
     */
    private Date modified;
    /**
     * 商品5张描述图
     */
    private List<String> itemImgs;
    /**
     * 属性图
     */
    private List<ShiguPropImg> propImgs;
    /**
     * 商品来源
     */
    private ItemFrom itemFrom;
    /**
     * 淘宝商品ID
     */
    private Long numIid;
    /**
     * 标题
     */
    private String title;
    /**
     * 商品详情
     */
    private String desc;
    /**
     * sku信息
     */
    private List<ShiguSku> skus;
    /**
     * 创建时间
     */
    private Date created;
    /**
     * 属性别名
     */
    private String propertyAlias;
    /**
     * 商品的重量，用于按重量计费的运费模板。注意：单位为kg
     */
    private String itemWeight;
    /**
     * 表示商品的体积，用于按体积计费的运费模板。该值的单位为立方米（m3）。该值支持两种格式的设置：格式1：bulk:3,单位为立方米(m3),表示直接设置为商品的体积。格式2：weight:10;breadth:10;height:10，单位为米（m）
     */
    private String itemSize;
    /**
     * 卖点
     */
    private String sellPoint;
    /**
     * 商家外部编号
     */
    private String outerId;
    /**
     * 无线宝贝描述
     */
    private String wirelessDesc;
    /**
     * 店铺ID
     */
    private Long shopId;

    public Long getShopId() {
        return shopId;
    }

    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }

    public Long getCid() {
        return cid;
    }

    public void setCid(Long cid) {
        this.cid = cid;
    }

    public String getSellerCids() {
        return sellerCids;
    }

    public void setSellerCids(String sellerCids) {
        this.sellerCids = sellerCids;
    }

    public String getProps() {
        return props;
    }

    public void setProps(String props) {
        this.props = props;
    }

    public String getPropsName() {
        return propsName;
    }

    public void setPropsName(String propsName) {
        this.propsName = propsName;
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

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Date getModified() {
        return modified;
    }

    public void setModified(Date modified) {
        this.modified = modified;
    }

    public List<String> getItemImgs() {
        return itemImgs;
    }

    public void setItemImgs(List<String> itemImgs) {
        this.itemImgs = itemImgs;
    }

    public List<ShiguPropImg> getPropImgs() {
        return propImgs;
    }

    public void setPropImgs(List<ShiguPropImg> propImgs) {
        this.propImgs = propImgs;
    }

    public ItemFrom getItemFrom() {
        return itemFrom;
    }

    public void setItemFrom(ItemFrom itemFrom) {
        this.itemFrom = itemFrom;
    }

    public Long getNumIid() {
        return numIid;
    }

    public void setNumIid(Long numIid) {
        this.numIid = numIid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public List<ShiguSku> getSkus() {
        return skus;
    }

    public void setSkus(List<ShiguSku> skus) {
        this.skus = skus;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public String getPropertyAlias() {
        return propertyAlias;
    }

    public void setPropertyAlias(String propertyAlias) {
        this.propertyAlias = propertyAlias;
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

    public String getSellPoint() {
        return sellPoint;
    }

    public void setSellPoint(String sellPoint) {
        this.sellPoint = sellPoint;
    }

    public String getOuterId() {
        return outerId;
    }

    public void setOuterId(String outerId) {
        this.outerId = outerId;
    }

    public String getWirelessDesc() {
        return wirelessDesc;
    }

    public void setWirelessDesc(String wirelessDesc) {
        this.wirelessDesc = wirelessDesc;
    }
}
