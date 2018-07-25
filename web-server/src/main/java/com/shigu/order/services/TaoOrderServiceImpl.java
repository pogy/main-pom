package com.shigu.order.services;

import com.alibaba.fastjson.JSON;
import com.opentae.core.mybatis.utils.FieldUtil;
import com.opentae.data.mall.beans.*;
import com.opentae.data.mall.examples.*;
import com.opentae.data.mall.interfaces.*;
import com.searchtool.configs.ElasticConfiguration;
import com.shigu.main4.common.tools.ShiguPager;
import com.shigu.main4.common.util.BeanMapper;
import com.shigu.main4.common.util.DateUtil;
import com.shigu.main4.monitor.vo.ItemUpRecordVO;
import com.shigu.main4.order.bo.GoodsTaoRelationBO;
import com.shigu.main4.order.bo.TbOrderBO;
import com.shigu.main4.order.exceptions.NotFindRelationGoodsException;
import com.shigu.main4.order.exceptions.NotFindSessionException;
import com.shigu.main4.order.process.ItemProductProcess;
import com.shigu.main4.order.servicevo.SubTbOrderVO;
import com.shigu.main4.order.servicevo.TbOrderVO;
import com.shigu.main4.order.zfenums.TbOrderStatusEnum;
import com.shigu.order.vo.TinyIdMapVO;
import com.shigu.order.vo.TinyVO;
import com.taobao.api.ApiException;
import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.SecretException;
import com.taobao.api.TaobaoClient;
import com.taobao.api.domain.Order;
import com.taobao.api.domain.Trade;
import com.taobao.api.request.TradeFullinfoGetRequest;
import com.taobao.api.request.TradesSoldGetRequest;
import com.taobao.api.response.TradeFullinfoGetResponse;
import com.taobao.api.response.TradesSoldGetResponse;
import com.taobao.api.security.SecurityClient;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by zf on 2017/7/21.
 */
@Service
public class TaoOrderServiceImpl implements TaoOrderService {


    @Autowired
    private MemberStoreTaobaoSessionMapper memberStoreTaobaoSessionMapper;

    @Autowired
    private ShiguGoodsTinyMapper shiguGoodsTinyMapper;

    @Autowired
    private ShiguGoodsTaoRelationMapper shiguGoodsTaoRelationMapper;

    @Autowired
    private MemberUserSubMapper memberUserSubMapper ;

    @Autowired
    private TaobaoSessionMapMapper taobaoSessionMapMapper;

    @Autowired
    private ShiguGoodsIdGeneratorMapper shiguGoodsIdGeneratorMapper;

    @Autowired
    private ItemProductProcess itemProductProcess;

    @Autowired
    private ShiguShopMapper shiguShopMapper;

    @Value("${appKey}")
    private String key;

    @Value("${secretKey}")
    private String secretKey;


    private  SecurityClient securityClient;

    @Autowired
    private  ItemOrderMapper itemOrderMapper;

    @Override
    public String myTbSessionKey(Long userId) throws NotFindSessionException {
        if (userId == null) {
            throw new NotFindSessionException("userId为null");
        }
        MemberUserSubExample example=new MemberUserSubExample();
        example.createCriteria().andUserIdEqualTo(userId).andAccountTypeEqualTo(3);
        List<MemberUserSub> session = memberUserSubMapper.selectByExample(example);
        if (session.size()==0){
            throw new NotFindSessionException("没有对应的信息");
        }
        TaobaoSessionMapExample taobaoSessionMapExample=new TaobaoSessionMapExample();
        taobaoSessionMapExample.createCriteria().andUserIdEqualTo(Long.parseLong(session.get(0).getSubUserKey())).andAppkeyEqualTo(key);
        List<TaobaoSessionMap> taobaoSessionMaps = taobaoSessionMapMapper.selectByExample(taobaoSessionMapExample);
        if (taobaoSessionMaps.size() == 0 ) {
            throw new NotFindSessionException("没有获取到淘宝session");
        }
        return taobaoSessionMaps.get(0).getSession();
    }

