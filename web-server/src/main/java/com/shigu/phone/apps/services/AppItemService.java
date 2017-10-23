package com.shigu.phone.apps.services;

import com.openJar.exceptions.OpenException;
import com.openJar.requests.app.*;
import com.openJar.responses.app.*;
import com.shigu.main4.common.tools.StringUtil;
import com.shigu.phone.baseservices.BaseItemService;
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
            if (StringUtil.isNull(request.getWebSite()))request.setWebSite(null);
            BaseCollectItemVO baseCollectItemVO = baseItemService.selItemCollect(request.getUserId(), request.getIndex(), request.getSize(),request.getWebSite());
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
        OpenException openException = new OpenException();

        List<String> list = Arrays.asList(request.getCollectIds().split(","));
        List<Long> collectIds = new ArrayList<>();
        list.stream().filter(item->item.trim().matches("^([0-9])+$")).forEach(item->{
            collectIds.add(Long.parseLong(item.trim()));
        });
        if (collectIds == null || collectIds.isEmpty()) {
            response.setSuccess(true);
            return response;
        }

        if(baseItemService.delItemCollect(collectIds, request.getUserId())){
            response.setSuccess(true);
        }else{
            openException.setErrMsg("删除商品收藏夹数据失败");
            response.setException(openException);
            response.setSuccess(false);
        }
        return response;
    }

    public GoodsCollectResponse collectGoods(GoodsCollectRequest request){
        GoodsCollectResponse response = new GoodsCollectResponse();
        if(baseItemService.addItemCollect(request.getUserId(),
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
