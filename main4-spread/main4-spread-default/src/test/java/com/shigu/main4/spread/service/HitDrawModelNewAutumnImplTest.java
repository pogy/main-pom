package com.shigu.main4.spread.service;

import com.alibaba.fastjson.JSONObject;
import com.opentae.data.mall.beans.ShiguTemp;
import com.opentae.data.mall.interfaces.ShiguTempMapper;
import com.shigu.main4.spread.enums.ActivityDrawEnum;
import com.shigu.main4.spread.enums.AutumnNewConstant;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * 类名：HitDrawModelNewAutumnImplTest
 * 类路径：com.shigu.main4.spread.service.HitDrawModelNewAutumnImplTest
 * 创建者：王浩翔
 * 创建时间：2017-08-15 19:32
 * 项目：main-pom
 * 描述：
 */

/**
 * 测试类com.shigu.main4.spread.service.impl.HitDrawModelNewAutumnImpl
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/store_test.xml")
public class HitDrawModelNewAutumnImplTest {


    @Autowired
    private ShiguTempMapper shiguTempMapper;
    /**
     * 初始化秋装奖池
     */
    @Test
    public void initPool() {
        ActivityDrawEnum currentActive = AutumnNewConstant.CURRENT_ACTIVE;
        ShiguTemp rank1 = generateNewAutumn2PrizePool(generateConstant(currentActive, 1, 2, 10, "A4"),
                0, "2017-09-11 00:00:00", 192);
        shiguTempMapper.insertSelective(rank1);
        ShiguTemp rank2 = generateNewAutumn2PrizePool(generateConstant(currentActive, 2, 3, 20, "A3"),
                 0, "2017-09-11 00:00:00", 192);
        shiguTempMapper.insertSelective(rank2);
        ShiguTemp rank3 = generateNewAutumn2PrizePool(generateConstant(currentActive, 3, 100, 80, "A2"),
                14, "2017-09-11 00:00:00", 24);
        shiguTempMapper.insertSelective(rank3);
        ShiguTemp rank4 = generateNewAutumn2PrizePool(generateConstant(currentActive, 4, 7000, 890, "A1"),
                1000, "2017-09-11 00:00:00", 24);
        shiguTempMapper.insertSelective(rank4);
    }


    private ShiguTemp generateNewAutumn2PrizePool(JSONObject constant,int throwNum,String nextThrowInTime,int updatePeriod) {
        ShiguTemp pool = new ShiguTemp();
        //奖池标记
        pool.setFlag(AutumnNewConstant.PRIZE_POOL_FLAG);
        //奖池常量
        pool.setKey6(constant.toJSONString());
        //当前奖池内数量
        pool.setKey1("0");
        //已被抽中奖品数量
        pool.setKey2("0");
        //一次投放奖品数量
        pool.setKey3(throwNum+"");
        //下次投放奖品时间
        pool.setKey4(nextThrowInTime);
        //奖品投放周期（小时）
        pool.setKey5(updatePeriod+"");
        return pool;
    }
    ///**
    // *
    // * @param constant 秋装奖池常量信息
    // * @param currentPrizeNum 当前可抽奖品数量
    // * @param distributedNum 已被抽中奖品数量
    // * @param throwNum 奖品下次投放数量
    // * @param nextThrowInTime 下次投放时间
    // * @param updatePeriod 投放周期
    // * @return
    // */
    //private ShiguTemp generateNewAutumnPrizePool(JSONObject constant, int currentPrizeNum,int distributedNum,int throwNum,String nextThrowInTime,int updatePeriod){
    //    ShiguTemp pool = new ShiguTemp();
    //    //设置活动标志
    //    pool.setFlag(AutumnNewConstant.PRIZE_POOL_FLAG);
    //    pool.setKey6(constant.toJSONString());
    //    pool.setKey1(currentPrizeNum+"");
    //    pool.setKey2(distributedNum+"");
    //    pool.setKey3(throwNum+"");
    //    pool.setKey4(nextThrowInTime);
    //    pool.setKey5(updatePeriod+"");
    //    return pool;
    //}

    /**
     * 秋装奖池常量信息
     * @param activityDrawEnum
     * @param rank
     * @param totalNum
     * @param hitProbability
     * @param prizeGood
     * @return
     */
    private JSONObject generateConstant(ActivityDrawEnum activityDrawEnum, int rank, int totalNum,int hitProbability,String prizeGood) {
        JSONObject poolConstant = new JSONObject();
        poolConstant.put("activeName",activityDrawEnum.activeName);
        poolConstant.put("activeType",activityDrawEnum.type);
        poolConstant.put("term",activityDrawEnum.term);
        poolConstant.put("pemId",activityDrawEnum.pemId);
        poolConstant.put("rank",rank);
        poolConstant.put("fullNumber",totalNum);
        poolConstant.put("hitProbability",hitProbability);
        poolConstant.put("prizeGood",prizeGood);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date startTime = sdf.parse(activityDrawEnum.startTime);
            poolConstant.put("startTime",startTime);
            Date deadline = sdf.parse(activityDrawEnum.deadline);
            poolConstant.put("deadline",deadline);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return poolConstant;
    }
}