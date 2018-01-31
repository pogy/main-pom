package com.shigu.main4.cdn.services;

import com.opentae.core.mybatis.utils.FieldUtil;
import com.opentae.data.mall.beans.*;
import com.opentae.data.mall.examples.*;
import com.opentae.data.mall.interfaces.*;
import com.opentae.data.mall.multibeans.GoodsStyleInfoBean;
import com.shigu.main4.cdn.bo.StyleChannelGoodsSearchBO;
import com.shigu.main4.cdn.vo.*;
import com.shigu.main4.common.tools.ShiguPager;
import com.shigu.main4.common.util.BeanMapper;
import com.shigu.main4.common.util.DateUtil;
import com.shigu.main4.goat.exceptions.GoatException;
import com.shigu.main4.goat.service.GoatDubboService;
import com.shigu.main4.goat.vo.ItemGoatVO;
import com.shigu.main4.item.bo.GoodsSearchBO;
import com.shigu.main4.item.enums.SearchCheckd;
import com.shigu.main4.item.enums.SearchOrderBy;
import com.shigu.main4.item.services.ItemSearchService;
import com.shigu.main4.item.vo.SearchItem;
import com.shigu.main4.item.vo.ShiguAggsPager;
import com.shigu.main4.storeservices.MarketShopService;
import com.shigu.main4.storeservices.ShopSearchService;
import com.shigu.main4.tools.RedisIO;
import com.shigu.main4.vo.FloorShow;
import com.shigu.main4.vo.MarketShow;
import com.shigu.main4.vo.SearchShopSimple;
import com.shigu.main4.vo.ShopShow;
import com.shigu.search.services.CategoryInSearchService;
import com.shigu.spread.enums.SpreadEnum;
import com.shigu.spread.services.ObjFromCache;
import com.shigu.spread.services.RedisForIndexPage;
import com.shigu.spread.services.SpreadService;
import com.shigu.spread.vo.ImgBannerVO;
import com.shigu.spread.vo.NewHzManIndexItemGoatVO;
import com.shigu.spread.vo.StyleSpreadChannelVO;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.*;
import java.util.stream.Collectors;

/**
 * 路径:com.shigu.main4.cdn.services.StyleChannelService
 * 工程:main-pom
 * 时间:18-1-26下午8:25
 * 创建人:wanghaoxiang
 * 描述：风格频道
 */
@Service
public class StyleChannelService {

    private static final Logger logger = LoggerFactory.getLogger(StyleChannelService.class);

    @Autowired
    private RedisIO redisIO;

    @Autowired
    private RedisForIndexPage redisForIndexPage;

    @Autowired
    private GoatDubboService goatDubboService;

    @Autowired
    private MarketShopService marketShopService;

    @Autowired
    private ShopSearchService shopSearchService;

    @Autowired
    private ItemSearchService itemSearchService;

    @Autowired
    private SpreadService spreadService;

    @Autowired
    private CategoryInSearchService categoryInSearchService;

    @Autowired
    private ShiguOuterFloorMapper shiguOuterFloorMapper;

    @Autowired
    private ShiguShopMapper shiguShopMapper;

    @Autowired
    private ShiguShopStyleRelationMapper shiguShopStyleRelationMapper;

    @Autowired
    private ShiguOuterMarketMapper shiguOuterMarketMapper;

    @Autowired
    private ShiguStyleMapper shiguStyleMapper;

    @Autowired
    private ShiguGoodsTinyMapper shiguGoodsTinyMapper;

    @Autowired
    private ShiguGoodsSoldoutMapper shiguGoodsSoldoutMapper;

    @Autowired
    private ShiguMarketMapper shiguMarketMapper;

    //市场店铺数据缓存
    private final String STYLE_MARKET_SHOP_CACHE_FORMAT = "cached_shops_for_market_%d_style_%d";

    private final String STYLE_MARKET_CACHE_FORMAT = "cached_market_for_website_%s_style_%d";

    private Map<Long, StyleSpreadChannelVO> styleSpreadMap;

    //初始化风格广告标签map
    @PostConstruct
    public void initStyleSpreadMap() {
        styleSpreadMap = new HashMap<>();
        ShiguStyleExample shiguStyleExample = new ShiguStyleExample();
        shiguStyleExample.createCriteria().andIsParentEqualTo(1);
        List<ShiguStyle> shiguStyles = shiguStyleMapper.selectByExample(shiguStyleExample);
        for (ShiguStyle shiguStyle : shiguStyles) {
            if (StringUtils.isNotBlank(shiguStyle.getTag())) {
                StyleSpreadChannelVO vo = new StyleSpreadChannelVO();
                vo.setStyleId(shiguStyle.getId());
                vo.setSpreadTag(shiguStyle.getTag());
                //vo.setWebSite("hz");
                styleSpreadMap.put(shiguStyle.getId(), vo);
            }
        }
    }

