package com.opentae.data.mall.beans;

/**
 * 店铺授权情况
 * Created by zhaohongbo on 16/7/22.
 */
public class StoreAuthDetail {
    private Long storeId;
    private Long endTime;

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

    public Long getEndTime() {
        return endTime;
    }

    public void setEndTime(Long endTime) {
        this.endTime = endTime;
    }
}
