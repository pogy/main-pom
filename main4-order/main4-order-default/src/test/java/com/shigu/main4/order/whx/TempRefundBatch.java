package com.shigu.main4.order.whx;

import com.opentae.data.mall.beans.ItemOrder;
import com.opentae.data.mall.beans.ItemOrderRefund;
import com.opentae.data.mall.beans.ItemOrderService;
import com.opentae.data.mall.beans.ItemOrderSub;
import com.opentae.data.mall.examples.ItemOrderServiceExample;
import com.opentae.data.mall.examples.ItemOrderSubExample;
import com.opentae.data.mall.interfaces.ItemOrderMapper;
import com.opentae.data.mall.interfaces.ItemOrderRefundMapper;
import com.opentae.data.mall.interfaces.ItemOrderServiceMapper;
import com.opentae.data.mall.interfaces.ItemOrderSubMapper;
import com.shigu.main4.order.BaseTest;
import com.shigu.main4.order.exceptions.OrderException;
import com.shigu.main4.order.exceptions.PayerException;
import com.shigu.main4.order.exceptions.RefundException;
import com.shigu.main4.order.model.RefundItemOrder;
import com.shigu.main4.order.services.AfterSaleService;
import com.shigu.main4.tools.SpringBeanFactory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 类名：TempRefundBatch
 * 类路径：com.shigu.main4.order.whx.TempRefundBatch
 * 创建者：王浩翔
 * 创建时间：2017-09-06 17:19
 * 项目：main-pom
 * 描述：订单退货临时用
 */
public class TempRefundBatch extends BaseTest {

    @Autowired
    private ItemOrderSubMapper itemOrderSubMapper;

    @Autowired
    private ItemOrderMapper itemOrderMapper;

    @Autowired
    private ItemOrderServiceMapper itemOrderServiceMapper;

    @Autowired
    private ItemOrderRefundMapper itemOrderRefundMapper;

    @Autowired
    private AfterSaleService afterSaleService;

    Map<Long, RefundInfomation> refundInfomations;

    public void init() {
        refundInfomations = new HashMap<>();
        //1
        HashMap<String, Integer> goodsNoMap = new HashMap<>();
        goodsNoMap.put("dsjd_A090_F16", 1);
        refundInfomations.put(62017090295723L, new RefundInfomation(133451, 500, 0, goodsNoMap));
        //2
        goodsNoMap = new HashMap<>();
        goodsNoMap.put("dsjd_A329_8012", 1);
        refundInfomations.put(62017090295611L, new RefundInfomation(133042, 450, 0, goodsNoMap));
        //3 退过
        goodsNoMap = new HashMap<>();
        goodsNoMap.put("dsjd_A027_T726",1);
        refundInfomations.put(62017090295680L,new RefundInfomation(133315,450,0,goodsNoMap));
        //4 退过
        goodsNoMap = new HashMap<>();
        goodsNoMap.put("dsjd_A129_7326",1);
        refundInfomations.put(62017090395797L,new RefundInfomation(133621,500,0,goodsNoMap));
        //5 退过
        goodsNoMap = new HashMap<>();
        goodsNoMap.put("dsjd_A129_7326",1);
        refundInfomations.put(62017090395801L,new RefundInfomation(133623,500,0,goodsNoMap));
        //6 退过
        goodsNoMap = new HashMap<>();
        goodsNoMap.put("dsjd_A129_7326",1);
        refundInfomations.put(62017090395847L,new RefundInfomation(133729,500,0,goodsNoMap));
        //7
        goodsNoMap = new HashMap<>();
        goodsNoMap.put("dsjd_A201_A201-XT007", 1);
        refundInfomations.put(62017090295700L, new RefundInfomation(133388, 500, 0, goodsNoMap));
        //8
        goodsNoMap = new HashMap<>();
        goodsNoMap.put("dsjd_B238_B238-190-P50", 1);
        refundInfomations.put(62017090295717L, new RefundInfomation(133430, 500, 0, goodsNoMap));
        //9
        goodsNoMap = new HashMap<>();
        goodsNoMap.put("qtds_2015-1_8857", 1);
        refundInfomations.put(62017090395845L, new RefundInfomation(133727, 500, 0, goodsNoMap));
        //10
        goodsNoMap = new HashMap<>();
        goodsNoMap.put("dsjd_B240_B240-B130-P75", 1);
        goodsNoMap.put("dsjd_B240_B240-B128-P90", 1);
        goodsNoMap.put("dsjd_C215_C215-WY168-P55", 1);
        refundInfomations.put(62017090395888L, new RefundInfomation(133873, 580, 0, goodsNoMap));
    }


