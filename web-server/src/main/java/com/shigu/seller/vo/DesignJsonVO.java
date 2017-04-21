package com.shigu.seller.vo;

import java.io.Serializable;

/**
 * 装修页面的json格式
 * Created by zhaohongbo on 17/4/18.
 */
public class DesignJsonVO implements Serializable{
    /**
     * 状态,0成功
     */
    private Integer status;
    /**
     * 成功或失败
     */
    private String message;
    /**
     * id
     */
    private String data;

    public DesignJsonVO() {
    }

    /**
     * 成功的构造
     * @param data
     */
    public DesignJsonVO(String data) {
        this.data = data;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
