package com.shigu.main4.order.vo;

import java.io.Serializable;

/**
 * 发货机构
 * Created by zhaohongbo on 17/6/1.
 */
public class SenderVO implements Serializable{

    private Long senderId;

    public Long getSenderId() {
        return senderId;
    }

    public void setSenderId(Long senderId) {
        this.senderId = senderId;
    }
}
