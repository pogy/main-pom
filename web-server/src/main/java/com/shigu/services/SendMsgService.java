package com.shigu.services;

import com.alibaba.dubbo.common.logger.Logger;
import com.alibaba.dubbo.common.logger.LoggerFactory;
import com.shigu.sms.beans.SmsSendResult;
import com.shigu.sms.utils.SmsJsoup;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


/**
 * 发短信服务
 * Created by zhaohongbo on 17/2/28.
 */
@Service
public class SendMsgService {
    private static final Logger logger = LoggerFactory.getLogger(SendMsgService.class);

    private static String account_quick = "sdk_sgwl";
    private static String pwd_quick = "20150630";
    private static String account_ordinary = "3377";
    private static String pwd_ordinary = "D47C126518CE8632397A155F11BDF6C2";

    /**
     * 发送注册短信
     * @param phone 手机号
     * @param code 验证码
     */
    public void sendVerificationCode(String phone, String code){
        String content = "您正在进行手机验证，验证码" + code + "，请在10分钟内按页面提示提交验证码，切勿将验证码泄露于他人。";
        sendSms_quick(phone,content);
    }

    /**
     * 直接发短信
     * @param mobile
     * @param content
     * @return
     */
    private String sendSms_quick(String mobile, String content) {
        String result = "";

        SmsJsoup u=new SmsJsoup();
        Date sendTime=new Date();//定时发送时间
        List<SmsSendResult> reList = u.sendHySms(mobile, content, sendTime);

        for (SmsSendResult item : reList) {
            if (!StringUtils.isEmpty(item.getFailPhones())) {
                result = result + item.getFailPhones() + ",";
            }
        }
        return result;
    }
}
