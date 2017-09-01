package com.shigu.phone.services;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.aliyun.opensearch.sdk.dependencies.com.google.common.collect.Lists;
import com.openJar.beans.app.AppGoodsBlock;
import com.openJar.beans.app.AppItemKv;
import com.openJar.exceptions.OpenException;
import com.openJar.requests.app.DoStoreCollectRequest;
import com.openJar.requests.app.ImgSearchRequest;
import com.openJar.requests.app.ItemSearchRequest;
import com.openJar.requests.app.OneItemRequest;
import com.openJar.responses.app.DoStoreCollectResponse;
import com.openJar.responses.app.ImgSearchResponse;
import com.openJar.responses.app.ItemSearchResponse;
import com.openJar.responses.app.OneItemResponse;
import com.shigu.main4.cdn.bo.ScStoreBO;
import com.shigu.main4.cdn.exceptions.CdnException;
import com.shigu.main4.cdn.services.CdnService;
import com.shigu.main4.common.tools.ShiguPager;
import com.shigu.main4.common.util.BeanMapper;
import com.shigu.main4.common.util.DateUtil;
import com.shigu.main4.item.enums.SearchOrderBy;
import com.shigu.main4.newcdn.vo.CdnGoodsInfoVO;
import com.shigu.main4.newcdn.vo.CdnShopInfoVO;
import com.shigu.main4.ucenter.services.UserCollectService;
import com.shigu.main4.ucenter.vo.ShopCollect;
import com.shigu.search.bo.SearchBO;
import com.shigu.search.services.GoodsSearchService;
import com.shigu.search.vo.GoodsInSearch;
import freemarker.template.TemplateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 类名：PhoneGoodsSearchService
 * 类路径：com.shigu.phone.services.PhoneGoodsSearchService
 * 创建者：王浩翔
 * 创建时间：2017-08-29 14:35
 * 项目：main-pom
 * 描述：移动端商品搜索service
 */
@Service
public class PhoneGoodsSearchService {

    @Autowired
    private GoodsSearchService goodsSearchService;

    @Autowired
    private CdnService cdnService;

    /**
     * 移动端商品搜索
     *
     * @param request
     * @return
     */
    public ItemSearchResponse itemSearch(ItemSearchRequest request) {
        ItemSearchResponse resp = new ItemSearchResponse();
        SearchBO bo = new SearchBO();
        bo.setWebSite(request.getWebSite());
        bo.setKeyword(request.getKeyword());
        bo.setMid(request.getMarketId());
        bo.setCid(request.getCid());
        bo.setPid(request.getCid());
        bo.setShopId(request.getStoreId());
        if (request.getType() == 2) {
            //商品库搜索顺序
            bo.setFrom("goods");
        }
        bo.setSort(request.getOrderBy());
        final String dateFormat = "yyyy.MM.dd";
        bo.setSt(request.getStartTime() == null ? null : DateUtil.dateToString(request.getStartTime(), dateFormat));
        bo.setEt(request.getEndTime() == null ? null : DateUtil.dateToString(request.getEndTime(), dateFormat));
        bo.setSp(request.getStartPrice() == null ? null : Double.valueOf(request.getStartPrice()));
        bo.setEp(request.getEndPrice() == null ? null : Double.valueOf(request.getEndPrice()));
        bo.setPage(request.getIndex());
        bo.setRows(request.getSize());
        ShiguPager<GoodsInSearch> result = goodsSearchService.search(bo, SearchOrderBy.valueIs(request.getOrderBy()), false).getSearchData();
        resp.setTotal(result.getTotalCount());
        resp.setHasNext(result.getNumber() < result.getTotalPages());
        resp.setItems(result.getContent().parallelStream().map(o -> {
            AppGoodsBlock vo = BeanMapper.map(o, AppGoodsBlock.class);
            vo.setGoodsId(Long.valueOf(o.getId()));
            return vo;
        }).collect(Collectors.toList()));
        resp.setSuccess(true);
        return resp;
    }

    /**
     * 移动端图搜
     *
     * @param request
     * @return
     */
    public ImgSearchResponse imgSearch(ImgSearchRequest request) {
        ImgSearchResponse resp = new ImgSearchResponse();
        try {
            resp.setItems(goodsSearchService.searchByPic(request.getImgurl(), request.getWebSite()).parallelStream().map(o -> {
                AppGoodsBlock vo = BeanMapper.map(o, AppGoodsBlock.class);
                vo.setGoodsId(Long.valueOf(o.getId()));
                return vo;
            }).collect(Collectors.toList()));
            resp.setSuccess(true);
        } catch (IOException e) {
            resp.setException(new OpenException());
        }
        return resp;
    }

    /**
     * app单商品信息
     * @param request
     * @return
     */
    public OneItemResponse oneItem(OneItemRequest request) {
        OneItemResponse resp = new OneItemResponse();
        try {
            //商品数据填充
            CdnGoodsInfoVO goods = cdnService.cdnGoodsInfo(request.getItemId());
            resp.setGoodsId(goods.getGoodsId());
            resp.setGoodsNo(goods.getGoodsNo());
            resp.setPrice(goods.getPiPrice());
            resp.setTitle(goods.getTitle());
            resp.setCreateTime(DateUtil.stringToDate(goods.getPostTime(), DateUtil.patternA));
            resp.setImgSrcs(goods.getImgUrls());
            resp.setGoodsLicenses(goods.getServices());
            resp.setColors(JSONArray.parseArray(goods.getColorsMeta()).parallelStream().map(o -> {
                JSONObject color = (JSONObject) o;
                return color.get("text").toString();
            }).collect(Collectors.toList()));
            resp.setSize(JSONArray.parseArray(goods.getSizesMeta()).parallelStream().map(Object::toString).collect(Collectors.toList()));
            resp.setItemKvs(goods.getNormalAttrs().parallelStream().map(o -> {
                AppItemKv itemKv = new AppItemKv();
                itemKv.setKey(o.getName());
                itemKv.setValue(o.getValue());
                return itemKv;
            }).collect(Collectors.toList()));
            //店铺数据填充
            CdnShopInfoVO shop = cdnService.cdnShopInfo(goods.getShopId());
            resp.setStoreId(goods.getShopId());
            resp.setStoreNum(shop.getShopNo());
            resp.setMarket(shop.getMarketName());
            resp.setStarNum(shop.getStarNum().intValue());
            resp.setShopHeadUrl(shop.getImgsrc());
            resp.setSuccess(true);
        } catch (CdnException | TemplateException | IOException e) {
            resp.setException(new OpenException());
        }
        return resp;
    }


}
