package com.shigu.main4.ucenter.services;

import com.shigu.main4.ucenter.bo.ShopeeUserBO;

/**
 * 类名：ShopeeUserService
 * 类路径： com.shigu.main4.ucenter.services.ShopeeUserService
 * 创建者： whx
 * 创建时间： 10/22/18 3:18 PM
 * 项目： main-pom
 * 描述：
 */
public interface ShopeeUserService {

    void refreshShopeeUserInfo(ShopeeUserBO bo);

    ShopeeUserBO selShopeeInfo(Long userId);
}