    /**
     * 风格频道商品列表
     *
     * @return
     */
    public ShiguPager<StyleGoodsInSearch> searchStyleGoods(StyleChannelGoodsSearchBO bo) {
        ShiguPager<StyleGoodsInSearch> pager = new ShiguPager<>();
        pager.setNumber(bo.getPage());
        //没有风格id，直接返回
        if (bo.getSpid() == null) {
            pager.setContent(new ArrayList<>());
            pager.calPages(0, 50);
            return pager;
        }
        GoodsSearchBO goodsSearchBO = new GoodsSearchBO();
        goodsSearchBO.setWebSite(bo.getWebSite());
        goodsSearchBO.setParentStyleId(bo.getSpid());
        goodsSearchBO.setKeyword(bo.getKeyword());
        goodsSearchBO.setMid(bo.getMid());
        goodsSearchBO.setPriceFrom(bo.getSp());
        goodsSearchBO.setPriceTo(bo.getEp());
        List<SearchCheckd> checkds = new ArrayList<>();
        if (Objects.equals(1, bo.getBpic())) {
            checkds.add(SearchCheckd.BIGZIP);
        }
        if (Objects.equals(1, bo.getGoodsVideo())) {
            checkds.add(SearchCheckd.VIDEO);
        }
        goodsSearchBO.setCheckds(checkds);
        List<Long> cids = new ArrayList<>();
        if (bo.getCid() != null) {
            cids.addAll(categoryInSearchService.selCidsFromCid(bo.getCid()));
        } else if (bo.getPid() != null) {
            cids.addAll(categoryInSearchService.selCidsFromCid(bo.getPid()));
        }
        if (cids.size() > 0) {
            goodsSearchBO.setCids(cids);
        }
        String sort = bo.getSort();
        if (sort == null) {
            sort = "style_channel";
        }
        Date timeFrom = null;
        Date timeTo = null;
        //查过去几天内的商品
        Integer days = bo.getD();
        if (days != null) {
            Calendar calendar = Calendar.getInstance();
            calendar.add(Calendar.DATE, -days);
            timeFrom = calendar.getTime();
        } else {
            //如果是用时间区间查询
            if (bo.getSt() != null) {
                timeFrom = DateUtil.stringToDate(bo.getSt(), "yyyy.MM.dd");
            }
            if (bo.getEt() != null) {
                timeTo = DateUtil.stringToDate(bo.getEt(), "yyyy.MM.dd");
            }
        }
        goodsSearchBO.setTimeForm(timeFrom);
        goodsSearchBO.setTimeTo(timeTo);

        SearchOrderBy searchOrderBy = SearchOrderBy.valueIs(sort);
        if (searchOrderBy == null) {
            searchOrderBy = SearchOrderBy.STYLE_CHANNEL;
        }
        goodsSearchBO.setOrderCase(searchOrderBy);
        goodsSearchBO.setPage(bo.getPage());
        goodsSearchBO.setPageSize(50);
        ShiguAggsPager shiguAggsPager = itemSearchService.searchItem(goodsSearchBO);
        pager.calPages(shiguAggsPager.getTotalCount(), 50);
        List<SearchItem> searchItems = shiguAggsPager.getContent();
        List<StyleGoodsInSearch> context = new ArrayList<>();
        pager.setContent(context);
        Set<Long> shopIds = searchItems.stream().filter(searchItem -> searchItem.getStoreId() != null).map(SearchItem::getStoreId).collect(Collectors.toSet());
        //查商品店铺信息
        Map<Long, SearchShopSimple> shopInfoMap = shopSearchService.selShopByIds(new ArrayList<>(shopIds), bo.getWebSite()).stream().collect(Collectors.toMap(SearchShopSimple::getShopId, o -> o));
        for (SearchItem source : searchItems) {
            StyleGoodsInSearch vo = new StyleGoodsInSearch();
            vo.setId(source.getItemId());
            vo.setTitle(source.getTitle());
            vo.setHighLightTitle(source.getHighLightTitle());
            vo.setGoodsNo(source.getGoodsNo());
            vo.setHighLightGoodsNo(source.getHighLightGoodsNo());
            vo.setImgsrc(source.getPicUrl());
            vo.setPiprice(source.getPrice());
            vo.setShopId(source.getStoreId());
            SearchShopSimple searchShopSimple = shopInfoMap.get(source.getStoreId());
            if (searchShopSimple != null) {
                vo.setAliww(searchShopSimple.getImAliww());
                vo.setFullStoreName(searchShopSimple.getMarket() + " " + searchShopSimple.getShopNum());
            }
            context.add(vo);
        }
        return pager;
    }


