package com.shigu.main4.item.services;

import com.alibaba.fastjson.JSON;
import com.aliyun.opensearch.sdk.generated.search.Order;
import com.aliyun.opensearch.sdk.generated.search.SortField;
import com.opentae.data.mall.examples.SearchCategoryExample;
import com.opentae.data.mall.examples.SearchCategorySubExample;
import com.opentae.data.mall.interfaces.SearchCategoryMapper;
import com.opentae.data.mall.interfaces.SearchCategorySubMapper;
import com.shigu.main4.common.tools.ShiguPager;
import com.shigu.main4.common.util.BeanMapper;
import com.shigu.main4.item.enums.SearchCategory;
import com.shigu.main4.item.enums.SearchOrderBy;
import com.shigu.main4.item.vo.*;
import com.shigu.opensearchsdk.OpenSearch;
import com.shigu.opensearchsdk.builder.AggsBuilder;
import com.shigu.opensearchsdk.builder.FilterBuilder;
import com.shigu.opensearchsdk.builder.QueryBuilder;
import com.shigu.opensearchsdk.builder.SummaryBuild;
import com.shigu.opensearchsdk.filter.NumberFilter;
import com.shigu.opensearchsdk.query.SearchQuery;
import com.shigu.opensearchsdk.response.Facet;
import com.shigu.opensearchsdk.response.Result;
import com.shigu.opensearchsdk.response.SearchResponse;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
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


    @Resource
    private OpenSearch openSearch;

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
        pager.setCats(Collections.<AggsCount>emptyList());
        pager.setMarkets(Collections.<AggsCount>emptyList());
        pager.setParentCats(Collections.<AggsCount>emptyList());
        pager.setNumber(page);

        OpenSearch openSearch = new OpenSearch("LTAINlvsCqKlSP4I", "XbfaARrK5PkUtqRfqWLfy5L9OQ9nQJ", "http://opensearch-cn-hangzhou.aliyuncs.com");

        OpenSearch.RequestBuilder<OpenItemVo> requestBuilder
                = openSearch.searchFrom(OpenItemVo.class).from((page - 1) * pageSize).size(pageSize)
                .setRank(null, "goods_search", 1000);

        SearchQuery searchQuery = null;
        if (StringUtils.isNotEmpty(keyword)) {
            String keywordNum = keyword.replaceAll(CHS_PATTERN.toString(), "");
            String keywordChina = keyword.replaceAll(NUMBER_PATTERN.toString(), "");
            if (StringUtils.isNotEmpty(keywordChina)) {
                searchQuery = QueryBuilder.search("title", keyword);
                requestBuilder.addSummary(SummaryBuild.field("title").length(120));
            }
            if (StringUtils.isNotEmpty(keywordNum)) {
                SearchQuery goodsNoQuery = QueryBuilder.search("goods_no", keyword);
                if (searchQuery == null) {
                    searchQuery = goodsNoQuery;
                } else {
                    searchQuery.or(goodsNoQuery);
                }
                requestBuilder.addSummary(SummaryBuild.field("goods_no").length(50));
            }
        }

        if (StringUtils.isNotEmpty(sid)) {
            SearchQuery sidsQuery = QueryBuilder.search("sids", sid);
            if (searchQuery != null) {
                searchQuery.and(sidsQuery);
            } else {
                searchQuery = sidsQuery;
            }
        }
        if (searchQuery != null) {
            requestBuilder.setQuery(searchQuery);
        }

        NumberFilter filters = FilterBuilder.number("is_closed", 0).and(FilterBuilder.number("pi_price").gt(0));
        if (cids != null && !cids.isEmpty()) {
            filters.and(FilterBuilder.termsIn("cid", cids.toArray(new Long[cids.size()])));
        }

        if (mid != null) {
            filters.and(FilterBuilder.number("parent_market_id", mid));
        }

        if (priceFrom != null) {
            filters.and(FilterBuilder.number("pi_price").gte(((Double) (priceFrom * 100)).longValue()));
        }

        if (priceTo != null) {
            filters.and(FilterBuilder.number("pi_price").lte(((Double) (priceTo * 100)).longValue()));
        }

        if (timeForm != null) {
            filters.and(FilterBuilder.number("created").gte(timeForm.getTime()));
        }

        if (timeTo != null) {
            filters.and(FilterBuilder.number("created").lte(timeTo.getTime()));
        }
        requestBuilder.addFilter(filters);

        // 6. 排序规则
        switch (orderCase) {
            case NEW:
                requestBuilder.addSort(new SortField("created", Order.DECREASE));
                break;
            case COMMON:
                break;
            case GOODS_COMMON:
//                requestBuilder.addSort(new SortField("sort_order", Order.DECREASE));
//                requestBuilder.addSort(new SortField("created", Order.DECREASE));
                break;
            case SALE:
                break;
            case CLICK:
                break;
            case PRICEUP:
                requestBuilder.addSort(new SortField("pi_price", Order.INCREASE));
                break;
            case PRICEDOWN:
                requestBuilder.addSort(new SortField("pi_price", Order.DECREASE));
                break;
            case GOODSUP:
                break;
        }

        if (aggs) {
            requestBuilder.addAggs(AggsBuilder.count("cid").size(100))
                    .addAggs(AggsBuilder.count("parent_market_id").size(100));
        }

        SearchResponse<OpenItemVo> response = requestBuilder.execute();
        if (response.isSuccess()) {
            Result<OpenItemVo> result = response.getResult();
            pager.calPages(result.getTotal(), pageSize);
            pager.setContent(new ArrayList<SearchItem>(result.getItems().size()));

            for (OpenItemVo vo : BeanMapper.getFieldList(result.getItems(), "fields", OpenItemVo.class)) {
                SearchItem searchItem = BeanMapper.map(vo, SearchItem.class);
                searchItem.setPrice(String.format("%.2f", vo.getPiPrice() * .01));
                searchItem.setItemId(vo.getGoodsId());
                if (vo.getGoodsNo().contains("<em>")) {
                    searchItem.setHighLightGoodsNo(vo.getGoodsNo());
                    searchItem.setGoodsNo(vo.getGoodsNo().replace("<em>","").replace("</em>", ""));
                } else {
                    searchItem.setGoodsNo(null);
                    searchItem.setHighLightTitle(vo.getTitle());
                    searchItem.setTitle(vo.getTitle().replace("<em>","").replace("</em>", ""));
                }
                pager.getContent().add(searchItem);
            }

            for (Facet facet : result.getFacet()) {
                if ("cid".equals(facet.getKey())) {
                    pager.setCats(JSON.parseArray(JSON.toJSONString(facet.getItems()), AggsCount.class));
                } else if ("parent_market_id".equals(facet.getKey())) {
                    pager.setMarkets(JSON.parseArray(JSON.toJSONString(facet.getItems()), AggsCount.class));
                }
            }
        }
        return pager;
    }
    /**
     * 半权查询。，在此的查询条件享受权重减半的待遇
     * 补邮费
     * 补运费
     * 补快递费
     * 邮费补差
     * 运费补差
     * 快递费补差
     * goods_level = 1
     * picurl miss
     *
     * 过滤价格为0批发价为0主题不存在
     * "补邮费", "补运费", "补快递费", "邮费补差", "运费补差", "快递费补差", "运费差价", "运费链接", "运费专拍"
     */

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
        ShiguPager<SearchItem> pager = new ShiguPager<>();
        pager.setNumber(page);

        OpenSearch.RequestBuilder<OpenItemVo> requestBuilder = openSearch.searchFrom(OpenItemVo.class)
                .from((page - 1) * pageSize).size(pageSize);
        if (ids != null && !ids.isEmpty()) {
            requestBuilder.addFilter(FilterBuilder.termsIn("goods_id", ids.toArray(new Long[ids.size()])));
        }
        SearchResponse<OpenItemVo> response = requestBuilder.execute();
        if (response.isSuccess()) {
            Result<OpenItemVo> result = response.getResult();
            pager.calPages(result.getTotal(), pageSize);
            pager.setContent(new ArrayList<SearchItem>(result.getItems().size()));
            for (OpenItemVo openItemVo : BeanMapper.getFieldList(result.getItems(), "fields", OpenItemVo.class)) {
                SearchItem searchItem = BeanMapper.map(openItemVo, SearchItem.class);
                searchItem.setItemId(openItemVo.getGoodsId());
                searchItem.setHighLightGoodsNo(openItemVo.getGoodsNo());
                searchItem.setHighLightTitle(openItemVo.getTitle());
                pager.getContent().add(searchItem);
            }
        }
        return pager;
    }
}
