package com.shigu.main4.ucenter.vo;

import java.io.Serializable;

/**
 * 类名：InvitedUser
 * 类路径：package com.shigu.main4.ucenter.vo.InvitedUser
 * 创建者：whx
 * 创建时间：7/16/18 4:30 PM
 * 项目：main-pom
 * 描述：受邀请注册的用户信息
 */
public class InvitedUser implements Serializable {

    /**
     * 用户id
     */
    private Long userId;
    /**
     * 用户头像
     */
    private String headImg;
    /**
     * 	用户手机
     */
    private String telephone;
    /**
     *	注册日期
     */
    private String registeDate;
    /**
     * 用户状态:1表示已注册， 2表示成功下单
     */
    private Integer userState;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getHeadImg() {
        return headImg;
    }

    public void setHeadImg(String headImg) {
        this.headImg = headImg;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getRegisteDate() {
        return registeDate;
    }

    public void setRegisteDate(String registeDate) {
        this.registeDate = registeDate;
    }

    public Integer getUserState() {
        return userState;
    }

    public void setUserState(Integer userState) {
        this.userState = userState;
    }
}
