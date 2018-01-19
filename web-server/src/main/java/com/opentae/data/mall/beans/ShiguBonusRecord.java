package com.opentae.data.mall.beans;

import java.io.Serializable;
import java.util.Date;

/**
 * 红包明细
 *
 * @author wangbo 2018-01-18 16:16
 */
public class ShiguBonusRecord implements Serializable {

    /** 主键 */
    private Long id;

    /** 流水号 */
    private String serialNumber;

    /** 支付方userId，0=系统充值 */
    private Long fromUserId;

    /** 接收方userId，0=系统回收 */
    private Long toUserId;

    /** 用户在第三方系统的唯一识别号，如：淘宝NICK、京东NICK */
    private String thirdId;

    /** 数量，单位：分 */
    private Long amount;

    /** 类型：1=系统充值，2=用户使用 */
    private Byte type;

    /** 状态：1=成功 */
    private Byte status;

    /** 创建时间 */
    private Date createTime;

    /** 更新时间 */
    private Date updateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public Long getFromUserId() {
        return fromUserId;
    }

    public void setFromUserId(Long fromUserId) {
        this.fromUserId = fromUserId;
    }

    public Long getToUserId() {
        return toUserId;
    }

    public void setToUserId(Long toUserId) {
        this.toUserId = toUserId;
    }

    public String getThirdId() {
        return thirdId;
    }

    public void setThirdId(String thirdId) {
        this.thirdId = thirdId;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
