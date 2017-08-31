package com.shigu.phone.services;

import com.openJar.beans.app.AppShopBlock;
import com.openJar.requests.app.ShopSearchRequest;
import com.openJar.responses.app.ShopSearchResponse;
import com.shigu.main4.common.tools.ShiguPager;
import com.shigu.search.bo.StorenumBO;
import com.shigu.search.services.StoreSelFromEsService;
import com.shigu.search.vo.StoreInSearch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

/**
 * 类名：PhoneSearchService
 * 类路径：com.shigu.phone.services.PhoneSearchService
 * 创建者：王浩翔
 * 创建时间：2017-08-29 14:35
 * 项目：main-pom
 * 描述：移动端搜索service
 */
@Service
public class PhoneSearchService {

    @Autowired
    private StoreSelFromEsService storeSelFromEsService;

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
}