    /**
     * 获取市场中设置过风格的显示的档口列表
     *
     * @param outerMarketId
     * @param parentStyleId
     * @return
     */
    public List<FloorVO> selStyleMarketShows(Long outerMarketId, Long parentStyleId) {
        if (parentStyleId == null) {
            return new ArrayList<>();
        }
        //没有传市场id，查电商基地
        if (outerMarketId == null) {
            outerMarketId = 1L;
        }
        List<FloorVO> marketList = redisIO.getList(String.format(STYLE_MARKET_SHOP_CACHE_FORMAT, outerMarketId, parentStyleId), FloorVO.class);
        if (marketList != null) {
            return marketList;
        }
        MarketShow marketShow = marketShopService.selMarketShow(outerMarketId);
        if (marketShow == null) {
            return new ArrayList<>();
        }
        List<FloorShow> floors = marketShow.getFloors();
        List<Long> shopIds = floors.stream().filter(floorShow -> floorShow.getShops().size() > 0).flatMap(floorShow -> floorShow.getShops().stream().filter(Objects::nonNull).filter(shopShow -> shopShow.getShopId() != null).map(ShopShow::getShopId)).collect(Collectors.toList());
        marketList = new ArrayList<>();
        if (shopIds.size() > 0) {
            ShiguShopStyleRelationExample example = new ShiguShopStyleRelationExample();
            example.createCriteria().andShopIdIn(shopIds).andShopParentStyleIdsLike("%," + parentStyleId + ",%");
            Set<Long> styledShops = shiguShopStyleRelationMapper.selectByExample(example).stream().map(ShiguShopStyleRelation::getShopId).collect(Collectors.toSet());
            if (styledShops.size() > 0) {
                floors.forEach(floor -> floor.setShops(floor.getShops().stream().filter(shop -> shop.getShopId() != null && styledShops.contains(shop.getShopId())).collect(Collectors.toList())));
                long now = System.currentTimeMillis();
                for (FloorShow floor : floors) {
                    List<ShopShow> shops = floor.getShops();
                    if (shops != null && shops.size() > 0) {
                        List<ShopInFloorVO> shopInFloorVOS = shops.stream().map(shop -> {
                            ShopInFloorVO shopVO = new ShopInFloorVO();
                            shopVO.setId(shop.getShopId());
                            shopVO.setCate(shop.getSystemComment());
                            shopVO.setNum(shop.getShopNum());
                            if (shop.getCreateDate() != null && now - shop.getCreateDate().getTime() < 30 * 24 * 3600 * 1000) {
                                shopVO.setIsNew(1);
                            }
                            shopVO.setIsfdGoods(0);
                            shopVO.setTags(shop.getTags());
                            return shopVO;
                        }).collect(Collectors.toList());
                        FloorVO floorVO = new FloorVO();
                        floorVO.setStores(shopInFloorVOS);
                        floorVO.setTitle(floor.getShowName());
                        marketList.add(floorVO);
                    }
                }
            }
        }
        //缓存半小时
        redisIO.putTemp(String.format(STYLE_MARKET_SHOP_CACHE_FORMAT, outerMarketId, parentStyleId), marketList, 30 * 60);
        return marketList;
    }


