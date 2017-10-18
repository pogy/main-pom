package com.shigu.phone.apps.services;

import com.openJar.beans.app.AppGoodsBlock;
import com.openJar.exceptions.OpenException;
import com.openJar.requests.app.*;
import com.openJar.responses.app.*;
import com.shigu.main4.tools.RedisIO;
import com.shigu.phone.baseservices.BaseItemService;
import com.shigu.phone.baseservices.BasePhoneCdnService;
import com.shigu.phone.basevo.BaseCollectItemVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

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
public class AppItemService {

    @Autowired
    private BaseItemService baseItemService;

    public ItemCollectResponse collectItem(ItemCollectRequest request){
        ItemCollectResponse response = new ItemCollectResponse();
        try {
            BaseCollectItemVO baseCollectItemVO = baseItemService.collectItem(request.getUserId(), request.getIndex(), request.getSize());
            response.setSuccess(true);
            response.setHasNext(baseCollectItemVO.getHasNext());
            response.setTotal(baseCollectItemVO.getTotal());
            response.setItems(baseCollectItemVO.getItems());
        } catch (OpenException e) {
            response.setSuccess(false);
            response.setException(e);
        }
        return response;
    }

    public DelItemCollectResponse delItemCollect(DelItemCollectRequest request){
        DelItemCollectResponse response = new DelItemCollectResponse();
        if(baseItemService.delItemCollect(request.getCollectIds(), request.getUserId())){
            response.setSuccess(true);
        }else{
            OpenException openException = new OpenException();
            openException.setErrMsg("删除商品收藏夹数据失败");
            response.setException(openException);
            response.setSuccess(false);
        }
        return response;
    }

    public GoodsCollectResponse collectGoods(GoodsCollectRequest request){
        GoodsCollectResponse response = new GoodsCollectResponse();
        if(baseItemService.collectGoods(request.getUserId(),
                request.getStoreId(), request.getGoodsId(), request.getWebSite())){
            response.setSuccess(true);
        }else{
            OpenException openException = new OpenException();
            openException.setErrMsg("收藏失败");
            response.setException(openException);
        }
        return response;
    }



}
