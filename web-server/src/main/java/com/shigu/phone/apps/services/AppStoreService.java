package com.shigu.phone.apps.services;

import com.opentae.data.mall.examples.ShiguGoodsTinyExample;
import com.opentae.data.mall.interfaces.ShiguGoodsTinyMapper;
import com.shigu.main4.cdn.services.CdnService;
import com.shigu.main4.cdn.services.MarketListService;
import com.shigu.main4.cdn.vo.MarketVO;
import com.shigu.main4.common.util.DateUtil;
import com.shigu.main4.newcdn.vo.CdnShopCatVO;
import com.shigu.main4.storeservices.ShopForCdnService;
import com.shigu.main4.storeservices.StoreRelationService;
import com.shigu.main4.vo.StoreRelation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by pc on 2017-08-29.
 * app 店铺 service
 *
 * @author lys
 * @version 3.0.0-SNAPSHOT
 * @description
 * @since 3.0.0-SNAPSHOT
 */
@Service
public class AppStoreService {

    private StoreRelationService storeRelationService;
    @Autowired
    public void setStoreRelationService(StoreRelationService storeRelationService) {
        this.storeRelationService = storeRelationService;
    }
    private ShopForCdnService shopForCdnService;
    @Autowired
    public void setShopForCdnService(ShopForCdnService shopForCdnService) {
        this.shopForCdnService = shopForCdnService;
    }
    private ShiguGoodsTinyMapper shiguGoodsTinyMapper;
    @Autowired
    public void setShiguGoodsTinyMapper(ShiguGoodsTinyMapper shiguGoodsTinyMapper) {
        this.shiguGoodsTinyMapper = shiguGoodsTinyMapper;
    }
    private MarketListService marketListService;
    @Autowired
    public void setMarketListService(MarketListService marketListService) {
        this.marketListService = marketListService;
    }
    private CdnService cdnService;
    @Autowired
    public void setCdnService(CdnService cdnService) {
        this.cdnService = cdnService;
    }
    //TODO 单店铺查询
    public Object selOneShopInfo() {
        //店铺基本信息
        StoreRelation storeRelation = storeRelationService.selRelationById(1L);
        //商品数量
        Long itemsNum = shopForCdnService.selItemNumberById(1L, "hz");
        //今日上新数
        ShiguGoodsTinyExample tinyExample = new ShiguGoodsTinyExample();
        tinyExample.setWebSite("hz");
        tinyExample.createCriteria().andStoreIdEqualTo(1L).andLoadDateGreaterThanOrEqualTo(DateUtil.getStartTime());
        int count = shiguGoodsTinyMapper.countByExample(tinyExample);


        return null;
    }
    //TODO 市场数据查询
    public Object selMarketData(){
        MarketVO marketVO = marketListService.selMarketData(1L, null);
        return null;
    }
    //TODO 店内类目
    public Object selShopCat(){
        List<CdnShopCatVO> cdnShopCatVOS = cdnService.cdnShopCat(1L);
        return null;
    }
}
