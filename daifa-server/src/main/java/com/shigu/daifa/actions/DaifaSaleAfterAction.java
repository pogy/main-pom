package com.shigu.daifa.actions;

import com.shigu.daifa.bo.SaleAfterBO;
import com.shigu.daifa.services.DaifaSaleAfterService;
import com.shigu.daifa.vo.DaifaSaleAfter;
import com.shigu.main4.common.tools.ShiguPager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DaifaSaleAfterAction {
    @Autowired
    DaifaSaleAfterService daifaSaleAfterService;
    @RequestMapping("daifa/afterSaleOrder")
    public String afterSaleOrder(SaleAfterBO bo, Model model){
        if(bo.getPage()==null){
            bo.setPage(1);
        }
        ShiguPager<DaifaSaleAfter> pager=daifaSaleAfterService.afterSaleOrder(bo);
        model.addAttribute("query",bo);
        model.addAttribute("orders",pager.getContent());
        model.addAttribute("pageOption",pager.selPageOption(10));
        return "daifa/afterSaleOrder";
    }
}
