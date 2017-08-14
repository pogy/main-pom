package com.shigu.order.actions;

import com.shigu.main4.common.exceptions.JsonErrException;
import com.shigu.main4.common.exceptions.Main4Exception;
import com.shigu.main4.order.enums.PayType;
import com.shigu.main4.order.exceptions.PayApplyException;
import com.shigu.main4.order.vo.ItemOrderVO;
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
 * 收银台页面
 * Created by whx on 2017/7/17 0017.
 * @author bugzy
 */
@Controller
@RequestMapping("order/")
public class PayModeAction {

    @Autowired
    private PayModeService payModeService;

    /**
     * 选择支付方式，默认支付宝
     * @param orderId
     * @param session
     * @param model
     * @return
     * @throws PayApplyException
     */
    @RequestMapping("payMode")
    public String payMode(Long orderId, HttpSession session, Model model) throws PayApplyException {
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
     * @return
     * @throws JsonErrException
     * @throws PayApplyException
     */
    @RequestMapping("payInfoJson")
    @ResponseBody
    public JSONObject payInfoJson(Long orderId) throws JsonErrException, PayApplyException {
        return JsonResponseUtil.success()
                // 使用百度云盘二维码生成api
                .element("qrcodeImg","http://pan.baidu.com/share/qrcode?w=300&h=300&url=" + payModeService.payApply(orderId, PayType.WX).getPayLink());
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
    @RequestMapping("xzpayJson")
    @ResponseBody
    public JSONObject xzpayJson(Long orderId, String pwd, HttpSession session) throws JsonErrException, PayApplyException {
        PersonalSession ps = (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        payModeService.checkPwd(pwd, ps.getUserId());

        payModeService.payxz(payModeService.payApply(orderId, PayType.XZ), ps.getUserId());
        return JsonResponseUtil.success();
    }

    @RequestMapping("alipay")
    public void alipay(Long id, HttpServletResponse response) throws PayApplyException, IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        writer.println(payModeService.payApply(id, PayType.ALI).getPayLink());
        writer.flush();
        writer.close();
    }

    /**
     * 支付轮询
     * @return
     */
    @RequestMapping("payPollingJson")
    @ResponseBody
    public JSONObject payPollingJson(Long orderId) {
        Long payId;
        if ((payId = payModeService.checkPayed(orderId)) != null) {
            return JsonResponseUtil.success().element("payId", payId);
        }
        return null;
    }

    @RequestMapping("paySuccess")
    public String paySuccess(Long orderId, Model model) throws Main4Exception {
        ItemOrderVO itemOrderVO = payModeService.itemOrder(orderId).orderInfo();
        model.addAttribute("orderId", orderId);
        model.addAttribute("amountPay", String.format("%.2f", itemOrderVO.getTotalFee() * .01));
        model.addAttribute("payType", payModeService.selPayType(orderId));
        return "trade/paySuccess";
    }
}
