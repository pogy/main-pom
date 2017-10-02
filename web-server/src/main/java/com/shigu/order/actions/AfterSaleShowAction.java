package com.shigu.order.actions;

import com.shigu.main4.common.exceptions.JsonErrException;
import com.shigu.main4.common.exceptions.Main4Exception;
import com.shigu.main4.daifa.exceptions.DaifaException;
import com.shigu.main4.order.exceptions.OrderException;
import com.shigu.order.bo.AfterSaleBo;
import com.shigu.order.services.AfterSaleShowService;
import com.shigu.order.services.OrderOptionSafeService;
import com.shigu.session.main4.PersonalSession;
import com.shigu.session.main4.names.SessionEnum;
import com.shigu.tools.JsonResponseUtil;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * Created by pc on 2017-07-25.
 *
 * @author pc
 * @version 3.0.0-SNAPSHOT
 * @description
 * @since 3.0.0-SNAPSHOT
 */
@Controller
@RequestMapping("order/")
public class AfterSaleShowAction {

    @Autowired
    private AfterSaleShowService afterSaleShowService;

    @Autowired
    private OrderOptionSafeService orderOptionSafeService;


    /**
     * 退换货页面
     *
     * @param childOrderId 子弹id
     * @return ftl
     */
    @RequestMapping(value = "returnOrChange", method = RequestMethod.GET)
    public String returnOrChange(@RequestParam(value = "childOrderId") String childOrderId, Model model) {
        Map<String, Object> map = afterSaleShowService.returnOrChange(childOrderId);

        model.addAllAttributes(map);

        return "trade/returnOrChange";
    }

    /**
     * 退货流程页
     * @param childOrderId 子单id
     * @param refundId  售后id
     * @param model model
     * @return 返回页面
     */
    @RequestMapping(value = "refund", method = RequestMethod.GET)
    public String refund(@RequestParam(value = "childOrderId",required = false)String childOrderId
            , @RequestParam(value = "refundId",required = false)String refundId
            ,@RequestParam(value="express",required = false)Integer express, Model model) throws Main4Exception, ParseException {
        List<String> stateList= Arrays.asList("1、买家申请退货退款","2、等待处理退货申请","3、买家退货","4、退货退款完成");
        if (!StringUtils.isEmpty(childOrderId) && StringUtils.isEmpty(refundId)) {
            Map<String, Object> map = afterSaleShowService.refundChildOrder(childOrderId);
            map.put("refundDesc",stateList);
            model.addAllAttributes(map);
            return "trade/refund";
        } else if (!StringUtils.isEmpty(refundId)) {
            Map<String, Object> map = afterSaleShowService.refund(refundId,express);
            map.put("refundDesc",stateList);
            model.addAllAttributes(map);
            return "trade/refund";
        }

        return "trade/refund";
    }

    /**
     * 换货流程页面
     * @param childOrderId  子单id
     * @param refundId  售后id
     * @param model model
     * @return  返回页面
     */
    @RequestMapping(value = "exchange", method = RequestMethod.GET)
    public String exchange(@RequestParam(value = "childOrderId",required = false)Long childOrderId
            , @RequestParam(value = "refundId",required = false)Long refundId
            ,@RequestParam(value="express",required = false)Integer express, Model model) throws Main4Exception, ParseException {
        List<String> stateList= Arrays.asList("1、买家申请换货","2、等待处理换货申请","3、换货完成");
        if (!StringUtils.isEmpty(childOrderId) && StringUtils.isEmpty(refundId)) {
            Map<String, Object> map = afterSaleShowService.exchangeChildOrder(childOrderId);
            map.put("exchangeDesc",stateList);
            model.addAllAttributes(map);
            return "trade/exchange";

        } else if (!StringUtils.isEmpty(refundId)) {
            Map<String, Object> map = afterSaleShowService.exchange(refundId,express);
            map.put("exchangeDesc",stateList);
            model.addAllAttributes(map);
            return "trade/exchange";
        }
        return "trade/exchange";
    }

