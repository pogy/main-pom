package com.shigu.daifa.api.services;

import com.openJar.beans.WorkUserGgoodsTasksCounts;
import com.openJar.beans.WorkUserGgoodsTasksGoods;
import com.openJar.beans.WorkUserGgoodsTasksMarket;
import com.openJar.beans.WorkUserGgoodsTasksSku;
import com.openJar.exception.SystemInterfaceException;
import com.openJar.responses.thirdSupport.SelWorkUserGgoodsTasksGoodsResponse;
import com.openJar.responses.thirdSupport.SelWorkUserGgoodsTasksStoresResponse;
import com.openJar.responses.thirdSupport.ShortCompleteCheckedResponse;
import com.openJar.responses.thirdSupport.ThirdLoinResponse;
import com.opentae.core.mybatis.utils.FieldUtil;
import com.opentae.data.daifa.beans.DaifaGgoods;
import com.opentae.data.daifa.beans.DaifaOrder;
import com.opentae.data.daifa.beans.DaifaTrade;
import com.opentae.data.daifa.beans.DaifaWorker;
import com.opentae.data.daifa.examples.DaifaGgoodsExample;
import com.opentae.data.daifa.examples.DaifaOrderExample;
import com.opentae.data.daifa.examples.DaifaTradeExample;
import com.opentae.data.daifa.examples.DaifaWorkerExample;
import com.opentae.data.daifa.interfaces.*;
import com.shigu.daifa.api.beans.NotCodeSets;
import com.shigu.daifa.services.DaifaAllocatedService;
import com.shigu.main4.common.util.BeanMapper;
import com.shigu.main4.common.util.DateUtil;
import com.shigu.main4.common.util.MoneyUtil;
import com.shigu.main4.daifa.exceptions.DaifaException;
import com.shigu.main4.daifa.process.OrderManageProcess;
import com.shigu.main4.daifa.process.PackDeliveryProcess;
import com.shigu.main4.daifa.process.TakeGoodsIssueProcess;
import com.shigu.main4.daifa.vo.UnComleteAllVO;
import com.shigu.sms.beans.SmsSendResult;
import com.shigu.sms.utils.SmsJsoup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ThirdSupportService {
    @Autowired
    private DaifaAllocatedService daifaAllocatedService;
    @Autowired
    DaifaWorkerMapper daifaWorkerMapper;
    @Autowired
    DaifaGgoodsMapper daifaGgoodsMapper;
    @Autowired
    DaifaGgoodsTasksMapper daifaGgoodsTasksMapper;
    @Autowired
    DaifaOrderMapper daifaOrderMapper;
    @Autowired
    TakeGoodsIssueProcess takeGoodsIssueProcess;
    @Autowired
    OrderManageProcess orderManageProcess;
    @Autowired
    PackDeliveryProcess packDeliveryProcess;
    @Autowired
    DaifaTradeMapper daifaTradeMapper;
    @Value("${ERROR_SEND_PHONE}")
    String errorSendPhone;

    public ThirdLoinResponse thirdLogin(String userName, String password) throws SystemInterfaceException {
        if (userName == null || userName.trim().length() == 0 || password == null || password.trim().length() == 0) {
            throw new SystemInterfaceException("缺少参数");
        }
        DaifaWorker worker = new DaifaWorker();
        worker.setDaifaWorker(userName);
        worker.setPassword(password);
        worker = daifaWorkerMapper.selectOne(worker);
        if (worker == null) {
            throw new SystemInterfaceException("用户不存在");
        }
        ThirdLoinResponse user = new ThirdLoinResponse();
        user.setDaifaSellerId(worker.getDaifaSellerId());
        user.setWorkerId(worker.getDaifaWorkerId());
        user.setLoginName(worker.getDaifaWorker());
        user.setPhone(worker.getPhone());
        user.setUserName(worker.getUserName());
        user.setSuccess(true);
        return user;
    }

    public SelWorkUserGgoodsTasksStoresResponse selPhoneGgoodsTasksStore(Long daifaWorkerId, Integer status) throws SystemInterfaceException {
        if (daifaWorkerId == null || status == null) {
            throw new SystemInterfaceException("缺少参数");
        }
        DaifaWorkerExample example = new DaifaWorkerExample();
        example.createCriteria().andDaifaWorkerIdEqualTo(daifaWorkerId).andUseStatusEqualTo(1);
        Integer count = daifaWorkerMapper.countByExample(example);
        if (count == 0) {
            throw new SystemInterfaceException("用户不存在");
        }
        List<WorkUserGgoodsTasksMarket> markets = daifaGgoodsMapper.selectWorkGgoodsStores(daifaWorkerId, status);
        WorkUserGgoodsTasksCounts counts = daifaGgoodsMapper.selectTodayWorkGgoodsStoresCount(daifaWorkerId);
        if (counts == null) {
            counts = new WorkUserGgoodsTasksCounts();
            counts.setTotalHasNum(0);
            counts.setTotalNum(0);
        }
        if (counts.getTotalHasNum() == null) {
            counts.setTotalHasNum(0);
        }
        if (counts.getTotalNum() == null) {
            counts.setTotalNum(0);
        }
        SelWorkUserGgoodsTasksStoresResponse res = new SelWorkUserGgoodsTasksStoresResponse();
        res.setMarkets(markets);
        res.setCounts(counts);
        res.setSuccess(true);
        return res;
    }

    public SelWorkUserGgoodsTasksGoodsResponse selPhoneGgoodsTasksGoods(Long daifaWorkerId, Long storeId, Integer status, List<String> codeMore) throws SystemInterfaceException {
        if (daifaWorkerId == null || storeId == null) {
            throw new SystemInterfaceException("缺少参数");
        }
        SelWorkUserGgoodsTasksGoodsResponse res = new SelWorkUserGgoodsTasksGoodsResponse();
        res.setSuccess(true);
        res.setSkuList(new ArrayList<>());
        res.setSumNum(0);
        res.setSumPrice(0L);


        DaifaWorkerExample example = new DaifaWorkerExample();
        example.createCriteria().andDaifaWorkerIdEqualTo(daifaWorkerId).andUseStatusEqualTo(1);
        Integer count = daifaWorkerMapper.countByExample(example);
        if (count == 0) {
            throw new SystemInterfaceException("用户不存在");
        }
        DaifaGgoodsExample example2 = new DaifaGgoodsExample();
        DaifaGgoodsExample.Criteria ce = example2.createCriteria().andDaifaWorkerIdEqualTo(daifaWorkerId)
                .andCreateDateEqualTo(DateUtil.dateToString(new Date(), DateUtil.patternB))
                .andStoreIdEqualTo(storeId);
        if (status != null) {
            ce.andTakeGoodsStatusEqualTo(status);
        }
        example2.setOrderByClause("create_time desc");
        List<DaifaGgoods> gs = daifaGgoodsMapper.selectByExample(example2);
        List<Long> orderIds = new ArrayList<Long>();
        for (DaifaGgoods g : gs) {
            orderIds.add(g.getDfOrderId());
        }
        if (orderIds.size() == 0) {
            return res;
        }
        DaifaOrderExample example3 = new DaifaOrderExample();
        example3.createCriteria().andDfOrderIdIn(orderIds);
        List<DaifaOrder> orders = daifaOrderMapper.selectFieldsByExample(example3, FieldUtil.codeFields("df_order_id,df_trade_id"));
        List<WorkUserGgoodsTasksSku> skus = new ArrayList<>();
        Map<Long, Integer> m = new HashMap<Long, Integer>();
        String storename = null;
        int sumNum = 0;
        long sumPrice = 0L;

        Map<String, String> codemoremap = new HashMap<String, String>();
        if (codeMore != null && codeMore.size() > 0) {
            for (String aCodeMore : codeMore) {
                codemoremap.put(aCodeMore, aCodeMore);
            }
        }
        List<Long> goodsIds = new ArrayList<>();
        for (DaifaGgoods g : gs) {
            if (g.getGoodsId() != null) {
                goodsIds.add(g.getGoodsId());
            }
        }


        for (DaifaGgoods g : gs) {
            if (m.get(g.getDfOrderId()) != null) {
                continue;
            }
            Integer i = null;
            WorkUserGgoodsTasksSku sku = null;
            for (int v = 0; v < skus.size(); v++) {
                WorkUserGgoodsTasksSku s = skus.get(v);
                if ((s.getGoodsNo() + "").equals(g.getGoodsCode() + "")) {
                    sku = s;
                    i = v;
                    break;
                }
            }
            if (sku == null) {
                sku = new WorkUserGgoodsTasksSku();
                sku.setGoods(new ArrayList<>());
                sku.setGoodsNo(g.getGoodsCode());
                sku.setTotalNum(0);
                sku.setTotalPiPrice(0L);
            }
            if (storename == null) {
                storename = g.getMarketName() + "(" + g.getStoreNum() + ")";
            }
            List<WorkUserGgoodsTasksGoods> goodsList = sku.getGoods();
            String code = null;
            for (DaifaOrder o : orders) {
                if (o.getDfOrderId().longValue() == g.getDfOrderId().longValue()) {
                    code = o.getDfOrderId() + "" + (o.getDfTradeId().toString().substring(0, 7));
                    break;
                }
            }
            if (code == null) {
                continue;
            }
            WorkUserGgoodsTasksGoods goods = null;
            Integer vi = null;
            for (int v = 0; v < goodsList.size(); v++) {
                WorkUserGgoodsTasksGoods go = goodsList.get(v);
                if ((go.getGoodsNo() + "" + go.getSkuStr() + go.getPiPrice()).equals(g.getGoodsCode() + "" + g.getPropStr() + MoneyUtil.StringToLong(g.getSinglePiPrice()))) {
                    goods = go;
                    vi = v;
                    break;
                }
            }
            if (goods == null) {
                goods = new WorkUserGgoodsTasksGoods();
                goods.setNum(g.getGoodsNum());
                if (codeMore == null || codeMore.size() == 0) {
                    goods.setHasNum(g.getGoodsNum());
                    goods.setCode(code);
                    goods.setNotCode("");
                    goods.setGgoodsStatus(g.getTakeGoodsStatus() + 1);
                } else {
                    if (codemoremap.get(code) != null) {
                        goods.setHasNum(g.getGoodsNum());
                        goods.setCode(code);
                        goods.setNotCode("");
                        goods.setGgoodsStatus(2);
                    } else {
                        goods.setHasNum(0);
                        goods.setCode("");
                        goods.setNotCode(code);
                        goods.setGgoodsStatus(g.getTakeGoodsStatus() + 1);
                    }
                }
                goods.setGoodsNo(g.getGoodsCode());
                goods.setStockNum(0);
                goods.setSkuStr(g.getPropStr());
                goods.setPiPrice(MoneyUtil.StringToLong(g.getSinglePiPrice()));
                if (g.getPicPath() != null) {
                    if (g.getPicPath().contains("taobaocdn") || g.getPicPath().contains("alicdn") || g.getPicPath().contains("imgs.571xz.net")) {
                        goods.setPicPath(g.getPicPath() + "_60x60.jpg");
                    } else {
                        goods.setPicPath(g.getPicPath());
                    }
                }
            } else {
                goods.setNum(goods.getNum() + g.getGoodsNum());
                if (codeMore == null||codeMore.size()==0) {
                    goods.setHasNum(goods.getHasNum() + g.getGoodsNum());
                    goods.setCode(goods.getCode() + "," + code);
                } else {
                    if (codemoremap.get(code) != null) {
                        goods.setHasNum(goods.getHasNum() + g.getGoodsNum());
                        goods.setGgoodsStatus(2);
                        if (goods.getCode().equals("")) {
                            goods.setCode(code);
                        } else {
                            goods.setCode(goods.getCode() + "," + code);
                        }
                    } else {
                        if (goods.getNotCode().equals("")) {
                            goods.setNotCode(code);
                        } else {
                            goods.setNotCode(goods.getNotCode() + "," + code);
                        }
                    }
                }

            }
            sku.setTotalNum(sku.getTotalNum() + g.getGoodsNum());
            sku.setTotalPiPrice(sku.getTotalPiPrice() + MoneyUtil.StringToLong(g.getSinglePiPrice()));
            sumNum += g.getGoodsNum();
            sumPrice += goods.getPiPrice();
            if (vi == null) {
                goodsList.add(goods);
            } else {
                goodsList.set(vi, goods);
            }
            m.put(g.getDfOrderId(), 1);
            if (i == null) {
                skus.add(sku);
            } else {
                skus.set(i, sku);
            }
        }
        for (WorkUserGgoodsTasksSku sku : skus) {
            for (WorkUserGgoodsTasksGoods g : sku.getGoods()) {
                if (g.getGgoodsStatus() != null && g.getGgoodsStatus() == 2) {
                    sku.setGgoodsStatus(2);
                    break;
                }
            }
            if (sku.getGgoodsStatus() == null) {
                sku.setGgoodsStatus(1);
            }
        }
        res.setSkuList(skus);
        res.setStoreName(storename);
        res.setSumNum(sumNum);
        res.setSumPrice(sumPrice);
        return res;
    }

    public ShortCompleteCheckedResponse shortCompleteChecked(Long daifaWorkerId, List<Long> orderIds, Integer status) throws SystemInterfaceException {
        if (daifaWorkerId == null || orderIds == null || orderIds.size() == 0 || status == null) {
            throw new SystemInterfaceException("缺少参数");
        }
        List<Long> oids = new ArrayList<>();
        oids.addAll(orderIds);
        String nowDate = DateUtil.dateToString(new Date(), DateUtil.patternB);
        DaifaGgoodsExample example = new DaifaGgoodsExample();
        example.createCriteria().andDfOrderIdIn(oids).andCreateDateEqualTo(nowDate)
                .andDaifaWorkerIdEqualTo(daifaWorkerId).andUseStatusEqualTo(1);
        List<DaifaGgoods> gs = daifaGgoodsMapper.selectByExample(example);
        DaifaOrderExample example3 = new DaifaOrderExample();
        example3.createCriteria().andDfOrderIdIn(oids);
        List<DaifaOrder> orders = daifaOrderMapper.selectFieldsByExample(example3, FieldUtil.codeFields("df_order_id,df_trade_id"));
        List<WorkUserGgoodsTasksSku> skus = new ArrayList<WorkUserGgoodsTasksSku>();
        Long storeId = null;
        StringBuilder storenull = new StringBuilder();
        String storename = null;
        int sumNum = 0;
        long sumPrice = 0l;
        Set<Long> priceOrderIds = new HashSet<>();
        for (DaifaGgoods g : gs) {
            priceOrderIds.add(g.getDfOrderId());
            Integer v1 = null;
            WorkUserGgoodsTasksSku sku = null;
            for (int v = 0; v < skus.size(); v++) {
                WorkUserGgoodsTasksSku s = skus.get(v);
                if ((s.getGoodsNo() + "").equals(g.getGoodsCode() + "")) {
                    sku = s;
                    v1 = v;
                    break;
                }
            }
            if (sku == null) {
                sku = new WorkUserGgoodsTasksSku();
                sku.setGoods(new ArrayList<>());
                sku.setGoodsNo(g.getGoodsCode());
                sku.setTotalNum(0);
                sku.setTotalPiPrice(0L);
            }
            if (storename == null) {
                storename = g.getMarketName() + "(" + g.getStoreNum() + ")";
            }
            List<WorkUserGgoodsTasksGoods> goodsList = sku.getGoods();
            WorkUserGgoodsTasksGoods goods = null;
            String code = null;
            for (DaifaOrder o : orders) {
                if (o.getDfOrderId().longValue() == g.getDfOrderId().longValue()) {
                    code = o.getDfOrderId() + "" + (o.getDfTradeId().toString().substring(0, 7));
                    break;
                }
            }
            if (code == null) {
                continue;
            }
            if (g.getStoreId() == null) {
                storenull.append(code).append(",");
                continue;
            }
            if (storeId == null) {
                storeId = g.getStoreId();
            } else {
                if (storeId.longValue() != g.getStoreId().longValue()) {
                    throw new SystemInterfaceException("档口不匹配");
                }
            }
            Integer vi = null;
            for (int v = 0; v < goodsList.size(); v++) {
                WorkUserGgoodsTasksGoods go = goodsList.get(v);
                if ((go.getGoodsNo() + "" + go.getSkuStr() + go.getPiPrice()).equals(g.getGoodsCode() + "" + g.getPropStr() + MoneyUtil.StringToLong(g.getSinglePiPrice()))) {
                    goods = go;
                    vi = v;
                    break;
                }
            }
            if (goods == null) {
                goods = new WorkUserGgoodsTasksGoods();
                goods.setNum(g.getGoodsNum());
                goods.setHasNum(g.getGoodsNum());
                goods.setCode(code);
                goods.setGgoodsStatus(g.getTakeGoodsStatus() + 1);
                goods.setGoodsNo(g.getGoodsCode());
                goods.setStockNum(0);
                goods.setSkuStr(g.getPropStr());
                goods.setPiPrice(MoneyUtil.StringToLong(g.getSinglePiPrice()));
                if (g.getPicPath() != null) {
                    if (g.getPicPath().contains("taobaocdn") || g.getPicPath().contains("alicdn") || g.getPicPath().contains("imgs.571xz.net")) {
                        goods.setPicPath(g.getPicPath() + "_60x60.jpg");
                    } else {
                        goods.setPicPath(g.getPicPath());
                    }
                }
            } else {
                goods.setNum(goods.getNum() + g.getGoodsNum());
                goods.setHasNum(goods.getHasNum() + g.getGoodsNum());
                goods.setCode(goods.getCode() + "," + code);
            }
            sku.setTotalNum(sku.getTotalNum() + g.getGoodsNum());
            sku.setTotalPiPrice(sku.getTotalPiPrice() + MoneyUtil.StringToLong(g.getSinglePiPrice()));
            sumNum += g.getGoodsNum();
            sumPrice += goods.getPiPrice();
            if (vi == null) {
                goodsList.add(goods);
            } else {
                goodsList.set(vi, goods);
            }
            if (v1 == null) {
                skus.add(sku);
            } else {
                skus.set(v1, sku);
            }
            for (int i = 0; i < oids.size(); i++) {
                if (g.getDfOrderId().longValue() == oids.get(i).longValue()) {
                    oids.remove(i);
                    break;
                }
            }
        }
        if (storenull.length() > 1) {
            throw new SystemInterfaceException("档口不匹配");
        }

        if (status == 2) {
            List<Long> noids = new ArrayList<Long>();
            noids.addAll(orderIds);
            sumNum = 0;
            sumPrice = 0L;
            example = new DaifaGgoodsExample();
            example.createCriteria().andDfOrderIdNotIn(noids).andCreateDateEqualTo(nowDate)
                    .andStoreIdEqualTo(storeId)
                    .andDaifaWorkerIdEqualTo(daifaWorkerId).andUseStatusEqualTo(1);
            gs = daifaGgoodsMapper.selectByExample(example);
            List<Long> aoid = new ArrayList<Long>();
            for (DaifaGgoods g : gs) {
                aoid.add(g.getDfOrderId());
            }
            example3 = new DaifaOrderExample();
            example3.createCriteria().andDfOrderIdIn(aoid);
            orders = daifaOrderMapper.selectFieldsByExample(example3, FieldUtil.codeFields("df_order_id,df_trade_id"));
            skus = new ArrayList<WorkUserGgoodsTasksSku>();
            for (DaifaGgoods g : gs) {
                Integer v1 = null;
                WorkUserGgoodsTasksSku sku = null;
                for (int v = 0; v < skus.size(); v++) {
                    WorkUserGgoodsTasksSku s = skus.get(v);
                    if ((s.getGoodsNo() + "").equals(g.getGoodsCode() + "")) {
                        sku = s;
                        v1 = v;
                        break;
                    }
                }
                if (sku == null) {
                    sku = new WorkUserGgoodsTasksSku();
                    sku.setGoods(new ArrayList<>());
                    sku.setGoodsNo(g.getGoodsCode());
                    sku.setTotalNum(0);
                    sku.setTotalPiPrice(0L);
                }
                List<WorkUserGgoodsTasksGoods> goodsList = sku.getGoods();
                WorkUserGgoodsTasksGoods goods = null;
                String code = null;
                for (DaifaOrder o : orders) {
                    if (o.getDfOrderId().longValue() == g.getDfOrderId().longValue()) {
                        code = o.getDfOrderId() + "" + (o.getDfTradeId().toString().substring(0, 7));
                        break;
                    }
                }
                Integer vi = null;
                for (int v = 0; v < goodsList.size(); v++) {
                    WorkUserGgoodsTasksGoods go = goodsList.get(v);
                    if ((go.getGoodsNo() + "" + go.getSkuStr() + go.getPiPrice()).equals(g.getGoodsCode() + "" + g.getPropStr() + MoneyUtil.StringToLong(g.getSinglePiPrice()))) {
                        goods = go;
                        vi = v;
                        break;
                    }
                }
                if (goods == null) {
                    goods = new WorkUserGgoodsTasksGoods();
                    goods.setNum(g.getGoodsNum());
                    goods.setHasNum(g.getGoodsNum());
                    goods.setCode(code);
                    goods.setGgoodsStatus(g.getTakeGoodsStatus() + 1);
                    goods.setGoodsNo(g.getGoodsCode());
                    goods.setStockNum(0);
                    goods.setSkuStr(g.getPropStr());
                    goods.setPiPrice(MoneyUtil.StringToLong(g.getSinglePiPrice()));
                    if (g.getPicPath() != null) {
                        if (g.getPicPath().contains("taobaocdn") || g.getPicPath().contains("alicdn") || g.getPicPath().contains("imgs.571xz.net")) {
                            goods.setPicPath(g.getPicPath() + "_60x60.jpg");
                        } else {
                            goods.setPicPath(g.getPicPath());
                        }
                    }
                } else {
                    goods.setNum(goods.getNum() + g.getGoodsNum());
                    goods.setHasNum(goods.getHasNum() + g.getGoodsNum());
                    goods.setCode(goods.getCode() + "," + code);
                }
                sku.setTotalNum(sku.getTotalNum() + g.getGoodsNum());
                sku.setTotalPiPrice(sku.getTotalPiPrice() + MoneyUtil.StringToLong(g.getSinglePiPrice()));
                sumNum += g.getGoodsNum();
                sumPrice += goods.getPiPrice();
                if (vi == null) {
                    goodsList.add(goods);
                } else {
                    goodsList.set(vi, goods);
                }
                if (v1 == null) {
                    skus.add(sku);
                } else {
                    skus.set(v1, sku);
                }
            }
        } else {
            if (oids.size() > 0) {
                example = new DaifaGgoodsExample();
                example.createCriteria().andDfOrderIdIn(oids).andCreateDateEqualTo(nowDate)
                        .andDaifaWorkerIdEqualTo(daifaWorkerId);
                example.setOrderByClause("create_time desc");
                gs = daifaGgoodsMapper.selectByExample(example);
                StringBuilder err = new StringBuilder();
                Map<Long, Long> m = new HashMap<Long, Long>();
                for (DaifaGgoods g : gs) {
                    if (m.get(g.getDfOrderId()) != null) {
                        continue;
                    }
                    if (g.getTakeGoodsStatus() == 2) {
                        for (DaifaOrder o : orders) {
                            if (o.getDfOrderId().longValue() == g.getDfOrderId().longValue()) {
                                err.append(o.getDfOrderId()).append("").append(o.getDfTradeId().toString().substring(0, 7)).append(",");
                                break;
                            }
                        }
                    }
                    m.put(g.getDfOrderId(), g.getDfOrderId());
                }
                if (err.length() > 1) {
                    throw new SystemInterfaceException("以下订单为分配:" + err.toString());
                }
            }
        }
        ShortCompleteCheckedResponse vo = new ShortCompleteCheckedResponse();
        vo.setSkuList(skus);
        vo.setStoreName(storename);
        vo.setSumNum(sumNum);
        vo.setSumPrice(sumPrice);
        vo.setSuccess(true);
        return vo;
    }


    public void shortComplete(Long daifaWorkerId, Long storeId, Integer bostatus, List<Long> orderIds, List<NotCodeSets> notCodes) throws SystemInterfaceException, DaifaException {
        if (daifaWorkerId == null || storeId == null || bostatus == null || orderIds == null || orderIds.size() == 0) {
            throw new SystemInterfaceException("缺少参数");
        }
        DaifaGgoodsExample example = new DaifaGgoodsExample();
        example.createCriteria().andUseStatusEqualTo(1).andStoreIdEqualTo(storeId).andDfOrderIdIn(orderIds)
                .andDaifaWorkerIdEqualTo(daifaWorkerId)
                .andOperateIsEqualTo(0);
        List<DaifaGgoods> daifaGgoods = daifaGgoodsMapper.selectFieldsByExample(example, FieldUtil.codeFields("take_goods_id,df_order_id"));

        List<Long> takeIds = BeanMapper.getFieldList(daifaGgoods, "takeGoodsId", Long.class);
        UnComleteAllVO vo =takeGoodsIssueProcess.uncompleteAllNew(daifaWorkerId, storeId, takeIds, bostatus == 1);
        if (notCodes != null && notCodes.size() != 0) {
            for (NotCodeSets nc : notCodes) {
                List<Long> upoids = nc.getOrderIds();
                int day = nc.getDay();
                if (day > 0 && upoids.size() > 0) {
                    if (day == 20) {
                        for (Long oid : upoids) {
                            orderManageProcess.markSubOrder(oid, "价格不符");
                        }
                    } else {
                        Date d1 = DateUtil.getdate(day);
                        if (day == 10) {
                            for (Long oid : upoids) {
                                orderManageProcess.markDown(oid);
                            }
                        } else {
                            for (Long oid : upoids) {
                                orderManageProcess.haveGoodsTime(oid, d1);
                            }
                        }
                    }
                }
            }
        }
        //发送缺货信息到order-server
        for(Long notTakeDfOrderId:vo.getNotTakeIds()){
            daifaAllocatedService.orderServerNotTake(notTakeDfOrderId);
        }

        if(vo.getTakeIds()!=null&&vo.getTakeIds().size()>0){
            for(Long takeDfOrderId:vo.getTakeIds()){
                daifaAllocatedService.orderServerTake(takeDfOrderId);
            }
            //获取已拿到的主单ID集合
            DaifaOrderExample daifaOrderExample=new DaifaOrderExample();
            daifaOrderExample.createCriteria().andDfOrderIdIn(vo.getTakeIds());
            List<DaifaOrder> hasOrders=daifaOrderMapper.selectFieldsByExample(daifaOrderExample,FieldUtil.codeFields("df_order_id,df_trade_id"));
            if(hasOrders.size()>0){
                Set<Long> dfTradeIds=BeanMapper.getFieldSet(hasOrders,"dfTradeId",Long.class);
                List<Long> tids=new ArrayList<>(dfTradeIds);
                DaifaTradeExample daifaTradeExample=new DaifaTradeExample();
                daifaTradeExample.createCriteria().andDfTradeIdIn(tids);
                List<DaifaTrade> trades=daifaTradeMapper.selectFieldsByExample(daifaTradeExample,FieldUtil.codeFields("df_trade_id,express_id,express_name"));
                Map<Long,List<DaifaTrade>> tradeMap=BeanMapper.groupBy(trades,"expressId",Long.class);
                Set<String> expressNames=new HashSet<>();
                for(List<DaifaTrade> ts:tradeMap.values()){
                    for(DaifaTrade t:ts){
                        try {
                            packDeliveryProcess.queryExpressCode(t.getDfTradeId());
                        } catch (DaifaException e) {
                            expressNames.add(t.getExpressName());
                            break;
                        }
                    }
                }
                if(expressNames.size()>0){
                    for(String expressName:expressNames){
                        String str=expressName+"可用单号不足,请及时联系快递补充单号.";
                        SmsJsoup u=new SmsJsoup();
                        String phones=errorSendPhone;//接收号码集合
                        Date sendTime=new Date();//定时发送时间
                        u.sendHySms(phones,str,sendTime);
                    }
                }
            }
        }

    }

}
