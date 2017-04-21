package com.opentae.data.mall.beans;

import com.opentae.common.beans.MoreSiteBean;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.Date;

/**
 * 店铺
 * @author shigu_zjb
 * @date 2017-02-09 11:17
 * @(C) shigu Copyright
 */
@Deprecated
public class ShiguStore extends MoreSiteBean{
    @Transient
    private static final long serialVersionUID = 7855888495556954230L;
    @Id
    @GeneratedValue(
            generator = "JDBC"
    )
    private Long storeId;
    private String storeName;
    private String taobaoUrl;
    private String mainBus;
    private String nick;
    private Long buycityId;
    private Long marketId;
    private String market;
    private Long parentMarketId;
    private String parentMarket;
    private Long todayGoodsnum;
    private Date lastGoodsDate;
    private String priceRole;
    private String storeNum;
    private String address;
    private String zipcode;
    private String telephone;
    private String phone;
    private String imQq;
    private String imAliww;
    private String infoFrom;
    private String servers;
    private String domain;
    private String storeErwei;
    private String phoneErwei;
    private String pcErwei;
    private Long userId;
    private String userName;
    private Integer useStatus;
    private String noCheckReason;
    private Date bindTime;
    private Integer bindStatus;
    private Long visitSum;
    private Integer storeStatus;
    private String closeReason;
    private Date createDate;
    private Date endDate;
    private Long sortOrder;
    private Long taobaoShopId;
    private Long taobaoUserId;
    private String taobaoKey;
    private String taobaoSec;
    private String taobaoSession;
    private String taobaoNice;
    private String ownerName;
    private String ownerCard;
    private Integer storeModel;
    private String packetUrl;
    private String remark1;
    private String remark2;
    private String remark3;
    private String remark4;
    private String remark5;
    private String remark6;
    private String remark7;
    private String remark8;
    private String remark9;
    private String remark10;
    private String remark11;
    private String remark12;
    private String remark13;
    private String remark14;
    private String remark15;
    private String remark16;
    private String remark17;
    private String remark18;
    private String remark19;
    private String remark20;
    private String idCardImg;
    private String businessLicenseImg;
    private String contractOfTenancyImg;
    private String priceMatcherRule;
    private Long starNum;
    private Date lastModifyTime;

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getTaobaoUrl() {
        return taobaoUrl;
    }

    public void setTaobaoUrl(String taobaoUrl) {
        this.taobaoUrl = taobaoUrl;
    }

    public String getMainBus() {
        return mainBus;
    }

