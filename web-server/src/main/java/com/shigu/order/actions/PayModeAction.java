package com.shigu.order.actions;

import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by whx on 2017/7/17 0017.
 */
@Controller
public class PayModeAction {

    @RequestMapping("/order/payMode")
    public String payMode() {
        return null;
    }

    @RequestMapping("/order/payInfoJson")
    @ResponseBody
    public JSONObject payInfoJson() {
        return null;
    }

    @RequestMapping("/order/xzpayJson")
    @ResponseBody
    public JSONObject xzpayJson() {
        return null;
    }

    @RequestMapping("/order/payPollingJson")
    @ResponseBody
    public JSONObject payPollingJson() {
        return null;
    }
}