    @Test
    public void batchRefund() {
        init();
        for (RefundInfomation refundInfomation : refundInfomations.values()) {

            ItemOrderSubExample example = new ItemOrderSubExample();
            example.createCriteria().andOidEqualTo(refundInfomation.getOid()).andGoodsNoIn(refundInfomation.getOrderRefundGoodsNo().keySet().parallelStream().collect(Collectors.toList()));
            List<ItemOrderSub> itemOrderSubs = itemOrderSubMapper.selectByExample(example);
            Iterator<ItemOrderSub> it = itemOrderSubs.iterator();
            while (it.hasNext()) {
                ItemOrderSub o = it.next();
                ItemOrderRefund existSubRefund = new ItemOrderRefund();
                existSubRefund.setSoid(o.getSoid());
                existSubRefund = itemOrderRefundMapper.selectOne(existSubRefund);
                if (existSubRefund != null) {
                    continue;
                }
                int refundNum = refundInfomation.getOrderRefundGoodsNo().get(o.getGoodsNo());
                long subRefund = 0;
                try {
                    //退子单
                    long refundMoney = refundNum * o.getPrice();
                    if (it.hasNext()) {
                        subRefund = refundMoney;
                    } else {
                        subRefund = refundMoney + refundInfomation.getRefundServices() + refundInfomation.getRefundLogistics();
                    }
                    Long refundId = afterSaleService.returnGoodsApply(o.getSoid(), refundNum, subRefund, "退货", "人工处理" + (it.hasNext() ? "退子单" : "退子单及快递费，服务费"));
                    //实际退款
                    SpringBeanFactory.getBean(RefundItemOrder.class, refundId).success();
                    ItemOrder itemOrder = itemOrderMapper.selectByPrimaryKey(refundInfomation.getOid());
                    itemOrder.setRefundFee(itemOrder.getRefundFee() + subRefund);
                    itemOrderMapper.updateByPrimaryKeySelective(itemOrder);
                    System.out.println(String.format("oid:%d\t\tsoid:%d\t\trefundId:%d\t\tgoodsNo:%s",o.getOid(),o.getSoid(),refundId,o.getGoodsNo()));
                } catch (OrderException | RefundException | PayerException e) {
                    e.printStackTrace();
                }

            }
            //退服务费显示
            if (refundInfomation.getRefundServices() > 0) {
                ItemOrderServiceExample serviceExample = new ItemOrderServiceExample();
                serviceExample.createCriteria().andOidEqualTo(refundInfomation.getOid()).andSoidIn(itemOrderSubs.parallelStream().map(ItemOrderSub::getSoid).collect(Collectors.toList()));
                List<ItemOrderService> itemOrderServices = itemOrderServiceMapper.selectByExample(serviceExample);
                long perService = refundInfomation.getRefundServices() / itemOrderServices.size();
                for (ItemOrderService itemOrderService : itemOrderServices) {
                    itemOrderService.setRefundMoney(itemOrderService.getRefundMoney() + perService);
                    itemOrderServiceMapper.updateByPrimaryKeySelective(itemOrderService);
                }
            }


        }
    }

    class RefundInfomation {
        //退快递费
        long refundLogistics = 0;
        //退服务费
        long refundServices = 0;
        //订单id
        long oid;
        //退货号数量
        Map<String, Integer> refundGoodsNo;
        Map<String, Integer> orderRefundGoodsNo;

        public RefundInfomation(long oid, long refundLogistics, long refundServices, Map<String, Integer> refundGoodsNo) {
            this.oid = oid;
            this.refundLogistics = refundLogistics;
            this.refundServices = refundServices;
            this.refundGoodsNo = refundGoodsNo;
            orderRefundGoodsNo = new HashMap<>(refundGoodsNo.size());
            refundGoodsNo.entrySet().parallelStream().forEach(o -> orderRefundGoodsNo.put(o.getKey().replaceFirst("[a-z]*_[A-Za-z0-9]*-?[A-Za-z0-9]*_", ""), o.getValue()));
        }

        public long getRefundLogistics() {
            return refundLogistics;
        }


        public long getRefundServices() {
            return refundServices;
        }


        public long getOid() {
            return oid;
        }

        public void setOid(long oid) {
            this.oid = oid;
        }

        public Map<String, Integer> getRefundGoodsNo() {
            return refundGoodsNo;
        }


        public Map<String, Integer> getOrderRefundGoodsNo() {
            return orderRefundGoodsNo;
        }

    }
}
