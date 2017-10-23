package com.shigu.phone.waps.service;

import com.openJar.exceptions.OpenException;
import com.shigu.phone.baseservices.BaseItemService;
import com.shigu.phone.basevo.BaseCollectItemVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    private BaseItemService baseItemService;

    public void delItemCollect(List<Long> collectIds, Long userId){
        baseItemService.delItemCollect(collectIds,userId);
    }

    public BaseCollectItemVO selItemCollect(Long userId,Integer index,Integer size,String webSite) throws OpenException {
       return baseItemService.selItemCollect(userId, index, size,webSite);
    }

    public Long hasCollected(String goodsId, Long userId) throws OpenException {
        Long id;
        try {
            id = Long.parseLong(goodsId);
        } catch (NumberFormatException e) {
            OpenException openException = new OpenException();
            openException.setErrMsg("查询失败["+ goodsId +"不能被转化成Long类型]");
            throw openException;
        }
        return baseItemService.hasCollected(id, userId);
    }

}
