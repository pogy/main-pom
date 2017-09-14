package com.shigu.daifa.actions;

import com.shigu.component.shiro.AuthorityUser;
import com.shigu.config.DaifaSessionConfig;
import com.shigu.daifa.bo.WaitSendBO;
import com.shigu.daifa.services.DaifaWaitSendService;
import com.shigu.daifa.vo.DaifaWaitSendVO;
import com.shigu.main4.common.tools.ShiguPager;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by pc on 2017-09-05.
 *待发action
 * @author pc
 * @version 3.0.0-SNAPSHOT
 * @description
 * @since 3.0.0-SNAPSHOT
 */
@Controller
public class DaifaWaitSendAction {
    private DaifaWaitSendService daifaWaitSendService;
    @Autowired
    public void setDaifaWaitSendService(DaifaWaitSendService daifaWaitSendService) {
        this.daifaWaitSendService = daifaWaitSendService;
    }

    @RequestMapping("daifa/notYetSipped")
    public String daifaWaitSendIndex(WaitSendBO bo , Model model){
        AuthorityUser auth = (AuthorityUser) SecurityUtils.getSubject().getSession().getAttribute(DaifaSessionConfig.DAIFA_SESSION);
        ShiguPager<DaifaWaitSendVO> pager = daifaWaitSendService.selPageData(bo,auth.getDaifaSellerId());

        model.addAttribute("orders",pager.getContent());
        model.addAttribute("pageOption",pager.selPageOption(10));
        model.addAttribute("query",bo);

        return "daifa/notYetSipped";
    }

}
