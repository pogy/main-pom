package com.shigu.main4.ucenter.services.impl;

import com.shigu.main4.tools.RedisIO;
import com.shigu.main4.ucenter.services.WxUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 微信用户服务
 * Created by zhaohongbo on 17/4/14.
 */
@Service("wxUserService")
public class WxUserServiceImpl implements WxUserService {
    @Autowired
    RedisIO redisIO;
    /**
     * 使用微信openIid换取userId
     * @param openIid
     * @return
     */
    @Override
    public Long selUserIdByOpenIid(String openIid) {
        return redisIO.get(openIid,Long.class);
    }

    @Override
    public void logOut(String openIid) {
        redisIO.del(openIid);
    }
}
