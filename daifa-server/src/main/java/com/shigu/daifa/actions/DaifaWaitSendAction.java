package com.shigu.daifa.actions;

import com.shigu.component.shiro.AuthorityUser;
import com.shigu.config.DaifaSessionConfig;
import com.shigu.daifa.bo.WaitSendBO;
import com.shigu.daifa.services.DaifaWaitSendService;
import com.shigu.daifa.vo.DaifaWaitSendVO;
import com.shigu.main4.common.tools.ShiguPager;
import com.shigu.main4.daifa.exceptions.DaifaException;
import com.shigu.main4.daifa.process.TakeGoodsIssueProcess;
import com.shigu.tools.JsonResponseUtil;
import net.sf.json.JSONObject;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
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

    @RequestMapping("daifa/notYetSipped")
    public String daifaWaitSendIndex(WaitSendBO bo , Model model){
        AuthorityUser auth = (AuthorityUser) SecurityUtils.getSubject().getSession().getAttribute(DaifaSessionConfig.DAIFA_SESSION);
        ShiguPager<DaifaWaitSendVO> pager = daifaWaitSendService.selPageData(bo,auth.getDaifaSellerId());

        model.addAttribute("orders",pager.getContent());
        model.addAttribute("pageOption",pager.selPageOption(10));
        model.addAttribute("query",bo);

        return "daifa/notYetSipped";
    }

    @RequestMapping("daifa/noPostRefund")
    @ResponseBody
    public JSONObject noPostRefund(Long childOrderId,String refundMoney) throws DaifaException {
        Integer status=takeGoodsIssueProcess.refundHasItemApply(childOrderId,refundMoney);
        Long refundId=null;
        try {
            //todo 调order

        } catch (Exception e) {
            takeGoodsIssueProcess.refundHasItemErrorRollback(childOrderId,status);
            return JsonResponseUtil.error(e.getMessage());
        }
//        takeGoodsIssueProcess.refundHasItem(refundId,);

        return JsonResponseUtil.success();
    }

}
