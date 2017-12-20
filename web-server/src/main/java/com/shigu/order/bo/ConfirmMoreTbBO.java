package com.shigu.order.bo;

import java.io.Serializable;
import java.util.List;

/**
 * 确认页面的参数
 * Created by zhaohongbo on 17/6/23.
 */
public class ConfirmMoreTbBO implements Serializable{
    /**
     * 发件单位ID
     */
    private Long senderId;
    /**
     * 快递公司单位ID
     */
    private Long postId;
    /**
     * 结算唯一码
     */
    private String idCode;

    /**
     * 获取 发件单位ID
     */
    public Long getSenderId() {
        return this.senderId;
    }

    /**
     * 设置 发件单位ID
     */
    public void setSenderId(Long senderId) {
        this.senderId = senderId;
    }

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