    @Override
    public ShiguPager<TbOrderVO> myTbOrders(TbOrderBO bo, String sessionKey) {
        ShiguPager<TbOrderVO> pager = new ShiguPager<>();
        TaobaoClient client = new DefaultTaobaoClient("http://gw.api.taobao.com/router/rest", key, secretKey);
        TradesSoldGetRequest req = new TradesSoldGetRequest();
        req.setFields("seller_flag,seller_nick,buyer_nick,title,type,created,sid,tid,seller_rate,buyer_rate,status,payment,discount_fee,adjust_fee,post_fee,total_fee,pay_time,end_time,modified,consign_time,buyer_obtain_point_fee,point_fee,real_point_fee,received_payment,commission_fee,pic_path,num_iid,num_iid,num,price,cod_fee,cod_status,shipping_type,receiver_name,receiver_state,receiver_city,receiver_district,receiver_address,receiver_zip,receiver_mobile,receiver_phone,orders.title,orders.pic_path,orders.price,orders.num,orders.iid,orders.num_iid,orders.sku_id,orders.refund_status,orders.status,orders.oid,orders.total_fee,orders.payment,orders.discount_fee,orders.adjust_fee,orders.sku_properties_name,orders.item_meal_name,orders.buyer_rate,orders.seller_rate,orders.outer_iid,orders.outer_sku_id,orders.refund_id,orders.seller_type");
        int size;
        int page;
        if (bo.getStartTime() != null) {
            req.setStartCreated(bo.getStartTime());
        }
        if (bo.getEndTime() != null) {
            req.setEndCreated(bo.getEndTime());
        }
        if (bo.getStatus() != null) {
            req.setStatus(bo.getStatus().toString());
        }
        if (bo.getPage() != null) {
            page = bo.getPage();
        }else {

            page = 1;
        }
        if (bo.getPageSize() != null) {
            size = bo.getPageSize();
        }else {

            size = 10;
        }
        pager.setNumber(page);
        req.setPageNo((long) page);
        req.setPageSize((long) size);
        try {
            TradesSoldGetResponse rsp = client.execute(req,sessionKey);
            List<TbOrderVO> tbOrderVOList = new ArrayList<>();
            List<Trade> trades = rsp.getTrades();
            if (trades!=null&&trades.size()>0){
                for (Trade t : trades) {
                    tbOrderVOList.add(packing(t,sessionKey));
                }
                pager.setContent(tbOrderVOList);
                pager.calPages(rsp.getTotalResults().intValue(), size);
            }
//            pager.setTotalCount(rsp.getTotalResults().intValue());
//            pager.setTotalPages((rsp.getTotalResults().intValue()/size));
        } catch (ApiException e) {
            e.printStackTrace();
        } catch (SecretException e) {
            e.printStackTrace();
        }


        return pager;
    }

    @Override
    public TbOrderVO myTbOrder(Long tid, TbOrderStatusEnum status, String sessionKey) {
        TaobaoClient client = new DefaultTaobaoClient("http://gw.api.taobao.com/router/rest", key, secretKey);
        TradeFullinfoGetRequest req = new TradeFullinfoGetRequest();
        req.setFields("seller_flag,seller_nick,buyer_nick,title,type,created,sid,tid,seller_rate,buyer_rate,status,payment,discount_fee,adjust_fee,post_fee,total_fee,pay_time,end_time,modified,consign_time,buyer_obtain_point_fee,point_fee,real_point_fee,received_payment,commission_fee,pic_path,num_iid,num_iid,num,price,cod_fee,cod_status,shipping_type,receiver_name,receiver_state,receiver_city,receiver_district,receiver_address,receiver_zip,receiver_mobile,receiver_phone,orders.title,orders.pic_path,orders.price,orders.num,orders.iid,orders.num_iid,orders.sku_id,orders.refund_status,orders.status,orders.oid,orders.total_fee,orders.payment,orders.discount_fee,orders.adjust_fee,orders.sku_properties_name,orders.item_meal_name,orders.buyer_rate,orders.seller_rate,orders.outer_iid,orders.outer_sku_id,orders.refund_id,orders.seller_type");

        req.setTid(tid);
        TbOrderVO tbOrderVO = null;
        try {
            TradeFullinfoGetResponse rsp = client.execute(req, sessionKey);
            Trade trade = rsp.getTrade();
            if (trade != null) {
                tbOrderVO = packing(trade,sessionKey);
            }
        } catch (ApiException e) {
            e.printStackTrace();
        } catch (SecretException e) {
            e.printStackTrace();
        }
        return tbOrderVO;
    }

