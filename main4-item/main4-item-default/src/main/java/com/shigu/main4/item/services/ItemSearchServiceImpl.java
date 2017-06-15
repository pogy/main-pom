package com.shigu.main4.item.services;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.aliyun.opensearch.SearcherClient;
import com.aliyun.opensearch.sdk.dependencies.com.google.common.collect.Lists;
import com.aliyun.opensearch.sdk.generated.commons.OpenSearchClientException;
import com.aliyun.opensearch.sdk.generated.commons.OpenSearchException;
import com.aliyun.opensearch.sdk.generated.search.Config;
import com.aliyun.opensearch.sdk.generated.search.SearchFormat;
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
    public ShiguAggsPager searchItem(
            // 基础查询
            String keyword,String webSite, Long mid, List<Long> cids, List<Long> shouldStoreIds,
            // 价格区间
            Double priceFrom, Double priceTo,
            // 时间区间
            Date timeForm, Date timeTo,
            // 排序
            SearchOrderBy orderCase,
            // 分页
            Integer page, Integer pageSize, boolean aggs) {

        // 1. 处理最大页码
        ShiguAggsPager pager = new ShiguAggsPager();
        pager.setNumber(page = page == null ? 1 : page > MAX_PAGE ? MAX_PAGE : page);
        pageSize = pageSize == null ? DEFAULT_PAGE_SIZE : pageSize;

        // 2. 处理分页参数
        SearchRequestBuilder sb = ElasticConfiguration.searchClient.prepareSearch("goods").setSize(pageSize).setFrom((page - 1) * pageSize);
        BoolQueryBuilder boolQuery = QueryBuilders.boolQuery().must(QueryBuilders.termQuery("is_off", 0));//商品状态出售中
        sb.setQuery(boolQuery);

        // 2.1 处理分站参数
        if (StringUtils.isNotEmpty(webSite)) {
            sb.setTypes(webSite);
        }
        // 3. 基础查询
        if (StringUtils.isNotBlank(keyword)) {
            String s=keyword;
            keyword = keyword.replaceAll("\\s+", " and ");
            BoolQueryBuilder keyBool=QueryBuilders.boolQuery();
            boolQuery.must(keyBool);
            keyBool.should(QueryBuilders.matchQuery("title", keyword).minimumShouldMatch("100%"));
            BoolQueryBuilder goodsNoQuery = QueryBuilders.boolQuery().should(QueryBuilders.matchQuery("goodsNo", keyword).minimumShouldMatch("100%"));
//            if (keyword.length() > 3) {
//                goodsNoQuery.should(QueryBuilders.wildcardQuery("goodsNo", "*" + s + "*"));
//                goodsNoQuery.minimumNumberShouldMatch(1);
//            }
            keyBool.should(goodsNoQuery);
//            keyBool.should(QueryBuilders.wildcardQuery("goodsNo","*"+s+"*"));
            keyBool.minimumNumberShouldMatch(1);
        }
        // 3.1 处理需要聚合后过滤的参数
        BoolQueryBuilder filterQuery=QueryBuilders.boolQuery();
        if (mid != null) {
            filterQuery.must(QueryBuilders.termQuery("parentMarketId", mid));
        }
        if (cids != null && !cids.isEmpty()) {
            filterQuery.must(QueryBuilders.termsQuery("cid", cids));
        }
        if(filterQuery.hasClauses()){
            sb.setPostFilter(filterQuery);
        }
        if (shouldStoreIds != null && !shouldStoreIds.isEmpty()) {
            boolQuery.should(QueryBuilders.termsQuery("storeId", shouldStoreIds));
        }

        // 4. 价格区间
        if (priceFrom != null) {
            Double price = priceFrom * 100;
            boolQuery.must(QueryBuilders.rangeQuery("piPrice").gte(price.longValue()));
        }
        if (priceTo != null) {
            Double price = priceTo * 100;
            boolQuery.must(QueryBuilders.rangeQuery("piPrice").lte(price.longValue()));
        }

        // 5. 时间区间
        if (timeForm != null) {
            boolQuery.must(QueryBuilders.rangeQuery("created").gte(DateFormatUtils.format(timeForm, DATE_FMT)).format(DATE_FMT));
        }
        if (timeTo != null) {
            boolQuery.must(QueryBuilders.rangeQuery("created").lte(DateFormatUtils.format(timeTo, DATE_FMT)).format(DATE_FMT));
        }
        // 6. 排序规则
        switch (orderCase) {
            case NEW:
                sb.addSort("created", SortOrder.DESC);
                break;
            case COMMON:
                break;
            case GOODS_COMMON:
                sb.addSort("sortOrder", SortOrder.DESC);
                sb.addSort("created", SortOrder.DESC);
                break;
            case SALE:
                break;
            case CLICK:
                break;
            case PRICEUP:
                sb.addSort("piPrice", SortOrder.ASC);
                break;
            case PRICEDOWN:
                sb.addSort("piPrice", SortOrder.DESC);
                break;
            case GOODSUP:
                break;
        }
        // 7. 查询权重处理
        buildBoostingQuery(keyword, sb, boolQuery);

        // 8. 关键词高亮
        sb.addHighlightedField("title").addHighlightedField("goodsNo")
                .setHighlighterPreTags("<font style='color:red;'>").setHighlighterPostTags("</font>");

        // 9. 处理聚合
        String marketCountName = "market_count";
        String parentCatName = "parent_cat_count";
        if (aggs) {
            AggregationBuilder parentCatAggregation = AggregationBuilders.terms(parentCatName).field("parent_cid").size(100)
                    .subAggregation(
                            AggregationBuilders.count("cid_num").field("goodsId"));
            if (mid != null) {
                parentCatAggregation = AggregationBuilders.filter(parentCatName)
                        .filter(QueryBuilders.termQuery("parentMarketId", mid)).subAggregation(parentCatAggregation);
            }
            AggregationBuilder marketAggregation = AggregationBuilders.terms(marketCountName).field("parentMarketId").size(100)
                    .subAggregation(AggregationBuilders.count("market_num").field("goodsId"));
            if (cids != null && !cids.isEmpty()) {
                marketAggregation = AggregationBuilders.filter(marketCountName).filter(QueryBuilders.termsQuery("cid", cids))
                .subAggregation(marketAggregation);
            }
            sb.addAggregation(parentCatAggregation).addAggregation(marketAggregation);
        }
        SearchResponse response = sb.execute().actionGet();
        SearchHits hits = response.getHits();

        if (aggs) {
              pager.setMarkets(getAggCount(marketCountName, response));
            pager.setParentCats(getAggCount(parentCatName, response));
        }

        // 10. 处理返回数据
        int totalHits = (int) hits.getTotalHits();
        if (totalHits > 0) {
            pager.setContent(new ArrayList<SearchItem>(pageSize));

            for (SearchHit hit : hits.getHits()) {
                SearchItem searchItem = packSearchItem(hit);
                // 高亮字段
                Map<String, HighlightField> highlightFields = hit.getHighlightFields();
                HighlightField title = highlightFields.get("title");
                if (title != null) {
                    searchItem.setHighLightTitle(StringUtils.join(title.fragments()));
                } else {
                    searchItem.setHighLightTitle(searchItem.getTitle());
                }
                HighlightField goodsNo = highlightFields.get("goodsNo");
                if (goodsNo != null) {
                    searchItem.setHighLightGoodsNo(StringUtils.join(goodsNo.fragments()));
                } else {
                    searchItem.setGoodsNo(null);
                }
                pager.getContent().add(searchItem);
            }

            int maxHits = MAX_PAGE * pageSize;
            pager.setTotalCount(totalHits);
            if (totalHits > maxHits) {
                pager.setTotalPages(MAX_PAGE);
            } else {
                pager.setTotalPages((totalHits - 1) / pageSize + 1);
            }
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
                .mustNot(QueryBuilders.termsQuery("title", "补邮费","补运费","补快递费","邮费补差","运费补差","快递费补差","运费差价","运费链接","运费专拍"));
        boostingQueryBuilder.positive(boolQuery);
        sb.setQuery(boostingQueryBuilder);

        // 半权查询
        boostingQueryBuilder.negative(halfWeight()).negativeBoost(.5f);
    }

    /**
     * 半权查询。，在此的查询条件享受权重减半的待遇
     * 补邮费
     补运费
     补快递费
     邮费补差
     运费补差
     快递费补差
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
                    aggsCount.setValue((long)bucket.getKeyAsNumber());
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
    public List<CategoryValue> selCategory(SearchCategory category,String webSite) {
        if(StringUtils.isEmpty(webSite)){
            webSite = "hz";
        }
        if (category == null) {
            return Collections.emptyList();
        }
        SearchCategoryExample categoryExample = new SearchCategoryExample();
        categoryExample.createCriteria().andTypeEqualTo(category.getCategoryType()).andWebSiteEqualTo(webSite);
        List<CategoryValue> categoryValues;
        categoryValues =  BeanMapper.mapList(searchCategoryMapper.selectByExample(categoryExample), CategoryValue.class);
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
        if(StringUtils.isEmpty(website)){
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
        final String[] FIELDS = {"goods_id","title","created","price","pic_url","store_id","goods_no"};
        final  String initialFilter = "goods_id = -1";
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
        if(ids != null && ids.size() > 0) {
            for (Long id: ids) {
                searchParams.addFilter("goods_id = " + id, "OR");
            }
        }
        try {
            SearchResult result = searcherClient.execute(searchParams);
            JSONObject jsonObject = JSON.parseObject(result.getResult());
            if ("OK".equals(jsonObject.getString("status"))) {
                JSONObject data = jsonObject.getJSONObject("result");
                int total = data.getIntValue("total");
                pager.calPages(total,pageSize);
                JSONArray items = data.getJSONArray("items");
                List<OpenItemVo> openItemVos = items.toJavaList(OpenItemVo.class);
                if (!openItemVos.isEmpty()){
                    for (OpenItemVo openItemVo : openItemVos) {
                        SearchItem searchItem = BeanMapper.map(openItemVo, SearchItem.class);
                        searchItem.setItemId(openItemVo.getGoodsId());
                        searchItem.setHighLightGoodsNo(openItemVo.getGoodsNo());
                        searchItem.setHighLightTitle(openItemVo.getTitle());
                        item.add(searchItem);
                    }
                }
            }else {
                throw new Main4Exception(jsonObject.getString("error"));
            }
        }catch (OpenSearchException | OpenSearchClientException ignored) {
        } catch (Main4Exception e){
            logger.error("搜索失败", e);
        }
        return pager;
    }
}
