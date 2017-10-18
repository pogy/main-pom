package com.shigu.phone.waps.service;

import com.aliyun.opensearch.sdk.dependencies.com.google.common.collect.Lists;
import com.openJar.beans.app.AppShopBlock;
import com.openJar.exceptions.OpenException;
import com.openJar.requests.app.DoStoreCollectRequest;
import com.openJar.requests.app.StoreCollectRequest;
import com.openJar.responses.app.DoStoreCollectResponse;
import com.openJar.responses.app.StoreCollectResponse;
import com.opentae.core.mybatis.example.MultipleExample;
import com.opentae.core.mybatis.example.MultipleExampleBuilder;
import com.opentae.core.mybatis.mapper.MultipleMapper;
import com.opentae.data.mall.examples.ShiguGoodsTinyExample;
import com.opentae.data.mall.examples.ShiguMarketExample;
import com.opentae.data.mall.examples.ShiguShopExample;
import com.opentae.data.mall.multibeans.AppShopBlockBean;
import com.shigu.main4.cdn.bo.ScStoreBO;
import com.shigu.main4.cdn.services.CdnService;
import com.shigu.main4.common.tools.ShiguPager;
import com.shigu.main4.storeservices.ShopForCdnService;
import com.shigu.main4.tools.RedisIO;
import com.shigu.main4.ucenter.exceptions.ShopCollectionException;
import com.shigu.main4.ucenter.services.RegisterAndLoginService;
import com.shigu.main4.ucenter.services.UserCollectService;
import com.shigu.main4.ucenter.webvo.ShopCollectVO;
import com.shigu.phone.apps.utils.ImgUtils;
import com.shigu.phone.baseservices.BasedPhoneStoreService;
import com.shigu.phone.basevo.ShopSearchVO;
import com.shigu.phone.basevo.StoreCollectVO;
import com.shigu.search.bo.StorenumBO;
import com.shigu.search.services.StoreSelFromEsService;
import com.shigu.search.vo.StoreInSearch;
import com.shigu.tools.JsonResponseUtil;
import com.shigu.zhb.utils.BeanMapper;
import net.sf.json.JSON;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 类名：PhoneStoreService
 * 类路径：com.shigu.phone.apps.baseservices.PhoneStoreService
 * 创建者：王浩翔
 * 创建时间：2017-08-31 15:38
 * 项目：main-pom
 * 描述：
 */

@Service
public class WapPhoneStoreService {

    @Autowired
    private BasedPhoneStoreService basedPhoneStoreService;

    /**
     * 移动端店铺搜索
     * @param keyword
     * @param webSite
     * @param index
     * @param size
     * @return
     */
    public ShopSearchVO shopSearch(String keyword, String webSite, Integer index, Integer size) {
       return basedPhoneStoreService.shopSearch(keyword, webSite, index, size);
    }

    /**
     * 店铺收藏夹
     *
     * @return
     */
    public StoreCollectVO storeCollect(String webSite,Long userId,Integer index,Integer size) {
        return basedPhoneStoreService.storeCollect(userId, webSite, index, size);
    }

    /**
     * 收藏OR取消收藏店铺
     *
     * @return
     */
    public void doStoreCollect(Long shopId,Boolean yesOrNo,Long userId) throws OpenException {
        basedPhoneStoreService.doStoreCollect(shopId,yesOrNo,userId);
    }

    /**
     * 批量取消收藏店铺
     *
     * @return
     */
    public void delStoreCollect(List<Long> collectIds, Long userId){
        basedPhoneStoreService.delShopCollection(userId,collectIds);
    }

}
