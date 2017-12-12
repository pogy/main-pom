package com.shigu.main4.daifa.model.impl;

import com.opentae.data.daifa.beans.*;
import com.opentae.data.daifa.examples.*;
import com.opentae.data.daifa.interfaces.*;
import com.shigu.main4.common.util.BeanMapper;
import com.shigu.main4.common.util.DateUtil;
import com.shigu.main4.common.util.MoneyUtil;
import com.shigu.main4.daifa.enums.DaifaSendMqEnum;
import com.shigu.main4.daifa.exceptions.IsOldException;
import com.shigu.main4.daifa.exceptions.DaifaException;
import com.shigu.main4.daifa.model.SaleAfterModel;
import com.shigu.main4.daifa.model.ScanSaleAfterExpressModel;
import com.shigu.main4.daifa.utils.MQUtil;
import com.shigu.main4.tools.SpringBeanFactory;
import net.sf.json.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Repository
@Scope("prototype")
public class SaleAfterModelImpl implements SaleAfterModel {

    @Autowired
    private DaifaOrderMapper daifaOrderMapper;
    @Autowired
    private DaifaTradeMapper daifaTradeMapper;
    @Autowired
    private DaifaAfterSaleMapper daifaAfterSaleMapper;
    @Autowired
    private DaifaAfterSaleSubMapper daifaAfterSaleSubMapper;
    @Autowired
    private DaifaAfterMoneyConsultMapper daifaAfterMoneyConsultMapper;
    @Autowired
    private DaifaAfterReceiveExpresStockMapper daifaAfterReceiveExpresStockMapper;
    @Autowired
    private DaifaStockMapper daifaStockMapper;
    @Autowired
    private DaifaStockRecordMapper daifaStockRecordMapper;
    @Autowired
    private DaifaWorkerMapper daifaWorkerMapper;
    @Autowired
    private MQUtil mqUtil;


    private Long refundId;

    public SaleAfterModelImpl(Long refundId) throws DaifaException {
        super();
        if(refundId==null){
            throw new DaifaException("refundId is null",DaifaException.DEBUG);
        }
        this.refundId = refundId;
    }
    public SaleAfterModelImpl() {
        super();
    }
    public Long getRefundId() {
        return refundId;
    }

    public void setRefundId(Long refundId) {
        this.refundId = refundId;
    }

