package com.shigu.main4.item.vo;

import java.io.Serializable;

/**
 * 异步同步一个店铺,需要的信息
 * Created by zhaohongbo on 17/3/18.
 */
public class AsynShopVO implements Serializable{
    /**
     * 店铺ID
     */
    private Long shopId;
    /**
     * 昵称
     */
    private String nick;

    public AsynShopVO() {
    }

    public AsynShopVO(Long shopId, String nick) {
        this.shopId = shopId;
        this.nick = nick;
    }

    public Long getShopId() {
        return shopId;
    }

    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }
}
