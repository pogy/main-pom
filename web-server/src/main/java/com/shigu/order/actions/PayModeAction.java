package com.shigu.order.actions;

import com.shigu.main4.common.exceptions.Main4Exception;
import com.shigu.order.services.PayModeService;
import com.shigu.session.main4.PersonalSession;
import com.shigu.session.main4.names.SessionEnum;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * Created by whx on 2017/7/17 0017.
 */
@Controller
public class PayModeAction {

    @Autowired
    private PayModeService payModeService;

    @RequestMapping("/order/payMode")
    public String payMode(String orderId, HttpSession session, Model model) throws Main4Exception {
        PersonalSession ps = (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        Long userId = ps.getUserId();
        model.addAttribute(payModeService.selPayModePageVO(orderId, userId));
        return "/trade/payMode";
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