    public void setMainBus(String mainBus) {
        this.mainBus = mainBus;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public Long getBuycityId() {
        return buycityId;
    }

    public void setBuycityId(Long buycityId) {
        this.buycityId = buycityId;
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

    public String getParentMarket() {
        return parentMarket;
    }

    public void setParentMarket(String parentMarket) {
        this.parentMarket = parentMarket;
    }

    public Long getTodayGoodsnum() {
        return todayGoodsnum;
    }

    public void setTodayGoodsnum(Long todayGoodsnum) {
        this.todayGoodsnum = todayGoodsnum;
    }

    public Date getLastGoodsDate() {
        return lastGoodsDate;
    }

    public void setLastGoodsDate(Date lastGoodsDate) {
        this.lastGoodsDate = lastGoodsDate;
    }

    public String getPriceRole() {
        return priceRole;
    }

    public void setPriceRole(String priceRole) {
        this.priceRole = priceRole;
    }

    public String getStoreNum() {
        return storeNum;
    }

    public void setStoreNum(String storeNum) {
        this.storeNum = storeNum;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getImQq() {
        return imQq;
    }

    public void setImQq(String imQq) {
        this.imQq = imQq;
    }

    public String getImAliww() {
        return imAliww;
    }

    public void setImAliww(String imAliww) {
        this.imAliww = imAliww;
    }

    public String getInfoFrom() {
        return infoFrom;
    }

    public void setInfoFrom(String infoFrom) {
        this.infoFrom = infoFrom;
    }

    public String getServers() {
        return servers;
    }

    public void setServers(String servers) {
        this.servers = servers;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getStoreErwei() {
        return storeErwei;
    }

    public void setStoreErwei(String storeErwei) {
        this.storeErwei = storeErwei;
    }

    public String getPhoneErwei() {
        return phoneErwei;
    }

    public void setPhoneErwei(String phoneErwei) {
        this.phoneErwei = phoneErwei;
    }

    public String getPcErwei() {
        return pcErwei;
    }

    public void setPcErwei(String pcErwei) {
        this.pcErwei = pcErwei;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getUseStatus() {
        return useStatus;
    }

    public void setUseStatus(Integer useStatus) {
        this.useStatus = useStatus;
    }

    public String getNoCheckReason() {
        return noCheckReason;
    }

    public void setNoCheckReason(String noCheckReason) {
        this.noCheckReason = noCheckReason;
    }

    public Date getBindTime() {
        return bindTime;
    }

    public void setBindTime(Date bindTime) {
        this.bindTime = bindTime;
    }

    public Integer getBindStatus() {
        return bindStatus;
    }

    public void setBindStatus(Integer bindStatus) {
        this.bindStatus = bindStatus;
    }

    public Long getVisitSum() {
        return visitSum;
    }

    public void setVisitSum(Long visitSum) {
        this.visitSum = visitSum;
    }

    public Integer getStoreStatus() {
        return storeStatus;
    }

    public void setStoreStatus(Integer storeStatus) {
        this.storeStatus = storeStatus;
    }

    public String getCloseReason() {
        return closeReason;
    }

    public void setCloseReason(String closeReason) {
        this.closeReason = closeReason;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Long getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(Long sortOrder) {
        this.sortOrder = sortOrder;
    }

    public Long getTaobaoShopId() {
        return taobaoShopId;
    }

    public void setTaobaoShopId(Long taobaoShopId) {
        this.taobaoShopId = taobaoShopId;
    }

    public Long getTaobaoUserId() {
        return taobaoUserId;
    }

    public void setTaobaoUserId(Long taobaoUserId) {
        this.taobaoUserId = taobaoUserId;
    }

    public String getTaobaoKey() {
        return taobaoKey;
    }

    public void setTaobaoKey(String taobaoKey) {
        this.taobaoKey = taobaoKey;
    }

    public String getTaobaoSec() {
        return taobaoSec;
    }

    public void setTaobaoSec(String taobaoSec) {
        this.taobaoSec = taobaoSec;
    }

    public String getTaobaoSession() {
        return taobaoSession;
    }

    public void setTaobaoSession(String taobaoSession) {
        this.taobaoSession = taobaoSession;
    }

    public String getTaobaoNice() {
        return taobaoNice;
    }

    public void setTaobaoNice(String taobaoNice) {
        this.taobaoNice = taobaoNice;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getOwnerCard() {
        return ownerCard;
    }

    public void setOwnerCard(String ownerCard) {
        this.ownerCard = ownerCard;
    }

    public Integer getStoreModel() {
        return storeModel;
    }

    public void setStoreModel(Integer storeModel) {
        this.storeModel = storeModel;
    }

    public String getPacketUrl() {
        return packetUrl;
    }

    public void setPacketUrl(String packetUrl) {
        this.packetUrl = packetUrl;
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

    public String getRemark3() {
        return remark3;
    }

    public void setRemark3(String remark3) {
        this.remark3 = remark3;
    }

    public String getRemark4() {
        return remark4;
    }

    public void setRemark4(String remark4) {
        this.remark4 = remark4;
    }

    public String getRemark5() {
        return remark5;
    }

    public void setRemark5(String remark5) {
        this.remark5 = remark5;
    }

    public String getRemark6() {
        return remark6;
    }

    public void setRemark6(String remark6) {
        this.remark6 = remark6;
    }

    public String getRemark7() {
        return remark7;
    }

    public void setRemark7(String remark7) {
        this.remark7 = remark7;
    }

    public String getRemark8() {
        return remark8;
    }

    public void setRemark8(String remark8) {
        this.remark8 = remark8;
    }

    public String getRemark9() {
        return remark9;
    }

    public void setRemark9(String remark9) {
        this.remark9 = remark9;
    }

    public String getRemark10() {
        return remark10;
    }

    public void setRemark10(String remark10) {
        this.remark10 = remark10;
    }

    public String getRemark11() {
        return remark11;
    }

    public void setRemark11(String remark11) {
        this.remark11 = remark11;
    }

    public String getRemark12() {
        return remark12;
    }

    public void setRemark12(String remark12) {
        this.remark12 = remark12;
    }

    public String getRemark13() {
        return remark13;
    }

    public void setRemark13(String remark13) {
        this.remark13 = remark13;
    }

    public String getRemark14() {
        return remark14;
    }

    public void setRemark14(String remark14) {
        this.remark14 = remark14;
    }

    public String getRemark15() {
        return remark15;
    }

    public void setRemark15(String remark15) {
        this.remark15 = remark15;
    }

    public String getRemark16() {
        return remark16;
    }

    public void setRemark16(String remark16) {
        this.remark16 = remark16;
    }

    public String getRemark17() {
        return remark17;
    }

    public void setRemark17(String remark17) {
        this.remark17 = remark17;
    }

    public String getRemark18() {
        return remark18;
    }

    public void setRemark18(String remark18) {
        this.remark18 = remark18;
    }

    public String getRemark19() {
        return remark19;
    }

    public void setRemark19(String remark19) {
        this.remark19 = remark19;
    }

    public String getRemark20() {
        return remark20;
    }

    public void setRemark20(String remark20) {
        this.remark20 = remark20;
    }

    public String getIdCardImg() {
        return idCardImg;
    }

    public void setIdCardImg(String idCardImg) {
        this.idCardImg = idCardImg;
    }

    public String getBusinessLicenseImg() {
        return businessLicenseImg;
    }

    public void setBusinessLicenseImg(String businessLicenseImg) {
        this.businessLicenseImg = businessLicenseImg;
    }

    public String getContractOfTenancyImg() {
        return contractOfTenancyImg;
    }

    public void setContractOfTenancyImg(String contractOfTenancyImg) {
        this.contractOfTenancyImg = contractOfTenancyImg;
    }

    public String getPriceMatcherRule() {
        return priceMatcherRule;
    }

    public void setPriceMatcherRule(String priceMatcherRule) {
        this.priceMatcherRule = priceMatcherRule;
    }

    public Long getStarNum() {
        return starNum;
    }

    public void setStarNum(Long starNum) {
        this.starNum = starNum;
    }

    public Date getLastModifyTime() {
        return lastModifyTime;
    }

    public void setLastModifyTime(Date lastModifyTime) {
        this.lastModifyTime = lastModifyTime;
    }
}