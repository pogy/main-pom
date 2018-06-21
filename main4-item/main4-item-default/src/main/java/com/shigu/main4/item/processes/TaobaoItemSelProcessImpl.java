package com.shigu.main4.item.processes;

import com.opentae.core.mybatis.utils.FieldUtil;
import com.opentae.data.mall.beans.ShiguGoodsTiny;
import com.opentae.data.mall.beans.ShiguShop;
import com.opentae.data.mall.beans.TaobaoSessionMap;
import com.opentae.data.mall.examples.ShiguGoodsTinyExample;
import com.opentae.data.mall.examples.TaobaoSessionMapExample;
import com.opentae.data.mall.interfaces.ShiguGoodsTinyMapper;
import com.opentae.data.mall.interfaces.ShiguShopMapper;
import com.opentae.data.mall.interfaces.TaobaoSessionMapMapper;
import com.shigu.main4.common.exceptions.Main4Exception;
import com.shigu.main4.common.tools.ShiguPager;
import com.shigu.main4.item.exceptions.TbOnsaleException;
import com.shigu.main4.item.exceptions.TbPropException;
import com.shigu.main4.item.services.utils.PropsService;
import com.shigu.main4.item.services.utils.TaobaoExecutor;
import com.shigu.main4.item.vo.PropertyItemVO;
import com.shigu.main4.item.vo.PropertyValueVO;
import com.shigu.main4.item.vo.PropsVO;
import com.shigu.main4.item.vo.TbOnsale;
import com.taobao.api.ApiException;
import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.domain.Item;
import com.taobao.api.domain.Trade;
import com.taobao.api.request.ItemsOnsaleGetRequest;
import com.taobao.api.request.TradesSoldGetRequest;
import com.taobao.api.response.ItemsOnsaleGetResponse;
import com.taobao.api.response.TradesSoldGetResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.*;

@Service("taobaoItemSelProcess")
public class TaobaoItemSelProcessImpl implements TaobaoItemSelProcess {

    @Autowired
    ShiguShopMapper shiguShopMapper;

    @Autowired
    TaobaoSessionMapMapper taobaoSessionMapMapper;

    @Autowired
    ShiguGoodsTinyMapper shiguGoodsTinyMapper;

    @Autowired
    private TaobaoExecutor taobaoExecutor;

    @Value("${taobao.app.key}")
    private String APPKEY;

    @Value("${taobao.app.secret}")
    private String SECRET;

    @Value("${taobao.app.server.url}")
    private String TOP_SERVER_URL;

    @Autowired
    PropsService propsService;

    @Override
    public ShiguPager<TbOnsale> selTbOnsale(Long shopId, String keyword, int pageNo, int pageSize) throws TbOnsaleException {
        if(shopId==null){
            throw new TbOnsaleException("shopId is null");
        }
        ShiguShop shop=shiguShopMapper.selectFieldsByPrimaryKey(shopId, FieldUtil.codeFields("shop_id,tb_nick,web_site"));
        if(shop==null){
            throw new TbOnsaleException("no shop's shopId is "+shopId);
        }
        //查出session
        TaobaoSessionMapExample taobaoSessionMapExample=new TaobaoSessionMapExample();
        taobaoSessionMapExample.createCriteria().andNickEqualTo(shop.getTbNick())
                .andAppkeyEqualTo(APPKEY);
        taobaoSessionMapExample.setStartIndex(0);
        taobaoSessionMapExample.setEndIndex(1);
        List<TaobaoSessionMap> list=taobaoSessionMapMapper.selectFieldsByConditionList(taobaoSessionMapExample,
                FieldUtil.codeFields("session"));
        if(list.size()==0){
            throw new TbOnsaleException("no session to "+shop.getTbNick());
        }
        TaobaoClient client = new DefaultTaobaoClient(TOP_SERVER_URL,
                APPKEY, SECRET);
        ItemsOnsaleGetRequest req = new ItemsOnsaleGetRequest();
        req.setFields("num_iid,title,price,pic_url");
        req.setQ(keyword);
        req.setPageNo(new Long(pageNo));
        req.setPageSize(new Long(pageSize));
        ItemsOnsaleGetResponse rsp = null;
        try {
            rsp = client.execute(req, list.get(0).getSession());
            if(!rsp.isSuccess()){
                throw new TbOnsaleException("tb open_error "+rsp.getBody());
            }
            ShiguPager<TbOnsale> pager=new ShiguPager<TbOnsale>();
            pager.setNumber(pageNo);
            pager.setTotalCount(rsp.getTotalResults().intValue());
            List<TbOnsale> onsales=new ArrayList<TbOnsale>();
            pager.setContent(onsales);
            List<Item> items=rsp.getItems();
            //淘宝ID串
            List<Long> numIids=new ArrayList<Long>();
            //存起来,等下改
            Map<Long,TbOnsale> map=new HashMap<Long, TbOnsale>();
            if(items!=null)
                for(Item it:items){
                    TbOnsale to=new TbOnsale();
                    to.setTitle(it.getTitle());
                    to.setNumIid(it.getNumIid());
                    to.setPicUrl(it.getPicUrl());
                    to.setPrice(it.getPrice());
                    numIids.add(it.getNumIid());
                    map.put(it.getNumIid(),to);
                    onsales.add(to);
                }
            if(numIids.size()==0){
                return pager;
            }
            ShiguGoodsTinyExample tinyExample=new ShiguGoodsTinyExample();
            tinyExample.createCriteria().andNumIidIn(numIids).andStoreIdEqualTo(shopId);
            tinyExample.setWebSite(shop.getWebSite());
            List<ShiguGoodsTiny> tinys=shiguGoodsTinyMapper.selectFieldsByExample(tinyExample,
                    FieldUtil.codeFields("goods_id,num_iid"));
            for(ShiguGoodsTiny sgt:tinys){
                map.get(sgt.getNumIid()).setGoodsId(sgt.getGoodsId());
            }
            return pager;
        } catch (ApiException e) {
            throw new TbOnsaleException("tb open_api_error "+e.getErrCode());
        }
    }

