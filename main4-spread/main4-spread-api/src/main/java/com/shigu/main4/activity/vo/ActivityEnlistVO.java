package com.shigu.main4.activity.vo;

import java.io.Serializable;

/**
 * 报名记录
 * Created by zhaohongbo on 17/5/4.
 */
public class ActivityEnlistVO implements Serializable{
    /**
     * 记录ID
     */
    private Long enId;
    /**
     * 用户ID
     */
    private Long userId;
    /**
     * 店铺ID
     */
    private Long shopId;
    /**
     * 活动ID
     */
    private Long activityId;
    /**
     * 联系人
     */
    private String name;
    /**
     * 联系电话
     */
    private String telephone;

    private Integer draw;

    public Integer getDraw() {
        return draw;
    }

    public void setDraw(Integer draw) {
        this.draw = draw;
    }

    public Long getEnId() {
        return enId;
    }

    public void setEnId(Long enId) {
        this.enId = enId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getShopId() {
        return shopId;
    }

    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }

    public Long getActivityId() {
        return activityId;
    }

    public void setActivityId(Long activityId) {
        this.activityId = activityId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
}
