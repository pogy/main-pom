package com.shigu.main4.storeservices.impl;

import com.opentae.core.mybatis.utils.FieldUtil;
import com.opentae.data.mall.beans.ShiguMarket;
import com.opentae.data.mall.beans.ShiguOuterFloor;
import com.opentae.data.mall.beans.ShiguOuterMarket;
import com.opentae.data.mall.beans.ShiguShop;
import com.opentae.data.mall.examples.ShiguMarketExample;
import com.opentae.data.mall.examples.ShiguOuterMarketExample;
import com.opentae.data.mall.interfaces.ShiguMarketMapper;
import com.opentae.data.mall.interfaces.ShiguOuterFloorMapper;
import com.opentae.data.mall.interfaces.ShiguOuterMarketMapper;
import com.opentae.data.mall.interfaces.ShiguShopLicenseMapper;
import com.opentae.data.mall.interfaces.ShiguShopMapper;
import com.shigu.main4.common.util.BeanMapper;
import com.shigu.main4.storeservices.MarketShopService;
import com.shigu.main4.storeservices.vo.HzMarketShopListComparator;
import com.shigu.main4.storeservices.vo.MarketShopListComparator;
import com.shigu.main4.vo.FloorShow;
import com.shigu.main4.vo.MarketNavShow;
import com.shigu.main4.vo.MarketShow;
import com.shigu.main4.vo.ShopShow;
import org.apache.commons.lang3.StringUtils;
import org.springframework.cache.Cache;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;


/**
 * 市场内档口数据查询
 *
 * @author shigu_zjb
 * @date 2017/02/27 18:35
 */
@Service("marketShopService")
public class MarketShopServiceImpl extends ShopServiceImpl implements MarketShopService {

    @Resource(name = "tae_mall_shiguShopMapper")
    private ShiguShopMapper shiguShopMapper;

    @Resource(name = "tae_mall_shiguOuterMarketMapper")
    private ShiguOuterMarketMapper shiguOuterMarketMapper;

    @Resource(name = "tae_mall_shiguOuterFloorMapper")
    private ShiguOuterFloorMapper shiguOuterFloorMapper;

    @Resource(name = "tae_mall_shiguMarketMapper")
    private ShiguMarketMapper shiguMarketMapper;

    @Resource(name = "tae_mall_shiguShopLicenseMapper")
    private ShiguShopLicenseMapper shiguShopLicenseMapper;


    /**
     * 按市场ID,查本市场信息
     *
     * @param outerMarketId
     * @return
     */
    @Override
    public MarketShow selMarketShow(Long outerMarketId) {
        if (outerMarketId == null) {
            return null;
        }
        // 市场信息
        ShiguOuterMarket shiguOuterMarket = new ShiguOuterMarket();
        shiguOuterMarket.setRuleId(outerMarketId);
        shiguOuterMarket = shiguOuterMarketMapper.selectOne(shiguOuterMarket);
        if (shiguOuterMarket == null) {
            return null;
        }

        MarketShow marketShowTop = new MarketShow();
        marketShowTop.setMarketId(shiguOuterMarket.getMarketId());
        marketShowTop.setMarketOuterId(shiguOuterMarket.getRuleId());
        marketShowTop.setWebSite(shiguOuterMarket.getWebSite());
        if (shiguOuterMarket.getMarketId() != null) {
            ShiguMarket shiguMarketNow = shiguMarketMapper.selectByPrimaryKey(shiguOuterMarket.getMarketId());
            if (shiguMarketNow != null) {
                marketShowTop.setPingying(shiguMarketNow.getMarketPingyin());
                marketShowTop.setMarketName(shiguMarketNow.getMarketName());
            }
        }

        // 市场列表
        List<MarketShow> marketShowList = new ArrayList<MarketShow>();
        ShiguOuterMarketExample outerMarketExample = new ShiguOuterMarketExample();
        outerMarketExample.createCriteria().andWebSiteEqualTo(shiguOuterMarket.getWebSite()).andMarkerShowEqualTo(1);
        outerMarketExample.setOrderByClause("sort_order asc");
        List<ShiguOuterMarket> outerMarketList = shiguOuterMarketMapper.selectByExample(outerMarketExample);
        Map<Long, MarketShow> marketShowMap = new HashMap<>(outerMarketList.size());
        List<Long> marketIds = new ArrayList<>(outerMarketList.size());
        for (ShiguOuterMarket outerMarket : outerMarketList) {
            MarketShow marketShow = new MarketShow();
            marketShow.setMarketName(outerMarket.getMarketName());
            marketShow.setMarketOuterId(outerMarket.getRuleId());
            marketShow.setMarketId(outerMarket.getMarketId());
            marketShow.setWebSite(outerMarket.getWebSite());
            if (outerMarket.getMarketId() != null) {
                marketIds.add(outerMarket.getMarketId());
                marketShowMap.put(outerMarket.getMarketId(),marketShow);
            }
            marketShowList.add(marketShow);
        }
        if (marketIds.size()>0) {
            ShiguMarketExample shiguMarketExample = new ShiguMarketExample();
            shiguMarketExample.createCriteria().andMarketIdIn(marketIds);
            for (ShiguMarket shiguMarket : shiguMarketMapper.selectByExample(shiguMarketExample)) {
                MarketShow marketShow = marketShowMap.get(shiguMarket.getMarketId());
                marketShow.setPingying(shiguMarket.getMarketPingyin());
            }
        }
        marketIds = null;
        marketShowMap = null;
        marketShowTop.setOtherMarkets(marketShowList);

        // 楼层IDS
        String outerFloorIds = shiguOuterMarket.getOuterFloorIds();
        if (StringUtils.isEmpty(outerFloorIds)) {
            return null;
        }
        String[] outerFloorStrIds = outerFloorIds.split(",");
        // 楼层数据
        List<FloorShow> floorShowList = new ArrayList<FloorShow>();
        List<ShiguOuterFloor> shiguOuterFloorList = shiguOuterFloorMapper.selFloorListByIds(outerFloorStrIds);
        for (int i = 0; i < shiguOuterFloorList.size(); i++) {
            ShiguOuterFloor shiguOuterFloor = shiguOuterFloorList.get(i);
            FloorShow floorShow = selFloorShow(shiguOuterFloor.getOuterFloorId());
            floorShowList.add(floorShow);
        }
        marketShowTop.setFloors(floorShowList);
        return marketShowTop;
    }

