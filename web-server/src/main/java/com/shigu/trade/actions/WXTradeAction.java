package com.shigu.trade.actions;

import com.shigu.main4.order.exceptions.PayerException;
import com.shigu.trade.bo.ScanPayBo;
import com.shigu.trade.services.WxPayService;
import com.tencent.common.Signature;
import com.tencent.common.XMLParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 接受微信订单推送
 * Created by bugzy on 2017/6/15 0015.
 */
@Controller
public class WXTradeAction {

    private static final Logger logger = LoggerFactory.getLogger(WXTradeAction.class);

    @Autowired
    private WxPayService wxPayService;

    @RequestMapping("api/wxnotify")
    public void incoming(HttpServletRequest request, HttpServletResponse response) throws IOException {
        BufferedReader reader = request.getReader();
        StringBuilder sb = new StringBuilder();
        String tmp;
        while ((tmp = reader.readLine()) != null)
            sb.append(tmp);
        reader.close();

        String xml = sb.toString();
        logger.debug(xml);

        response.setContentType("text/xml");
        PrintWriter out = response.getWriter();

        boolean checked = Signature.checkIsSignValidFromResponseString(xml);
        boolean error = true;
        if (checked) {
            try {
                wxPayService.payNotice(XMLParser.getObjFromXml(xml, ScanPayBo.class));
                error = false;
            } catch (PayerException e) {
                e.printStackTrace();
            }
            out.println("<xml>" +
                    "  <return_code><![CDATA[SUCCESS]]></return_code>" +
                    "  <return_msg><![CDATA[SUCCESS]]></return_msg>" +
                    "</xml>");
        }
        if (!checked || error){
            out.println("<xml>" +
                    "  <return_code><![CDATA[FAIL]]></return_code>" +
                    "  <return_msg><![CDATA[NONE]]></return_msg>" +
                    "</xml>");
        }
        out.flush();
        out.close();
    }
}
