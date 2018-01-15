package com.shigu.phone.waps.service;

import com.openJar.exceptions.OpenException;
import com.opentae.data.mall.beans.ShiguStoreCollect;
import com.shigu.phone.baseservices.BasedPhoneStoreService;
import com.shigu.phone.basevo.ShopSearchVO;
import com.shigu.phone.basevo.StoreCollectVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
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
public class WapPhoneStoreService {

    @Autowired
    private BasedPhoneStoreService basedPhoneStoreService;

    /**
     * 移动端店铺搜索
     * @param keyword
     * @param webSite
     * @param index
     * @param size
     * @return
     */
    public ShopSearchVO shopSearch(String keyword, String webSite, Integer index, Integer size) {
       return basedPhoneStoreService.shopSearch(keyword, webSite, index, size);
    }

    /**
     * 店铺收藏夹
     *
     * @return
     */
    public StoreCollectVO storeCollect(String webSite,Long userId,Integer index,Integer size) {
        return basedPhoneStoreService.storeCollect(userId, webSite, index, size);
    }

    /**
     * 收藏OR取消收藏店铺
     *
     * @return
     */
    public void doStoreCollect(Long shopId,Boolean yesOrNo,Long userId) throws OpenException {
        basedPhoneStoreService.doStoreCollect(shopId,yesOrNo,userId);
    }

    /**
     * 收藏店铺
     *
     * @return
     */
    public ShiguStoreCollect collectStore(Long userId,Long shopId) throws OpenException {
        return basedPhoneStoreService.collectStore(userId,shopId);
    }


    /**
     * 批量取消收藏店铺
     *
     * @return
     */
    public void delStoreCollect(List<Long> collectIds, Long userId){
        basedPhoneStoreService.delShopCollection(userId,collectIds);
    }

    public Long hasCollected(String storeId, Long userId) throws OpenException {
        Long id;
        try {
            id = Long.parseLong(storeId);
        } catch (NumberFormatException e) {
            OpenException openException = new OpenException();
            openException.setErrMsg("查询失败["+ storeId +"不能被转化成Long类型]");
            throw openException;
        }
        return basedPhoneStoreService.hasCollected(id,userId);
    }
}
