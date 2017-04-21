package com.shigu.session.main4;

import com.shigu.session.main4.enums.LoginFromType;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 登陆的用户信息,main4里面用
 * Created by zhaohongbo on 17/2/20.
 */
public class PersonalSession implements Serializable{

    private static final long serialVersionUID = -4349627619474808317L;
    /**
     * 用户ID
     */
    private Long userId;
    /**
     * 子账号Id
     */
    private Long subUserId;
    /**
     * 用户星座网昵称
     */
    private String userNick;
    /**
     * 登陆名
     */
    private String loginName;
    /**
     * 登陆类别
     */
    private LoginFromType loginFromType;
    /**
     * 头像
     */
    private String headUrl;
    /**
     * 当前已经登陆的店铺
     */
    private ShopSession logshop;
    /**
     * 除当前登陆店铺以外的其它店铺
     */
    private List<ShopSession> otherShops;
    /**
     * 其它平台的session
     */
    private Map<String,Object> otherPlatform;

    public Map<String, Object> getOtherPlatform() {
        if(otherPlatform==null)
            otherPlatform=new HashMap<>();
        return otherPlatform;
    }

    public void setOtherPlatform(Map<String, Object> otherPlatform) {
        this.otherPlatform = otherPlatform;
    }

    public ShopSession getLogshop() {
        return logshop;
    }

    public void setLogshop(ShopSession logshop) {
        this.logshop = logshop;
    }

    public List<ShopSession> getOtherShops() {
        return otherShops;
    }

    public void setOtherShops(List<ShopSession> otherShops) {
        this.otherShops = otherShops;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getSubUserId() {
        return subUserId;
    }

    public void setSubUserId(Long subUserId) {
        this.subUserId = subUserId;
    }

    public String getUserNick() {
        return userNick;
    }

    public void setUserNick(String userNick) {
        this.userNick = userNick;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getHeadUrl() {
        return headUrl;
    }

    public void setHeadUrl(String headUrl) {
        this.headUrl = headUrl;
    }

    public LoginFromType getLoginFromType() {
        return loginFromType;
    }

    public void setLoginFromType(LoginFromType loginFromType) {
        this.loginFromType = loginFromType;
    }
}
