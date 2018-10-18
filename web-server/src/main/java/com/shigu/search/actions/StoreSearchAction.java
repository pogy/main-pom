package com.shigu.search.actions;

import com.shigu.main4.common.tools.ShiguPager;
import com.shigu.main4.common.tools.StringUtil;
import com.shigu.main4.storeservices.SearchCategoryService;
import com.shigu.main4.tools.RedisIO;
import com.shigu.search.bo.StorenumBO;
import com.shigu.search.services.CategoryInSearchService;
import com.shigu.search.services.StoreSelFromEsService;
import com.shigu.search.vo.StoreInSearch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 店铺类搜索
 * Created by zhaohongbo on 17/4/5.
 */
@Controller
public class StoreSearchAction {

    @Autowired
    StoreSelFromEsService storeSelFromEsService;

    @Autowired
    CategoryInSearchService categoryInSearchService;

    @Autowired
    SearchCategoryService searchCategoryService;

    @Autowired
    RedisIO redisIO;

    private static String SHIGU_SHOP_SEARCH_KEYWORD = "shigu_shop_search_keyword";

    /**
     * 档口搜索
     * @return
     */
    @RequestMapping("storenum")
    public String storenum(StorenumBO bo, Model model){
        bo.setRows(15);
        if(bo.getWebSite()==null){
            bo.setWebSite("hz");
        }
        if (bo.getKeyword() == null) {
            bo.setKeyword("");
        }
        if (!StringUtil.isNull(bo.getKeyword()))
            redisIO.rpush(SHIGU_SHOP_SEARCH_KEYWORD,bo.getKeyword());
        model.addAttribute("query",bo);
        model.addAttribute("markets",categoryInSearchService.selMarkets(bo.getWebSite()));
        ShiguPager<StoreInSearch> pager=storeSelFromEsService.searchStore(bo);
        model.addAttribute("storelist",pager.getContent());
        model.addAttribute("pageOption",pager.selPageOption(bo.getRows()));
        model.addAttribute("webSite",bo.getWebSite());
        model.addAttribute("catemenu",searchCategoryService.getMarketCateShow(bo.getWebSite()));
        if ("kx".equalsIgnoreCase(bo.getWebSite())) {
            return "xieSearch/storenum";
        } else {
            return "search/storenum";
        }

    }

}