    /**
     * ====================================================================================
     *
     * @方法名： afterApply
     * @user gzy 2017/9/15 11:21
     * @功能： 代发售后申请的写入 客户发起
     * @param: orderCode外部子单号, afterType售后类型(1退货2换货), num申请数量, reason原因
     * @return:
     * @exception: ====================================================================================
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {Exception.class}, isolation = Isolation.DEFAULT)
    public String saleAfterApply(Long orderCode, Integer afterType, Integer num, String reason) throws DaifaException {
        DaifaOrder tmpo=new DaifaOrder();
        tmpo.setRefundId(refundId);
        Integer count=daifaOrderMapper.selectCount(tmpo);
        if(count>0){
            throw new DaifaException("售后信息已存在",DaifaException.DEBUG);
        }
        DaifaOrderExample daifaOrderExample = new DaifaOrderExample();
        daifaOrderExample.createCriteria().andOrderCodeEqualTo(orderCode.toString()).andRefundIdIsNull();
        List<DaifaOrder> orders = daifaOrderMapper.selectByExample(daifaOrderExample);
        if (orders.size() == 0) {
            //订单不存在
            throw new DaifaException("订单不存在",DaifaException.DEBUG);
        }
        if (orders.size() < num) {
            //申请的售后的件数大于可申请售后的数量
            throw new DaifaException("申请的售后的件数大于可申请售后的数量",DaifaException.DEBUG);
        }

        List<Long> afterOids=BeanMapper.getFieldList(orders,"dfOrderId",Long.class);

        DaifaAfterSale after = new DaifaAfterSale();
        after.setDfTradeId(orders.get(0).getDfTradeId());
        after = daifaAfterSaleMapper.selectOne(after);

        Date time = new Date();
        String date = DateUtil.dateToString(time, DateUtil.patternB);
        DaifaTrade trade = daifaTradeMapper.selectByPrimaryKey(orders.get(0).getDfTradeId());

        List<Long> updateIds = new ArrayList<>();
        if (after == null) {
            if (trade.getSendStatus() != 2) {
                //未发货,不能申请售后
                throw new DaifaException("未发货,不能申请售后",DaifaException.DEBUG);
            }
            after = BeanMapper.map(trade, DaifaAfterSale.class);
            after.setCreateTime(time);
            after.setCreateDate(date);
            after.setReceiverMobile(trade.getReceiverPhone());
            after.setBuyerRemark(null);
            after.setRemark1(null);
            after.setRemark2(null);
            daifaAfterSaleMapper.insert(after);
            List<DaifaAfterSaleSub> subs = new ArrayList<>();
            int i = 0;
            DaifaOrderExample daifaOrderExample1 = new DaifaOrderExample();
            daifaOrderExample1.createCriteria().andDfTradeIdEqualTo(trade.getDfTradeId());
            List<DaifaOrder> os = daifaOrderMapper.selectByExample(daifaOrderExample1);
            for (DaifaOrder o : os) {
                DaifaAfterSaleSub sub = BeanMapper.map(o, DaifaAfterSaleSub.class);
                sub.setAfterSaleId(after.getAfterSaleId());
                sub.setAfterStatus(0);
                sub.setCreateDate(date);
                sub.setCreateTime(time);
                sub.setBuyerTelephone(trade.getReceiverPhone());
                sub.setRemark(null);
                sub.setRemark1(null);
                sub.setRemark2(null);
                sub.setSellerId(trade.getSellerId());
                if (afterOids.contains(o.getDfOrderId()) && i < num) {
                    i++;
                    sub.setRefundId(refundId);
                    sub.setAfterType(afterType);
                    sub.setApplyTime(time);
                    sub.setAfterStatus(1);
                    updateIds.add(o.getDfOrderId());
                }
                subs.add(sub);
            }
            daifaAfterSaleSubMapper.insertListNoId(subs);
        } else {
            int i = 0;
            for (DaifaOrder o : orders) {
                if (i == num) {
                    break;
                }
                updateIds.add(o.getDfOrderId());
                i++;
            }
            DaifaAfterSaleSub sub = new DaifaAfterSaleSub();
            sub.setRefundId(refundId);
            sub.setAfterType(afterType);
            sub.setApplyTime(time);
            sub.setAfterStatus(1);
            sub.setBuyerTelephone(trade.getReceiverPhone());
            DaifaAfterSaleSubExample daifaAfterSaleSubExample = new DaifaAfterSaleSubExample();
            daifaAfterSaleSubExample.createCriteria().andDfOrderIdIn(updateIds);
            daifaAfterSaleSubMapper.updateByExampleSelective(sub, daifaAfterSaleSubExample);
        }
        DaifaOrder tmp = new DaifaOrder();
        tmp.setRefundId(refundId);
        if (afterType == 1) {
            tmp.setReCause(reason);
            tmp.setReturnGoodsApplyTime(time);
            tmp.setReturnGoodsStatus(1);
        } else {
            tmp.setChangeTime(time);
            tmp.setChangeReason(reason);
            tmp.setChangeStatus(1);
        }
        DaifaOrderExample updateDaifaOrderExample = new DaifaOrderExample();
        updateDaifaOrderExample.createCriteria().andDfOrderIdIn(updateIds);
        daifaOrderMapper.updateByExampleSelective(tmp, updateDaifaOrderExample);
        return null;
    }

    /**
     * ====================================================================================
     * @方法名： afterApplyDeal
     * @user gzy 2017/9/15 11:22
     * @功能： 代发售后申请的处理 客服处理
     * @param: status是否同意申请(1同意2拒绝),reason拒绝理由
     * 同意发回收货地址，如果不同意返回拒绝的理由
     * @return:
     * @exception:
     * ====================================================================================
     *
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {Exception.class}, isolation = Isolation.DEFAULT)
    public String saleAfterApplyDeal(Integer status, String reason) throws DaifaException {
        DaifaAfterSaleSub tmp = new DaifaAfterSaleSub();
        tmp.setRefundId(refundId);
        List<DaifaAfterSaleSub> subs = daifaAfterSaleSubMapper.select(tmp);
        if (subs.size() == 0) {
            //售后申请不存在
            throw new DaifaException("售后申请不存在",DaifaException.DEBUG);
        }
        if (subs.get(0).getAfterStatus() != 1) {
            //售后状态错误,不是申请中的状态
            throw new DaifaException("售后状态错误,不是申请中的订单",DaifaException.DEBUG);
        }
        DaifaAfterSaleSub daifaAfterSaleSub = new DaifaAfterSaleSub();
        daifaAfterSaleSub.setAfterStatus(2);
        daifaAfterSaleSub.setApplyDealStatus(status);
        daifaAfterSaleSub.setApplyDealTime(new Date());
        if (status == 2) {
            if(StringUtils.isEmpty(reason)){
                throw new DaifaException("请填写拒绝理由",DaifaException.DEBUG);
            }
            daifaAfterSaleSub.setApplyRefuseReason(reason);
        }
        updateAfterSubs(daifaAfterSaleSub);

        Map<String,Object> map=new HashMap<>();
        switch (status) {
            case 1: {
                //同意受理
                map.put("refundId",refundId);
                map.put("canRefund",true);
                break;
            }
            case 2: {
                //拒绝受理
                map.put("refundId",refundId);
                map.put("canRefund",false);
                map.put("reason",reason);
                break;
            }
        }
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("data",map);
        jsonObject.put("msg", DaifaSendMqEnum.afterSaleAccept.getMsg());
        jsonObject.put("status","true");
        mqUtil.sendMessage(DaifaSendMqEnum.afterSaleAccept.getMessageKey()+refundId,
                DaifaSendMqEnum.afterSaleAccept.getMessageTag(), jsonObject.toString());
        return null;
    }


    /**
     * ====================================================================================
     *
     * @方法名： saleAfterExpress
     * @user gzy 2017/9/15 12:13
     * @功能： 代发快递信息的写入  客户发起
     * @param:
     * @return:
     * @exception: ====================================================================================
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {Exception.class}, isolation = Isolation.DEFAULT)
    public String saleAfterExpress(String expressName, String expressCode) throws DaifaException {
        DaifaAfterSaleSub tmp = new DaifaAfterSaleSub();
        tmp.setRefundId(refundId);
        List<DaifaAfterSaleSub> subs = daifaAfterSaleSubMapper.select(tmp);
        if (subs.size() == 0) {
            //售后申请不存在
            throw new DaifaException("售后申请不存在",DaifaException.DEBUG);
        }
        List<Integer> status = Arrays.asList(2, 3);
        if (!status.contains(subs.get(0).getAfterStatus()) ||
                (subs.get(0).getApplyDealStatus() != null && subs.get(0).getApplyDealStatus() == 2)) {
            //售后状态错误,当前状态不能设置退回快递信息
            throw new DaifaException("售后状态错误,当前状态不能设置退回快递信息",DaifaException.DEBUG);
        }
        DaifaAfterSaleSub daifaAfterSaleSub = new DaifaAfterSaleSub();
        daifaAfterSaleSub.setAfterStatus(3);
        daifaAfterSaleSub.setApplyExpressCode(expressCode);
        daifaAfterSaleSub.setApplyExpressName(expressName);
        updateAfterSubs(daifaAfterSaleSub);

        //查询包裹,如果存在包裹,则前往绑定
        DaifaAfterReceiveExpresStockExample daifaAfterReceiveExpresStockExample=new DaifaAfterReceiveExpresStockExample();
        daifaAfterReceiveExpresStockExample.createCriteria().andReceivedExpressCodeEqualTo(expressCode);
        if(daifaAfterReceiveExpresStockMapper.countByExample(daifaAfterReceiveExpresStockExample)>0){
            ScanSaleAfterExpressModel model= SpringBeanFactory.getBean(ScanSaleAfterExpressModel.class);
            model.expressScanRelevance(expressCode);
        }
        return null;
    }

    @Override
    public int saleAfterRemark(Long afterSaleId, String remark) throws DaifaException {
        DaifaAfterSale oldSale = daifaAfterSaleMapper.selectByPrimaryKey(afterSaleId);
        if (oldSale == null) {
            throw new DaifaException("售后申请不存在",DaifaException.DEBUG);
        }
        DaifaAfterSale daifaAfterSale = new DaifaAfterSale();
        daifaAfterSale.setAfterSaleId(afterSaleId);
        daifaAfterSale.setRemark(oldSale.getRemark()==null?remark:(oldSale.getRemark()+"<br>"+remark));
        return daifaAfterSaleMapper.updateByPrimaryKeySelective(daifaAfterSale);
    }

    /**
     * ====================================================================================
     *
     * @方法名： storeRefundMoney
     * @user gzy 2017/9/15 11:41
     * @功能： 档口退货成功退款 客服处理
     * @param: money金额
     * @return:
     * @exception: ====================================================================================
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {Exception.class}, isolation = Isolation.DEFAULT)
    public String storeRefundMoney(String money) throws DaifaException {
        DaifaAfterSaleSub tmp = new DaifaAfterSaleSub();
        tmp.setRefundId(refundId);
        List<DaifaAfterSaleSub> subs = daifaAfterSaleSubMapper.select(tmp);
        if (subs.size() == 0) {
            //售后申请不存在
            throw new DaifaException("售后申请不存在",DaifaException.DEBUG);
        }

        if (subs.get(0).getAfterStatus() < 4) {
            //售后状态错误,未收到货
            throw new DaifaException("售后状态错误,未收到货",DaifaException.DEBUG);
        }

        //读取退款成功的id集合
        List<Long> entIds = new ArrayList<>();
        Long maxMoney=0L;
        for (DaifaAfterSaleSub sub1 : subs) {
            maxMoney+=MoneyUtil.StringToLong(sub1.getSinglePiPrice())*sub1.getGoodsNum();
            if(sub1.getAfterStatus()>4){
                continue;
            }
            if(sub1.getInStock()==null){
                storeRefundRefuse(sub1.getDfOrderId(),"未收到货");
                continue;
            }
            if (sub1.getStoreDealStatus() == null || sub1.getStoreDealStatus() != 2) {
                try {
                    int intOutType=selNowStockStatus(sub1.getDfOrderId());
                    if(intOutType!=3){
                        throw new DaifaException("设置失败,存在未处理完的商品");
                    }
                } catch (IsOldException ignored) {
                }
                entIds.add(sub1.getAfterSaleSubId());
            }
        }
        if(MoneyUtil.StringToLong(money)>maxMoney){
            throw new DaifaException("售后状态错误,超过可退总额",DaifaException.DEBUG);
        }
        //entIds数量为0,即所有都已经处理过,跳出
        if(entIds.size()==0){
            return null;
        }
        //设置为已退款
        DaifaAfterSaleSub update = new DaifaAfterSaleSub();
        update.setStoreDealStatus(1);
        update.setAfterStatus(5);
        update.setStoreDealTime(new Date());
        update.setStoreReturnMoney(MoneyUtil.dealPrice(MoneyUtil.StringToLong(money) / entIds.size()));
        DaifaAfterSaleSubExample daifaAfterSaleSubExample = new DaifaAfterSaleSubExample();
        daifaAfterSaleSubExample.createCriteria().andAfterSaleSubIdIn(entIds);
        daifaAfterSaleSubMapper.updateByExampleSelective(update, daifaAfterSaleSubExample);

        //校验是否处理完整个refund
        tmp = new DaifaAfterSaleSub();
        tmp.setRefundId(refundId);
        subs = daifaAfterSaleSubMapper.select(tmp);
        for (DaifaAfterSaleSub s : subs) {
            if (s.getAfterStatus() != 5) {
                return null;
            }
        }
        //议价消息
        JSONObject jsonObject=new JSONObject();
        Map<String,Object> map=new HashMap<>();
        map.put("refundId",refundId);
        map.put("storeMoney",MoneyUtil.StringToLong(money));
        jsonObject.put("data",map);
        jsonObject.put("msg", DaifaSendMqEnum.repriceApply.getMsg());
        jsonObject.put("status","true");
        mqUtil.sendMessage(DaifaSendMqEnum.repriceApply.getMessageKey()+refundId,
                DaifaSendMqEnum.repriceApply.getMessageTag(), jsonObject.toString());
        return null;
    }

    /**
     * ====================================================================================
     *
     * @方法名： storeReturnRefuse
     * @user gzy 2017/9/15 11:39
     * @功能： 档口退货拒绝 客服处理
     * @param: orderId代发子订单ID, reason原因
     * @return:
     * @exception: ====================================================================================
     */
    @Override
    public String storeRefundRefuse(Long orderId, String reason) throws DaifaException {
        DaifaAfterSaleSub sub = new DaifaAfterSaleSub();
        sub.setDfOrderId(orderId);
        sub = daifaAfterSaleSubMapper.selectOne(sub);
        if (sub == null) {
            //售后申请不存在
            throw new DaifaException("售后申请不存在",DaifaException.DEBUG);
        }
        if (sub.getAfterStatus() != 4) {
            //售后状态错误,未收到货
            throw new DaifaException("售后状态错误,未收到货",DaifaException.DEBUG);
        }
        DaifaAfterSaleSub update = new DaifaAfterSaleSub();
        update.setStoreDealStatus(2);
        update.setAfterStatus(5);
        update.setStoreDealTime(new Date());
        update.setStoreRefuseReason(reason);
        update.setAfterSaleSubId(sub.getAfterSaleSubId());
        update.setStoreReturnMoney("0.00");
        daifaAfterSaleSubMapper.updateByPrimaryKeySelective(update);

        DaifaOrder o=new DaifaOrder();
        o.setDfOrderId(sub.getDfOrderId());
        if(sub.getAfterType()==1){
            o.setReturnGoodsStatus(3);
        }else{
            o.setChangeStatus(3);
        }
        daifaOrderMapper.updateByPrimaryKeySelective(o);

        //校验是否处理完整个refund
        int num=0;
        boolean isLast=true;
        DaifaAfterSaleSub tmp = new DaifaAfterSaleSub();
        tmp.setRefundId(sub.getRefundId());
        List<DaifaAfterSaleSub> subs = daifaAfterSaleSubMapper.select(tmp);
        for (DaifaAfterSaleSub s : subs) {
            if (s.getAfterStatus() != 5&&s.getInStock()!=null) {
                isLast=false;
                continue;
            }
            num++;
        }
        if(isLast){
            for(DaifaAfterSaleSub s : subs){
                if(s.getAfterStatus() != 5&&s.getInStock()==null){
                    update = new DaifaAfterSaleSub();
                    update.setStoreDealStatus(2);
                    update.setAfterStatus(5);
                    update.setStoreDealTime(new Date());
                    update.setStoreRefuseReason("未收到货");
                    update.setAfterSaleSubId(s.getAfterSaleSubId());
                    update.setStoreReturnMoney("0.00");
                    daifaAfterSaleSubMapper.updateByPrimaryKeySelective(update);
                    num++;
                }
            }
        }
        //发送档口拒绝消息
        JSONObject jsonObject=new JSONObject();
        Map<String,Object> map=new HashMap<>();
        map.put("refundId",sub.getRefundId());
        map.put("num",num);
        jsonObject.put("data",map);
        jsonObject.put("msg",StringUtils.isEmpty(reason)?DaifaSendMqEnum.shopRefuse.getMsg():reason);
        jsonObject.put("status","true");
        mqUtil.sendMessage(DaifaSendMqEnum.shopRefuse.getMessageKey()+sub.getRefundId(),
                DaifaSendMqEnum.shopRefuse.getMessageTag(), jsonObject.toString());
        return null;
    }

