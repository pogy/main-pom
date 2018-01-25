package com.shigu.main4.storeservices.impl;

import com.aliyun.opensearch.sdk.dependencies.com.google.common.collect.Lists;
import com.aliyun.opensearch.sdk.generated.search.Order;
import com.aliyun.opensearch.sdk.generated.search.SortField;
import com.opentae.core.mybatis.utils.FieldUtil;
import com.opentae.data.mall.beans.*;
import com.opentae.data.mall.examples.*;
import com.opentae.data.mall.interfaces.*;
import com.shigu.main4.bo.OnsaleItemQueryBO;
import com.shigu.main4.common.tools.ShiguPager;
import com.shigu.main4.common.util.BeanMapper;
import com.shigu.main4.item.vo.OpenItemVo;
import com.shigu.main4.item.vo.SearchGoodsVo;
import com.shigu.main4.storeservices.ShopForCdnService;
import com.shigu.main4.storeservices.bo.ShopForCdnBo;
import com.shigu.main4.tools.RedisIO;
import com.shigu.main4.vo.*;
import com.shigu.opensearchsdk.OpenSearch;
import com.shigu.opensearchsdk.builder.AggsBuilder;
import com.shigu.opensearchsdk.builder.FilterBuilder;
import com.shigu.opensearchsdk.builder.QueryBuilder;
import com.shigu.opensearchsdk.builder.SummaryBuild;
import com.shigu.opensearchsdk.query.Query;
import com.shigu.opensearchsdk.query.TermQuery;
import com.shigu.opensearchsdk.response.Facet;
import com.shigu.opensearchsdk.response.Result;
import com.shigu.opensearchsdk.response.SearchResponse;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
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
    private ShiguShopStyleRelationMapper shiguShopStyleRelationMapper;

    @Autowired
    private ShiguStyleMapper shiguStyleMapper;

    @Resource
    private OpenSearch openSearch;

    @Resource
    private ShiguGoodsSoldoutMapper shiguGoodsSoldoutMapper;

    @Autowired
    private RedisIO redisIO;

    // 店铺风格处理队列redis标签
    private static final String SHOP_STYLE_HANDLER_QUEUE_INDEX = "shop_style_handler_queue_";

    private static final String SEARCH_APP = "goods_search_";
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
    public Long selItemNumberById(Long shopId,String webSite) {
        ShopForCdnBo shopForCdnBo = new ShopForCdnBo();
        shopForCdnBo.setShopId(shopId);
        shopForCdnBo.setIsOff(0);
        shopForCdnBo.setPageNo(1);
        shopForCdnBo.setPageSize(0);
        return ((long) getRequestBuilder(shopForCdnBo,webSite).execute().getResult().getTotal());
    }

    /**
     * 查店铺推荐宝贝,按shopId
     *
     * @param shopId 店铺ID
     * @return 商品豆腐块信息
     */
    @Override
    @SuppressWarnings("unchecked")
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
            itemShowBlock.setShopId(shiguGoodsTiny.getStoreId());
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

                List<Facet.Bucket> items = new ArrayList<>();
                //防止下标越界
                if(searchResponse.getResult().getFacet() !=null && searchResponse.getResult().getFacet().size()>0){
                    items = searchResponse.getResult().getFacet().get(0).getItems();
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
                }
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
    public ShiguPager<ItemShowBlock> searchItemOnsale(List<Long> ids,String webSite, int pageNo, int pageSize) {
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
    public ShiguPager<ItemShowBlock> searchItemOnsale(String keyword, Long shopId,String webSite, String orderBy, int pageNo, int pageSize) {
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
    public ShiguPager<ItemShowBlock> searchItemOnsale(String keyword, Long shopId,String webSite, Long cid, String scid, String orderBy,Date startTime,Date endTime, int pageNo, int pageSize) {
//        if (cid == null && StringUtils.isEmpty(scid)) {
//            return searchItemOnsale(keyword, shopId, orderBy, pageNo, pageSize);
//        }
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
    public ShiguPager<ItemShowBlock> searchItemOnsale(String keyword, Long shopId,String webSite, Double priceFrom, Double priceTo, String orderBy,Date startTime,Date endTime, int pageNo, int pageSize) {
//        if (priceFrom == null || priceTo == null) {
//            return searchItemOnsale(keyword, shopId, orderBy, pageNo, pageSize);
//        }
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


    @Override
    public ShiguPager<ItemShowBlock> searchItemOnsaleByBO(OnsaleItemQueryBO onsaleItemQueryBO, String webSite, int paggeNo, int pageSize) {
        ShiguPager<ItemShowBlock> pager = new ShiguPager<>();
        ShopForCdnBo bo = BeanMapper.map(onsaleItemQueryBO, ShopForCdnBo.class);
        bo.setIsOff(0);
        bo.setPageNo(paggeNo);
        bo.setPageSize(pageSize);
        selectItemShowBlockByBo(bo,pager,webSite);
        return pager;
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
        ShiguGoodsSoldoutExample shiguGoodsSoldoutExample = createExampleByBo(shopForCdnBo);
        List<ItemShowBlock> itemShowBlockList = selectItemShowBlockByDBBo(shiguGoodsSoldoutExample);
        ShiguPager<ItemShowBlock> shiguPager = new ShiguPager<ItemShowBlock>();
        shiguPager.calPages(shiguGoodsSoldoutMapper.countByExample(shiguGoodsSoldoutExample), pageSize);
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
                shopBase.setType(shiguShop.getType());
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
        List<ItemShowBlock> itemShowBlocks = Lists.newArrayList();
        shiguPager.setNumber(shopForCdnBo.getPageNo());
        shiguPager.setContent(itemShowBlocks);
        OpenSearch.RequestBuilder<OpenItemVo> searchParamsBuilder = getRequestBuilder(shopForCdnBo,webSite);
        SearchResponse<OpenItemVo> response = searchParamsBuilder.execute();
        if (response.isSuccess()) {
            Result<OpenItemVo> result = response.getResult();
            shiguPager.calPages(result.getTotal(), shopForCdnBo.getPageSize());
            for (OpenItemVo itemVo : BeanMapper.getFieldList(result.getItems(), "fields", OpenItemVo.class)) {
                ItemShowBlock itemShowBlock = BeanMapper.map(itemVo,ItemShowBlock.class);
                itemShowBlock.setImgUrl(itemVo.getPicUrl());
                itemShowBlock.setPrice(itemShowBlock.parsePrice(itemVo.getPiPrice()));
                itemShowBlock.setItemId(itemVo.getGoodsId());
                itemShowBlock.setWebSite(webSite);
                itemShowBlock.setShopId(itemVo.getStoreId());
                itemShowBlocks.add(itemShowBlock);
            }
        }
        return itemShowBlocks;
    }

    /**
     * 按条件Bo封装OpenSearch查询条件
     *
     * @param shopForCdnBo     查询条件
     * @return OpenSearch的SearchParamsBuilder条件
     */
    public OpenSearch.RequestBuilder<OpenItemVo> getRequestBuilder(ShopForCdnBo shopForCdnBo,String webSite) {
        String appNameHead="goods_search_";
        OpenSearch.RequestBuilder<OpenItemVo> requestBuilder = openSearch.searchFrom(appNameHead + webSite,OpenItemVo.class)
                .from(shopForCdnBo.getPageSize() * (shopForCdnBo.getPageNo() - 1))
                .size(shopForCdnBo.getPageSize());

        String orderBy = shopForCdnBo.getOrderBy();
        if (StringUtils.isEmpty(orderBy)) {
            requestBuilder.addSort(new SortField("created", Order.DECREASE));
            if (shopForCdnBo.getParentStyleId() != null) {
                requestBuilder.addSort(new SortField("style_search_score",Order.DECREASE));
            }
        } else {
            switch (orderBy) {
                case "price-asc":
                    requestBuilder.addSort(new SortField("pi_price", Order.INCREASE));
                    break;
                case "price-desc":
                    requestBuilder.addSort(new SortField("pi_price", Order.DECREASE));
                    break;
                case "time_up":
                    requestBuilder.addSort(new SortField("created", Order.INCREASE));
                    break;
                case "time_down":
                    requestBuilder.addSort(new SortField("created", Order.DECREASE));
                    break;
                case "xp":
                    requestBuilder.addSort(new SortField("created", Order.DECREASE));
                    break;
                case "popular":
                    requestBuilder.setRank("goods_search_default","goods_search_popular",2000);
                    break;
                case "common":
                    requestBuilder.setRank("rough_project_c","project_c",2000);
                    break;
                default:
                    requestBuilder.addSort(new SortField("created", Order.DECREASE));
                    break;
            }
        }

        String keyword = shopForCdnBo.getKeyword();
        Query searchQuery = null;
        if(StringUtils.isNotBlank(keyword)) {
            searchQuery = QueryBuilder.search("title", keyword).boost(10).or(QueryBuilder.search("goods_no", keyword).boost(5));
            requestBuilder.addSummary(SummaryBuild.field("title").length(120));
        }
        Long shopId = shopForCdnBo.getShopId();
        if (shopId != null && shopForCdnBo.getScid() != null) {
            Long scid = Long.valueOf(shopForCdnBo.getScid());
            String scidStr = selScidStr(shopId,scid);
            TermQuery cidAllQuery = null;
            for (String scidOneCat : scidStr.split(",")) {
                if (cidAllQuery == null) {
                    cidAllQuery = QueryBuilder.termSearch("cid_all", scidOneCat);
                }else {
                    cidAllQuery.or(QueryBuilder.termSearch("cid_all", scidOneCat));
                }
            }
            //TermQuery cidAllQuery = QueryBuilder.termSearch("cid_all", scidStr);
            if (searchQuery != null) {
                searchQuery.and(cidAllQuery);
            } else {
                searchQuery = cidAllQuery;
            }
        }
        if (searchQuery != null) {
            requestBuilder.setQuery(searchQuery);
        }
        shopId = shopForCdnBo.getShopId();
        if (shopId != null) {
            requestBuilder.addFilter(FilterBuilder.number("store_id", shopId));
        }
        if (shopForCdnBo.getParentStyleId() != null) {
            requestBuilder.addFilter(FilterBuilder.number("parent_style_id", shopForCdnBo.getParentStyleId()));
        }
        List<Long> goodsIds = shopForCdnBo.getGoodsIds();
        if (goodsIds != null ) {
            requestBuilder.addFilter(FilterBuilder.termsIn("goods_id", goodsIds.toArray(new Long[goodsIds.size()])));
        }
        Long cid = shopForCdnBo.getCid();
        if (cid != null) {
            requestBuilder.addFilter(FilterBuilder.number("cid", cid));
        }
        Double priceFrom = shopForCdnBo.getPriceFrom();
        if (priceFrom != null) {
            Double fromPrice = priceFrom * 100;
            requestBuilder.addFilter(FilterBuilder.number("pi_price").gte(fromPrice.longValue()));
        }
        Double priceTo = shopForCdnBo.getPriceTo();
        if (priceTo != null) {
            Double toPrice = priceTo * 100;
            requestBuilder.addFilter(FilterBuilder.number("pi_price").lte(toPrice.longValue()));
        }
        Date dateFrom = shopForCdnBo.getDateFrom();
        if (dateFrom != null) {
            requestBuilder.addFilter(FilterBuilder.number("created").gte(dateFrom.getTime()));
        }
        Date dateTo = shopForCdnBo.getDateTo();
        if (dateTo != null) {
            requestBuilder.addFilter(FilterBuilder.number("created").lte(dateTo.getTime()));
        }
        return requestBuilder;
    }

    /**
     * 按shopId和scid获取到对应scidStr/cid_all
     *
     * @param shopId
     * @param scid
     * @return 计算出cid_all或scid_str的结果
     */
    private String selScidStr(Long shopId, Long scid) {
        String scidStr;
        ShiguStorecat storecat = storeCatMapper.selectByPrimaryKey(scid);
        if(storecat != null && storecat.getIsParent() != null && storecat.getIsParent() == 1) {//是父类
            ShiguStorecatExample catExample=new ShiguStorecatExample();
            catExample.createCriteria().andParentScidEqualTo(scid);
            List<ShiguStorecat> subcats =storeCatMapper.selectByExample(catExample);//子级类目
            if(subcats.size() == 0){
                scid=(scid-shopId)/1000000;
                scidStr= scid.toString();
            }else{
                StringBuilder scidStrb = new StringBuilder();
                for(ShiguStorecat c:subcats){
                    scidStrb.append(",").append((c.getScid() - shopId) / 1000000);
                }
                if(scidStrb.toString().startsWith(",")){
                    scidStr = scidStrb.substring(1);
                }else{
                    scidStr = scid.toString();
                }
            }
        }else{
            scid=(scid-shopId)/1000000;
            scidStr = scid.toString();
        }
        return scidStr;
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
        ShiguGoodsSoldoutExample shiguGoodsSoldoutExample = createExampleByBo(shopForCdnBo);
        List<ItemShowBlock> itemShowBlocks = selectItemShowBlockByDBBo(shiguGoodsSoldoutExample);
        shiguPager.setContent(itemShowBlocks);
        int total = shiguGoodsSoldoutMapper.countByExample(shiguGoodsSoldoutExample);
        shiguPager.calPages(total, shopForCdnBo.getPageSize());
        shiguPager.setNumber(shopForCdnBo.getPageNo());
        return itemShowBlocks;
    }

    private List<ItemShowBlock> selectItemShowBlockByDBBo(ShiguGoodsSoldoutExample shiguGoodsSoldoutExample) {
        List<ShiguGoodsSoldout> shiguGoodsSoldouts = shiguGoodsSoldoutMapper.selectFieldsByExample(shiguGoodsSoldoutExample, FieldUtil.codeFields("title,goods_id,pic_url,pi_price,web_site,goods_no,soldout_time"));
        List<ItemShowBlock> itemShowBlocks = new ArrayList<>();
        for (ShiguGoodsSoldout shiguGoodsSoldout : shiguGoodsSoldouts){
            ItemShowBlock itemShowBlock= new ItemShowBlock();
            itemShowBlock.setShopId(shiguGoodsSoldout.getStoreId());
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

    private ShiguGoodsSoldoutExample createExampleByBo(ShopForCdnBo shopForCdnBo) {
        ShiguGoodsSoldoutExample shiguGoodsSoldoutExample = new ShiguGoodsSoldoutExample();
        ShiguGoodsSoldoutExample.Criteria criteria = shiguGoodsSoldoutExample.createCriteria();
        // 排序设置
        if (StringUtils.isEmpty(shopForCdnBo.getOrderBy())) {
            // 默认时间排序
            shiguGoodsSoldoutExample.setOrderByClause("created desc");
        } else {
            if (StringUtils.equals(shopForCdnBo.getOrderBy(), "price-asc")) {
                shiguGoodsSoldoutExample.setOrderByClause("pi_price asc");
            }
            if (StringUtils.equals(shopForCdnBo.getOrderBy(), "price-desc")) {
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
        /*
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
        if (shopForCdnBo.getPriceFrom() != null) {
            criteria.andPiPriceGreaterThanOrEqualTo(((Double) (shopForCdnBo.getPriceFrom() * 100)).longValue());
        }
        if (shopForCdnBo.getPriceTo() != null) {
            criteria.andPiPriceLessThanOrEqualTo(((Double) (shopForCdnBo.getPriceTo() * 100)).longValue());
        }
        if (shopForCdnBo.getDateFrom() != null) {
            criteria.andCreatedGreaterThanOrEqualTo(shopForCdnBo.getDateFrom());
        }
        if (shopForCdnBo.getDateTo() != null) {
            criteria.andCreatedLessThanOrEqualTo(shopForCdnBo.getDateTo());
        }
        if (shopForCdnBo.getSoldDateFrom() != null) {
            criteria.andSoldoutTimeGreaterThanOrEqualTo(shopForCdnBo.getSoldDateFrom());
        }
        if (shopForCdnBo.getSoldDateTo() != null) {
            criteria.andSoldoutTimeLessThanOrEqualTo(shopForCdnBo.getSoldDateTo());
        }
        if (null != shopForCdnBo.getShopId()) {
            criteria.andStoreIdEqualTo(shopForCdnBo.getShopId());
        }
        if (null != shopForCdnBo.getScid() && StringUtils.isNotEmpty(shopForCdnBo.getScid())) {
            //先查一下是否父级
            Long scid = Long.parseLong(shopForCdnBo.getScid());
            String scidStr = selScidStr(shopForCdnBo.getShopId(),scid);
            criteria.andCidAllEqualTo(scidStr);
        }
        shiguGoodsSoldoutExample.setStartIndex(shopForCdnBo.getPageSize() * (shopForCdnBo.getPageNo() - 1));
        shiguGoodsSoldoutExample.setEndIndex(shopForCdnBo.getPageNo() * shopForCdnBo.getPageSize());
        shiguGoodsSoldoutExample.setWebSite("hz");
        return shiguGoodsSoldoutExample;
    }


    @Override
    public List<ItemShowBlock> shopGoodsNew(Long shopId) {
        if (shopId == null) {
            return Collections.EMPTY_LIST;
        }
        Cache goodsNewCache = cacheManager.getCache("shopGoodsNew");
        List<ItemShowBlock> goodsNewList = goodsNewCache.get(shopId, List.class);
        if (goodsNewList != null) {
            return goodsNewList;
        }
        ShiguShop shiguShop = shiguShopMapper.selectByPrimaryKey(shopId);
        if (shiguShop == null) {
            return Collections.EMPTY_LIST;
        }
        String webSite = shiguShop.getWebSite();
        goodsNewList = searchItemOnsale(null, shopId, webSite, "time_down", 1, 4).getContent();
        goodsNewCache.put(shopId,goodsNewList);
        return goodsNewList;
    }

    /**
     * 获取店内商品风格（风格频道）
     * @param shopId
     * @return
     */
    @Override
    public List<ShiguStyleShowVO> selShopStyleById(Long shopId) {
        if (shopId == null) {
            // 没有输入店铺id，直接返回不可修改的空list
            return Collections.EMPTY_LIST;
        }
        ShiguShopStyleRelation shiguShopStyleRelation = new ShiguShopStyleRelation();
        shiguShopStyleRelation.setShopId(shopId);
        shiguShopStyleRelation = shiguShopStyleRelationMapper.selectOne(shiguShopStyleRelation);
        if (shiguShopStyleRelation == null) {
            ShiguShop shiguShop = shiguShopMapper.selectByPrimaryKey(shopId);
            // 没查到对应的店铺，或店铺状态不是开店，直接返回
            if (shiguShop == null || !Objects.equals(0,shiguShop.getShopStatus())) {
                return Collections.EMPTY_LIST;
            }
            //是正常店铺，且在店铺风格索引表中还没有记录，添加记录
            shiguShopStyleRelation = new ShiguShopStyleRelation();
            shiguShopStyleRelation.setShopId(shopId);
            shiguShopStyleRelation.setWebSite(shiguShop.getWebSite());
            shiguShopStyleRelation.setShopParentStyleIds(",");
            shiguShopStyleRelationMapper.insertSelective(shiguShopStyleRelation);
            // 推送到redis，交给定时项目处理店铺内风格数据
            redisIO.rpush(SHOP_STYLE_HANDLER_QUEUE_INDEX,shopId);
        }
        //去掉头尾id区分标志用符号,
        String parentStyleIdsStr = shiguShopStyleRelation.getShopParentStyleIds().replaceFirst("^,", "").replaceAll(",$", "");
        // 没有设置过商品风格标签
        if (StringUtils.isBlank(parentStyleIdsStr)) {
            return Collections.EMPTY_LIST;
        }
        List<Long> parentStyleIdList = new ArrayList<>();
        for (String idStr : parentStyleIdsStr.split(",")) {
            parentStyleIdList.add(Long.parseLong(idStr));
        }
        if (parentStyleIdList.size() == 0) {
            return Collections.EMPTY_LIST;
        }
        ShiguStyleExample example = new ShiguStyleExample();
        // 目前只提供父级风格搜索
        example.createCriteria().andIdIn(parentStyleIdList).andIsParentEqualTo(1);
        List<ShiguStyle> shiguStyles = shiguStyleMapper.selectByExample(example);
        List<ShiguStyleShowVO> list = new ArrayList<>(shiguStyles.size());
        for (ShiguStyle shiguStyle : shiguStyles) {
            ShiguStyleShowVO styleShowVO = new ShiguStyleShowVO();
            styleShowVO.setSpid(shiguStyle.getId());
            styleShowVO.setName(shiguStyle.getStyleName());
            styleShowVO.setSort(shiguStyle.getSort());
            list.add(styleShowVO);
        }
        Collections.sort(list);
        return list;
    }
}
