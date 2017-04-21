package com.shigu.seller.services;

import com.shigu.main4.common.vo.ShiguTags;
import com.shigu.main4.exceptions.StoreException;
import com.shigu.main4.storeservices.ShopBaseService;
import com.shigu.main4.storeservices.ShopLicenseService;
import com.shigu.main4.storeservices.StoreRelationService;
import com.shigu.main4.vo.ShopBase;
import com.shigu.main4.vo.StoreRelation;
import com.shigu.seller.bo.ShopBaseBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * 专门保存店铺设置用
 * Created by zhaohongbo on 17/3/18.
 */
@Service
public class ShopBaseSaveService {
    @Autowired
    ShopBaseService shopBaseService;

    @Autowired
    StoreRelationService storeRelationService;

    @Autowired
    ShopLicenseService shopLicenseService;

    /**
     * 保存店铺基本信息
     * @param bo
     */
    @Transactional
    public void saveShopBase(Long shopId,ShopBaseBO bo) throws StoreException {
        if(bo.getMainBus()!=null||bo.getPacketUrl()!=null
                ||bo.getStoreNum()!=null||bo.getStoreName()!=null||bo.getSmallTitle()!=null) {
            ShopBase base = new ShopBase();
            base.setMainBus(bo.getMainBus());
            base.setDataPackageUrl(bo.getPacketUrl());
            base.setShopName(bo.getStoreName());
            base.setShopNum(bo.getStoreNum());
            base.setSystemRecommon(bo.getSmallTitle());
            shopBaseService.modifyShopBase(shopId, base);
        }
        //联系方式
        if(bo.getTelephone()!=null||bo.getImQq()!=null
                ||bo.getImWw()!=null||bo.getImWx()!=null){
            StoreRelation relation=new StoreRelation();
            relation.setStoreId(shopId);
            relation.setTelephone(bo.getTelephone());
            relation.setImQq(bo.getImQq());
            relation.setImWw(bo.getImWw());
            relation.setImWx(bo.getImWx());
            storeRelationService.updateRelation(relation);
        }
        //保存标签属性
        String servers=bo.getServers();
        List<ShiguTags> tages=new ArrayList<>();
        if(servers!=null&&!"".equals(servers)){
            String[] serverarr=servers.split(",");
            for(String s:serverarr){
                if(ShiguTags.CAN_CHANGE.getValue().equals(s)){
                    tages.add(ShiguTags.CAN_CHANGE);
                }else if(ShiguTags.CAN_RETREAT.getValue().equals(s)){
                    tages.add(ShiguTags.CAN_RETREAT);
                }
            }
        }
        shopLicenseService.updateShopTagLicense(shopId,tages);
    }
}
