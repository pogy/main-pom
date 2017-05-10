package com.shigu.main4.spread.service;

import com.shigu.main4.goat.enums.GoatType;
import com.shigu.main4.goat.exceptions.GoatException;
import com.shigu.main4.goat.service.GoatDubboService;
import com.shigu.main4.goat.vo.ItemGoatVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by zhaohongbo on 17/5/10.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/store_test.xml")
public class GoatDubboServiceTest {
    @Autowired
    GoatDubboService goatDubboService;

    @Test
    public void selGoatByIdTest() throws GoatException {
        ItemGoatVO igv=goatDubboService.selGoatById(1L, GoatType.ItemGoat);
        System.out.println(igv);
        goatDubboService.selGoatByLocalId(1L,GoatType.ItemGoat);
    }
}
