package com.shigu.main4.item.services;

/**
 * 批发价计算
 * Created by zhaohongbo on 17/2/25.
 */
public interface PriceCalculateService {
    /**
     * 计算批发价
     * @param shopId 店铺ID
     * @param price 原价,分为单位
     * @param strs 来源   {标题 , 货号  ,  外部编号,,,,} 将以此顺序匹配
     *                  {title,huohao,outerId,,,,}
     * @return 批发价
     */
    Long pickPipriceFromTitle(Long shopId,Long price,String ... strs);
}
