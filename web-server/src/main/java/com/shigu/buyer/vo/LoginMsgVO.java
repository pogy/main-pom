package com.shigu.buyer.vo;

import java.io.Serializable;

/**
 * 外站要来拿的登陆信息
 * Created by zhaohongbo on 17/3/29.
 */
public class LoginMsgVO implements Serializable{
    /**
     * 用户ID
     */
    private Long userId;
    /**
     * 淘宝昵称
     */
    private String tbNick;
    /**
     * 是否来自淘宝
     */
    private Boolean fromTaobao;
    /**
     * 是否商家
     */
    private Boolean imSeller;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getTbNick() {
        return tbNick;
    }

    public void setTbNick(String tbNick) {
        this.tbNick = tbNick;
    }

    public Boolean getFromTaobao() {
        return fromTaobao;
    }

    public void setFromTaobao(Boolean fromTaobao) {
        this.fromTaobao = fromTaobao;
    }

    public Boolean getImSeller() {
        return imSeller;
    }

    public void setImSeller(Boolean imSeller) {
        this.imSeller = imSeller;
    }
}
