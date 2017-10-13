package com.shigu.daifa.actions;

import com.shigu.component.shiro.AuthorityUser;
import com.shigu.config.DaifaSessionConfig;
import com.shigu.daifa.bo.SendBO;
import com.shigu.daifa.services.DaifaSendService;
import com.shigu.daifa.vo.DaifaSendVO;
import com.shigu.daifa.vo.SendSumVO;
import com.shigu.main4.common.tools.ShiguPager;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by pc on 2017-09-05.
 *已发action
 * @author pc
 * @version 3.0.0-SNAPSHOT
 * @description
 * @since 3.0.0-SNAPSHOT
 */
@Controller
public class DaifaSendAction {
    private DaifaSendService daifaSendService;

    @Autowired
    public void setDaifaWaitSendService(DaifaSendService daifaSendService) {
        this.daifaSendService = daifaSendService;
    }
    /**
     * ====================================================================================
     * @方法名： daifaSendIndex
     * @user gzy 2017/10/13 13:16
     * @功能：已发货订单
     * @param: [bo, model]
     * @return: java.lang.String
     * @exception:
     * ====================================================================================
     *
     */
    @RequestMapping("daifa/hasBeenShipped")
    public String daifaSendIndex(SendBO bo , Model model){

        AuthorityUser auth = (AuthorityUser) SecurityUtils.getSubject().getSession().getAttribute(DaifaSessionConfig.DAIFA_SESSION);
        ShiguPager<DaifaSendVO> pager = daifaSendService.selPageData(bo,auth.getDaifaSellerId());
        SendSumVO sum=daifaSendService.sum(auth.getDaifaSellerId());
        model.addAttribute("orders",pager.getContent());
        model.addAttribute("orderStatistics",sum);
        model.addAttribute("pageOption",pager.selPageOption(10));
        model.addAttribute("query",bo);
        model.addAttribute("userName",auth.getDaifaUserName ());
        model.addAttribute("menu","hasBeenShipped.htm");//前台所要的左边菜单
        return "daifa/hasBeenShipped";
    }

}
