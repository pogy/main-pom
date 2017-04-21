package com.shigu.main4.cdn.services;

import com.opentae.core.mybatis.utils.FieldUtil;
import com.opentae.data.mall.beans.ShiguGoodsIdGenerator;
import com.opentae.data.mall.beans.ShiguGoodsTiny;
import com.opentae.data.mall.beans.ShiguShop;
import com.opentae.data.mall.interfaces.ShiguGoodsIdGeneratorMapper;
import com.opentae.data.mall.interfaces.ShiguGoodsTinyMapper;
import com.opentae.data.mall.interfaces.ShiguShopMapper;
import com.shigu.main4.cdn.bo.ScGoodsBO;
import com.shigu.main4.cdn.bo.ScStoreBO;
import com.shigu.main4.ucenter.exceptions.ItemCollectionException;
import com.shigu.main4.ucenter.exceptions.ShopCollectionException;
import com.shigu.main4.ucenter.services.UserCollectService;
import com.shigu.main4.ucenter.vo.ItemCollect;
import com.shigu.main4.ucenter.vo.ShopCollect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * cdn服务
 * Created by zhaohongbo on 17/3/7.
 */
@Service
public class CdnService {

    @Autowired
    UserCollectService userCollectService;

    @Autowired
    ShiguGoodsIdGeneratorMapper shiguGoodsIdGeneratorMapper;

    @Autowired
    ShiguGoodsTinyMapper shiguGoodsTinyMapper;

    @Autowired
    ShiguShopMapper shiguShopMapper;

    /**
     * 收藏商品
     * @param userId
     * @param bo
     * @return
     */
    public boolean addItemCollect(Long userId,ScGoodsBO bo){
        ItemCollect itemCollect=new ItemCollect();
        itemCollect.setUserId(userId);
        //查出店、webSite
        ShiguGoodsIdGenerator sgig=shiguGoodsIdGeneratorMapper.selectByPrimaryKey(bo.getGoodsId());
        if(sgig==null){
            return false;
        }
        ShiguGoodsTiny sgt=new ShiguGoodsTiny();
        sgt.setGoodsId(bo.getGoodsId());
        sgt.setWebSite(sgig.getWebSite());
        sgt=shiguGoodsTinyMapper.selectFieldsByPrimaryKey(sgt, FieldUtil.codeFields("goods_id,store_id"));
        if(sgt==null){
            return false;
        }
        itemCollect.setItemId(bo.getGoodsId());
        itemCollect.setStoreId(sgt.getStoreId());
        itemCollect.setWebsite(sgig.getWebSite());
        try {
            userCollectService.addItemCollection(itemCollect);
        } catch (ItemCollectionException e) {
            return false;
        }
        return true;
    }

    /**
     * 收藏店铺
     * @param userId
     * @param bo
     * @return
     */
    public boolean addShopCollect(Long userId, ScStoreBO bo){
        ShopCollect shopCollect=new ShopCollect();
        ShiguShop shop=shiguShopMapper.selectFieldsByPrimaryKey(bo.getStore_id(),
                FieldUtil.codeFields("shop_id,web_site"));
        if(shop==null){
            return false;
        }
        shopCollect.setWebsite(shop.getWebSite());
        shopCollect.setUserId(userId);
        shopCollect.setShopId(shop.getShopId());
        try {
            userCollectService.addShopCollection(shopCollect);
        } catch (ShopCollectionException e) {
            return false;
        }
        return true;
    }
}
