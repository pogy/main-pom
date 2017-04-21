package com.shigu.main4.cdn.services;

import com.opentae.data.mall.beans.ShiguStoreNumShow;
import com.opentae.data.mall.interfaces.ShiguStoreNumShowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by zhaohongbo on 17/3/20.
 */
@Service
public class OldStoreNumShowService {

    @Autowired
    ShiguStoreNumShowMapper shiguStoreNumShowMapper;

    /**
     * 查出新的shopID
     * @param numIid
     * @return
     */
    public Long selShopId(Long numIid){
        ShiguStoreNumShow numShow=shiguStoreNumShowMapper.selectByPrimaryKey(numIid);
        if(numShow!=null){
            return numShow.getStoreId();
        }
        return null;
    }
}
