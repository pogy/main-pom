package com.shigu.main4.cdn.bo;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 收藏店铺
 * Created by zhaohongbo on 17/3/7.
 */
public class ScStoreBO implements Serializable{

    @NotNull(message = "store_id为null")
    private Long store_id;

    private String callback;

    public String getCallback() {
        return callback;
    }

    public void setCallback(String callback) {
        this.callback = callback;
    }

    public Long getStore_id() {
        return store_id;
    }

    public void setStore_id(Long store_id) {
        this.store_id = store_id;
    }
}
