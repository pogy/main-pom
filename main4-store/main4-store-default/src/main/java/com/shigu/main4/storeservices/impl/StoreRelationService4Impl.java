package com.shigu.main4.storeservices.impl;


import com.opentae.core.mybatis.utils.FieldUtil;
import com.opentae.data.mall.beans.ShiguMarket;
import com.opentae.data.mall.beans.ShiguShop;
import com.opentae.data.mall.interfaces.ShiguMarketMapper;
import com.opentae.data.mall.interfaces.ShiguShopMapper;
import com.shigu.main4.exceptions.StoreException;
import com.shigu.main4.storeservices.ShopBaseService;
import com.shigu.main4.storeservices.ShopToEsService;
import com.shigu.main4.storeservices.StoreRelationService;
import com.shigu.main4.vo.StoreRelation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.lang.reflect.Field;
import java.util.Date;

/**
 * 店铺联系方式SERVICE
 *
 * @author shigu_zjb
 * @date 2017/2/20 11:15
 *
 */
@Service("storeRelationService")
public class StoreRelationService4Impl extends ShopServiceImpl implements StoreRelationService{

    @Resource(name = "tae_mall_shiguShopMapper")
    private ShiguShopMapper shiguShopMapper;

    @Resource(name = "tae_mall_shiguMarketMapper")
    private ShiguMarketMapper shiguMarketMapper;

    @Autowired
    private ShopBaseService shopBaseService;

    @Autowired
    private ShopToEsService shopToEsService;

    /**
     * 店铺联系方式查询
     * @param storeId 店铺ID
     * @return
     */
    public StoreRelation selRelationById(Long storeId) {
        if(storeId == null){
            return null;
        }
        // 查询缓存
        Cache cache = cacheManager.getCache("shoprelationCache");
        StoreRelation storeRelationCache = cache.get(storeId, StoreRelation.class);
        if(storeRelationCache != null){
            return storeRelationCache;
        }
        // 查询数据库
        ShiguShop shiguShop = shiguShopMapper.selectByPrimaryKey(storeId);
        if(shiguShop == null){
            return null;
        }
        StoreRelation storeRelation = new StoreRelation();
        storeRelation.setStoreNum(shiguShop.getShopNum());
        storeRelation.setImWw(shiguShop.getImAliww());
        storeRelation.setImWx(shiguShop.getImWx());
        storeRelation.setWebSite(shiguShop.getWebSite());
        ShiguMarket shiguMarket = shiguMarketMapper.selectFieldsByPrimaryKey(shiguShop.getMarketId(),
                FieldUtil.codeFields("market_id,market_name"));
        if(shiguMarket != null){
            storeRelation.setMarketName(shiguMarket.getMarketName());
        }
        storeRelation.setMarketId(shiguShop.getMarketId());

        ShiguMarket shiguMarketFloor = shiguMarketMapper.selectFieldsByPrimaryKey(shiguShop.getFloorId(),
                FieldUtil.codeFields("market_id,market_name"));
        if(shiguMarketFloor != null){
            storeRelation.setFloor(shiguMarketFloor.getMarketName());
        }

        storeRelation.setTelephone(shiguShop.getTelephone());
        storeRelation.setImQq(shiguShop.getImQq());
        storeRelation.setStoreId(shiguShop.getShopId());
        // 加入缓存
        cache.put(storeId, storeRelation);
        return storeRelation;
    }

    /**
     * 店铺联系方式查询
     * @param storeId 店铺ID
     * @param webSite 分站标识
     * @return
     */
    public StoreRelation selRelationById(Long storeId, String webSite) {
        if(storeId == null || StringUtils.isEmpty(webSite)){
            return null;
        }
        // 查询缓存
        Cache cache = cacheManager.getCache("shoprelationCache");
        StoreRelation storeRelationCache = cache.get(storeId, StoreRelation.class);
        if(storeRelationCache != null){
            return storeRelationCache;
        }
        ShiguShop shiguShop = new ShiguShop();
        shiguShop.setShopId(storeId);
        shiguShop.setWebSite(webSite);
        shiguShop =  shiguShopMapper.selectOne(shiguShop);
        if(shiguShop == null){
            return null;
        }
        StoreRelation storeRelation = new StoreRelation();
        storeRelation.setStoreNum(shiguShop.getShopNum());
        storeRelation.setImWw(shiguShop.getImAliww());
        storeRelation.setImWx(shiguShop.getImWx());
        storeRelation.setWebSite(shiguShop.getWebSite());

        ShiguMarket shiguMarket = shiguMarketMapper.selectFieldsByPrimaryKey(shiguShop.getMarketId(),
                FieldUtil.codeFields("market_id,market_name"));
        if(shiguMarket != null){
            storeRelation.setMarketName(shiguMarket.getMarketName());
        }

        ShiguMarket shiguMarketFloor = shiguMarketMapper.selectFieldsByPrimaryKey(shiguShop.getFloorId(),
                FieldUtil.codeFields("market_id,market_name"));
        if(shiguMarketFloor != null){
            storeRelation.setFloor(shiguMarketFloor.getMarketName());
        }

        storeRelation.setTelephone(shiguShop.getTelephone());
        storeRelation.setImQq(shiguShop.getImQq());
        storeRelation.setStoreId(shiguShop.getShopId());
        // 加入缓存
        cache.put(storeId, storeRelation);
        return storeRelation;
    }

    /**
     * 更新店铺联系信息
     * @param relation 联系方式
     * @throws StoreException
     */
    public void updateRelation(StoreRelation relation) throws StoreException {
        if(relation == null || relation.getStoreId() == null){
            throw new StoreException();
        }
        ShiguShop shiguShop = new ShiguShop();
        shiguShop.setShopNum(relation.getStoreNum());
        shiguShop.setImAliww(relation.getImWw());
        shiguShop.setTelephone(relation.getTelephone());
        shiguShop.setImQq(relation.getImQq());
        shiguShop.setShopId(relation.getStoreId());
        shiguShop.setImWx(relation.getImWx());
        shiguShop.setLastModifyTime(new Date());
        int result = shiguShopMapper.updateByPrimaryKeySelective(shiguShop);
        //添加到ES
        shopToEsService.addToEs(shiguShop.getShopId());
        if(result == 0){
            throw new StoreException();
        }
        Cache cache = cacheManager.getCache("shoprelationCache");
        cache.evict(relation.getStoreId());
    }

    /**
     * 更新店铺联系信息
     * @param relation 联系方式
     * @param webSite 分站
     * @throws StoreException
     */
    public void updateRelation(StoreRelation relation, String webSite) throws StoreException {
        if(relation == null || StringUtils.isEmpty(webSite) || relation.getStoreId() == null) {
            throw new StoreException();
        }
        ShiguShop shiguShop = new ShiguShop();
        shiguShop.setShopId(relation.getStoreId());
        shiguShop.setWebSite(webSite);
        shiguShop.setTelephone(relation.getTelephone());
        shiguShop.setImQq(relation.getImQq());
        shiguShop.setImAliww(relation.getImWw());
        shiguShop.setShopNum(relation.getStoreNum());
        shiguShop.setImWx(relation.getImWx());
        shiguShop.setLastModifyTime(new Date());
        int result = shiguShopMapper.updateByPrimaryKeySelective(shiguShop);
        //添加到ES
        shopToEsService.addToEs(shiguShop.getShopId());
        if(result == 0){
            throw new StoreException();
        }
        Cache cache = cacheManager.getCache("shoprelationCache");
        cache.evict(relation.getStoreId());
    }
}
