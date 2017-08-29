package com.shigu.phone.services;

import com.openJar.beans.app.AppGoodsBlock;
import com.openJar.exceptions.OpenException;
import com.openJar.requests.app.ImgSearchRequest;
import com.openJar.requests.app.ItemSearchRequest;
import com.openJar.responses.app.ImgSearchResponse;
import com.openJar.responses.app.ItemSearchResponse;
import com.shigu.main4.common.tools.ShiguPager;
import com.shigu.main4.common.util.BeanMapper;
import com.shigu.main4.common.util.DateUtil;
import com.shigu.main4.item.enums.SearchOrderBy;
import com.shigu.search.bo.SearchBO;
import com.shigu.search.services.GoodsSearchService;
import com.shigu.search.vo.GoodsInSearch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
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

    /**
     * 移动端商品搜索
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
        if (request.getType()==2) {
            //商品库搜索顺序
            bo.setFrom("goods");
        }
        bo.setSort(request.getOrderBy());
        final String dateFormat = "yyyy.MM.dd";
        bo.setSt(request.getStartTime()==null?null:DateUtil.dateToString(request.getStartTime(),dateFormat));
        bo.setEt(request.getEndTime()==null?null:DateUtil.dateToString(request.getEndTime(),dateFormat));
        bo.setSp(request.getStartPrice()==null?null:Double.valueOf(request.getStartPrice()));
        bo.setEp(request.getEndPrice()==null?null:Double.valueOf(request.getEndPrice()));
        bo.setPage(request.getIndex());
        bo.setRows(request.getSize());
        ShiguPager<GoodsInSearch> result = goodsSearchService.search(bo, SearchOrderBy.valueIs(request.getOrderBy()), false).getSearchData();
        resp.setTotal(result.getTotalCount());
        resp.setHasNext(result.getNumber()<result.getTotalPages());
        resp.setItems(result.getContent().parallelStream().map(o->{
            AppGoodsBlock vo = BeanMapper.map(o, AppGoodsBlock.class);
            vo.setGoodsId(Long.valueOf(o.getId()));
            return vo;
        }).collect(Collectors.toList()));
        resp.setSuccess(true);
        return resp;
    }

    /**
     * 移动端图搜
     * @param request
     * @return
     */
    public ImgSearchResponse imgSearch(ImgSearchRequest request) {
        ImgSearchResponse resp = new ImgSearchResponse();
        try {
            resp.setItems(goodsSearchService.searchByPic(request.getImgurl(),request.getWebSite()).parallelStream().map(o->{
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
}
