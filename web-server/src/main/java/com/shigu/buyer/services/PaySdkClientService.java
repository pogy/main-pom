package com.shigu.buyer.services;

import com.openJar.requests.sgpay.AlipayMoneyTradeSearch4OldRequest;
import com.openJar.requests.sgpay.AlipayToCashEd4OldRequest;
import com.openJar.requests.sgpay.UserTempSecret4OldRequest;
import com.openJar.responses.sgpay.AlipayMoneyTradeSearch4OldResponse;
import com.openJar.responses.sgpay.AlipayToCashEd4OldResponse;
import com.openJar.responses.sgpay.UserTempSecret4OldResponse;
import com.shigu.buyer.bo.TixianBO;
import com.shigu.main4.common.exceptions.JsonErrException;
import com.shigu.tools.XzSdkClient;
import net.sf.json.JSONObject;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;

/**
 * 支付sdk调用系统服务
 * Created by zhaohongbo on 17/3/1.
 */
@Service
public class PaySdkClientService {
    private static final Logger logger = Logger.getLogger(PaySdkClientService.class);
    @Autowired
    XzSdkClient xzSdkClient;

    /**
     * 支付系统临时授权码
     * @param userId
     * @return
     */
    public String tempcode(Long userId){
            String tempCode;
        UserTempSecret4OldRequest req=new UserTempSecret4OldRequest();
        req.setXzUserId(userId);
        try {
            UserTempSecret4OldResponse res= (UserTempSecret4OldResponse) xzSdkClient.getPcOpenClient().execute(req);
            tempCode=res.getCode();
        } catch (Exception e) {
            logger.error("获取tempCode失败 "+userId,e);
            tempCode="pay_api error";
        }
        return tempCode;
    }

    /**
     *
     * @param bo
     * @param userId
     * @return
     */
    public JSONObject tixian(TixianBO bo, Long userId){
        AlipayToCashEd4OldRequest req=new AlipayToCashEd4OldRequest();
        req.setXzUserId(userId);
        req.setAlipayUserId(bo.getAlipay());
        req.setCashAmount((long) (bo.getPaynum()*100));
        req.setAlipayRealName(bo.getPayname());
        AlipayToCashEd4OldResponse res=(AlipayToCashEd4OldResponse)xzSdkClient.getPcOpenClient().execute(req);
        JSONObject obj;
        if(res.isSuccess()){
            obj=JSONObject.fromObject("{'result':'success'}");
        }else{
//            obj=JSONObject.fromObject("{'OK':'"+res.getBody()+"'}");
            obj=JSONObject.fromObject("{'result':'error', 'msg':'提现失败，请稍后再试'}");
        }
        return obj;
    }

    /**
     * 充值
     * @param userId 用户ID
     * @param alipayTradeNo 支付宝交易号
     * @param alipayUser 支付宝账号
     * @throws JsonErrException
     */
    public String rechange(Long userId,String alipayTradeNo,String alipayUser) throws JsonErrException {
        AlipayMoneyTradeSearch4OldRequest request=new AlipayMoneyTradeSearch4OldRequest();
        request.setAlipayNo(alipayTradeNo);
        request.setAlipayNick(alipayUser);
        request.setXzUserId(userId);
        AlipayMoneyTradeSearch4OldResponse response= (AlipayMoneyTradeSearch4OldResponse) xzSdkClient.getPcOpenClient()
                .execute(request);
        if(!response.isSuccess()){
            throw new JsonErrException(response.getException().getErrMsg());
        }
        Long payAmount=response.getPayAmount();
        Double d = payAmount / 100d;
        DecimalFormat df = new DecimalFormat("0.00");
        return df.format(d);
    }
}
