package com.shigu.phone.baseservices;

import com.openJar.exceptions.OpenException;
import com.shigu.phone.basevo.BaseCollectItemVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by pc on 2017-08-29.
 * app 店铺 service
 *
 * @author lys
 * @version 3.0.0-SNAPSHOT
 * @description
 * @since 3.0.0-SNAPSHOT
 */
@Service
public class BaseItemService {

    @Autowired
    private BasePhoneCdnService basePhoneCdnService;

    public BaseCollectItemVO collectItem(Long userId, Integer index, Integer size) throws OpenException {
        return basePhoneCdnService.selItemCollect(userId,index, size);
    }

    public Boolean delItemCollect(List<Long> collectIds,Long userId){
        try {

            basePhoneCdnService.delItemCollect(userId,collectIds);
            return Boolean.TRUE;
        } catch (Exception e) {
            return Boolean.FALSE;
        }

    }

    public Boolean collectGoods(Long userId,Long storeId,Long goodsId,String webSite ){
        return basePhoneCdnService.addItemCollect(userId,storeId,goodsId,webSite);
    }



}
