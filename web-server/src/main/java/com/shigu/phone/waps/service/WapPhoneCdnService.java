package com.shigu.phone.waps.service;

import com.openJar.exceptions.OpenException;
import com.opentae.data.mall.beans.ShiguGoodsCollect;
import com.shigu.main4.ucenter.webvo.ItemCollectInfoVO;
import com.shigu.phone.baseservices.BasePhoneCdnService;
import com.shigu.phone.basevo.BaseCollectItemVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public BaseCollectItemVO selItemCollect(Long userId, Integer index, Integer pageSize,String webSite) throws OpenException {
        return basePhoneCdnService.selItemCollect(userId, index, pageSize,webSite);
    }

    /**
     * 收藏商品
     * @param userId
     * @return
     */
    public ShiguGoodsCollect collectItem( Long userId, Long storeId, Long goodsId, String webSite) throws OpenException {
        return basePhoneCdnService.collectItem(userId,storeId,goodsId,webSite);
    }

    public void delItemCollect(Long userId, List<Long> collectIds){
        basePhoneCdnService.delItemCollect(userId,collectIds);
    }

}
