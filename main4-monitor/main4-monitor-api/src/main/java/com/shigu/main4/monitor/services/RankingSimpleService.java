package com.shigu.main4.monitor.services;

import com.shigu.main4.common.exceptions.Main4Exception;
import com.shigu.main4.monitor.enums.CidMarketIdMapEnum;
import com.shigu.main4.monitor.enums.RankingPeriodEnum;
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
     * @return
     * @throws Main4Exception
     */
    List<RankingCateLineVO> getRankingCateLinesByCids(Long cid, RankingPeriodEnum periodEnum) throws Main4Exception;

    /**
     * 根据类目排名店铺（目前只有男装、女装、综合，以市场区分）
     * @param cat
     * @return
     */
    List<RankingShopVO> selRankingShopBy(CidMarketIdMapEnum cat);

}
