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
    @Deprecated
    Long pickPipriceFromTitle(Long shopId,Long price,String ... strs);


    /**
     *
     * 特别注意:该方法在ModPriceCalculateServiceImpl中未实现
     *
     * 计算批发价
     * @param shopId 店铺ID
     * @param itemId 商品ID
     * @param numIid 淘宝商品ID
     *               如果传递了商品ID或淘宝商品ID,则如果出现以下匹配异常,将被写入匹配异常表
     *                          1:匹配出的价格存在被抛弃的
     *                          2:匹配出的价格存在超过零售价的
     *                          3:未匹配出价格的
     * @param price 原价,分为单位
     * @param strs 来源   {标题 , 货号  ,  外部编号,,,,} 将以此顺序匹配
     *                  {title,huohao,outerId,,,,}
     * @return 批发价
     */
    Long pickPipriceFromTitle(Long shopId,String webSite,Long itemId,Long numIid,Long price,String ... strs);
}
