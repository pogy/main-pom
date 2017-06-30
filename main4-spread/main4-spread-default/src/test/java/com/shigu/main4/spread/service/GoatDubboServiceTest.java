package com.shigu.main4.spread.service;

import com.alibaba.fastjson.JSON;
import com.shigu.main4.activity.exceptions.ActivityException;
import com.shigu.main4.goat.beans.ImgGoat;
import com.shigu.main4.goat.enums.GoatType;
import com.shigu.main4.goat.exceptions.GoatException;
import com.shigu.main4.goat.service.GoatDubboService;
import com.shigu.main4.goat.vo.GoatIntermVO;
import com.shigu.main4.goat.vo.ImgGoatVO;
import com.shigu.main4.goat.vo.ItemGoatVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by zhaohongbo on 17/5/10.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/store_test.xml")
public class GoatDubboServiceTest {
    @Autowired
    GoatDubboService goatDubboService;

    @Test
    public void selGoatByIdTest() throws GoatException, ActivityException {
        ImgGoatVO igv=goatDubboService.selGoatById(25L, GoatType.ImgGoat);
        System.out.println(JSON.toJSONString(igv));
        List<GoatIntermVO> givs=goatDubboService.selGoatByLocalId(1L,GoatType.ImgGoat);
        System.out.println(JSON.toJSONString(givs));
    }

    @Test
    public void selByLocalId() throws GoatException, ActivityException {
        List<GoatIntermVO> list=goatDubboService.selGoatByLocalId(33L,GoatType.ItemGoat);
        System.out.println(list);
    }
}
