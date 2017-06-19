package com.shigu.main4.item.services;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.aliyun.opensearch.SearcherClient;
import com.aliyun.opensearch.sdk.dependencies.com.google.common.collect.Lists;
import com.aliyun.opensearch.sdk.generated.commons.OpenSearchClientException;
import com.aliyun.opensearch.sdk.generated.commons.OpenSearchException;
import com.aliyun.opensearch.sdk.generated.search.*;
import com.aliyun.opensearch.sdk.generated.search.general.SearchResult;
import com.aliyun.opensearch.search.SearchParamsBuilder;
import com.opentae.data.mall.beans.ESGoods;
import com.opentae.data.mall.beans.ShiguGoodsTiny;
import com.opentae.data.mall.examples.SearchCategoryExample;
import com.opentae.data.mall.examples.SearchCategorySubExample;
import com.opentae.data.mall.examples.ShiguGoodsTinyExample;
import com.opentae.data.mall.interfaces.SearchCategoryMapper;
import com.opentae.data.mall.interfaces.SearchCategorySubMapper;
import com.opentae.data.mall.interfaces.ShiguGoodsTinyMapper;
import com.searchtool.configs.ElasticConfiguration;
import com.shigu.main4.common.exceptions.Main4Exception;
import com.shigu.main4.common.tools.ShiguPager;
import com.shigu.main4.common.util.BeanMapper;
import com.shigu.main4.common.util.HighLightKit;
import com.shigu.main4.item.enums.SearchCategory;
import com.shigu.main4.item.enums.SearchOrderBy;
import com.shigu.main4.item.vo.*;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.BoostingQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.aggregations.Aggregation;
import org.elasticsearch.search.aggregations.AggregationBuilder;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.aggregations.bucket.filter.InternalFilter;
import org.elasticsearch.search.aggregations.bucket.terms.Terms;
import org.elasticsearch.search.highlight.HighlightField;
import org.elasticsearch.search.sort.SortOrder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.regex.Pattern;

/**
 * Created by wxc on 2017/4/4.
 *
 * @author wxc
 * @version main_site4.0 4.0.0
 * @since main_site4.0 4.0.0
 */
@Service
public class ItemSearchServiceImpl implements ItemSearchService {

    private static final Logger logger = LoggerFactory.getLogger(ItemSearchServiceImpl.class);

    private static final String SEARCH_APP = "goods_search_";


    public static final Pattern CHS_PATTERN = Pattern.compile("[\\u4E00-\\u9FA5]+");
    public static final Pattern LETTER_PATTERN = Pattern.compile("[a-zA-Z]");
    public static final Pattern NUMBER_PATTERN = Pattern.compile("[0-9]+");


    @Autowired
    private SearcherClient searcherClient;

    @Autowired
    private SearchCategoryMapper searchCategoryMapper;

