package com.shigu.main4.storeservices;

import com.shigu.main4.common.tools.ShiguPager;
import com.shigu.main4.vo.SearchShop;
import com.shigu.main4.vo.SearchShopSimple;

import java.util.List;

/**
 * 店铺搜索程序
 * Created by zhaohongbo on 17/4/5.
 */
public interface ShopSearchService {

    /**
     * 查单店商品
     * @param keyword
     * @param mid
     * @param page
     * @param pageSize
     * @return
     */
    ShiguPager<SearchShop> searchShop(String keyword,String webSite, Long mid, Integer page, Integer pageSize);

    /**
     * 按shopId查店信息
     * @param shopIds
     * @return
     */
    List<SearchShopSimple> selShopByIds(List<Long> shopIds, String website);


    /**
     * 按shopNum精确匹配一个店
     * @param shopNum
     * @return
     */
    List<SearchShopSimple>  selShopByShopNum(String shopNum,String webSite);
}
