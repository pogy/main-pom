package com.shigu.order.services;

import com.opentae.core.mybatis.example.MultipleExample;
import com.opentae.core.mybatis.example.MultipleExampleBuilder;
import com.opentae.core.mybatis.mapper.MultipleMapper;
import com.opentae.core.mybatis.utils.FieldUtil;
import com.opentae.data.mall.beans.*;
import com.opentae.data.mall.examples.*;
import com.opentae.data.mall.interfaces.*;
import com.shigu.main4.common.exceptions.JsonErrException;
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
import com.shigu.order.exceptions.OrderException;
import com.shigu.order.vo.*;
import com.shigu.tools.JsonResponseUtil;
import com.shigu.zf.utils.PriceConvertUtils;
import com.shigu.zf.utils.SimilarityMap;
import com.taobao.api.security.SecurityBiz;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.*;
import java.util.stream.Collectors;

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
    private ShiguGoodsTinyMapper shiguGoodsTinyMapper;
    @Autowired
    private RedisIO redisIO;

    @Autowired
    private MultipleMapper multipleMapper;
    @Autowired
    private ItemOrderMapper itemOrderMapper;



    private static SimilarityMap<OrderProv> similarityProvMap;
    private static SimilarityMap<OrderCity> similarityCityMap;
    private static SimilarityMap<OrderTown> similarityTownMap;


    public MyTbOrderVO<TbOrderVO> myTbOrders(Long userId,Long orderId, Integer page,Integer size, String startTime, String endTime) {
        String sessionKey;
        SecurityBiz.getSeparatorCharMap();
        try {
            sessionKey = taoOrderService.myTbSessionKey(userId);
        } catch (NotFindSessionException e) {
            return new MyTbOrderVO();
        }
        int notLinkNum=0;
        MyTbOrderVO<TbOrderVO> v=new MyTbOrderVO<>();
        if(orderId!=null){
            TbOrderVO vo=taoOrderService.myTbOrder(orderId,TbOrderStatusEnum.WAIT_SELLER_SEND_GOODS,sessionKey);
            List<TbOrderVO> list=new ArrayList<>();
            if(vo!=null){
                vo.setXzUserId(userId);
                notLinkNum+=linkGoodsNo(vo);
                list.add(vo);
            }
            v.setNotLinkNum(notLinkNum);
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
            vo.setXzUserId(userId);
            notLinkNum+=linkGoodsNo(vo);
        }
        v.setContent(tvo.getContent());
        v.setNumber(page);
        v.setTotalCount(tvo.getTotalCount());
        v.setTotalPages(tvo.getTotalPages());
        v.setNotLinkNum(notLinkNum);
        return v;
    }

    public ShiguPager<GoodsVO> selectglGoods(String keyword,String webSite, Integer page, Integer size){
        //查出支持的几个市场
        ItemTradeForbidExample forbidExample=new ItemTradeForbidExample();
        ShiguMarketExample marketExample=new ShiguMarketExample();
        MultipleExample multipleExample=MultipleExampleBuilder.from(marketExample).leftJoin(forbidExample)
                .on(forbidExample.createCriteria().equalTo(ItemTradeForbidExample.targetId,ShiguMarketExample.marketId)
                .andTypeEqualTo(1)).where(marketExample.createCriteria().andIsParentEqualTo(1L).andWebSiteEqualTo(webSite),forbidExample.createCriteria().andForbidIdIsNull()).build();
        List<OnsaleMarket> onsaleMarkets=multipleMapper.selectFieldsByMultipleExample(multipleExample,OnsaleMarket.class);
        List<Long> mids=onsaleMarkets.stream().map(OnsaleMarket::getMarketId).collect(Collectors.toList());
        ShiguAggsPager pager= itemSearchService.searchForTbItem(keyword,webSite,mids, SearchOrderBy.COMMON,page,size);
        ShiguPager<GoodsVO> vo=new ShiguPager<>();
        List<GoodsVO> gs=new ArrayList<>();
        List<Long> ids=new ArrayList<>();
        Map<Long,GoodsVO> map=new HashMap<>();
        for(SearchItem pa:pager.getContent()){
            GoodsVO g=new GoodsVO();
            g.setTitle(pa.getTitle());
            g.setPrice(pa.getPrice());
            StoreRelation shop=storeRelationService.selRelationById(pa.getStoreId());
            g.setStoreNum(shop.getStoreNum());
            g.setMarketName(shop.getMarketName());
            g.setImgSrc(pa.getPicUrl());
            g.setId(pa.getItemId());
//            g.setGoodsNo(pa.getGoodsNo());//搜索中其实没有货号
            gs.add(g);
            ids.add(pa.getItemId());
            map.put(pa.getItemId(),g);
        }

        if (ids.size()>0) {
            ShiguGoodsTinyExample example=new ShiguGoodsTinyExample();
            example.createCriteria().andGoodsIdIn(ids);
            example.setWebSite(webSite);
            List<ShiguGoodsTiny> tinys=shiguGoodsTinyMapper.selectFieldsByExample(example,FieldUtil.codeFields("goods_id,goods_no"));
            for(ShiguGoodsTiny tiny:tinys){
                map.get(tiny.getGoodsId()).setGoodsNo(tiny.getGoodsNo());
            }
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

    public String submitTbOrders(Long tid,Long userId) throws NotFindRelationGoodsException, OrderException {
//        String sessionKey = taoOrderService.myTbSessionKey(userId);
//        TbOrderVO order=taoOrderService.myTbOrder(tid,TbOrderStatusEnum.WAIT_SELLER_SEND_GOODS,sessionKey);
        TbOrderVO order=redisIO.get("tbOrder"+tid,TbOrderVO.class);
        if(order == null){
            throw new OrderException("操作超时,请刷新重试!");
        }
        if(order.getXzUserId().longValue()!=userId){
            throw new OrderException("非法请求");
        }
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
            ItemSkuVO itemSkuVO=BeanMapper.map(info, ItemSkuVO.class);
            itemSkuVO.setSkuId(info.getSelectiveSku().getSkuId());
            vo.setSelectiveSku(itemSkuVO);
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
        if (prov != null) {
            buyerAddress.setProvId(prov.getProvId());
            buyerAddress.setProvince(prov.getProvName());
        }
        if (city != null) {
            buyerAddress.setCityId(city.getCityId());
            buyerAddress.setCity(city.getCityName());
        }
        if (town != null) {
            buyerAddress.setTownId(town.getTownId());
            buyerAddress.setTown(town.getTownName());
        }
        buyerAddress.setName(order.getReceiverName());
        buyerAddress.setTelephone(order.getReceiverPhone());
        buyerAddress.setAddress(order.getSimpleAddress());
        buyerAddress.setUserId(userId);
        String addressId = confirmOrderService.saveTmpBuyerAddress(buyerAddress);
        addressVO.setAddressId(addressId);

        submitVo.setTbOrderAddressInfo(addressVO);
        redisIO.putTemp(uuid, submitVo, 600);
        return uuid;
    }

    /**
     * 淘宝批量下单,包含校验
     * 校验失败,按失败类型返回不同的id集合
     * 校验成功,返回code
     * @param tids
     * @param userId
     * @param repeatIs
     * @return
     * @throws NotFindSessionException
     * @throws NotFindRelationGoodsException
     * @throws OrderException
     */
    public JSONObject submitMoreTbOrders(List<String> tids, Long userId, boolean repeatIs) throws JsonErrException {
        List<Long> fdlProvIds= Arrays.asList(33L,34L,35L);
        List<String> noGoodsNoTids=new ArrayList<>();
        List<Long> noGoodsNoNumiids=new ArrayList<>();

        List<String> errorAddressTids=new ArrayList<>();
        List<String> otherIds=new ArrayList<>();

        Map<String,BuyerAddressVO> addsMap=new HashMap<>();

        List<OrderSubmitVo> orderSubmitVos=new ArrayList<>();

        Map<Long,TinyVO> tinyVOMap=new HashMap<>();
        Map<String,SynItem> synItemMap=new HashMap<>();
        Map<String,ItemProductVO> itemProductVOMap =new HashMap<>();

        for(String tid:tids){
            TbOrderVO order=redisIO.get("tbOrder"+tid,TbOrderVO.class);
            if (order == null) {
                continue ;
            }
            if(order.getXzUserId().longValue()!=userId){
                throw new JsonErrException("非法请求");
            }
            otherIds.add(order.getTbId());
            List<CartVO> cartVOS = new ArrayList<>();
            for(int i=0;i<order.getChildOrders().size();i++){
                SubTbOrderVO sub=order.getChildOrders().get(i);
                //商品是否已经确定未关联,如果是则continue,减少后续操作
                if(noGoodsNoNumiids.contains(sub.getNumiid())){
                    continue;
                }
                //校验关联
                TinyVO rgv=tinyVOMap.get(sub.getNumiid());
                if(rgv==null){
                    try {
                        rgv=taoOrderService.selSourceGoodsByNumIid(sub.getNumiid());
                        if(rgv==null){
                            noGoodsNoTids.add(order.getTbId());
                            noGoodsNoNumiids.add(sub.getNumiid());
                            continue;
                        }
                    } catch (NotFindRelationGoodsException e) {
                        noGoodsNoTids.add(order.getTbId());
                        noGoodsNoNumiids.add(sub.getNumiid());
                        continue;
                    }
                    tinyVOMap.put(sub.getNumiid(),rgv);
                }
                //如果存在校验失败的订单,则之后的循环不再进行包装cart对象,减少操作
                if(noGoodsNoTids.size()==0&&errorAddressTids.size()==0){
                    SynItem goods=synItemMap.get(rgv.getGoodsId()+rgv.getWebSite());
                    if(goods==null){
                        goods=itemAddOrUpdateService.selItemByGoodsId(rgv.getGoodsId(),rgv.getWebSite());
                        synItemMap.put(rgv.getGoodsId()+rgv.getWebSite(),goods);
                    }
                    ItemProductVO info = itemProductVOMap.get(rgv.getGoodsId()+sub.getColor()+sub.getSize());
                    if(info==null){
                        info=itemProductProcess.generateProduct(rgv.getGoodsId(), sub.getColor(), sub.getSize());
                        itemProductVOMap.put(rgv.getGoodsId()+sub.getColor()+sub.getSize(),info);
                    }
                    CartVO vo=new CartVO();
                    vo.setNum(sub.getNum());
                    vo.setUserId(userId);
                    vo.setSkuId(info.getSelectiveSku().getSkuId());
                    vo.setShopId(goods.getShopId());
                    vo.setMarketId(goods.getMarketId());
                    vo.setMarketName(info.getMarketName());
                    ItemSkuVO itemSkuVO=BeanMapper.map(info, ItemSkuVO.class);
                    itemSkuVO.setSkuId(info.getSelectiveSku().getSkuId());
                    vo.setSelectiveSku(itemSkuVO);
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
            }
            OrderSubmitVo submitVo = new OrderSubmitVo();
            submitVo.setUserId(userId);
            submitVo.setSubmitType(OrderSubmitType.CART);
            submitVo.setProducts(cartVOS);
            submitVo.setOuterOrderNo(order.getTbId());
            submitVo.setAddress(order.getAddress());
            //获取淘宝地址缓存信息
            TbOrderAddressInfoVO addressVO=new TbOrderAddressInfoVO();
            addressVO.setAllAddressInfo(order.getAddress());
            addressVO.setId(new Long(order.getTbId()));
            addressVO.setProv(order.getProv());
            addressVO.setName(order.getReceiverName());
            SimilarityMap<OrderProv> provmap = similarityProvMap();
            SimilarityMap<OrderCity> citymap = similarityCityMap();
            SimilarityMap<OrderTown> townmap = similarityTownMap();
            OrderProv prov=provmap.get(order.getProv());
            OrderCity city=citymap.get(order.getCity());
            OrderTown town=townmap.get(order.getTown());
            BuyerAddressVO buyerAddress = new BuyerAddressVO();
            if (prov != null && !fdlProvIds.contains(prov.getProvId())) {
                buyerAddress.setProvId(prov.getProvId());
                buyerAddress.setProvince(prov.getProvName());
            }else{
                errorAddressTids.add(order.getTbId());
            }
            if (city != null) {
                buyerAddress.setCityId(city.getCityId());
                buyerAddress.setCity(city.getCityName());
            }else{
                errorAddressTids.add(order.getTbId());
            }
            if(errorAddressTids.size()!=0){
                continue ;
            }
            if (town != null) {
                buyerAddress.setTownId(town.getTownId());
                buyerAddress.setTown(town.getTownName());
            }
            buyerAddress.setName(order.getReceiverName());
            buyerAddress.setTelephone(order.getReceiverPhone());
            buyerAddress.setAddress(order.getSimpleAddress());
            buyerAddress.setUserId(userId);
            addsMap.put(order.getTbId(),buyerAddress);
            submitVo.setTbOrderAddressInfo(addressVO);
            orderSubmitVos.add(submitVo);
        }
        if(otherIds.size()==0){
            throw new JsonErrException("操作超时,请刷新重试!");
        }

        if(noGoodsNoTids.size()!=0){
            // 存在没关联的商品
            JSONObject obj= new JSONObject();
            obj.put("result","error");
            obj.put("noGoodsNoTids",noGoodsNoTids);
            obj.put("noGoodsNoNum",noGoodsNoNumiids.size());
            return obj;
        }



        if(errorAddressTids.size()!=0){
            // 存在错误地址的商品
            List<String> leftIds=new ArrayList<>(otherIds);
            leftIds.removeIf(errorAddressTids::contains);
            JSONObject obj= new JSONObject();
            obj.put("result","error");
            obj.put("errorAddressTids",errorAddressTids);
            obj.put("successAddressTids",leftIds);
            return obj;
        }

        ItemOrderExample itemOrderExample=new ItemOrderExample();
        itemOrderExample.createCriteria().andOuterIdIn(otherIds);
        List<ItemOrder> os= itemOrderMapper.selectFieldsByExample(itemOrderExample,FieldUtil.codeFields("oid,outer_id"));
        if(os.size()>0&&!repeatIs){
            List<String> hasIds= os.stream().map(ItemOrder::getOuterId).collect(Collectors.toList());
            List<String> leftIds=new ArrayList<>(otherIds);
            leftIds.removeIf(hasIds::contains);
            // 存在已下单的商品
            JSONObject obj= new JSONObject();
            obj.put("result","error");
            obj.put("hasIds",hasIds);
            obj.put("leftIds",leftIds);
            return obj;
        }

        for(OrderSubmitVo submitVo:orderSubmitVos){
            BuyerAddressVO buyerAddress=addsMap.get(submitVo.getOuterOrderNo());
            String addressId = confirmOrderService.saveTmpBuyerAddress(buyerAddress);
            submitVo.getTbOrderAddressInfo().setAddressId(addressId);
        }
        String uuid = UUIDGenerator.getUUID();
        redisIO.putTemp(uuid, orderSubmitVos, 3600);
        return JsonResponseUtil.success(uuid);
    }

    /**
     * 未关联商品列表
     * @param tids
     * @param userId
     * @return
     */
    public List<SubTbOrderVO> moreTbNeedBind(List<String> tids, Long userId) {
        List<Long> noGoodsNoNumiids=new ArrayList<>();
        List<SubTbOrderVO> os=new ArrayList<>();
        for(String tid:tids){
            TbOrderVO order=redisIO.get("tbOrder"+tid,TbOrderVO.class);
            if (order == null||order.getXzUserId().longValue()!=userId) {
                continue ;
            }
            for(SubTbOrderVO sub:order.getChildOrders()){
                if(noGoodsNoNumiids.contains(sub.getNumiid())){
                    continue;
                }
                try {
                    if(taoOrderService.selSourceGoodsByNumIid(sub.getNumiid())==null){
                        noGoodsNoNumiids.add(sub.getNumiid());
                        os.add(sub);
                    }
                } catch (NotFindRelationGoodsException e) {
                    noGoodsNoNumiids.add(sub.getNumiid());
                    os.add(sub);
                }
            }
        }
        return os;
    }

    /**
     * 错误地址列表
     * @param tids
     * @param userId
     * @return
     */
    public List<MoreErrorAddressVO> moreErrorAddress(List<String> tids, Long userId) {
        return tids.stream().map(s -> redisIO.get("tbOrder"+s,TbOrderVO.class))
                .filter(tbOrderVO -> tbOrderVO != null&&tbOrderVO.getXzUserId().longValue()==userId)
                .map(tbOrderVO -> new MoreErrorAddressVO(tbOrderVO.getTbId(),tbOrderVO.getAddress()))
                .collect(Collectors.toList());
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

    private int linkGoodsNo(TbOrderVO vo){
        vo.setCanOrder(true);
        vo.setProfits(null);
        Long lr= 0L;
        int notLinkNum=0;
        for(SubTbOrderVO subvo:vo.getChildOrders()){
            if(StringUtils.isEmpty(subvo.getGoodsNo())){
                try {
                    TinyVO rgv=taoOrderService.selSourceGoodsByNumIid(subvo.getNumiid());
                    if (rgv != null) {
                        subvo.setGoodsNo(rgv.getGoodsNo());
                        subvo.setXzPrice(rgv.getPiPriceString());
                        subvo.setWebSite(rgv.getWebSite());
                        lr+= subvo.getNewTbPriceLong()-rgv.getPiPrice();
                    }else {
                        vo.setCanOrder(false);
                        notLinkNum++;
                    }
                } catch (NotFindRelationGoodsException e) {
                    vo.setCanOrder(false);
                    notLinkNum++;
                }
            }
        }
        if(vo.isCanOrder()){
            vo.setProfits(PriceConvertUtils.priceToString(lr));
        }
        redisIO.putTemp("tbOrder"+vo.getTbId(), vo, 3600);
        return notLinkNum;
    }
}
