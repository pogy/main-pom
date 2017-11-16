package com.shigu.main4.daifa.process.impltest;

import com.shigu.main4.daifa.exceptions.DaifaException;
import com.shigu.main4.daifa.process.SysDealProcess;
import com.shigu.main4.tools.SpringBeanFactory;
import com.shigu.test.BaseSpringTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @类编号
 * @类名称：SysDealProcessImplTest
 * @文件路径：com.shigu.main4.daifa.process.impltest.SysDealProcessImplTest
 * @内容摘要：
 * @编码作者：gzy
 * @创建日期：2017/9/22 10:29
 * @version: main-pom
 * @since: main-pom
 * @commonents:
 */
public class SysDealProcessImplTest extends BaseSpringTest {



    @Autowired
    private SysDealProcess sysDealProcess;

    @Test
    public void updateUserAndRoles_test(){//OK

        Long userId=new Long(4L);
        String roleIds="13";


        sysDealProcess = SpringBeanFactory.getBean(SysDealProcess.class);
        try {
            sysDealProcess.updateUserAndRoles (userId,roleIds);
        } catch (DaifaException e) {
            e.printStackTrace ();
        }

    }

}
