package com.shigu.main4.order.model.impltest;

import com.opentae.data.daifa.beans.DaifaGgoods;
import com.opentae.data.daifa.beans.DaifaGgoodsTasks;
import com.opentae.data.daifa.beans.DaifaOrder;
import com.opentae.data.daifa.beans.DaifaTrade;
import com.opentae.data.daifa.examples.DaifaGgoodsExample;
import com.opentae.data.daifa.interfaces.*;
import com.shigu.main4.common.util.BeanMapper;
import com.shigu.main4.daifa.bo.SubOrderModelBO;
import com.shigu.main4.daifa.exceptions.DaifaException;
import com.shigu.main4.daifa.model.CargoManModel;
import com.shigu.main4.daifa.model.impl.SubOrderModelImpl;
import com.shigu.main4.daifa.process.TakeGoodsIssueProcess;
import com.shigu.main4.daifa.vo.PrintTagVO;
import com.shigu.main4.tools.SpringBeanFactory;
import com.shigu.test.BaseSpringTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;

/**
 * Created by pc on 2017-08-11.
 *
 * @author pc
 * @version 3.0.0-SNAPSHOT
 * @description
 * @since 3.0.0-SNAPSHOT
 */
public class TakeGoodsIssueProcessTest extends BaseSpringTest {
    @Autowired
    DaifaOrderMapper daifaOrderMapper;
    @Autowired
    DaifaGgoodsTasksMapper daifaGgoodsTasksMapper;
    @Autowired
    DaifaGgoodsMapper daifaGgoodsMapper;
    @Autowired
    DaifaTradeMapper daifaTradeMapper;
    @Autowired
    DaifaWaitSendOrderMapper daifaWaitSendOrderMapper;
    @Autowired
    DaifaWaitSendMapper daifaWaitSendMapper;
    @Autowired
    TakeGoodsIssueProcess takeGoodsIssueProcess;

    @Test
    @Transactional
    public void printAllTags_test() throws DaifaException {
        DaifaTrade trade = insertTrade(82894793479L);
        DaifaGgoodsTasks daifaGgoodsTasks = new DaifaGgoodsTasks();
        daifaGgoodsTasks.setDfTradeId(82894793479L);
        List<DaifaGgoodsTasks> ts = daifaGgoodsTasksMapper.select(daifaGgoodsTasks);
        assertNotEquals(ts.size(), 0);
        List<Long> tids = new ArrayList<>();
        Long oid = null;
        for (DaifaGgoodsTasks t : ts) {
            if (t.getAllocatStatus() == 0) {
                tids.add(t.getTasksId());
                oid = t.getDfOrderId();
            }
        }
        boolean b = false;

        CargoManModel bean = SpringBeanFactory.getBean(CargoManModel.class, 2L);
        bean.takeToMe(tids);



        List<PrintTagVO> printTagVOS = takeGoodsIssueProcess.printAllTags(999999999L);
        assertNotEquals(printTagVOS.size(),0);
        DaifaGgoodsExample daifaGgoodsExample = new DaifaGgoodsExample();
        daifaGgoodsExample.createCriteria().andDfTradeIdEqualTo(82894793479L);
        List<DaifaGgoods> ggoods = daifaGgoodsMapper.selectByExample(daifaGgoodsExample);
        ggoods.forEach(ggood->{assertEquals(ggood.getPrintBarcodeStatus(),new Integer(2));
            System.out.println("---------------批次号----"+ggood.getPrintBatch());
        });

        System.out.println("-----------打打-----"+printTagVOS.get(0).getPriceAndBarCode());


    }


    private DaifaTrade insertTrade(Long tid) {
        DaifaTrade t = new DaifaTrade();
        t.setBarCodeKey("A02");
        t.setBuyerId(100012567L);
        t.setBuyerName("zf");
        t.setBuyerQq("460333383");
        t.setBuyerRemark("aaaa");
        t.setBuyerTelephone("18969041771");
        t.setBuyerNick("zf");
        t.setBuyerWw("a1234526");
        t.setBuyerWx("18969041771");
        t.setCreateTime(new Date());
        t.setDaifaType(2);
        t.setExpressFee("6.00");
        t.setExpressName("申通快递");
        t.setExpressId(68L);
        t.setGoodsFee("100.00");
        t.setGoodsNum(2L);
        t.setMoney("108.00");
        t.setPayStatus(1);
        t.setPayTime(new Date());
        t.setPrintExpressStatus(0);
        t.setRealPayMoney("108.00");
        t.setReceiverAddress("浙江省 杭州市 西湖区 中豪晴园2-2-302");
        t.setReceiverMobile("18969041771");
        t.setReceiverName("张峰");
        t.setReceiverPhone("18969041771");
        t.setReceiverQq("460333383");
        t.setReceiverState("浙江省");
        t.setSellerId(999999999L);
        t.setSellerName("星帮");
        t.setSendStatus(0);
        t.setServicesFee("2.00");
        t.setTaobaoTid(12123465443454L);
        t.setTaobaoUserNick("a1234526");
        t.setTotalFee("108.00");
        t.setTradeCode("order_1");
        t.setTradeDiscountFee("0.00");
        t.setTradeStatus(1);
        t.setDfTradeId(tid);
        daifaTradeMapper.insertSelective(t);

        insert(tid, "1-2");
        insert(tid, "2-2");
        return t;
    }

