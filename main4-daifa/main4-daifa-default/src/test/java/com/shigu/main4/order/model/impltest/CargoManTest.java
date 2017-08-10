package com.shigu.main4.order.model.impltest;

import com.shigu.main4.daifa.exceptions.DaifaException;
import com.shigu.main4.daifa.model.CargoManModel;
import com.shigu.main4.tools.SpringBeanFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Collections;

/**
 * Created by zhaohongbo on 17/6/1.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/test.xml")
public class CargoManTest {



    @Test
    public void takeToMe_test() throws DaifaException {
        CargoManModel bean = SpringBeanFactory.getBean(CargoManModel.class, 1l);
        bean.takeToMe(Collections.singletonList(1L));

    }
    @Test
    public void finishTakeGoods_test() throws DaifaException {
        CargoManModel bean = SpringBeanFactory.getBean(CargoManModel.class, 1l);
        bean.finishTakeGoods();
    }
}
