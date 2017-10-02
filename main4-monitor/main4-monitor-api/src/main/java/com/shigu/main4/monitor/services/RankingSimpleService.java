package com.shigu.main4.monitor.services;

import com.shigu.main4.common.exceptions.Main4Exception;
import com.shigu.main4.monitor.vo.RankingCateLineVO;
import com.shigu.main4.monitor.vo.RankingShopVO;

import java.util.List;

/**
 * 类名：RankingSimpleService
 * 类路径：com.shigu.main4.monitor.services.RankingSimpleService
 * 创建者：王浩翔
 * 创建时间：2017-10-02 9:27
 * 项目：main-pom
 * 描述：排行榜业务简单服务
 */
public interface RankingSimpleService {

    /**
     * 根据顶级类目（目前只有男装/女装）获取前三名排行数据
     * @param cid
     * @param periodNum
     * @return
     * @throws Main4Exception
     */
    List<RankingCateLineVO> getRankingCateLinesByCids(Long cid, int periodNum) throws Main4Exception;

    /**
     * 目前根据市场区分店铺类目
     * @param marketIds
     * @param size
     * @return
     */
    List<RankingShopVO> selRankingShopBy(List<Long> marketIds,Integer size);

}