    // TODO: 18-1-10 效率优化
    /**
     * 按外部楼层ID查一层的数据
     *
     * @param outerFloor
     * @return
     */
    @Override
    public FloorShow selFloorShow(Long outerFloor) {
        // 查询缓存
        Cache cache = cacheManager.getCache("floorCache");
        FloorShow floorShowCache = cache.get(outerFloor, FloorShow.class);
        if (floorShowCache != null) {
            return floorShowCache;
        }
        ShiguOuterFloor shiguOuterFloor = shiguOuterFloorMapper.selectByPrimaryKey(outerFloor);
        if (shiguOuterFloor == null) {
            return null;
        }
        List<ShopShow> shopShowList = new ArrayList<ShopShow>();
        if (StringUtils.isEmpty(shiguOuterFloor.getFloorIds())) {
            return null;
        }
        String[] floorIds = shiguOuterFloor.getFloorIds().split(",");
        FloorShow floorShow = new FloorShow();
        floorShow.setFloorIds(shiguOuterFloor.getFloorIds());
        floorShow.setOuterFloorId(outerFloor);
        floorShow.setShowName(shiguOuterFloor.getShowName());
        floorShow.setOtherName(shiguOuterFloor.getOtherName());
        String webSite=null;
        for (String floorIdStr : floorIds) {
            Long floorId = Long.valueOf(floorIdStr);
            List<ShiguShop> shiguShopList = new ArrayList<ShiguShop>();
            if (floorId != -1) {
                shiguShopList = findOpenShopListByFloorIds(floorId);
            }
            for (ShiguShop shiguShop : shiguShopList) {
                if(webSite==null){
                    webSite=shiguShop.getWebSite();
                }
                ShopShow shopShow = new ShopShow();
                shopShow.setFloorId(shiguShop.getFloorId());
                String context = shiguShop.getShopTagsContexts();
                shopShow.setTags(selTags(context));
                shopShow.setShopName(shiguShop.getShopName());
                shopShow.setShopNum(shiguShop.getShopNum());
                shopShow.setMainBus(shiguShop.getMainBus());
                shopShow.setShopId(shiguShop.getShopId());
                shopShow.setSystemComment(shiguShop.getSystemRecommon());
                shopShow.setSortOrderKey(shiguShop.getSortOrderKey());
                shopShow.setCreateDate(shiguShop.getCreateDate());
                shopShowList.add(shopShow);
            }
            String addedShops = shiguOuterFloor.getAddedShop();
            if (!StringUtils.isEmpty(addedShops)) {
                List<Long> shopIdList = new ArrayList<Long>();
                String[] shops = addedShops.split(";");
                Map<Long, ShopShow> map = new HashMap<>();
                Map<Long,Integer> isSort=new HashMap<>();
                for (String shop : shops) {
                    String[] shopInfos = shop.split(",");
                    ShopShow shopShow = new ShopShow();
                    if (!StringUtils.isEmpty(shopInfos[0])) {
                        shopShow.setShopId(Long.valueOf(shopInfos[0]));
                        shopIdList.add(shopShow.getShopId());
                    }
                    if (shopInfos.length >= 4) {
                        shopShow.setSystemComment(shopInfos[3]);
                    }
                    if (shopInfos.length >= 2) {
                        shopShow.setShopNum(shopInfos[1]);
                        shopShow.setSortOrderKey(shopInfos[1]);
                        isSort.put(shopShow.getShopId(),1);
                    }
                    if (shopInfos.length >= 3) {
                        shopShow.setShopName(shopInfos[2]);
                    }
                    shopShowList.add(shopShow);
                    map.put(shopShow.getShopId(), shopShow);
                }

                List<ShiguShop> shopList = shiguShopMapper.selectShopListByShopIdsForMarketList(shopIdList);
                for (ShiguShop shiguShop : shopList) {
                    ShopShow s = map.get(shiguShop.getShopId());
                    if (s == null || shiguShop.getShopStatus() != 0 || shiguShop.getDisplayInMarket() != 1) {
                        continue;
                    }
                    String context = shiguShop.getShopTagsContexts();
                    s.setTags(selTags(context));
                    s.setFloorId(shiguShop.getFloorId());
                    if(isSort.get(shiguShop.getShopId())==null){
                        s.setSortOrderKey(shiguShop.getSortOrderKey());
                    }else{
                        s.setFloorId(floorId!=-1?floorId:shiguShop.getFloorId());
                    }
                    if (!StringUtils.isEmpty(shiguShop.getSystemRecommon())) {
                        s.setSystemComment(shiguShop.getSystemRecommon());
                    }
                    s.setCreateDate(shiguShop.getCreateDate());
                    s.setMainBus(shiguShop.getMainBus());
                }
            }
        }
        //查出真实楼层排序用
        if(shopShowList.size()>0){
            Set<Long> floorIdSet=new HashSet<>(BeanMapper.getFieldList(shopShowList,"floorId",Long.TYPE));
            if(floorIdSet.size()>0){
                List<Long> floorIdlist=new ArrayList<>(floorIdSet);
                ShiguMarketExample example=new ShiguMarketExample();
                example.createCriteria().andMarketIdIn(floorIdlist);
                List<ShiguMarket> markets=shiguMarketMapper.selectFieldsByExample(example, FieldUtil.codeFields("market_id,market_name"));
                Map<Long,ShiguMarket> map=BeanMapper.list2Map(markets,"marketId",Long.TYPE);
                List<ShopShow> results=new ArrayList<>();
                for(ShopShow s:shopShowList){
                    if (s.getFloorId() == null) {
                        continue;
                    }
                    s.setFloor(map.get(s.getFloorId()).getMarketName());
                    results.add(s);
                }
                shopShowList=results;
            }else{
                shopShowList=new ArrayList<>();
            }
        }
        // shop 排序
        getShopComparator(shopShowList,webSite);
        floorShow.setShops(shopShowList);
        cache.put(outerFloor, floorShow);
        return floorShow;
    }

