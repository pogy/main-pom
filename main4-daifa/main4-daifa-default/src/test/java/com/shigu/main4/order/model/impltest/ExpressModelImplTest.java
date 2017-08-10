package com.shigu.main4.order.model.impltest;

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
        ExpressModel bean = SpringBeanFactory.getBean(ExpressModel.class, 69l,999999990L);
       // bean.takeToMe(Collections.singletonList(1L));
        OrderExpressBO bo=new OrderExpressBO();
        bo.setExpressName ("韵达快递");
        bo.setReceiverName ("顾邹阳");
        bo.setReceiverPhone ("18857193391");
        bo.setReceiverAddress ("浙江省 杭州市 滨江区 西兴街道物联网街芯图大厦1102室");
        bo.setTid (53456788999928L);
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
        try {
            bean.callExpress (bo);
            ExpressVO vo= bean.callExpress (bo);//再次调用也就是不在调用快递鸟直接从数据库里返回
            System.out.println (vo.getExpressCode ());
        }catch(DaifaException e){
            e.printStackTrace ();
        }


    }
}
