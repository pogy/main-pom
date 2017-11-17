package com.shigu.main4.monitor.enums;

import com.shigu.main4.common.exceptions.Main4Exception;

import java.util.ArrayList;
import java.util.List;

/**
 * 类名：CidMarketIdMapEnum
 * 类路径：com.shigu.main4.monitor.enums.CidMarketIdMapEnum
 * 创建者：王浩翔
 * 创建时间：2017-10-02 14:23
 * 项目：main-pom
 * 描述：
 */
public enum CidMarketIdMapEnum {

    MAN_CAT_SHOP_RANKING(30L, "man_cat_shop_ranking_score_index_", "本周男装排行榜", RankingPeriodEnum.RANKING_BY_WEEK,10000, 608L, 613L, 617L, 619L, 621L, 648L, 650L, 655L, 661L, 670L, 674L, 1087L, 1105L, 1403L),  //男装对应市场
    WOMAN_CAT_SHOP_RANKING(16L, "woman_cat_shop_ranking_score_index_", "本周女装排行榜", RankingPeriodEnum.RANKING_BY_WEEK,10000, 601L, 642L, 652L, 666L, 668L, 1063L, 1462L), //女装对应市场
    ALL_CAT_SHOP_RANKING(0L, "all_cat_shop_ranking_score_index_", "本周档口总排行榜", RankingPeriodEnum.RANKING_BY_WEEK,10000, 601L, 608L, 613L, 617L, 619L, 621L, 642L, 648L, 650L, 652L, 655L, 661L, 666L, 668L, 670L, 674L, 1063L, 1087L, 1105L, 1403L, 1455L, 1462L, 1552L, 1597L), //杭州全部市场
    ALL_CAT_SHOP_RANKING_MONTH(-1L, "all_cat_shop_ranking_score_month_index_", "本月档口总排行榜", RankingPeriodEnum.RANKING_BY_MONTH,40000, 601L, 608L, 613L, 617L, 619L, 621L, 642L, 648L, 650L, 652L, 655L, 661L, 666L, 668L, 670L, 674L, 1063L, 1087L, 1105L, 1403L, 1455L, 1462L, 1552L, 1597L), //杭州全部市场月排行
    ;
    public final Long cid;
    public final String indexPrefix;
    public final String title;
    public final RankingPeriodEnum periodEnum;
    public final int totalScore;
    private final List<Long> marketIds;

    CidMarketIdMapEnum(Long cid, String indexPrefix, String title, RankingPeriodEnum periodEnum, int totalScore, Long... marketIds) {
        this.cid = cid;
        this.indexPrefix = indexPrefix;
        this.marketIds = new ArrayList<Long>();
        this.title = title;
        this.periodEnum = periodEnum;
        this.totalScore = totalScore;
        for (Long marketId : marketIds) {
            this.marketIds.add(marketId);
        }
    }

    public String getIndexPrefix() {
        return indexPrefix;
    }

    public List<Long> getMarketIds() {
        ArrayList<Long> result = new ArrayList<>();
        result.addAll(marketIds);
        return result;
    }

    public static CidMarketIdMapEnum cidMarketIdMap(Long cid) throws Main4Exception {
        for (CidMarketIdMapEnum cidMarketIdMapEnum : values()) {
            if (cidMarketIdMapEnum.cid.equals(cid)) {
                return cidMarketIdMapEnum;
            }
        }
        throw new Main4Exception("没有对应的排行榜映射");
    }
}
