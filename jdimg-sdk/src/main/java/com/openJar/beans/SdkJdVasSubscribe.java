package com.openJar.beans;

import com.openJar.utils.OpenBean;

import java.util.Date;

public class SdkJdVasSubscribe extends OpenBean{
    /**
     * 用户京东ID
     */
    private Long jdUid;
    /**项目编码*/
    private String itemCode;
    /**购买人*/
    private String UserName;
    /**
     * 调用来源
     */
    private String itemSource;
    /**
     * 服务版本号
     */
    private Integer versionNo;
    /**
     * 到期时间
     */
    private Date endDate;

    public Long getJdUid() {
        return jdUid;
    }

    public void setJdUid(Long jdUid) {
        this.jdUid = jdUid;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getItemSource() {
        return itemSource;
    }

    public void setItemSource(String itemSource) {
        this.itemSource = itemSource;
    }

    public Integer getVersionNo() {
        return versionNo;
    }

    public void setVersionNo(Integer versionNo) {
        this.versionNo = versionNo;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}
