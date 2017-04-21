package com.shigu.main4.storeservices.impl;


import com.opentae.data.mall.beans.ShiguStore;
import com.opentae.data.mall.beans.ShiguStoreIdGenerator;
import com.opentae.data.mall.beans.ShiguStoreWx;
import com.opentae.data.mall.interfaces.*;
import com.shigu.main4.exceptions.StoreException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * 店铺SERVICE
 *
 * @author shigu_zjb
 * @date 2017/2/9 12:51
 *
 */
@Service("shiguStoreService")
public class ShiguStoreServiceImpl {

    @Resource(name = "tae_mall_shiguStoreMapper")
    private ShiguStoreMapper shiguStoreMapper;

    @Resource(name = "tae_mall_managerJiekouMapper")
    private ShiguStoreIdGeneratorMapper shiguStoreIdGeneratorMapper;

    @Resource(name = "tae_mall_shiguStoreWxMapper")
    private ShiguStoreWxMapper shiguStoreWxMapper;

    @Resource(name = "tae_mall_shiguStoreNumMapper")
    private ShiguStoreNumMapper shiguStoreNumMapper;

    @Resource(name = "tae_mall_shiguStoreNumShowMapper")
    private ShiguStoreNumShowMapper shiguStoreNumShowMapper;

    /**
     * 查询店铺联系信息
     * @param storeId 店铺ID
     * @return
     */
    public ShiguStore findStoreConcatInfoByStoreId(Long storeId){
        if(storeId == null){return null;}
        ShiguStoreIdGenerator shiguStoreIdGenerator = shiguStoreIdGeneratorMapper.selectStoreGenById(storeId);
        if(shiguStoreIdGenerator == null){
            return null;
        }
        String website = shiguStoreIdGenerator.getWebSite();
        ShiguStore shiguStore = shiguStoreMapper.selectStoreRelationByIdWebSite(storeId, website);
        return shiguStore;
    }


    /**
     * 查询店铺联系信息
     * @param storeId 店铺ID
     * @param website 站点
     * @return
     */
    public ShiguStore findStoreConcatInfoByStoreIdSite(Long storeId ,String website){
        if(storeId == null || StringUtils.isEmpty(website)){
            return null;
        }
        ShiguStore shiguStore = shiguStoreMapper.selectStoreRelationByIdWebSite(storeId, website);
        return shiguStore;
    }

    /**
     * 店铺信息修改
     * @param shiguStore
     * @return
     */
    public void updateByShiguStore(ShiguStore shiguStore) throws StoreException {
        if(shiguStore == null || shiguStore.getStoreId() == null){
            throw new StoreException();
        }
        ShiguStoreIdGenerator shiguStoreIdGenerator = shiguStoreIdGeneratorMapper.selectStoreGenById(shiguStore.getStoreId());
        if(shiguStoreIdGenerator == null){
            // 找不到该店铺信息
            throw new StoreException();
        }
        String website = shiguStoreIdGenerator.getWebSite();
        int result = shiguStoreMapper.updateStoreRelationByIdWebSite(shiguStore, website);
        if(result == 0){
            throw new StoreException();
        }
        // 修改档口展现表与档口设置表
        if(!StringUtils.isEmpty(shiguStore.getStoreNum())){
            shiguStoreNumMapper.updateStoreNumByStoreId(shiguStore.getStoreId(),shiguStore.getStoreNum());
            shiguStoreNumShowMapper.updateStoreNumByStoreId(shiguStore.getStoreId(),shiguStore.getStoreNum());
        }
    }

    /**
     * 更新或新增店铺微信信息
     * @param shiguStoreWx
     */
    public void addOrUpdate(ShiguStoreWx shiguStoreWx) throws StoreException{
        if(shiguStoreWx == null || shiguStoreWx.getStoreId() == null){
            return;
        }
        ShiguStoreIdGenerator shiguStoreIdGenerator = shiguStoreIdGeneratorMapper.selectStoreGenById(shiguStoreWx.getStoreId());
        if(shiguStoreIdGenerator == null){
            // 找不到该店铺信息
            throw new StoreException();
        }
        ShiguStoreWx shiguStoreWxQuery = new ShiguStoreWx();
        shiguStoreWxQuery.setStoreId(shiguStoreWx.getStoreId());
        int wxInt = shiguStoreWxMapper.selectCount(shiguStoreWxQuery);
        if(wxInt == 0){
            // 新增
            shiguStoreWxMapper.insertSelective(shiguStoreWx);
            return;
        }
        // 修改
        shiguStoreWxMapper.updateByPrimaryKeySelective(shiguStoreWx);
    }


    /**
     * 查询店铺微信信息
     * @param storeId
     * @return
     */
    public ShiguStoreWx findShiguStoreWxByStoreId(Long storeId){
        ShiguStoreWx shiguStoreWx = new ShiguStoreWx();
        shiguStoreWx.setStoreId(storeId);
        shiguStoreWx = shiguStoreWxMapper.selectOne(shiguStoreWx);
        return shiguStoreWx;
    }
}
