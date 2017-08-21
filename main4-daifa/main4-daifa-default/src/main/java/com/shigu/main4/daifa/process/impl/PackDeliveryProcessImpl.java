package com.shigu.main4.daifa.process.impl;

import com.opentae.core.mybatis.utils.FieldUtil;
import com.opentae.data.daifa.beans.*;
import com.opentae.data.daifa.interfaces.*;
import com.shigu.main4.common.util.BeanMapper;
import com.shigu.main4.common.util.DateUtil;
import com.shigu.main4.daifa.bo.DeliveryBO;
import com.shigu.main4.daifa.bo.OrderExpressBO;
import com.shigu.main4.daifa.bo.SubOrderExpressBO;
import com.shigu.main4.daifa.exceptions.DaifaException;
import com.shigu.main4.daifa.model.ExpressModel;
import com.shigu.main4.daifa.model.OrderModel;
import com.shigu.main4.daifa.process.PackDeliveryProcess;
import com.shigu.main4.daifa.vo.ExpressVO;
import com.shigu.main4.daifa.vo.PackResultVO;
import com.shigu.main4.daifa.vo.PrintExpressVO;
import com.shigu.main4.tools.SpringBeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service("packDeliveryProcess")
public class PackDeliveryProcessImpl implements PackDeliveryProcess {
    @Autowired
    private DaifaOrderMapper daifaOrderMapper;
    @Autowired
    private DaifaWaitSendOrderMapper daifaWaitSendOrderMapper;
    @Autowired
    private DaifaSendMapper daifaSendMapper;
    @Autowired
    private DaifaSendOrderMapper daifaSendOrderMapper;
    @Autowired
    private DaifaSellerMapper daifaSellerMapper;
    @Autowired
    private DaifaTradeMapper daifaTradeMapper;
    @Override
    public PackResultVO packSubOrder(Long subOrderId) throws DaifaException {
        DaifaOrder order=daifaOrderMapper.selectByPrimaryKey(subOrderId);
        if(order==null){
            throw new DaifaException("此条码对应的订单编号不存在");
        }
        DaifaTrade trade=daifaTradeMapper.selectByPrimaryKey(order.getDfTradeId());
        if(trade.getSendStatus()==2){
            DaifaSend send=new DaifaSend();
            send.setDfTradeId(order.getDfTradeId());
            send=daifaSendMapper.selectOne(send);
            PackResultVO print = new PackResultVO();
            print.setSendId(send.getSendId());
            print.setGoodsInfo(order.getStoreGoodsCode()+"\t"+order.getPropStr());
            print.setExpressName(send.getExpressName());
            print.setExpressCode(send.getExpressCode());
            return print;
        }
        DaifaWaitSendOrder daifaWaitSendOrder=new DaifaWaitSendOrder();
        daifaWaitSendOrder.setDfOrderId(subOrderId);
        daifaWaitSendOrder=daifaWaitSendOrderMapper.selectOne(daifaWaitSendOrder);
        if(daifaWaitSendOrder==null){
            throw new DaifaException("此条码对应的商品全部暂未拿到货");
        }
        String lastScanDate= DateUtil.dateToString(new Date(),DateUtil.patternB);
        DaifaWaitSendOrder updateWaitSendOrder=new DaifaWaitSendOrder();
        updateWaitSendOrder.setDwsoId(daifaWaitSendOrder.getDwsoId());
        updateWaitSendOrder.setLastScanDate(lastScanDate);
        daifaWaitSendOrderMapper.updateByPrimaryKeySelective(updateWaitSendOrder);

        DaifaOrder tmpo=new DaifaOrder();
        tmpo.setDfTradeId(order.getDfTradeId());
        List<DaifaOrder> orders=daifaOrderMapper.select(tmpo);
        for(DaifaOrder o:orders){
            if(o.getAllocatStatus()==0&&(o.getRefundStatus() == null||o.getRefundStatus()!=2)){
                throw new DaifaException("此条码对应的部分商品未分配");
            }
            if(o.getTakeGoodsStatus()==2&&(o.getRefundStatus() == null||o.getRefundStatus()!=2)){
                throw new DaifaException("此条码对应的部分商品未拿到货且未退款,建议入库");
            }
        }

        DaifaWaitSendOrder tmpwo=new DaifaWaitSendOrder();
        tmpwo.setDfTradeId(order.getDfTradeId());
        List<DaifaWaitSendOrder> wos=daifaWaitSendOrderMapper.select(tmpwo);
        for(DaifaWaitSendOrder wo:wos){
            if(!lastScanDate.equals(wo.getLastScanDate())&&wo.getRefundStatus()!=2){
                throw new DaifaException("此条码对应的部分商品未扫描");
            }
        }

        //发货
        OrderExpressBO exbo=new OrderExpressBO();
        exbo.setExpressName(trade.getExpressName());
        exbo.setReceiverAddress(trade.getReceiverAddress());
        exbo.setReceiverName(trade.getReceiverName());
        exbo.setReceiverPhone(trade.getReceiverMobile()==null?trade.getReceiverPhone():trade.getReceiverMobile());
        exbo.setTid(trade.getDfTradeId());
        List<SubOrderExpressBO> list=new ArrayList<>();
        List<Long> oids=new ArrayList<>();
        for(DaifaOrder o:orders){
            SubOrderExpressBO so=new SubOrderExpressBO();
            so.setGoodsNum(o.getGoodsNum());
            so.setOrderId(o.getDfOrderId());
            so.setPropStr(o.getPropStr());
            so.setStoreGoodsCode(o.getStoreGoodsCode());
            oids.add(o.getDfOrderId());
            list.add(so);
        }
        exbo.setList(list);
        ExpressModel expressModel=SpringBeanFactory.getBean(ExpressModel.class,trade.getExpressId(),trade.getSellerId());
        ExpressVO exvo;
        try {
            exvo = expressModel.callExpress(exbo);
        } catch (DaifaException e) {
            throw new DaifaException("订单全部拿到货,快递单打印失败("+trade.getExpressName()+","+e.getMessage()+")");
        }
        DeliveryBO bo= BeanMapper.map(trade,DeliveryBO.class);
        bo.setExpressCode(exvo.getExpressCode());
        bo.setMarkDestination(exvo.getMarkDestination());
        bo.setPackageName(exvo.getPackageName());
        bo.setDfOrderIds(oids);
        OrderModel orderModel= SpringBeanFactory.getBean(OrderModel.class,order.getDfTradeId());
        orderModel.send(bo);

        //获取信息
        DaifaSend send=new DaifaSend();
        send.setDfTradeId(order.getDfTradeId());
        send=daifaSendMapper.selectOne(send);
        PackResultVO print = new PackResultVO();
        print.setSendId(send.getSendId());
        print.setGoodsInfo(order.getStoreGoodsCode()+"\t"+order.getPropStr());
        print.setExpressName(send.getExpressName());
        print.setExpressCode(send.getExpressCode());

        return print;
    }

