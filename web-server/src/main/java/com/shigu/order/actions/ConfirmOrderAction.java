package com.shigu.order.actions;

import com.shigu.component.common.globality.constant.SystemConStant;
import com.shigu.component.common.globality.response.ResponseBase;
import com.shigu.main4.common.exceptions.JsonErrException;
import com.shigu.order.bo.ConfirmBO;
import com.shigu.order.services.ConfirmOrderService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * Created by zhaohongbo on 17/6/23.
 */
@Controller
@RequestMapping
public class ConfirmOrderAction {

    @Autowired
    ConfirmOrderService confirmOrderService;

    /**
     * 订单确认提交
     * @param bo
     */
    @RequestMapping("/order/confirmOrders")
    public String confirmOrders(ConfirmBO bo) throws JsonErrException {
        ResponseBase rsp = new ResponseBase();
        rsp.setResult(SystemConStant.RESPONSE_STATUS_SUCCESS);
        Long oid = confirmOrderService.submit(bo);
        String payUrl = "/order/payMode.htm?oid="+oid;
        return "redirect:" + payUrl;
    }
}
