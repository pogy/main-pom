package com.shigu.main4.cdn.actions;

import com.shigu.main4.cdn.bo.FullShopRankingBO;
import com.shigu.main4.cdn.services.RankingListShowService;
import com.shigu.main4.cdn.vo.RankingVO;
import com.shigu.main4.common.exceptions.Main4Exception;
import com.shigu.main4.common.tools.ShiguPager;
import com.shigu.main4.monitor.enums.CidMapEnum;
import com.shigu.main4.monitor.enums.CidMarketIdMapEnum;
import com.shigu.main4.monitor.vo.RankingShopVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * 类名：RankingListAction
 * 类路径：com.shigu.main4.cdn.actions.RankingListAction
 * 创建者：王浩翔
 * 创建时间：2017-09-27 15:46
 * 项目：main-pom
 * 描述：排行榜数据展示
 */
@Controller
public class RankingListAction {

    @Autowired
    RankingListShowService rankingListShowService;

    @RequestMapping("fullShopRanking")
    public String fullShopRanking(FullShopRankingBO bo, Model model) throws Main4Exception {
        //todo:具体实现
        CidMarketIdMapEnum cidMarketIdMapEnum = CidMarketIdMapEnum.cidMarketIdMap(bo.getId());
        if (bo.getPage() == null) {
            bo.setPage(1);
        }
        ShiguPager<RankingShopVO> rankingShopVOPager = rankingListShowService.getRankingShopVOPager(cidMarketIdMapEnum, bo.getPage(), 20);
        RankingVO shopRanking = new RankingVO();
        shopRanking.setRankingId(cidMarketIdMapEnum.cid);
        shopRanking.setRankingTitle(cidMarketIdMapEnum.title);
        shopRanking.setShopList(rankingShopVOPager.getContent());
        model.addAttribute("rankingId",shopRanking.getRankingId());
        model.addAttribute("shopRanking", shopRanking);
        model.addAttribute("pageOption",rankingShopVOPager.selPageOption(20));
        model.addAttribute("query",bo);
        return "xzSearch/fullShopRanking";
    }

    @RequestMapping("shopRanking")
    public String shopRanking(Model model) throws Main4Exception {
        //todo:具体实现
        List<RankingVO> rankingCateList = new ArrayList<>();
        rankingCateList.add(rankingListShowService.getCatRanking(CidMapEnum.MAN_CAT_RANKING, CidMarketIdMapEnum.MAN_CAT_SHOP_RANKING));
        rankingCateList.add(rankingListShowService.getCatRanking(CidMapEnum.WOMAN_CAT_RANKING,CidMarketIdMapEnum.WOMAN_CAT_SHOP_RANKING));
        ArrayList<RankingVO> rankingShopList = new ArrayList<>();
        rankingShopList.add(rankingListShowService.getShopRanking(CidMarketIdMapEnum.ALL_CAT_SHOP_RANKING));
        rankingShopList.add(rankingListShowService.getShopRanking(CidMarketIdMapEnum.ALL_CAT_SHOP_RANKING_MONTH));
        model.addAttribute("rankingCateList",rankingCateList);
        model.addAttribute("rankingShopList",rankingShopList);
        return "xzSearch/shopRanking";
    }
}
