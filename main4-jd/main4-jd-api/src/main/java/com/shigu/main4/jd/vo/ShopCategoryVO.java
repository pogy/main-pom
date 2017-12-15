package com.shigu.main4.jd.vo;

import java.io.Serializable;

/**
 * Created By admin on 2017/12/14/15:58
 */
public class ShopCategoryVO implements Serializable {

    private static final long serialVersionUID = 1068022458103649657L;

    private long cid;
    private long parentId;
    private String name;
    private Boolean isParent;
    private Boolean isOpen;
    private Boolean isHomeShow;
    private long shopId;
    private int orderNo;

    public ShopCategoryVO() {
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