    @Override
    public TinyVO selSourceGoodsByNumIid(Long numiid) throws NotFindRelationGoodsException {
        List<Long> numIids=new ArrayList<>();
        numIids.add(numiid);
        List<TinyVO> tinyVOs=selUpedTinys(numIids);
        return tinyVOs.size()>0?tinyVOs.get(0):null;
    }

    @Override
    public void glGoodsJson(Long numiid, Long goodsId,Long userId) throws NotFindRelationGoodsException {
        if (numiid == null || goodsId == null) {
            throw new NotFindRelationGoodsException("numiid或goodsid为空");
        }
        ShiguGoodsIdGenerator goodsIdObj=shiguGoodsIdGeneratorMapper.selectByPrimaryKey(goodsId);
        if (goodsIdObj == null) {
            throw new NotFindRelationGoodsException("商品ID非法");
        }
        GoodsTaoRelationBO shiguGoodsTaoRelation=new GoodsTaoRelationBO();
        shiguGoodsTaoRelation.setNumIid(numiid);
        shiguGoodsTaoRelation.setUserId(userId);
        shiguGoodsTaoRelation.setGoodsId(goodsId);
        shiguGoodsTaoRelation.setWebSite(goodsIdObj.getWebSite());
        itemProductProcess.relationTaoGoods(shiguGoodsTaoRelation);
    }

