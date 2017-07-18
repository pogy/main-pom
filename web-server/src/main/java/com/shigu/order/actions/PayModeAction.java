package com.shigu.order.actions;

import com.shigu.main4.common.exceptions.JsonErrException;
import com.shigu.main4.common.exceptions.Main4Exception;
import com.shigu.main4.order.exceptions.PayApplyException;
import com.shigu.order.services.PayModeService;
import com.shigu.session.main4.PersonalSession;
import com.shigu.session.main4.names.SessionEnum;
import com.shigu.tools.JsonResponseUtil;
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

    /**
     * 选择支付方式，默认支付宝
     * @param orderId
     * @param session
     * @param model
     * @return
     * @throws JsonErrException
     * @throws PayApplyException
     */
    @RequestMapping("/order/payMode")
    public String payMode(String orderId, HttpSession session, Model model) throws JsonErrException, PayApplyException {
        PersonalSession ps = (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        Long userId = ps.getUserId();
        model.addAttribute(payModeService.selPayModePageVO(orderId, userId));
        return "/trade/payMode";
    }

    /**
     * 微信支付
     * @param orderId
     * @param session
     * @return
     * @throws JsonErrException
     * @throws PayApplyException
     */
    @RequestMapping("/order/payInfoJson")
    @ResponseBody
    public JSONObject payInfoJson(String orderId, HttpSession session) throws JsonErrException, PayApplyException {
        PersonalSession ps = (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        Long userId = ps.getUserId();
        return JsonResponseUtil.success().element("qrcodeImg",payModeService.wxpay(orderId, userId));
    }

    /**
     * 星座宝支付
     * @param orderId
     * @param pwd
     * @param session
     * @return
     * @throws JsonErrException
     * @throws PayApplyException
     */
    @RequestMapping("/order/xzpayJson")
    @ResponseBody
    public JSONObject xzpayJson(String orderId, String pwd, HttpSession session) throws JsonErrException, PayApplyException {
        PersonalSession ps = (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        payModeService.xzpay(orderId,pwd,ps.getUserId());
        return JsonResponseUtil.success();
    }

    //TODO:支付轮询
    /**
     * 支付轮询
     * @return
     */
    @RequestMapping("/order/payPollingJson")
    @ResponseBody
    public JSONObject payPollingJson() {
        return null;
    }
}
