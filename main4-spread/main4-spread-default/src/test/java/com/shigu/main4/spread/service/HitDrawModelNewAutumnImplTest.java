package com.shigu.main4.spread.service;

import com.alibaba.fastjson.JSONObject;
import com.opentae.data.mall.beans.ShiguTemp;
import com.opentae.data.mall.interfaces.ShiguTempMapper;
import com.shigu.main4.spread.enums.ActivityDrawEnum;
import com.shigu.main4.spread.vo.active.draw.NewAutumnPrizePool;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.*;
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
        //System.out.println(generateConstant(ActivityDrawEnum.NEW_AUTUMN,1,1,50,"一等奖"));
        //JSONObject poolConstant = new JSONObject();
        ShiguTemp rank1 = generateNewAutumnPrizePool(generateConstant(ActivityDrawEnum.NEW_AUTUMN, 1, 1, 50, "一等奖"),
                0, 0, 1, "2017-08-22 00:00:00", 240);
        shiguTempMapper.insertSelective(rank1);

    }

    /**
     *
     * @param constant 奖池常量信息
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
        pool.setFlag(NewAutumnPrizePool.PRIZE_POOL_FLAG);
        pool.setKey6(constant.toJSONString());
        pool.setKey1(currentPrizeNum+"");
        pool.setKey2(distributedNum+"");
        pool.setKey3(throwNum+"");
        pool.setKey4(nextThrowInTime);
        pool.setKey5(updatePeriod+"");
        return pool;
    }

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