    /**
     * ====================================================================================
     *
     * @方法名： refundFailInStock
     * @user gzy 2017/9/15 11:45
     * @功能： 售后入库  客服处理
     * @param: orderId代发子订单ID, inStockType入库类型(1售后退货入库2退货失败入库)，stockLocktion库位,sendPhone包裹手机号(退货入库时传)
     * @return:
     * @exception: ====================================================================================
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {Exception.class}, isolation = Isolation.DEFAULT)
    public String refundFailInStock(Long orderId, Integer inStockType, String stockLocktion,String sendPhone) throws DaifaException {
        DaifaAfterSaleSub tmp = new DaifaAfterSaleSub();
        tmp.setDfOrderId(orderId);
        tmp = daifaAfterSaleSubMapper.selectOne(tmp);
        if (tmp == null) {
            //售后申请不存在
            throw new DaifaException("售后申请不存在",DaifaException.DEBUG);
        }
        if (!(tmp.getAfterStatus() == 4 || (tmp.getAfterStatus() == 5 && tmp.getStoreDealStatus() == 2))) {
            //售后状态错误,之后收到货的状态或退货失败状态时才能入库
            throw new DaifaException("售后状态错误,只有收到货的状态或退货失败状态时才能入库",DaifaException.DEBUG);
        }
        DaifaAfterSaleSub sub = new DaifaAfterSaleSub();
        sub.setAfterSaleSubId(tmp.getAfterSaleSubId());
        sub.setInStock(inStockType);
        sub.setStockLocation(stockLocktion);
        daifaAfterSaleSubMapper.updateByPrimaryKeySelective(sub);
        if(inStockType==1){
            if(StringUtils.isEmpty(tmp.getApplyExpressCode())){
                throw new DaifaException("非法请求,售后订单未设置申请的快递,无法入库",DaifaException.DEBUG);
            }
            DaifaAfterReceiveExpresStock stock=new DaifaAfterReceiveExpresStock();
            stock.setRelevanceStatus(1);
            stock.setSendPhone(sendPhone);
            stock.setStockLocation(stockLocktion);
            DaifaAfterReceiveExpresStockExample daifaAfterReceiveExpresStockExample=new DaifaAfterReceiveExpresStockExample();
            daifaAfterReceiveExpresStockExample.createCriteria().andDfOrderIdEqualTo(orderId);
            daifaAfterReceiveExpresStockMapper.updateByExampleSelective(stock,daifaAfterReceiveExpresStockExample);
        }
        return null;
    }

    /**
     * 写入库存
     * @param afterSubId
     * @param workerId
     */
    @Override
    public void insertDaifaStock(Long afterSubId,Long workerId){
        DaifaAfterSaleSub sub=daifaAfterSaleSubMapper.selectByPrimaryKey(afterSubId);
        DaifaStock stock=new DaifaStock();
        stock.setDfOrderId(sub.getDfOrderId());
        stock.setDfTradeId(sub.getDfTradeId());
        stock.setSellerId(sub.getSellerId());
        daifaStockMapper.insertSelective(stock);
        insertDaifaStockRecord(1,stock.getStockId(),workerId,null);
    }

