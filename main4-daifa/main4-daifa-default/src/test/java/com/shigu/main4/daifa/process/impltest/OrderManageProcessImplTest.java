package com.shigu.main4.daifa.process.impltest;

import com.shigu.main4.daifa.exceptions.DaifaException;
import com.shigu.main4.daifa.model.OrderModel;
import com.shigu.main4.daifa.process.OrderManageProcess;
import com.shigu.main4.daifa.process.TakeGoodsIssueProcess;
import com.shigu.main4.daifa.vo.PrintTagVO;
import com.shigu.main4.tools.SpringBeanFactory;
import com.shigu.test.BaseSpringTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * @类编号
 * @类名称：OrderManageProcessImplTest
 * @文件路径：com.shigu.main4.daifa.process.impltest.OrderManageProcessImplTest
 * @内容摘要：
 * @编码作者：gzy
 * @创建日期：2017/9/6 11:51
 * @version: main-pom
 * @since: main-pom
 * @commonents:
 */
public class OrderManageProcessImplTest extends BaseSpringTest {

    @Autowired
    OrderManageProcess orderManageProcess;

    @Test
    public void orderTimeout_test(){//OK
        orderManageProcess = SpringBeanFactory.getBean(OrderManageProcess.class);
        orderManageProcess.orderTimeout ();

    }


    @Test
    public void dealWaitSendOrderDisplay_test()throws DaifaException {

        orderManageProcess = SpringBeanFactory.getBean(OrderManageProcess.class);
        //62017090596149,62017090395845,62017090796511,62017090996832,62017091398490,62017091298344,62017091097376,62017091198125,62017091498714,62017091498771,
        //62017091799214,62017091598882,62017091899406,62017091999570,62017091899390,62017092199935,62017092200247,62017092400637,62017092300456,
        //62017092500765,62017092500816,62017092500817,62017092801403,62017092801493,62017092500890,62017092801358,62017092801525,62017092600904,
        //62017093001926,62017100202375,62017100302596,62017100202369,62017100302620,62017100202218,62017100102182,62017100102126,62017100503088,
        //62017100402813,62017100503130,62017100503375,62017100703992,62017100302585,62017100804282,62017100804171,62017100703968,62017100703874,
        //62017100904535,62017100904631,62017100904560,62017100904516,62017101105366,62017101105568,62017101005296,62017100804220,62017100804174,
        //62017100703778,62017100703960,62017100603540,62017100603696,62017100704137,62017101005343,62017101406805,62017100804439,
        Long dfTradeId=62017100804439L;
        Integer orderDisplay=0;

        orderManageProcess.dealWaitSendOrderDisplay( dfTradeId, orderDisplay);
    }
}
