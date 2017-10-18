package com.shigu.phone.baseservices;

import com.aliyun.opensearch.sdk.dependencies.com.google.common.collect.Lists;
import com.openJar.beans.app.AppShopBlock;
import com.openJar.exceptions.OpenException;
import com.openJar.requests.app.DoStoreCollectRequest;
import com.openJar.requests.app.ShopSearchRequest;
import com.openJar.requests.app.StoreCollectRequest;
import com.openJar.responses.app.DoStoreCollectResponse;
import com.openJar.responses.app.ShopSearchResponse;
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
import com.shigu.phone.basevo.ShopSearchVO;
import com.shigu.phone.basevo.StoreCollectVO;
import com.shigu.search.bo.StorenumBO;
import com.shigu.search.services.StoreSelFromEsService;
import com.shigu.search.vo.StoreInSearch;
import com.shigu.zhb.utils.BeanMapper;
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
public class BasedPhoneStoreService {

    @Autowired
    private UserCollectService userCollectService;

    @Autowired
    private CdnService cdnService;

    @Autowired
    private RegisterAndLoginService registerAndLoginService;

    @Autowired
    private StoreSelFromEsService storeSelFromEsService;

    @Autowired
    private ShopForCdnService shopForCdnService;

    @Autowired
    private MultipleMapper tae_mall_multipleMapper;

    @Autowired
    private RedisIO redisIO;

    /**
     * 移动端店铺搜索
     *
     * @return
     */
    public ShopSearchVO shopSearch(String keyword, String webSite,Integer index,Integer size) {
        StorenumBO bo = new StorenumBO();
        bo.setKeyword(keyword);
        bo.setWebSite(webSite);
        bo.setPage(index);
        bo.setRows(size);
        ShiguPager<StoreInSearch> result = storeSelFromEsService.searchStore(bo);
        ShopSearchVO shopSearchVO = new ShopSearchVO();
        shopSearchVO.setTotal(result.getTotalCount());
        shopSearchVO.setHasNext(result.getNumber() < result.getTotalPages());
        shopSearchVO.setShops(result.getContent().parallelStream().map(o -> {
            AppShopBlock vo = new AppShopBlock();
            vo.setShopId(Long.valueOf(o.getId()));
            vo.setMarket(o.getFullMarketText());
            vo.setHighLightMarket(o.getHighMarketName());
            vo.setShopNum(o.getName());
            vo.setHighLightShopNum(o.getHighName());
            vo.setStarNum(o.getXy());
            vo.setTelephone(o.getTel());
            vo.setImAliww(o.getAliww());
            vo.setImQq(o.getImqq());
            vo.setMainCase(o.getMainCate());
            vo.setItemNum(o.getGoodsCount());
            vo.setShopHeadUrl(ImgUtils.headUrl(o.getAliww()));
            return vo;
        }).collect(Collectors.toList()));
        return shopSearchVO;
    }

    /**
     * 店铺收藏夹
     *
     * @return
     */
    public StoreCollectVO storeCollect(Long userId, String webSite,Integer index,Integer size) {
        StoreCollectVO storeCollectVO = new StoreCollectVO();
        ShiguPager<ShopCollectVO> shopCollectVOShiguPager = userCollectService.selShopCollections(userId, webSite, index, size);
        if (shopCollectVOShiguPager.getTotalCount() == 0) {
           return storeCollectVO;//收藏夹无商品
        }
        List<ShopCollectVO> shopCollectVOS = shopCollectVOShiguPager.getContent();
        List<Long> shopIds = shopCollectVOS.stream().map(ShopCollectVO::getShopId).collect(Collectors.toList());
        ArrayList<AppShopBlockBean> appShopBlockBeans = new ArrayList<>(size);
        ShiguMarketExample marketExample = new ShiguMarketExample();
        ShiguShopExample shopExample = new ShiguShopExample();
        MultipleExample example = MultipleExampleBuilder.from(shopExample)
                .join(marketExample).on(shopExample.createCriteria().andShopIdIn(shopIds).equalTo(ShiguGoodsTinyExample.marketId, ShiguMarketExample.marketId))
                .build();
        example.setGroupByClause("shigu_shop.shop_id");
        appShopBlockBeans.addAll(tae_mall_multipleMapper.selectFieldsByMultipleExample(example, AppShopBlockBean.class));
        storeCollectVO.setShops(appShopBlockBeans.parallelStream().map(o -> {
            AppShopBlock shop = BeanMapper.map(o, AppShopBlock.class);
            //从ShopCdn拿档口商品数量
            shop.setItemNum(shopForCdnService.selItemNumberById(o.getShopId(), o.getWebSite()).intValue());
            //从缓存拿星星数
            shop.setStarNum(shopForCdnService.selShopStarById(o.getShopId()).toString());
            shop.setShopHeadUrl(shop.getShopHeadUrl().replace("回车间",o.getImAliww()));
            return shop;
        }).collect(Collectors.toList()));
        storeCollectVO.setTotal(shopCollectVOShiguPager.getTotalCount());
        storeCollectVO.setHasNext(shopCollectVOShiguPager.getNumber() < shopCollectVOShiguPager.getTotalPages());
        return storeCollectVO;
    }

    /**
     * 收藏OR取消收藏店铺
     *
     * @return
     */
    public void doStoreCollect( Long shopId,boolean yesOrNo,Long userId) throws OpenException {
        if (yesOrNo) {
            try {
                addShopCollection(userId,shopId);
            } catch (ShopCollectionException e) {
               OpenException openException  = new OpenException();
               openException.setErrMsg("收藏失败");
               throw openException;
            }
        } else {
            delShopCollection(userId,Lists.newArrayList(shopId));
        }
    }

    /**
     * 删除店铺收藏
     *
     * @return
     */
    public void delShopCollection(Long userId,List<Long> shopIds) {
        userCollectService.delShopCollectionByShopIds(userId,shopIds);
    }

    /**
     * 添加店铺收藏
     *
     * @throws ShopCollectionException
     */
    public void addShopCollection(Long userId,Long shopId) throws ShopCollectionException {
        ScStoreBO bo = new ScStoreBO();
        bo.setStore_id(shopId);
        cdnService.addShopCollect(userId, bo);
    }
}
