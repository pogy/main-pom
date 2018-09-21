package com.shigu.activity.actions;

import com.opentae.data.mall.beans.ShiguMarketActivitys;
import com.shigu.activity.bo.ActivityBo;
import com.shigu.activity.service.MarketActivityService;
import com.shigu.activity.vo.ActivityGoodsVo;
import com.shigu.main4.common.tools.ShiguPager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ProjectName: main-pom
 * @Package: com.shigu.activity.actions
 * @ClassName: MarketActivityAction
 * @Author: sy
 * @CreateDate: 2018/9/20 0020 17:35
 */
@Controller
@RequestMapping("activity")
public class MarketActivityAction {

    @Autowired
    private MarketActivityService marketActivityService;

    @RequestMapping("popularStyle")
    public String popularStyle(ActivityBo bo, Model model){
        ShiguMarketActivitys activity = marketActivityService.selActivity(bo.getMaId());
        ShiguPager<ActivityGoodsVo> pager = marketActivityService.selActivityGoods(bo.getMaId(), bo.getPage(), bo.getPageSize());
        model.addAttribute("activeName",activity.getMaName());
        model.addAttribute("bannerSrc",activity.getMaPic());
        model.addAttribute("maId",bo.getMaId());
        model.addAttribute("bgColor",activity.getMaBackground());
        model.addAttribute("goodsList",pager.getContent());
        model.addAttribute("pageOption",pager.selPageOption(bo.getPageSize()));
        return "xzSearch/popularStyle";
    }
}