    /**
     * 提交快递
     *
     * @param refundId    退款id
     * @param expressName   快递id
     * @param expressCode 快递单号
     * @return json
     */
    @RequestMapping(value = "chooseExpress", method = RequestMethod.POST)
    @ResponseBody
    public JSONObject chooseExpress(String refundId, String expressName, String expressCode, HttpSession session) {

        if (StringUtils.isEmpty(refundId)) {
            return JsonResponseUtil.error("售后id不能空");
        }

        PersonalSession ps= (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        if(!orderOptionSafeService.checkByRefundId(ps.getUserId(),Long.valueOf(refundId))){
            return JsonResponseUtil.error("只能操作本用户下的订单");
        }
        if (StringUtils.isEmpty(expressName)) {
            return JsonResponseUtil.error("快递不能空");
        }
        if (StringUtils.isEmpty(expressCode)) {
            return JsonResponseUtil.error("快递单号不能空");
        }

        afterSaleShowService.chooseExpress(refundId, expressName, expressCode);
        return JsonResponseUtil.success();

    }

    /**
     * 修改快递
     * @param refundId  售后id
     * @param expressName 快递id
     * @param expressCode 快递单号
     * @return  json
     */
    @RequestMapping(value = "modifyExpress", method = RequestMethod.POST)
    @ResponseBody
    public JSONObject modifyExpress(String refundId, String expressName, String expressCode,HttpSession session) {
        if (StringUtils.isEmpty(refundId)) {
            return JsonResponseUtil.error("售后id不能空");
        }

        PersonalSession ps= (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        if(!orderOptionSafeService.checkByRefundId(ps.getUserId(),Long.valueOf(refundId))){
            return JsonResponseUtil.error("只能操作本用户下的订单");
        }
        if (StringUtils.isEmpty(expressName)) {
            return JsonResponseUtil.error("快递不能空");
        }
        if (StringUtils.isEmpty(expressCode)) {
            return JsonResponseUtil.error("快递单号不能空");
        }
        afterSaleShowService.modifyExpress(refundId,expressName,expressCode);

        return JsonResponseUtil.success();
    }


    /**
     * 请求订单退货
     *
     * @param bo 参数
     * @return json
     */
    @RequestMapping(value = "refundApply", method = RequestMethod.POST)
    @ResponseBody
    public JSONObject applyReturnOrder(AfterSaleBo bo,HttpSession session) throws JsonErrException, OrderException {


        if (StringUtils.isEmpty(bo.getChildOrderId())) {
            return JsonResponseUtil.error("订单id不能空");
        }
        PersonalSession ps= (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        if(!orderOptionSafeService.checkBySoid(ps.getUserId(),Long.valueOf(bo.getChildOrderId()))){
            return JsonResponseUtil.error("只能操作本用户下的订单");
        }
        if (StringUtils.isEmpty(bo.getRefundCount()) || bo.getRefundCount() == 0) {
            return JsonResponseUtil.error("退货数量不能空");
        }

        return JsonResponseUtil.success().element("refundId", afterSaleShowService.applyReturnOrder(bo).toString());
    }

    /**
     * 请求订单换货
     * @param bo 参数
     * @return json
     * @throws JsonErrException 异常
     */
    @RequestMapping(value="exchangeApply",method = RequestMethod.POST)
    @ResponseBody
    public JSONObject exchangeApply(AfterSaleBo bo,HttpSession session) throws JsonErrException, OrderException {
        if (StringUtils.isEmpty(bo.getChildOrderId())) {
            return JsonResponseUtil.error("订单id不能空");
        }
        PersonalSession ps= (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        if(!orderOptionSafeService.checkBySoid(ps.getUserId(),Long.valueOf(bo.getChildOrderId()))){
            return JsonResponseUtil.error("只能操作本用户下的订单");
        }
        return JsonResponseUtil.success().element("refundId",afterSaleShowService.exchangeApply(bo));
    }

    /**
     * 同意退款金额
     * @param refundId 售后id
     * @param agreeState 是否同意 1同意 2不同意
     * @return json
     */
    @RequestMapping(value = "agreeRefundMoney",method = RequestMethod.POST)
    @ResponseBody
    public JSONObject agreeRefundMoney(String refundId,Integer agreeState,HttpSession session) throws Main4Exception {
        if(StringUtils.isEmpty(refundId)){
            return JsonResponseUtil.error("售后id不能空");
        }
        PersonalSession ps= (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        if(!orderOptionSafeService.checkByRefundId(ps.getUserId(),Long.valueOf(refundId))){
            return JsonResponseUtil.error("只能操作本用户下的订单");
        }
        if(StringUtils.isEmpty(agreeState)){
            return JsonResponseUtil.error("缺少参数同意");
        }
        afterSaleShowService.agreeRefunMoney(Long.parseLong(refundId),agreeState);
        return JsonResponseUtil.success();
    }

    @RequestMapping("finishExchange")
    @ResponseBody
    public JSONObject finishExchange(Long refundId,HttpSession session) throws OrderException, DaifaException {
        PersonalSession ps = (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        afterSaleShowService.finishExchange(refundId,ps.getUserId());
        return JsonResponseUtil.success();
    }

}
