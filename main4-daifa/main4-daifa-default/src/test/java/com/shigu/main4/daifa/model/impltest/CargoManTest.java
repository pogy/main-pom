package com.shigu.main4.daifa.model.impltest;

import com.shigu.main4.daifa.exceptions.DaifaException;
import com.shigu.main4.daifa.model.CargoManModel;
import com.shigu.main4.tools.SpringBeanFactory;
import com.shigu.test.BaseSpringTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by zhaohongbo on 17/6/1.
 */

public class CargoManTest extends BaseSpringTest {



    @Test
    public void takeToMe_test() throws DaifaException {//OK
        CargoManModel bean = SpringBeanFactory.getBean(CargoManModel.class, 3l);

        List<Long> list=new ArrayList<> ();
        list.add(9856L);
        list.add(9857L);

        bean.takeToMe(list);

    }
    @Test
    public void finishTakeGoods_test() throws DaifaException {//OK
        CargoManModel bean = SpringBeanFactory.getBean(CargoManModel.class, 3l);
        bean.finishTakeGoods();
    }
}
