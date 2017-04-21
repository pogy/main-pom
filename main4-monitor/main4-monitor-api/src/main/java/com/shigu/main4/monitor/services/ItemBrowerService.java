package com.shigu.main4.monitor.services;

import java.util.List;
import java.util.Map;

/**
 * 商品浏览记录服务
 * 基于redis
 * Created by zhaohongbo on 17/3/8.
 */
public interface ItemBrowerService {
    /**
     * 查询商品浏览量
     * @param itemId
     * @return
     */
    Long selItemBrower(Long itemId);

    /**
     * 批量聚合流量
     * @param itemIds
     * @return
     */
    Map<Long,Long> selMoreItemBrower(List<Long> itemIds);

}
