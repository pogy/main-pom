package com.shigu.phone.waps.service;

import com.openJar.beans.app.AppGoodsBlock;
import com.openJar.exceptions.OpenException;
import com.openJar.responses.app.ItemCollectResponse;
import com.opentae.data.mall.beans.ShiguMarket;
import com.opentae.data.mall.beans.ShiguShop;
import com.opentae.data.mall.examples.ShiguMarketExample;
import com.opentae.data.mall.examples.ShiguShopExample;
import com.opentae.data.mall.interfaces.ShiguGoodsIdGeneratorMapper;
import com.opentae.data.mall.interfaces.ShiguMarketMapper;
import com.opentae.data.mall.interfaces.ShiguShopMapper;
import com.shigu.main4.common.tools.ShiguPager;
import com.shigu.main4.common.util.BeanMapper;
import com.shigu.main4.item.services.ItemSearchService;
import com.shigu.main4.item.vo.SearchItem;
import com.shigu.main4.ucenter.exceptions.ItemCollectionException;
import com.shigu.main4.ucenter.services.UserBaseService;
import com.shigu.main4.ucenter.services.UserCollectService;
import com.shigu.main4.ucenter.vo.ItemCollect;
import com.shigu.main4.ucenter.vo.UserInfo;
import com.shigu.main4.ucenter.webvo.ItemCollectInfoVO;
import com.shigu.phone.baseservices.BasePhoneCdnService;
import com.shigu.phone.basevo.BaseCollectItemVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * cdn服务
 * Created by zhaohongbo on 17/3/7.
 */
@Service
public class WapPhoneCdnService{
    @Autowired
    private BasePhoneCdnService basePhoneCdnService;

    /**
     * 查询收藏的商品
     * @param userId
     * @return
     */
    public BaseCollectItemVO selItemCollect(Long userId, Integer index, Integer pageSize) throws OpenException {
        return basePhoneCdnService.selItemCollect(userId, index, pageSize);
    }

    /**
     * 收藏/取消收藏商品
     * @param userId
     * @return
     */
    public boolean addItemCollect(Long userId,Long storeId,Long goodsId,String webSite){
        return basePhoneCdnService.addItemCollect(userId,storeId,goodsId,webSite);
    }

    public void delItemCollect(Long userId, List<Long> collectIds){
        basePhoneCdnService.delItemCollect(userId,collectIds);
    }

}