    private Long insert(Long tid, String code) {
        SubOrderModelBO bo = new SubOrderModelBO();
        bo.setAggrement(1);
        bo.setBarCodeKeyNum(code);
        bo.setCid(10000L);
        bo.setDfTradeId(tid);
        bo.setFloorId(1090L);
        bo.setFloorName("3F");
        bo.setGoodsCode("DSA322 Y509 P45");
        bo.setGoodsId(21048206L);
        bo.setGoodsNum(1);
        bo.setMarketId(1087L);
        bo.setMarketName("电商基地");
        bo.setOrderCode("subOrder_1");
        bo.setTradeCode("order_1");
        bo.setOrderDiscountFee("0.00");
        bo.setOrderPartitionId("subOrderFen_1");
        bo.setOrderStatus(1L);
        bo.setPicPath("https://img.alicdn.com/bao/uploaded/i1/850617645/TB2KG8ZXF6.F1JjSZPhXXc_LXXa_!!850617645.jpg");
        bo.setPropStr("灰色:4XL");
        bo.setSinglePay("50.00");
        bo.setSinglePiPrice("50.00");
        bo.setSinglePrice("78.00");
        bo.setSingleServicesFee("1.00");
        bo.setStoreGoodsCode("dsjd_A322_Y509_P45");
        bo.setStoreId(40508L);
        bo.setStoreNum("A322");
        bo.setTitle("港风文艺1 秋季男青少年圆领卫衣宽松韩版学生休闲百搭 Y509 P45");
        bo.setTotalFee("51.00");
        bo.setTotalServiceFee("1.00");
        bo.setSellerId(999999999L);
        bo.setWebSite("hz");
        SubOrderModelImpl impl = SpringBeanFactory.getBean(SubOrderModelImpl.class, bo);

        DaifaOrder order = daifaOrderMapper.selectByPrimaryKey(impl.getSubOrderId());
        DaifaGgoodsTasks task = new DaifaGgoodsTasks();
        task.setDfOrderId(impl.getSubOrderId());
        task = daifaGgoodsTasksMapper.selectOne(task);
        SubOrderModelBO bo1 = BeanMapper.map(order, SubOrderModelBO.class);
        SubOrderModelBO bo2 = BeanMapper.map(task, SubOrderModelBO.class);
        Field[] fs = SubOrderModelBO.class.getDeclaredFields();
        for (Field f : fs) {
            f.setAccessible(true);
            try {
                Object b = f.get(bo);
                if (!f.getName().equals("sellerId") && !f.getName().equals("webSite")) assertEquals(b, f.get(bo1));
                Object b2 = f.get(bo2);
                if (b2 != null) assertEquals(b, b2);
            } catch (IllegalAccessException e) {
                System.out.println(f.getName());
                assertFalse(false);
            }
        }
        assertEquals(order.getDelistIs(), new Integer(0));
        assertEquals(order.getAllocatStatus(), new Integer(0));

        assertEquals(task.getDelistIs(), new Integer(0));
        assertEquals(task.getAllocatStatus(), new Integer(0));
        assertEquals(task.getTakeGoodsDate(), null);
        assertEquals(task.getTakeGoodsStatus(), new Integer(0));
        assertEquals(task.getOperateIs(), new Integer(0));
        assertEquals(task.getUseStatus(), new Integer(1));
        assertEquals(task.getDaifaWorker(), null);
        assertEquals(task.getDaifaWorkerId(), null);
        assertEquals(task.getAllocatDate(), null);
        assertEquals(task.getAllocatTime(), null);
        assertEquals(task.getEndStatus(), new Integer(0));
        assertEquals(task.getGgoodsCode(), null);
        assertEquals(task.getPrintBarcodeStatus(), new Integer(1));
        assertEquals(task.getPrintGoodsStatus(), new Integer(1));
        assertEquals(task.getPrintBatch(), null);
        assertEquals(task.getReturnStatus(), new Integer(0));
        return impl.getSubOrderId();
    }

}
