package com.shigu.main4.item.services;

import com.aliyun.opensearch.SearcherClient;
import com.aliyun.opensearch.sdk.dependencies.com.google.common.collect.Lists;
import com.aliyun.opensearch.sdk.generated.commons.OpenSearchClientException;
import com.aliyun.opensearch.sdk.generated.commons.OpenSearchException;
import com.aliyun.opensearch.sdk.generated.search.*;
import com.aliyun.opensearch.sdk.generated.search.general.SearchResult;
import com.opentae.data.mall.interfaces.ShiguShopMapper;
import com.shigu.main4.common.exceptions.Main4Exception;
import com.shigu.main4.common.tools.ShiguPager;
import com.shigu.main4.common.util.BeanMapper;
import com.shigu.main4.common.util.HighLightKit;
import com.shigu.main4.item.enums.SearchCategory;
import com.shigu.main4.item.enums.SearchOrderBy;
import com.shigu.main4.item.vo.*;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;


/**
 * Created by zlm on 2017/6/13.
 *
 * @author zlm
 * @version main_site4.0 4.0.0
 * @since main_site4.0 4.0.0
 */
@Service("itemSearchOpenService")
public class ItemSearchOpenServiceImpl implements ItemSearchService  {

    public static final Pattern CHS_PATTERN = Pattern.compile("[\\u4E00-\\u9FA5]+");
    public static final Pattern LETTER_PATTERN = Pattern.compile("[a-zA-Z]");
    public static final Pattern NUMBER_PATTERN = Pattern.compile("[0-9]+");

    private static final Logger logger = LoggerFactory.getLogger(ItemSearchOpenServiceImpl.class);


    @Qualifier(value = "searcherItemClient")
    @Autowired
    private SearcherClient searcherItemClient;

