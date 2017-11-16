package com.shigu.phone.waps.service;

import com.openJar.beans.app.*;
import com.openJar.exceptions.OpenException;
import com.shigu.phone.baseservices.BaseStoreService;
import com.shigu.phone.basevo.OneShopVO;
import com.shigu.phone.basevo.ShopCatVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * 类名：PhoneStoreService
 * 类路径：com.shigu.phone.apps.baseservices.PhoneStoreService
 * 创建者：王浩翔
 * 创建时间：2017-08-31 15:38
 * 项目：main-pom
 * 描述：
 */

@Service
public class WapStoreService {

    @Autowired
    private BaseStoreService baseStoreService;

    public OneShopVO selOneShopInfo(Long shopId,String webSite,Long userId) throws OpenException {
       return baseStoreService.selOneShopInfo(shopId, webSite, userId);
    }

    public AppMarket selMarketData(Long mid,String webSite) throws OpenException {
        return baseStoreService.selMarketData(mid,webSite);
    }

    public List<AppShopCat> selShopCat(String webSite,Long shopId) throws OpenException {
        ShopCatVO shopCatVO = baseStoreService.selShopCat(shopId);
        return shopCatVO.getCats();
    }

}
