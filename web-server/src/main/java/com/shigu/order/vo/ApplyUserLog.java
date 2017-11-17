package com.shigu.order.vo;

/**
 * Created by pc on 2017-07-26.
 *
 * @author pc
 * @version 3.0.0-SNAPSHOT
 * @description
 * @since 3.0.0-SNAPSHOT
 */
public class ApplyUserLog {
    private Integer userType;
    private String userNickname;
    private String userHeadimg;
    private String recordTime;
    private String recordContent;
    private Integer afterSaleType;
    private Boolean afterSaleInfoShowIs;

    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    public String getUserNickname() {
        return userNickname;
    }

    public void setUserNickname(String userNickname) {
        this.userNickname = userNickname;
    }

    public String getUserHeadimg() {
        return userHeadimg;
    }

    public void setUserHeadimg(String userHeadimg) {
        this.userHeadimg = userHeadimg;
    }

    public String getRecordTime() {
        return recordTime;
    }

    public void setRecordTime(String recordTime) {
        this.recordTime = recordTime;
    }

    public String getRecordContent() {
        return recordContent;
    }

    public void setRecordContent(String recordContent) {
        this.recordContent = recordContent;
    }

    public Boolean getAfterSaleInfoShowIs() {
        return afterSaleInfoShowIs;
    }

    public void setAfterSaleInfoShowIs(Boolean afterSaleInfoShowIs) {
        this.afterSaleInfoShowIs = afterSaleInfoShowIs;
    }

    public Integer getAfterSaleType() {
        return afterSaleType;
    }

    public void setAfterSaleType(Integer afterSaleType) {
        this.afterSaleType = afterSaleType;
    }
}
