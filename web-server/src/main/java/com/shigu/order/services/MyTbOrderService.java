package com.shigu.order.services;

import com.opentae.core.mybatis.utils.FieldUtil;
import com.opentae.data.mall.beans.OrderCity;
import com.opentae.data.mall.beans.OrderProv;
import com.opentae.data.mall.beans.OrderTown;
import com.opentae.data.mall.examples.OrderCityExample;
import com.opentae.data.mall.examples.OrderProvExample;
import com.opentae.data.mall.examples.OrderTownExample;
import com.opentae.data.mall.interfaces.OrderCityMapper;
import com.opentae.data.mall.interfaces.OrderProvMapper;
import com.opentae.data.mall.interfaces.OrderTownMapper;
import com.shigu.main4.common.tools.ShiguPager;
import com.shigu.main4.common.util.BeanMapper;
import com.shigu.main4.common.util.DateUtil;
import com.shigu.main4.common.util.UUIDGenerator;
import com.shigu.main4.item.enums.SearchOrderBy;
import com.shigu.main4.item.services.ItemAddOrUpdateService;
import com.shigu.main4.item.services.ItemSearchService;
import com.shigu.main4.item.vo.SearchItem;
import com.shigu.main4.item.vo.ShiguAggsPager;
import com.shigu.main4.item.vo.SynItem;
import com.shigu.main4.order.bo.TbOrderBO;
import com.shigu.main4.order.exceptions.NotFindRelationGoodsException;
import com.shigu.main4.order.exceptions.NotFindSessionException;
import com.shigu.main4.order.process.ItemProductProcess;
import com.shigu.main4.order.servicevo.SubTbOrderVO;
import com.shigu.main4.order.servicevo.TbOrderVO;
import com.shigu.main4.order.vo.*;
import com.shigu.main4.order.zfenums.TbOrderStatusEnum;
import com.shigu.main4.storeservices.StoreRelationService;
import com.shigu.main4.tools.RedisIO;
import com.shigu.main4.tools.SpringBeanFactory;
import com.shigu.main4.vo.StoreRelation;
import com.shigu.order.OrderSubmitType;
import com.shigu.order.vo.OrderSubmitVo;
import com.shigu.order.vo.TbOrderAddressInfoVO;
import com.shigu.order.vo.TinyVO;
import com.shigu.zf.utils.PriceConvertUtils;
import com.shigu.zf.utils.SimilarityMap;
import com.taobao.api.security.SecurityBiz;
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
    @Autowired
    ItemAddOrUpdateService itemAddOrUpdateService;
    @Autowired
    private ConfirmOrderService confirmOrderService;

    @Autowired
    private ItemProductProcess itemProductProcess;
    @Autowired
    private RedisIO redisIO;



    private static SimilarityMap<OrderProv> similarityProvMap;
    private static SimilarityMap<OrderCity> similarityCityMap;
    private static SimilarityMap<OrderTown> similarityTownMap;


    public ShiguPager<TbOrderVO> myTbOrders(Long userId,Long orderId, Integer page,Integer size, String startTime, String endTime) {
        String sessionKey;
        SecurityBiz.getSeparatorCharMap();
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
                        TinyVO rgv=taoOrderService.selSourceGoodsByNumIid(subvo.getNumiid());
                        if (rgv != null) {
                            subvo.setGoodsNo(rgv.getGoodsNo());
                            subvo.setXzPrice(rgv.getPiPriceString());
                            subvo.setWebSite(rgv.getWebSite());
                            lr+= subvo.getNewTbPriceLong()-rgv.getPiPrice();
                        }
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
        ShiguAggsPager pager= itemSearchService.searchItem(keyword,webSite,null, null,null,null,null,null,null,null,null, SearchOrderBy.COMMON,page,size,false);
        ShiguPager<GoodsVO> vo=new ShiguPager<>();
        List<GoodsVO> gs=new ArrayList<>();
        for(SearchItem pa:pager.getContent()){
            GoodsVO g=new GoodsVO();
            g.setTitle(pa.getTitle());
            g.setPrice(pa.getPrice());
            StoreRelation shop=storeRelationService.selRelationById(pa.getStoreId());
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

    public void glGoodsJson(Long numIid,Long goodsId,Long userId) throws NotFindRelationGoodsException {
        taoOrderService.glGoodsJson(numIid,goodsId,userId);
    }

    public String submitTbOrders(Long tid,Long userId) throws NotFindSessionException, NotFindRelationGoodsException {
        String sessionKey = taoOrderService.myTbSessionKey(userId);
        TbOrderVO order=taoOrderService.myTbOrder(tid,TbOrderStatusEnum.WAIT_SELLER_SEND_GOODS,sessionKey);
        List<CartVO> cartVOS = new ArrayList<>();
        for(int i=0;i<order.getChildOrders().size();i++){
            SubTbOrderVO sub=order.getChildOrders().get(i);
            TinyVO rgv=taoOrderService.selSourceGoodsByNumIid(sub.getNumiid());
            SynItem goods=itemAddOrUpdateService.selItemByGoodsId(rgv.getGoodsId(),rgv.getWebSite());
            ItemProductVO info = itemProductProcess.generateProduct(rgv.getGoodsId(), sub.getColor(), sub.getSize());
            CartVO vo=new CartVO();
            vo.setNum(sub.getNum());
            vo.setUserId(userId);
            vo.setSkuId(info.getSelectiveSku().getSkuId());
            vo.setShopId(goods.getShopId());
            vo.setMarketId(goods.getMarketId());
            vo.setMarketName(info.getMarketName());
            vo.setSelectiveSku(BeanMapper.map(info, ItemSkuVO.class));
            vo.setShopNum(info.getShopNum());
            vo.setFloor(info.getFloor());
            vo.setFloorId(goods.getFloorId());
            vo.setGoodsId(goods.getGoodsId());
            vo.setGoodsNo(goods.getGoodsNo());
            vo.setPicUrl(goods.getPicUrl());
            vo.setPid(info.getPid());
            vo.setPrice(PriceConvertUtils.StringToLong(goods.getPiPriceString()));
            vo.setTitle(goods.getTitle());
            vo.setWebSite(goods.getWebSite());
            vo.setWeight(info.getWeight());
            vo.setCartId(i-goods.getGoodsId());
            cartVOS.add(vo);
        }
        String uuid = UUIDGenerator.getUUID();

        OrderSubmitVo submitVo = new OrderSubmitVo();
        submitVo.setUserId(userId);
        submitVo.setSubmitType(OrderSubmitType.CART);
        submitVo.setProducts(cartVOS);
        submitVo.setOuterOrderNo(order.getTbId()+"");
        submitVo.setAddress(order.getAddress());
        //获取淘宝地址缓存信息
        TbOrderAddressInfoVO addressVO=new TbOrderAddressInfoVO();
        addressVO.setAllAddressInfo(order.getAddress());
        addressVO.setId(tid);
        addressVO.setProv(order.getProv());
        addressVO.setName(order.getReceiverName());
        SimilarityMap<OrderProv> provmap = similarityProvMap();
        SimilarityMap<OrderCity> citymap = similarityCityMap();
        SimilarityMap<OrderTown> townmap = similarityTownMap();
        OrderProv prov=provmap.get(order.getProv());
        OrderCity city=citymap.get(order.getCity());
        OrderTown town=townmap.get(order.getTown());
        BuyerAddressVO buyerAddress = new BuyerAddressVO();
        buyerAddress.setAddress(order.getSimpleAddress());
        if (city != null) {
            buyerAddress.setCityId(city.getCityId());
            buyerAddress.setCity(city.getCityName());
        }
        buyerAddress.setName(order.getReceiverName());
        if (prov != null) {
            buyerAddress.setProvId(prov.getProvId());
            buyerAddress.setProvince(prov.getProvName());
        }
        buyerAddress.setTelephone(order.getReceiverPhone());
        if (town != null) {
            buyerAddress.setTownId(town.getTownId());
            buyerAddress.setTown(town.getTownName());
        }
        buyerAddress.setUserId(userId);
        String addressId = confirmOrderService.saveTmpBuyerAddress(buyerAddress);
        addressVO.setAddressId(addressId);

        submitVo.setTbOrderAddressInfo(addressVO);
        redisIO.putTemp(uuid, submitVo, 600);
        return uuid;
    }


    private static SimilarityMap<OrderProv> similarityProvMap(){
        if(similarityProvMap==null){
            similarityProvMap=new SimilarityMap<OrderProv>();
            OrderProvMapper orderProvMapper=SpringBeanFactory.getBean(OrderProvMapper.class);
            OrderProvExample example1 = new OrderProvExample();
            List<OrderProv> provs = orderProvMapper.selectFieldsByExample(example1, FieldUtil.codeFields("prov_id,prov_name"));
            for (OrderProv p : provs) {
                similarityProvMap.put(p.getProvName(), p);
            }
        }
        return similarityProvMap;
    }
    private static SimilarityMap<OrderCity> similarityCityMap(){
        if(similarityCityMap==null){
            similarityCityMap=new SimilarityMap<OrderCity>();
            OrderCityMapper orderCityMapper=SpringBeanFactory.getBean(OrderCityMapper.class);
            OrderCityExample example2 = new OrderCityExample();
            List<OrderCity> citys = orderCityMapper.selectFieldsByExample(example2, FieldUtil.codeFields("city_id,city_name"));
            for (OrderCity c : citys) {
                similarityCityMap.put(c.getCityName(), c);
            }
        }
        return similarityCityMap;
    }
    private static SimilarityMap<OrderTown> similarityTownMap(){
        if(similarityTownMap==null){
            similarityTownMap=new SimilarityMap<OrderTown>();
            OrderTownMapper orderTownMapper=SpringBeanFactory.getBean(OrderTownMapper.class);
            OrderTownExample example2 = new OrderTownExample();
            List<OrderTown> towns = orderTownMapper.selectFieldsByExample(example2, FieldUtil.codeFields("town_id,town_name"));
            for (OrderTown t : towns) {
                similarityTownMap.put(t.getTownName(), t);
            }
        }
        return similarityTownMap;
    }
}
