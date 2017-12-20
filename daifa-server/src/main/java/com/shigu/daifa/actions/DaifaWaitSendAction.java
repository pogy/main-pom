package com.shigu.daifa.actions;

import com.shigu.component.shiro.AuthorityUser;
import com.shigu.config.DaifaSessionConfig;
import com.shigu.daifa.bo.WaitSendBO;
import com.shigu.daifa.services.DaifaWaitSendService;
import com.shigu.daifa.vo.DaifaWaitSendVO;
import com.shigu.main4.common.tools.ShiguPager;
import com.shigu.main4.daifa.exceptions.DaifaException;
import com.shigu.main4.daifa.process.TakeGoodsIssueProcess;
import net.sf.json.JSONObject;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
    @Autowired
    TakeGoodsIssueProcess takeGoodsIssueProcess;

    private DaifaWaitSendService daifaWaitSendService;
    @Autowired
    public void setDaifaWaitSendService(DaifaWaitSendService daifaWaitSendService) {
        this.daifaWaitSendService = daifaWaitSendService;
    }
    /**
     * ====================================================================================
     * @方法名： daifaWaitSendIndex
     * @user gzy 2017/10/13 13:16
     * @功能：未发货订单
     * @param: [bo, model]
     * @return: java.lang.String
     * @exception:
     * ====================================================================================
     *
     */
    @RequestMapping("daifa/notYetSipped")
    public String daifaWaitSendIndex(WaitSendBO bo , Model model){

        AuthorityUser auth = (AuthorityUser) SecurityUtils.getSubject().getSession().getAttribute(DaifaSessionConfig.DAIFA_SESSION);
        ShiguPager<DaifaWaitSendVO> pager = daifaWaitSendService.selPageData(bo,auth.getDaifaSellerId());

        model.addAttribute("orders",pager.getContent());
        model.addAttribute("pageOption",pager.selPageOption(10));
        model.addAttribute("query",bo);
        model.addAttribute("userName",auth.getDaifaUserName ());
        model.addAttribute("menu","notYetSipped.htm");//前台所要的左边菜单
        return "daifa/notYetSipped";
    }
    /**
     * ====================================================================================
     * @方法名： noPostRefund
     * @user gzy 2017/10/13 13:17
     * @功能：
     * @param: [childOrderId, refundMoney]
     * @return: net.sf.json.JSONObject
     * @exception:
     * ====================================================================================
     *
     */
    @RequestMapping("daifa/noPostRefund")
    @ResponseBody
    public JSONObject noPostRefund(Long childOrderId,String refundMoney) throws DaifaException {

        return daifaWaitSendService.noPostRefund(childOrderId,refundMoney);
    }

}
