package com.opentae.data.mall.beans;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

/**
 * 用户子表
 * Created by zhaohongbo on 17/2/15.
 */
public class MemberUserSub implements Serializable{

    private static final long serialVersionUID = 1019793329611389075L;
    @Id
    @GeneratedValue(
            generator = "JDBC"
    )
    private Long subUserId;
    private Long userId;
    private String subUserName;
    private String subUserPassword;
    private String subUserKey;
    private Integer accountType;
    private Long logins;
    private Long useStatus;
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
    private Integer isOpenStore;
    private Date createTime;

    public Long getSubUserId() {
        return subUserId;
    }

    public void setSubUserId(Long subUserId) {
        this.subUserId = subUserId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getSubUserName() {
        return subUserName;
    }

    public void setSubUserName(String subUserName) {
        this.subUserName = subUserName;
    }

    public String getSubUserPassword() {
        return subUserPassword;
    }

    public void setSubUserPassword(String subUserPassword) {
        this.subUserPassword = subUserPassword;
    }

    public String getSubUserKey() {
        return subUserKey;
    }

    public void setSubUserKey(String subUserKey) {
        this.subUserKey = subUserKey;
    }

    public Integer getAccountType() {
        return accountType;
    }

    public void setAccountType(Integer accountType) {
        this.accountType = accountType;
    }

    public Long getLogins() {
        return logins;
    }

    public void setLogins(Long logins) {
        this.logins = logins;
    }

    public Long getUseStatus() {
        return useStatus;
    }

    public void setUseStatus(Long useStatus) {
        this.useStatus = useStatus;
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

    public Integer getIsOpenStore() {
        return isOpenStore;
    }

    public void setIsOpenStore(Integer isOpenStore) {
        this.isOpenStore = isOpenStore;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
