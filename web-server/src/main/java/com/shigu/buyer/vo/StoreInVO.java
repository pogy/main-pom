package com.shigu.buyer.vo;

import com.shigu.main4.vo.ShopApply;
import com.shigu.tools.DateParseUtil;

import java.io.Serializable;

/**
 * 店铺入驻值
 * Created by zhaohongbo on 17/3/14.
 */
public class StoreInVO implements Serializable{
    /**
     * 申请ID
     */
    private Long storeId;
    /**
     * 店铺名,这里放市场-档口号
     */
    private String storeName;
    /**
     * 申请时间
     */
    private String sqTime;
    /**
     * 0不通过
     * 1申请中
     * 2已通过
     */
    private Integer status;
    /**
     * 店铺申请回执编号
     * webSite+storeId
     */
    private String userCode;

    public StoreInVO(ShopApply apply) {
        setStoreId(apply.getRuzhuId());
        setStoreName(apply.getMarket()+" "+apply.getShopNum());
        setSqTime(DateParseUtil.parseDate("yyyy-MM-dd HH:mm:ss",apply.getApplyTime()));
        setUserCode(apply.getRuzhuId().toString());
        setStatus(apply.getStatus()==0?1:apply.getStatus()==1?2:0);
    }

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getSqTime() {
        return sqTime;
    }

    public void setSqTime(String sqTime) {
        this.sqTime = sqTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }
}
