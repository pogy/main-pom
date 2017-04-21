package com.shigu.sysman.shop.service;


import com.opentae.data.mall.beans.ShiguMarket;
import com.opentae.data.mall.interfaces.ShiguMarketMapper;
import com.opentae.data.mall.interfaces.ShiguShopMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 市场SERVICE
 *
 *
 */
@Service
public class ShiguMarketService {

    @Autowired
    private ShiguMarketMapper shiguMarketMapper;


    /**
     * 市场列表
     * @param shiguMarket
     * @return
     */
    public List<ShiguMarket> findShiguMarketListo(ShiguMarket shiguMarket){
        List<ShiguMarket> shiguMarketlist = shiguMarketMapper.select(shiguMarket);
        return shiguMarketlist;
    }

    /**
     * 查询市场
     * @param marketId
     * @return
     */
    public ShiguMarket getShiguMarketById(Long marketId){
        ShiguMarket shiguMarket = shiguMarketMapper.selectByPrimaryKey(marketId);
        return shiguMarket;
    }

}
