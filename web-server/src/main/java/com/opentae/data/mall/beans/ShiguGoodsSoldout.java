package com.opentae.data.mall.beans;

import com.opentae.common.beans.MoreSiteBean;

import org.apache.commons.lang3.StringUtils;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * 下架商品
 *
 */
public class ShiguGoodsSoldout extends MoreSiteBean {

    private static final long serialVersionUID = -2054349009419695808L;
    @Id
    @GeneratedValue(
        generator = "JDBC"
    )
    private Long goodsId;
    private Long numIid;
    private String detailUrl;
    private String title;
    private String nick;
    private String type;
    private Date created;
    private String isLightningConsignment;
    private Long isFenxiao;
    private String isXinpin;
    private Long validThru;
    private String outerId;
    private Long cid;
    private String cidAll;
    private String picUrl;
    private Long num;
    @Column(name="sold_out_time")
    @Deprecated
    private Date soldOutTime;
    private Date listTime;
    private Date delistTime;
    private String stuffStatus;
    private String city;
    private String prov;
    private String priceString;
    private Long price;
    private Long piPrice;
    private String piPriceString;
    private String priceRole;
    private String postFee;
    private String expressFee;
    private String emsFee;
    private String hasDiscount;
    private String freightPayer;
    private String hasShowcase;
    private Date modified;
    private Long marketId;
    private String market;
    private Long parentMarketId;
    private String parentMarketName;
    private String storeNum;
    private Long isTaobaoSynchronization;
    private Long isAkeyToUpload;
    private Long isTrade;
    private Long isEfficacious;
    private Long storeId;
    private Long clicks;
    private Long isClosed;
    private Integer goodsStatus;
    private String goodsNo;
    private Long sortOrder;
    private Long numberTradableGoods;
    private Long notNumberTradableGoods;
    private String webSite;
    private String remark10;
    private String remark9;
    private String remark8;
    private String remark7;
    private String remark6;
    private String remark5;
    private String remark4;
    private String remark3;
    private String remark1;
    private String remark2;

    /**
     * 原因
     */
    private String soldoutReason;
    @Column(name="soldout_time")
    private Date soldoutTime;

    private Long soldUserId;

    private Integer isExcelImp;
    private Integer isStandard;

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
        if(StringUtils.isNotBlank(title)){
            title= KeyWordsUtil.duleKeyWords(title);
        }
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

    public Long getIsFenxiao() {
        return isFenxiao;
    }

    public void setIsFenxiao(Long isFenxiao) {
        this.isFenxiao = isFenxiao;
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

    @Deprecated
    public Date getSoldOutTime() {
        return soldOutTime;
    }

    @Deprecated
    public void setSoldOutTime(Date soldOutTime) {
        this.setSoldoutTime(soldOutTime);
//        this.soldOutTime = soldOutTime;
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

    public String getPriceRole() {
        return priceRole;
    }

    public void setPriceRole(String priceRole) {
        this.priceRole = priceRole;
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

    public String getMarket() {
        return market;
    }

    public void setMarket(String market) {
        this.market = market;
    }

    public Long getParentMarketId() {
        return parentMarketId;
    }

    public void setParentMarketId(Long parentMarketId) {
        this.parentMarketId = parentMarketId;
    }

    public String getParentMarketName() {
        return parentMarketName;
    }

    public void setParentMarketName(String parentMarketName) {
        this.parentMarketName = parentMarketName;
    }

    public String getStoreNum() {
        return storeNum;
    }

    public void setStoreNum(String storeNum) {
        this.storeNum = storeNum;
    }

    public Long getIsTaobaoSynchronization() {
        return isTaobaoSynchronization;
    }

    public void setIsTaobaoSynchronization(Long isTaobaoSynchronization) {
        this.isTaobaoSynchronization = isTaobaoSynchronization;
    }

    public Long getIsAkeyToUpload() {
        return isAkeyToUpload;
    }

    public void setIsAkeyToUpload(Long isAkeyToUpload) {
        this.isAkeyToUpload = isAkeyToUpload;
    }

    public Long getIsTrade() {
        return isTrade;
    }

    public void setIsTrade(Long isTrade) {
        this.isTrade = isTrade;
    }

    public Long getIsEfficacious() {
        return isEfficacious;
    }

    public void setIsEfficacious(Long isEfficacious) {
        this.isEfficacious = isEfficacious;
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

    public Long getNumberTradableGoods() {
        return numberTradableGoods;
    }

    public void setNumberTradableGoods(Long numberTradableGoods) {
        this.numberTradableGoods = numberTradableGoods;
    }

    public Long getNotNumberTradableGoods() {
        return notNumberTradableGoods;
    }

    public void setNotNumberTradableGoods(Long notNumberTradableGoods) {
        this.notNumberTradableGoods = notNumberTradableGoods;
    }

    public String getWebSite() {
        return webSite;
    }

    public void setWebSite(String webSite) {
        this.webSite = webSite;
    }

    public String getRemark10() {
        return remark10;
    }

    public void setRemark10(String remark10) {
        this.remark10 = remark10;
    }

    public String getRemark9() {
        return remark9;
    }

    public void setRemark9(String remark9) {
        this.remark9 = remark9;
    }

    public String getRemark8() {
        return remark8;
    }

    public void setRemark8(String remark8) {
        this.remark8 = remark8;
    }

    public String getRemark7() {
        return remark7;
    }

    public void setRemark7(String remark7) {
        this.remark7 = remark7;
    }

    public String getRemark6() {
        return remark6;
    }

    public void setRemark6(String remark6) {
        this.remark6 = remark6;
    }

    public String getRemark5() {
        return remark5;
    }

    public void setRemark5(String remark5) {
        this.remark5 = remark5;
    }

    public String getRemark4() {
        return remark4;
    }

    public void setRemark4(String remark4) {
        this.remark4 = remark4;
    }

    public String getRemark3() {
        return remark3;
    }

    public void setRemark3(String remark3) {
        this.remark3 = remark3;
    }

    public String getRemark1() {
        return remark1;
    }

    public void setRemark1(String remark1) {
        this.remark1 = remark1;
    }

    public String getRemark2() {
        return remark2;
    }

    public void setRemark2(String remark2) {
        this.remark2 = remark2;
    }

    public String getSoldoutReason() {
        return soldoutReason;
    }

    public void setSoldoutReason(String soldoutReason) {
        this.soldoutReason = soldoutReason;
    }

    public Date getSoldoutTime() {
        return soldoutTime;
    }

    public void setSoldoutTime(Date soldoutTime) {
        this.soldoutTime = soldoutTime;
    }

    public Long getSoldUserId() {
        return soldUserId;
    }

    public void setSoldUserId(Long soldUserId) {
        this.soldUserId = soldUserId;
    }

    public Integer getIsExcelImp() {
        return isExcelImp;
    }

    public void setIsExcelImp(Integer isExcelImp) {
        this.isExcelImp = isExcelImp;
    }

    public Integer getIsStandard() {
        return isStandard;
    }

    public void setIsStandard(Integer isStandard) {
        this.isStandard = isStandard;
    }
}
