package com.shigu.order.actions;

import com.shigu.main4.common.exceptions.JsonErrException;
import com.shigu.main4.order.exceptions.PayApplyException;
import com.shigu.order.services.PayModeService;
import com.shigu.order.vo.PayModePageVO;
import com.shigu.session.main4.PersonalSession;
import com.shigu.session.main4.names.SessionEnum;
import com.shigu.tools.JsonResponseUtil;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

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
        PayModePageVO payModePageVO = payModeService.selPayModePageVO(orderId, userId);
        model.addAttribute("orderId", orderId);
        model.addAttribute("amountPay", payModePageVO.getAmountPay());
        model.addAttribute("currentAmount", payModePageVO.getCurrentAmount());
        model.addAttribute("notSetPassword", payModePageVO.getNotSetPassword());
        model.addAttribute("tempCode", payModePageVO.getTempCode());
        model.addAttribute("alipayUrl", payModePageVO.getAlipayUrl());
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
        String wxpay = payModeService.wxpay(orderId, ps.getUserId());
        return JsonResponseUtil.success().element("qrcodeImg","http://pan.baidu.com/share/qrcode?w=300&h=300&url=" + wxpay);
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

    @RequestMapping("/order/alipay")
    public void alipay(Long id, HttpServletResponse response) throws PayApplyException, IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        writer.println(payModeService.alipay(id));
        writer.flush();
        writer.close();
    }
}