    private List<Integer> selTags(String context) {
        if (!StringUtils.isEmpty(context)) {
            String[] ids = context.split(",");
            List<Integer> integerList = new ArrayList<Integer>();
            for (String id : ids) {
                integerList.add(Integer.parseInt(id));
            }
            return integerList;
        }
        return null;
    }

    /**
     * 查找市场内开的的店铺档口
     *
     * @param floorId 楼层ID
     * @return
     */
    private List<ShiguShop> findOpenShopListByFloorIds(Long floorId) {
        return shiguShopMapper.selectShopForMarketList(floorId);
    }

    @Override
    public void getShopComparator(List<ShopShow> shopShowList){
        getShopComparator(shopShowList,null);
    }

    private void getShopComparator(List<ShopShow> shopShowList,String webSite) {
        if("hz".equals(webSite)){
            shopShowList.sort(new HzMarketShopListComparator());
        }else{
            shopShowList.sort(new MarketShopListComparator());
        }
    }

    /**
     * 查询站点市场展现数据
     *
     * @param website
     * @return
     */
    @Override
    public List<MarketNavShow> selMarketNavShowList(String website) {
        if (StringUtils.isEmpty(website)) {
            website = "hz";
        }
        Cache cache = cacheManager.getCache("marketNavCache");
        List<MarketNavShow> marketNavShowCacheList = cache.get(website, List.class);
        if (marketNavShowCacheList != null) {
            return marketNavShowCacheList;
        }
        ShiguOuterMarketExample outerMarketExample = new ShiguOuterMarketExample();
        outerMarketExample.createCriteria().andWebSiteEqualTo(website);
        List<ShiguOuterMarket> outerMarketList = shiguOuterMarketMapper.selectByExample(outerMarketExample);
        List<MarketNavShow> marketNavShowList = new ArrayList<MarketNavShow>();
        for (ShiguOuterMarket outerMarket : outerMarketList) {
            MarketNavShow marketNavShow = new MarketNavShow();
            marketNavShow.setMarketName(outerMarket.getMarketName());
            marketNavShow.setMid(outerMarket.getRuleId());
            marketNavShow.setWebSite(outerMarket.getWebSite());
            marketNavShowList.add(marketNavShow);
        }
        cache.put(website, marketNavShowList);
        return marketNavShowList;
    }
}
