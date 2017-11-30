package com.shigu.order.actions;

import com.shigu.component.common.globality.constant.SystemConStant;
import com.shigu.component.common.globality.response.ResponseBase;
import com.shigu.main4.common.exceptions.JsonErrException;
import com.shigu.main4.common.exceptions.Main4Exception;
import com.shigu.main4.common.tools.ShiguPager;
import com.shigu.main4.common.util.DateUtil;
import com.shigu.main4.daifa.exceptions.OrderNotFindException;
import com.shigu.main4.order.services.AfterSaleService;
import com.shigu.order.bo.OrderBO;
import com.shigu.main4.order.servicevo.ExpressInfoVO;
import com.shigu.order.services.MyOrderService;
import com.shigu.order.vo.MyOrderDetailVO;
import com.shigu.order.vo.MyOrderVO;
import com.shigu.session.main4.PersonalSession;
import com.shigu.session.main4.names.SessionEnum;
import com.shigu.tools.DateParseUtil;
import com.shigu.tools.JsonResponseUtil;
import net.sf.json.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @类编号
 * @类名称：MyOrderAction
 * @文件路径：com.shigu.order.actions.MyOrderAction
 * @内容摘要：订单列表
 * @编码作者：gzy
 * @创建日期：2017/7/20 10:42
 * @version: main-pom
 * @since: main-pom
 * @commonents:
 */
@Controller
@RequestMapping("order/")
public class MyOrderAction {
    @Autowired
    MyOrderService myOrderService;
    @Autowired
    AfterSaleService afterSaleService;


