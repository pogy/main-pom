package com.shigu.daifa.actions;

import com.shigu.component.shiro.AuthorityUser;
import com.shigu.config.DaifaSessionConfig;
import com.shigu.daifa.bo.SaleAfterBO;
import com.shigu.daifa.services.DaifaSaleAfterService;
import com.shigu.daifa.vo.DaifaSaleAfter;
import com.shigu.daifa.vo.RefuseReasonVO;
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

import java.util.List;

@Controller
public class DaifaSaleAfterAction {
    @Autowired
    DaifaSaleAfterService daifaSaleAfterService;
    @RequestMapping("daifa/afterSaleOrder")
    public String afterSaleOrder(SaleAfterBO bo, Model model){
        if(bo.getPage()==null){
            bo.setPage(1);
        }
        Session session = SecurityUtils.getSubject().getSession();
        AuthorityUser auth = (AuthorityUser) session.getAttribute(DaifaSessionConfig.DAIFA_SESSION);
        ShiguPager<DaifaSaleAfter> pager=daifaSaleAfterService.afterSaleOrder(bo,auth.getDaifaSellerId());
        model.addAttribute("query",bo);
        model.addAttribute("orders",pager.getContent());
        model.addAttribute("pageOption",pager.selPageOption(10));
        return "daifa/afterSaleOrder";
    }

    @RequestMapping("daifa/addAfterServerRemarkJson")
    @ResponseBody
    public JSONObject addAfterServerRemarkJson(Long orderId,String remarkCon) throws DaifaException {
        daifaSaleAfterService.addAfterServerRemarkJson(orderId,remarkCon);
        return JsonResponseUtil.success();
    }

    @RequestMapping("daifa/getRefuseReason")
    @ResponseBody
    public JSONObject getRefuseReason(){
        List<RefuseReasonVO> list= daifaSaleAfterService.getRefuseReason();
        JSONObject obj=JsonResponseUtil.success();
        obj.put("refuseReason",list);
        return obj;
    }
    @RequestMapping("daifa/refuseAfterSale")
    @ResponseBody
    public JSONObject refuseAfterSale(Long refundId,Long type) throws DaifaException {
        daifaSaleAfterService.refuseAfterSale(refundId,type);
        return JsonResponseUtil.success();
    }

    @RequestMapping("daifa/agreeAfterSale")
    @ResponseBody
    public JSONObject agreeAfterSale(Long refundId) throws DaifaException {
        daifaSaleAfterService.agreeAfterSale(refundId);
        return JsonResponseUtil.success();
    }

    @RequestMapping("daifa/editRefund")
    @ResponseBody
    public JSONObject editRefund(Long refundId,String refundMoney) throws DaifaException {
        daifaSaleAfterService.editRefund(refundId,refundMoney);
        return JsonResponseUtil.success();
    }


}
