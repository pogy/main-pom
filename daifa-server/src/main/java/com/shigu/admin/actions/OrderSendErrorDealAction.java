package com.shigu.admin.actions;

import com.opentae.data.daifa.beans.DaifaTrade;
import com.shigu.admin.bo.OrderSendErrorDealBO;
import com.shigu.admin.services.OrderSendErrorDealService;
import com.shigu.component.shiro.AuthorityUser;
import com.shigu.config.DaifaSessionConfig;
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

import java.util.ArrayList;
import java.util.List;

/**
 * @类编号
 * @类名称：OrderSendErrorDealAction
 * @文件路径：com.shigu.admin.actions.OrderSendErrorDealAction
 * @内容摘要：订单快递鸟发货时显示错误
 * @编码作者：gzy
 * @创建日期：2017/9/12 11:08
 * @version: main-pom
 * @since: main-pom
 * @commonents:
 */
@Controller
public class OrderSendErrorDealAction {

    @Autowired
    OrderSendErrorDealService orderSendErrorDealService;
    /**
     * ====================================================================================
     * @方法名： orderSendErrorDealindex
     * @user gzy 2017/9/12 17:47
     * @功能：
     * @param: [bo, model]
     * @return: java.lang.String
     * @exception:
     * ====================================================================================
     *
     */
    @RequestMapping("admin/orderSendErrorindex")
    public String orderSendErrorDealindex(OrderSendErrorDealBO bo, Model model){

        List<DaifaTrade> list=null;
    if(bo.getDfTradeId ()==null&&bo.getPhone ()==null){
        bo.setFlo (1);
        list = orderSendErrorDealService.sendErrorDeal (bo);
    }else {
         list = orderSendErrorDealService.sendErrorDeal (bo);
         bo.setCount (list.size ());
    }
    if(bo.getCount ()==null){
        bo.setCount (1);
    }
    if(bo.getPage ()==null){
        bo.setPage (1+"");
    }
        String pageOption = bo.getCount() + "," + "10" + "," + bo.getPage();
        model.addAttribute("orders", list);
        model.addAttribute("query", bo);

        model.addAttribute("pageOption", pageOption);

        return "admin/orderSendErrorDeal";
    }
    /**
     * ====================================================================================
     * @方法名： dealOrderSendError
     * @user gzy 2017/9/12 17:47
     * @功能：
     * @param: [dfTradeId, receiverName, receiverAddr]
     * @return: net.sf.json.JSONObject
     * @exception:
     * ====================================================================================
     *
     */
    @RequestMapping("admin/dealOrderSendErrorJson")
    @ResponseBody
    public JSONObject dealOrderSendError(Long dfTradeId,String receiverName,String receiverAddr) throws DaifaException {

        if (dfTradeId == null||receiverName == null||receiverAddr == null) {
            throw new DaifaException("缺少参数");
        }
        orderSendErrorDealService.dealOrderSendError (dfTradeId,receiverName,receiverAddr);
        return JsonResponseUtil.success();
    }
}
