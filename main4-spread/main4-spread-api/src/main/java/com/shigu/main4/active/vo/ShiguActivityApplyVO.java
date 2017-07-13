package com.shigu.main4.active.vo;

import java.io.Serializable;
import java.util.List;

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
    private Integer choose;

    /**
     * 店铺ID
     */
    private Long shopId;

    /**
     * 商品链接 ;
     */
    private List<Long> itemIds;

    /**
     * 用户
     */
    private Long userId;

    /**
     * 电话
     */
    private String phone;

    private String cateIds;

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

    public void setChoose(Integer choose) {
        this.choose = choose;
    }

    public Integer getChoose() {
        return this.choose;
    }

    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }

    public Long getShopId() {
        return this.shopId;
    }

    public void setItemIds(List<Long> itemIds) {
        this.itemIds = itemIds;
    }

    public List<Long> getItemIds() {
        return this.itemIds;
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

    public String getCateIds() {
        return cateIds;
    }

    public void setCateIds( String cateIds ) {
        this.cateIds = cateIds;
    }
}
