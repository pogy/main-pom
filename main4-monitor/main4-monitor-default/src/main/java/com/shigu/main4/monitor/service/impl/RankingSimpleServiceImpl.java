package com.shigu.main4.monitor.service.impl;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.shigu.main4.common.exceptions.Main4Exception;
import com.shigu.main4.monitor.enums.CidMapEnum;
import com.shigu.main4.monitor.enums.CidMarketIdMapEnum;
import com.shigu.main4.monitor.services.RankingSimpleService;
import com.shigu.main4.monitor.vo.RankingCateLineVO;
import com.shigu.main4.monitor.vo.RankingShopVO;
import com.shigu.main4.tools.RedisIO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 类名：RankingSimpleServiceImpl
 * 类路径：com.shigu.main4.monitor.service.impl.RankingSimpleServiceImpl
 * 创建者：王浩翔
 * 创建时间：2017-10-02 10:37
 * 项目：main-pom
 * 描述：
 */
@Service("rankingSimpleService")
public class RankingSimpleServiceImpl implements RankingSimpleService {

    @Autowired
    RedisIO redisIO;

    /**
     * 拿到一周起始时间的时间戳（周日）
     *
     * @param periodNum 往前搜索的星期数 0是本周，1是上周。。。
     * @return
     */
    public static String getWeekTimeStamp(int periodNum) {
        Calendar instance = Calendar.getInstance();
        instance.setTime(new Date());
        instance.set(Calendar.DAY_OF_WEEK, 1);
        instance.add(Calendar.DATE, -7 * periodNum);
        return new SimpleDateFormat("yyyy-MM-dd").format(instance.getTime());
    }


    @Override
    public List<RankingCateLineVO> getRankingCateLinesByCids(Long cid) throws Main4Exception {
        List<RankingCateLineVO> list = redisIO.getList(CidMapEnum.map(cid) + getWeekTimeStamp(0), RankingCateLineVO.class);
        if (list == null) {
            list = redisIO.getList(CidMapEnum.map(cid) + getWeekTimeStamp(1), RankingCateLineVO.class);
        }
        return list;
    }

    /**
     * 获取当前期店铺排行数据
     * @return
     */
    @Override
    public List<RankingShopVO> selRankingShopBy(CidMarketIdMapEnum cat) {
        String key = cat.getIndexPrefix() + getWeekTimeStamp(0);
        List<RankingShopVO> list = redisIO.getList(key, RankingShopVO.class);
        if (list == null) {
            //如果当前期数据还不存在（还在计算过程中），则返回上一期数据
            key = cat.getIndexPrefix() + getWeekTimeStamp(1);
            list = redisIO.getList(key,RankingShopVO.class);
        }
        return list;
    }


}
