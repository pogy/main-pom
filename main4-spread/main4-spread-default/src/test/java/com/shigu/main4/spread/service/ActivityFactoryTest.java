package com.shigu.main4.spread.service;

import com.opentae.data.mall.interfaces.SpreadActivityMapper;
import com.opentae.data.mall.interfaces.SpreadTermMapper;
import com.shigu.main4.activity.beans.ActivityTerm;
import com.shigu.main4.activity.enums.ActivityType;
import com.shigu.main4.activity.exceptions.ActivityException;
import com.shigu.main4.activity.service.ActivityFactory;
import com.shigu.main4.activity.vo.ActivityTermVO;
import com.shigu.main4.activity.vo.GoatActivityVO;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * 活动工厂测试
 * Created by zhaohongbo on 17/5/4.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/store_test.xml")
public class ActivityFactoryTest {

    @Autowired
    ActivityFactory activityFactory;

    @Autowired
    SpreadTermMapper spreadTermMapper;

    @Autowired
    SpreadActivityMapper spreadActivityMapper;

    @Test
    @Transactional
    public void addAndGetTermTest() throws ActivityException, ParseException {
        //正常测试
        ActivityTermVO vo=new ActivityTermVO();
        vo.setActivityType(ActivityType.GOAT_LED);
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        vo.setStartTime(sdf.parse("2017-09-06"));
        vo.setEndTime(sdf.parse("2017-09-16"));
        ActivityTerm t1=activityFactory.addAndGetTerm(vo);
        //正常添加了,会非空
        assertNotEquals(spreadTermMapper.selectByPrimaryKey(t1.getTermId()),null);
        //重叠情况一测试
        ActivityTermVO vo1=new ActivityTermVO();
        vo1.setActivityType(ActivityType.GOAT_LED);
        vo1.setStartTime(sdf.parse("2017-09-04"));
        vo1.setEndTime(sdf.parse("2017-09-10"));
        try {
            activityFactory.addAndGetTerm(vo1);
            //不报错不行
            Assert.fail();
        } catch (ActivityException e) {
        }

        //重叠情况二测试
        ActivityTermVO vo2=new ActivityTermVO();
        vo2.setActivityType(ActivityType.GOAT_LED);
        vo2.setStartTime(sdf.parse("2017-09-07"));
        vo2.setEndTime(sdf.parse("2017-09-10"));
        try {
            activityFactory.addAndGetTerm(vo2);
            //不报错不行
            Assert.fail();
        } catch (ActivityException e) {
        }

        //重叠情况三测试
        ActivityTermVO vo3=new ActivityTermVO();
        vo3.setActivityType(ActivityType.GOAT_LED);
        vo3.setStartTime(sdf.parse("2017-09-07"));
        vo3.setEndTime(sdf.parse("2017-09-10"));
        try {
            activityFactory.addAndGetTerm(vo3);
            //不报错不行
            Assert.fail();
        } catch (ActivityException e) {
        }
        //加活动测试
        GoatActivityVO goat=new GoatActivityVO();
        Long activityId=t1.throwActivity(goat);
        assertNotEquals(spreadActivityMapper.selectByPrimaryKey(activityId),null);
    }
}
