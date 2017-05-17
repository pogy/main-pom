package com.shigu.main4.monitor.services;

import com.shigu.main4.monitor.vo.ItemBrowerFlowVO;

import java.util.List;
import java.util.Map;

/**
 * 商品浏览记录服务
 * 基于redis
 * Created by zhaohongbo on 17/3/8.
 */
public interface ItemBrowerService {
    /**
     * 查询不真流量
     * @param itemId
     * @return
     */
    ItemBrowerFlowVO selUnrealBrower(Long itemId);

    /**
     * 创建不真流量缓存
     * @param itemId
     * @return
     */
    ItemBrowerFlowVO makeUnrealBrower(Long itemId);

    /**
     * 添加不真流量
     * @param itemId
     * @param number
     * @return
     */
    ItemBrowerFlowVO addUnrealBrower(Long itemId,Integer number);
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
