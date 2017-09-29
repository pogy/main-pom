package com.shigu.main4.cdn.actions;

import com.shigu.main4.cdn.vo.RankingVO;
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

    @RequestMapping("fullShopRanking")
    public String fullShopRanking(Long type, String webSite, Integer page, Model model) {

        //todo:具体实现
        model.addAttribute("shopRanking",new RankingVO());
        return "xzSearch/fullShopRanking";
    }

    @RequestMapping("shopRanking")
    public String shopRanking(Model model) {
        //todo:具体实现
        List<RankingVO> rankingCateList = new ArrayList<>();
        List<Object> rankingShopList = new ArrayList<>();
        model.addAttribute("rankingCateList",rankingCateList);
        model.addAttribute("rankingShopList",rankingShopList);
        return "xzSearch/shopRanking";
    }
}