    /**
     * 获取有店铺设置过商品风格的市场列表
     *
     * @param webSite
     * @param parentStyleId
     * @return
     */
    // TODO: 18-1-29 细节调整 执行顺序优化调整
    public List<StyleChannelMarketVO> selStyleMarkets(String webSite, Long parentStyleId) {
        if (parentStyleId == null) {
            return new ArrayList<>();
        }
        if (StringUtils.isBlank(webSite)) {
            webSite = "hz";
        }
        List<StyleChannelMarketVO> markets = redisIO.getList(String.format(STYLE_MARKET_CACHE_FORMAT, webSite, parentStyleId), StyleChannelMarketVO.class);
        if (markets != null) {
            return markets;
        }
        markets = new ArrayList<>();
        ShiguOuterMarketExample shiguOuterMarketExample = new ShiguOuterMarketExample();
        shiguOuterMarketExample.createCriteria().andWebSiteEqualTo(webSite);
        List<ShiguOuterMarket> shiguOuterMarkets = shiguOuterMarketMapper.selectByExample(shiguOuterMarketExample);
        Map<Long, Set<Long>> marketFloorMap = new HashMap<>();
        for (ShiguOuterMarket shiguOuterMarket : shiguOuterMarkets) {
            String outerFloorIdsStr = shiguOuterMarket.getOuterFloorIds();
            if (StringUtils.isNotBlank(outerFloorIdsStr)) {
                marketFloorMap.put(shiguOuterMarket.getRuleId(), Arrays.stream(outerFloorIdsStr.split(",")).map(Long::parseLong).collect(Collectors.toSet()));
            }
        }
        Map<Long, Set<Long>> outFloorShopMap = new HashMap<>();
        Set<Long> allFloor = marketFloorMap.values().stream().flatMap(Collection::stream).collect(Collectors.toSet());
        if (allFloor != null && allFloor.size() > 0) {
            ShiguOuterFloorExample shiguOuterFloorExample = new ShiguOuterFloorExample();
            shiguOuterFloorExample.createCriteria().andOuterFloorIdIn(new ArrayList<>(allFloor));
            List<ShiguOuterFloor> shiguOuterFloors = shiguOuterFloorMapper.selectByExample(shiguOuterFloorExample);
            if (shiguOuterFloors.size() > 0) {
                Map<Long, Set<Long>> floorAddedShopMap = new HashMap<>();
                Map<Long, Set<Long>> floorSubMarketMap = new HashMap<>();
                shiguOuterFloors.forEach(o -> {
                    if (StringUtils.isNotBlank(o.getAddedShop())) {
                        Set<Long> addShopIds = Arrays.stream(o.getAddedShop().split(";")).map(shopInfos -> Long.parseLong(shopInfos.split(",")[0])).collect(Collectors.toSet());
                        if (addShopIds.size() > 0) {
                            floorAddedShopMap.put(o.getOuterFloorId(), addShopIds);
                        }
                    }
                    Set<Long> floorIds = Arrays.stream(o.getFloorIds().split(",")).filter(StringUtils::isNotBlank).map(Long::parseLong).collect(Collectors.toSet());
                    floorSubMarketMap.put(o.getOuterFloorId(), floorIds);
                });
                List<Long> subMarketIds = floorSubMarketMap.values().stream().flatMap(Collection::stream).collect(Collectors.toList());
                ShiguShopExample shopExample = new ShiguShopExample();
                //查询所有子级市场可显示的店铺
                ShiguShopExample.Criteria criteria = shopExample.createCriteria().andFloorIdIn(subMarketIds).andShopStatusEqualTo(0).andDisplayInMarketEqualTo(1);
                if (floorAddedShopMap.size() > 0) {
                    List<Long> addShopIds = floorAddedShopMap.values().stream().flatMap(Collection::stream).collect(Collectors.toList());
                    criteria.or().andShopIdIn(addShopIds).andShopStatusEqualTo(0).andDisplayInMarketEqualTo(1);
                }
                List<ShiguShop> shiguShops = shiguShopMapper.selectFieldsByExample(shopExample, FieldUtil.codeFields("shop_id,floor_id"));
                Set<Long> allShowShopIdsInMarket = shiguShops.stream().map(ShiguShop::getShopId).collect(Collectors.toSet());
                Set<Long> showShopIds = new HashSet<>();
                if (allShowShopIdsInMarket.size() > 0) {
                    ShiguShopStyleRelationExample shiguShopStyleRelationExample = new ShiguShopStyleRelationExample();
                    shiguShopStyleRelationExample.createCriteria().andShopIdIn(new ArrayList<>(allShowShopIdsInMarket)).andShopParentStyleIdsLike("%," + parentStyleId + ",%");
                    List<ShiguShopStyleRelation> shopStyleRelations = shiguShopStyleRelationMapper.selectByExample(shiguShopStyleRelationExample);
                    showShopIds.addAll(shopStyleRelations.stream().map(ShiguShopStyleRelation::getShopId).collect(Collectors.toSet()));
                }
                Map<Long, Set<Long>> subMarketShopIdMap = shiguShops.stream().collect(Collectors.groupingBy(ShiguShop::getFloorId, Collectors.mapping(ShiguShop::getShopId, Collectors.toSet())));
                for (ShiguOuterFloor shiguOuterFloor : shiguOuterFloors) {
                    Set<Long> floorShopIds = new HashSet<>();
                    Long outerFloorId = shiguOuterFloor.getOuterFloorId();
                    floorSubMarketMap.get(outerFloorId).forEach(floorId -> {
                        Set<Long> floorShops = subMarketShopIdMap.get(floorId);
                        if (floorShops != null && floorShops.size() > 0) {
                            floorShops.retainAll(showShopIds);
                            floorShopIds.addAll(floorShops);
                        }
                    });
                    Set<Long> addedShops = floorAddedShopMap.get(outerFloorId);
                    if (addedShops != null && addedShops.size() > 0) {
                        addedShops.retainAll(showShopIds);
                        floorShopIds.addAll(addedShops);
                    }
                    outFloorShopMap.put(outerFloorId, floorShopIds);
                }
            }
        }
        for (ShiguOuterMarket shiguOuterMarket : shiguOuterMarkets) {
            Set<Long> outerFloorIds = marketFloorMap.get(shiguOuterMarket.getRuleId());
            if (outerFloorIds != null && outerFloorIds.size() > 0) {
                for (Long outerFloorId : outerFloorIds) {
                    Set<Long> outFloorShopIds = outFloorShopMap.get(outerFloorId);
                    //市场内有楼层有设置了风格的店铺，添加显示
                    if (outFloorShopIds != null && outFloorShopIds.size() > 0) {
                        StyleChannelMarketVO market = new StyleChannelMarketVO();
                        market.setMid(shiguOuterMarket.getRuleId());
                        market.setName(shiguOuterMarket.getMarketName());
                        markets.add(market);
                        break;
                    }
                }
            }
        }
        //缓存3小时
        redisIO.putTemp(String.format(STYLE_MARKET_CACHE_FORMAT, webSite, parentStyleId), markets, 60 * 60 * 3);
        return markets;
    }

