package com.opentae.data.mall.beans;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

public class ShiguShop implements Serializable {
    /**
     * 主键
     */
    @Id
    @GeneratedValue(generator = "JDBC")
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
     * 星座用户ID
     */
	private Long userId;

    /**
     * 店名
     */
	private String shopName;

    /**
     * 分站
     */
	private String webSite;

    /**
     * 淘宝店链接
     */
	private String taobaoUrl;

    /**
     * 淘宝昵称，是否淘宝店，以此值为参考依据，此值为null说明不是淘宝店
     */
	private String tbNick;

    /**
     * 档口号
     */
	private String shopNum;

    /**
     * 价格匹配规则
     */
	private String priceRule;

    /**
     * 档口地址
     */
	private String address;

    /**
     * 邮编
     */
	private String zipcode;

    /**
     * 座机
     */
	private String telephone;

    /**
     * 手机
     */
	private String mobilePhone;

    /**
     * QQ号
     */
	private String imQq;

    /**
     * 旺旺号
     */
	private String imAliww;

    /**
     * 
     */
	private String imWx;

    /**
     * 星座网二级域名
     */
	private String domain;

    /**
     * 关店原因
     */
	private String closeReason;

    /**
     * 店铺状态，0是正常，1是关店
     */
	private Integer shopStatus;

    /**
     * 创建时间
     */
	private Date createDate;

    /**
     * 最后修改时间
     */
	private Date lastModifyTime;

    /**
     * 
     */
	private String dataPacketUrl;

    /**
     * 店铺公告
     */
	private String shopAnnouncement;

    /**
     * 商品关联ID，此值默认为本店店铺ID
     */
	private Long itemLinkId;

    /**
     * 同步淘宝，1同步，2不同步
     */
	private Integer synTaobao;

    /**
     * 在市场中排序标识，默认等于shop_num
     */
	private String sortOrderKey;

    /**
     * 是否在市场中显示，1表示要显示，0表示不需要，程序中不涉及到此字段的修改，只用于数据库直接修改，用于测试店铺的隐藏
     */
	private Integer displayInMarket;

    /**
     * 
     */
	private Integer userManager;

    /**
     * 邮箱
     */
	private String email;

    /**
     * 主营类目
     */
	private String mainBus;

    /**
     * 系统备注
     */
	private String systemRecommon;

    /**
     * 老的用户ID
     */
	private Long everUserId;

    /**
     * 1淘宝店铺，2普通店铺
     */
	private Integer type;

	public void setShopId(Long shopId) {
		this.shopId = shopId;
	}

	public Long getShopId() {
		return this.shopId;
	}

	public void setMarketId(Long marketId) {
		this.marketId = marketId;
	}

	public Long getMarketId() {
		return this.marketId;
	}

	public void setFloorId(Long floorId) {
		this.floorId = floorId;
	}

	public Long getFloorId() {
		return this.floorId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getUserId() {
		return this.userId;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public String getShopName() {
		return this.shopName;
	}

	public void setWebSite(String webSite) {
		this.webSite = webSite;
	}

	public String getWebSite() {
		return this.webSite;
	}

	public void setTaobaoUrl(String taobaoUrl) {
		this.taobaoUrl = taobaoUrl;
	}

	public String getTaobaoUrl() {
		return this.taobaoUrl;
	}

	public void setTbNick(String tbNick) {
		this.tbNick = tbNick;
	}

	public String getTbNick() {
		return this.tbNick;
	}

	public void setShopNum(String shopNum) {
		this.shopNum = shopNum;
	}

	public String getShopNum() {
		return this.shopNum;
	}

	public void setPriceRule(String priceRule) {
		this.priceRule = priceRule;
	}

	public String getPriceRule() {
		return this.priceRule;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAddress() {
		return this.address;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getZipcode() {
		return this.zipcode;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getTelephone() {
		return this.telephone;
	}

	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}

	public String getMobilePhone() {
		return this.mobilePhone;
	}

	public void setImQq(String imQq) {
		this.imQq = imQq;
	}

	public String getImQq() {
		return this.imQq;
	}

	public void setImAliww(String imAliww) {
		this.imAliww = imAliww;
	}

	public String getImAliww() {
		return this.imAliww;
	}

	public void setImWx(String imWx) {
		this.imWx = imWx;
	}

	public String getImWx() {
		return this.imWx;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	public String getDomain() {
		return this.domain;
	}

	public void setCloseReason(String closeReason) {
		this.closeReason = closeReason;
	}

	public String getCloseReason() {
		return this.closeReason;
	}

	public void setShopStatus(Integer shopStatus) {
		this.shopStatus = shopStatus;
	}

	public Integer getShopStatus() {
		return this.shopStatus;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getCreateDate() {
		return this.createDate;
	}

	public void setLastModifyTime(Date lastModifyTime) {
		this.lastModifyTime = lastModifyTime;
	}

	public Date getLastModifyTime() {
		return this.lastModifyTime;
	}

	public void setDataPacketUrl(String dataPacketUrl) {
		this.dataPacketUrl = dataPacketUrl;
	}

	public String getDataPacketUrl() {
		return this.dataPacketUrl;
	}

	public void setShopAnnouncement(String shopAnnouncement) {
		this.shopAnnouncement = shopAnnouncement;
	}

	public String getShopAnnouncement() {
		return this.shopAnnouncement;
	}

	public void setItemLinkId(Long itemLinkId) {
		this.itemLinkId = itemLinkId;
	}

	public Long getItemLinkId() {
		return this.itemLinkId;
	}

	public void setSynTaobao(Integer synTaobao) {
		this.synTaobao = synTaobao;
	}

	public Integer getSynTaobao() {
		return this.synTaobao;
	}

	public void setSortOrderKey(String sortOrderKey) {
		this.sortOrderKey = sortOrderKey;
	}

	public String getSortOrderKey() {
		return this.sortOrderKey;
	}

	public void setDisplayInMarket(Integer displayInMarket) {
		this.displayInMarket = displayInMarket;
	}

	public Integer getDisplayInMarket() {
		return this.displayInMarket;
	}

	public void setUserManager(Integer userManager) {
		this.userManager = userManager;
	}

	public Integer getUserManager() {
		return this.userManager;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmail() {
		return this.email;
	}

	public void setMainBus(String mainBus) {
		this.mainBus = mainBus;
	}

	public String getMainBus() {
		return this.mainBus;
	}

	public void setSystemRecommon(String systemRecommon) {
		this.systemRecommon = systemRecommon;
	}

	public String getSystemRecommon() {
		return this.systemRecommon;
	}

	public void setEverUserId(Long everUserId) {
		this.everUserId = everUserId;
	}

	public Long getEverUserId() {
		return this.everUserId;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getType() {
		return this.type;
	}

}