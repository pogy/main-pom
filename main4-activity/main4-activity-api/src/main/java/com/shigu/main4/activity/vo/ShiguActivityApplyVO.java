package com.shigu.main4.activity.vo;

import java.io.Serializable;

/**
 * 申请信息
 * Created by bugzy on 2017/6/30 0030.
 */
public class ShiguActivityApplyVO implements Serializable {

    private Long applyId;

    /**
     * 活动id
     */
    private Long activityId;

    /**
     * 申请是否通过。
     */
    private Boolean choose;

    /**
     * 店铺ID
     */
    private Long shopId;

    /**
     * 商品链接 ;
     */
    private String items;

    /**
     * 用户
     */
    private Long userId;

    /**
     * 电话
     */
    private String phone;

    public void setApplyId(Long applyId) {
        this.applyId = applyId;
    }

    public Long getApplyId() {
        return this.applyId;
    }

    public void setActivityId(Long activityId) {
        this.activityId = activityId;
    }

    public Long getActivityId() {
        return this.activityId;
    }

    public void setChoose(Boolean choose) {
        this.choose = choose;
    }

    public Boolean getChoose() {
        return this.choose;
    }

    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }

    public Long getShopId() {
        return this.shopId;
    }

    public void setItems(String items) {
        this.items = items;
    }

    public String getItems() {
        return this.items;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getUserId() {
        return this.userId;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhone() {
        return this.phone;
    }

}
