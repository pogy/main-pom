package com.shigu.main4.vo;

import java.io.Serializable;

/**
 * Created By zyl on 2018/10/17 0017/11:54
 */
public class LinceseVo implements Serializable{

    private Long shopId;
    private Integer type;
    private Integer isWx;
    private Integer isZx;
    private String context;

    public Integer getIsWx() {
        return isWx;
    }

    public void setIsWx(Integer isWx) {
        this.isWx = isWx;
    }

    public Integer getIsZx() {
        return isZx;
    }

    public void setIsZx(Integer isZx) {
        this.isZx = isZx;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Long getShopId() {
        return shopId;
    }

    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }

}
