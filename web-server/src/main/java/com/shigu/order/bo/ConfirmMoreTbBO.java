package com.shigu.order.bo;

import java.io.Serializable;

/**
 * 确认页面的参数
 * Created by zhaohongbo on 17/6/23.
 */
public class ConfirmMoreTbBO implements Serializable{
    /**
     * 快递公司单位ID
     */
    private Long postId;
    /**
     * 结算唯一码
     */
    private String idCode;

    /**
     * 获取 结算唯一码
     */
    public String getIdCode() {
        return this.idCode;
    }

    /**
     * 设置 结算唯一码
     */
    public void setIdCode(String idCode) {
        this.idCode = idCode;
    }

    /**
     * 获取 快递公司单位ID
     */
    public Long getPostId() {
        return this.postId;
    }

    /**
     * 设置 快递公司单位ID
     */
    public void setPostId(Long postId) {
        this.postId = postId;
    }
}
