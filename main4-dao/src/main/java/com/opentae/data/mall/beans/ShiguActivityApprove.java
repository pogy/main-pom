package com.opentae.data.mall.beans;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by Administrator on 2017/7/12.
 */
public class ShiguActivityApprove implements Serializable {
    /**
     *
     */
    @Id
    @GeneratedValue(generator = "JDBC")
    private Long approveId;

    /**
     * 活动id
     */
    private Long activityId;


    /**
     *
     */
    private Long shopId;

    /**
     * 商品链接 ;
     */
    private String item;

    /**
     * 用户
     */
    private Long userId;

    /**
     * 电话
     */
    private String phone;

    /**
     * 类型id
     */
    private Long cateId;

    public Long getApproveId() {
        return approveId;
    }

    public void setApproveId( Long approveId ) {
        this.approveId = approveId;
    }

    public void setActivityId( Long activityId) {
        this.activityId = activityId;
    }

    public Long getActivityId() {
        return this.activityId;
    }

    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }

    public Long getShopId() {
        return this.shopId;
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

    public String getItem() {
        return item;
    }

    public void setItem( String item ) {
        this.item = item;
    }

    public Long getCateId() {
        return cateId;
    }

    public void setCateId( Long cateId ) {
        this.cateId = cateId;
    }
}
