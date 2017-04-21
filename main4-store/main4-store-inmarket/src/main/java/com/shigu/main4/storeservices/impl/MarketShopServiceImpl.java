package com.shigu.main4.storeservices.impl;

import com.alibaba.fastjson.JSON;
import com.opentae.data.mall.beans.*;
import com.opentae.data.mall.examples.ShiguOuterMarketExample;
import com.opentae.data.mall.examples.ShiguShopExample;
import com.opentae.data.mall.interfaces.*;
import com.shigu.main4.enums.ShopLicenseTypeEnum;
import com.shigu.main4.storeservices.MarketShopService;
import com.shigu.main4.storeservices.vo.MarketShopListComparator;
import com.shigu.main4.vo.FloorShow;
import com.shigu.main4.vo.MarketShow;
import com.shigu.main4.vo.ShopShow;
import org.apache.commons.lang3.ClassUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.cache.Cache;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;


/**
 * 市场内档口数据查询
 *
 * @author shigu_zjb
 * @date 2017/02/27 18:35
 *
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
     * @param outerMarketId
     * @return
     */
    @Override
    public MarketShow selMarketShow(Long outerMarketId) {
        if(outerMarketId == null){
            return null;
        }
        // 市场信息
        ShiguOuterMarket shiguOuterMarket = new ShiguOuterMarket();
        shiguOuterMarket.setRuleId(outerMarketId);
        shiguOuterMarket = shiguOuterMarketMapper.selectOne(shiguOuterMarket);
        if(shiguOuterMarket == null){
            return null;
        }

        MarketShow marketShowTop = new MarketShow();
        marketShowTop.setMarketId(shiguOuterMarket.getMarketId());
        marketShowTop.setMarketOuterId(shiguOuterMarket.getRuleId());
        if(shiguOuterMarket.getMarketId()!=null){
            ShiguMarket shiguMarketNow = shiguMarketMapper.selectByPrimaryKey(shiguOuterMarket.getMarketId());
            if(shiguMarketNow != null){
                marketShowTop.setPingying(shiguMarketNow.getMarketPingyin());
                marketShowTop.setWebSite(shiguMarketNow.getWebSite());
                marketShowTop.setMarketName(shiguMarketNow.getMarketName());
            }
        }

        // 市场列表
        List<MarketShow> marketShowList = new ArrayList<MarketShow>();
        ShiguOuterMarketExample outerMarketExample = new ShiguOuterMarketExample();
        outerMarketExample.createCriteria().andWebSiteEqualTo(shiguOuterMarket.getWebSite());
        List<ShiguOuterMarket> outerMarketList = shiguOuterMarketMapper.selectByExample(outerMarketExample);
        for (int i = 0; i < outerMarketList.size(); i++) {
            ShiguOuterMarket outerMarket = outerMarketList.get(i);
            MarketShow marketShow = new MarketShow();
            if(outerMarket.getMarketId()!=null){
                ShiguMarket shiguMarket = shiguMarketMapper.selectByPrimaryKey(outerMarket.getMarketId());
                if(shiguMarket != null){
                    marketShow.setPingying(shiguMarket.getMarketPingyin());
                }
            }
            marketShow.setMarketName(outerMarket.getMarketName());
            marketShow.setMarketOuterId(outerMarket.getRuleId());
            marketShow.setMarketId(outerMarket.getMarketId());
            marketShow.setWebSite(outerMarket.getWebSite());
            marketShowList.add(marketShow);
        }
        marketShowTop.setOtherMarkets(marketShowList);

        // 楼层IDS
        String outerFloorIds = shiguOuterMarket.getOuterFloorIds();
        if(StringUtils.isEmpty(outerFloorIds)){
            return null;
        }
        String [] outerFloorStrIds = outerFloorIds.split(",");
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

    /**
     * 按外部楼层ID查一层的数据
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
        if(shiguOuterFloor == null){
            return null;
        }
        List<ShopShow> shopShowList = new ArrayList<ShopShow>();
        if(StringUtils.isEmpty(shiguOuterFloor.getFloorIds())){
            return null;
        }
        String [] floorIds = shiguOuterFloor.getFloorIds().split(",");
        FloorShow floorShow = new FloorShow();
        floorShow.setFloorIds(shiguOuterFloor.getFloorIds());
        floorShow.setOuterFloorId(outerFloor);
        floorShow.setShowName(shiguOuterFloor.getShowName());
        for (int k = 0; k < floorIds.length; k++) {
            Long floorId = Long.valueOf(floorIds[k]);
            List<ShiguShop> shiguShopList = new ArrayList<ShiguShop>();
            if(floorId != -1){
                shiguShopList = findOpenShopListByFloorIds(floorId);
            }
            for (int i = 0; i < shiguShopList.size(); i++) {
                ShiguShop shiguShop = shiguShopList.get(i);
                ShopShow shopShow = new ShopShow();
                String context = shiguShop.getShopTagsContexts();
                if (!StringUtils.isEmpty(context)) {
                    String[] ids = context.split(",");
                    List<Integer> integerList = new ArrayList<Integer>();
                    for (int m = 0; m < ids.length; m++) {
                        integerList.add(Integer.parseInt(ids[m]));
                    }
                    shopShow.setTags(integerList);
                }
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
            if(!StringUtils.isEmpty(addedShops)){
                List<Long> shopIdList = new ArrayList<Long>();
                String [] shops = addedShops.split(";");
                for (int i = 0; i < shops.length; i++) {
                    String [] shopInfos = shops[i].split(",");
                    ShopShow shopShow = new ShopShow();
                    if(!StringUtils.isEmpty(shopInfos[0])){
                        shopShow.setShopId(Long.valueOf(shopInfos[0]));
                        shopIdList.add(shopShow.getShopId());
                    }
                    if(shopInfos.length >= 4) {
                        shopShow.setSystemComment(shopInfos[3]);
                    }
                    if(shopInfos.length >= 2){
                        shopShow.setShopNum(shopInfos[1]);
                        shopShow.setSortOrderKey(shopInfos[1]);
                    }
                    if(shopInfos.length >= 3) {
                        shopShow.setShopName(shopInfos[2]);
                    }
                    shopShowList.add(shopShow);
                }
                List<ShiguShop> shopList = shiguShopMapper.selectShopListByShopIdsForMarketList(shopIdList);
                for (int m = 0; m < shopIdList.size(); m++) {
                    ShiguShop shiguShop = shopList.get(m);
                    for (int n = 0; n < shopShowList.size(); n++) {
                        if (shiguShop.getShopId().intValue() == shopShowList.get(n).getShopId().intValue()) {
                            if (shiguShop.getShopStatus() != 0 || shiguShop.getDisplayInMarket() != 1) {
                                continue;
                            }
                            String context = shiguShop.getShopTagsContexts();
                            if (!StringUtils.isEmpty(context)) {
                                String[] ids = context.split(",");
                                List<Integer> integerList = new ArrayList<Integer>();
                                for (int a = 0; a < ids.length; a++) {
                                    integerList.add(Integer.parseInt(ids[a]));
                                }
                                shopShowList.get(n).setTags(integerList);
                            }
                            shopShowList.get(n).setSortOrderKey(shiguShop.getSortOrderKey());
                            if (!StringUtils.isEmpty(shiguShop.getSystemRecommon())) {
                                shopShowList.get(n).setSystemComment(shiguShop.getSystemRecommon());
                            }
                            shopShowList.get(n).setCreateDate(shiguShop.getCreateDate());
                            shopShowList.get(n).setMainBus(shiguShop.getMainBus());
                            break;
                        }
                    }
                }
            }
        }
        // shop 排序
        getShopComparator(shopShowList);
        floorShow.setShops(shopShowList);
        cache.put(outerFloor,floorShow);
        return floorShow;
    }

    /**
     * 查找市场内开的的店铺档口
     * @param floorId 楼层ID
     * @return
     */
    public List<ShiguShop> findOpenShopListByFloorIds(Long floorId){
        List<ShiguShop> shiguShopList = shiguShopMapper.selectShopForMarketList(floorId);
        return shiguShopList;
    }

    @Override
    public void getShopComparator(List<ShopShow> shopShowList) {
        Collections.sort(shopShowList, new MarketShopListComparator());
    }
}
