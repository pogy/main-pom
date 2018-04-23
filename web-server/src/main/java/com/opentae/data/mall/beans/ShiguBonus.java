package com.opentae.data.mall.beans;

import java.io.Serializable;
import java.util.Date;

/**
 * 红包
 *
 * @author wangbo 2018-01-18 16:16
 */
public class ShiguBonus implements Serializable {

    /** 主键 */
    private Long id;

    /** 用户ID */
    private Long userId;

    /** 用户在第三方系统的唯一识别号，如：淘宝NICK、京东NICK */
    private String thirdId;

    /** third_id类型：1=淘宝NICK、2=京东NICK */
    private Byte type;

    /** 状态：1=正常、2=冻结 */
    private Byte status;

    /** 红包余额，单位：分 */
    private Long balance;

    /** 创建时间 */
    private Date createTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getThirdId() {
        return thirdId;
    }

    public void setThirdId(String thirdId) {
        this.thirdId = thirdId;
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

    public Long getBalance() {
        return balance;
    }

    public void setBalance(Long balance) {
        this.balance = balance;
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

    /** 更新时间 */

    private Date updateTime;
}
