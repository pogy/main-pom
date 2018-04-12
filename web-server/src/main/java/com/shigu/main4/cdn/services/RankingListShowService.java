package com.shigu.main4.cdn.services;

import com.shigu.main4.cdn.vo.RankingVO;
import com.shigu.main4.common.exceptions.Main4Exception;
import com.shigu.main4.common.tools.ShiguPager;
import com.shigu.main4.monitor.enums.CidMapEnum;
import com.shigu.main4.monitor.enums.CidMarketIdMapEnum;
import com.shigu.main4.monitor.services.RankingSimpleService;
import com.shigu.main4.monitor.vo.RankingShopVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 类名：RankingListShowService
 * 类路径：com.shigu.main4.cdn.services.RankingListShowService
 * 创建者：王浩翔
 * 创建时间：2017-10-03 13:53
 * 项目：main-pom
 * 描述：
 */
@Service("rankingListShowService")
public class RankingListShowService {

    @Autowired
    RankingSimpleService rankingSimpleService;

    //目前没有排行榜对应id值
    public RankingVO getCatRanking(CidMapEnum cidMapEnum, CidMarketIdMapEnum cidMarketIdMapEnum) throws Main4Exception {
        RankingVO rankingVO = new RankingVO();
        rankingVO.setRankingId(cidMapEnum.cid);
        rankingVO.setRankingTitle(cidMapEnum.title);
        rankingVO.setCateLineList(rankingSimpleService.getRankingCateLinesByCids(cidMapEnum.cid, cidMapEnum.cidMarketIdMapEnum.periodEnum));
        rankingVO.setShopList(getRankingShopVOPager(cidMarketIdMapEnum, 1, 10).getContent());
        return rankingVO;
    }

    public RankingVO getShopRanking(CidMarketIdMapEnum cidMarketIdMapEnum) {
        RankingVO rankingVO = new RankingVO();
        rankingVO.setRankingId(cidMarketIdMapEnum.cid);
        rankingVO.setRankingTitle(cidMarketIdMapEnum.title);
        rankingVO.setShopList(getRankingShopVOPager(cidMarketIdMapEnum, 1, 10).getContent());
        return rankingVO;
    }

    public ShiguPager<RankingShopVO> getRankingShopVOPager(CidMarketIdMapEnum cidMarketIdMapEnum, Integer page, Integer size) {
        ShiguPager<RankingShopVO> pager = new ShiguPager<>();
        List<RankingShopVO> rankingShopVOS = rankingSimpleService.selRankingShopBy(cidMarketIdMapEnum);
        if (rankingShopVOS == null) {
            rankingShopVOS=new ArrayList<>();
        }
        pager.setNumber(page);
        pager.calPages(rankingShopVOS.size(), size);
        int startIndex = (page - 1) * size;
        int endIndex = startIndex + size;
        if (startIndex > rankingShopVOS.size()) {
            pager.setContent(rankingShopVOS.subList(0, 0));
        } else if (endIndex > rankingShopVOS.size()) {
            pager.setContent(rankingShopVOS.subList(startIndex, rankingShopVOS.size()));
        } else {
            pager.setContent(rankingShopVOS.subList(startIndex, endIndex));
        }
        return pager;
    }

}