    @Autowired
    private ShiguShopMapper shiguShopMapper;
    /**
     * 搜索主方法
     *
     * @param keyword        关键词
     * @param mid            市场ID
     * @param cids           叶子类目ID
     * @param shouldStoreIds 应该关联的店铺
     * @param priceFrom      批价开始
     * @param priceTo        批价结束
     * @param timeForm       created时间开始
     * @param timeTo         created时间结束
     * @param orderCase      条件
     * @param page           当前页码
     * @param pageSize       每页条数
     * @return
     */
    @Override
    public ShiguAggsPager searchItem(String keyword, String webSite, Long mid, List<Long> cids, List<Long> shouldStoreIds, Double priceFrom, Double priceTo, Date timeForm, Date timeTo, SearchOrderBy orderCase, Integer page, Integer pageSize, boolean aggs) {
        ShiguAggsPager pager = new ShiguAggsPager();
        pager.setNumber(page);

        Config config = new Config(Lists.newArrayList("goods_search_hz"));
        config.setStart((page - 1) * page);
        config.setHits(pageSize);
        config.setFetchFields(Lists.newArrayList("goods_id", "title", "goods_no", "pic_url", "cid", "created", "price", "goods_level", "parent_market_id"));
        config.setSearchFormat(SearchFormat.JSON);
        SearchParams searchParams = new SearchParams(config);
        String keywordNum = keyword.replaceAll(CHS_PATTERN.toString(), "");
        String keywordChina = keyword.replaceAll(NUMBER_PATTERN.toString(), "");
        if (StringUtils.isNotEmpty(keyword)) {
            String query = "";
            if(StringUtils.isNotEmpty(keywordChina)){
                query += "title:'"+keywordChina+"'";
            }
            if(StringUtils.isNotEmpty(keywordNum)){
                if (StringUtils.isEmpty(query)) {
                    query +="goods_no:'"+keywordNum+"'";
                } else {
                    query += " OR goods_no:'"+keywordNum+"'";
                }
            }
            searchParams.setQuery(query);
        }
        String filter = "is_closed = 0";
        String cidsStr = "";
        if (cids != null && !cids.isEmpty()) {
            StringBuffer cidSb = new StringBuffer();
            for (Long item : cids) {
                cidSb.append(item.toString()).append("|");
            }
            filter += " AND ";
            cidsStr = cidSb.toString().substring(0, cidSb.toString().length()-2);
            filter += "in(cid, \"" + cidsStr + "\")";
        }

        if (shouldStoreIds != null && !shouldStoreIds.isEmpty()) {
            StringBuffer sidSb = new StringBuffer();
            for (Long item : shouldStoreIds) {
                sidSb.append(item.toString()).append("|");
            }
            filter += " AND ";
            filter += "in(store_id, \"" + sidSb.toString().substring(0, sidSb.toString().length()-2) + "\")";
        }

        if (mid != null) {
            filter += " AND ";
            filter += "parent_market_id=" + mid;
        }

        // 4. 价格区间
        if (priceFrom != null) {
            filter += " AND ";
            Double price = priceFrom * 100;
            filter += "pi_price>=" + price.longValue();
        }
        if (priceTo != null) {
            filter += " AND ";
            Double price = priceTo * 100;
            filter += "pi_price<=" + price.longValue();
        }

        // 5. 时间区间
        if (timeForm != null) {
            filter += " AND ";
            filter += "created>=" + timeForm.getTime();
        }
        if (timeTo != null) {
            filter += " AND ";
            filter += "created<=" + timeTo.getTime();
        }
        if (StringUtils.isNotEmpty(filter)) {
            searchParams.setFilter(filter);
        }

        // 6. 排序规则
        Sort sorter = new Sort();
        switch (orderCase) {
            case NEW:
                sorter.addToSortFields(new SortField("created", Order.DECREASE));
                searchParams.setSort(sorter);
                break;
            case COMMON:
                break;
            case GOODS_COMMON:
                sorter.addToSortFields(new SortField("sort_order", Order.DECREASE));
                sorter.addToSortFields(new SortField("created", Order.DECREASE));
                break;
            case SALE:
                break;
            case CLICK:
                break;
            case PRICEUP:
                sorter.addToSortFields(new SortField("pi_price", Order.INCREASE));
                break;
            case PRICEDOWN:
                sorter.addToSortFields(new SortField("pi_price", Order.DECREASE));
                break;
            case GOODSUP:
                break;
        }
        searchParams.setSort(sorter);

        Aggregate agg = new Aggregate();
        agg.setGroupKey("cid"); //设置group_key
        agg.setAggFun("count()"); //设置agg_fun
        if (mid != null) {
            agg.setAggFilter("parent_market_id=" + mid); //设置agg_filter
        }
        agg.setMaxGroup("100"); //设置最大返回组数
        searchParams.addToAggregates(agg);

        agg = new Aggregate();
        agg.setGroupKey("parent_market_id"); //设置group_key
        agg.setAggFun("count()"); //设置agg_fun
        if (StringUtils.isNotEmpty(cidsStr)) {
            agg.setAggFilter("in(cid, \"" + cidsStr + "\")"); //设置agg_filter
        }
        agg.setMaxGroup("100"); //设置最大返回组数
        searchParams.addToAggregates(agg);

        try {
            SearchResult result = searcherItemClient.execute(searchParams);
            JSONObject jsonObject = JSON.parseObject(result.getResult());
            if ("OK".equals(jsonObject.getString("status"))) {
                JSONObject data = jsonObject.getJSONObject("result");
                int total = data.getIntValue("total");
                pager.calPages(total, pageSize);
                List<SearchItem> itemList = Lists.newArrayList();
                pager.setContent(itemList);

                JSONArray items = data.getJSONArray("items");
                List<OpenItemVo> openItemVos = items.toJavaList(OpenItemVo.class);
                if (!openItemVos.isEmpty()) {
                    HighLightKit defaultInstance = HighLightKit.getDefaultInstance();
                    for (OpenItemVo vo : openItemVos) {
                        SearchItem searchItem = BeanMapper.map(vo, SearchItem.class);
                        searchItem.setHighLightTitle(defaultInstance.bright(keyword, vo.getTitle()));
                        searchItem.setHighLightGoodsNo(defaultInstance.bright(keyword, vo.getGoodsNo()));
                        itemList.add(searchItem);
                    }
                }
                JSONArray facetItems = data.getJSONArray("facet");
                int len = facetItems.size();
                if (0< len) {
                    for (int i=0; i< len ;i++) {
                        JSONObject facetItem = facetItems.getJSONObject(i);
                        JSONArray jsonArray =  facetItem.getJSONArray("items");
                        if ("cid".equalsIgnoreCase(facetItem.getString("key"))) {
                            pager.setParentCats(jsonArray.toJavaList(AggsCount.class));
                        } else if ("parent_market_id".equalsIgnoreCase(facetItem.getString("key"))) {
                            pager.setMarkets(jsonArray.toJavaList(AggsCount.class));
                        }
                    }
                }


            } else throw new Main4Exception(jsonObject.getString("errors"));
        } catch (OpenSearchException | OpenSearchClientException ignored) {

        } catch (Main4Exception e) {
            logger.error("搜索失败", e);
        }
        return pager;
    }

    @Override
    public ShiguPager<SearchItem> searchItemByIds(List<Long> ids, String webSite, Integer page, Integer pageSize) {
        return null;
    }

    @Override
    public List<CategoryValue> selCategory(SearchCategory category, String webSite) {
        return null;
    }

    @Override
    public List<CategoryValue> selSubCategory(String parentCateValue, SearchCategory category, String website) {
        return null;
    }
}