    @Override
    public Map<Long, Long> calculateTrade(String nick, List<Long> numIids, Date from, Date to) throws Main4Exception {
        TradesSoldGetRequest request = new TradesSoldGetRequest();
        request.setStartCreated(from);
        request.setEndCreated(to == null ? new Date() : to);
        request.setFields("tid,num,num_iid");
        request.setStatus("TRADE_FINISHED");
        request.setType("fixed,auction,guarantee_trade,step,independent_shop_trade,auto_delivery,ec,cod,game_equipment,shopex_trade,netcn_trade,external_trade,instant_trade ,b2c_cod,hotel_trade,super_market_trade,super_market_cod_trade,taohua, eticket, tmall_i18n,,nopaid ,insurance_plus,finance,pre_auth_type, lazada");
        request.setUseHasNext(true);
        request.setPageSize(100L);
        Long pageNo = 1L;
        request.setPageNo(pageNo);
        TradesSoldGetResponse response;
        List<Trade> trades = new ArrayList<Trade>();
        do {
            response = taobaoExecutor.success(request, nick);
            request.setPageNo(++pageNo);
            if (response.getTrades() != null) {
                trades.addAll(response.getTrades());
            }
        } while (response.getHasNext());

        Map<Long, Long> totalCount = new HashMap<Long, Long>();
        if (numIids != null && !numIids.isEmpty()) {
            for (Iterator<Trade> iterator = trades.iterator(); iterator.hasNext(); )
                if (!numIids.contains(iterator.next().getNumIid()))
                    iterator.remove();

            for (Long numIid : numIids) {
                totalCount.put(numIid, 0L);
            }
        }

        for (Trade trade : trades) {
            Long numIid = trade.getNumIid();
            if (numIid == null)
                continue;
            Long count = totalCount.get(numIid);
            if (count == null)
                count = 0L;
            totalCount.put(numIid, ++ count);
        }
        return totalCount;
    }

    @Override
    public PropsVO selProps(Long cid) throws TbPropException {
        try {
            return propsService.selProps(cid);
        } catch (Exception e) {
            throw new TbPropException(e.getMessage());
        }
    }
    @Override
    public PropertyItemVO selItemVoBySub(Long cid, String path) throws TbPropException {
        try {
            return propsService.selItemVoBySub(cid,path);
        } catch (ApiException e) {
            throw new TbPropException(e.getMessage());
        }
    }

    @Override
    public List<PropertyValueVO> propselect(Long cid, String key) {
        return propsService.propselect(cid,key);
    }

    @Override
    public String propmore(Long cid, String value) {
        return propsService.propselect(cid,value).toString();
    }


}
