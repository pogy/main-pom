package com.shigu.order.services;

import com.shigu.main4.common.tools.ShiguPager;
import com.shigu.main4.common.util.DateUtil;
import com.shigu.main4.item.enums.SearchOrderBy;
import com.shigu.main4.item.services.ItemSearchService;
import com.shigu.main4.item.vo.SearchItem;
import com.shigu.main4.item.vo.ShiguAggsPager;
import com.shigu.main4.order.bo.TbOrderBO;
import com.shigu.main4.order.zfenums.TbOrderStatusEnum;
import com.shigu.main4.order.exceptions.NotFindRelationGoodsException;
import com.shigu.main4.order.exceptions.NotFindSessionException;
import com.shigu.main4.order.services.TaoOrderService;
import com.shigu.main4.order.servicevo.RelationGoodsVO;
import com.shigu.main4.order.servicevo.SubTbOrderVO;
import com.shigu.main4.order.servicevo.TbOrderVO;
import com.shigu.main4.order.utils.PriceConvertUtils;
import com.shigu.main4.order.vo.GoodsVO;
import com.shigu.main4.storeservices.StoreRelationService;
import com.shigu.main4.vo.StoreRelation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by zf on 2017/7/21.
 */
@Service("tae_myTbOrderService")
public class MyTbOrderService {
    @Autowired
    TaoOrderService taoOrderService;
    @Autowired
    ItemSearchService itemSearchService;
    @Autowired
    StoreRelationService storeRelationService;

    public ShiguPager<TbOrderVO> myTbOrders(Long userId,Long orderId, Integer page,Integer size, String startTime, String endTime) {
        String sessionKey;
        try {
            sessionKey = taoOrderService.myTbSessionKey(userId);
        } catch (NotFindSessionException e) {
            return new ShiguPager<>();
        }
        if(orderId!=null){
            ShiguPager<TbOrderVO> v=new ShiguPager<>();
            TbOrderVO vo=taoOrderService.myTbOrder(orderId,TbOrderStatusEnum.WAIT_SELLER_SEND_GOODS,sessionKey);
            List<TbOrderVO> list=new ArrayList<>();
            if(vo!=null){
                list.add(vo);
            }
            v.setContent(list);
            v.setNumber(page);
            v.calPages(list.size(),size);
            return v;
        }
        TbOrderBO bo = new TbOrderBO();
        bo.setPage(page);
        bo.setPageSize(size);
        bo.setStatus(TbOrderStatusEnum.WAIT_SELLER_SEND_GOODS);
        Date st = null;
        Date et = null;
        if (!StringUtils.isEmpty(startTime)) {
            st = DateUtil.stringToDate(startTime, DateUtil.patternA);
        }
        if (!StringUtils.isEmpty(endTime)) {
            et = DateUtil.stringToDate(endTime, DateUtil.patternA);
        }
        bo.setEndTime(et);
        bo.setStartTime(st);
        ShiguPager<TbOrderVO> tvo=taoOrderService.myTbOrders(bo,sessionKey);
        List<TbOrderVO> vos=tvo.getContent();
        for(TbOrderVO vo:vos){
            vo.setCanOrder(true);
            vo.setProfits(null);
            Long lr=0l;
            for(SubTbOrderVO subvo:vo.getChildOrders()){
                if(StringUtils.isEmpty(subvo.getGoodsNo())){
                    try {
                        RelationGoodsVO rgv=taoOrderService.glGoodsJson(subvo.getNumiid());
                        subvo.setGoodsNo(rgv.getGoodsNo());
                        subvo.setXzPrice(rgv.getPrice());
                        lr+= subvo.getNewTbPriceLong()-rgv.getPriceLong();
                    } catch (NotFindRelationGoodsException e) {
                        vo.setCanOrder(false);
                    }
                }
            }
            if(vo.isCanOrder()){
                vo.setProfits(PriceConvertUtils.priceToString(lr));
            }
        }
        return tvo;
    }

    public ShiguPager<GoodsVO> selectglGoods(String keyword,String webSite, Integer page, Integer size){
        ShiguAggsPager pager= itemSearchService.searchItem(keyword,webSite,null,null,null,null,null,null,null,null, SearchOrderBy.COMMON,page,size,false);
        ShiguPager<GoodsVO> vo=new ShiguPager<>();
        List<GoodsVO> gs=new ArrayList<>();
        for(SearchItem pa:pager.getContent()){
            GoodsVO g=new GoodsVO();
            g.setTitle(pa.getTitle());
            g.setPrice(pa.getPrice());
            StoreRelation shop=storeRelationService.selRelationById(pa.getItemId());
            g.setStoreNum(shop.getStoreNum());
            g.setMarketName(shop.getMarketName());
            g.setImgSrc(pa.getPicUrl());
            g.setId(pa.getItemId());
            g.setGoodsNo(pa.getGoodsNo());
            gs.add(g);
        }
        vo.setTotalPages(pager.getTotalPages());
        vo.setContent(gs);
        vo.setTotalCount(pager.getTotalCount());
        vo.setNumber(pager.getNumber());
        return vo;
    }

    public void glGoodsJson(Long numIid,Long goodsId) throws NotFindRelationGoodsException {
        taoOrderService.glGoodsJson(numIid,goodsId);
    }
}
