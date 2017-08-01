package com.shigu.main4.order.services.impl;

import com.opentae.data.mall.beans.ItemOrder;
import com.opentae.data.mall.beans.MemberStoreTaobaoSession;
import com.opentae.data.mall.beans.ShiguGoodsTaoRelation;
import com.opentae.data.mall.beans.ShiguGoodsTiny;
import com.opentae.data.mall.examples.ItemOrderExample;
import com.opentae.data.mall.examples.MemberStoreTaobaoSessionExample;
import com.opentae.data.mall.examples.ShiguGoodsTaoRelationExample;
import com.opentae.data.mall.examples.ShiguGoodsTinyExample;
import com.opentae.data.mall.interfaces.ItemOrderMapper;
import com.opentae.data.mall.interfaces.MemberStoreTaobaoSessionMapper;
import com.opentae.data.mall.interfaces.ShiguGoodsTaoRelationMapper;
import com.opentae.data.mall.interfaces.ShiguGoodsTinyMapper;
import com.shigu.main4.common.tools.ShiguPager;
import com.shigu.main4.common.util.BeanMapper;
import com.shigu.main4.order.bo.TbOrderBO;
import com.shigu.main4.order.exceptions.NotFindRelationGoodsException;
import com.shigu.main4.order.exceptions.NotFindSessionException;
import com.shigu.main4.order.services.TaoOrderService;
import com.shigu.main4.order.servicevo.RelationGoodsVO;
import com.shigu.main4.order.servicevo.SubTbOrderVO;
import com.shigu.main4.order.servicevo.TbOrderVO;
import com.shigu.main4.order.zfenums.TbOrderStatusEnum;
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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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

        MemberStoreTaobaoSessionExample example = new MemberStoreTaobaoSessionExample();
        example.createCriteria().andUserIdEqualTo(userId);
        List<MemberStoreTaobaoSession> session = memberStoreTaobaoSessionMapper.selectFieldsByExample(example, "taobao_login_session");
        if (session.size() == 0 || StringUtils.isEmpty(session.get(0).getTaobaoLoginSession())) {
            throw new NotFindSessionException("没有获取到淘宝session");
        }
        return session.get(0).getTaobaoLoginSession();
    }

    @Override
    public ShiguPager<TbOrderVO> myTbOrders(TbOrderBO bo, String sessionKey) {
        ShiguPager<TbOrderVO> pager = new ShiguPager<>();
        TaobaoClient client = new DefaultTaobaoClient("http://gw.api.taobao.com/router/rest", key, secretKey);
        TradesSoldGetRequest req = new TradesSoldGetRequest();
        req.setFields("seller_nick,buyer_nick,title,type,created,sid,tid,seller_rate,buyer_rate,status,payment,discount_fee,adjust_fee,post_fee,total_fee,pay_time,end_time,modified,consign_time,buyer_obtain_point_fee,point_fee,real_point_fee,received_payment,commission_fee,pic_path,num_iid,num_iid,num,price,cod_fee,cod_status,shipping_type,receiver_name,receiver_state,receiver_city,receiver_district,receiver_address,receiver_zip,receiver_mobile,receiver_phone,orders.title,orders.pic_path,orders.price,orders.num,orders.iid,orders.num_iid,orders.sku_id,orders.refund_status,orders.status,orders.oid,orders.total_fee,orders.payment,orders.discount_fee,orders.adjust_fee,orders.sku_properties_name,orders.item_meal_name,orders.buyer_rate,orders.seller_rate,orders.outer_iid,orders.outer_sku_id,orders.refund_id,orders.seller_type");
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
        req.setExtType("service");
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
        req.setFields("seller_nick,buyer_nick,title,type,created,sid,tid,seller_rate,buyer_rate,status,payment,discount_fee,adjust_fee,post_fee,total_fee,pay_time,end_time,modified,consign_time,buyer_obtain_point_fee,point_fee,real_point_fee,received_payment,commission_fee,pic_path,num_iid,num_iid,num,price,cod_fee,cod_status,shipping_type,receiver_name,receiver_state,receiver_city,receiver_district,receiver_address,receiver_zip,receiver_mobile,receiver_phone,orders.title,orders.pic_path,orders.price,orders.num,orders.iid,orders.num_iid,orders.sku_id,orders.refund_status,orders.status,orders.oid,orders.total_fee,orders.payment,orders.discount_fee,orders.adjust_fee,orders.sku_properties_name,orders.item_meal_name,orders.buyer_rate,orders.seller_rate,orders.outer_iid,orders.outer_sku_id,orders.refund_id,orders.seller_type");

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
    public RelationGoodsVO glGoodsJson(Long numiid) throws NotFindRelationGoodsException {
        if (numiid == null) {
            throw new NotFindRelationGoodsException("numiid为null");
        }
        ShiguGoodsTinyExample shiguGoodsTinyExample = new ShiguGoodsTinyExample();
        shiguGoodsTinyExample.setWebSite("hz");
        shiguGoodsTinyExample.createCriteria().andNumIidEqualTo(numiid);
        List<ShiguGoodsTiny> shiguGoodsTinies = shiguGoodsTinyMapper.selectByExample(shiguGoodsTinyExample);
        if (shiguGoodsTinies.size() > 0) {
            return glGoodsJson(numiid, shiguGoodsTinies.get(0).getGoodsId());
        }
        return null;
    }

    @Override
    public RelationGoodsVO glGoodsJson(Long numiid, Long goodsId) throws NotFindRelationGoodsException {
        if (numiid == null || goodsId == null) {
            throw new NotFindRelationGoodsException("numiid或goodsid为空");
        }
        RelationGoodsVO vo = new RelationGoodsVO();
        ShiguGoodsTiny shiguGoodsTiny = shiguGoodsTinyMapper.selectGoodsById("hz", goodsId);
        if (shiguGoodsTiny != null) {
            vo.setGoodsNo(shiguGoodsTiny.getGoodsNo());
            vo.setPrice(shiguGoodsTiny.getPriceString());
            vo.setPriceLong(shiguGoodsTiny.getPrice());
            vo.setWebSite("hz");
        }
        ShiguGoodsTaoRelationExample shiguGoodsTaoRelationExample = new ShiguGoodsTaoRelationExample();
        shiguGoodsTaoRelationExample.createCriteria().andNumIidEqualTo(numiid).andGoodsIdEqualTo(goodsId);
        List<ShiguGoodsTaoRelation> shiguGoodsTaoRelations = shiguGoodsTaoRelationMapper.selectByExample(shiguGoodsTaoRelationExample);
        if (shiguGoodsTaoRelations.size() == 0) {
            ShiguGoodsTaoRelation shiguGoodsTaoRelation = new ShiguGoodsTaoRelation();
            shiguGoodsTaoRelation.setGoodsId(goodsId);
            shiguGoodsTaoRelation.setNumIid(numiid);
            shiguGoodsTaoRelation.setWebSite("hz");
            shiguGoodsTaoRelationMapper.insertSelective(shiguGoodsTaoRelation);
        }
        return vo;

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
            t.setReceiverPhone(getSecurityClient().decrypt(t.getReceiverPhone(), "phone", session));
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
        String address="";
        if (!StringUtils.isEmpty(t.getReceiverName())) {
            address+=t.getReceiverName();
        }
        if (!StringUtils.isEmpty(t.getReceiverPhone())){
            address+=","+t.getReceiverPhone();
        }else if (!StringUtils.isEmpty(t.getReceiverMobile())){
            address+=","+t.getReceiverMobile();
        }
        if (!StringUtils.isEmpty(t.getReceiverAddress())){
            address+=","+t.getReceiverState()+" "+t.getReceiverCity()+" "+t.getReceiverDistrict()+" "+t.getReceiverAddress();
        }
        tbOrderVO.setAddress(address);
        if (t.getPayTime()!=null){
            tbOrderVO.setTime(t.getPayTime().toString());
        }

        ItemOrderExample itemOrderExample=new ItemOrderExample();
        itemOrderExample.createCriteria().andOuterIdEqualTo(t.getTid().toString());
        List<ItemOrder> itemOrders = itemOrderMapper.selectByExample(itemOrderExample);
        if (itemOrders.size()>0){
            tbOrderVO.setLastTime( new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(itemOrders.get(0).getCreateTime()));
        }
        ////
        tbOrderVO.setLastTime(t.getCreated().toString());
        List<SubTbOrderVO> childOrders = new ArrayList<>();
        if (t.getOrders().size() > 0) {
            List<Long> numIids = BeanMapper.getFieldList(t.getOrders(), "numIid", long.class);
            ShiguGoodsTinyExample shiguGoodsTinyExample=new ShiguGoodsTinyExample();
            shiguGoodsTinyExample.setWebSite("hz");
            shiguGoodsTinyExample.createCriteria().andNumIidIn(numIids);
            List<ShiguGoodsTiny> shiguGoodsTinies = shiguGoodsTinyMapper.selectByExample(shiguGoodsTinyExample);
            Map<Long, ShiguGoodsTiny> map = BeanMapper.list2Map(shiguGoodsTinies, "numIid", long.class);
            for (Order o : t.getOrders()) {
                SubTbOrderVO vo=new SubTbOrderVO();
                vo.setWebSite("hz");
                vo.setTbChildOrderId(o.getOid());
                vo.setImgSrc(o.getPicPath());
                vo.setNum(o.getNum().intValue());
                vo.setNumiid(o.getNumIid());
                vo.setOldTbPrice(o.getTotalFee());
                vo.setOldTbPriceLong(((long)Double.parseDouble(o.getTotalFee())));
                vo.setNewTbPrice(o.getPayment());
                vo.setNewTbPriceLong(((long)Double.parseDouble(o.getPayment())));
                vo.setColor(o.getSkuPropertiesName().split(";")[0].split(":")[1]);
                vo.setSize(o.getSkuPropertiesName().split(";")[1].split(":")[1]);
                if (map.size()>0){
                    vo.setGoodsNo(map.get(o.getNumIid()).getGoodsNo());
                    vo.setXzPrice(map.get(o.getNumIid()).getPriceString());
                    vo.setXzPriceLong(map.get(o.getNumIid()).getPrice());
                }
                vo.setTitle(o.getTitle());
                childOrders.add(vo);
            }
            tbOrderVO.setChildOrders(childOrders);
        }
        return tbOrderVO;
    }

}