    public  SecurityClient getSecurityClient() {
        if (securityClient == null) {
            securityClient=new SecurityClient(new DefaultTaobaoClient("https://eco.taobao.com/router/rest",key, secretKey), "mfy66cL42XjXNkOifNHniJ36NuoNBDnz2TbBIqRgMMc=");
//            securityClient = new SecurityClient(new DefaultTaobaoClient("https://gw.api.tbsandbox.com/router/rest", "1021720662", "sandboxb87142f81cb85374baeb2f285"), "Hm0Vqe1VmR3x/a7oqaFUHEf0Gu0yv1JwI8j+tau+fDo= ");
        }
        return securityClient;
    }
    //解密的方法
    private Trade decrypt(Trade t,String session) throws SecretException {

        if (!StringUtils.isEmpty(t.getBuyerNick())) {
            t.setBuyerNick(getSecurityClient().decrypt(t.getBuyerNick(), "search", session));
        }
        if (!StringUtils.isEmpty(t.getReceiverAddress())) {
            t.setReceiverAddress(getSecurityClient().decrypt(t.getReceiverAddress(), "simple", session));
        }
        if (!StringUtils.isEmpty(t.getReceiverMobile())) {
            t.setReceiverMobile(getSecurityClient().decrypt(t.getReceiverMobile(), "phone", session));
        }
        if (!StringUtils.isEmpty(t.getReceiverPhone())) {
            t.setReceiverPhone(getSecurityClient().decrypt(t.getReceiverPhone(), "search", session));
        }
        if (!StringUtils.isEmpty(t.getReceiverName())) {
            t.setReceiverName(getSecurityClient().decrypt(t.getReceiverName(), "search", session));
        }

        return t;
    }
    //封装的方法
    public  TbOrderVO packing(Trade t,String session) throws SecretException {
        decrypt(t, session);
        TbOrderVO tbOrderVO = new TbOrderVO();
        tbOrderVO.setTbId(t.getTid().toString());
        String address="";
        if (!StringUtils.isEmpty(t.getReceiverName())) {
            address+=t.getReceiverName();
        }
        if (!StringUtils.isEmpty(t.getReceiverMobile())){
            address+=","+t.getReceiverMobile();
            tbOrderVO.setReceiverPhone(t.getReceiverMobile());
        }else if (!StringUtils.isEmpty(t.getReceiverPhone())){
            address+=","+t.getReceiverPhone();
        }
        if (!StringUtils.isEmpty(t.getReceiverAddress())){
            address+=","+t.getReceiverState()+" "+t.getReceiverCity()+" "
                    +(t.getReceiverDistrict()==null?"":t.getReceiverDistrict())+" "+t.getReceiverAddress();
        }
        tbOrderVO.setAddress(address);
        tbOrderVO.setSimpleAddress(t.getReceiverAddress());
        if (t.getPayTime()!=null){
            tbOrderVO.setTime(DateUtil.dateToString(t.getPayTime(),"yyyy-MM-dd HH:mm:ss"));
        }
        if (!StringUtils.isEmpty(t.getReceiverCity())){
            tbOrderVO.setCity(t.getReceiverCity());
        }
        if (!StringUtils.isEmpty(t.getReceiverState())){
            tbOrderVO.setProv(t.getReceiverState());
        }
        if (!StringUtils.isEmpty(t.getReceiverDistrict())){
            tbOrderVO.setTown(t.getReceiverDistrict());
        }else{
            tbOrderVO.setTown("");
        }
        if (!StringUtils.isEmpty(t.getReceiverName())){
            tbOrderVO.setReceiverName(t.getReceiverName());
        }
        if(t.getSellerFlag() != null){
            tbOrderVO.setFlagState(t.getSellerFlag());
        }

        ItemOrderExample itemOrderExample=new ItemOrderExample();
        itemOrderExample.createCriteria().andOuterIdEqualTo(t.getTid().toString());
        List<ItemOrder> itemOrders = itemOrderMapper.selectByExample(itemOrderExample);
        if (itemOrders.size()>0){
            tbOrderVO.setLastTime( new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(itemOrders.get(0).getCreateTime()));
        }
        List<SubTbOrderVO> childOrders = new ArrayList<>();
        if (t.getOrders().size() > 0) {
            for (Order o : t.getOrders()) {
                SubTbOrderVO vo=new SubTbOrderVO();
                vo.setTbChildOrderId(o.getOid().toString());
                vo.setImgSrc(o.getPicPath());
                vo.setNum(o.getNum().intValue());
                vo.setNumiid(o.getNumIid());
                vo.setOldTbPrice(o.getTotalFee());
                Double tbOldPriceLong=Double.parseDouble(o.getTotalFee())*100;
                vo.setOldTbPriceLong(tbOldPriceLong.longValue());
                if (o.getPayment() == null) {
                    vo.setNewTbPrice(o.getTotalFee());
                    vo.setNewTbPriceLong(vo.getOldTbPriceLong());
                }else{
                    vo.setNewTbPrice(o.getPayment());
                    Double tbNewPriceLong=Double.parseDouble(o.getPayment())*100;
                    vo.setNewTbPriceLong(tbNewPriceLong.longValue());
                }

                if(o.getSkuPropertiesName()!=null){
                    String[] propArr=o.getSkuPropertiesName().split(";");
                    if(propArr[0].contains(":")){
                        vo.setColor(propArr[0].split(":")[1]);
                    }
                    if(propArr.length>1){
                        vo.setSize(propArr[1].split(":")[1]);
                    }
                }
                vo.setTitle(o.getTitle());
                childOrders.add(vo);
            }
            tbOrderVO.setChildOrders(childOrders);
        }
        return tbOrderVO;
    }

