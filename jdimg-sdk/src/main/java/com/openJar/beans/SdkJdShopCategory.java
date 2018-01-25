package com.openJar.beans;

import com.openJar.utils.OpenBean;

import java.io.Serializable;

/**
 * Created By admin on 2018/1/16/15:15
 */
public class SdkJdShopCategory extends OpenBean implements Serializable {
    /**
     * 类目编号
     */
    private long cid;
    /**
     * 父类目编号
     */
    private long parentId;
    /**
     * 类目名称
     */
    private String name;
    /**
     * 类目是否为父类目，即：该类目是否还有子类目
     */
    private Boolean isParent;
    /**
     * 是否展开子分类
     */
    private Boolean isOpen;
    /**
     * 是否在首页展示分类
     */
    private Boolean isHomeShow;
    /**
     * 	店铺ID
     */
    private long shopId;
    /**
     * 排序号
     */
    private int orderNo;

    public SdkJdShopCategory() {
    }

    public long getCid() {
        return cid;
    }

    public void setCid(long cid) {
        this.cid = cid;
    }

    public long getParentId() {
        return parentId;
    }

    public void setParentId(long parentId) {
        this.parentId = parentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getParent() {
        return isParent;
    }

    public void setParent(Boolean parent) {
        isParent = parent;
    }

    public Boolean getOpen() {
        return isOpen;
    }

    public void setOpen(Boolean open) {
        isOpen = open;
    }

    public Boolean getHomeShow() {
        return isHomeShow;
    }

    public void setHomeShow(Boolean homeShow) {
        isHomeShow = homeShow;
    }

    public long getShopId() {
        return shopId;
    }

    public void setShopId(long shopId) {
        this.shopId = shopId;
    }

    public int getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(int orderNo) {
        this.orderNo = orderNo;
    }
}
