package com.shigu.main4.daifa.process.impltest;

import com.shigu.main4.daifa.exceptions.DaifaException;
import com.shigu.main4.daifa.process.PackDeliveryProcess;
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
    public void dealOrderSendError_test(){//OK
        Long dfTradeId=new Long(62017091197898L);
        String receiverName="胡晓林";
        String receiverAddr="江苏省 泰州市 姜堰市 海姜大道5号红星美家居生活广场(华东五金城对面)";

        packDeliveryProcess = SpringBeanFactory.getBean(PackDeliveryProcess.class);
        try {
            packDeliveryProcess.dealOrderSendError (dfTradeId,receiverName,receiverAddr);
        } catch (DaifaException e) {
            e.printStackTrace ();
        }

    }
}
