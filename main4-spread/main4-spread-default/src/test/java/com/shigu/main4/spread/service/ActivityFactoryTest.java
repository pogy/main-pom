package com.shigu.main4.spread.service;

import com.opentae.data.mall.beans.SpreadActivity;
import com.opentae.data.mall.beans.SpreadEnlist;
import com.opentae.data.mall.beans.SpreadTerm;
import com.opentae.data.mall.examples.SpreadEnlistExample;
import com.opentae.data.mall.examples.SpreadTermExample;
import com.opentae.data.mall.interfaces.SpreadActivityMapper;
import com.opentae.data.mall.interfaces.SpreadEnlistMapper;
import com.opentae.data.mall.interfaces.SpreadTermMapper;
import com.shigu.main4.activity.beans.ActivityEnlist;
import com.shigu.main4.activity.beans.ActivityTerm;
import com.shigu.main4.activity.beans.GoatActivity;
import com.shigu.main4.activity.beans.LedActivity;
import com.shigu.main4.activity.enums.ActivityType;
import com.shigu.main4.activity.exceptions.ActivityException;
import com.shigu.main4.activity.service.ActivityDubboService;
import com.shigu.main4.activity.model.ActivityFactory;
import com.shigu.main4.activity.vo.ActivityEnlistVO;
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
import java.util.*;

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

    @Autowired
    ActivityDubboService activityDubboService;

    @Test
    public void selActivitysTest(){
        List<GoatActivityVO> goats=activityFactory.selTermById(62L).selActivitys();
        System.out.println(goats);
    }

