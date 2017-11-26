package com.shigu.main4.daifa.process.impl;

import com.alibaba.dubbo.common.logger.Logger;
import com.alibaba.dubbo.common.logger.LoggerFactory;
import com.opentae.data.daifa.beans.*;
import com.opentae.data.daifa.examples.DaifaCallExpressExample;
import com.opentae.data.daifa.examples.DaifaOrderExample;
import com.opentae.data.daifa.examples.DaifaWaitSendExample;
import com.opentae.data.daifa.examples.DaifaWaitSendOrderExample;
import com.opentae.data.daifa.interfaces.*;
import com.shigu.main4.common.util.BeanMapper;
import com.shigu.main4.common.util.DateUtil;
import com.shigu.main4.daifa.bo.DeliveryBO;
import com.shigu.main4.daifa.bo.OrderExpressBO;
import com.shigu.main4.daifa.bo.SubOrderExpressBO;
import com.shigu.main4.daifa.enums.DaifaSendMqEnum;
import com.shigu.main4.daifa.exceptions.DaifaException;
import com.shigu.main4.daifa.model.ExpressModel;
import com.shigu.main4.daifa.model.OrderModel;
import com.shigu.main4.daifa.process.PackDeliveryProcess;
import com.shigu.main4.daifa.utils.MQUtil;
import com.shigu.main4.daifa.vo.ExpressVO;
import com.shigu.main4.daifa.vo.OrderSendErrorDealVO;
import com.shigu.main4.daifa.vo.PackResultVO;
import com.shigu.main4.daifa.vo.PrintExpressVO;
import com.shigu.main4.tools.SpringBeanFactory;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.text.DecimalFormat;
import java.util.*;

import static org.junit.Assert.assertTrue;

@Service("packDeliveryProcess")
public class PackDeliveryProcessImpl implements PackDeliveryProcess {
    private static final Logger logger = LoggerFactory.getLogger(PackDeliveryProcessImpl.class);
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
    private DaifaTradeMapper daifaTradeMapper;//
    @Autowired
    private DaifaWaitSendMapper daifaWaitSendMapper;//
    @Autowired
    private DaifaGoodsWeightMapper daifaGoodsWeightMapper;

    @Autowired
    private DaifaCallExpressMapper daifaCallExpressMapper;

    @Autowired
    private MQUtil mqUtil;

