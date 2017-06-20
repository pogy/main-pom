package com.shigu.main4.storeservices.impl;

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
import com.opentae.core.mybatis.utils.FieldUtil;
import com.opentae.data.mall.beans.*;
import com.opentae.data.mall.examples.*;
import com.opentae.data.mall.interfaces.*;
import com.searchtool.configs.ElasticConfiguration;
import com.shigu.main4.common.exceptions.Main4Exception;
import com.shigu.main4.common.tools.ShiguPager;
import com.shigu.main4.common.util.BeanMapper;
import com.shigu.main4.common.util.DateUtil;
import com.shigu.main4.item.vo.OpenItemVo;
import com.shigu.main4.storeservices.ShopForCdnService;
import com.shigu.main4.storeservices.bo.ShopForCdnBo;
import com.shigu.main4.storeservices.vo.SearchGoodsVo;
import com.shigu.main4.vo.*;
import com.shigu.opensearchsdk.OpenSearch;
import com.shigu.opensearchsdk.builder.AggsBuilder;
import com.shigu.opensearchsdk.builder.FilterBuilder;
import com.shigu.opensearchsdk.response.Facet;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.search.SearchType;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.RangeQueryBuilder;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.aggregations.Aggregation;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.aggregations.bucket.terms.LongTerms;
import org.elasticsearch.search.aggregations.bucket.terms.Terms;
import org.elasticsearch.search.sort.SortOrder;
import org.omg.CORBA.SystemException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.*;


/**
 * Created by wxc on 2017/2/20.
 * <p>
 * 店铺CDN服务默认实现
 *
 * @author wxc
 * @version domwiki 4.0.0
 * @since domwiki 4.0.0
 */
@Service("shopForCdnService")
public class ShopForCdnServiceImpl extends ShopServiceImpl implements ShopForCdnService {

    private static final Logger logger = LoggerFactory.getLogger(ShopForCdnServiceImpl.class);

    @Resource(name = "tae_mall_shiguStorecatMapper")
    private ShiguStorecatMapper storeCatMapper;

    @Resource(name = "tae_mall_shiguShopLicenseMapper")
    private ShiguShopLicenseMapper shiguShopLicenseMapper;

    @Resource(name = "tae_mall_shiguTaobaocatMapper")
    private ShiguTaobaocatMapper shiguTaobaocatMapper;

    @Resource(name = "tae_mall_shiguShopMapper")
    private ShiguShopMapper shiguShopMapper;

    @Resource(name = "tae_mall_shiguGoodsTinyMapper")
    private ShiguGoodsTinyMapper shiguGoodsTinyMapper;

    @Autowired
    private SearcherClient searcherClient;

    @Resource(name = "shiguOpenSearch")
    private OpenSearch openSearch;

    @Resource
    private ShiguGoodsSoldoutMapper shiguGoodsSoldoutMapper;

    /**
     * 创建ES对象SearchRequestBuilder
     *
     * @param shopForCdnBo
     * @return
     */
    public SearchRequestBuilder getSearchRequestBuilder(ShopForCdnBo shopForCdnBo) {
        if (shopForCdnBo == null) {
            shopForCdnBo = new ShopForCdnBo();
        }
        SearchRequestBuilder srb = ElasticConfiguration.searchClient.prepareSearch("goods");
        BoolQueryBuilder boleanQueryBuilder = QueryBuilders.boolQuery();
        int totalrow = shopForCdnBo.getPageSize() * (shopForCdnBo.getPageNo() - 1);
        srb.setSize(shopForCdnBo.getPageSize());
        srb.setFrom(totalrow);

        // 排序设置
        if (StringUtils.isEmpty(shopForCdnBo.getOrderBy())) {
            // 默认时间排序
            srb.addSort("created", SortOrder.DESC);
        } else {
            if (StringUtils.equals(shopForCdnBo.getOrderBy(), "price_up")) {
                srb.addSort("piPrice", SortOrder.ASC);
            }
            if (StringUtils.equals(shopForCdnBo.getOrderBy(), "price_down")) {
                srb.addSort("piPrice", SortOrder.DESC);
            }
            if (StringUtils.equals(shopForCdnBo.getOrderBy(), "time_up")) {
                srb.addSort("created", SortOrder.ASC);
            }
            if (StringUtils.equals(shopForCdnBo.getOrderBy(), "time_down")) {
                srb.addSort("created", SortOrder.DESC);
            }
            if (StringUtils.equals(shopForCdnBo.getOrderBy(), "soldOutTime_desc")) {
                srb.addSort("soldOutTime", SortOrder.DESC);
            }
        }

        // shopID查询
        if (shopForCdnBo.getShopId() != null) {
            QueryBuilder qb = QueryBuilders.termQuery("storeId", shopForCdnBo.getShopId());
            boleanQueryBuilder.must(qb);
        }

        List<Long> goodsIds = shopForCdnBo.getGoodsIds();
        if (goodsIds != null && !goodsIds.isEmpty()) {
            boleanQueryBuilder.must(QueryBuilders.termsQuery("goodsId", shopForCdnBo.getGoodsIds()));
        }

        // 标题
        if (!StringUtils.isEmpty(shopForCdnBo.getKeyword())) {
            boleanQueryBuilder.should(QueryBuilders.matchQuery("title", shopForCdnBo.getKeyword()).minimumShouldMatch("100%"));
            boleanQueryBuilder.should(QueryBuilders.matchQuery("goodsNo", shopForCdnBo.getKeyword()).minimumShouldMatch("100%"));
            boleanQueryBuilder.minimumNumberShouldMatch(1);
        }

        // CID查询条件
        if (shopForCdnBo.getCid() != null) {
            QueryBuilder qb = QueryBuilders.termQuery("cid", shopForCdnBo.getCid());
            boleanQueryBuilder.must(qb);
        }

        // 价格区间条件
        if (shopForCdnBo.getPriceFrom() != null) {
            Double fromPrice = shopForCdnBo.getPriceFrom() * 100;
            RangeQueryBuilder qb = QueryBuilders.rangeQuery("piPrice").from(fromPrice.longValue());
            boleanQueryBuilder.must(qb);
        }

        if (shopForCdnBo.getPriceTo() != null) {
            Double toPrice = shopForCdnBo.getPriceTo() * 100;
            RangeQueryBuilder qb = QueryBuilders.rangeQuery("piPrice").to(toPrice.longValue());
            boleanQueryBuilder.must(qb);
        }

        // 时间范围区间
        if (shopForCdnBo.getDateFrom() != null) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            RangeQueryBuilder qb = QueryBuilders.rangeQuery("created").from(sdf.format(shopForCdnBo.getDateFrom()));
            if (shopForCdnBo.getDateTo() != null) {
                qb.to(sdf.format(shopForCdnBo.getDateTo()));
            }
            boleanQueryBuilder.must(qb);
        } else {
            if (shopForCdnBo.getDateTo() != null) {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                RangeQueryBuilder qb = QueryBuilders.rangeQuery("created").to(sdf.format(shopForCdnBo.getDateTo()));
                boleanQueryBuilder.must(qb);
            }
        }

