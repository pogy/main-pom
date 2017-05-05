package com.shigu.main4.spread.service;

import com.opentae.data.mall.beans.SpreadActivity;
import com.opentae.data.mall.beans.SpreadEnlist;
import com.opentae.data.mall.examples.SpreadEnlistExample;
import com.opentae.data.mall.interfaces.SpreadActivityMapper;
import com.opentae.data.mall.interfaces.SpreadEnlistMapper;
import com.opentae.data.mall.interfaces.SpreadTermMapper;
import com.shigu.main4.activity.beans.ActivityEnlist;
import com.shigu.main4.activity.beans.ActivityTerm;
import com.shigu.main4.activity.beans.LedActivity;
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
import java.util.List;

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
    @Autowired
    SpreadEnlistMapper spreadEnlistMapper;

    @Test
    @Transactional
    public void selLedActivityWithFunc_joinActivity(){
        //4个参数不能为空
        //参数//Long userId, Long shopId, String name, String phone

        SpreadActivity sa=new SpreadActivity ();
        sa.setContext ("{}");
        sa.setDescription ("");
        sa.setPubFromTime (new Date());
        sa.setPubToTime (new Date());
        sa.setSort (1);
        sa.setTermId (20170501L);
        sa.setType (ActivityType.GOAT_LED.ordinal ());
        spreadActivityMapper.insert (sa);

        LedActivity la=activityFactory.selActivityById(sa.getActivityId ());
        //userId为空
        try {//1000012151L  40435L  良品元素男装钱塘4010  18868412681
            la.joinActivity (null,40435L,"良品元素男装钱塘4010","18868412681");
            Assert.fail ();
        } catch (ActivityException e) {
            // e.printStackTrace ();
        }
        //shopId为空
        try {//1000012151L  40435L  良品元素男装钱塘4010  18868412681
            la.joinActivity (1000012151L,null,"良品元素男装钱塘4010","18868412681");
            Assert.fail ();
        } catch (ActivityException e) {
            // e.printStackTrace ();
        }
        //name为空
        try {//1000012151L  40435L  良品元素男装钱塘4010  18868412681
            la.joinActivity (1000012151L,40435L,null,"18868412681");
            Assert.fail ();
        } catch (ActivityException e) {
            // e.printStackTrace ();
        }
        //name为""
        try {//1000012151L  40435L  良品元素男装钱塘4010  18868412681
            la.joinActivity (1000012151L,40435L,"","18868412681");
            Assert.fail ();
        } catch (ActivityException e) {
            // e.printStackTrace ();
        }
        //name为空
        try {//1000012151L  40435L  良品元素男装钱塘4010  18868412681
            la.joinActivity (1000012151L,40435L,"良品元素男装钱塘4010",null);
            Assert.fail ();
        } catch (ActivityException e) {
            // e.printStackTrace ();
        }
        //name为""
        try {//1000012151L  40435L  良品元素男装钱塘4010  18868412681
            la.joinActivity (1000012151L,40435L,"良品元素男装钱塘4010","");
            Assert.fail ();
        } catch (ActivityException e) {
            // e.printStackTrace ();
        }
        //保存
        try {//1000012151L  40435L  良品元素男装钱塘4010  18868412681
            la.joinActivity (1000012151L,40435L,"良品元素男装钱塘4010","18868412681");
            //查询spread_enlist 中是否有值
            SpreadEnlistExample see=new SpreadEnlistExample ();
            //所有字段有值
            see.createCriteria ().andActivityIdEqualTo (sa.getActivityId ()).andUserIdEqualTo (1000012151L).andShopIdEqualTo (40435L)
                    .andNameEqualTo ("良品元素男装钱塘4010").andTelephoneEqualTo ("18868412681").andDrawEqualTo (0);
            List<SpreadEnlist> list= spreadEnlistMapper.selectByExample (see);
            assertEquals (list.size (),1L);//

        } catch (ActivityException e) {
            // e.printStackTrace ();
        }
        //重复参加
        try {//1000012151L  40435L  良品元素男装钱塘4010  18868412681
            la.joinActivity (1000012151L,40435L,"良品元素男装钱塘4010","18868412681");
            //报错
            Assert.fail ();

        } catch (ActivityException e) {
             e.printStackTrace ();
        }


    }
    @Test
    @Transactional
    public void selEnlistById_hitTest() throws ActivityException {
        SpreadEnlist se=new SpreadEnlist ();
        se.setDraw (0);
        se.setName ("zhongjiang");
        se.setShopId (24806L);
        se.setTelephone ("18857193391");
        se.setUserId (35377L);
        se.setActivityId (1L);
        spreadEnlistMapper.insert (se);
        //System.out.println("返回ID="+se.getEnlistId ());

        ActivityEnlist ae=activityFactory.selEnlistById (se.getEnlistId ());
        //第一种情况ID为空时中签
        ae.setEnId (null);
        try {
            ae.hit ();
            Assert.fail ();
        } catch (ActivityException e) {
            // e.printStackTrace ();
        }
        //第二种中签
        ActivityEnlist ae1=activityFactory.selEnlistById (se.getEnlistId ());
        ae1.setEnId (se.getEnlistId ());
        ae1.hit ();
        SpreadEnlist se1= spreadEnlistMapper.selectByPrimaryKey (se.getEnlistId ());
        assertEquals (se1.getDraw ().longValue (),1L);
    }
    @Test
    @Transactional
    public void selEnlistById_unhitTest() throws ActivityException {
        SpreadEnlist se=new SpreadEnlist ();
        se.setDraw (1);
        se.setName ("zhongjiang");
        se.setShopId (24806L);
        se.setTelephone ("18857193391");
        se.setUserId (35377L);
        se.setActivityId (1L);
        spreadEnlistMapper.insert (se);
       // System.out.println("返回ID="+se.getEnlistId ());

        ActivityEnlist ae=activityFactory.selEnlistById (se.getEnlistId ());
        //第一种情况ID为空时取消中签
        ae.setEnId (null);
        try {
            ae.unhit ();
            Assert.fail ();
        } catch (ActivityException e) {
           // e.printStackTrace ();
        }
        //第二种
        ActivityEnlist ae1=activityFactory.selEnlistById (se.getEnlistId ());
        ae1.setEnId (se.getEnlistId ());
        ae1.unhit ();
        SpreadEnlist se1= spreadEnlistMapper.selectByPrimaryKey (se.getEnlistId ());
        assertEquals (se1.getDraw ().longValue (),0L);
    }


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
