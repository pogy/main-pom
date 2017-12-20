package com.opentae.data.mall.beans;


import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.io.Serializable;
import java.util.Date;

/**
 * 实名认证申请
 *
 * @author shigu_zjb
 * @date 2017/3/1 18:29
 *
 */
public class MemberLicenseApply implements Serializable{

    @Id
    @GeneratedValue(
            generator = "JDBC"
    )
    /** 主键ID */
    private Long applyId;

    /** 用户ID */
    private Long userId;

    /** 用户权益类型 1代表实名认证，2代表邮箱认证，3代表密码安全，4代表绑定手机 */
    private Integer licenseType;

    /** 权益内容 */
    private String context;

    /** 申请时间 */
    private Date createTime;

    /** 审核状态 1通过，0未审核，-1不通过 */
    private Integer applyStatus;

    /** 不通过原因 */
    private String reason;

    @Transient
    private String userName;

    @Transient
    private String loginPhone;

    public Long getApplyId() {
        return applyId;
    }

    public void setApplyId(Long applyId) {
        this.applyId = applyId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Integer getLicenseType() {
        return licenseType;
    }

    public void setLicenseType(Integer licenseType) {
        this.licenseType = licenseType;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getApplyStatus() {
        return applyStatus;
    }

    public void setApplyStatus(Integer applyStatus) {
        this.applyStatus = applyStatus;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getLoginPhone() {
        return loginPhone;
    }

    public void setLoginPhone(String loginPhone) {
        this.loginPhone = loginPhone;
    }
}