    /**
     * 获取推荐商品广告数据列表
     *
     * @param parentStyleId
     * @return
     */
    public List<StyleGoodsInSearch> selStyleRecommendGoodsList(Long parentStyleId) {
        StyleSpreadChannelVO styleSpreadChannel = getStyleSpreadChannel(parentStyleId);
        if (styleSpreadChannel == null) {
            return new ArrayList<>();
        }
        List<StyleGoodsInSearch> recommend = selStyleRecommendGoods(styleSpreadChannel).selObj();
        Collections.shuffle(recommend);
        return recommend;
    }

    /**
     * 查询推荐商品广告数据
     *
     * @param vo
     * @return
     */
    public ObjFromCache<List<StyleGoodsInSearch>> selStyleRecommendGoods(StyleSpreadChannelVO vo) {
        return new ObjFromCache<List<StyleGoodsInSearch>>(redisForIndexPage, vo.recommendTag(), StyleGoodsInSearch.class) {
            @Override
            public List<StyleGoodsInSearch> selReal() {
                //广告标记
                String localCode = vo.recommendTag();
                //错误的标签，直接返回
                if (StyleSpreadChannelVO.ERROR_TAG.equals(localCode)) {
                    return new ArrayList<>();
                }
                List<StyleGoodsInSearch> recommendList = new ArrayList<>();
                try {
                    List<ItemGoatVO> goatVOS = goatDubboService.selGoatsFromLocalCode(localCode);
                    //广告商品id集合
                    List<Long> goodsIds = goatVOS.stream().filter(itemGoatVO -> null != itemGoatVO.getItemId()).map(ItemGoatVO::getItemId).collect(Collectors.toList());
                    if (goodsIds.size() > 0) {
                        ShiguGoodsTinyExample shiguGoodsTinyExample = new ShiguGoodsTinyExample();
                        shiguGoodsTinyExample.setWebSite(vo.getWebSite());
                        shiguGoodsTinyExample.createCriteria().andGoodsIdIn(goodsIds);
                        //做广告的商品id
                        List<ShiguGoodsTiny> goatGoods = shiguGoodsTinyMapper.selectFieldsByExample(shiguGoodsTinyExample, FieldUtil.codeFields("goods_id,title,pic_url,goods_no,store_id"));
                        Set<Long> shopIds = goatGoods.stream().filter(shiguGoodsTiny -> shiguGoodsTiny.getStoreId() != null).map(ShiguGoodsTiny::getStoreId).collect(Collectors.toSet());
                        Map<Long, SearchShopSimple> shopMap = shopSearchService.selShopByIds(new ArrayList<>(shopIds), vo.getWebSite()).stream().filter(searchShopSimple -> searchShopSimple.getShopId() != null).collect(Collectors.toMap(SearchShopSimple::getShopId, o -> o));
                        recommendList = goatGoods.stream().map(g -> {
                            StyleGoodsInSearch goodsVo = new StyleGoodsInSearch();
                            goodsVo.setId(g.getGoodsId());
                            goodsVo.setTitle(g.getTitle());
                            goodsVo.setHighLightTitle(g.getTitle());
                            goodsVo.setImgsrc(g.getPicUrl());
                            goodsVo.setPiprice(String.format("%.2f", g.getPiPrice() * 0.01));
                            String goodsNo = g.getGoodsNo();
                            //配合前端需求，只有goodsNo存在时才输出
                            if (StringUtils.isNotBlank(goodsNo)) {
                                goodsVo.setGoodsNo(goodsNo);
                                goodsVo.setHighLightGoodsNo(goodsNo);
                            }
                            goodsVo.setShopId(g.getStoreId());
                            SearchShopSimple searchShopSimple = shopMap.get(g.getStoreId());
                            if (searchShopSimple != null) {
                                goodsVo.setAliww(searchShopSimple.getImAliww());
                                goodsVo.setFullStoreName(searchShopSimple.getMarket() + " " + searchShopSimple.getShopNum());
                            }
                            //这里没用到
                            goodsVo.setHighLightGoodsNo("");
                            goodsVo.setHighLightTitle("");
                            return goodsVo;
                        }).collect(Collectors.toList());
                    }
                } catch (GoatException e) {
                    logger.error("获取风格推荐广告商品数据异常" + vo.recommendTag(), e);
                }
                return recommendList;
            }
        };
    }

