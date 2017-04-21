package com.shigu.main4.ucenter.services;

import com.shigu.main4.common.exceptions.Main4Exception;
import com.shigu.session.main4.ShopSession;

import java.util.List;

/**
 * 用户的店铺信息
 * Created by Licca on 17/2/21.
 */
public interface UserShopService {
    /**
     * 按userId查出最近一次登陆的档口
     * @param userId
     * @return
     */
    ShopSession selShopByUserId(Long userId);

    /**
     * 查出当前用户所有可用店铺
     * @param userId
     * @return
     */
    List<ShopSession> selUsersAllShop(Long userId);

    /**
     * 用户切换店铺
     * @param userId
     * @param shopId
     */
    void changeShop(Long userId,Long shopId);

    /**
     * 按淘宝昵称绑定店铺
     * 如果用户不存在,throw异常
     * 如果店铺不存在,返回null
     * 设置成功,返回shop_id
     * @param nick
     * @return
     */
    Long bindNickToShop(String nick) throws Main4Exception;

}
