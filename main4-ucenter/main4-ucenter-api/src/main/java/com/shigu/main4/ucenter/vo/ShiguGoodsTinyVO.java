package com.shigu.main4.ucenter.vo;


import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;
import java.util.Date;


public class ShiguGoodsTinyVO implements Serializable {

    private String error="OK";//成功就是OK


    private Long goodsId;

    private String title;
    private String nick;
    private String type;
    private Date created;
    private String isLightningConsignment;

    private String isXinpin;
    private Long validThru;
    private String outerId;
    private Long cid;
    private String cidAll;
    private String cname;//类目名

    private String picUrl;
    private Long num;
    private Date listTime;
    private Date delistTime;
    private String stuffStatus;
    private String city;
    private String prov;
    private String priceString;
    private Long price;
    private Long piPrice;
    private String piPriceString;
    private String postFee;
    private String expressFee;
    private String emsFee;
    private String hasDiscount;
    private String freightPayer;
    private String hasShowcase;
    private Date modified;
    private Long marketId;

    private Long parentMarketId;

    private String storeNum;

    private Long storeId;
    private Long clicks;
    private Long isClosed;
    private Integer goodsStatus;
    private String goodsNo;
    private Long sortOrder;
    private Long inStoreSortOrder;
    private String webSite;
    private Date loadDate;

    private Integer isStandard;

    private Integer isExcelImp;

    private Boolean hasAdded=false;

    public Boolean getHasAdded() {
        return hasAdded;
    }

    public void setHasAdded(Boolean hasAdded) {
        this.hasAdded = hasAdded;
    }

    private ShiguGoodsExtendsVO extendsGoods;

    public ShiguGoodsExtendsVO getExtendsGoods () {
        return extendsGoods;
    }

    public void setExtendsGoods (ShiguGoodsExtendsVO extendsGoods) {
        this.extendsGoods = extendsGoods;
    }

    public String getError () {
        return error;
    }

    public void setError (String error) {
        this.error = error;
    }

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public String getIsLightningConsignment() {
        return isLightningConsignment;
    }

    public void setIsLightningConsignment(String isLightningConsignment) {
        this.isLightningConsignment = isLightningConsignment;
    }

    public String getCidAll () {
        return cidAll;
    }

    public void setCidAll (String cidAll) {
        this.cidAll = cidAll;
    }

    public String getIsXinpin() {
        return isXinpin;
    }

    public void setIsXinpin(String isXinpin) {
        this.isXinpin = isXinpin;
    }

    public Long getValidThru() {
        return validThru;
    }

    public void setValidThru(Long validThru) {
        this.validThru = validThru;
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

    public String getCname () {
        return cname;
    }

    public void setCname (String cname) {
        this.cname = cname;
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

    public String getStuffStatus() {
        return stuffStatus;
    }

    public void setStuffStatus(String stuffStatus) {
        this.stuffStatus = stuffStatus;
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

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Long getPiPrice() {
        return piPrice;
    }

    public void setPiPrice(Long piPrice) {
        this.piPrice = piPrice;
    }

    public String getPiPriceString() {
        return piPriceString;
    }

    public void setPiPriceString(String piPriceString) {
        this.piPriceString = piPriceString;
    }

    public String getPostFee() {
        return postFee;
    }

    public void setPostFee(String postFee) {
        this.postFee = postFee;
    }

    public String getExpressFee() {
        return expressFee;
    }

    public void setExpressFee(String expressFee) {
        this.expressFee = expressFee;
    }

    public String getEmsFee() {
        return emsFee;
    }

    public void setEmsFee(String emsFee) {
        this.emsFee = emsFee;
    }

    public String getHasDiscount() {
        return hasDiscount;
    }

    public void setHasDiscount(String hasDiscount) {
        this.hasDiscount = hasDiscount;
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

    public Long getMarketId() {
        return marketId;
    }

    public void setMarketId(Long marketId) {
        this.marketId = marketId;
    }


    public Long getParentMarketId() {
        return parentMarketId;
    }

    public void setParentMarketId(Long parentMarketId) {
        this.parentMarketId = parentMarketId;
    }

    public String getStoreNum() {
        return storeNum;
    }

    public void setStoreNum(String storeNum) {
        this.storeNum = storeNum;
    }

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

    public Long getClicks() {
        return clicks;
    }

    public void setClicks(Long clicks) {
        this.clicks = clicks;
    }

    public Long getIsClosed() {
        return isClosed;
    }

    public void setIsClosed(Long isClosed) {
        this.isClosed = isClosed;
    }

    public Integer getGoodsStatus() {
        return goodsStatus;
    }

    public void setGoodsStatus(Integer goodsStatus) {
        this.goodsStatus = goodsStatus;
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

    public Long getInStoreSortOrder() {
        return inStoreSortOrder;
    }

    public void setInStoreSortOrder(Long inStoreSortOrder) {
        this.inStoreSortOrder = inStoreSortOrder;
    }

    public String getWebSite() {
        return webSite;
    }

    public void setWebSite(String webSite) {
        this.webSite = webSite;
    }

    public Date getLoadDate() {
        return loadDate;
    }

    public void setLoadDate(Date loadDate) {
        this.loadDate = loadDate;
    }

    public Integer getIsStandard() {
        return isStandard;
    }

    public void setIsStandard(Integer isStandard) {
        this.isStandard = isStandard;
    }

    public Integer getIsExcelImp() {
        return isExcelImp;
    }

    public void setIsExcelImp(Integer isExcelImp) {
        this.isExcelImp = isExcelImp;
    }


}
