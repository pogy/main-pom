package com.shigu.main4.member;

import com.shigu.main4.test.factory.TestBean;
import com.shigu.main4.test.factory.TestFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Created by zhaohongbo on 17/3/31.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration( value="/ac.xml" )
public class MytestFactory {

    @Resource(name = "productBean2")
    TestBean testBean;
    @Test
    public void test(){
        System.out.println("11111");
        System.out.println(testBean.getMemberUserCopy2Mapper());
    }
}
