package com.shigu.phone.waps.service;

import com.openJar.exceptions.OpenException;
import com.openJar.requests.app.DelItemCollectRequest;
import com.openJar.requests.app.GoodsCollectRequest;
import com.openJar.requests.app.ItemCollectRequest;
import com.openJar.responses.app.DelItemCollectResponse;
import com.openJar.responses.app.GoodsCollectResponse;
import com.openJar.responses.app.ItemCollectResponse;
import com.shigu.main4.tools.RedisIO;
import com.shigu.phone.services.PhoneCdnService;
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
public class WapItemService {

    @Autowired
    private PhoneCdnService phoneCdnService;
    @Autowired
    private RedisIO redisIO;

    public ItemCollectResponse collectItem(ItemCollectRequest request){
        return phoneCdnService.selItemCollect(request.getUserId(), request.getIndex(), request.getSize());
    }

    public DelItemCollectResponse delItemCollect(DelItemCollectRequest request){
        DelItemCollectResponse response = new DelItemCollectResponse();
        //验证不通过
        if (!request.getToken().equals(redisIO.get("phone_login_token" + request.getUserId()))) {
            OpenException openException = new OpenException();
            openException.setErrMsg("tocken验证失败");
            response.setException(openException);
            response.setSuccess(false);
            return response;
        }

        try {
            List<String> list = Arrays.asList(request.getCollectIds().split(","));
            List<Long> collectIds = new ArrayList<>();
            list.stream().filter(item->item.trim().matches("^([0-9])+$")).forEach(item->{
                collectIds.add(Long.parseLong(item.trim()));
            });
            phoneCdnService.delItemCollect(request.getUserId(),collectIds);

            response.setSuccess(true);
            return response;
        } catch (Exception e) {
            OpenException openException = new OpenException();
            openException.setErrMsg("删除商品收藏夹数据失败");
            response.setException(openException);
            response.setSuccess(false);
            return response;
        }
    }

    public GoodsCollectResponse collectItem(GoodsCollectRequest request){
        GoodsCollectResponse response = new GoodsCollectResponse();
        Boolean isSuccess = phoneCdnService.addItemCollect(request.getUserId(),request.getStoreId(),request.getGoodsId(),request.getWebSite());
        response.setSuccess(isSuccess);
        if (!isSuccess){
            OpenException openException = new OpenException();
            openException.setErrMsg("收藏失败");
            response.setException(openException);
        }
        return response;
    }



}
