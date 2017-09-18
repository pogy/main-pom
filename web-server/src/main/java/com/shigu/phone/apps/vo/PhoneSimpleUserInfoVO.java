package com.shigu.phone.apps.vo;

import com.opentae.core.mybatis.config.Column;

/**
 * 类名：PhoneSimpleUserInfoVO
 * 类路径：com.shigu.phone.apps.vo.PhoneSimpleUserInfoVO
 * 创建者：王浩翔
 * 创建时间：2017-09-18 17:43
 * 项目：main-pom
 * 描述：移动端简单用户信息
 */
public class PhoneSimpleUserInfoVO {
    @Column("member_user.user_id")
    private Long userId;
    @Column("member_user.user_nick")
    private String userNick;
    @Column("member_user.is_open_store")
    private Boolean imSeller;
    @Column("member_user.portrait_url")
    private String imgsrc;
    private String token;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserNick() {
        return userNick;
    }

    public void setUserNick(String userNick) {
        this.userNick = userNick;
    }

    public Boolean getImSeller() {
        return imSeller;
    }

    public void setImSeller(Boolean imSeller) {
        this.imSeller = imSeller;
    }

    public String getImgsrc() {
        return imgsrc;
    }

    public void setImgsrc(String imgsrc) {
        this.imgsrc = imgsrc;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
