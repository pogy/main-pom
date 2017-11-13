package com.shigu.main4.daifa.process.impltest;

import com.shigu.main4.daifa.exceptions.DaifaException;
import com.shigu.main4.daifa.process.PackDeliveryProcess;
import com.shigu.main4.daifa.vo.ExpressVO;
import com.shigu.main4.tools.SpringBeanFactory;
import com.shigu.test.BaseSpringTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @类编号
 * @类名称：PackDeliveryProcessImplTest
 * @文件路径：com.shigu.main4.daifa.process.impltest.PackDeliveryProcessImplTest
 * @内容摘要：
 * @编码作者：gzy
 * @创建日期：2017/9/12 16:52
 * @version: main-pom
 * @since: main-pom
 * @commonents:
 */
public class PackDeliveryProcessImplTest extends BaseSpringTest {

    @Autowired
    private PackDeliveryProcess packDeliveryProcess;

    @Test
    public void dealSubOrderError_test () {
        Long dfOrderId=397161L;
        String propStr="黑色:40/41（适合39-40脚穿）";
        String goodsCode="MT01";
        String storeGoodsCode="dsjd_C319_MT01-P15";
        packDeliveryProcess = SpringBeanFactory.getBean(PackDeliveryProcess.class);
        try {
            packDeliveryProcess.dealSubOrderError ( dfOrderId,  propStr,  goodsCode,  storeGoodsCode);
        } catch (DaifaException e) {
            e.printStackTrace ();
        }

    }

    @Test
    public void dealOrderSendError_test(){//OK  3865321809147
        Long dfTradeId=new Long(62017101909227L);
        String receiverName="唐军";
        String receiverAddr="上海市 上海市 南汇区 西门路18号彩虹商务1#楼10层";

        packDeliveryProcess = SpringBeanFactory.getBean(PackDeliveryProcess.class);
        try {
            packDeliveryProcess.dealOrderSendError (dfTradeId,receiverName,receiverAddr);
        } catch (DaifaException e) {
            e.printStackTrace ();
        }

    }
    @Test
    public void packSubOrder_test(){//OK  Long subOrderId
        Long subOrderId=new Long(387655L);


        packDeliveryProcess = SpringBeanFactory.getBean(PackDeliveryProcess.class);
        try {
            packDeliveryProcess.packSubOrder (subOrderId);
        } catch (DaifaException e) {
            e.printStackTrace ();
        }

    }

    @Test
    public void dealSendTest(){
        Long dfTradeId=62017101206126L;

        packDeliveryProcess = SpringBeanFactory.getBean(PackDeliveryProcess.class);
        try {
            ExpressVO vo=  packDeliveryProcess.dealSendTest (dfTradeId);
            show (vo);
        } catch (DaifaException e) {
            e.printStackTrace ();
        }
    }
}
