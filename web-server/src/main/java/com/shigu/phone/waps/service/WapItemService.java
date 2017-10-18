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

    public BaseCollectItemVO collectItem(Long userId,Integer index,Integer size) throws OpenException {
       return baseItemService.collectItem(userId, index, size);
    }

}
