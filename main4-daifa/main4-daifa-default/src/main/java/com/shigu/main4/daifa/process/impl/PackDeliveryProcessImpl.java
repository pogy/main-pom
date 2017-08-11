package com.shigu.main4.daifa.process.impl;

import com.opentae.core.mybatis.utils.FieldUtil;
import com.opentae.data.daifa.beans.*;
import com.opentae.data.daifa.interfaces.*;
import com.shigu.main4.common.util.DateUtil;
import com.shigu.main4.daifa.exceptions.DaifaException;
import com.shigu.main4.daifa.process.PackDeliveryProcess;
import com.shigu.main4.daifa.vo.PackResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
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
            if(o.getAllocatStatus()==0){
                throw new DaifaException("此条码对应的部分商品未分配");
            }
            if(o.getTakeGoodsStatus()==2&&o.getRefundStatus()!=2){
                throw new DaifaException("此条码对应的部分商品未拿到货且未退款,建议入库");
            }
        }

        DaifaWaitSendOrder tmpwo=new DaifaWaitSendOrder();
        tmpwo.setDfTradeId(order.getDfTradeId());
        List<DaifaWaitSendOrder> wos=daifaWaitSendOrderMapper.select(tmpwo);
        for(DaifaWaitSendOrder wo:wos){
            if(!lastScanDate.equals(wo.getLastScanDate())){
                throw new DaifaException("此条码对应的部分商品未扫描");
            }
        }

        //发货
//        OrderModel orderModel= SpringBeanFactory.getBean(OrderModel.class,order.getDfTradeId());
//        orderModel.send();

        //获取信息
        DaifaTrade trade=daifaTradeMapper.selectFieldsByPrimaryKey(order.getDfTradeId(), FieldUtil.codeFields("df_trade_id,bar_code_key"));
        DaifaSend send=new DaifaSend();
        send.setDfTradeId(order.getDfTradeId());
        send=daifaSendMapper.selectOne(send);
        DaifaSendOrder tmpSo=new DaifaSendOrder();
        tmpSo.setSendId(send.getSendId());
        List<DaifaSendOrder> sendOrders=daifaSendOrderMapper.select(tmpSo);

        DaifaSeller seller=daifaSellerMapper.selectByPrimaryKey(send.getSellerId());

        Map<String,Integer> skumap=new HashMap<>();
        PackResultVO print = new PackResultVO();
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
        senduex.setPrintStatus(2);
        senduex.setSendId(send.getSendId());
        daifaSendMapper.updateByPrimaryKeySelective(senduex);
        return print;
    }
}
