package com.shigu.order.actions;

import com.opentae.data.mall.beans.ShiguOrderCashback;
import com.shigu.order.services.OrderReturnMoneyService;
import com.shigu.tools.JsonResponseUtil;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

/**
 * @ProjectName: main-pom
 * @Package: com.shigu.order.actions
 * @ClassName: OrderReturnMoneyAction
 * @Author: sy
 * @CreateDate: 2018/5/24 0024 18:26
 */
@Controller
public class OrderReturnMoneyAction {

    @Autowired
    private OrderReturnMoneyService orderReturnMoneyService;

    @RequestMapping("orderCashbackSuccessNotify")
    @ResponseBody
    public JSONObject orderCashbackSuccessNotify(String data){
        JSONObject json = JSONObject.fromObject(data);
        Long oid = Long.valueOf(json.get("orderId").toString());
        ShiguOrderCashback shiguOrderCashback = orderReturnMoneyService.getOrderCashback(oid);
        if (shiguOrderCashback == null)
            return JsonResponseUtil.error("error");
        ShiguOrderCashback soc = new ShiguOrderCashback();
        soc.setCId(shiguOrderCashback.getCId());
        soc.setEndTime(new Date());
        if (orderReturnMoneyService.updateCashback(soc))
           return JsonResponseUtil.success("success");
        return JsonResponseUtil.error("error");
    }

    @RequestMapping("orderCashbackInfo")
    @ResponseBody
    public JSONObject orderCashbackInfo(Long orderId){
        ShiguOrderCashback shiguOrderCashback = orderReturnMoneyService.getOrderCashback(orderId);
        com.alibaba.fastjson.JSONObject json = new com.alibaba.fastjson.JSONObject();
        if (shiguOrderCashback != null ){
            Boolean alreadyCashback=shiguOrderCashback.getEndTime()!=null?true:false;
            Long tradeAmount = shiguOrderCashback.getCashback()*100;
            Long userId = orderReturnMoneyService.getUserId(shiguOrderCashback.getOId());
            json.put("alreadyCashback",alreadyCashback);
            json.put("tradeAmount",tradeAmount);
            json.put("userId",userId);
            json.put("orderId",shiguOrderCashback.getOId());
            json.put("cashbackRate",10);
            json.put("result",true);
        }
        return JsonResponseUtil.success().element("data",json.toJSONString());
    }

}
