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
        ShiguTemp rank1 = generateNewAutumnPrizePool(generateConstant(currentActive, 1, 1, 20, "一等奖"),
                0, 0, 1, "2017-08-22 00:00:00", 240);
        shiguTempMapper.insertSelective(rank1);
        ShiguTemp rank2 = generateNewAutumnPrizePool(generateConstant(currentActive, 2, 5, 50, "二等奖"),
                1, 0, 1, "2017-08-19 00:00:00", 48);
        shiguTempMapper.insertSelective(rank2);
        ShiguTemp rank3 = generateNewAutumnPrizePool(generateConstant(currentActive, 3, 120, 100, "三等奖"),
                12, 0, 12, "2017-08-18 00:00:00", 24);
        shiguTempMapper.insertSelective(rank3);
        ShiguTemp rank4 = generateNewAutumnPrizePool(generateConstant(currentActive, 4, 250, 150, "参与奖"),
                25, 0, 250, "2017-08-18 00:00:00", 24);
        shiguTempMapper.insertSelective(rank4);
    }

    /**
     *
     * @param constant 秋装奖池常量信息
     * @param currentPrizeNum 当前可抽奖品数量
     * @param distributedNum 已被抽中奖品数量
     * @param throwNum 奖品下次投放数量
     * @param nextThrowInTime 下次投放时间
     * @param updatePeriod 投放周期
     * @return
     */
    private ShiguTemp generateNewAutumnPrizePool(JSONObject constant, int currentPrizeNum,int distributedNum,int throwNum,String nextThrowInTime,int updatePeriod){
        ShiguTemp pool = new ShiguTemp();
        //设置活动标志
        pool.setFlag(AutumnNewConstant.PRIZE_POOL_FLAG);
        pool.setKey6(constant.toJSONString());
        pool.setKey1(currentPrizeNum+"");
        pool.setKey2(distributedNum+"");
        pool.setKey3(throwNum+"");
        pool.setKey4(nextThrowInTime);
        pool.setKey5(updatePeriod+"");
        return pool;
    }

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