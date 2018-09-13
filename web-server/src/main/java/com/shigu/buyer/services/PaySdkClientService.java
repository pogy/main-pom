package com.shigu.buyer.services;


import com.openJar.requests.sgpay.AlipayMoneyTradeSearch4OldRequest;
import com.openJar.requests.sgpay.UserTempSecret4OldRequest;
import com.openJar.responses.sgpay.AlipayMoneyTradeSearch4OldResponse;
import com.openJar.responses.sgpay.UserTempSecret4OldResponse;
import com.opentae.data.mall.interfaces.MemberUserMapper;
import com.shigu.buyer.bo.TixianBO;
import com.shigu.buyer.vo.DisposeBeanVO;
import com.shigu.main4.common.exceptions.JsonErrException;
import com.shigu.main4.pay.bo.XzbPayTrade;
import com.shigu.main4.pay.requests.XzbAlipayToCashedRequest;
import com.shigu.main4.pay.requests.XzbPayRequest;
import com.shigu.main4.pay.requests.XzbUserDisposeLimitRequest;
import com.shigu.main4.pay.responses.XzbAlipayToCashEdResponse;
import com.shigu.main4.pay.responses.XzbDisposeLimitResponse;
import com.shigu.main4.pay.responses.XzbPayResponse;
import com.shigu.main4.pay.services.XzbService;
import com.shigu.main4.tools.RedisIO;
import com.shigu.tools.JsonResponseUtil;
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
    
    @Autowired
    private MemberUserMapper memberUserMapper;
    
    @Autowired
    private RedisIO redisIO;
    
    @Autowired
    private DisposeBeanVO disposeBeanVO;

    @Autowired
    private XzbService xzbService;

    private final String freeCashInfoPrefix = "user_cash_apply_unprocessed_prifix_";
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
        XzbAlipayToCashedRequest req=new XzbAlipayToCashedRequest();
        req.setXzUserId(userId);
        req.setAlipayUserId(bo.getAlipay());
        req.setCashAmount((long) (bo.getPaynum()*100));
        req.setAlipayRealName(bo.getPayname());
        XzbAlipayToCashEdResponse res = xzbService.alipayToCashEd(req);
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

    public Long xzpay(Long userId, Long money, String outerId) throws JsonErrException {
        XzbPayRequest request = new XzbPayRequest();
        request.setXzUserId(userId);
        XzbPayTrade trade = new XzbPayTrade();
        trade.setTotalFee(money);
        trade.setOuterId(outerId);
        request.setTrade(trade);
        XzbPayResponse response = xzbService.xzbPay(request);
        if (!response.isSuccess()) {
            throw new JsonErrException(response.getBody());
        }
        return response.getPayId();
    }
    
    /**
     * 获取用户当月免费提现次数信息
     * @param userId
     * @return
     */
    public JSONObject selCurrentFreeCashInfo(Long userId) {
        XzbUserDisposeLimitRequest request = new XzbUserDisposeLimitRequest();
        request.setXzUserId(userId);
        XzbDisposeLimitResponse resp = xzbService.userDisposeLimit(request);
        if (resp.isSuccess()) {
            return JsonResponseUtil.success().element("freeWithdrawNum", resp.getFreeWithdrawNum()).element("withdrawUpperLimit", resp.getWithdrawUpperLimit());
        }
        return JsonResponseUtil.error(resp.getException().getErrMsg());
        //Long xzbId = memberUserMapper.userXzbAccount(userId);
        //Map withdrawMap = redisIO.get(String.format("%s%d_%d", freeCashInfoPrefix, xzbId, new Date().getMonth()), Map.class);
        //int cashTimes = 0;
        //if (withdrawMap != null) {
        //    cashTimes = withdrawMap.size();
        //}
        //int freeWithdrawNum = disposeBeanVO.getMaxFreeTimes() - cashTimes;
        //return JsonResponseUtil.success()
        //               .element("freeWithdrawNum", freeWithdrawNum < 0 ? 0 : freeWithdrawNum)
        //               .element("withdrawUpperLimit", String.format("%.2f", 0.01 * disposeBeanVO.getMaxCashMoney()));
    }
}