    @Override
    public PackResultVO packSubOrder(Long subOrderId) throws DaifaException {
        DaifaOrder order=daifaOrderMapper.selectByPrimaryKey(subOrderId);
        if(order==null){
            throw new DaifaException("此条码对应的订单编号不存在",DaifaException.DEBUG);
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
            throw new DaifaException("此条码对应的商品全部暂未拿到货",DaifaException.DEBUG);
        }
        List<SubOrderExpressBO> list=cheackeSend(order.getDfTradeId());

        String lastScanDate= DateUtil.dateToString(new Date(),DateUtil.patternB);
        DaifaWaitSendOrder updateWaitSendOrder=new DaifaWaitSendOrder();
        updateWaitSendOrder.setDwsoId(daifaWaitSendOrder.getDwsoId());
        updateWaitSendOrder.setLastScanDate(lastScanDate);
        daifaWaitSendOrderMapper.updateByPrimaryKeySelective(updateWaitSendOrder);
        DaifaWaitSendOrder tmpwo=new DaifaWaitSendOrder();
        tmpwo.setDfTradeId(order.getDfTradeId());
        List<DaifaWaitSendOrder> wos=daifaWaitSendOrderMapper.select(tmpwo);
        for(DaifaWaitSendOrder wo:wos){
            if(!lastScanDate.equals(wo.getLastScanDate())&&wo.getRefundStatus()!=2){
                throw new DaifaException("此条码对应的部分商品未扫描",DaifaException.DEBUG);
            }
        }

        //发货
        OrderExpressBO exbo=new OrderExpressBO();
        exbo.setExpressName(trade.getExpressName());
        exbo.setReceiverAddress(trade.getReceiverAddress());
        exbo.setReceiverName(trade.getReceiverName());
        exbo.setReceiverPhone(trade.getReceiverMobile()==null?trade.getReceiverPhone():trade.getReceiverMobile());
        exbo.setTid(trade.getDfTradeId());
        List<Long> oids=BeanMapper.getFieldList(list,"orderId",Long.class);
        exbo.setList(list);
        ExpressModel expressModel=SpringBeanFactory.getBean(ExpressModel.class,trade.getExpressId(),trade.getSellerId());
        ExpressVO exvo;
        try {
            exvo = expressModel.callExpress(exbo);
        } catch (DaifaException e) {
            throw new DaifaException("订单全部拿到货,快递单打印失败("+trade.getExpressName()+","+e.getMessage()+")",DaifaException.DEBUG);
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

        print.setPackageCode(exvo.getPackageCode ());
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
        print.setPackageCode (send.getPackageCode ());
        print.setSendNum(orderSize>=1?goodsnum:null);

        DaifaSend senduex=new DaifaSend();
        senduex.setPrintStatus(1);
        senduex.setSendId(send.getSendId());
        daifaSendMapper.updateByPrimaryKeySelective(senduex);
        return print;
    }

    @Override
    @Transactional(rollbackFor = {Exception.class}, isolation = Isolation.DEFAULT)
    public OrderSendErrorDealVO dealOrderSendError (Long dfTradeId, String receiverName, String receiverAddr) throws DaifaException{
        DaifaTrade dt=new DaifaTrade ();
        dt.setDfTradeId (dfTradeId);
        dt.setReceiverName (receiverName);
        dt.setReceiverAddress (receiverAddr);
        daifaTradeMapper.updateByPrimaryKeySelective (dt);
        DaifaWaitSend waitSend=new DaifaWaitSend();
        waitSend.setDfTradeId (dfTradeId);
        waitSend.setReceiverName (receiverName);
        waitSend.setReceiverAddress (receiverAddr);
        DaifaWaitSendExample waitSendExample=new DaifaWaitSendExample ();
        waitSendExample.createCriteria ().andDfTradeIdEqualTo (dfTradeId);
        daifaWaitSendMapper.updateByExampleSelective (waitSend,waitSendExample);
        OrderSendErrorDealVO vo=new OrderSendErrorDealVO();
        vo.setDfTradeId (dfTradeId);
        vo.setSuccess ("OK");
        return vo;
    }
    /**
     * ====================================================================================
     * @方法名： dealSubOrderError
     * @user gzy 2017/11/9 11:14
     * @功能：修改子单的商品属性，商品货号，商家编码
     * @param: [dfOrderId, propStr, goodsCode, storeGoodsCode]
     * @return: int
     * @exception:
     * ====================================================================================
     *
     */
    @Override
    public int dealSubOrderError(Long dfOrderId,String propStr,String goodsCode,String storeGoodsCode)throws DaifaException{
        DaifaOrder order=new DaifaOrder ();
        order.setDfOrderId (dfOrderId);
        order.setPropStr (propStr);
        order.setGoodsCode (goodsCode);
        order.setStoreGoodsCode (storeGoodsCode);
        daifaOrderMapper.updateByPrimaryKeySelective (order);
        DaifaWaitSendOrder worder=new DaifaWaitSendOrder();
        worder.setDfOrderId (dfOrderId);
        worder.setPropStr (propStr);
        worder.setGgoodsCode (goodsCode);
        worder.setStoreGoodsCode (storeGoodsCode);
        DaifaWaitSendOrderExample example=new DaifaWaitSendOrderExample ();
        example.createCriteria ().andDfOrderIdEqualTo (dfOrderId);
      return  daifaWaitSendOrderMapper.updateByExampleSelective (worder,example);
    }

    public void updateGoodsWeight(Long subOrderId,Long weight,Long sellerId){
        DaifaOrder order=daifaOrderMapper.selectByPrimaryKey(subOrderId);
        Long goodsId=order.getGoodsId();
        DaifaGoodsWeight w=daifaGoodsWeightMapper.selectByPrimaryKey(goodsId);
        if(w!=null){
            w.setGoodsWeight(weight);
            w.setCreateTime(null);
            w.setSellerId(null);
            daifaGoodsWeightMapper.updateByPrimaryKeySelective(w);
        }else{
            w=new DaifaGoodsWeight();
            w.setGoodsId(goodsId);
            w.setGoodsWeight(weight);
            w.setCreateTime(new Date());
            w.setSellerId(sellerId);
            daifaGoodsWeightMapper.insertSelective(w);
        }
        DecimalFormat df = new DecimalFormat("0.000");
        Map<String,Object> map=new HashMap<>();
        map.put("goodsId",goodsId);
        map.put("weight",df.format(weight/1000));
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("data",map);
        jsonObject.put("msg", DaifaSendMqEnum.weightSet.getMsg());
        jsonObject.put("status","true");
        mqUtil.sendMessage(DaifaSendMqEnum.weightSet.getMessageKey()+goodsId,
                DaifaSendMqEnum.weightSet.getMessageTag(), jsonObject.toString());

    }

    @Override
    public void queryExpressCode(Long dfTradeId) throws DaifaException {
        DaifaTrade trade=daifaTradeMapper.selectByPrimaryKey(dfTradeId);
        if(trade==null||trade.getSendStatus()==2){
            return;
        }
        List<SubOrderExpressBO> list;
        try {
            list = cheackeSend(dfTradeId);
        } catch (DaifaException e) {
            return;
        }
        OrderExpressBO exbo=new OrderExpressBO();
        exbo.setExpressName(trade.getExpressName());
        exbo.setReceiverAddress(trade.getReceiverAddress());
        exbo.setReceiverName(trade.getReceiverName());
        exbo.setReceiverPhone(trade.getReceiverMobile()==null?trade.getReceiverPhone():trade.getReceiverMobile());
        exbo.setTid(trade.getDfTradeId());
        exbo.setList(list);
        ExpressModel expressModel=SpringBeanFactory.getBean(ExpressModel.class,trade.getExpressId(),trade.getSellerId());
        try {
            expressModel.callExpress(exbo);
        } catch (DaifaException e) {
            List<String> errMsgs=Arrays.asList("快递鸟内部错误码：207,错误信息：单号不足请及时充值");
            if(errMsgs.contains(e.getMessage())){
                throw new DaifaException(trade.getExpressName()+"单号不足",DaifaException.DEBUG);
            }
        }
    }

    /**
     * 校验是否可发货
     * 如果可发,则返回因拿到的商品信息
     * @param dfTradeId
     */
    private List<SubOrderExpressBO> cheackeSend(Long dfTradeId) throws DaifaException {
        DaifaOrder tmpo=new DaifaOrder();
        tmpo.setDfTradeId(dfTradeId);
        List<DaifaOrder> orders=daifaOrderMapper.select(tmpo);
        for(DaifaOrder o:orders){
            if(o.getAllocatStatus()==0&&(o.getRefundStatus() == null||o.getRefundStatus()!=2)){
                throw new DaifaException("此条码对应的部分商品未分配",DaifaException.DEBUG);
            }
            if(o.getAllocatStatus()==1&&o.getTakeGoodsStatus()==0){
                throw new DaifaException("此条码对应的部分商品正在拿货中,建议入库",DaifaException.DEBUG);
            }
            if(o.getTakeGoodsStatus()==2&&(o.getRefundStatus() == null||o.getRefundStatus()!=2)){
                throw new DaifaException("此条码对应的部分商品未拿到货且未退款,建议入库",DaifaException.DEBUG);
            }
            if(o.getTakeGoodsStatus()==1&&o.getRefundStatus() != null&&o.getRefundStatus()==1){
                throw new DaifaException("此条码对应的商品已申请未发退款(退款进行中),请稍后重试",DaifaException.DEBUG);
            }
        }
        List<SubOrderExpressBO> list=new ArrayList<>();
        for(DaifaOrder o:orders){
            SubOrderExpressBO so=new SubOrderExpressBO();
            so.setGoodsNum(o.getGoodsNum());
            so.setOrderId(o.getDfOrderId());
            so.setPropStr(o.getPropStr());
            so.setStoreGoodsCode(o.getStoreGoodsCode());
            list.add(so);
        }
        return list;
    }

    /**
     * ====================================================================================
     * @方法名： dealSendTest
     * @user gzy 2017/10/27 17:31
     * @功能：
     * @param: [dfTradeId]
     * @return: com.shigu.main4.daifa.vo.ExpressVO
     * @exception:
     * ====================================================================================
     *
     */
    public ExpressVO dealSendTest(Long dfTradeId)throws DaifaException{

        ExpressVO vo=null;
        Long expressId=0L;
        Long sellerId=0L;
        DaifaTrade dt=daifaTradeMapper.selectByPrimaryKey (dfTradeId);
        if(dt!=null) {
            OrderExpressBO bo = new OrderExpressBO ();
            bo.setExpressName (dt.getExpressName ());//圆通快递
            bo.setReceiverName (dt.getReceiverName ());//姓名
            bo.setReceiverPhone (dt.getReceiverPhone ());//手机号
            bo.setReceiverAddress (dt.getReceiverAddress ());//地址
             expressId=dt.getExpressId ();
            sellerId=dt.getSellerId ();
            String stradeId = "8" + dt.getDfTradeId ();
            bo.setTid (new Long (stradeId));//修改后的交易号

            DaifaOrderExample example = new DaifaOrderExample ();
            example.createCriteria ().andDfTradeIdEqualTo (dfTradeId);
            List<DaifaOrder> list_order = daifaOrderMapper.selectByExample (example);

            //子单商品
            List<SubOrderExpressBO> list = new ArrayList<> ();

            if(list_order!=null&&list_order.size ()>0) {
                for(int i=0;i<list_order.size ();i++) {
                    SubOrderExpressBO bo1 = new SubOrderExpressBO ();
                    bo1.setOrderId (list_order.get (i).getDfOrderId ());
                    bo1.setStoreGoodsCode (list_order.get (i).getStoreGoodsCode ());
                    bo1.setGoodsNum (1);
                    bo1.setPropStr (list_order.get (i).getPropStr ());
                    list.add (bo1);
                }
            }
            bo.setList (list);
            //=========================================没有快递鸟账户开始====================================
            ExpressModel bean = SpringBeanFactory.getBean (ExpressModel.class, expressId, sellerId);
            try {
                bean.callExpress (bo);
                vo = bean.callExpress (bo);//再次调用也就是不在调用快递鸟直接从数据库里返回
                //更新daifaCallExpress中的dfTradeId的快递单号，三段码，集包地//daifaCallExpressMapper
                DaifaCallExpress express=new DaifaCallExpress ();
                express.setDfTradeId (dfTradeId);
                express.setExpressCode (vo.getExpressCode ());
                express.setPackageName (vo.getPackageName ());
                express.setPackageCode (vo.getPackageCode ());
                express.setMarkDestination (vo.getMarkDestination ());

                DaifaCallExpress dce1= daifaCallExpressMapper.selectByPrimaryKey (new Long (stradeId));
                if(dce1!=null){
                    express.setJsonData (dce1.getJsonData ());

                    DaifaCallExpressExample daifaCallExpressExample=new DaifaCallExpressExample ();
                    daifaCallExpressExample.createCriteria ().andDfTradeIdEqualTo (dfTradeId);

                    daifaCallExpressMapper.updateByExampleSelective (express,daifaCallExpressExample);
                    //删除daifaCallExpress中的stradeId
                    daifaCallExpressMapper.deleteByPrimaryKey (new Long (stradeId));
                    //更新daifaTrade中dfTradeId对应的expressCode  //daifaTradeMapper
                    DaifaTrade trade=new DaifaTrade ();
                    trade.setDfTradeId (dfTradeId);
                    trade.setExpressCode (vo.getExpressCode ());
                    daifaTradeMapper.updateByPrimaryKeySelective (trade);
                    //更新daifaWaitSend中dfTradeId对应的的expressCode//daifaWaitSendMapper
                    DaifaWaitSend send=new DaifaWaitSend ();
                    send.setDfTradeId (dfTradeId);
                    send.setExpressCode (vo.getExpressCode ());
                    send.setMarkDestination (vo.getMarkDestination ());
                    send.setPackageName (vo.getPackageName ());
                    DaifaWaitSendExample sendExample=new DaifaWaitSendExample ();
                    sendExample.createCriteria ().andDfTradeIdEqualTo (dfTradeId);
                    daifaWaitSendMapper.updateByExampleSelective (send,sendExample);
                }




            } catch (DaifaException e) {
                // System.out.println("11111@@@"+e.getMessage ());

                assertTrue (true);
            }
        }
        return vo;
    }
}
