package com.shigu.daifa.actions;

import com.shigu.component.shiro.AuthorityUser;
import com.shigu.config.DaifaSessionConfig;
import com.shigu.daifa.services.DaifaFinanceService;
import com.shigu.daifa.vo.FinanceVO;
import com.shigu.daifa.vo.WorkerTakeNumVO;
import com.shigu.main4.common.util.DateUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class DaifaFinanceAction {
    @Autowired
    DaifaFinanceService daifaFinanceService;
    /**
     * ====================================================================================
     * @方法名： financialStatistic
     * @user gzy 2017/10/13 13:09
     * @功能：财务统计
     * @param: [time, model]
     * @return: java.lang.String
     * @exception:
     * ====================================================================================
     *
     */
    @RequestMapping("daifa/financialStatistic")
    public String financialStatistic(String time, Model model){

        Session session = SecurityUtils.getSubject().getSession();
        AuthorityUser auth = (AuthorityUser) session.getAttribute(DaifaSessionConfig.DAIFA_SESSION);

        FinanceVO vo=daifaFinanceService.selFinace(time,auth.getDaifaSellerId());
        Map<String,String> map=new HashMap<>();
        map.put("time",time);
        model.addAttribute("query",map);
        model.addAttribute("orderStatistics",vo);
        model.addAttribute("userName",auth.getDaifaUserName ());
        model.addAttribute("menu","financialStatistic.htm");//前台所要的左边菜单
        return  "daifa/financialStatistic";
    }

    @RequestMapping("daifa/takeGoodsStatistic")
    public String takeGoodsStatistic(Model model){
        Session session = SecurityUtils.getSubject().getSession();
        AuthorityUser auth = (AuthorityUser) session.getAttribute(DaifaSessionConfig.DAIFA_SESSION);
        Date startDate=DateUtil.getStartMouth();
        String day= DateUtil.dateToString(startDate,DateUtil.patternB);
        List<WorkerTakeNumVO> vos= daifaFinanceService.takeGoodsStatistic(day,auth.getDaifaSellerId());
        String timeArea=DateUtil.dateToString(startDate,DateUtil.patternA)+"至"+DateUtil.dateToString(new Date(),DateUtil.patternA);
        model.addAttribute("takeGoodsStatisticList",vos);
        model.addAttribute("timeArea",timeArea);
        model.addAttribute("userName",auth.getDaifaUserName ());
        return  "daifa/takeGoodsStatistic";
    }
}
