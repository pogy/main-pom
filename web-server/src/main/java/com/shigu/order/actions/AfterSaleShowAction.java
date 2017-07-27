package com.shigu.order.actions;

import com.shigu.main4.common.exceptions.JsonErrException;
import com.shigu.main4.order.services.AfterSaleService;
import com.shigu.order.bo.AfterSaleBo;
import com.shigu.order.services.AfterSaleShowService;
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
            ,@RequestParam(value="express",required = false)Integer express, Model model) {

        if (!StringUtils.isEmpty(childOrderId) && StringUtils.isEmpty(refundId)) {
            Map<String, Object> map = afterSaleShowService.refundChildOrder(childOrderId);
            model.addAllAttributes(map);
            return "trade/refund";
        } else if (!StringUtils.isEmpty(refundId)) {
            Map<String, Object> map = afterSaleShowService.refund(refundId,express);
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
    public String exchange(@RequestParam(value = "childOrderId",required = false)String childOrderId
            , @RequestParam(value = "refundId",required = false)String refundId
            ,@RequestParam(value="express",required = false)Integer express, Model model) {
        if (!StringUtils.isEmpty(childOrderId) && StringUtils.isEmpty(refundId)) {
            Map<String, Object> map = afterSaleShowService.exchangeChildOrder(Long.parseLong(childOrderId));
            model.addAllAttributes(map);
            return "trade/exchange";

        } else if (!StringUtils.isEmpty(refundId)) {
            Map<String, Object> map = afterSaleShowService.exchange(Long.parseLong(refundId),express);
            model.addAllAttributes(map);
            return "trade/exchange";
        }
        return "trade/exchange";
    }

    /**
     * 提交快递
     *
     * @param refundId    退款id
     * @param expressId   快递id
     * @param expressCode 快递单号
     * @return json
     */
    @RequestMapping(value = "chooseExpress", method = RequestMethod.POST)
    @ResponseBody
    public JSONObject chooseExpress(String refundId, String expressId, String expressCode) {
        if (StringUtils.isEmpty(refundId)) {
            return JsonResponseUtil.error("售后id不能空");
        }
        if (StringUtils.isEmpty(expressId)) {
            return JsonResponseUtil.error("快递不能空");
        }
        if (StringUtils.isEmpty(expressCode)) {
            return JsonResponseUtil.error("快递单号不能空");
        }

        afterSaleShowService.chooseExpress(refundId, expressId, expressCode);
        return JsonResponseUtil.success();

    }

    /**
     * 修改快递
     * @param refundId  售后id
     * @param expressId 快递id
     * @param expressCode 快递单号
     * @return  json
     */
    @RequestMapping(value = "modifyExpress", method = RequestMethod.POST)
    @ResponseBody
    public JSONObject modifyExpress(String refundId, String expressId, String expressCode) {
        if (StringUtils.isEmpty(refundId)) {
            return JsonResponseUtil.error("售后id不能空");
        }
        if (StringUtils.isEmpty(expressId)) {
            return JsonResponseUtil.error("快递不能空");
        }
        if (StringUtils.isEmpty(expressCode)) {
            return JsonResponseUtil.error("快递单号不能空");
        }
        afterSaleShowService.modifyExpress(refundId,expressId,expressCode);

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
    public JSONObject applyReturnOrder(AfterSaleBo bo) throws JsonErrException {


        if (StringUtils.isEmpty(bo.getChildOrderId())) {
            return JsonResponseUtil.error("订单id不能空");
        }
        if (StringUtils.isEmpty(bo.getRefundCount()) || bo.getRefundCount() == 0) {
            return JsonResponseUtil.error("退货数量不能空");
        }

        return JsonResponseUtil.success().element("refundId", afterSaleShowService.applyReturnOrder(bo));
    }

    /**
     * 请求订单换货
     * @param bo 参数
     * @return json
     * @throws JsonErrException 异常
     */
    @RequestMapping(value="exchangeApply",method = RequestMethod.POST)
    @ResponseBody
    public JSONObject exchangeApply(AfterSaleBo bo) throws JsonErrException{
        if (StringUtils.isEmpty(bo.getChildOrderId())) {
            return JsonResponseUtil.error("订单id不能空");
        }
        return JsonResponseUtil.success().element("refundId ",afterSaleShowService.exchangeApply(bo));
    }

    public JSONObject agreeRefundMoney(String refundId,Integer agreeState){
        if(StringUtils.isEmpty(refundId)){
            return JsonResponseUtil.error("售后id不能空");
        }
        if(StringUtils.isEmpty(agreeState)){
            return JsonResponseUtil.error("缺少参数同意");
        }
        afterSaleShowService.agreeRefunMoney(Long.parseLong(refundId),agreeState);
        return JsonResponseUtil.success();
    }

}
