package com.opentae.data.mall.beans;


import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.io.Serializable;
import java.util.Date;

/**
 * 广告竞拍申请
 * @author shigu_zjb
 * @date 2017/3/22 17:02
 *
 */
@Deprecated
public class SpreadAuctShop implements Serializable{

    /** 主键ID */
    @Id
    @GeneratedValue(
            generator = "JDBC"
    )
    private Long id;

    /** 竞拍ID */
    private Long screnId;

    /** 店铺ID */
    private Long shopId;

    /** 是否中奖 */
    private Boolean isDraw;

    /** 手机号 */
    private String contactsPhone;

    /** 联系人姓名 */
    private String contactsName;

    /** 创建时间 */
    private Date createTime;

    /** 更新时间 */
    private Date modifyTime;

    /** 数据有效性 */
    private Boolean enabled;

    /** 市场名称 */
    @Transient
    private String marketName;

    /** 店铺档口号 */
    @Transient
    private String shopNum;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getScrenId() {
        return screnId;
    }

    public void setScrenId(Long screnId) {
        this.screnId = screnId;
    }

    public Long getShopId() {
        return shopId;
    }

    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }

    public String getContactsPhone() {
        return contactsPhone;
    }

    public void setContactsPhone(String contactsPhone) {
        this.contactsPhone = contactsPhone;
    }

    public String getContactsName() {
        return contactsName;
    }

    public void setContactsName(String contactsName) {
        this.contactsName = contactsName;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public Boolean getDraw() {
        return isDraw;
    }

    public void setDraw(Boolean draw) {
        isDraw = draw;
    }

    public String getMarketName() {
        return marketName;
    }

    public void setMarketName(String marketName) {
        this.marketName = marketName;
    }

    public String getShopNum() {
        return shopNum;
    }

    public void setShopNum(String shopNum) {
        this.shopNum = shopNum;
    }
}
