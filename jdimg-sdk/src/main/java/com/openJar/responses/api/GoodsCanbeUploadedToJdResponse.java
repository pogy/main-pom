package com.openJar.responses.api;

import com.openJar.responses.Response;

/**
 * Created By admin on 2018/1/16/13:24
 */
public class GoodsCanbeUploadedToJdResponse extends Response {
    /**
     * 商品是否可以上传到京东 true：可以
     */
    private Boolean can;

    public Boolean getCan() {
        return can;
    }

    public void setCan(Boolean can) {
        this.can = can;
    }
}