    @Autowired
    private SearchCategorySubMapper searchCategorySubMapper;

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
    public ShiguAggsPager searchItem(String keyword, String webSite, Long mid, List<Long> cids, List<Long> shouldStoreIds, String sid, Double priceFrom, Double priceTo, Date timeForm, Date timeTo, SearchOrderBy orderCase, Integer page, Integer pageSize, boolean aggs) {
        ShiguAggsPager pager = new ShiguAggsPager();
        pager.setNumber(page);

        Config config = new Config(Lists.newArrayList("goods_search_hz"));
        config.setStart((page - 1) * pageSize);
        config.setHits(pageSize);
        config.setFetchFields(Lists.newArrayList("goods_id", "title", "goods_no", "pic_url", "cid", "created", "price", "goods_level", "parent_market_id", "store_id"));
        config.setSearchFormat(SearchFormat.JSON);
        SearchParams searchParams = new SearchParams(config);

        if (StringUtils.isNotEmpty(keyword)) {
            String keywordNum = keyword.replaceAll(CHS_PATTERN.toString(), "");
            String keywordChina = keyword.replaceAll(NUMBER_PATTERN.toString(), "");
            String query = "";
            if (StringUtils.isNotEmpty(keywordChina)) {
                query += "title:'" + keywordChina + "'";
            }
            if (StringUtils.isNotEmpty(keywordNum)) {
                if (StringUtils.isEmpty(query)) {
                    query += "goods_no:'" + keywordNum + "'";
                } else {
                    query += " OR goods_no:'" + keywordNum + "'";
                }
            }
            if (StringUtils.isNotEmpty(sid)) {
                if (StringUtils.isEmpty(query)) {
                    query += "sids:'" + sid + "'";
                } else {
                    query ="(" + query + ")";
                    query += " AND sids:'" + sid + "'";
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
            cidsStr = cidSb.toString().substring(0, cidSb.toString().length() - 2);
            filter += "in(cid, \"" + cidsStr + "\")";
        }

//        if (shouldStoreIds != null && !shouldStoreIds.isEmpty()) {
//            StringBuffer sidSb = new StringBuffer();
//            for (Long item : shouldStoreIds) {
//                sidSb.append(item.toString()).append(":");
//            }
//            filter += " AND ";
//
//            String user_option =  sidSb.substring(0, sidSb.length()-2) ;
////            filter += "tag_match(\"" + user_option +"\",  \"store_id\", 10, \"sum\", \"false\",\"false\")";
//            filter += "tag_match(\"35749:32861:16573:41603:35782:41836:29858:39959:40721:15908:40097:42538:3905\",  store_id, 10, \"sum\", \"false\",\"false\")";
//
//        }

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
            SearchResult result = searcherClient.execute(searchParams);
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
                        searchItem.setItemId(vo.getGoodsId());
                        searchItem.setHighLightTitle(defaultInstance.bright(keyword, vo.getTitle()));
                        searchItem.setHighLightGoodsNo(defaultInstance.bright(keyword, vo.getGoodsNo()));
                        itemList.add(searchItem);
                    }
                }
                JSONArray facetItems = data.getJSONArray("facet");
                int len = facetItems.size();
                if (0 < len) {
                    for (int i = 0; i < len; i++) {
                        JSONObject facetItem = facetItems.getJSONObject(i);
                        JSONArray jsonArray = facetItem.getJSONArray("items");
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

    private SearchItem packSearchItem(SearchHit hit) {
        ESGoods esGoods = JSON.parseObject(hit.getSourceAsString(), ESGoods.class);
        SearchItem searchItem = BeanMapper.map(esGoods, SearchItem.class);
        searchItem.setItemId(esGoods.getGoodsId());
        Long piPrice = esGoods.getPiPrice();
        searchItem.setPrice(String.format("%.2f", piPrice * .01));
        return searchItem;
    }

    private void buildBoostingQuery(String keyword, SearchRequestBuilder sb, BoolQueryBuilder boolQuery) {
//        boolQuery.must(QueryBuilders.boostingQuery().negative(QueryBuilders.))
        BoostingQueryBuilder boostingQueryBuilder = QueryBuilders.boostingQuery();
        if (StringUtils.isBlank(keyword)) {// 空搜索词时去除 不含title的结果
            boolQuery.must(QueryBuilders.existsQuery("title"));
        }
        boolQuery//.mustNot(QueryBuilders.termQuery("price", 0))// 价格为0 ， 批发价为0， 主图不存在
                .mustNot(QueryBuilders.termQuery("piPrice", 0.0))
                .mustNot(QueryBuilders.termsQuery("title", "补邮费", "补运费", "补快递费", "邮费补差", "运费补差", "快递费补差", "运费差价", "运费链接", "运费专拍"));
        boostingQueryBuilder.positive(boolQuery);
        sb.setQuery(boostingQueryBuilder);

        // 半权查询
        boostingQueryBuilder.negative(halfWeight()).negativeBoost(.5f);
    }

    /**
     * 半权查询。，在此的查询条件享受权重减半的待遇
     * 补邮费
     * 补运费
     * 补快递费
     * 邮费补差
     * 运费补差
     * 快递费补差
     */
    private BoolQueryBuilder halfWeight() {

        return QueryBuilders.boolQuery()
                .should(QueryBuilders.termsQuery("parentMarketId", Arrays.asList(913, 674)))//低权市场
                //.should(QueryBuilders.matchQuery("title", "邮费 补差 运费 链接 付款"))
//                .should(QueryBuilders.termsQuery("title", "补邮费","补运费","补快递费","邮费补差","运费补差","快递费补差","运费差价","运费链接","运费专拍"))
//                .mustNot(QueryBuilders.matchQuery("title","补邮费 补运费 补快递费 邮费补差 运费补差 快递费补差 运费差价 运费链接 运费专拍"))
                .should(QueryBuilders.boolQuery().filter(QueryBuilders.rangeQuery("created").lte(DateFormatUtils.format(DateUtils.addMonths(new Date(), -3), DATE_FMT)).format(DATE_FMT)))
                .should(QueryBuilders.termQuery("goods_level", 1))
                .should(QueryBuilders.missingQuery("picUrl"));
    }

    private List<AggsCount> getAggCount(String aggName, SearchResponse response) {
        List<AggsCount> aggsCounts = new ArrayList<>();
        Aggregation aggregation = response.getAggregations().get(aggName);

        Terms terms;
        if (aggregation instanceof InternalFilter) {
            terms = ((InternalFilter) aggregation).getAggregations().get(aggName);
        } else {
            terms = (Terms) aggregation;
        }
        if (terms != null) {
            List<Terms.Bucket> buckets = terms.getBuckets();
            if (buckets != null) {
                for (Terms.Bucket bucket : buckets) {
                    AggsCount aggsCount = new AggsCount();
                    aggsCount.setValue((long) bucket.getKeyAsNumber());
                    aggsCount.setCount(bucket.getDocCount());
                    aggsCounts.add(aggsCount);
                }
            }
        }
        return aggsCounts;
    }

    /**
     * 查询搜索类目
     *
     * @param category
     * @return
     */
    @Override
    public List<CategoryValue> selCategory(SearchCategory category, String webSite) {
        if (StringUtils.isEmpty(webSite)) {
            webSite = "hz";
        }
        if (category == null) {
            return Collections.emptyList();
        }
        SearchCategoryExample categoryExample = new SearchCategoryExample();
        categoryExample.createCriteria().andTypeEqualTo(category.getCategoryType()).andWebSiteEqualTo(webSite);
        List<CategoryValue> categoryValues;
        categoryValues = BeanMapper.mapList(searchCategoryMapper.selectByExample(categoryExample), CategoryValue.class);
        Collections.sort(categoryValues);
        return categoryValues;
    }

    /**
     * 查询子级搜索类目
     *
     * @param parentCateValue
     * @return
     */
    @Override
    public List<CategoryValue> selSubCategory(String parentCateValue, SearchCategory category, String website) {
        if (StringUtils.isEmpty(parentCateValue))
            return Collections.emptyList();
        if (StringUtils.isEmpty(website)) {
            website = "hz";
        }
        SearchCategorySubExample subExample = new SearchCategorySubExample();
        subExample.createCriteria().andParentCateValueEqualTo(parentCateValue).andTypeEqualTo(category.getCategoryType()).andWebSiteEqualTo(website);
        List<CategoryValue> categoryValues;
        Collections.sort(categoryValues = BeanMapper.mapList(searchCategorySubMapper.selectByExample(subExample), CategoryValue.class));
        return categoryValues;
    }



    /**
     * 按ID查询
     *
     * @param ids
     * @param webSite
     * @param page
     * @param pageSize
     * @return
     */
    @Override
    public ShiguPager<SearchItem> searchItemByIds(List<Long> ids, String webSite, Integer page, Integer pageSize) {
        final String[] FIELDS = {"goods_id", "title", "created", "price", "pic_url", "store_id", "goods_no"};
        final String initialFilter = "goods_id = -1";
        ShiguPager<SearchItem> pager = new ShiguPager<>();
        pager.setNumber(page);
        ArrayList<SearchItem> item = Lists.newArrayList();
        pager.setContent(item);
        Config config = new Config(Lists.<String>newArrayList(SEARCH_APP + webSite));
        config.setStart((page - 1) * pageSize);
        config.setHits(pageSize);
        config.setFetchFields(Lists.<String>newArrayList(FIELDS));
        config.setSearchFormat(SearchFormat.JSON);
        SearchParamsBuilder searchParams = SearchParamsBuilder.create(config);

        searchParams.addFilter(initialFilter);
        if (ids != null && ids.size() > 0) {
            for (Long id : ids) {
                searchParams.addFilter("goods_id = " + id, "OR");
            }
        }
        try {
            SearchResult result = searcherClient.execute(searchParams);
            JSONObject jsonObject = JSON.parseObject(result.getResult());
            if ("OK".equals(jsonObject.getString("status"))) {
                JSONObject data = jsonObject.getJSONObject("result");
                int total = data.getIntValue("total");
                pager.calPages(total, pageSize);
                JSONArray items = data.getJSONArray("items");
                List<OpenItemVo> openItemVos = items.toJavaList(OpenItemVo.class);
                if (!openItemVos.isEmpty()) {
                    for (OpenItemVo openItemVo : openItemVos) {
                        SearchItem searchItem = BeanMapper.map(openItemVo, SearchItem.class);
                        searchItem.setItemId(openItemVo.getGoodsId());
                        searchItem.setHighLightGoodsNo(openItemVo.getGoodsNo());
                        searchItem.setHighLightTitle(openItemVo.getTitle());
                        item.add(searchItem);
                    }
                }
            } else {
                throw new Main4Exception(jsonObject.getString("error"));
            }
        } catch (OpenSearchException | OpenSearchClientException ignored) {
        } catch (Main4Exception e) {
            logger.error("搜索失败", e);
        }
        return pager;
    }
}
