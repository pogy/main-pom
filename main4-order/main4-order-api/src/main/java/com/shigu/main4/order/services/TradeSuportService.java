package com.shigu.main4.order.services;

import java.util.List;

/**
 * 交易支持度检测
 * Created by zhaohongbo on 17/7/21.
 */
public interface TradeSuportService {
    /**
     * 限制的市场ID列表
     * @param senderId
     * @return
     */
    List<Long> forbidMarketList(Long senderId);

    /**
     * 检测市场是否支持
     * @param senderId
     * @param marketId
     * @return
     */
    boolean checkMarket(Long senderId,Long marketId);

    /**
     * 检测店铺是否支持
     * @param senderId
     * @param shopId
     * @return
     */
    boolean checkShop(Long senderId,Long shopId);

    /**
     * 检测商品是否支持
     * @param senderId
     * @param goodsId
     * @return
     */
    boolean checkGoods(Long senderId,Long goodsId);
}
