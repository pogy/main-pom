package com.shigu.main4.cdn.services;

import com.opentae.core.mybatis.utils.FieldUtil;
import com.opentae.data.mall.beans.*;
import com.opentae.data.mall.examples.*;
import com.opentae.data.mall.interfaces.*;
import com.shigu.main4.cdn.vo.FloorVO;
import com.shigu.main4.cdn.vo.ShopInFloorVO;
import com.shigu.main4.cdn.vo.StyleChannelMarketVO;
import com.shigu.main4.cdn.vo.StyleGoodsInSearch;
import com.shigu.main4.goat.exceptions.GoatException;
import com.shigu.main4.goat.service.GoatDubboService;
import com.shigu.main4.goat.vo.ItemGoatVO;
import com.shigu.main4.storeservices.MarketShopService;
import com.shigu.main4.storeservices.ShopSearchService;
import com.shigu.main4.tools.RedisIO;
import com.shigu.main4.vo.FloorShow;
import com.shigu.main4.vo.MarketShow;
import com.shigu.main4.vo.SearchShopSimple;
import com.shigu.main4.vo.ShopShow;
import com.shigu.spread.services.ObjFromCache;
import com.shigu.spread.services.RedisForIndexPage;
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

    private static final Logger logger = LoggerFactory.getLogger(StyleChannelService.class)

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
                        market.setId(shiguOuterMarket.getRuleId());
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
     * @param parentStyleId
     * @return
     */
    public List<StyleGoodsInSearch> selStyleRecommendGoodsList(Long parentStyleId) {
        StyleSpreadChannelVO styleSpreadChannel = getStyleSpreadChannel(parentStyleId);
        if (styleSpreadChannel == null) {
            return new ArrayList<>();
        }
        return selStyleRecommendGoods(styleSpreadChannel).selObj();
    }

    /**
     * 查询推荐商品广告数据
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
                        goodsVo.setImgsrc(g.getPicUrl());
                        goodsVo.setPiprice(g.getPiPriceString());
                        goodsVo.setGoodsNo(g.getGoodsNo());
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
                } catch (GoatException e) {
                    logger.error("获取风格推荐广告商品数据异常", e);
                }
                return recommendList;
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
