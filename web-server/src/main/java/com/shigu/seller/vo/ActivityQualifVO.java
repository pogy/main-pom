package com.shigu.seller.vo;

/**
 * 活动页资质
 * Created by bugzy on 2017/7/13 0013.
 */
public class ActivityQualifVO {

    public ActivityQualifVO(String content, Boolean status) {
        this.content = content;
        this.status = status;
    }

    /**资质描述*/
    private String content;

    /**准入，不准*/
    private Boolean status;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}
