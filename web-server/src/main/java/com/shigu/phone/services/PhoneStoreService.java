package com.shigu.phone.services;

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
import com.shigu.main4.ucenter.exceptions.ShopCollectionException;
import com.shigu.main4.ucenter.services.RegisterAndLoginService;
import com.shigu.main4.ucenter.services.UserCollectService;
import com.shigu.main4.ucenter.webvo.ShopCollectVO;
import com.shigu.search.bo.StorenumBO;
import com.shigu.search.services.StoreSelFromEsService;
import com.shigu.search.vo.StoreInSearch;
import com.shigu.zhb.utils.BeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 类名：PhoneStoreService
 * 类路径：com.shigu.phone.services.PhoneStoreService
 * 创建者：王浩翔
 * 创建时间：2017-08-31 15:38
 * 项目：main-pom
 * 描述：
 */

@Service
public class PhoneStoreService {

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

    /**
     * 移动端店铺搜索
     * @param request
     * @return
     */
    public ShopSearchResponse shopSearch(ShopSearchRequest request) {
        StorenumBO bo = new StorenumBO();
        bo.setKeyword(request.getKeyword());
        bo.setWebSite(request.getWebSite());
        bo.setPage(request.getIndex());
        bo.setRows(request.getSize());
        ShiguPager<StoreInSearch> result = storeSelFromEsService.searchStore(bo);
        ShopSearchResponse resp = new ShopSearchResponse();
        resp.setTotal(result.getTotalCount());
        resp.setHasNext(result.getNumber()<result.getTotalPages());
        resp.setShops(result.getContent().parallelStream().map(o->{
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
            vo.setShopHeadUrl(o.getImgsrc());
            return vo;
        }).collect(Collectors.toList()));
        resp.setSuccess(true);
        return resp;
    }

    /**
     * 店铺收藏夹
     * @param request
     * @return
     */
    public StoreCollectResponse storeCollect(StoreCollectRequest request) {
        StoreCollectResponse resp = new StoreCollectResponse();
        ShiguPager<ShopCollectVO> shopCollectVOShiguPager = userCollectService.selShopCollections(request.getUserId(), null, request.getIndex(), request.getSize());
        List<ShopCollectVO> shopCollectVOS = shopCollectVOShiguPager.getContent();
        List<Long> shopIds = shopCollectVOS.stream().map(ShopCollectVO::getShopId).collect(Collectors.toList());
        Set<String> webSites = shopCollectVOS.parallelStream().map(ShopCollectVO::getWebsite).collect(Collectors.toSet());
        ArrayList<AppShopBlockBean> appShopBlockBeans = new ArrayList<>(request.getSize());
        //按分站获取店铺信息
        for (String webSite : webSites) {
            ShiguGoodsTinyExample goodsTinyExample = new ShiguGoodsTinyExample();
            goodsTinyExample.setWebSite(webSite);
            ShiguMarketExample marketExample = new ShiguMarketExample();
            ShiguShopExample shopExample = new ShiguShopExample();
            MultipleExample example = MultipleExampleBuilder.from(shopExample)
                    .join(marketExample).on(shopExample.createCriteria().andShopIdIn(shopIds).andWebSiteEqualTo(webSite).equalTo(ShiguGoodsTinyExample.marketId,ShiguMarketExample.marketId))
                    .join(goodsTinyExample).on(goodsTinyExample.createCriteria().equalTo(ShiguGoodsTinyExample.storeId,ShiguShopExample.shopId))
                    .build();
            example.setGroupByClause("shigu_shop.shop_id");
            appShopBlockBeans.addAll(tae_mall_multipleMapper.selectFieldsByMultipleExample(example, AppShopBlockBean.class));
        }
        resp.setShops(appShopBlockBeans.parallelStream().map(o->{
            AppShopBlock shop = BeanMapper.map(o,AppShopBlock.class);
            //从ShopCdn拿档口商品数量
            shop.setItemNum(shopForCdnService.selItemNumberById(o.getShopId(),o.getWebSite()).intValue());
            //从缓存拿星星数
            shop.setStarNum(shopForCdnService.selShopStarById(o.getShopId()).toString());
            return shop;
        }).collect(Collectors.toList()));
        resp.setTotal(shopCollectVOShiguPager.getTotalCount());
        resp.setHasNext(shopCollectVOShiguPager.getNumber()<shopCollectVOShiguPager.getTotalPages());
        resp.setSuccess(true);
        return resp;
    }

    /**
     * 收藏OR取消收藏店铺
     *
     * @param request
     * @return
     */
    public DoStoreCollectResponse doStoreCollect(DoStoreCollectRequest request) {
        DoStoreCollectResponse resp = new DoStoreCollectResponse();
        if (!registerAndLoginService.checkToken(request.getUserId(), request.getToken())) {
            resp.setSuccess(false);
            return resp;
        }
        if (request.getYesOrNo()) {
            try {
                addShopCollection(request);
            } catch (ShopCollectionException e) {
                resp.setException(new OpenException());
            }
        } else {
            delShopCollection(request);
        }
        resp.setSuccess(true);
        return resp;
    }

    /**
     * 删除店铺收藏
     *
     * @param request
     * @return
     */
    private void delShopCollection(DoStoreCollectRequest request) {
        userCollectService.delShopCollectionByShopIds(request.getUserId(), Lists.newArrayList(request.getShopId()));
    }

    /**
     * 添加店铺收藏
     *
     * @param request
     * @throws ShopCollectionException
     */
    private void addShopCollection(DoStoreCollectRequest request) throws ShopCollectionException {
        ScStoreBO bo = new ScStoreBO();
        bo.setStore_id(request.getShopId());
        cdnService.addShopCollect(request.getUserId(), bo);
    }
}
