package com.shigu.main4.item.enums;

/**
 * 类名：ShopCountRedisCacheEnum
 * 类路径：com.shigu.main4.item.enums.ShopCountRedisCacheEnum
 * 创建者：王浩翔
 * 创建时间：2017-11-06 16:40
 * 项目：main-pom
 * 描述：
 */
public enum ShopCountRedisCacheEnum {
    SHOP_NO_LOW_PRICE_INDEX_("shop_no_low_price_index_in_redis_"),
    SHOP_NO_CONSITUTUENT_INDEX_("shop_no_consitutuent_index_in_redis_"),
    SHOP_NO_BIG_PIC_INDEX_("shop_no_big_pic_index_in_redis_"),
    ;
    public final String cacheName;

    ShopCountRedisCacheEnum(String cacheName) {
        this.cacheName = cacheName;
    }
}