    /**
     * 写入出入库
     * @param stockStatus
     * @param stockId
     * @param workerId
     */
    @Override
    public void insertDaifaStockRecord(int stockStatus,Long stockId,Long workerId,String piCode){
        DaifaWorker worker=daifaWorkerMapper.selectByPrimaryKey(workerId);
        DaifaStockRecord daifaStockRecord=new DaifaStockRecord();
        daifaStockRecord.setDaifaWorker(worker.getDaifaWorker());
        daifaStockRecord.setDaifaWorkerId(workerId);
        daifaStockRecord.setInOutType(stockStatus);
        daifaStockRecord.setStockId(stockId);
        switch (stockStatus){
            case 1:{
                daifaStockRecord.setInTime(new Date());
                break;
            }
            case 2:{
                daifaStockRecord.setOutTime(new Date());
                daifaStockRecord.setPiCode(piCode);
                break;
            }
            case 3:{
                daifaStockRecord.setReturnTime(new Date());
                break;
            }
        }
        daifaStockRecordMapper.insertSelective(daifaStockRecord);
    }



    /**
     * ====================================================================================
     *
     * @方法名： moneyConsultRefuse
     * @user gzy 2017/9/15 11:51
     * @功能： 客户拒绝协商金额 客户发起的
     * daifa_after_money_consult  客服协商金表城进行修改
     * @param: refundId退货ID
     * @return:
     * @exception: ====================================================================================
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {Exception.class}, isolation = Isolation.DEFAULT)
    public String moneyConsultRefuse() throws DaifaException {
        DaifaAfterSaleSub tmp = new DaifaAfterSaleSub();
        tmp.setRefundId(refundId);
        List<DaifaAfterSaleSub> subs = daifaAfterSaleSubMapper.select(tmp);
        if (subs.size() == 0) {
            //售后申请不存在
            throw new DaifaException("售后申请不存在",DaifaException.DEBUG);
        }
        Long refundMoney = 0L;
        for (DaifaAfterSaleSub s : subs) {
            if (!Arrays.asList(5,7).contains(s.getAfterStatus())) {
                throw new DaifaException("当前订单状态不可议价",DaifaException.DEBUG);
            }
            refundMoney += MoneyUtil.StringToLong(s.getStoreReturnMoney());
        }
        DaifaAfterMoneyConsultExample daifaAfterMoneyConsultExample = new DaifaAfterMoneyConsultExample();
        daifaAfterMoneyConsultExample.createCriteria().andRefundIdEqualTo(refundId);
        daifaAfterMoneyConsultExample.setOrderByClause("after_consult_id desc");
        List<DaifaAfterMoneyConsult> daifaAfterMoneyConsults = daifaAfterMoneyConsultMapper.selectByExample(daifaAfterMoneyConsultExample);
        int num = daifaAfterMoneyConsults.size() + 1;
        DaifaAfterMoneyConsult insert = new DaifaAfterMoneyConsult();
        insert.setRefundId(refundId);
        insert.setCreateTime(new Date());
        insert.setConsultType(2);
        insert.setConsultBatch(num);
        if (daifaAfterMoneyConsults.size() > 0) {
            if(daifaAfterMoneyConsults.get(0).getConsultType()==2){
                //当前已处于"拒绝协商金额"状态
                throw new DaifaException("当前已处于\"拒绝协商金额\"状态",DaifaException.DEBUG);
            }
            insert.setConsultMoney(daifaAfterMoneyConsults.get(0).getConsultMoney());
        } else {
            insert.setConsultMoney(MoneyUtil.dealPrice(refundMoney));
        }
        daifaAfterMoneyConsultMapper.insertSelective(insert);
        DaifaAfterSaleSub update=new DaifaAfterSaleSub();
        update.setAfterStatus(7);
        updateAfterSubs(update);
        return null;
    }

    @Override
    public String moneyConsultAgree() throws DaifaException {
        DaifaAfterSaleSub update=new DaifaAfterSaleSub();
        update.setAfterStatus(6);
        updateAfterSubs(update);
        DaifaAfterSaleSubExample daifaAfterSaleSubExample=new DaifaAfterSaleSubExample();
        daifaAfterSaleSubExample.createCriteria().andRefundIdEqualTo(refundId).andStoreDealStatusEqualTo(1);
        List<DaifaAfterSaleSub> subs=daifaAfterSaleSubMapper.selectByExample(daifaAfterSaleSubExample);
        if(subs.size()>0){
            List<Long> oids=BeanMapper.getFieldList(subs,"dfOrderId",Long.class);
            DaifaOrderExample daifaOrderExample=new DaifaOrderExample();
            daifaOrderExample.createCriteria().andDfOrderIdIn(oids);
            DaifaOrder o=new DaifaOrder();
            if(subs.get(0).getAfterType()==1){
                o.setReturnGoodsStatus(2);
                o.setReturnGoodsFinishTime(new Date());
            }else{
                o.setChangeStatus(2);
                o.setChangeTime(new Date());
            }
            daifaOrderMapper.updateByExampleSelective(o,daifaOrderExample);
        }
        return null;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {Exception.class}, isolation = Isolation.DEFAULT)
    public String moneyConsult(String money) throws DaifaException {
        DaifaAfterMoneyConsultExample daifaAfterMoneyConsultExample = new DaifaAfterMoneyConsultExample();
        daifaAfterMoneyConsultExample.createCriteria().andRefundIdEqualTo(refundId);
        daifaAfterMoneyConsultExample.setOrderByClause("after_consult_id desc");
        List<DaifaAfterMoneyConsult> daifaAfterMoneyConsults = daifaAfterMoneyConsultMapper.selectByExample(daifaAfterMoneyConsultExample);
        if(daifaAfterMoneyConsults.size()==0){
            //议价信息错误
            throw new DaifaException("议价信息错误",DaifaException.DEBUG);
        }
        DaifaAfterSaleSub tmp = new DaifaAfterSaleSub();
        tmp.setRefundId(refundId);
        List<DaifaAfterSaleSub> subs = daifaAfterSaleSubMapper.select(tmp);
        Long maxMoney=0L;
        for (DaifaAfterSaleSub sub1 : subs) {
            maxMoney+=MoneyUtil.StringToLong(sub1.getSinglePiPrice())*sub1.getGoodsNum();
        }
        if(MoneyUtil.StringToLong(money)>maxMoney){
            throw new DaifaException("售后状态错误,超过可退总额",DaifaException.DEBUG);
        }

        if(daifaAfterMoneyConsults.get(0).getConsultType()==2){
            DaifaAfterMoneyConsult insert=new DaifaAfterMoneyConsult();
            insert.setRefundId(refundId);
            insert.setCreateTime(new Date());
            insert.setConsultType(1);
            insert.setConsultBatch(daifaAfterMoneyConsults.size()+1);
            insert.setConsultMoney(MoneyUtil.dealPrice(MoneyUtil.StringToLong(money)));
            daifaAfterMoneyConsultMapper.insertSelective(insert);
        }else{
            throw new DaifaException("每次用户拒绝议价,只能设置一次金额",DaifaException.DEBUG);
//            DaifaAfterMoneyConsult update=new DaifaAfterMoneyConsult();
//            update.setAfterConsultId(daifaAfterMoneyConsults.get(0).getAfterConsultId());
//            update.setConsultMoney(MoneyUtil.dealPrice(MoneyUtil.StringToLong(money)));
//            daifaAfterMoneyConsultMapper.updateByPrimaryKeySelective(update);
        }
        //发送改金额消息
        JSONObject jsonObject=new JSONObject();
        Map<String,Object> map=new HashMap<>();
        map.put("refundId",refundId);
        map.put("storeMoney",MoneyUtil.StringToLong(money));
        jsonObject.put("data",map);
        jsonObject.put("msg", DaifaSendMqEnum.repriceApply.getMsg());
        jsonObject.put("status","true");
        mqUtil.sendMessage(DaifaSendMqEnum.repriceApply.getMessageKey()+refundId,
                DaifaSendMqEnum.repriceApply.getMessageTag(), jsonObject.toString());
        return null;
    }

    @Override
    public String changeEnt() throws DaifaException {
        DaifaAfterSaleSub tmp = new DaifaAfterSaleSub();
        tmp.setRefundId(refundId);
        List<DaifaAfterSaleSub> subs = daifaAfterSaleSubMapper.select(tmp);
        if (subs.size() == 0) {
            //售后申请不存在
            throw new DaifaException("售后申请不存在",DaifaException.DEBUG);
        }
        if(subs.get(0).getAfterType()!=2){
            throw new DaifaException("不是换货售后",DaifaException.DEBUG);
        }
        if(subs.get(0).getAfterStatus()!=4){
            throw new DaifaException("代发未收到货",DaifaException.DEBUG);
        }
        DaifaAfterSaleSub update=new DaifaAfterSaleSub();
        update.setAfterStatus(6);
        updateAfterSubs(update);
        return null;
    }

    private void updateAfterSubs(DaifaAfterSaleSub sub) {
        DaifaAfterSaleSubExample daifaAfterSaleSubExample = new DaifaAfterSaleSubExample();
        daifaAfterSaleSubExample.createCriteria().andRefundIdEqualTo(refundId);
        daifaAfterSaleSubMapper.updateByExampleSelective(sub, daifaAfterSaleSubExample);
    }

    @Override
    public int selNowStockStatus(Long dfOrderId) throws IsOldException {
        DaifaStock stock=new DaifaStock();
        stock.setDfOrderId(dfOrderId);
        stock=daifaStockMapper.selectOne(stock);
        if(stock==null){
            throw new IsOldException();
        }
        return selNowStockStatusByStockId(stock.getStockId());

    }

    @Override
    public int selNowStockStatusByStockId(Long stockId){
        DaifaStockRecordExample daifaStockRecordExample=new DaifaStockRecordExample();
        daifaStockRecordExample.createCriteria().andStockIdEqualTo(stockId);
        daifaStockRecordExample.setOrderByClause("stock_record_id desc");
        List<DaifaStockRecord> rs=daifaStockRecordMapper.selectByExample(daifaStockRecordExample);
        return rs.get(0).getInOutType();
    }
}
