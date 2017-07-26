package com.shigu.main4.cdn.actions;

import com.alibaba.fastjson.JSON;
import com.shigu.main4.cdn.bo.MarketBO;
import com.shigu.main4.cdn.services.MarketListService;
import com.shigu.main4.cdn.vo.MarketTagVO;
import com.shigu.main4.cdn.vo.MarketVO;
import com.shigu.main4.storeservices.MarketShopService;
import com.shigu.main4.vo.MarketNavShow;
import com.shigu.tools.ResultRetUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
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
        if ("kx".equalsIgnoreCase(marketVO.getWebSite())) {
            return "cdn/xieIndex";
        } else {
            return "cdn/index";
        }

    }

    /**
     * 市场展示数据
     * @param webSite
     * @return
     */
    @RequestMapping(value = "/marketDataList" )
    @ResponseBody
    public void marketList(String callback, String webSite, HttpServletResponse response) throws IOException {
        if(StringUtils.isEmpty(webSite)){
            webSite = "hz";
        }
        List<MarketNavShow> marketNavShowList = marketListService.selMarketNavShow(webSite);
        ResultRetUtil.returnJsonp(callback,JSON.toJSONString(marketNavShowList),response);
    }
}
