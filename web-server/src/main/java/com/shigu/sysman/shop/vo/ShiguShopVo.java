package com.shigu.sysman.shop.vo;


import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.io.Serializable;
import java.util.Date;

/**
 * 店铺VO
 *
 */
public class ShiguShopVo implements Serializable{

    /**
     * 主键
     */
    @Id
    @GeneratedValue(
        generator = "JDBC"
    )
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
     * 淘宝昵称，是否淘宝店， 以此值为参考依据， 此值为null说明不是淘宝店
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
     * 微信
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
     * 店铺创建时间
     */
    private Date createDate;

    /**
     * 最后修改时间
     */
    private Date lastModifyTime;

    /**
     * 数据包链接
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
     * 是否在市场中显示，1表示要显示，0表示不需要
     */
    private Long displayInMarket;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 主营类目
     */
    private String mainBus;

    /**
     * 用户是否有管理权,1有，0没有
     */
    private Integer userManager;

    /**
     * 系统备注
     */
    private String systemRecommon;

    /**
     * fresh_time
     */
    private Date freshTime;

    /**
     * Access过期时间
     */
    private Long expiresIn;

    /**
     * 用户名
     */
    private String userName;

    /**
     *  市场
     */
    private String marketName;

    /**
     * 顶级市场
     */
    private String parentMarketName;

    /**
     * TMC 状态
     *
     */
    private Boolean tmcStatus;

    /**
     * 首次加入队列时间
     */
    private Date tmcFirstTime;

    /**
     * 最后加入队列时间
     */
    private Date tmcLastTime;

    /**
     * 是否有效
     */
    private Boolean isValid;

    /**
     * 授权状态
     */
    private int shopAuthState;

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

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getWebSite() {
        return webSite;
    }

    public void setWebSite(String webSite) {
        this.webSite = webSite;
    }

    public String getTaobaoUrl() {
        return taobaoUrl;
    }

    public void setTaobaoUrl(String taobaoUrl) {
        this.taobaoUrl = taobaoUrl;
    }

    public String getTbNick() {
        return tbNick;
    }

    public void setTbNick(String tbNick) {
        this.tbNick = tbNick;
    }

    public String getShopNum() {
        return shopNum;
    }

    public void setShopNum(String shopNum) {
        this.shopNum = shopNum;
    }

    public String getPriceRule() {
        return priceRule;
    }

    public void setPriceRule(String priceRule) {
        this.priceRule = priceRule;
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

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
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

    public String getImWx() {
        return imWx;
    }

    public void setImWx(String imWx) {
        this.imWx = imWx;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getCloseReason() {
        return closeReason;
    }

    public void setCloseReason(String closeReason) {
        this.closeReason = closeReason;
    }

    public Integer getShopStatus() {
        return shopStatus;
    }

    public void setShopStatus(Integer shopStatus) {
        this.shopStatus = shopStatus;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getLastModifyTime() {
        return lastModifyTime;
    }

    public void setLastModifyTime(Date lastModifyTime) {
        this.lastModifyTime = lastModifyTime;
    }

    public String getDataPacketUrl() {
        return dataPacketUrl;
    }

    public void setDataPacketUrl(String dataPacketUrl) {
        this.dataPacketUrl = dataPacketUrl;
    }

    public String getShopAnnouncement() {
        return shopAnnouncement;
    }

    public void setShopAnnouncement(String shopAnnouncement) {
        this.shopAnnouncement = shopAnnouncement;
    }

    public Long getItemLinkId() {
        return itemLinkId;
    }

    public void setItemLinkId(Long itemLinkId) {
        this.itemLinkId = itemLinkId;
    }

    public Integer getSynTaobao() {
        return synTaobao;
    }

    public void setSynTaobao(Integer synTaobao) {
        this.synTaobao = synTaobao;
    }

    public String getSortOrderKey() {
        return sortOrderKey;
    }

    public void setSortOrderKey(String sortOrderKey) {
        this.sortOrderKey = sortOrderKey;
    }

    public Long getDisplayInMarket() {
        return displayInMarket;
    }

    public void setDisplayInMarket(Long displayInMarket) {
        this.displayInMarket = displayInMarket;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMainBus() {
        return mainBus;
    }

    public void setMainBus(String mainBus) {
        this.mainBus = mainBus;
    }

    public Integer getUserManager() {
        return userManager;
    }

    public void setUserManager(Integer userManager) {
        this.userManager = userManager;
    }

    public String getSystemRecommon() {
        return systemRecommon;
    }

    public void setSystemRecommon(String systemRecommon) {
        this.systemRecommon = systemRecommon;
    }

    public Date getFreshTime() {
        return freshTime;
    }

    public void setFreshTime(Date freshTime) {
        this.freshTime = freshTime;
    }

    public Long getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(Long expiresIn) {
        this.expiresIn = expiresIn;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getMarketName() {
        return marketName;
    }

    public void setMarketName(String marketName) {
        this.marketName = marketName;
    }

    public String getParentMarketName() {
        return parentMarketName;
    }

    public void setParentMarketName(String parentMarketName) {
        this.parentMarketName = parentMarketName;
    }

    public Boolean getTmcStatus() {
        return tmcStatus;
    }

    public void setTmcStatus(Boolean tmcStatus) {
        this.tmcStatus = tmcStatus;
    }

    public Date getTmcFirstTime() {
        return tmcFirstTime;
    }

    public void setTmcFirstTime(Date tmcFirstTime) {
        this.tmcFirstTime = tmcFirstTime;
    }

    public Date getTmcLastTime() {
        return tmcLastTime;
    }

    public void setTmcLastTime(Date tmcLastTime) {
        this.tmcLastTime = tmcLastTime;
    }

    public Boolean getValid() {
        return isValid;
    }

    public void setValid(Boolean valid) {
        isValid = valid;
    }

    public int getShopAuthState() {
        return shopAuthState;
    }

    public void setShopAuthState(int shopAuthState) {
        this.shopAuthState = shopAuthState;
    }
}
