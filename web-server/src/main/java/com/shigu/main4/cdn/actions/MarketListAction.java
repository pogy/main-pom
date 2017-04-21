package com.shigu.main4.cdn.actions;

import com.shigu.main4.cdn.bo.MarketBO;
import com.shigu.main4.cdn.services.MarketListService;
import com.shigu.main4.cdn.vo.MarketTagVO;
import com.shigu.main4.cdn.vo.MarketVO;
import com.shigu.main4.storeservices.MarketShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Objects;

/**
 * 市场列表
 * Created by zhaohongbo on 17/3/25.
 */
@Controller
public class MarketListAction {

    @Autowired
    MarketListService marketListService;
    /**
     * 市场列表首页
     * @return
     */
    @RequestMapping("market")
    public String marketIndex(MarketBO bo, Model model){
        MarketVO marketVO=marketListService.selMarketData(bo.getMid(),bo.getCid());
        model.addAttribute("marketName", marketVO.getMarketName());
        model.addAttribute("markets", marketVO.getMarketTags());
        model.addAttribute("cates",marketVO.getCates());
        model.addAttribute("marketList",marketVO.getFloorVOs());
        model.addAttribute("webSite",marketVO.getWebSite());
        model.addAttribute("marketId",bo.getMid());
        model.addAttribute("cateId",bo.getCid());
        return "cdn/index";
    }
}
