package com.shigu.daifa.actions;

import com.opentae.data.daifa.beans.DaifaOrder;
import com.shigu.daifa.services.DaifaSaleAfterService;
import com.shigu.daifa.vo.DaifaAfterReceiveExpresStockVO;
import com.shigu.daifa.bo.ParcelSearchBO;
import com.shigu.daifa.bo.PutInStorageBO;
import com.shigu.component.shiro.AuthorityUser;
import com.shigu.config.DaifaSessionConfig;
import com.shigu.daifa.bo.SaleAfterBO;
import com.shigu.daifa.services.DaifaSaleAfterService;
import com.shigu.daifa.vo.AfterSumVO;
import com.shigu.daifa.vo.DaifaSaleAfterVO;
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
import org.springframework.web.bind.annotation.RequestMethod;
import javax.servlet.http.HttpServletRequest;

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
        ShiguPager<DaifaSaleAfterVO> pager=daifaSaleAfterService.afterSaleOrder(bo,auth.getDaifaSellerId(),10);
        AfterSumVO sum=daifaSaleAfterService.sum(auth.getDaifaSellerId());
        model.addAttribute("query",bo);
        model.addAttribute("orders",pager.getContent());
        model.addAttribute("orderStatistics",sum);
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

    @RequestMapping("daifa/parcelSweepCode")
    public String parcelSweepCode(HttpServletRequest request,Model model) throws DaifaException {
        Session session = SecurityUtils.getSubject().getSession();
        AuthorityUser auth = (AuthorityUser) session.getAttribute(DaifaSessionConfig.DAIFA_SESSION);
        model.addAttribute("userIcon","");
        model.addAttribute("userName",auth.getDaifaUserName());
        return "daifa/parcelSweepCode";
    }

    @RequestMapping("daifa/returnOrder")
    public String returnOrder(HttpServletRequest request,Model model) throws DaifaException {
        List<DaifaOrder> daifaOrders = daifaSaleAfterService.returnOrder();
        //TODO
        return "daifa/parcelSweepCode";
    }

    /**
     * 包裹入库
     * @param bo
     * @return
     * @throws DaifaException
     */
    @RequestMapping("daifa/putInStorage")
    @ResponseBody
    public JSONObject putInStorage(PutInStorageBO bo) throws DaifaException {
        daifaSaleAfterService.putInStorage(bo);
        return JsonResponseUtil.success();
    }

    /**
     * 子单入库
     * @param stockCode 库存编号
     * @param childOrderId 子单id
     * @return
     * @throws DaifaException
     */
    @RequestMapping("daifa/childOrderInStorage")
    @ResponseBody
    public JSONObject childOrderInStorage(String stockCode,Long childOrderId) throws DaifaException {
        daifaSaleAfterService.childOrderInStorage(stockCode,childOrderId);
        return JsonResponseUtil.success();
    }

    /**
     * 包裹查询
     * @param
     */
    @RequestMapping("daifa/parcelSearch")
    public String parcelSearch(ParcelSearchBO bo,Model model) throws DaifaException {
        if(bo.getPage()==null){
            bo.setPage(1);
        }
        Session session = SecurityUtils.getSubject().getSession();
        AuthorityUser auth = (AuthorityUser) session.getAttribute(DaifaSessionConfig.DAIFA_SESSION);
        model.addAttribute("userIcon","");
        model.addAttribute("userName",auth.getDaifaUserName());
        model.addAttribute("query",bo);
        model.addAttribute("orderStatistics",daifaSaleAfterService.getOrderStatistics(bo));

        ShiguPager<DaifaAfterReceiveExpresStockVO> pager= daifaSaleAfterService.getDaifaAfterReceiveExpresStock(bo,auth.getDaifaSellerId());
        model.addAttribute("postList",pager.getContent());
        model.addAttribute("pageOption",pager.selPageOption(10));
        return "daifa/parcelSearch";
    }

    /**
     *添加包裹备注接口
     * @param packbagId   包裹id
     * @param remarkCon 添加的备注内容
     * @return
     * @throws DaifaException
     */
    @RequestMapping("daifa/addPackageRemark")
    @ResponseBody
    public JSONObject addPackageRemark(Long packbagId,String remarkCon) throws DaifaException {
        daifaSaleAfterService.addPackageRemark(packbagId,remarkCon);
        return JsonResponseUtil.success();
    }






}