    /**
     * 风格频道首页热销广告列表
     *
     * @return
     */
    public List<NewHzManIndexItemGoatVO> selStyleHotStyleList(Long parentStyleId) {
        StyleSpreadChannelVO styleSpreadChannel = getStyleSpreadChannel(parentStyleId);
        if (styleSpreadChannel == null) {
            return new ArrayList<>();
        }
        List<NewHzManIndexItemGoatVO> hotSale = selStyleHotStyleGoods(styleSpreadChannel).selObj();
        Collections.shuffle(hotSale);
        return hotSale;
    }

    /**
     * 风格频道首页热销商品数据
     *
     * @param vo
     * @return
     */
    public ObjFromCache<List<NewHzManIndexItemGoatVO>> selStyleHotStyleGoods(StyleSpreadChannelVO vo) {
        return new ObjFromCache<List<NewHzManIndexItemGoatVO>>(redisForIndexPage, vo.hotStyleTag(), NewHzManIndexItemGoatVO.class) {
            @Override
            public List<NewHzManIndexItemGoatVO> selReal() {
                if (StyleSpreadChannelVO.ERROR_TAG.equals(vo.hotStyleTag())) {
                    return new ArrayList<>();
                }
                List<NewHzManIndexItemGoatVO> list = new ArrayList<>();
                try {
                    List<ItemGoatVO> goatVOS = goatDubboService.selGoatsFromLocalCode(vo.hotStyleTag());
                    Set<Long> goodsIds = goatVOS.stream().filter(itemGoatVO -> itemGoatVO.getItemId() != null).map(ItemGoatVO::getItemId).collect(Collectors.toSet());
                    if (goodsIds.size() > 0) {
                        ShiguGoodsTinyExample shiguGoodsTinyExample = new ShiguGoodsTinyExample();
                        shiguGoodsTinyExample.setWebSite(vo.getWebSite());
                        shiguGoodsTinyExample.createCriteria().andGoodsIdIn(new ArrayList<>(goodsIds));
                        List<ShiguGoodsTiny> shiguGoodsTinies = shiguGoodsTinyMapper.selectFieldsByExample(shiguGoodsTinyExample, FieldUtil.codeFields("goods_id,pic_url,pi_price_string,store_id"));
                        Map<Long, ShiguGoodsTiny> goodsTinyMap = shiguGoodsTinies.stream().collect(Collectors.toMap(ShiguGoodsTiny::getGoodsId, o -> o));
                        Set<Long> shopIds = shiguGoodsTinies.stream().map(ShiguGoodsTiny::getStoreId).collect(Collectors.toSet());
                        Map<Long, SearchShopSimple> shopInfoMap = shopSearchService.selShopByIds(new ArrayList<>(shopIds), vo.getWebSite()).stream().collect(Collectors.toMap(SearchShopSimple::getShopId, o -> o));
                        for (ItemGoatVO goatVO : goatVOS) {
                            if (goatVO.getItemId() != null) {
                                ShiguGoodsTiny shiguGoodsTiny = goodsTinyMap.get(goatVO.getItemId());
                                if (shiguGoodsTiny != null) {
                                    NewHzManIndexItemGoatVO goods = new NewHzManIndexItemGoatVO();
                                    goods.setId(shiguGoodsTiny.getGoodsId().toString());
                                    goods.setImgSrc(shiguGoodsTiny.getPicUrl());
                                    goods.setPiprice(shiguGoodsTiny.getPiPriceString());
                                    goods.setShopId(shiguGoodsTiny.getStoreId().toString());
                                    SearchShopSimple searchShopSimple = shopInfoMap.get(shiguGoodsTiny.getStoreId());
                                    if (searchShopSimple != null) {
                                        goods.setShopNo(searchShopSimple.getShopNum());
                                        goods.setMarketName(searchShopSimple.getMarket());
                                    }
                                    list.add(goods);
                                }
                            }

                        }
                    }

                } catch (GoatException e) {
                    logger.error("获取风格热销数据失败" + vo.hotStyleTag(), e);
                }
                return list;
            }
        };
    }

