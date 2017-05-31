package com.shigu.main4.storeservices.impl;

import com.aliyun.opensearch.OpenSearchClient;
import com.shigu.main4.common.tools.ShiguPager;
import com.shigu.main4.storeservices.ShopSearchService;
import com.shigu.main4.vo.SearchShop;
import com.shigu.main4.vo.SearchShopSimple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 阿里开放搜索 实现店铺搜索
 * Created by bugzy on 2017/5/31 0031.
 */
@Service
public class ShopSearchServiceOpenImpl implements ShopSearchService {

    @Autowired
    private OpenSearchClient openSearchClient;

    /**
     * 查单店商品
     *
     * @param keyword 搜索词
     * @param webSite 分站
     * @param mid 市场ID
     * @param page 页码
     * @param pageSize 分页大小
     * @return 分页结构数据
     */
    @Override
    public ShiguPager<SearchShop> searchShop(String keyword, String webSite, Long mid, Integer page, Integer pageSize) {
        return null;
    }

    /**
     * 按shopId查店信息
     *
     * @param shopIds 店铺IDS
     * @param website 分站
     * @return 基本店铺信息
     */
    @Override
    public List<SearchShopSimple> selShopByIds(List<Long> shopIds, String website) {
        return null;
    }

    /**
     * 按shopNum精确匹配一个店
     *
     * @param shopNum 档口号
     * @param webSite 分站
     * @return 店铺信息
     */
    @Override
    public List<SearchShopSimple> selShopByShopNum(String shopNum, String webSite) {
        return null;
    }
}
