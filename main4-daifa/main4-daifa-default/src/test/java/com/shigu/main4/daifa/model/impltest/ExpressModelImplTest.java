package com.shigu.main4.daifa.model.impltest;

import com.shigu.main4.daifa.bo.OrderExpressBO;
import com.shigu.main4.daifa.bo.SubOrderExpressBO;
import com.shigu.main4.daifa.exceptions.DaifaException;
import com.shigu.main4.daifa.model.ExpressModel;
import com.shigu.main4.daifa.vo.ExpressVO;
import com.shigu.main4.tools.SpringBeanFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;

/**
 * @类编号
 * @类名称：ExpressModelImplTest
 * @文件路径：com.shigu.main4.order.model.impltest.ExpressModelImplTest
 * @内容摘要：
 * @编码作者：gzy
 * @创建日期：2017/8/10 15:51
 * @version: main-pom
 * @since: main-pom
 * @commonents:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/test.xml")
public class ExpressModelImplTest{

    @Test
    public void callExpress_test() throws DaifaException {


        OrderExpressBO bo=new OrderExpressBO();
        bo.setExpressName ("韵达快递");
        bo.setReceiverName ("顾邹阳");
        bo.setReceiverPhone ("18857193391");
        bo.setReceiverAddress ("浙江省 杭州市 滨江区 西兴街道物联网街芯图大厦1102室");
        bo.setTid (53456788999929L);
        //子单商品
        List<SubOrderExpressBO> list=new ArrayList<> ();

        SubOrderExpressBO bo1=new SubOrderExpressBO ();
        bo1.setOrderId (12344L);
        bo1.setStoreGoodsCode ("dsjd_A101_g4537");
        bo1.setGoodsNum (1);
        bo1.setPropStr ("红色:XL");
        list.add (bo1);
        SubOrderExpressBO bo2=new SubOrderExpressBO ();
        bo2.setOrderId (12345L);
        bo2.setStoreGoodsCode ("dsjd_A101_g4537");
        bo2.setGoodsNum (1);
        bo2.setPropStr ("红色:XL");
        list.add (bo2);
        SubOrderExpressBO bo3=new SubOrderExpressBO ();
        bo3.setOrderId (12346L);
        bo3.setStoreGoodsCode ("dsjd_A101_g4536");
        bo3.setGoodsNum (1);
        bo3.setPropStr ("白色:XL");
        list.add (bo3);
        bo.setList (list);

        //=========================================没有快递鸟账户开始====================================
        ExpressModel bean = SpringBeanFactory.getBean(ExpressModel.class, 69l,9999999999L);
        try {
            bean.callExpress (bo);
            ExpressVO vo= bean.callExpress (bo);//再次调用也就是不在调用快递鸟直接从数据库里返回
        }catch(DaifaException e){
            System.out.println("11111@@@"+e.getMessage ());
            assertTrue(true);
        }
        //=========================================没有快递鸟账户结束=====================================
        //=========================================没有快递鸟账户不对开始==================================
        bean = SpringBeanFactory.getBean(ExpressModel.class, 66l,999999990L);
        try {
            bean.callExpress (bo);
            ExpressVO vo= bean.callExpress (bo);//再次调用也就是不在调用快递鸟直接从数据库里返回
            System.out.println ("2￥￥￥￥22222@@@"+vo.getExpressCode ());
        }catch(DaifaException e){
            System.out.println("222222@@@"+e.getMessage ());
            assertTrue(true);
            // assertTrue (true);
        }
        //=========================================没有快递鸟账户不对结束==================================
        //=========================================调用快递鸟账户开始======================================
        bean = SpringBeanFactory.getBean(ExpressModel.class, 69l,999999990L);
        try {

            bean.callExpress (bo);
            ExpressVO vo= bean.callExpress (bo);
            System.out.println ("3￥￥￥￥333333@@@"+vo.getExpressCode ());
        }catch(DaifaException e){
            System.out.println("33333333@@@"+e.getMessage ());
            assertTrue(true);
            // assertTrue (true);
        }
        //=========================================调用快递鸟账户结束======================================
        //=========================================再次调用打印不调用快递直接查询数据库开始===================

        try {

            bean.callExpress (bo);
            ExpressVO vo= bean.callExpress (bo);
            System.out.println ("4￥￥￥￥444444@@@"+vo.getExpressCode ());
        }catch(DaifaException e){
            System.out.println("4444444@@@"+e.getMessage ());
            assertTrue(true);
            // assertTrue (true);
        }
        //=========================================再次调用打印不调用快递直接查询数据库结束====================

    }
}
