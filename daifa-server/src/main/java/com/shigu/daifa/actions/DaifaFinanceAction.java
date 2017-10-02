package com.shigu.daifa.actions;

import com.shigu.component.shiro.AuthorityUser;
import com.shigu.config.DaifaSessionConfig;
import com.shigu.daifa.services.DaifaFinanceService;
import com.shigu.daifa.vo.FinanceVO;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.Map;

@Controller
public class DaifaFinanceAction {
    @Autowired
    DaifaFinanceService daifaFinanceService;

    @RequestMapping("daifa/financialStatistic")
    public String financialStatistic(String time, Model model){
        Session session = SecurityUtils.getSubject().getSession();
        AuthorityUser auth = (AuthorityUser) session.getAttribute(DaifaSessionConfig.DAIFA_SESSION);

        FinanceVO vo=daifaFinanceService.selFinace(time,auth.getDaifaSellerId());
        Map<String,String> map=new HashMap<>();
        map.put("time",time);
        model.addAttribute("query",map);
        model.addAttribute("orderStatistics",vo);
        return  "daifa/financialStatistic";
    }
}
