package com.shigu.admin.actions;

import com.opentae.data.daifa.beans.DaifaOrder;
import com.opentae.data.daifa.beans.DaifaTrade;
import com.shigu.admin.bo.OrderSendErrorDealBO;
import com.shigu.admin.services.OrderSendErrorDealService;
import com.shigu.component.shiro.AuthorityUser;
import com.shigu.config.DaifaSessionConfig;
import com.shigu.main4.daifa.exceptions.DaifaException;
import com.shigu.main4.daifa.vo.ExpressVO;
import com.shigu.main4.daifa.vo.PackResultVO;
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
        Session session = SecurityUtils.getSubject().getSession();
        String auth = (String) session.getAttribute(DaifaSessionConfig.DAIFA_SYS_SESSION);
        List<DaifaTrade> list=null;
        if(bo.getCount ()==null){
            bo.setCount (1);
        }
        if(bo.getPage ()==null){
            bo.setPage (1+"");
        }
    if(bo.getDfTradeId ()==null&&bo.getPhone ()==null){
        bo.setFlo (1);
        list = orderSendErrorDealService.sendErrorDeal (bo);
    }else {
         list = orderSendErrorDealService.sendErrorDeal (bo);
         bo.setCount (list.size ());
    }

        String pageOption = bo.getCount() + "," + "10" + "," + bo.getPage();
        model.addAttribute("orders", list);
        model.addAttribute("query", bo);

        model.addAttribute("pageOption", pageOption);
        model.addAttribute("userName", auth);
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
            throw new DaifaException("缺少参数",DaifaException.DEBUG);
        }
        orderSendErrorDealService.dealOrderSendError (dfTradeId,receiverName,receiverAddr);
        return JsonResponseUtil.success();
    }
    //===============================子单商品属性里有+=============================================
    /**
     * ====================================================================================
     * @方法名： orderSendErrorSubindex
     * @user gzy 2017/9/22 18:08
     * @功能：子单列表
     * @param: [bo, model]
     * @return: java.lang.String
     * @exception:
     * ====================================================================================
     *
     */
    @RequestMapping("admin/orderSendErrorSubindex")
    public String orderSendErrorSubindex(OrderSendErrorDealBO bo, Model model){
        Session session = SecurityUtils.getSubject().getSession();
        String auth = (String) session.getAttribute(DaifaSessionConfig.DAIFA_SYS_SESSION);
        if(bo.getCount ()==null){
            bo.setCount (1);
        }
        if(bo.getPage ()==null){
            bo.setPage (1+"");
        }
        List<DaifaOrder> list= orderSendErrorDealService.queryErrorSubOrder(bo);
        String pageOption = bo.getCount() + "," + "10" + "," + bo.getPage();
        model.addAttribute("orders", list);
        model.addAttribute("query", bo);

        model.addAttribute("pageOption", pageOption);
        model.addAttribute("userName", auth);
        return "admin/orderSendErrorSubindex";
    }
    /**
     * ====================================================================================
     * @方法名： dealSubOrderErrorJson
     * @user gzy 2017/9/22 18:20
     * @功能：子单的更新
     * @param: [dfOrderId, propStr]
     * @return: net.sf.json.JSONObject
     * @exception:
     * ====================================================================================
     *
     */
    @RequestMapping("admin/dealSubOrderErrorJson")
    @ResponseBody
    public JSONObject dealSubOrderErrorJson(Long dfOrderId,String propStr,String goodsCode,String storeGoodsCode) throws DaifaException {

        if (dfOrderId == null||propStr == null) {
            throw new DaifaException("缺少参数",DaifaException.DEBUG);
        }
        orderSendErrorDealService.dealSubOrderError (dfOrderId,propStr,goodsCode,storeGoodsCode);
        return JsonResponseUtil.success();
    }

    /**
     * ====================================================================================
     * @方法名： sendTestinit
     * @user gzy 2017/10/27 15:46
     * @功能：发货测试的初始货页面
     * @param: [bo, model]
     * @return: java.lang.String
     * @exception:
     * ====================================================================================
     *
     */
    @RequestMapping("admin/sendTest")
    public String sendTestinit(OrderSendErrorDealBO bo, Model model){

        Session session = SecurityUtils.getSubject().getSession();
        String auth = (String) session.getAttribute(DaifaSessionConfig.DAIFA_SYS_SESSION);

        model.addAttribute("userName", auth);
        return "admin/sendTest";
    }
    /**
     * ====================================================================================
     * @方法名： dealSendTestJson
     * @user gzy 2017/10/27 16:11
     * @功能：处理再次发货
     * @param: [bo, model]
     * @return: net.sf.json.JSONObject
     * @exception:
     * ====================================================================================
     *
     */
    @RequestMapping("admin/dealSendTestJson")
    @ResponseBody
    public JSONObject dealSendTestJson(OrderSendErrorDealBO bo, Model model) throws DaifaException {
        ExpressVO vo1=new ExpressVO ();
        if (bo.getDfTradeId () == null||bo.getSendType () == null) {
            throw new DaifaException("缺少参数",DaifaException.DEBUG);
        }
        if(bo.getSendType ()==1){
            //特别处理
            vo1= orderSendErrorDealService.dealSendTest(new Long(bo.getDfTradeId ()));

        }else{
            if(bo.getSendType ()==0){
                //普通调用

                PackResultVO vo=  orderSendErrorDealService.dealSendordinary(new Long(bo.getDfTradeId ()));

                vo1.setExpressCode (vo.getExpressCode ());
                vo1.setTid (new Long(bo.getDfTradeId ()));

            }
        }

        //orderSendErrorDealService.dealSubOrderError (dfOrderId,propStr,goodsCode,storeGoodsCode);
        return JsonResponseUtil.success ("快递单号："+vo1.getExpressCode ()+"@@三段码："+vo1.getMarkDestination ()+"@"+vo1.getPackageName ());
    }
}
