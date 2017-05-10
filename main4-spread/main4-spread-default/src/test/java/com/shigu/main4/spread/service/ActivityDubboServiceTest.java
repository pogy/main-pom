package com.shigu.main4.spread.service;

import com.shigu.main4.activity.service.ActivityDubboService;
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
public class ActivityDubboServiceTest {

    @Autowired
    ActivityDubboService activityDubboService;

    @Test
    public void selActivityInTermTest(){
        activityDubboService.selActivityInTerm(32L);
    }
}
