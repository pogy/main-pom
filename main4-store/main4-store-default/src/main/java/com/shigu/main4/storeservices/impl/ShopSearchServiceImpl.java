package com.shigu.main4.storeservices.impl;

import com.alibaba.fastjson.JSON;
import com.searchtool.configs.ElasticConfiguration;
import com.shigu.main4.common.tools.ShiguPager;
import com.shigu.main4.common.util.BeanMapper;
import com.shigu.main4.common.util.HighLightKit;
import com.shigu.main4.storeservices.ShopSearchService;
import com.shigu.main4.vo.SearchShop;
import com.shigu.main4.vo.SearchShopSimple;
import com.shigu.main4.vo.ShopInES;
import org.apache.commons.lang3.StringUtils;
import org.elasticsearch.action.search.SearchType;
import org.elasticsearch.common.text.Text;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.highlight.HighlightField;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by wxc on 2017/4/5.
 *
 * @author wxc
 * @version main_site4.0 4.0.0
 * @since main_site4.0 4.0.0
 */
@Service
public class ShopSearchServiceImpl implements ShopSearchService {

    public static final Pattern CHS_PATTERN = Pattern.compile("[\\u4E00-\\u9FA5]+");
    public static final Pattern LETTER_PATTERN = Pattern.compile("[a-zA-Z]");
    public static final Pattern NUMBER_PATTERN = Pattern.compile("[0-9]+");
    /**
     * 档口搜索
     *
     * @param keyword
     * @param mid
     * @param page
     * @param pageSize
     * @return
     */
    @Override
    public ShiguPager<SearchShop> searchShop(String keyword,String webSite, Long mid, Integer page, Integer pageSize) {
        ShiguPager<SearchShop> pager = new ShiguPager<>();
        pager.setNumber(page);

        BoolQueryBuilder qb = QueryBuilders.boolQuery().must(QueryBuilders.termQuery("shop_status", 0L));
        if (StringUtils.isNotBlank(keyword)) {
            keyword = keyword.replaceAll("\\s+", "");
            if (keyword.length() > 30) {
                keyword = keyword.substring(0, 30);
            }
            Matcher matcher = CHS_PATTERN.matcher(keyword);
            while (matcher.find()) {
                qb.must(QueryBuilders.matchQuery("market", matcher.group()));
            }
            String keywordNum = keyword.replaceAll(CHS_PATTERN.toString(), "");
            qb.should(QueryBuilders.matchQuery("shop_num", keywordNum)).boost(5);
            qb.should(QueryBuilders.termQuery("market_id", 1087));
            Matcher numMatch = NUMBER_PATTERN.matcher(keywordNum);
            while (numMatch.find()) {
                qb.must(QueryBuilders.wildcardQuery("shop_num", "*" + numMatch.group()+"*"));
            }
        }

        if (mid != null) {
            qb.must(QueryBuilders.termQuery("market_id", mid));
        }

        SearchHits response = ElasticConfiguration.searchClient.prepareSearch("shop").setSize(pageSize).setFrom((page - 1) * pageSize)
                .setQuery(qb)
                .addHighlightedField("shop_num")
                .addHighlightedField("market")
                .setHighlighterPreTags("<font style='color:red;'>")
                .setHighlighterPostTags("</font>")
                .setSearchType(SearchType.DEFAULT)
                .setTypes(webSite)
                .execute().actionGet().getHits();
        long totalHits = response.getTotalHits();
        pager.setTotalCount((int) totalHits);
        pager.setTotalPages((int) ((totalHits - 1) / pageSize + 1));
        pager.setContent(new ArrayList<SearchShop>());
        if (totalHits > 0) {
            HighLightKit kit = HighLightKit.getDefaultInstance();
            for (SearchHit hit : response.getHits()) {
                ShopInES shopInES = JSON.parseObject(hit.getSourceAsString(), ShopInES.class);
                SearchShop searchShop = BeanMapper.map(shopInES, SearchShop.class);
                searchShop.setMainCase(shopInES.getMainBus());
                searchShop.setHighLightShopNum(kit.bright(keyword, searchShop.getShopNum()));
                searchShop.setHighLightMarket(kit.bright(keyword, searchShop.getMarket()));

                /*Map<String, HighlightField> highlightFieldMap = hit.highlightFields();
                HighlightField market = highlightFieldMap.get("market");
                if (market != null) {
                    searchShop.setHighLightMarket(StringUtils.join(market.fragments()));
                } else {
                    searchShop.setHighLightMarket(searchShop.getMarket());
                }
                HighlightField shop_num = highlightFieldMap.get("shop_num");
                if (shop_num != null) {
                    searchShop.setHighLightShopNum(StringUtils.join(shop_num.fragments()));
                } else {
                    searchShop.setHighLightShopNum(searchShop.getShopNum());
                }*/

                pager.getContent().add(searchShop);
            }
        }
        return pager;
    }

    /**
     * 按shopId查店信息
     *
     * @param shopIds
     * @return
     */
    @Override
    public List<SearchShopSimple> selShopByIds(List<Long> shopIds) {
        if (shopIds == null || shopIds.isEmpty()) {
            return Collections.emptyList();
        }
        return selShopSimpleFromEs(QueryBuilders.termsQuery("shop_id", shopIds),"hz");
    }

    /**
     * 按shopNum精确匹配一个店
     *
     * @param shopNum
     * @return
     */
    @Override
    public List<SearchShopSimple> selShopByShopNum(String shopNum,String webSite) {
        if (StringUtils.isEmpty(shopNum))
            return Collections.emptyList();
        List<SearchShopSimple> shopSimples = selShopSimpleFromEs(QueryBuilders.matchQuery("shop_num", shopNum),webSite);
        List<SearchShopSimple> simples = new ArrayList<>();
        for (int i = 0; i < shopSimples.size(); i++) {
            SearchShopSimple searchShopSimple = shopSimples.get(i);
            if (searchShopSimple.getShopNum().equals(shopNum))
                simples.add(searchShopSimple);
            else
                break;
        }
        return simples;
    }

    private List<SearchShopSimple> selShopSimpleFromEs(QueryBuilder qb,String type) {
        SearchHits response = ElasticConfiguration.searchClient.prepareSearch("shop").setSize(1000)
                .setQuery(QueryBuilders.boolQuery()
                        .must(qb).filter(QueryBuilders.termQuery("shop_status", 0L))
                ).setTypes(type).execute().actionGet().getHits();
        List<SearchShopSimple> shopSimples = new ArrayList<>();
        if (response.getTotalHits() > 0) {
            for (SearchHit hit : response.getHits()) {
                ShopInES shopInES = JSON.parseObject(hit.getSourceAsString(), ShopInES.class);
                SearchShopSimple searchShopSimple = BeanMapper.map(shopInES, SearchShopSimple.class);
                searchShopSimple.setMainCase(shopInES.getMainBus());
                shopSimples.add(searchShopSimple);
            }
        }
        return shopSimples;
    }
}