    /**
     * 查询商品关联
     * @param numIids
     * @return
     */
    private List<TinyVO> selUpedTinys(List<Long> numIids){
        //1、先匹配item_goods_relation表
        //2、如果1没匹配到,继续去ES。shigugoodsup_v2匹配
        //3、把匹配到的结果包装成需要的
        if(numIids.size()==0){
            return new ArrayList<>();
        }
        List<TinyIdMapVO> tinyIds=selFromRelation(numIids);
        numIids.removeAll(BeanMapper.getFieldList(tinyIds,"numIid",Long.class));
        if(numIids.size()>0){
            tinyIds.addAll(selFromEs(numIids));
        }
        //ID对
        Map<Long,Long> goodsIdAndNumIid=new HashMap<>();
        Map<String,List<Long>> sitesGoodsMap=new HashMap<>();
        tinyIds.forEach(id -> {
            List<Long> ids=sitesGoodsMap.get(id.getWebSite());
            if (ids == null) {
                ids = new ArrayList<Long>();
                sitesGoodsMap.put(id.getWebSite(),ids);
            }
            ids.add(id.getGoodsId());
            goodsIdAndNumIid.put(id.getGoodsId(),id.getNumIid());
        });
        Iterator<String> it=sitesGoodsMap.keySet().iterator();
        List<TinyVO> tinyVOs=new ArrayList<>();
        while(it.hasNext()){
            String webSite=it.next();
            List<Long> goodsIds=sitesGoodsMap.get(webSite);
            if (goodsIds.size() > 0) {
                ShiguGoodsTinyExample tinyExample=new ShiguGoodsTinyExample();
                tinyExample.createCriteria().andGoodsIdIn(goodsIds);
                tinyExample.setWebSite(webSite);
                List<ShiguGoodsTiny> shiguGoodsTinies=shiguGoodsTinyMapper.selectFieldsByExample(tinyExample,
                        FieldUtil.codeFields("goods_id,num_iid,store_id,goods_no,pi_price,pi_price_string,web_site"));
                List<TinyVO> webSiteTinys=BeanMapper.mapList(shiguGoodsTinies,TinyVO.class);
                webSiteTinys.forEach(t -> {
                    t.setNumIid(goodsIdAndNumIid.get(t.getGoodsId()));
                });
                tinyVOs.addAll(webSiteTinys);
                //处理货号为空的情况
                List<Long> emptyStoreIds=new ArrayList<>();
                shiguGoodsTinies.forEach(t -> {
                    if (StringUtils.isEmpty(t.getGoodsNo())) {
                        emptyStoreIds.add(t.getStoreId());
                    }
                });
                if (emptyStoreIds.size()>0) {
                    List<ShopNumAndMarket> shops=shiguShopMapper.selShopNumAndMarkets(emptyStoreIds.stream().distinct().collect(Collectors.toList()));
                    Map<Long,ShopNumAndMarket> map=shops.stream().collect(Collectors.toMap(ShopNumAndMarket::getShopId,(p)->p));
                    tinyVOs.stream().filter((s) -> StringUtils.isEmpty(s.getGoodsNo())).forEach(t ->
                            t.setGoodsNo(map.get(t.getStoreId()).getMarket()+"_"+map.get(t.getStoreId()).getShopNum()));
                }
            }
        }
        return tinyVOs;
    }

    /**
     * 对手动关联过的数据中查询
     * @param numIids
     * @return
     */
    private List<TinyIdMapVO> selFromRelation(List<Long> numIids){
        ShiguGoodsTaoRelationExample taoRelationExample=new ShiguGoodsTaoRelationExample();
        taoRelationExample.createCriteria().andNumIidIn(numIids);
        List<ShiguGoodsTaoRelation> taoRelations=shiguGoodsTaoRelationMapper.selectByExample(taoRelationExample);
        return BeanMapper.mapList(taoRelations,TinyIdMapVO.class);
    }

    /**
     * 从用户一键上传过的记录中查询
     * @param numIids
     * @return
     */
    private List<TinyIdMapVO> selFromEs(List<Long> numIids){
        try {
            SearchResponse response = ElasticConfiguration.searchClient.prepareSearch("shigugoodsup")
                    .setQuery(QueryBuilders.termsQuery("fenNumiid",numIids)).execute().actionGet();
            SearchHits hits=response.getHits();
            SearchHit[] hitArr=hits.getHits();
            List<TinyIdMapVO> results=new ArrayList<>();
            for(int i=0;i<hitArr.length;i++){
                SearchHit hit=hitArr[i];
                ItemUpRecordVO shiguGoodsUp = JSON.parseObject(hit.getSourceAsString(), ItemUpRecordVO.class);
                TinyIdMapVO tinyIdMapVO=new TinyIdMapVO();
                tinyIdMapVO.setWebSite(shiguGoodsUp.getWebSite());
                tinyIdMapVO.setGoodsId(shiguGoodsUp.getSupperGoodsId());
                tinyIdMapVO.setNumIid(shiguGoodsUp.getFenNumiid());
                results.add(tinyIdMapVO);
            }
            return results;
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }


}
