package com.shigu.seller.vo;

/**
 * 活动信息
 * Created by bugzy on 2017/6/30 0030.
 */
public class ActivityListVO {

    private Long actid;

    private String actImg;

    private String actTitle;

    private String applyTime;

    private String applyRange;

    private String actStartTime;

    private String actEndTime;

    private String actNums;

    private String chargeStyle;

    private Boolean supportReturn;

    private Boolean supportBarter;

    private int hdStatus;

    private int sqStatus;

    private String goodsImgSrc;

    public Long getActid() {
        return actid;
    }

    public void setActid(Long actid) {
        this.actid = actid;
    }

    public String getActImg() {
        return actImg;
    }

    public void setActImg(String actImg) {
        this.actImg = actImg;
    }

    public String getActTitle() {
        return actTitle;
    }

    public void setActTitle(String actTitle) {
        this.actTitle = actTitle;
    }

    public String getApplyTime() {
        return applyTime;
    }

    public void setApplyTime(String applyTime) {
        this.applyTime = applyTime;
    }

    public String getApplyRange() {
        return applyRange;
    }

    public void setApplyRange(String applyRange) {
        this.applyRange = applyRange;
    }

    public String getActStartTime() {
        return actStartTime;
    }

    public void setActStartTime(String actStartTime) {
        this.actStartTime = actStartTime;
    }

    public String getActEndTime() {
        return actEndTime;
    }

    public void setActEndTime(String actEndTime) {
        this.actEndTime = actEndTime;
    }

    public String getActNums() {
        return actNums;
    }

    public void setActNums(String actNums) {
        this.actNums = actNums;
    }

    public String getChargeStyle() {
        return chargeStyle;
    }

    public void setChargeStyle(String chargeStyle) {
        this.chargeStyle = chargeStyle;
    }

    public Boolean getSupportReturn() {
        return supportReturn;
    }

    public void setSupportReturn(Boolean supportReturn) {
        this.supportReturn = supportReturn;
    }

    public Boolean getSupportBarter() {
        return supportBarter;
    }

    public void setSupportBarter(Boolean supportBarter) {
        this.supportBarter = supportBarter;
    }

    public int getHdStatus() {
        return hdStatus;
    }

    public void setHdStatus(int hdStatus) {
        this.hdStatus = hdStatus;
    }

    public int getSqStatus() {
        return sqStatus;
    }

    public void setSqStatus(int sqStatus) {
        this.sqStatus = sqStatus;
    }

    public String getGoodsImgSrc() {
        return goodsImgSrc;
    }

    public void setGoodsImgSrc(String goodsImgSrc) {
        this.goodsImgSrc = goodsImgSrc;
    }
}