        // 时间范围区间
        if (shopForCdnBo.getSoldDateFrom() != null) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            RangeQueryBuilder qb = QueryBuilders.rangeQuery("soldOutTime").from(sdf.format(shopForCdnBo.getSoldDateFrom()));
            if (shopForCdnBo.getSoldDateTo() != null) {
                qb.to(sdf.format(shopForCdnBo.getSoldDateTo()));
            }
            boleanQueryBuilder.must(qb);
        } else {
            if (shopForCdnBo.getSoldDateTo() != null) {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                RangeQueryBuilder qb = QueryBuilders.rangeQuery("soldOutTime").to(sdf.format(shopForCdnBo.getSoldDateTo()));
                boleanQueryBuilder.must(qb);
            }
        }

        if (shopForCdnBo.getIsOff() != null) {
            QueryBuilder qb = QueryBuilders.termQuery("is_off", shopForCdnBo.getIsOff());
            boleanQueryBuilder.must(qb);
        }

        if (shopForCdnBo.getScid() != null) {
            //先查一下是否父级
            Long scid=Long.valueOf(shopForCdnBo.getScid());
            String scidStr;
            ShiguStorecat storecat=storeCatMapper.selectByPrimaryKey(scid);
            if(storecat!=null&&storecat.getIsParent()!=null&&storecat.getIsParent()==1){//是父类
                ShiguStorecatExample catExample=new ShiguStorecatExample();
                catExample.createCriteria().andParentScidEqualTo(scid);
                List<ShiguStorecat> subcats=storeCatMapper.selectByExample(catExample);//子级类目
                scidStr="";
                if(subcats.size() == 0){
                    scid=(scid-shopForCdnBo.getShopId())/1000000;
                    scidStr=scid.toString();
                }else{
                    for(ShiguStorecat c:subcats){
                        scidStr+=","+((c.getScid()-shopForCdnBo.getShopId())/1000000);
                    }
                    if(scidStr.startsWith(",")){
                        scidStr=scidStr.substring(1);
                    }else{
                        scidStr=scid.toString();
                    }
                }
            }else{
                scid=(scid-shopForCdnBo.getShopId())/1000000;
                scidStr=scid.toString();
            }

            boleanQueryBuilder.must(QueryBuilders.queryStringQuery(scidStr).field("cidAll"));
        }
        srb.setQuery(boleanQueryBuilder);

        return srb;
    }

    /**
     * 根据条件BO获取数据
     *
     * @param shopForCdnBo
     * @return
     */
    public List<ItemShowBlock> selectItemShowBlockByEsBo(ShopForCdnBo shopForCdnBo) {
        SearchRequestBuilder srb = getSearchRequestBuilder(shopForCdnBo);
        SearchResponse response = srb.execute().actionGet();
        SearchHit[] hits = response.getHits().getHits();
        List<ItemShowBlock> itemShowBlockList = new ArrayList<ItemShowBlock>();
        if (hits != null && hits.length > 0) {
            for (SearchHit hit : hits) {
                ShiguGoodsTiny shiguGoodsTiny = JSON.parseObject(hit.getSourceAsString(), ShiguGoodsTiny.class);
                if (shiguGoodsTiny == null) {
                    return null;
                }
                ItemShowBlock itemShowBlock = new ItemShowBlock();
                itemShowBlock.setImgUrl(shiguGoodsTiny.getPicUrl());
                itemShowBlock.setItemId(shiguGoodsTiny.getGoodsId());
                if(shiguGoodsTiny.getPiPrice()!=null)//暂时用一下,等数据修好了,再删除本行
                itemShowBlock.setPrice(shiguGoodsTiny.getPiPrice().toString());
                itemShowBlock.setTitle(shiguGoodsTiny.getTitle());
                itemShowBlock.setWebSite(shiguGoodsTiny.getWebSite());
                itemShowBlock.setGoodsNo(shiguGoodsTiny.getGoodsNo());
                itemShowBlock.setSoldOutTime(DateUtil.dateToString(shiguGoodsTiny.getSoldOutTime(),DateUtil.patternD));
                itemShowBlockList.add(itemShowBlock);
            }
        }
        return itemShowBlockList;
    }


    /**
     * 查询数据数
     *
     * @param shopForCdnBo
     * @return
     */
    public Long selectCountByEsBo(ShopForCdnBo shopForCdnBo) {
        SearchRequestBuilder srb = getSearchRequestBuilder(shopForCdnBo);
        srb.setSearchType(SearchType.COUNT);
        SearchResponse response = srb.execute().actionGet();
        Long total = response.getHits().getTotalHits();
        return total;
    }

    /**
     * 按店ID查店内类目
     *
     * @param shopId 店铺ID
     * @return 按顺序排列的店内类目列表
     */
    @Override
    public List<ShopCat> selShopCatsById(Long shopId) {
        Cache shopCatCache = cacheManager.getCache("shopCatCache");

        //确定该cache保存的类型正确
        @SuppressWarnings("unchecked")
        List<ShopCat> shopCats = (List<ShopCat>) shopCatCache.get(shopId, List.class);
        if (shopCats == null) {

            //1. 查询数据库
            shopCats = new ArrayList<>();
            ShiguStorecatExample catExample = new ShiguStorecatExample();
            catExample.createCriteria().andStoreIdEqualTo(shopId);
            List<ShiguStorecat> shiguStorecats = storeCatMapper.selectByExample(catExample);

            //  父类ID， 子类集合    暂存子类目集合
            Map<Long, List<ShopCat>> catMap = new TreeMap<>();
            //2. 构造数据
            for (ShiguStorecat shiguStorecat : shiguStorecats) {
                ShopCat cat = new ShopCat();
                cat.setCid(shiguStorecat.getScid().toString());
                cat.setName(shiguStorecat.getScName());
                Integer sortOrder = shiguStorecat.getSortOrder();
                if (sortOrder != null)
                    cat.setSort(sortOrder);

                boolean isParent = shiguStorecat.getIsParent()!=null&&shiguStorecat.getIsParent() == 1;

                // 获取父类ID
                Long parentScid = isParent ? shiguStorecat.getScid() : shiguStorecat.getParentScid();

                // 从Map中获取该父级类目的子类集合
                List<ShopCat> sub = catMap.get(parentScid);

                if (sub == null) {
                    sub = new ArrayList<>();
                    catMap.put(parentScid, sub);
                }

                if (isParent) {
                    // 从Map中接管 子类目集合引用
                    cat.setSubCats(sub);
                    // 如果是父级类目，添加到结果集shopCats
                    shopCats.add(cat);
                } else {
                    // 暂存入Map中
                    sub.add(cat);
                }
            } // shiguStorecats loop:

            // 3. 父级以及父级下面的子级，都要按这个顺序排序
            Collections.sort(shopCats);
            for (ShopCat shopCat : shopCats)
                Collections.sort(shopCat.getSubCats());

            // 4. 缓存
            shopCatCache.put(shopId, shopCats);

        } // 数据库查询完成
        return shopCats;
    }

    /**
     * 查店铺的星星数
     *
     * @param shopId 店铺ID
     * @return 星星数值
     */
    @Override
    public Long selShopStarById(Long shopId) {
        Cache shopStarCache = cacheManager.getCache("shopStarCache");
        Long star = shopStarCache.get(shopId, Long.class);

        if (star == null) {
            // 星星默认0
            star = 0L;
            // 缓存不存在：
            //      1. 查询数据库
            ShiguShopLicenseExample licenseExample = new ShiguShopLicenseExample();
            licenseExample.createCriteria()
                    .andShopIdEqualTo(shopId)
                    .andLicenseTypeEqualTo(6)       //权益 == 星星
                    .andLicenseFailureEqualTo(0);   //权益有效
            List<ShiguShopLicense> shiguShopLicenses = shiguShopLicenseMapper.selectByExample(licenseExample);

            // license_type=6的权益中，存储的是星星数
            // 如果没有这条记录或这条记录的license_failure为1，返回星星数0
            if (shiguShopLicenses.size() != 0) {
                // 2. 取星星， 此处只可能有一条
                ShiguShopLicense shiguShopLicense = shiguShopLicenses.get(0);
                String context = shiguShopLicense.getContext();
                try {
                    star = Long.valueOf(context);
                } catch (NumberFormatException ignore) {
                    // 忽略
                }
            }

            // 3. 缓存星星数
            shopStarCache.put(shopId, star);
        } //star == null ) end
        return star;
    }

    /**
     * 按店铺ID查商品总数
     *
     * @param shopId
     * @return
     */
    @Override
    public Long selItemNumberById(Long shopId) {
        ShopForCdnBo shopForCdnBo = new ShopForCdnBo();
        shopForCdnBo.setShopId(shopId);
        shopForCdnBo.setIsOff(0);
        Long total = selectCountByEsBo(shopForCdnBo);
        return total;
    }

    /**
     * 查店铺推荐宝贝,按shopId
     *
     * @param shopId 店铺ID
     * @return 商品豆腐块信息
     */
    @Override
    public List<ItemShowBlock> selRecomments(Long shopId) {
        if(shopId == null){
            return null;
        }
        Cache cache = cacheManager.getCache("shopRecommentsCache");
        List itemShowBlockLists = cache.get(shopId, List.class);
        if(itemShowBlockLists != null){
            return (List<ItemShowBlock>)itemShowBlockLists;
        }
        ShiguShop shiguShop = shiguShopMapper.selectByPrimaryKey(shopId);
        if(shiguShop == null){
            return null;
        }
        ShiguGoodsTinyExample goodsTinyExample = new ShiguGoodsTinyExample();
        goodsTinyExample.createCriteria().andStoreIdEqualTo(shopId).andIsShowcaseEqualTo(1).andIsClosedEqualTo(0L)
                .andWebSiteEqualTo(shiguShop.getWebSite());
        ShiguGoodsTiny shiguGoodsTinyFnd = new ShiguGoodsTiny();
        shiguGoodsTinyFnd.setStoreId(shopId);
        shiguGoodsTinyFnd.setIsShowcase(1);
        shiguGoodsTinyFnd.setIsClosed(0L);
        shiguGoodsTinyFnd.setWebSite(shiguShop.getWebSite());
        goodsTinyExample.setOrderByClause("load_date desc");
        goodsTinyExample.setStartIndex(0);
        goodsTinyExample.setEndIndex(10);
        List<ShiguGoodsTiny> shiguGoodsTinyList = shiguGoodsTinyMapper.select(shiguGoodsTinyFnd);
        List<ItemShowBlock> itemShowBlockList = new ArrayList<ItemShowBlock>();
        for(int i = 0;i<shiguGoodsTinyList.size();i++){
            ShiguGoodsTiny shiguGoodsTiny = shiguGoodsTinyList.get(i);
            ItemShowBlock itemShowBlock = new ItemShowBlock();
            itemShowBlock.setWebSite(shiguGoodsTiny.getWebSite());
            itemShowBlock.setTitle(shiguGoodsTiny.getTitle());
            itemShowBlock.setPrice(String.valueOf(shiguGoodsTiny.getPiPrice()));
            itemShowBlock.setItemId(shiguGoodsTiny.getGoodsId());
            itemShowBlock.setImgUrl(shiguGoodsTiny.getPicUrl());
            itemShowBlockList.add(itemShowBlock);
        }
        cache.put(shopId, itemShowBlockList);
        return itemShowBlockList;
    }

    /**
     * 查本店类目聚合情况
     *
     * @param shopId 店铺ID
     * @return 类目聚合父级信息集合
     */
    @Override
    public List<CatPolymerization> selCatRolymerizations(Long shopId) {
        Cache cache = cacheManager.getCache("catPolymerizationCache");

        // 确信强转正确
        @SuppressWarnings("unchecked")
        List<CatPolymerization> polymerizationList = (List<CatPolymerization>) cache.get(shopId, List.class);

        if (polymerizationList == null) {
            ShiguShop shiguShop = shiguShopMapper.selectFieldsByPrimaryKey(shopId, FieldUtil.codeFields("shop_id,web_site"));
            if (shiguShop != null) {
                // 1. ES 查询店铺商品数量（按类目分）
                com.shigu.opensearchsdk.response.SearchResponse<SearchGoodsVo> searchResponse = openSearch.searchFrom(SearchGoodsVo.class)
                        .addFilter(FilterBuilder.number("store_id", shopId))
                        .addAggs(AggsBuilder.count("cid").size(1000))
                        .execute();

                List<Facet.Bucket> items = searchResponse.getResult().getFacet().get(0).getItems();
                List<Long> cids = new ArrayList<>();
                cids.add(-10086L);// In empty 会尴尬的
                for (Facet.Bucket item : items) {
                    cids.add(((Facet.LongBucket) item).getValue());
                }

                // 3. 商品所属类目
                ShiguTaobaocatExample catExample = new ShiguTaobaocatExample();
                catExample.createCriteria().andCidIn(cids);
                List<ShiguTaobaocat> shiguTaobaocats = shiguTaobaocatMapper.selectByExample(catExample);

                // 4. 拿到所有商品类目的父级类目
                Set<Long> parentCids = new HashSet<>();
                parentCids.add(-10010L);
                for (ShiguTaobaocat shiguTaobaocat : shiguTaobaocats) {
                    parentCids.add(shiguTaobaocat.getParentCid());
                }
                ShiguTaobaocatExample parentCatExample = new ShiguTaobaocatExample();
                parentCatExample.createCriteria().andCidIn(new ArrayList<>(parentCids));
                List<ShiguTaobaocat> parentTaobaoCats = shiguTaobaocatMapper.selectByExample(parentCatExample);

                // 5. 父级类目Map<父类目ID，父类目信息>
                Map<Long, CatPolymerization> polymerizationMap = new HashMap<>();
                for (ShiguTaobaocat parentTaobaoCat : parentTaobaoCats) {
                    CatPolymerization catPolymerization = newCatPolymerization(parentTaobaoCat, items);
                    catPolymerization.setSubPolymerizations(new ArrayList<CatPolymerization>());
                    polymerizationMap.put(parentTaobaoCat.getCid(), catPolymerization);
                }
                // 6. 处理商品类目
                for (ShiguTaobaocat shiguTaobaocat : shiguTaobaocats) {
                    CatPolymerization polymerization = newCatPolymerization(shiguTaobaocat, items);
                    CatPolymerization parentPolymerization = polymerizationMap.get(shiguTaobaocat.getParentCid());

                    // 有父类目的，加入其父类目的子类目列表%……%￥￥……&*……&
                    if (parentPolymerization != null) {
                        parentPolymerization.getSubPolymerizations().add(polymerization);
                    } else { // 当前类目当做顶级类目，放入父类目MAP
                        polymerization.setSubPolymerizations(new ArrayList<CatPolymerization>());
                        polymerizationMap.put(shiguTaobaocat.getCid(), polymerization);
                    }
                }
                polymerizationList = new ArrayList<>(polymerizationMap.values());
                cache.put(shopId, polymerizationList);
            }
        }
        return polymerizationList;
    }

    private CatPolymerization newCatPolymerization(ShiguTaobaocat shiguTaobaocat, List<Facet.Bucket> buckets) {
        CatPolymerization polymerization = new CatPolymerization();
        polymerization.setName(shiguTaobaocat.getCname());
        polymerization.setCid(shiguTaobaocat.getCid());
        for (Facet.Bucket bucket : buckets) {
            if (((Facet.LongBucket) bucket).getValue().equals(shiguTaobaocat.getCid())) {
                polymerization.setNumber(((long) bucket.getCount()));
                break;
            }
        }
        return polymerization;
    }

    @Override
    public ShiguPager<ItemShowBlock> searchItemOnsale(List<Long> ids, int pageNo, int pageSize) {
        String webSite = "hz";
        ShiguPager<ItemShowBlock> shiguPager = new ShiguPager<>();
        if (ids == null || ids.isEmpty()) {
            shiguPager.setContent(Collections.<ItemShowBlock>emptyList());
            shiguPager.calPages(0,5);
            shiguPager.setNumber(1);
            return shiguPager;
        }
        ShopForCdnBo shopForCdnBo = new ShopForCdnBo();
        shopForCdnBo.setPageNo(pageNo);
        shopForCdnBo.setPageSize(pageSize);
        shopForCdnBo.setIsOff(0);
        shopForCdnBo.setGoodsIds(ids);
        selectItemShowBlockByBo(shopForCdnBo,shiguPager,webSite);
        return shiguPager;
    }

    /**
     * 查询店内出售中的商品
     *
     * @param keyword  关键字
     * @param orderBy  排序
     * @param pageNo   当前页码
     * @param pageSize
     * @return 商品豆腐块分页信息
     */
    @Override
    public ShiguPager<ItemShowBlock> searchItemOnsale(String keyword, Long shopId, String orderBy, int pageNo, int pageSize) {
        String webSite = "hz";
        ShiguPager<ItemShowBlock> shiguPager = new ShiguPager<ItemShowBlock>();
        ShopForCdnBo shopForCdnBo = new ShopForCdnBo();
        shopForCdnBo.setKeyword(keyword);
        shopForCdnBo.setOrderBy(orderBy);
        shopForCdnBo.setPageNo(pageNo);
        shopForCdnBo.setPageSize(pageSize);
        shopForCdnBo.setShopId(shopId);
        shopForCdnBo.setIsOff(0);
        selectItemShowBlockByBo(shopForCdnBo,shiguPager,webSite);
        return shiguPager;
    }

    /**
     * 查询店内出售中的商品
     *
     * @param keyword  关键字
     * @param cid      淘宝标准类目ID
     * @param scid     店内类目ID
     * @param orderBy  排序
     * @param pageNo   当前页
     * @param pageSize 每页数量
     * @return 商品豆腐块分页信息
     */
    @Override
    public ShiguPager<ItemShowBlock> searchItemOnsale(String keyword, Long shopId, Long cid, String scid, String orderBy,Date startTime,Date endTime, int pageNo, int pageSize) {
//        if (cid == null && StringUtils.isEmpty(scid)) {
//            return searchItemOnsale(keyword, shopId, orderBy, pageNo, pageSize);
//        }
        String webSite = "hz";
        ShiguPager<ItemShowBlock> shiguPager = new ShiguPager<ItemShowBlock>();
        ShopForCdnBo shopForCdnBo = new ShopForCdnBo();
        shopForCdnBo.setKeyword(keyword);
        shopForCdnBo.setOrderBy(orderBy);
        shopForCdnBo.setPageNo(pageNo);
        shopForCdnBo.setPageSize(pageSize);
        shopForCdnBo.setCid(cid);
        shopForCdnBo.setScid(scid);
        shopForCdnBo.setShopId(shopId);
        shopForCdnBo.setIsOff(0);
        shopForCdnBo.setDateFrom(startTime);
        shopForCdnBo.setDateTo(endTime);
        selectItemShowBlockByBo(shopForCdnBo,shiguPager,webSite);
        return shiguPager;
    }

    /**
     * 查询店内出售中的商品
     *
     * @param keyword   关键字
     * @param priceFrom 价格开始值
     * @param priceTo   价格结束值
     * @param orderBy   排序
     * @param pageNo    当前页
     * @param pageSize  每页数量
     * @return 商品豆腐块分页信息
     */
    @Override
    public ShiguPager<ItemShowBlock> searchItemOnsale(String keyword, Long shopId, Double priceFrom, Double priceTo, String orderBy,Date startTime,Date endTime, int pageNo, int pageSize) {
//        if (priceFrom == null || priceTo == null) {
//            return searchItemOnsale(keyword, shopId, orderBy, pageNo, pageSize);
//        }
        String webSite = "hz";
        ShiguPager<ItemShowBlock> shiguPager = new ShiguPager<ItemShowBlock>();
        ShopForCdnBo shopForCdnBo = new ShopForCdnBo();
        shopForCdnBo.setKeyword(keyword);
        shopForCdnBo.setOrderBy(orderBy);
        shopForCdnBo.setPageNo(pageNo);
        shopForCdnBo.setPageSize(pageSize);
        shopForCdnBo.setPriceFrom(priceFrom);
        shopForCdnBo.setPriceTo(priceTo);
        shopForCdnBo.setShopId(shopId);
        shopForCdnBo.setIsOff(0);
        shopForCdnBo.setDateFrom(startTime);
        shopForCdnBo.setDateTo(endTime);
        selectItemShowBlockByBo(shopForCdnBo,shiguPager,webSite);
        return shiguPager;
    }

    /**
     * 查询店内仓库中的商品
     *
     * @param from     开始时间
     * @param to       结束时间
     * @param pageNo   当前页
     * @param pageSize 每页条数
     * @return 商品豆腐块分页信息
     */
    @Override
       public ShiguPager<ItemShowBlock> searchItemInstock(Date from, Date to, Long shopId, int pageNo, int pageSize) {
        ShopForCdnBo shopForCdnBo = new ShopForCdnBo();
        shopForCdnBo.setPageNo(pageNo);
        shopForCdnBo.setPageSize(pageSize);
        shopForCdnBo.setShopId(shopId);
        shopForCdnBo.setSoldDateFrom(from);
        shopForCdnBo.setSoldDateTo(to);
        shopForCdnBo.setIsOff(1);
        shopForCdnBo.setOrderBy("soldOutTime_desc");
        List<ItemShowBlock> itemShowBlockList = selectItemShowBlockByEsBo(shopForCdnBo);
        ShiguPager<ItemShowBlock> shiguPager = new ShiguPager<ItemShowBlock>();
        Long resultCount = selectCountByEsBo(shopForCdnBo);
        shiguPager.calPages(resultCount.intValue(), pageSize);
        shiguPager.setContent(itemShowBlockList);
        shiguPager.setNumber(pageNo);
        return shiguPager;
    }

    /**
     * 查店铺基本信息,用于店铺页
     *
     * @param shopId
     * @return
     */
    @Override
    public ShopBaseForCdn selShopBase(Long shopId) {
        if (shopId == null)
            return null;
        Cache shopBaseCache = cacheManager.getCache("shopBaseCache");
        ShopBaseForCdn shopBase = shopBaseCache.get(shopId, ShopBaseForCdn.class);
        if (shopBase == null) {
            ShiguShop shiguShop = shiguShopMapper.selectByPrimaryKey(shopId);
            if (shiguShop != null) {
                shopBase = new ShopBaseForCdn();
                shopBase.setMainBus(shiguShop.getMainBus());
                shopBase.setOpenTime(DateFormatUtils.format(shiguShop.getCreateDate(), "yyyy-MM-dd"));
                shopBase.setDataPackageUrl(shiguShop.getDataPacketUrl());
                shopBase.setTaobaoUrl(shiguShop.getTaobaoUrl());
                shopBaseCache.put(shopId, shopBase);
            }
        }
        return shopBase;
    }

    /**
     * 按条件Bo查询店内仓库中的商品
     *
     * @param shopForCdnBo     查询条件
     * @param shiguPager       返回页面
     * @param webSite   分站信息
     * @return 商品豆腐块信息
     */
    public List<ItemShowBlock> selectItemShowBlockByBo(ShopForCdnBo shopForCdnBo, ShiguPager<ItemShowBlock> shiguPager, String webSite) {
        if (shopForCdnBo == null) {
            shopForCdnBo = new ShopForCdnBo();
        }
        boolean isDataBase = (shopForCdnBo.getIsOff() != null && !shopForCdnBo.getIsOff().equals(0)) || shopForCdnBo.getSoldDateFrom() != null || shopForCdnBo.getSoldDateTo() != null;
        if (isDataBase) {
            return selectItemShowBlockByDBBo(shopForCdnBo, shiguPager, webSite);
        }
        return selectItemSearchBlockByOpenSearchBo(shopForCdnBo,shiguPager,webSite);
    }

    /**
     * 按条件Bo在OpenSearch查询店内仓库中的商品
     *
     * @param shopForCdnBo     查询条件
     * @param shiguPager       返回页面
     * @param webSite   分站信息
     * @return 商品豆腐块信息
     */
    public List<ItemShowBlock> selectItemSearchBlockByOpenSearchBo(ShopForCdnBo shopForCdnBo, ShiguPager<ItemShowBlock> shiguPager, String webSite) {
        final String[] FIELDS = {"goods_id", "title", "price", "goods_no", "web_site"};
        List<ItemShowBlock> itemShowBlocks = Lists.newArrayList();
        shiguPager.setNumber(shopForCdnBo.getPageNo());
        shiguPager.setContent(itemShowBlocks);
        SearchParamsBuilder searchParamsBuilder = getSearchParamsBuilder(shopForCdnBo, webSite, FIELDS);
        try {
            SearchResult searchResult = searcherClient.execute(searchParamsBuilder);
            JSONObject jsonObject = JSON.parseObject(searchResult.getResult());
            if(StringUtils.equals("OK",jsonObject.getString("status"))) {
                JSONObject data = jsonObject.getJSONObject("result");
                int total = data.getIntValue("total");
                shiguPager.calPages(total,shopForCdnBo.getPageSize());
                JSONArray items = data.getJSONArray("items");

                List<OpenItemVo> openItemVos = items.toJavaList(OpenItemVo.class);
                if (openItemVos != null && !openItemVos.isEmpty()) {
                    for (OpenItemVo openItemVoForStore:openItemVos) {
                        ItemShowBlock itemShowBlock = BeanMapper.map(openItemVoForStore,ItemShowBlock.class);
                        itemShowBlock.setImgUrl(openItemVoForStore.getPicUrl());
                        itemShowBlock.setItemId(openItemVoForStore.getGoodsId());
                        itemShowBlock.setWebSite(webSite);
                        itemShowBlocks.add(itemShowBlock);
                    }
                }
            } else {
                throw new Main4Exception(jsonObject.getString("errors"));
            }
        } catch (OpenSearchException|OpenSearchClientException ignored) {
        } catch (Main4Exception e) {
            logger.error("搜索失败", e);
        }
        return itemShowBlocks;
    }

    /**
     * 按条件Bo封装OpenSearch查询条件
     *
     * @param shopForCdnBo     查询条件
     * @param webSite       分站信息
     * @param fields   需要字段
     * @return OpenSearch的SearchParamsBuilder条件
     */
    public SearchParamsBuilder getSearchParamsBuilder(ShopForCdnBo shopForCdnBo, String webSite, String[] fields) {
        SearchParamsBuilder searchParamsBuilder = null;
        final String appName = "goods_search_";
        Config config = new Config(Lists.<String>newArrayList(appName + webSite));
        int pageNo = shopForCdnBo.getPageNo();
        int pageSize = shopForCdnBo.getPageSize();
        config.setStart(pageSize * (pageNo - 1));
        config.setHits(pageSize);
        config.setFetchFields(Lists.<String>newArrayList(fields));
        config.setSearchFormat(SearchFormat.JSON);
        SearchParams searchParams = new SearchParams(config);
        String orderBy = shopForCdnBo.getOrderBy();
        Sort sort = new Sort();
        if (StringUtils.isEmpty(orderBy)) {
            sort.addToSortFields(new SortField("created", Order.DECREASE));
        } else {
            switch (orderBy) {
                case "price_up":
                {
                    sort.addToSortFields(new SortField("pi_price", Order.INCREASE));
                    break;
                }
                case "price_down":
                {
                    sort.addToSortFields(new SortField("pi_price", Order.DECREASE));
                    break;
                }
                case "time_up":
                {
                    sort.addToSortFields(new SortField("created", Order.INCREASE));
                    break;
                }
                case "time_down":
                {
                    sort.addToSortFields(new SortField("created", Order.DECREASE));
                    break;
                }
                default:
                {
                    sort.addToSortFields(new SortField("created", Order.DECREASE));
                    break;
                }
            }
        }
        searchParams.setSort(sort);
        String keyword = shopForCdnBo.getKeyword();
        StringBuilder query = new StringBuilder();
        if(keyword != null && !keyword.trim().isEmpty()) {
            query.append("title:\"");
            query.append(keyword);
            query.append("\" ^10 OR goods_no:\"");
            query.append(keyword);
            query.append("\" ^ 5");
        }
        Long shopId = shopForCdnBo.getShopId();
        if (shopId != null && shopForCdnBo.getScid() != null) {
            Long scid = Long.valueOf(shopForCdnBo.getScid());
            String scidStr = null;
            ShiguStorecat storecat=storeCatMapper.selectByPrimaryKey(scid);
            if(storecat != null && storecat.getIsParent() != null && storecat.getIsParent() == 1) {//是父类
                ShiguStorecatExample catExample=new ShiguStorecatExample();
                catExample.createCriteria().andParentScidEqualTo(scid);
                List<ShiguStorecat> subcats =storeCatMapper.selectByExample(catExample);//子级类目
                scidStr = null;
                if(subcats.size() == 0){
                    scid=(scid-shopId)/1000000;
                    scidStr=scid.toString();
                }else{
                    for(ShiguStorecat c:subcats){
                        scidStr+=","+((c.getScid()-shopId)/1000000);
                    }
                    if(scidStr.startsWith(",")){
                        scidStr=scidStr.substring(1);
                    }else{
                        scidStr=scid.toString();
                    }
                }
            }else{
                scid=(scid-shopId)/1000000;
                scidStr=scid.toString();
            }
            if (StringUtils.isNotEmpty(query)){
                query.append("AND (cid_all:\"");
                query.append(scidStr);
                query.append("\")");
            } else {
                query.append("cid_all:\"");
                query.append(scidStr);
                query.append("\"");
            }
        }
        if (StringUtils.isNotEmpty(query)) {
            searchParams.setQuery(query.toString());
        }
        searchParamsBuilder = SearchParamsBuilder.create(searchParams);
        shopId = shopForCdnBo.getShopId();
        if (shopId != null) {
            searchParamsBuilder.addFilter("store_id = " + shopId, "AND");

        }
        List<Long> goodsIds = shopForCdnBo.getGoodsIds();
        if (goodsIds != null ) {
            searchParamsBuilder.addFilter("goods_id = -1");
            if (goodsIds.size() > 0) {
                for (Long id: goodsIds){
                    searchParamsBuilder.addFilter("goods_id = " + id, "OR");
                }
            }
        }
        Long cid = shopForCdnBo.getCid();
        if (cid != null) {
            searchParamsBuilder.addFilter("cid = " + cid,"AND");
        }
        Double priceFrom = shopForCdnBo.getPriceFrom();
        if (priceFrom != null) {
            Double fromPrice = priceFrom * 100;
            searchParamsBuilder.addFilter("pi_price >= " + fromPrice.longValue(), "AND");
        }
        Double priceTo = shopForCdnBo.getPriceTo();
        if (priceTo != null) {
            Double toPrice = priceTo * 100;
            searchParamsBuilder.addFilter("pi_price < " + toPrice.longValue(), "AND");
        }
        Date dateFrom = shopForCdnBo.getDateFrom();
        if (dateFrom != null) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            searchParamsBuilder.addFilter("created >= " + dateFrom.getTime(), "AND");
        }
        Date dateTo = shopForCdnBo.getDateTo();
        if (dateTo != null) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            searchParamsBuilder.addFilter("created < " + dateTo.getTime(), "AND");
        }
        return searchParamsBuilder;
    }

    /**
     * 按条件Bo在数据库中查询店内仓库中的商品
     *
     * @param shopForCdnBo     查询条件
     * @param shiguPager       返回页面
     * @param webSite   分站信息
     * @return 商品豆腐块信息
     */
    private  List<ItemShowBlock> selectItemShowBlockByDBBo(ShopForCdnBo shopForCdnBo, ShiguPager<ItemShowBlock> shiguPager, String webSite) {
        List<ItemShowBlock> itemShowBlocks = selectItemShowBlockByDBBo(shopForCdnBo);
        shiguPager.setContent(itemShowBlocks);
        int total = selectCountByDBBo(shopForCdnBo).intValue();
        shiguPager.calPages(total, shopForCdnBo.getPageSize());
        shiguPager.setNumber(shopForCdnBo.getPageNo());
        return itemShowBlocks;
    }

    public Long selectCountByDBBo(ShopForCdnBo shopForCdnBo) {
        ShiguGoodsSoldoutExample shiguGoodsSoldoutExample = new ShiguGoodsSoldoutExample();
        ShiguGoodsSoldoutExample.Criteria criteria = shiguGoodsSoldoutExample.createCriteria();
        /**
         * 设置查询条件
         */
        if (null != shopForCdnBo.getKeyword()&&StringUtils.isNotEmpty(shopForCdnBo.getKeyword())) {
            criteria.andTitleLike("%"+shopForCdnBo.getKeyword()+"%");
        }
        if (null != shopForCdnBo.getGoodsIds() && shopForCdnBo.getGoodsIds().size() > 0) {
            criteria.andGoodsIdIn(shopForCdnBo.getGoodsIds());
        }
        if (null != shopForCdnBo.getCid()) {
            criteria.andCidEqualTo(shopForCdnBo.getCid());
        }
        /*if (null != shopForCdnBo.getScid()) {
            criteria.andCidAllEqualTo(shopForCdnBo.getScid());
        }*/
        if (null != shopForCdnBo.getPriceFrom() || null != shopForCdnBo.getPriceTo()) {
            if (null != shopForCdnBo.getPriceFrom() && null == shopForCdnBo.getPriceTo()) {
                criteria.andPriceGreaterThan(shopForCdnBo.getPriceFrom().longValue());
            }
            if (null != shopForCdnBo.getPriceTo() && null == shopForCdnBo.getPriceFrom()) {
                criteria.andPriceLessThan(shopForCdnBo.getPriceTo().longValue());
            }
            if (null != shopForCdnBo.getPriceFrom() && null != shopForCdnBo.getPriceTo()) {
                criteria.andPriceBetween(shopForCdnBo.getPriceFrom().longValue(), shopForCdnBo.getPriceTo().longValue());
            }
        }
        if (null != shopForCdnBo.getDateFrom() || null != shopForCdnBo.getDateTo()) {
            if (null != shopForCdnBo.getDateFrom() && null == shopForCdnBo.getDateTo()) {
                criteria.andCreatedGreaterThan(shopForCdnBo.getDateFrom());
            }
            if (null != shopForCdnBo.getDateTo() && null == shopForCdnBo.getDateFrom()) {
                criteria.andCreatedLessThan(shopForCdnBo.getDateTo());
            }
            if (null != shopForCdnBo.getDateFrom() && null != shopForCdnBo.getDateTo()) {
                criteria.andCreatedBetween(shopForCdnBo.getDateFrom(), shopForCdnBo.getDateTo());
            }
        }
        if (null != shopForCdnBo.getSoldDateFrom() || null != shopForCdnBo.getSoldDateTo()) {
            if (null != shopForCdnBo.getSoldDateFrom() && null == shopForCdnBo.getSoldDateTo()) {
                criteria.andSoldoutTimeGreaterThan(shopForCdnBo.getSoldDateFrom());
            }
            if (null != shopForCdnBo.getSoldDateTo() && null == shopForCdnBo.getSoldDateFrom()) {
                criteria.andSoldoutTimeLessThan(shopForCdnBo.getSoldDateTo());
            }
            if (null != shopForCdnBo.getSoldDateFrom() && null != shopForCdnBo.getSoldDateTo()) {
                criteria.andSoldoutTimeBetween(shopForCdnBo.getDateFrom(), shopForCdnBo.getSoldDateTo());
            }
        }
        if (null != shopForCdnBo.getShopId()) {
            criteria.andStoreIdEqualTo(shopForCdnBo.getShopId());
        }
        if (null != shopForCdnBo.getScid()&&StringUtils.isNotEmpty(shopForCdnBo.getScid())) {
            //先查一下是否父级
            Long scid = Long.parseLong(shopForCdnBo.getScid());
            String scidStr = "";
            ShiguStorecat storecat = storeCatMapper.selectByPrimaryKey(scid);
            if (storecat != null && storecat.getIsParent() != null && storecat.getIsParent() == 1) {//是父类
                ShiguStorecatExample catExample = new ShiguStorecatExample();
                catExample.createCriteria().andParentScidEqualTo(scid);
                List<ShiguStorecat> subcats = storeCatMapper.selectByExample(catExample);//子级类目
                scidStr = "";
                if (subcats.size() == 0) {
                    scid = (scid - shopForCdnBo.getShopId()) / 1000000;
                    scidStr = scid.toString();

                } else {
                    for (ShiguStorecat c : subcats) {
                        scidStr += "," + ((c.getScid() - shopForCdnBo.getShopId()) / 1000000);
                    }
                    if (scidStr.startsWith(",")) {
                        scidStr = scidStr.substring(1);
                    } else {
                        scidStr = scid.toString();
                    }
                }
            } else {
                scid = (scid - shopForCdnBo.getShopId()) / 1000000;
                scidStr = scid.toString();
            }
            criteria.andCidAllEqualTo(scidStr);
        }
        shiguGoodsSoldoutExample.setWebSite("hz");
        long total = shiguGoodsSoldoutMapper.countByExample(shiguGoodsSoldoutExample);
        return Long.valueOf(total);
    }

    public List<ItemShowBlock> selectItemShowBlockByDBBo(ShopForCdnBo shopForCdnBo) {
        if (null == shopForCdnBo.getIsOff()||shopForCdnBo.getIsOff()==1) {
            return null;
        }

        ShiguGoodsSoldoutExample shiguGoodsSoldoutExample = new ShiguGoodsSoldoutExample();
        ShiguGoodsSoldoutExample.Criteria criteria = shiguGoodsSoldoutExample.createCriteria();
        // 排序设置
        if (StringUtils.isEmpty(shopForCdnBo.getOrderBy())) {
            // 默认时间排序
            shiguGoodsSoldoutExample.setOrderByClause("created desc");
        } else {
            if (StringUtils.equals(shopForCdnBo.getOrderBy(), "price_up")) {
                shiguGoodsSoldoutExample.setOrderByClause("pi_price asc");
            }
            if (StringUtils.equals(shopForCdnBo.getOrderBy(), "price_down")) {
                shiguGoodsSoldoutExample.setOrderByClause("pi_price desc");
            }
            if (StringUtils.equals(shopForCdnBo.getOrderBy(), "time_up")) {
                shiguGoodsSoldoutExample.setOrderByClause("created asc");
            }
            if (StringUtils.equals(shopForCdnBo.getOrderBy(), "time_down")) {
                shiguGoodsSoldoutExample.setOrderByClause("created desc");
            }
            if (StringUtils.equals(shopForCdnBo.getOrderBy(), "soldOutTime_desc")) {
                shiguGoodsSoldoutExample.setOrderByClause("soldout_time desc");
            }
        }
        /**
         * 设置查询条件
         */
        if (null != shopForCdnBo.getKeyword()&&StringUtils.isNotEmpty(shopForCdnBo.getKeyword())) {
            criteria.andTitleLike("%"+shopForCdnBo.getKeyword()+"%");
        }
        if (null != shopForCdnBo.getGoodsIds() && shopForCdnBo.getGoodsIds().size() > 0) {
            criteria.andGoodsIdIn(shopForCdnBo.getGoodsIds());
        }
        if (null != shopForCdnBo.getCid()) {
            criteria.andCidEqualTo(shopForCdnBo.getCid());
        }
        if (null != shopForCdnBo.getPriceFrom() || null != shopForCdnBo.getPriceTo()) {
            if (null != shopForCdnBo.getPriceFrom() && null == shopForCdnBo.getPriceTo()) {
                criteria.andPiPriceGreaterThan(shopForCdnBo.getPriceFrom().longValue());
            }
            if (null != shopForCdnBo.getPriceTo() && null == shopForCdnBo.getPriceFrom()) {
                criteria.andPiPriceLessThan(shopForCdnBo.getPriceTo().longValue());
            }
            if (null != shopForCdnBo.getPriceFrom() && null != shopForCdnBo.getPriceTo()) {
                criteria.andPiPriceBetween(shopForCdnBo.getPriceFrom().longValue(), shopForCdnBo.getPriceTo().longValue());
            }
        }
        if (null != shopForCdnBo.getDateFrom() || null != shopForCdnBo.getDateTo()) {
            if (null != shopForCdnBo.getDateFrom() && null == shopForCdnBo.getDateTo()) {
                criteria.andCreatedGreaterThan(shopForCdnBo.getDateFrom());
            }
            if (null != shopForCdnBo.getDateTo() && null == shopForCdnBo.getDateFrom()) {
                criteria.andCreatedLessThan(shopForCdnBo.getDateTo());
            }
            if (null != shopForCdnBo.getDateFrom() && null != shopForCdnBo.getDateTo()) {
                criteria.andCreatedBetween(shopForCdnBo.getDateFrom(), shopForCdnBo.getDateTo());
            }
        }
        if (null != shopForCdnBo.getSoldDateFrom() || null != shopForCdnBo.getSoldDateTo()) {
            if (null != shopForCdnBo.getSoldDateFrom() && null == shopForCdnBo.getSoldDateTo()) {
                criteria.andSoldoutTimeGreaterThan(shopForCdnBo.getSoldDateFrom());
            }
            if (null != shopForCdnBo.getSoldDateTo() && null == shopForCdnBo.getSoldDateFrom()) {
                criteria.andSoldoutTimeLessThan(shopForCdnBo.getSoldDateTo());
            }
            if (null != shopForCdnBo.getSoldDateFrom() && null != shopForCdnBo.getSoldDateTo()) {
                criteria.andSoldoutTimeBetween(shopForCdnBo.getDateFrom(), shopForCdnBo.getSoldDateTo());
            }
        }
        if (null != shopForCdnBo.getShopId()) {
            criteria.andStoreIdEqualTo(shopForCdnBo.getShopId());
        }
        if (null != shopForCdnBo.getScid()&&StringUtils.isNotEmpty(shopForCdnBo.getScid())) {
            //先查一下是否父级
            Long scid = Long.parseLong(shopForCdnBo.getScid());
            String scidStr = "";
            ShiguStorecat storecat = storeCatMapper.selectByPrimaryKey(scid);
            if (storecat != null && storecat.getIsParent() != null && storecat.getIsParent() == 1) {//是父类
                ShiguStorecatExample catExample = new ShiguStorecatExample();
                catExample.createCriteria().andParentScidEqualTo(scid);
                List<ShiguStorecat> subcats = storeCatMapper.selectByExample(catExample);//子级类目
                scidStr = "";
                if (subcats.size() == 0) {
                    scid = (scid - shopForCdnBo.getShopId()) / 1000000;
                    scidStr = scid.toString();

                } else {
                    for (ShiguStorecat c : subcats) {
                        scidStr += "," + ((c.getScid() - shopForCdnBo.getShopId()) / 1000000);
                    }
                    if (scidStr.startsWith(",")) {
                        scidStr = scidStr.substring(1);
                    } else {
                        scidStr = scid.toString();
                    }
                }
            } else {
                scid = (scid - shopForCdnBo.getShopId()) / 1000000;
                scidStr = scid.toString();
            }
            criteria.andCidAllEqualTo(scidStr);
        }
        shiguGoodsSoldoutExample.setStartIndex(shopForCdnBo.getPageSize() * (shopForCdnBo.getPageNo() - 1));
        shiguGoodsSoldoutExample.setEndIndex(shopForCdnBo.getPageNo() * shopForCdnBo.getPageSize());
        shiguGoodsSoldoutExample.setWebSite("hz");
        List<ShiguGoodsSoldout> shiguGoodsSoldouts = shiguGoodsSoldoutMapper.selectFieldsByExample(shiguGoodsSoldoutExample, FieldUtil.codeFields("title,goods_id,pic_url,pi_price,web_site,goods_no,soldout_time"));
        List<ItemShowBlock> itemShowBlocks = new ArrayList<>();
        for (ShiguGoodsSoldout shiguGoodsSoldout : shiguGoodsSoldouts){
            ItemShowBlock itemShowBlock= new ItemShowBlock();
            itemShowBlock.setImgUrl(shiguGoodsSoldout.getPicUrl());
            itemShowBlock.setTitle(shiguGoodsSoldout.getTitle());
            itemShowBlock.setItemId(shiguGoodsSoldout.getGoodsId());
            if (null!=shiguGoodsSoldout.getPiPrice()){

                itemShowBlock.setPrice(shiguGoodsSoldout.getPiPrice().toString());
            }
            itemShowBlock.setWebSite(shiguGoodsSoldout.getWebSite());
            itemShowBlock.setGoodsNo(shiguGoodsSoldout.getGoodsNo());
            itemShowBlock.setSoldOutTime(shiguGoodsSoldout.getSoldoutTime().toString());
            itemShowBlocks.add(itemShowBlock);
        }
        return itemShowBlocks;
    }

}