//    @Test
//    public void testId(){
//        ActivityTermVO atv=activityDubboService.selByTermId(50L);
//        System.out.println(atv);
//    }


    @Test
    @Transactional(rollbackFor = Exception.class)
    public void selLedActivityWithFunc_joinActivityTest() throws ActivityException {
        //4个参数不能为空
        //参数//Long userId, Long shopId, String name, String phone

        SpreadActivity sa=new SpreadActivity ();
        sa.setContext ("{}");
        sa.setDescription ("");
        sa.setSort (1);
        sa.setTermId (20170501L);
        sa.setType (ActivityType.GOAT_LED.ordinal ());
        spreadActivityMapper.insert (sa);

        LedActivity la=activityFactory.selActivityById(sa.getActivityId ());
        la.setActivityId(sa.getActivityId());
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
    @Transactional(rollbackFor = Exception.class)
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
    @Transactional(rollbackFor = Exception.class)
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
    @Transactional(rollbackFor = Exception.class)
    public void addAndGetTermTest() throws ActivityException, ParseException {
        spreadTermMapper.deleteByExample(new SpreadTermExample());
        Calendar cal=Calendar.getInstance();
        cal.add(Calendar.DATE,-1);
        Date start=cal.getTime();
        cal.add(Calendar.DATE,2);
        Date end=cal.getTime();
        //正常测试
        ActivityTermVO vo=new ActivityTermVO();
        vo.setActivityType(ActivityType.GOAT_LED);
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        vo.setStartTime(start);
        vo.setEndTime(end);
        ActivityTerm t1=activityFactory.addAndGetTerm(vo);
        //正常添加了,会非空
        assertNotEquals(spreadTermMapper.selectByPrimaryKey(t1.getTermId()),null);
        //重叠情况一测试
        ActivityTermVO vo1=new ActivityTermVO();
        vo1.setActivityType(ActivityType.GOAT_LED);
        vo1.setStartTime(end);
        vo1.setEndTime(sdf.parse("2019-09-10"));
        try {
            activityFactory.addAndGetTerm(vo1);
            //不报错不行
            Assert.fail();
        } catch (ActivityException e) {
        }

        //重叠情况二测试
        ActivityTermVO vo2=new ActivityTermVO();
        vo2.setActivityType(ActivityType.GOAT_LED);
        vo2.setStartTime(sdf.parse("2019-09-07"));
        vo2.setEndTime(sdf.parse("2019-09-10"));
        try {
            activityFactory.addAndGetTerm(vo2);
            //不报错不行
            Assert.fail();
        } catch (ActivityException e) {
        }

        //重叠情况三测试
        ActivityTermVO vo3=new ActivityTermVO();
        vo3.setActivityType(ActivityType.GOAT_LED);
        vo3.setStartTime(sdf.parse("2019-09-07"));
        vo3.setEndTime(sdf.parse("2019-09-10"));
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
    @Test
    @Transactional(rollbackFor = Exception.class)
    public void selGoatActivityWithFunc_selEnlistTest() throws ActivityException {
        SpreadActivity activity=new SpreadActivity();
        activity.setActivityId(20170508L);
        activity.setTermId(20170508L);
        activity.setType(ActivityType.GOAT_SELL.ordinal());
        activity.setContext("{}");
        spreadActivityMapper.insertSelective(activity);

        Map<Long,SpreadEnlist> inseMap=new HashMap<>();
        for(int i=0;i<10;i++){
            SpreadEnlist se=new SpreadEnlist();
            se.setActivityId(20170508L);
            se.setCreateTime(new Date());
            se.setName("testname"+i);
            se.setTelephone("tsetphone"+1);
            se.setDraw(i%2);
            spreadEnlistMapper.insertSelective(se);
            inseMap.put(se.getEnlistId(),se);
        }

        GoatActivity ga=activityFactory.selActivityById(20170508L);
        ga.setActivityId(20170508L);
        //测试一,hitType=0
        List<ActivityEnlistVO> list=ga.selEnlist(0);
        List<Long> enids1=new ArrayList<>();
        for(ActivityEnlistVO vo:list){
            enids1.add(vo.getEnId());
            //验证activity_id\name\telephone是否为空
            SpreadEnlist setmp=inseMap.get(vo.getEnId());
            assertNotEquals(setmp,null);
            assertEquals(vo.getActivityId(),setmp.getActivityId());
            assertEquals(vo.getName(),setmp.getName());
            assertEquals(vo.getTelephone(),setmp.getTelephone());
        }
        SpreadEnlistExample example=new SpreadEnlistExample();
        SpreadEnlistExample.Criteria ce=example.createCriteria().andDrawEqualTo(0).andEnlistIdIn(enids1);
        example.setOrderByClause("create_time desc");
        List<SpreadEnlist> selist=spreadEnlistMapper.selectByExample(example);
        List<Long> enids2=new ArrayList<>();
        for(SpreadEnlist se:selist){
            enids2.add(se.getEnlistId());
        }
        assertEquals(enids1,enids2);


        //测试二,hitType=1
        list=ga.selEnlist(1);
        enids1=new ArrayList<>();
        for(ActivityEnlistVO vo:list){
            enids1.add(vo.getEnId());
            //验证activity_id\name\telephone是否为空
            SpreadEnlist setmp=inseMap.get(vo.getEnId());
            assertNotEquals(setmp,null);
            assertEquals(vo.getActivityId(),setmp.getActivityId());
            assertEquals(vo.getName(),setmp.getName());
            assertEquals(vo.getTelephone(),setmp.getTelephone());
        }
        example=new SpreadEnlistExample();
        ce=example.createCriteria().andDrawEqualTo(1).andEnlistIdIn(enids1);
        example.setOrderByClause("create_time desc");
        selist=spreadEnlistMapper.selectByExample(example);
        enids2=new ArrayList<>();
        for(SpreadEnlist se:selist){
            enids2.add(se.getEnlistId());
        }
        assertEquals(enids1,enids2);

        //测试三,hitType=2
        list=ga.selEnlist(2);
        enids1=new ArrayList<>();
        for(ActivityEnlistVO vo:list){
            enids1.add(vo.getEnId());
            //验证activity_id\name\telephone是否为空
            SpreadEnlist setmp=inseMap.get(vo.getEnId());
            assertNotEquals(setmp,null);
            assertEquals(vo.getActivityId(),setmp.getActivityId());
            assertEquals(vo.getName(),setmp.getName());
            assertEquals(vo.getTelephone(),setmp.getTelephone());
        }
        example=new SpreadEnlistExample();
        ce=example.createCriteria().andEnlistIdIn(enids1);
        example.setOrderByClause("create_time desc");
        selist=spreadEnlistMapper.selectByExample(example);
        enids2=new ArrayList<>();
        for(SpreadEnlist se:selist){
            enids2.add(se.getEnlistId());
        }
        assertEquals(enids1,enids2);

        //测试四,activity_id为空
        ga.setActivityId(null);
        list=ga.selEnlist(-1);
        assertEquals(list,null);
    }

    @Test
    @Transactional(rollbackFor = Exception.class)
    public void selLedActivityWithFunc_randomHitTest() throws ActivityException {

        //4个参数不能为空
        //参数//Long userId, Long shopId, String name, String phone

        SpreadActivity sa = new SpreadActivity();
        sa.setContext("{}");
        sa.setDescription("");
        sa.setSort(1);
        sa.setTermId(20170501L);
        sa.setType(ActivityType.GOAT_LED.ordinal());
        spreadActivityMapper.insert(sa);

        LedActivity la = activityFactory.selActivityById(sa.getActivityId());
        la.setActivityId(sa.getActivityId());

        //先插入五条全部合格的数据
        for (int i = 0; i < 5; i++) {
            SpreadEnlist se = new SpreadEnlist();
            se.setDraw(0);
            se.setActivityId(la.getActivityId());
            se.setCreateTime(new Date());
            se.setName("我的天" + i);
            se.setShopId((long) (100 + i));
            se.setTelephone("12118128122");
            se.setUserId(1000000808 + (long) i);
            spreadEnlistMapper.insertSelective(se);
        }
        //测试数量异常
        int num=0;
        try {
             num=6;
            la.randomHit(num);
            Assert.fail();
        } catch (ActivityException e) {
           // System.err.println(e.getMessage());
        }
       // try {
            num=4;
            List<ActivityEnlistVO> volsit=la.randomHit(num);
            List<Long> eidlist=new ArrayList<>();
            for(ActivityEnlistVO avo:volsit){
                eidlist.add(avo.getEnId());
            }

            SpreadEnlistExample seex=new SpreadEnlistExample();
            seex.createCriteria().andActivityIdEqualTo(la.getActivityId()).andEnlistIdIn(eidlist);

            List<SpreadEnlist> sdlist=spreadEnlistMapper.selectByExample(seex);
            assertEquals(sdlist.size(),num);
           /* if(sdlist.size()!=num){
                System.err.println("测试异常:数量不同于数据库中签数量");
            }*/
            for(SpreadEnlist se:sdlist){
               // if(se.getDraw()!=1){
                    assertEquals(se.getDraw ().intValue (),1);
                    //System.err.println("测试异常:"+se.getEnlistId()+"没有将draw设置成1");
               // }
            }
        //} catch (ActivityException e) {
        //    System.err.println(e.getMessage());
       // }

        try {
            SpreadEnlist se = new SpreadEnlist();
            se.setDraw(1);
            se.setActivityId(la.getActivityId());
            se.setCreateTime(new Date());
            se.setName("我的天" + 110);
            se.setShopId((long) (100 + 110));
            se.setTelephone("12118128122");
            se.setUserId(1000000808 + (long) 110);
            spreadEnlistMapper.insertSelective(se);
            la.randomHit(num);
            Assert.fail();
        } catch (ActivityException e) {
            System.err.println(e.getMessage());
        }


    }

    /**
     * 修改其次测试
     */
    @Test
    @Transactional(rollbackFor = Exception.class)
    public void selTermWithFunc_modify() throws ParseException {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        SpreadTerm term=new SpreadTerm();
        term.setType(ActivityType.GOAT_SELL.ordinal());
        term.setStartTime(sdf.parse("2010-05-12"));
        term.setEndTime(sdf.parse("2010-05-15"));
        spreadTermMapper.insertSelective(term);
        SpreadTerm term2=new SpreadTerm();
        term2.setType(ActivityType.GOAT_SELL.ordinal());
        term2.setStartTime(sdf.parse("2010-05-16"));
        term2.setEndTime(sdf.parse("2010-05-18"));
        spreadTermMapper.insertSelective(term2);
        //测试修改,时间与自己重叠
        ActivityTerm at=activityFactory.selTermById(term2.getTermId());
        try {
            at.modify(ActivityType.GOAT_LED,sdf.parse("2010-05-17"),sdf.parse("2010-05-18"));
            SpreadTerm st=spreadTermMapper.selectByPrimaryKey(term2.getTermId());
            assertEquals(ActivityType.GOAT_LED.ordinal(),st.getType().intValue());
        } catch (ActivityException e) {
            Assert.fail();
        }
        //异常情况,时间重叠
        try {
            at.modify(ActivityType.GOAT_SELL,sdf.parse("2010-05-14"),sdf.parse("2010-05-16"));
            Assert.fail();
        } catch (ActivityException e) {
        }
        //异常情况,时间小于
        try {
            at.modify(ActivityType.GOAT_SELL,sdf.parse("2010-05-09"),sdf.parse("2010-05-10"));
        } catch (ActivityException e) {
            Assert.fail();
        }
    }
}