    @Override
    public PrintExpressVO printExpress(Long sendId) {
        DaifaSend send=daifaSendMapper.selectByPrimaryKey(sendId);
        DaifaTrade trade=daifaTradeMapper.selectByPrimaryKey(send.getDfTradeId());
        DaifaSendOrder tmpSo=new DaifaSendOrder();
        tmpSo.setSendId(send.getSendId());
        List<DaifaSendOrder> sendOrders=daifaSendOrderMapper.select(tmpSo);

        DaifaSeller seller=daifaSellerMapper.selectByPrimaryKey(send.getSellerId());

        Map<String,Integer> skumap=new HashMap<>();
        PrintExpressVO print=new PrintExpressVO();
        print.setDfTradeId(send.getDfTradeId().toString());
        print.setPostCode(send.getExpressCode());
        print.setReceiverName(send.getReceiverName());
        print.setRecieverAddress(send.getReceiverAddress());
        print.setReceiverMobile(send.getReceiverPhone());
        print.setSenderName(seller.getName());
        print.setSenderPhone(seller.getTelephone());
        print.setSenderAddress(seller.getAddress());
        int orderSize=0;
        for (DaifaSendOrder sendOrder : sendOrders) {
            if (sendOrder.getTakeGoodsStatus()!=null&&sendOrder.getTakeGoodsStatus()==1) {
                orderSize++;
                String key = sendOrder.getStoreNum() + "-" + sendOrder.getGoodsCode() + "-" + sendOrder.getPropStr();
                skumap.merge(key, sendOrder.getGoodsNum(), (a, b) -> a + b);
            }
        }
        List<String> goodsMs = new ArrayList<String>();
        Iterator<String> it = skumap.keySet().iterator();
        int goodsnum=0;
        while (it.hasNext()) {
            String keyz = it.next();
            String goodsku = keyz + "-" + skumap.get(keyz) + "件";
            goodsMs.add(goodsku);
            goodsnum+=skumap.get(keyz);
        }
        print.setGoodsMs(goodsMs);
        print.setSpecialStr(trade.getBarCodeKey());
        print.setPostName(send.getExpressName());
        print.setMarkDestination(send.getMarkDestination());
        print.setPackageName(send.getPackageName());
        print.setSendNum(orderSize>=1?goodsnum:null);

        DaifaSend senduex=new DaifaSend();
        senduex.setPrintStatus(1);
        senduex.setSendId(send.getSendId());
        daifaSendMapper.updateByPrimaryKeySelective(senduex);
        return print;
    }
}
