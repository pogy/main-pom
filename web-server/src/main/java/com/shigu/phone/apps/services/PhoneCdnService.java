package com.shigu.phone.apps.services;

import com.openJar.exceptions.OpenException;
import com.openJar.responses.app.ItemCollectResponse;
import com.shigu.phone.baseservices.BasePhoneCdnService;
import com.shigu.phone.basevo.BaseCollectItemVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

/**
 * cdn服务
 * Created by zhaohongbo on 17/3/7.
 */
@Service
public class PhoneCdnService {

    @Autowired
    private BasePhoneCdnService basePhoneCdnService;

    /**
     * 查询收藏的商品
     * @param userId
     * @return
     */
    public ItemCollectResponse selItemCollect(Long userId, Integer index, Integer pageSize,String webSite){
        ItemCollectResponse response = new ItemCollectResponse();
        try {
            BaseCollectItemVO baseCollectItemVO = basePhoneCdnService.selItemCollect(userId, index, pageSize,webSite);
            response.setItems(baseCollectItemVO.getItems());
            response.setTotal(baseCollectItemVO.getTotal());
            response.setHasNext(baseCollectItemVO.getHasNext());
            response.setSuccess(true);
        } catch (OpenException e) {
            e.printStackTrace();
        }
        return response;
    }

    /**
     * 收藏/取消收藏商品
     * @param userId
     * @return
     */
    public boolean addItemCollect(Long userId,Long storeId,Long goodsId,String webSite){
        return basePhoneCdnService.addItemCollect( userId, storeId, goodsId, webSite);
    }

    public void delItemCollect(Long userId, List<Long> collectIds){
        basePhoneCdnService.delItemCollect( userId, collectIds);
    }

}