    /**
     * ====================================================================================
     *
     * @方法名： myOrder
     * @user gzy 2017/7/20 13:00
     * @功能：
     * @param: [session, model, bo]
     * @return: java.lang.String
     * @exception: ====================================================================================
     */
    @RequestMapping("myOrder")
    public String myOrder(HttpSession session, Model model, OrderBO bo) throws Main4Exception {

        PersonalSession ps = (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        if (bo.getPageSize() == null) {
            bo.setPageSize(10);
        }
        if (bo.getPage() == null) {
            bo.setPage(1);
        }
        String dateFormat = "yyyy-MM-dd";
        if (bo.getSt() != null) {
            Date st = DateParseUtil.parseFromString(dateFormat, bo.getSt());
            if (st == null) {
                throw new Main4Exception("查询开始日期错误");
            }
        }
        if (bo.getEt() != null) {
            Date et = DateParseUtil.parseFromString(dateFormat, bo.getEt());
            if (et == null) {
                throw new Main4Exception("查询结束日期错误");
            }
        }
        ShiguPager<MyOrderVO> pager = myOrderService.selectMyOrderPager(bo, ps.getUserId());
        model.addAttribute("query", bo);//返回查询条件
        model.addAttribute("orders", pager.getContent());
        model.addAttribute("pageOption", pager.selPageOption(bo.getPageSize()));
        return "fxs/myOrder";

    }

    @RequestMapping("wipeOffNewTip")
    @ResponseBody
    public JSONObject wipeOffNewTip(Long refundId){
        afterSaleService.wipeOffNewTip(refundId);
        return JsonResponseUtil.success();
    }

    /**
     * 验证订单是否可退
     */
    @RequestMapping("isCanApplyRefund")
    @ResponseBody
    public JSONObject isCanApplyRefund(Long childOrderId){
        try {
            return JsonResponseUtil.success().element("refundState", myOrderService.testRefund(childOrderId) ? 1 : 2);
        } catch (OrderNotFindException e) {
            return JsonResponseUtil.success().element("refundState",3);
        }
    }

    /**
     * ====================================================================================
     *
     * @方法名： removeOrder
     * @user gzy 2017/7/20 14:48
     * @功能：删除订单
     * @param: [orderId]
     * @return: net.sf.json.JSONObject
     * @exception: ====================================================================================
     */
    @RequestMapping("removeOrder")
    @ResponseBody
    public JSONObject removeOrder(HttpSession session, Long orderId) throws JsonErrException {
        PersonalSession ps = (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        ResponseBase rsp = new ResponseBase();
        if (orderId == null) {
            rsp.setResult(SystemConStant.RESPONSE_STATUS_ERROR);
            rsp.setMsg("订单ID为空！");
            return JSONObject.fromObject(rsp);
        }
        boolean flag = myOrderService.orderBelongTo(orderId, ps.getUserId());
        if (!flag) {
            rsp.setResult(SystemConStant.RESPONSE_STATUS_ERROR);
            rsp.setMsg("非法访问！");
            return JSONObject.fromObject(rsp);
        }
        int i = myOrderService.removeOrder(orderId);
        if (i > 0) {
            rsp.setResult(SystemConStant.RESPONSE_STATUS_SUCCESS);
        } else {
            rsp.setResult(SystemConStant.RESPONSE_STATUS_FAILED);
            rsp.setMsg("删除订单失败！");
        }
        return JSONObject.fromObject(rsp);
    }

    /**
     * ====================================================================================
     *
     * @方法名： cancelOrder
     * @user gzy 2017/7/20 14:48
     * @功能：取消订单
     * @param: [orderId]
     * @return: net.sf.json.JSONObject
     * @exception: ====================================================================================
     */
    @RequestMapping("cancelOrder")
    @ResponseBody
    public JSONObject cancelOrder(HttpSession session, Long orderId) throws JsonErrException {
        PersonalSession ps = (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        ResponseBase rsp = new ResponseBase();
        if (orderId == null) {
            rsp.setResult(SystemConStant.RESPONSE_STATUS_ERROR);
            rsp.setMsg("订单ID为空！");
            return JSONObject.fromObject(rsp);
        }
        boolean flag = myOrderService.orderBelongTo(orderId, ps.getUserId());
        if (!flag) {
            rsp.setResult(SystemConStant.RESPONSE_STATUS_ERROR);
            rsp.setMsg("非法访问！");
            return JSONObject.fromObject(rsp);
        }
        int i = myOrderService.cancelOrder(orderId);
        if (i > 0) {
            rsp.setResult(SystemConStant.RESPONSE_STATUS_SUCCESS);
        } else {
            rsp.setResult(SystemConStant.RESPONSE_STATUS_FAILED);
            rsp.setMsg("取消订单失败！");
        }
        return JSONObject.fromObject(rsp);
    }

    @RequestMapping("orderDetail")
    public String orderDetail(HttpSession session, Long orderId, Model model) throws Main4Exception, ParseException {
        if (orderId == null) {
            //订单出错
            model.addAttribute("msg", "订单号不能为空！");
            return "trade/noOrderInfo";
        }
        PersonalSession ps = (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        boolean flag = myOrderService.orderBelongTo(orderId, ps.getUserId());
        if (!flag) {
            //没有这个订单
            model.addAttribute("msg", "非法访问！");
            return "trade/noOrderInfo";
        } else {

            MyOrderDetailVO detailVo = myOrderService.orderDetail(orderId,ps.getUserId());
            model.addAttribute("orderDetailVO", detailVo);
            model.addAttribute("orderStateText", detailVo.getOrderStateText());
            model.addAttribute("orderCreateTime", detailVo.getOrderCreateTime());
            model.addAttribute("orderId", orderId);
            model.addAttribute("orderDealTime", detailVo.getOrderDealTime());
            model.addAttribute("orderAddrInfo", detailVo.getOrderAddrInfo());
            model.addAttribute("express", detailVo.getExpress());
            model.addAttribute("childOrders", detailVo.getChildOrders());
            model.addAttribute("total", detailVo.getTotal());
            model.addAttribute("orderStateNum", detailVo.getOrderStateNum());
            model.addAttribute("orderStateTime", detailVo.getOrderStateTime());
        }

        return "trade/orderDetail";
    }


    @RequestMapping("expressDetail")
    public String expressDetail(HttpSession session, Long orderId, Model model) throws Main4Exception, ParseException {
        if (orderId == null) {
            model.addAttribute("msg","订单不能为空");
            return "trade/noOrderInfo";
        }
        ExpressInfoVO expressInfoVO = myOrderService.expressInfo(orderId);
        model.addAttribute("expressStateDesc", Stream.of("1待揽件","2运输", "3派送", "4签收"));
        model.addAttribute("expressCurrentState",expressInfoVO.getExpressCurrentState()+1);
        model.addAttribute("expressAddrInfo",myOrderService.expressAddrInfo(orderId));
        model.addAttribute("expressDetail",myOrderService.expressDetail(orderId).getDetail());
        model.addAttribute("expressName",expressInfoVO.getExpressName());
        model.addAttribute("expressCode",expressInfoVO.getExpressId());
        return "trade/expressDetail";
    }


    @RequestMapping("markingTbShipments")
    @ResponseBody
    public JSONObject tbSend(HttpSession session,Long orderId) throws Main4Exception {
        PersonalSession ps = (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        myOrderService.tbSend(ps.getUserId(),orderId);
        return JsonResponseUtil.success();
    }

    @RequestMapping("upBatchPostDataToServer")
    @ResponseBody
    public JSONObject moreTbSend(HttpSession session,String leftOrderIds) throws Main4Exception {
        PersonalSession ps = (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        myOrderService.moreTbSend(ps.getUserId(), Arrays.stream(leftOrderIds.split(",")).filter(StringUtils::isNotEmpty).map(Long::parseLong).collect(Collectors.toList()));
        return JsonResponseUtil.success();
    }

}