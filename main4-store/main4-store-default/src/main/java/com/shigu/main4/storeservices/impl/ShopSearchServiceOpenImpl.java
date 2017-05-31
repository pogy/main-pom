package com.shigu.main4.storeservices.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.aliyun.opensearch.SearcherClient;
import com.aliyun.opensearch.sdk.dependencies.com.google.common.collect.Lists;
import com.aliyun.opensearch.sdk.generated.commons.OpenSearchClientException;
import com.aliyun.opensearch.sdk.generated.commons.OpenSearchException;
import com.aliyun.opensearch.sdk.generated.search.Config;
import com.aliyun.opensearch.sdk.generated.search.SearchFormat;
import com.aliyun.opensearch.sdk.generated.search.SearchParams;
import com.aliyun.opensearch.sdk.generated.search.general.SearchResult;
import com.shigu.main4.common.exceptions.Main4Exception;
import com.shigu.main4.common.tools.ShiguPager;
import com.shigu.main4.common.util.BeanMapper;
import com.shigu.main4.vo.OpenShopVo;
import com.shigu.main4.vo.SearchShop;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 阿里开放搜索 实现店铺搜索
 * Created by bugzy on 2017/5/31 0031.
 */
@Service
public class ShopSearchServiceOpenImpl extends ShopSearchServiceImpl {

    private static final Logger logger = LoggerFactory.getLogger(ShopSearchServiceOpenImpl.class);

    @Autowired
    private SearcherClient searcherClient;

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
        ShiguPager<SearchShop> pager = new ShiguPager<>();
        pager.setNumber(page);

        Config config = new Config(Lists.newArrayList("search_shop"));
        config.setStart((page - 1) * page);
        config.setHits(pageSize);
        config.setSearchFormat(SearchFormat.JSON);
        SearchParams searchParams = new SearchParams(config);
        if (StringUtils.isNotEmpty(keyword)) {
            searchParams.setQuery("shop_info:'" + keyword + '\'');
        }
        String filter = "";
        if (StringUtils.isNotEmpty(webSite)) {
            filter = "web_site='" + webSite + "'";
        }
        if (mid != null) {
            if (StringUtils.isNotEmpty(filter)) {
                filter += " AND ";
            }
            filter += "market_id=" + mid;
        }
        if (StringUtils.isNotEmpty(filter)) {
            searchParams.setFilter(filter);
        }
        try {
            SearchResult result = searcherClient.execute(searchParams);
            JSONObject jsonObject = JSON.parseObject(result.getResult());
            if ("OK".equals(jsonObject.getString("status"))) {
                JSONObject data = jsonObject.getJSONObject("result");
                int total = data.getIntValue("total");
                pager.calPages(total, pageSize);
                JSONArray items = data.getJSONArray("items");
                List<OpenShopVo> openShopVos = items.toJavaList(OpenShopVo.class);
                ArrayList<SearchShop> shop = Lists.newArrayList();
                pager.setContent(shop);
                for (OpenShopVo vo : openShopVos) {
                    SearchShop searchShop = BeanMapper.map(vo, SearchShop.class);
                    searchShop.setMarket(vo.getMarketName());
                    shop.add(searchShop);
                }
            } else throw new Main4Exception(jsonObject.getString("errors"));
        } catch (OpenSearchException | OpenSearchClientException ignored) {
        } catch (Main4Exception e) {
            logger.error("搜索失败", e);
        }
        return pager;
    }
}
