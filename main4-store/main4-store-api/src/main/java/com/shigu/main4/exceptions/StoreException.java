package com.shigu.main4.exceptions;

import com.shigu.main4.common.exceptions.Main4Exception;

/**
 * 店铺服务类异常
 * Created by zhaohongbo on 17/2/8.
 */
public class StoreException extends Main4Exception{


    private Long storeId;

    public StoreException(){}

    public StoreException(String message) {
        super(message);
    }

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }
}
