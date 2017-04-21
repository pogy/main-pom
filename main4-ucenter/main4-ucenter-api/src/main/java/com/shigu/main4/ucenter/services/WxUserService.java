package com.shigu.main4.ucenter.services;

/**
 * 微信用户服务
 * Created by zhaohongbo on 17/4/14.
 */
public interface WxUserService {
    /**
     * 按openIid获取用户ID
     * @param openIid
     * @return
     */
    Long selUserIdByOpenIid(String openIid);

    /**
     * 退出登陆
     * @param openIid
     */
    void logOut(String openIid);
}
