package com.shigu.main4.cdn.vo;

import com.shigu.main4.monitor.vo.RankingCateLineVO;
import com.shigu.main4.monitor.vo.RankingShopVO;

import java.util.List;

/**
 * 类名：RankingVO
 * 类路径：com.shigu.main4.cdn.vo.RankingVO
 * 创建者：王浩翔
 * 创建时间：2017-09-27 16:58
 * 项目：main-pom
 * 描述：排行榜分类数据显示
 */
public class RankingVO {
    //排行榜id，用于查看完整榜单的参数
    private Long rankingId;
    //排行榜标题
    private String rankingTitle;
    //左侧数据统计条列表 类目排行数据，只有按类型排行时才有
    private List<RankingCateLineVO> cateLineList;
    //店铺排行榜列表 结果非空，按类型排行和档口排行都有数据
    private List<RankingShopVO> shopList;

    public Long getRankingId() {
        return rankingId;
    }

    public void setRankingId(Long rankingId) {
        this.rankingId = rankingId;
    }

    public String getRankingTitle() {
        return rankingTitle;
    }

    public void setRankingTitle(String rankingTitle) {
        this.rankingTitle = rankingTitle;
    }

    public List<RankingCateLineVO> getCateLineList() {
        return cateLineList;
    }

    public void setCateLineList(List<RankingCateLineVO> cateLineList) {
        this.cateLineList = cateLineList;
    }

    public List<RankingShopVO> getShopList() {
        return shopList;
    }

    public void setShopList(List<RankingShopVO> shopList) {
        this.shopList = shopList;
    }
}
