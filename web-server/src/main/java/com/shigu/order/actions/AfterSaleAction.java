package com.shigu.order.actions;

import com.shigu.main4.common.exceptions.JsonErrException;
import com.shigu.main4.order.services.ItemOrderService;
import com.shigu.order.bo.AfterSaleBo;
import com.shigu.order.services.AfterSaleService;
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
public class AfterSaleAction {
    @Autowired
    private AfterSaleService afterSaleService;


    /**
     * 退换货页面
     * @param childOrderId 子弹id
     * @return ftl
     */
    @RequestMapping(value = "returnOrChange",method = RequestMethod.GET)
    public String returnOrChange(@RequestParam(value = "childOrderId")String childOrderId, Model model){

        Map<String,Object> map = afterSaleService.returnOrChange(childOrderId);

        model.addAllAttributes(map);

        return "trade/returnOrChange";
    }

    @RequestMapping(value = "refund",method = RequestMethod.GET)
    public String refund(String childOrderId,String refundId,Model model){

        if(!StringUtils.isEmpty(childOrderId)){
            Map<String,Object> map = afterSaleService.refundChildOrder(childOrderId);
            model.addAllAttributes(map);
            return "trade/refund";
        }else if(!StringUtils.isEmpty(refundId)){
            Map<String,Object> map = afterSaleService.refund(refundId);
            return "trade/refund";
        }

        return "trade/refund";
    }

    /**
     * 提交快递
     * @param childOrderId 子弹
     * @param expressId 快递id
     * @param expressCode 快递单号
     * @return json
     */
    @RequestMapping(value = "chooseExpress",method = RequestMethod.POST)
    @ResponseBody
    public JSONObject chooseExpress(String childOrderId,String expressId,String expressCode){
        if(StringUtils.isEmpty(childOrderId)){
           return JsonResponseUtil.error("子订单不能空");
        }
        if(StringUtils.isEmpty(expressId)){
            return JsonResponseUtil.error("快递不能空");
        }
        if(StringUtils.isEmpty(expressCode)){
            return JsonResponseUtil.error("快递单号不能空");
        }

        afterSaleService.chooseExpress(childOrderId,expressId,expressCode);
        return JsonResponseUtil.success();

    }



    /**
     * 请求订单退货
     * @param bo 参数
     * @return json
     */
    @RequestMapping(value = "refundApply",method = RequestMethod.POST)
    @ResponseBody
    public JSONObject applyReturnOrder(AfterSaleBo bo) throws JsonErrException{


        if(StringUtils.isEmpty(bo.getChildOrderId())){
           return JsonResponseUtil.error("订单id不能空");
        }
        if(StringUtils.isEmpty(bo.getRefundCount())||bo.getRefundCount()==0){
           return JsonResponseUtil.error("退货数量不能空");
        }

        return JsonResponseUtil.success().element("refundId",afterSaleService.applyReturnOrder(bo));
    }



}
