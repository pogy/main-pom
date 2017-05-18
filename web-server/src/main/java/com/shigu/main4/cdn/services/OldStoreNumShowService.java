package com.shigu.main4.cdn.services;

import com.opentae.data.mall.interfaces.ShiguShopMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by zhaohongbo on 17/3/20.
 */
@Service
public class OldStoreNumShowService {

    @Autowired
    ShiguShopMapper shiguShopMapper;

    /**
     * 查出新的shopID
     * @param numIid
     * @return
     */
    public Long selShopId(Long numIid){
        return shiguShopMapper.selShopIdByNumId(numIid);
    }
}
