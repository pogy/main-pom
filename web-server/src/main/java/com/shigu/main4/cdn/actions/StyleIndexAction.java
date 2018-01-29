package com.shigu.main4.cdn.actions;

import com.shigu.main4.cdn.bo.StyleChanelMarketSearchBO;
import com.shigu.main4.cdn.bo.StyleChannelGoodsSearchBO;
import com.shigu.main4.cdn.bo.StyleChannelSearchBO;
import com.shigu.main4.cdn.services.IndexShowService;
import com.shigu.main4.cdn.services.StyleChannelService;
import com.shigu.main4.cdn.vo.StyleChannelVO;
import com.shigu.main4.cdn.vo.StyleGoodsInSearch;
import com.shigu.main4.common.tools.ShiguPager;
import com.shigu.search.actions.PageErrAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * 路径:com.shigu.main4.cdn.actions.StyleIndexAction
 * 工程:main-pom
 * 时间:18-1-26上午10:34
 * 创建人:wanghaoxiang
 * 描述：首页风格馆(目前只有杭州男装）
 */
@Controller
public class StyleIndexAction {

    @Autowired
    private PageErrAction pageErrAction;

    @Autowired
    private IndexShowService indexShowService;

    @Autowired
    private StyleChannelService styleChannelService;

    private final String SUCCESS = "success";


    /**
     * 风格频道首页
     *
     * @param bo
     * @param model
     * @return
     */
    @RequestMapping("styleIndex")
    public String styleIndex(StyleChannelSearchBO bo, Model model) {
        String varifyResult = varifyBoAndAddCommon(bo, model);
        if (!SUCCESS.equals(varifyResult)) {
            return varifyResult;
        }
        model.addAttribute("styleBanner", styleChannelService.selStyleIndexBanner(bo.getSpid()));
        //model.addAttribute("shopList",shopList)
        model.addAttribute("hotSaleGoodsList", styleChannelService.selStyleHotStyleList(bo.getSpid()));
        return "styleChannel/styleIndex";
    }

    @RequestMapping("styleGoodsList")
    public String styleGoodsList(StyleChannelGoodsSearchBO bo, Model model) {
        String varifyResult = varifyBoAndAddCommon(bo, model);
        if (!SUCCESS.equals(varifyResult)) {
            return varifyResult;
        }
        model.addAttribute("marketList", styleChannelService.selStyleMarkets(bo.getWebSite(), bo.getSpid()));
        ShiguPager<StyleGoodsInSearch> pager = styleChannelService.searchStyleGoods(bo);
        model.addAttribute("goodsList", pager.getContent());
        model.addAttribute("totalPage", pager.getTotalPages());
        model.addAttribute("pageOption", pager.selPageOption(50));
        return "styleChannel/styleGoodsList";
    }

    /**
     * 风格商品推荐
     *
     * @return
     */
    @RequestMapping("styleRecommd")
    public String styleRecommd(StyleChannelSearchBO bo, Model model) {
        String varifyResult = varifyBoAndAddCommon(bo, model);
        if (!SUCCESS.equals(varifyResult)) {
            return varifyResult;
        }
        model.addAttribute("goodsList", styleChannelService.selStyleRecommendGoodsList(bo.getSpid()));
        return "styleChannel/styleRecommd";
    }


    @RequestMapping("styleMarket")
    public String styleMarket(StyleChanelMarketSearchBO bo, Model model) {
        String varifyResult = varifyBoAndAddCommon(bo, model);
        if (!SUCCESS.equals(varifyResult)) {
            return varifyResult;
        }
        Long mid = bo.getMid();
        model.addAttribute("marketId", null == mid ? 1 : mid);
        model.addAttribute("markets", styleChannelService.selStyleMarkets("hz", bo.getSpid()));
        model.addAttribute("marketList", styleChannelService.selStyleMarketShows(bo.getMid(), bo.getSpid()));
        return "styleChannel/styleMarket";
    }


    /**
     * 风格频道公共搜索条件验证与共同响应结果添加
     *
     * @param bo
     * @param model
     * @return
     */
    private String varifyBoAndAddCommon(StyleChannelSearchBO bo, Model model) {
        Long spid = bo.getSpid();
        if (spid == null) {
            return pageErrAction.pageErr("请指定要查看的频道风格", model);
        }
        model.addAttribute("query", bo);
        //风格大类列表
        List<StyleChannelVO> styleList = indexShowService.selStyleChannelInfo().selObj();
        model.addAttribute("styleList", styleList);
        for (StyleChannelVO vo : styleList) {
            if (spid.equals(vo.getSpid())) {
                //当前风格大类名称
                model.addAttribute("sname", vo.getSname());
            }
        }
        model.addAttribute("catemenu", indexShowService.selStyleChannelCateNavVO());
        return SUCCESS;
    }

}
