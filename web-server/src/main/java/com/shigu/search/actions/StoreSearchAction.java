package com.shigu.search.actions;

import com.shigu.main4.common.tools.ShiguPager;
import com.shigu.search.bo.StorenumBO;
import com.shigu.search.services.CategoryInSearchService;
import com.shigu.search.services.StoreSelFromEsService;
import com.shigu.search.vo.StoreInSearch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.concurrent.ExecutorService;

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
        model.addAttribute("query",bo);
        model.addAttribute("markets",categoryInSearchService.selMarkets(bo.getWebSite()));
        ShiguPager<StoreInSearch> pager=storeSelFromEsService.searchStore(bo);
        model.addAttribute("storelist",pager.getContent());
        model.addAttribute("pageOption",pager.selPageOption(bo.getRows()));
        model.addAttribute("webSite",bo.getWebSite());
        if ("kx".equalsIgnoreCase(bo.getWebSite())) {
            return "xieSearch/storenum";
        } else {
            return "search/storenum";
        }

    }

}
