package com.shigu.trade.actions;

import com.alipay.api.AlipayApiException;
import com.alipay.api.internal.util.AlipaySignature;
import com.shigu.main4.order.exceptions.PayerException;
import com.shigu.main4.order.model.able.PayerServiceAble;
import com.shigu.trade.bo.ScanPayBo;
import com.shigu.trade.services.AliPayService;
import com.shigu.trade.services.WxPayService;
import com.tencent.common.Signature;
import com.tencent.common.XMLParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * 接受支付宝回调
 * Created by zlm on 2017/7/18 0015.
 */
@Controller
public class AlipayAction {

    private static final Logger logger = LoggerFactory.getLogger(AlipayAction.class);

    @Autowired
    private AliPayService aliPayService;

    @RequestMapping("api/alinotify")
    public void notify( HttpServletRequest request, HttpServletResponse response) throws IOException {
        Map<String, String[]> paramsMap =  request.getParameterMap();
        Map<String, String> paramsMapAli = new HashMap<String, String>();
        for (Map.Entry<String, String[]> item : paramsMap.entrySet()) {
            paramsMapAli.put(item.getKey(), item.getValue()[0]);
        }
        logger.info(paramsMapAli.toString());
        try {
            boolean signVerified = AlipaySignature.rsaCheckV1(paramsMapAli, aliPayService.getPublicKey(), "utf-8", "RSA") ;//调用SDK验证签名
            String tradeStatus =  paramsMapAli.get("trade_status");
            if(signVerified){
                if ("TRADE_SUCCESS".equalsIgnoreCase(tradeStatus) || "TRADE_FINISHED".equalsIgnoreCase(tradeStatus)) {
                    aliPayService.payNotice(paramsMapAli);
                }
                response.getWriter().print("success");
            } else {
                response.getWriter().print("failure");
            }
        } catch (AlipayApiException e) {
            logger.error(e.getMessage());
            response.getWriter().print("failure");
        } catch (PayerException e) {
            logger.error(e.getMessage());
            response.getWriter().print("failure");
        }
    }

    @RequestMapping("api/alireturn")
    public void returnAct( HttpServletRequest request, HttpServletResponse response) throws IOException {
        Map<String, String[]> paramsMap =  request.getParameterMap();
        Map<String, String> paramsMapAli = new HashMap<String, String>();
        for (Map.Entry<String, String[]> item : paramsMap.entrySet()) {
            paramsMapAli.put(item.getKey(), item.getValue()[0]);
        }
        logger.info(paramsMapAli.toString());
        try {
            boolean signVerified = AlipaySignature.rsaCheckV1(paramsMapAli, aliPayService.getPublicKey(), "utf-8", "RSA") ;//调用SDK验证签名
            String tradeStatus =  paramsMapAli.get("trade_status");
            if(signVerified){
                if ("TRADE_SUCCESS".equalsIgnoreCase(tradeStatus) || "TRADE_FINISHED".equalsIgnoreCase(tradeStatus)) {
                    aliPayService.payNotice(paramsMapAli);
                    response.getWriter().print("订单支付成功");
                } else {
                    response.getWriter().print("订单支付状态未知");
                }

            } else {
                response.getWriter().print("验签失败");
            }
        } catch (AlipayApiException e) {
            logger.error(e.getMessage());
            response.getWriter().print("支付失败");
        } catch (PayerException e) {
            logger.error(e.getMessage());
            response.getWriter().print("支付失败");
        }
    }


}
