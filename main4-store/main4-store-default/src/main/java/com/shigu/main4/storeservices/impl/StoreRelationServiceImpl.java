package com.shigu.main4.storeservices.impl;

import com.alibaba.druid.util.StringUtils;
import com.opentae.data.mall.beans.ShiguStore;
import com.opentae.data.mall.beans.ShiguStoreIdGenerator;
import com.opentae.data.mall.beans.ShiguStoreWx;
import com.opentae.data.mall.interfaces.ShiguStoreIdGeneratorMapper;
import com.shigu.main4.exceptions.StoreException;
import com.shigu.main4.storeservices.StoreRelationService;
import com.shigu.main4.vo.StoreRelation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * 店铺联系方式服务实现类
 * Created by zhaohongbo on 17/2/8.
 */
@Deprecated
public class StoreRelationServiceImpl implements StoreRelationService {

    @Resource(name = "shiguStoreService")
    private ShiguStoreServiceImpl shiguStoreService;

    @Resource(name = "tae_mall_managerJiekouMapper")
    private ShiguStoreIdGeneratorMapper shiguStoreIdGeneratorMapper;

    @Resource(name = "shiguGoodsTinyService")
    private ShiguGoodsTinyServiceImpl shiguGoodsTinyService;

    /**
     * 按店铺ID查店铺的联系方式
     * @param storeId 店铺ID
     * @return 1、查询表shigu_store_id_generator查出webSite
     *          2、调用selRelationById(storeId,webSite)返回结果
     */
    public StoreRelation selRelationById(Long storeId) {
        ShiguStoreIdGenerator shiguStoreIdGenerator = shiguStoreIdGeneratorMapper.selectStoreGenById(storeId);
        if(shiguStoreIdGenerator == null){
            return null;
        }
        String website = shiguStoreIdGenerator.getWebSite();
        StoreRelation storeRelation = selRelationById(storeId ,website);
        return storeRelation;
    }
    /**
     * 指定分站及店铺ID查联系方式
     * @param storeId 店铺ID
     * @param webSite 分站标识
     * @return 1、查出shigu_store_${webSite}的几个相关字段,返回storeRelation
     */
    public StoreRelation selRelationById(Long storeId, String webSite) {
        ShiguStore shiguStore = shiguStoreService.findStoreConcatInfoByStoreIdSite(storeId, webSite);
        if(shiguStore == null){
            return null;
        }
        StoreRelation storeRelation = new StoreRelation();
        storeRelation.setImQq(shiguStore.getImQq());
        storeRelation.setImWw(shiguStore.getImAliww());
        storeRelation.setStoreId(storeId);
        storeRelation.setTelephone(shiguStore.getTelephone());
        storeRelation.setStoreNum(shiguStore.getStoreNum());
        storeRelation.setMarketName(shiguStore.getParentMarket());
        storeRelation.setFloor(shiguStore.getMarket());

        ShiguStoreWx shiguStoreWx = shiguStoreService.findShiguStoreWxByStoreId(storeId);
        if (shiguStoreWx != null) {
            storeRelation.setImWx(shiguStoreWx.getImWx());
        }
        return storeRelation;
    }

    /**
     * 修改店铺联系信息
     * 其中storeId不能为空
     * 如果更新失败,扔出异常
     * @param relation 联系方式
     * @throws StoreException
     * 1、查询表shigu_store_id_generator查出webSite
     *          2、updateRelation(storeId,webSite)
     */
    @Transactional
    public void updateRelation(StoreRelation relation) throws StoreException {
        if(relation == null || relation.getStoreId() == null){
            throw new StoreException();
        }
        ShiguStoreIdGenerator shiguStoreIdGenerator = shiguStoreIdGeneratorMapper.selectStoreGenById(relation.getStoreId());
        if(shiguStoreIdGenerator == null){
            throw new StoreException();
        }
        String website = shiguStoreIdGenerator.getWebSite();
        updateRelation(relation, website);
    }
    /**
     * 批定分站修改店铺联系信息
     * 其中storeId不能为空
     * 如果更新失败,扔出异常
     * @param relation 联系方式
     * @param webSite 分站
     * @throws StoreException
     * 1、更新shigu_store_${webSite}对应字段
     * 2、如果旺旺有修改,需要对应修改shigu_goods_tiny表的im_aliww字段【以后商品表优化后,这块可能取消】
     */
    @Transactional
    public void updateRelation(StoreRelation relation, String webSite) throws StoreException {
        ShiguStore shiguStore = shiguStoreService.findStoreConcatInfoByStoreIdSite(relation.getStoreId(), webSite);

        if (!StringUtils.equals(relation.getImWw(), shiguStore.getImAliww())) {
            // 修改shigu_goods_tiny表的im_aliww字段
            shiguGoodsTinyService.updateImWwByStoreId(webSite, relation.getStoreId(), relation.getImWw(), relation.getStoreNum());
        }

        shiguStore.setStoreId(relation.getStoreId());
        shiguStore.setStoreNum(relation.getStoreNum());
        shiguStore.setTelephone(relation.getTelephone());
        shiguStore.setImQq(relation.getImQq());
        shiguStore.setImAliww(relation.getImWw());

        // 修改店铺信息
        shiguStoreService.updateByShiguStore(shiguStore);

        if(!StringUtils.isEmpty(relation.getImWx())){
            // 修改店铺微信信息
            ShiguStoreWx shiguStoreWx = new ShiguStoreWx();
            shiguStoreWx.setStoreId(relation.getStoreId());
            shiguStoreWx.setImWx(relation.getImWx());
            shiguStoreWx.setWebSite(webSite);
            shiguStoreService.addOrUpdate(shiguStoreWx);
        }
    }


}