    /**
     * 获取风格频道首页轮播大图
     *
     * @param parentStyleId
     * @return
     */
    public List<ImgBannerVO> selStyleIndexBanner(Long parentStyleId) {
        StyleSpreadChannelVO channel = getStyleSpreadChannel(parentStyleId);
        if (channel == null) {
            return new ArrayList<>();
        }
        SpreadEnum spreadEnum = SpreadEnum.getSpreadEnumByCode(channel.bannerTag());
        if (spreadEnum == null) {
            return new ArrayList<>();
        }
        return spreadService.selImgBanners(spreadEnum).selObj();
    }

    public List<StyleSpreadShopVO> selSpreadShop(Long parentStyleId) {
        StyleSpreadChannelVO channel = getStyleSpreadChannel(parentStyleId);
        if (channel == null) {
            return new ArrayList<>();
        }
        List<StyleSpreadShopVO> shops = selSpreadShop(channel).selObj();
        Collections.shuffle(shops);
        return shops;
    }

    public ObjFromCache<List<StyleSpreadShopVO>> selSpreadShop(StyleSpreadChannelVO vo) {
        return new ObjFromCache<List<StyleSpreadShopVO>>(redisForIndexPage, vo.goatShopTag(), StyleSpreadShopVO.class) {
            @Override
            public List<StyleSpreadShopVO> selReal() {
                if (StyleSpreadChannelVO.ERROR_TAG.equals(vo.goatShopTag())) {
                    return new ArrayList<>();
                }
                //一个店铺中的广告商品的数量
                int shopGoodsSize = 2;
                List<StyleSpreadShopVO> vos = new ArrayList<>();
                try {
                    //因为是公司运营添加的广告商品，所以没有对商品实际风格进行限制
                    List<ItemGoatVO> goatVOS = goatDubboService.selGoatsFromLocalCode(vo.goatShopTag());
                    Set<Long> goodsIds = goatVOS.stream().filter(itemGoatVO -> null != itemGoatVO.getItemId()).map(ItemGoatVO::getItemId).collect(Collectors.toSet());
                    List<Long> goodsIdsList = new ArrayList<>(goodsIds);
                    if (goodsIds.size() > 0) {
                        ShiguGoodsTinyExample shiguGoodsTinyExample = new ShiguGoodsTinyExample();
                        shiguGoodsTinyExample.setWebSite(vo.getWebSite());
                        shiguGoodsTinyExample.createCriteria().andGoodsIdIn(goodsIdsList);
                        List<ShiguGoodsTiny> shiguGoodsTinies = shiguGoodsTinyMapper.selectFieldsByExample(shiguGoodsTinyExample, FieldUtil.codeFields("goods_id,pic_url,store_id"));
                        HashMap<Long, List<StyleSpreadShopGoodsVO>> shopGoodsMap = new HashMap<>();
                        for (ShiguGoodsTiny shiguGoodsTiny : shiguGoodsTinies) {
                            List<StyleSpreadShopGoodsVO> styleSpreadShopGoodsVOS = shopGoodsMap.get(shiguGoodsTiny.getStoreId());
                            if (styleSpreadShopGoodsVOS == null) {
                                styleSpreadShopGoodsVOS = new ArrayList<>();
                                shopGoodsMap.put(shiguGoodsTiny.getStoreId(), styleSpreadShopGoodsVOS);
                            }
                            StyleSpreadShopGoodsVO goodsVO = new StyleSpreadShopGoodsVO();
                            goodsVO.setGoodsId(shiguGoodsTiny.getGoodsId());
                            goodsVO.setImgsrc(shiguGoodsTiny.getPicUrl());
                            styleSpreadShopGoodsVOS.add(goodsVO);
                        }
                        Set<Long> shopIds = new HashSet<>(shopGoodsMap.keySet());
                        if (shiguGoodsTinies.size() < goodsIds.size()) {
                            //有商品下架了
                            ShiguGoodsSoldoutExample shiguGoodsSoldoutExample = new ShiguGoodsSoldoutExample();
                            shiguGoodsSoldoutExample.setWebSite(vo.getWebSite());
                            shiguGoodsSoldoutExample.createCriteria().andGoodsIdIn(goodsIdsList);
                            List<ShiguGoodsSoldout> shiguGoodsSoldouts = shiguGoodsSoldoutMapper.selectFieldsByExample(shiguGoodsSoldoutExample, FieldUtil.codeFields("store_id"));
                            shopIds.addAll(shiguGoodsSoldouts.stream().filter(shiguGoodsSoldout -> shiguGoodsSoldout.getStoreId() != null).map(ShiguGoodsSoldout::getStoreId).collect(Collectors.toList()));
                        }
                        for (Long shopId : shopIds) {
                            List<StyleSpreadShopGoodsVO> shopGoodsInfos = shopGoodsMap.get(shopId);
                            if (shopGoodsInfos == null) {
                                shopGoodsInfos = new ArrayList<>();
                                shopGoodsMap.put(shopId, shopGoodsInfos);
                            }
                            int goodsSize = shopGoodsInfos.size();
                            if (goodsSize > shopGoodsSize) {
                                shopGoodsInfos = new ArrayList<>(shopGoodsInfos.subList(0, shopGoodsSize));
                                shopGoodsMap.put(shopId, shopGoodsInfos);
                            }
                            if (goodsSize < shopGoodsSize) {
                                //有商品下架了或商品个数不足，从对应店铺获取对应风格商品数据填充，正常维护数据时不会进入这部分流程
                                List<Long> existedGoodsIds = BeanMapper.getFieldList(shopGoodsInfos, "goodsId", Long.class);
                                List<GoodsStyleInfoBean> goodsStyleInfoBeans = shiguGoodsTinyMapper.selShopStyleGoods(vo.getWebSite(), shopId, vo.getStyleId(), existedGoodsIds, 0, shopGoodsSize - goodsSize);
                                for (GoodsStyleInfoBean goodsStyleInfoBean : goodsStyleInfoBeans) {
                                    StyleSpreadShopGoodsVO goodsVO = new StyleSpreadShopGoodsVO();
                                    goodsVO.setGoodsId(goodsStyleInfoBean.getGoodsId());
                                    goodsVO.setImgsrc(goodsStyleInfoBean.getImgsrc());
                                    shopGoodsInfos.add(goodsVO);
                                }
                            }
                        }
                        //开店的档口
                        if (shopIds.size() > 0) {
                            ShiguShopExample shiguShopExample = new ShiguShopExample();
                            shiguShopExample.createCriteria().andShopIdIn(new ArrayList<>(shopIds)).andShopStatusEqualTo(0);
                            List<ShiguShop> shiguShops = shiguShopMapper.selectFieldsByExample(shiguShopExample, FieldUtil.codeFields("shop_id,market_id,shop_num,create_date"));
                            Map<Long, String> marketIdNameMap = new HashMap<>();
                            Set<Long> marketIds = shiguShops.stream().filter(shiguShop -> shiguShop.getMarketId() != null).map(ShiguShop::getMarketId).collect(Collectors.toSet());
                            if (marketIds.size() > 0) {
                                ShiguMarketExample shiguMarketExample = new ShiguMarketExample();
                                shiguMarketExample.createCriteria().andMarketIdIn(new ArrayList<>(marketIds));
                                marketIdNameMap.putAll(shiguMarketMapper.selectFieldsByExample(shiguMarketExample, FieldUtil.codeFields("market_id,market_name")).stream().collect(Collectors.toMap(ShiguMarket::getMarketId, ShiguMarket::getMarketName)));
                            }
                            for (ShiguShop shiguShop : shiguShops) {
                                Long shopId = shiguShop.getShopId();
                                StyleSpreadShopVO shopVO = new StyleSpreadShopVO();
                                shopVO.setShopId(shopId);
                                String marketName = marketIdNameMap.get(shiguShop.getMarketId());
                                shopVO.setShopName((marketName == null ? "" : marketName) + shiguShop.getShopNum());
                                Calendar calendar = Calendar.getInstance();
                                int curYear = calendar.get(Calendar.YEAR);
                                int curMonth = calendar.get(Calendar.MONTH);
                                Date createDate = shiguShop.getCreateDate();
                                calendar.setTime(createDate);
                                int createYear = calendar.get(Calendar.YEAR);
                                int createMonth = calendar.get(Calendar.MONTH);
                                shopVO.setShopAge((curYear - createYear) + (curMonth - createMonth <= 0 ? 0 : 1));
                                shopVO.setGoodsList(shopGoodsMap.get(shopId));
                                vos.add(shopVO);
                            }
                        }
                    }
                } catch (GoatException e) {
                    logger.error("获取风格频道首页档口数据失败" + vo.goatShopTag(), e);
                }
                return vos;
            }
        };
    }

    private StyleSpreadChannelVO getStyleSpreadChannel(Long parentStyleId) {
        if (parentStyleId == null) {
            return null;
        }
        return styleSpreadMap.get(parentStyleId);
    }
}
