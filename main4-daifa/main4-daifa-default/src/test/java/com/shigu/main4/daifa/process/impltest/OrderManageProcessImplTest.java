package com.shigu.main4.daifa.process.impltest;

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
}
