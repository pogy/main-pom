package com.shigu.daifa.actions;

import com.shigu.component.shiro.AuthorityUser;
import com.shigu.config.DaifaSessionConfig;
import com.shigu.daifa.bo.SaleAfterBO;
import com.shigu.daifa.services.DaifaSaleAfterDisposeService;
import com.shigu.daifa.vo.DaifaSaleAfterDisposeVO;
import com.shigu.main4.common.tools.ShiguPager;
import com.shigu.main4.daifa.exceptions.DaifaException;
import com.shigu.tools.JsonResponseUtil;
import net.sf.json.JSONObject;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DaifaSaleAfterDisposeAction {
    @Autowired
    DaifaSaleAfterDisposeService daifaSaleAfterDisposeService;

    /**
     * ====================================================================================
     * @方法名： afterSaleProcess
     * @user gzy 2017/10/13 13:14
     * @功能：售后处理
     * @param: [bo, model]
     * @return: java.lang.String
     * @exception:
     * ====================================================================================
     *
     */
    @RequestMapping("daifa/afterSaleProcess")
    public String afterSaleProcess(SaleAfterBO bo, Model model){

        if(bo.getPage()==null){
            bo.setPage(1);
        }
        Session session = SecurityUtils.getSubject().getSession();
        AuthorityUser auth = (AuthorityUser) session.getAttribute(DaifaSessionConfig.DAIFA_SESSION);
        ShiguPager<DaifaSaleAfterDisposeVO> pager= daifaSaleAfterDisposeService.afterSaleProcess(bo,auth.getDaifaSellerId());
        model.addAttribute("query",bo);
        model.addAttribute("orders",pager.getContent());
        model.addAttribute("pageOption",pager.selPageOption(10));
        model.addAttribute("userName",auth.getDaifaUserName ());
        model.addAttribute("menu","afterSaleProcess.htm");//前台所要的左边菜单
        return "daifa/afterSaleProcess";
    }
    /**
     * ====================================================================================
     * @方法名： writeRefund
     * @user gzy 2017/10/13 13:14
     * @功能：
     * @param: [refundId, refundMoney]
     * @return: net.sf.json.JSONObject
     * @exception:
     * ====================================================================================
     *
     */
    @RequestMapping("daifa/writeRefund")
    @ResponseBody
    public JSONObject writeRefund(Long refundId,String refundMoney) throws DaifaException {

        daifaSaleAfterDisposeService.writeRefund(refundId,refundMoney);
        return JsonResponseUtil.success();
    }
    /**
     * ====================================================================================
     * @方法名： writeStockCode
     * @user gzy 2017/10/13 13:14
     * @功能：
     * @param: [childOrderId, stockCode, reason]
     * @return: net.sf.json.JSONObject
     * @exception:
     * ====================================================================================
     *
     */
    @RequestMapping("daifa/writeStockCode")
    @ResponseBody
    public JSONObject writeStockCode(Long childOrderId,String stockCode,String reason) throws DaifaException {

        daifaSaleAfterDisposeService.writeStockCode(childOrderId,stockCode,reason);
        return JsonResponseUtil.success();
    }
}
