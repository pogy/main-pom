package com.shigu.daifa.actions;

import com.shigu.component.shiro.AuthorityUser;
import com.shigu.config.DaifaSessionConfig;
import com.shigu.daifa.services.DaifaTodayFinanceService;
import com.shigu.daifa.vo.NewFinancialVo;
import com.shigu.main4.common.util.DateUtil;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created By zyl on 2018/9/6 0006/15:28
 */
@Controller
public class DaifaTodayFinanceAction {

    @Autowired
    DaifaTodayFinanceService daifaTodayFinanceService;




    /**
     * 当天发货商品金额
     * 当天发货商品服务费
     * 当天快递费
     * 当日退货退款金额
     */
    @RequestMapping("daifa/dfStatistic")
    public String financialStatistic(String time, Model model){
        Session session = SecurityUtils.getSubject().getSession();
        AuthorityUser auth = (AuthorityUser) session.getAttribute(DaifaSessionConfig.DAIFA_SESSION);
        if(StringUtils.isEmpty(time)){
            time= DateUtil.dateToString(new Date(),DateUtil.patternA);
        }

        NewFinancialVo vo=daifaTodayFinanceService.getFinancial(time,auth.getDaifaSellerId());
        Map<String,String> map=new HashMap<>();
        map.put("time",time);
        model.addAttribute("query",map);
        model.addAttribute("orderStatistics",vo);
        model.addAttribute("userName",auth.getDaifaUserName ());
        model.addAttribute("menu","dfStatistic.htm");//前台所要的左边菜单
        return  "daifa/dfStatistic";
    }
}
